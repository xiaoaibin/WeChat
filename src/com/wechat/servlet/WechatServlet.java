package com.wechat.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import com.wechat.entity.TextMessage;
import com.wechat.util.CheckUtil;
import com.wechat.util.MessageUtil;

public class WechatServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String signature = req.getParameter("signature");// 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
		String timestamp = req.getParameter("timestamp");// 时间戳
		String nonce = req.getParameter("nonce");// 随机数
		String echostr = req.getParameter("echostr");// 随机字符串
		
		PrintWriter out = resp.getWriter();
		if(CheckUtil.checkSignature(signature, timestamp, nonce)){
			out.print(echostr);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		try {
			Map<String,String> map = MessageUtil.xmlToMap(req);
			String toUserName = map.get("ToUserName");
			String fromUserName = map.get("FromUserName");
			String msgType = map.get("MsgType");
			String content = map.get("Content");
			
			String message = null;// 返回给用户的信息
			
			if(MessageUtil.MESSAGE_TEXT.equals(msgType)){// 文本消息
				if("1".equals(content)){
					message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.firstMenu());
				}else if("2".equals(content)){
					message = MessageUtil.initNewsMessage(toUserName, fromUserName);// 图文消息
					//message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.secondMenu());// 普通文本消息
				}else if("3".equals(content)){
					message = MessageUtil.initMusicMessage(toUserName, fromUserName);// 音乐消息
				}else if("？".equals(content) || "?".equals(content)){
					message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.menuText());
				}
			}else if(MessageUtil.MESSAGE_IMAGE.equals(msgType)){
				message = MessageUtil.initImageMessage(toUserName, fromUserName);// 图片消息
			}else if(MessageUtil.MESSAGE_EVENT.equals(msgType)){// event事件
				String eventType = map.get("Event");
				if(MessageUtil.MESSAGE_SUBSCRIBE.equals(eventType)){// 关注事件
					message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.menuText());
				}else if(MessageUtil.MESSAGE_CLICK.equals(eventType)){// Click事件 点击菜单拉取消息时的事件推送
					message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.menuText());
				}else if(MessageUtil.MESSAGE_VIEW.equals(eventType)){// VIEW事件 点击菜单跳转链接时的事件推送
					String url = map.get("EventKey");
					message = MessageUtil.initText(toUserName, fromUserName, url);
				}else if(MessageUtil.MESSAGE_SCANCODE.equals(eventType)){// scancode_push 扫码推事件的事件推送
					String key = map.get("EventKey");
					message = MessageUtil.initText(toUserName, fromUserName, key);
				}else if(MessageUtil.MESSAGE_LOCATION_SELECT.equals(eventType)){// location_select 弹出地理位置选择器的事件推送  
					String Label = map.get("EventKey");
					message = MessageUtil.initText(toUserName, fromUserName, Label);
				}
			}else if(MessageUtil.MESSAGE_LOCATION.equals(msgType)){// 地理信息
				String Label = map.get("Label");
				message = MessageUtil.initText(toUserName, fromUserName, Label);
			}
			out.print(message);
			System.out.println(message);
		} catch (DocumentException e) {
			e.printStackTrace();
		}finally {
			out.close();
		}
	}
	
	
}
