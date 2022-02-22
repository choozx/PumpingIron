package com.fp.pi.info;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class infoController {
	
	@RequestMapping(value = "/info.go", method = RequestMethod.GET)
	public String infoGo(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/info.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/chest.go", method = RequestMethod.GET)
	public String chestGo(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/chest.jsp");
		return "index";
	}
	@RequestMapping(value = "/chest1.go", method = RequestMethod.GET)
	public String chest1Go(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/chest1.jsp");
		return "index";
	}
	@RequestMapping(value = "/chest2.go", method = RequestMethod.GET)
	public String chest2Go(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/chest2.jsp");
		return "index";
	}
	@RequestMapping(value = "/chest3.go", method = RequestMethod.GET)
	public String chest3Go(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/chest3.jsp");
		return "index";
	}
	@RequestMapping(value = "/chest4.go", method = RequestMethod.GET)
	public String chest4Go(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/chest4.jsp");
		return "index";
	}
	@RequestMapping(value = "/chest5.go", method = RequestMethod.GET)
	public String chest5Go(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/chest5.jsp");
		return "index";
	}
	@RequestMapping(value = "/chest6.go", method = RequestMethod.GET)
	public String chest6Go(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/chest6.jsp");
		return "index";
	}
	
	
	
	
	
	
	@RequestMapping(value = "/back.go", method = RequestMethod.GET)
	public String backGo(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/back.jsp");
		return "index";
	}
	@RequestMapping(value = "/back1.go", method = RequestMethod.GET)
	public String back1Go(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/back1.jsp");
		return "index";
	}
	@RequestMapping(value = "/back2.go", method = RequestMethod.GET)
	public String back2Go(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/back2.jsp");
		return "index";
	}
	@RequestMapping(value = "/back3.go", method = RequestMethod.GET)
	public String back3Go(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/back3.jsp");
		return "index";
	}
	@RequestMapping(value = "/back4.go", method = RequestMethod.GET)
	public String back4Go(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/back4.jsp");
		return "index";
	}
	@RequestMapping(value = "/back5.go", method = RequestMethod.GET)
	public String back5Go(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/back5.jsp");
		return "index";
	}
	@RequestMapping(value = "/back6.go", method = RequestMethod.GET)
	public String back6Go(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/back6.jsp");
		return "index";
	}
	
	
	
	
	@RequestMapping(value = "/shoulder.go", method = RequestMethod.GET)
	public String shoulderGo(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/shoulder.jsp");
		return "index";
	}
	@RequestMapping(value = "/shoulder1.go", method = RequestMethod.GET)
	public String shoulder1Go(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/shoulder1.jsp");
		return "index";
	}
	@RequestMapping(value = "/shoulder2.go", method = RequestMethod.GET)
	public String shoulder2Go(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/shoulder2.jsp");
		return "index";
	}
	@RequestMapping(value = "/shoulder3.go", method = RequestMethod.GET)
	public String shoulder3Go(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/shoulder3.jsp");
		return "index";
	}
	@RequestMapping(value = "/shoulder4.go", method = RequestMethod.GET)
	public String shoulder4Go(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/shoulder4.jsp");
		return "index";
	}
	@RequestMapping(value = "/shoulder5.go", method = RequestMethod.GET)
	public String shoulder5Go(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/shoulder5.jsp");
		return "index";
	}
	@RequestMapping(value = "/shoulder6.go", method = RequestMethod.GET)
	public String shoulder6Go(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/shoulder6.jsp");
		return "index";
	}
	
	
	
	
	@RequestMapping(value = "/arm.go", method = RequestMethod.GET)
	public String armGo(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/arm.jsp");
		return "index";
	}
	@RequestMapping(value = "/arm1.go", method = RequestMethod.GET)
	public String arm1Go(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/arm1.jsp");
		return "index";
	}
	@RequestMapping(value = "/arm2.go", method = RequestMethod.GET)
	public String arm2Go(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/arm2.jsp");
		return "index";
	}
	@RequestMapping(value = "/arm3.go", method = RequestMethod.GET)
	public String arm3Go(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/arm3.jsp");
		return "index";
	}
	@RequestMapping(value = "/arm4.go", method = RequestMethod.GET)
	public String arm4Go(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/arm4.jsp");
		return "index";
	}
	@RequestMapping(value = "/arm5.go", method = RequestMethod.GET)
	public String arm5Go(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/arm5.jsp");
		return "index";
	}
	@RequestMapping(value = "/arm6.go", method = RequestMethod.GET)
	public String arm6Go(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/arm6.jsp");
		return "index";
	}
	
	
	
	
	@RequestMapping(value = "/leg.go", method = RequestMethod.GET)
	public String legGo(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/leg.jsp");
		return "index";
	}
	@RequestMapping(value = "/leg1.go", method = RequestMethod.GET)
	public String leg1Go(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/leg1.jsp");
		return "index";
	}
	@RequestMapping(value = "/leg2.go", method = RequestMethod.GET)
	public String leg2Go(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/leg2.jsp");
		return "index";
	}
	@RequestMapping(value = "/leg3.go", method = RequestMethod.GET)
	public String leg3Go(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/leg3.jsp");
		return "index";
	}
	@RequestMapping(value = "/leg4.go", method = RequestMethod.GET)
	public String leg4Go(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/leg4.jsp");
		return "index";
	}
	@RequestMapping(value = "/leg5.go", method = RequestMethod.GET)
	public String leg5Go(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/leg5.jsp");
		return "index";
	}
	@RequestMapping(value = "/leg6.go", method = RequestMethod.GET)
	public String leg6Go(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/leg6.jsp");
		return "index";
	}
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/abs.go", method = RequestMethod.GET)
	public String absGo(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/abs.jsp");
		return "index";
	}
	@RequestMapping(value = "/abs1.go", method = RequestMethod.GET)
	public String abs1Go(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/abs1.jsp");
		return "index";
	}
	@RequestMapping(value = "/abs2.go", method = RequestMethod.GET)
	public String abs2Go(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/abs2.jsp");
		return "index";
	}
	@RequestMapping(value = "/abs3.go", method = RequestMethod.GET)
	public String abs3Go(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/abs3.jsp");
		return "index";
	}
	@RequestMapping(value = "/abs4.go", method = RequestMethod.GET)
	public String abs4Go(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/abs4.jsp");
		return "index";
	}
	@RequestMapping(value = "/abs5.go", method = RequestMethod.GET)
	public String abs5Go(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/abs5.jsp");
		return "index";
	}
	@RequestMapping(value = "/abs6.go", method = RequestMethod.GET)
	public String abs6Go(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/abs6.jsp");
		return "index";
	}

}
