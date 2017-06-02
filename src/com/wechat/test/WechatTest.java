package com.wechat.test;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import com.wechat.entity.AccessToken;
import com.wechat.util.MessageUtil;
import com.wechat.util.WechatUtil;

import net.sf.json.JSONObject;

/**
 * WechatUtil测试类
 * @author aibinxiao
 * @date 2017年6月2日 上午9:20:34
 */
public class WechatTest {
	
	// 1.获取access_token测试
	/*public static void main(String[] args) {
		// 注意测试之前，需要将本机的ip地址加入到微信公众号的ip白名单中
		AccessToken token = WechatUtil.getAccessToken();
		System.out.println("票据："+token.getToken());
		System.out.println("有效时间："+token.getExpiresIn());
	}*/
	
	// 2.上传图片测试
	/*public static void main(String[] args) {
		// 注意测试之前，需要将本机的ip地址加入到微信公众号的ip白名单中
		try {
			AccessToken token = WechatUtil.getAccessToken();
			System.out.println("票据："+token.getToken());
			System.out.println("有效时间："+token.getExpiresIn());
			
			String path = "D:/kevin.jpg";
			String mediaId = WechatUtil.upload(path, token.getToken(), MessageUtil.MESSAGE_IMAGE);
			System.out.println("mediaId:" + mediaId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	//得到mediaId
	/*票据：haY0sfRcvkHPNBYXcKpnZs0tHCMVlWxWBsWhA3oVrD93if5qNpMsnA5vVv797AuIku0G00Ce5v3Fi6BCVRejYdz0WBjIHB4P4fRfGGv2pUXG57WauVWpoCeUuVDeJJu-QXMjAAADKZ
	有效时间：7200
	{"type":"image","media_id":"uhKLBoJ73aPPpNuxfaltpWJbbNMLe6DYaYTQ6zS2N0oOHR1T3nFB1A3_xPvZtlS4","created_at":1496369721}
	uhKLBoJ73aPPpNuxfaltpWJbbNMLe6DYaYTQ6zS2N0oOHR1T3nFB1A3_xPvZtlS4*/
	
	// 3.测试缩略图上传，大小不能超过64Kb
	/*public static void main(String[] args) {
		// 注意测试之前，需要将本机的ip地址加入到微信公众号的ip白名单中
		try {
			AccessToken token = WechatUtil.getAccessToken();
			System.out.println("票据："+token.getToken());
			System.out.println("有效时间："+token.getExpiresIn());
			
			String path = "D:/kevin.jpg";
			String thumbMediaId = WechatUtil.upload(path, token.getToken(), MessageUtil.MESSAGE_THUMB);
			System.out.println("thumbMediaId:" + thumbMediaId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	/*票据：coBk5O5e12mUuBf68m68o_yY5qsUSNmL6CmPPG1xbtoTHac6etosQ0xup5drB70gFR1m3oYS-CJ7O2tQGI7WSi_K91jjtfAuXbze67Skzg97jmdNjaF6dImQgw0TeWRxIJVgAEALMY
	有效时间：7200
	{"type":"thumb","thumb_media_id":"Scsxi6ujXa3my8ItPVIgyBkn-Sm3G6CRimk9sDfeVZJyAFnfuDHmQtBb-cZ7t3ni","created_at":1496372712}
	thumbMediaId:Scsxi6ujXa3my8ItPVIgyBkn-Sm3G6CRimk9sDfeVZJyAFnfuDHmQtBb-cZ7t3ni*/
	
	public static void main(String[] args) {
		try {
			AccessToken token = WechatUtil.getAccessToken();
			System.out.println("票据："+token.getToken());
			System.out.println("有效时间："+token.getExpiresIn());
			
			String menu = JSONObject.fromObject(WechatUtil.initMenu()).toString();
			int result = WechatUtil.createMenu(token.getToken(), menu);
			if(result==0){
				System.out.println("创建菜单成功");
			}else{
				System.out.println("错误码："+ result);
				// 40017 invalid button type hint 无效的菜单类型，即创建菜单时，有菜单的类型有误
				// 40024 invalid sub button type hint 无效的二级菜单类型，无效可能错误，也可能为空了
			}
		} catch (Exception e) {
			e.printStackTrace();
	    }
	}
}
