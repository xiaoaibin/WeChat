package com.wechat.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.wechat.entity.Image;
import com.wechat.entity.ImageMessage;
import com.wechat.entity.Music;
import com.wechat.entity.MusicMessage;
import com.wechat.entity.News;
import com.wechat.entity.NewsMessage;
import com.wechat.entity.TextMessage;

/**
 * 消息工具类
 * 主要用于消息的格式转换
 * @author aibinxiao
 * @date 2017年6月1日 下午12:10:19
 */
public class MessageUtil {
	
	public static final String MESSAGE_TEXT = "text"; // 文本消息
	public static final String MESSAGE_IMAGE = "image"; // 图片消息
	public static final String MESSAGE_THUMB = "thumb"; // 缩略图
	public static final String MESSAGE_NEWS = "news"; // 图文消息
	public static final String MESSAGE_VOICE = "voice"; // 语音消息
	public static final String MESSAGE_MUSIC = "music"; // 音乐消息
	public static final String MESSAGE_VIDEO = "video"; // 视频信息
	public static final String MESSAGE_SHORTVIDEO = "shortvideo"; // 小视频信息
	public static final String MESSAGE_LINK = "link"; // 链接消息
	public static final String MESSAGE_LOCATION = "location"; //地理位置信息 
	public static final String MESSAGE_EVENT = "event"; // 事件推送
	public static final String MESSAGE_SUBSCRIBE = "subscribe"; // 关注事件
	public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe"; // 取消关注事件
	public static final String MESSAGE_CLICK = "CLICK"; // 菜单点击事件CLICK
	public static final String MESSAGE_VIEW = "VIEW"; // 菜单点击事件VIEW
	public static final String MESSAGE_SCANCODE = "scancode_push"; // 扫码事件推送
	public static final String MESSAGE_LOCATION_SELECT = "location_select"; // 弹出地理位置选择器的事件推送
	
	// 注意各文件类型大小
	// 图片（image）: 2M，支持PNG\JPEG\JPG\GIF格式
    // 语音（voice）：2M，播放长度不超过60s，支持AMR\MP3格式
    // 视频（video）：10MB，支持MP4格式
    // 缩略图（thumb）：64KB，支持JPG格式

	/**
	 * xml格式转换为map集合
	 * @param request
	 * @return
	 * @throws IOException 
	 * @throws DocumentException 
	 */
	public static Map<String,String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException{
		Map<String,String> map = new HashMap<String,String>();
		SAXReader reader = new SAXReader();
		
		// 1.获取输入流
		InputStream ins = request.getInputStream();
		// 2.解析xml文档
		Document doc = reader.read(ins);
		
		// 3.获取xml文档的根节点<xml></xml>
		Element root = doc.getRootElement();
		
		// 4.获取根节点中所有的子节点
		List<Element> list = root.elements();
		
		for(Element e:list){
			// 5.循环遍历子节点，并将子节点的名称和节点内容存入map中
			map.put(e.getName(), e.getText());
		}
		
		ins.close();
		return map;
	}
	
	/**
	 * 将文本消息对象转换为xml
	 * @param textMessage
	 * @return
	 */
	public static String textMessageToXml(TextMessage textMessage){
		XStream xstream = new XStream();// 需要注意的是这里使用的是xstream-1.3.1.jar,当我使用1.4.10时会抛出异常
		xstream.alias("xml", textMessage.getClass());//将xml的根节点替换成xml
		return xstream.toXML(textMessage);
	}
	
	/**
	 * 拼接文本消息
	 * @param toUserName
	 * @param fromUserName
	 * @param content
	 * @return
	 */
	public static String initText(String toUserName,String fromUserName,String content){
		TextMessage text = new TextMessage();
		text.setToUserName(fromUserName);// 接收方：返回给发送方，即用户
		text.setFromUserName(toUserName);// 发送方：即微信公众号服务器端，即原先接受用户信息方
		text.setCreateTime(new Date().getTime());// 创建时间，则为当前时间
		text.setContent(content);// 返回内容
		text.setMsgType(MessageUtil.MESSAGE_TEXT);// 返回信息类型，仍然为文本类型
		return textMessageToXml(text);// 将返回信息转为xml格式
	}
	
	/**
	 * 关注后的主菜单
	 * @return
	 */
	public static String menuText(){
		StringBuffer sb = new StringBuffer();
		sb.append("欢迎又帅气又有眼光的您的关注，请按照以下菜单进行操作：\n\n");
		sb.append("1、主要功能介绍\n");
		sb.append("2、联系帅气的飞鱼\n");
		sb.append("回复?获取帮助");
		return sb.toString();
	}
	
	/**
	 * 回复菜单1，返回内容
	 * @return
	 */
	public static String firstMenu(){
		StringBuffer sb = new StringBuffer();
		sb.append("分享程序员飞鱼的生活点滴、学习编程的心得见解以及工作项目的记录。\n");
		sb.append("这里有飞鱼好玩的故事，也有正在学习的编程技术个人笔记和方法总结，还有踏入工作后，每日工作的总结记录。\n");
		return sb.toString();
	}
	
	/**
	 * 回复菜单2，返回内容
	 * @return
	 */
	public static String secondMenu(){
		StringBuffer sb = new StringBuffer();
		sb.append("很高兴能帮助帅气的您：请添加以下联系方式\n");
		sb.append("1、Email:\naibinxiao@126.com\n");
		sb.append("2、QQ:\n1245354005\n");
		return sb.toString();
	}
	
	/**
	 * 将图文消息对象转换为xml
	 * @param newsMessage
	 * @return
	 */
	public static String newsMessageToXml(NewsMessage newsMessage){
		XStream xstream = new XStream();// 需要注意的是这里使用的是xstream-1.3.1.jar,当我使用1.4.10时会抛出异常
		xstream.alias("xml", newsMessage.getClass());//将xml的根节点替换成xml
		xstream.alias("item", new News().getClass());// 将xml中的item节点替换为单条图文
		return xstream.toXML(newsMessage);
	}
	
	/**
	 * 图文消息的拼接
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public static String initNewsMessage(String toUserName,String fromUserName){
		String message = null;
		List<News> newsList = new ArrayList<News>();
		NewsMessage newsMessage = new NewsMessage();
		
		News news = new News();
		news.setTitle("飞鱼说编程介绍");
		news.setDescription("分享程序员飞鱼的生活点滴、学习编程的心得见解以及工作项目的记录。这里有飞鱼好玩的故事，也有正在学习的编程技术个人笔记和方法总结，还有踏入工作后，每日工作的总结记录。");
		news.setPicUrl("http://feiyucoding.tunnel.2bdata.com/WeChat/image/kevin.jpg");
		news.setUrl("https://my.oschina.net/aibinxiao/blog/913600");
		
		newsList.add(news);
		newsMessage.setToUserName(fromUserName);
		newsMessage.setFromUserName(toUserName);
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(MessageUtil.MESSAGE_NEWS);
		newsMessage.setArticles(newsList);
		newsMessage.setArticleCount(newsList.size());
		
		message = newsMessageToXml(newsMessage);
		return message;
	}
	
	/**
	 * 将图片消息对象转换为xml
	 * @param imgaeMessage
	 * @return
	 */
	public static String imageMessageToXml(ImageMessage imageMessage){
		XStream xstream = new XStream();// 需要注意的是这里使用的是xstream-1.3.1.jar,当我使用1.4.10时会抛出异常
		xstream.alias("xml", imageMessage.getClass());//将xml的根节点替换成xml
		return xstream.toXML(imageMessage);
	}
	
	/**
	 * 图片消息的拼接
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public static String initImageMessage(String toUserName,String fromUserName){
		String message = null;
		Image image = new Image();
		image.setMediaId("uhKLBoJ73aPPpNuxfaltpWJbbNMLe6DYaYTQ6zS2N0oOHR1T3nFB1A3_xPvZtlS4");
		ImageMessage imageMessage = new ImageMessage();
		imageMessage.setFromUserName(toUserName);
		imageMessage.setToUserName(fromUserName);
		imageMessage.setMsgType(MESSAGE_IMAGE);
		imageMessage.setCreateTime(new Date().getTime());
		imageMessage.setImage(image);
		message = imageMessageToXml(imageMessage);
		return message;
	}
	
	/**
	 * 将音乐消息转为xml
	 * @param musicMessage
	 * @return
	 */
	private static String musicMessageToXml(MusicMessage musicMessage) {
		XStream xstream = new XStream();
		xstream.alias("xml", musicMessage.getClass());
		return xstream.toXML(musicMessage);
	}
	
	/**
	 * 音乐消息的拼接
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public static String initMusicMessage(String toUserName,String fromUserName){
		String message = null;
		Music music = new Music();
		music.setThumbMediaId("Scsxi6ujXa3my8ItPVIgyBkn-Sm3G6CRimk9sDfeVZJyAFnfuDHmQtBb-cZ7t3ni");
		music.setTitle("我可以-飞鱼");
		music.setDescription("我可以陪你去看星星");
		music.setMusicUrl("http://changba.com/s/BbG3gALZEH-qN-xOx7OhFg?code=RkvQSz26kloAwSHOfgu1v1-FFaJgrLx3GwFx1sFMxN6imZSSHP72cxzs_RXelrDM64s5P-NNcaJbzS16vpASayLiv8MSPfBcwQshSijIT0k8Ar9AwYgdeLBQ6hyCjYBZ&plan20170531=8&source=qq");
		music.setHQMusicUrl("http://changba.com/s/BbG3gALZEH-qN-xOx7OhFg?code=RkvQSz26kloAwSHOfgu1v1-FFaJgrLx3GwFx1sFMxN6imZSSHP72cxzs_RXelrDM64s5P-NNcaJbzS16vpASayLiv8MSPfBcwQshSijIT0k8Ar9AwYgdeLBQ6hyCjYBZ&plan20170531=8&source=qq");
		
		MusicMessage musicMessage = new MusicMessage();
		musicMessage.setMusic(music);
		musicMessage.setFromUserName(toUserName);
		musicMessage.setToUserName(fromUserName);
		musicMessage.setMsgType(MESSAGE_MUSIC);
		musicMessage.setCreateTime(new Date().getTime());
		
		message = musicMessageToXml(musicMessage);
		return message;
	}

}
