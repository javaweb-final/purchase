package com.javaweb.purchase.utils;

import com.javaweb.purchase.utils.yun.SmsSingleSender;
import com.javaweb.purchase.utils.yun.SmsSingleSenderResult;
import com.javaweb.purchase.utils.yun.SmsVoiceVerifyCodeSender;
import com.javaweb.purchase.utils.yun.SmsVoiceVerifyCodeSenderResult;

public class SmsSDKDemo {
    public static void main(String[] args) {
    	try {
    		//请根据实际 accesskey 和 secretkey 进行开发，以下只作为演示 sdk 使用
    		String accesskey = "5e046ce7efb9a32b40cec899";
    		String secretkey ="1ee388bb9d694867afa11fa4e3417951";
    		//手机号码
    		String phoneNumber = "18923729118";
    		 //初始化单发
	    	SmsSingleSender singleSender = new SmsSingleSender(accesskey, secretkey);
	    	SmsSingleSenderResult singleSenderResult;
	
	    	 //普通单发,注意前面必须为【】符号包含，置于头或者尾部。
	    singleSenderResult = singleSender.send(0, "86", phoneNumber, "【Kewail科技】尊敬的用户：您的验证码：520，工作人员不会索取，请勿泄漏。", "", "");
	    	System.out.println(singleSenderResult);
	    	
	    	
	    	//语音验证码发送
    		//SmsVoiceVerifyCodeSender smsVoiceVerifyCodeSender = new SmsVoiceVerifyCodeSender(accesskey,secretkey);
    		//SmsVoiceVerifyCodeSenderResult smsVoiceVerifyCodeSenderResult = smsVoiceVerifyCodeSender.send("86",phoneNumber, "444144",2,"");
    		//System.out.println(smsVoiceVerifyCodeSenderResult);

    	} catch (Exception e) {
			e.printStackTrace();
		}
    }
    public static  void testSms(String phoneNumber,String key){
		try {
			//请根据实际 accesskey 和 secretkey 进行开发，以下只作为演示 sdk 使用
			String accesskey = "5e046ce7efb9a32b40cec899";
			String secretkey ="1ee388bb9d694867afa11fa4e3417951";
			//手机号码

			//初始化单发
			SmsSingleSender singleSender = new SmsSingleSender(accesskey, secretkey);
			SmsSingleSenderResult singleSenderResult;

			//普通单发,注意前面必须为【】符号包含，置于头或者尾部。
			singleSenderResult = singleSender.send(0, "86", phoneNumber, "【Kewail科技】尊敬的用户：您的验证码："+key+"，工作人员不会索取，请勿泄漏。", "", "");
			System.out.println(singleSenderResult);


			//语音验证码发送
			//SmsVoiceVerifyCodeSender smsVoiceVerifyCodeSender = new SmsVoiceVerifyCodeSender(accesskey,secretkey);
			//SmsVoiceVerifyCodeSenderResult smsVoiceVerifyCodeSenderResult = smsVoiceVerifyCodeSender.send("86",phoneNumber, "444144",2,"");
			//System.out.println(smsVoiceVerifyCodeSenderResult);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
