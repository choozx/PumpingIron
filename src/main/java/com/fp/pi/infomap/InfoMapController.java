package com.fp.pi.infomap;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.CDATA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fp.pi.TokenMaker;
import com.fp.pi.member.MemberDAO;

@Controller
public class InfoMapController {
	
	@Autowired
	MemberDAO mDAO;
	
	@Autowired
	InfoMapDAO iDAO;
	
/////////////////////////////////////// 지도로 정보 검색  ////////////////////////////////////////////

	@RequestMapping(value = "/infoMap.go", method = RequestMethod.GET)
	public String infoMapGo(HttpServletRequest req) {
		
		mDAO.loginCheck(req);
		
		req.setAttribute("contentPage", "infoMap/infoMap.jsp");
		return "index";
	}
	
	
	
	
	
	/////////////////////////////////////// 가격 정보 모아 보기 //////////////////////////////////////////
	
	
	@RequestMapping(value = "/priceInfo.go", method = RequestMethod.GET)
	public String priceInfoGo(InfoMapBean i,HttpServletRequest req) {
		

		if (mDAO.loginCheck(req)) {
		}
		
		req.setAttribute("contentPage", "infoMap/priceInfo.jsp");
		return "index";
	}
	
	
	@RequestMapping(value = "/priceInfo.reg", method = RequestMethod.POST)
	public String priceInfoReg(InfoMapBean i, HttpServletRequest req) {
		
		if (mDAO.loginCheck(req)) {
			iDAO.insertInfo(i, req);
		}
		TokenMaker.make(req);
		
		req.setAttribute("contentPage", "infoMap/priceInfo.jsp");
		return "index";
	}
	
	
	
	@RequestMapping(value = "/priceInfo.search", method = RequestMethod.GET)
	public String searchPriceInfo(InfoMapBean i, HttpServletRequest req) {
		
		if (mDAO.loginCheck(req)) {
		}
		iDAO.searchPriceInfo(i, req);
		
		req.setAttribute("contentPage", "infoMap/priceInfo.jsp");
		return "index";
	}
	
	
	
	@RequestMapping(value = "/priceInfo.del", method = RequestMethod.GET)
	public  @ResponseBody int deletePriceInfo(InfoMapBean i, HttpServletRequest req) {
		
		if (mDAO.loginCheck(req)) {
			iDAO.deletePriceInfo(i, req);
			return 1;
			}
			return 0;
		
	}
	
	
	
	
	@RequestMapping(value = "/priceInfo.get.updateData", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody List<InfoMapBean> getPriceInfo(InfoMapBean i, HttpServletRequest req) {
		
		if (mDAO.loginCheck(req)) {
		}
		iDAO.get_a_PriceInfo(i, req);
		
		req.setAttribute("contentPage", "infoMap/priceInfo.jsp");
		return iDAO.get_a_PriceInfo(i, req);
	}
	
	
	
	@RequestMapping(value = "/priceInfo.update", method = RequestMethod.POST)
	public String priceInfoUpdate(InfoMapBean i, HttpServletRequest req) {
		
		if (mDAO.loginCheck(req)) {
			iDAO.updateInfo(i, req);
		}
		TokenMaker.make(req);
		
//		System.out.println(i.getPi_name());
		
		req.setAttribute("contentPage", "infoMap/priceInfo.jsp");
		return "index";
	}
	
	
	
	
	
}
