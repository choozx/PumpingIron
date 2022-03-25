package com.fp.pi;

import java.text.SimpleDateFormat;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class TokenMaker {
	
	public static void make(HttpServletRequest req) {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss:SS");
		String token = sdf.format(d);
		req.setAttribute("token", token);
		
		System.out.println(token + "-----------");
		
		
	}
	public static void make2(HttpServletRequest req) {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss:SS");
		String token = sdf.format(d);
		req.setAttribute("token2", token);
		
		System.out.println(token + "-----------2");
		
		
	}
	public static void make3(HttpServletRequest req) {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss:SS");
		String token = sdf.format(d);
		req.setAttribute("token3", token);
		
		System.out.println(token + "-----------3");
		
		
	}
	public static void make4(HttpServletRequest req) {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss:SS");
		String token = sdf.format(d);
		req.setAttribute("token4", token);
		
		System.out.println(token + "-----------4");
		
		
	}


}
