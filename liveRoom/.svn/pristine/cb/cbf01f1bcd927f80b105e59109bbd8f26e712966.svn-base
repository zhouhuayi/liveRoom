package com.liveRoom.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.httpclient.HttpException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liveRoom.util.SendMsg_webchinese;

@Controller
public class PhoneController {
	
	private static final String VALIDATE_PHONE_CODE = "VALIDATE_PHONE_CODE";
	private static final String VALIDATE_PHONE = "VALIDATE_PHONE";
	
	@RequestMapping("sendCode.do")
	@ResponseBody
	protected String sendCode(String phone, HttpServletRequest request) throws HttpException, IOException {
		StringBuilder code = new StringBuilder();
		String result = "failure";
		Random random = new Random();
		String phoneCode = "";
		// 6位验证码
		for (int i = 0; i < 6; i++) {
			code.append(String.valueOf(random.nextInt(10)));
		}
		Map<String, Object> pnMap = UserController.phoneMap;
		phoneCode = code.toString();
		long nowTime = new Date().getTime();
		
		if(pnMap.get(phone) != null && !pnMap.get(phone).equals("")) {
			long oldTime = Long.parseLong(pnMap.get("time").toString());
			long time = 5*60*1000 - (nowTime - oldTime);
			System.out.println("剩下：" + time/(60*1000) + "分钟" + time%(60*1000)/1000 + "秒");
			if(time <= 0) {
				UserController.phoneMap.put(phone, phoneCode);
				UserController.phoneMap.put("time", nowTime);
				String smsText = "验证码：" + phoneCode;
				System.out.println("手机号：" + phone + ", " + smsText);
				if(Integer.parseInt(SendMsg_webchinese.sendMessage(phone, smsText)) > 0) {
					result = "success";
				}
			} else {
				String smsText = "验证码：" + pnMap.get(phone);
				System.out.println("手机号：" + phone + ", " + smsText);
				if(Integer.parseInt(SendMsg_webchinese.sendMessage(phone, smsText)) > 0) {
					result = "success";
				}
			}
		} else {
			UserController.phoneMap.put(phone, phoneCode);
			UserController.phoneMap.put("time", nowTime);
			String smsText = "验证码：" + phoneCode;
			System.out.println("手机号：" + phone + ", " + smsText);
			if(Integer.parseInt(SendMsg_webchinese.sendMessage(phone, smsText)) > 0) {
				result = "success";
			}
		}
		return result;
	}
	
	@RequestMapping("validateCode.do")
	@ResponseBody
	protected static String validate(HttpServletRequest request){
		System.out.println(request.getSession().getAttribute(VALIDATE_PHONE_CODE));
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute(VALIDATE_PHONE_CODE);
		String phone = (String) session.getAttribute(VALIDATE_PHONE);
		String inputCode = request.getParameter("code");
		String inputPhone = request.getParameter("phone");
		if(phone.equals(inputPhone) && code.equalsIgnoreCase(inputCode)){
			return "success";
		}else{
			return "failure";
		}
	}
}
