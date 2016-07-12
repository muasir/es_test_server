package com.es.sms.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

@Controller
public class DefaultController {

    @Autowired
    protected MappingJacksonJsonView jsonView;

    protected static final String SUCCESS_FIELD = "status";
    protected static final String DATA_FIELD = "data";

    @RequestMapping(value = "/user/{deviceId}", method = RequestMethod.GET)
    public @ResponseBody ModelAndView getUser(
	    @PathVariable("deviceId") String provider,
	    HttpServletResponse httpResponse_p, WebRequest request_p,
	    HttpServletRequest request) {
	boolean success = false;
	ModelAndView mv = new ModelAndView();
	mv.setView(jsonView);
	try {
	    mv.addObject("username", "Jane Doe");
	    success = true;
	} catch (Exception e) {
	    success = false;
	}
	mv.addObject(SUCCESS_FIELD, success);
	return mv;
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public @ResponseBody ModelAndView getUserOrder(
	    HttpServletResponse httpResponse_p, WebRequest request_p,
	    HttpServletRequest request) {
	boolean success = false;
	ModelAndView mv = new ModelAndView();
	mv.setView(jsonView);
	try {
	    mv.addObject(
		    "message",
		    "We shipped your 3 month supply of L**itor 250mg medicine.  Your order can be tracked using FedEx 23423423424.");
	    success = true;
	} catch (Exception e) {
	    success = false;
	}
	mv.addObject(SUCCESS_FIELD, success);
	return mv;
    }

    @RequestMapping(value = "/coverage", method = RequestMethod.GET)
    public @ResponseBody ModelAndView getCoverage(
	    HttpServletResponse httpResponse_p, WebRequest request_p,
	    HttpServletRequest request) {
	boolean success = false;
	ModelAndView mv = new ModelAndView();
	mv.setView(jsonView);
	try {
	    mv.addObject("message",
		    "I will need drug name and strength to tell you if the medicine is covered.");
	    success = true;
	} catch (Exception e) {
	    success = false;
	}
	mv.addObject(SUCCESS_FIELD, success);
	return mv;
    }

    @RequestMapping(value = "/refill", method = RequestMethod.GET)
    public @ResponseBody ModelAndView getRefillUser(
	    HttpServletResponse httpResponse_p, WebRequest request_p,
	    HttpServletRequest request) {
	boolean success = false;
	ModelAndView mv = new ModelAndView();
	mv.setView(jsonView);
	try {
	    mv.addObject(
		    "message",
		    "We will refill your medicine (L**itor 250mg).  Tracking number will ship when we process the order.");
	    success = true;
	} catch (Exception e) {
	    success = false;
	}
	mv.addObject(SUCCESS_FIELD, success);
	return mv;
    }

    @RequestMapping(value = "/marketing", method = RequestMethod.GET)
    public @ResponseBody ModelAndView getMarketingMsg(
	    HttpServletResponse httpResponse_p, WebRequest request_p,
	    HttpServletRequest request) {
	boolean success = false;
	ModelAndView mv = new ModelAndView();
	mv.setView(jsonView);
	try {
	    mv.addObject(
		    "message",
		    "Did you know if you were to switch L**itor to home delivery, you could save $85.  Would you like me to set that up for you?");
	    success = true;
	} catch (Exception e) {
	    success = false;
	}
	mv.addObject(SUCCESS_FIELD, success);
	return mv;
    }

    @RequestMapping(value = "/marketing/validation", method = RequestMethod.GET)
    public @ResponseBody ModelAndView getMarketingValidationMsg(
	    @RequestParam(value = "step", required = true) int step,
	    HttpServletResponse httpResponse_p, WebRequest request_p,
	    HttpServletRequest request) {
	boolean success = false;
	ModelAndView mv = new ModelAndView();
	mv.setView(jsonView);
	try {
	    String msg = null;
	    if (step == 1) {
		msg = "We have Dr. Paige D. @ Kidz Dental, 15222 William Cannon, Austin TX 78758.  Is that correct?";
	    } else if (step == 2) {
		msg = "Is the shipping address of 123 Sesame Street, Austin TX 78722 still valid?";
	    }
	    mv.addObject("message", msg);
	    success = true;
	} catch (Exception e) {
	    success = false;
	}
	mv.addObject(SUCCESS_FIELD, success);
	return mv;
    }

    @RequestMapping(value = "/order/new", method = RequestMethod.GET)
    public @ResponseBody ModelAndView createNewOrder(
	    HttpServletResponse httpResponse_p, WebRequest request_p,
	    HttpServletRequest request) {
	boolean success = false;
	ModelAndView mv = new ModelAndView();
	mv.setView(jsonView);
	try {
	    mv.addObject(
		    "message",
		    "Congratulation! We will be shipping your order momentarily.  I will text you when we ship your prescription.");
	    success = true;
	    System.out.println("Received a new order from");
	} catch (Exception e) {
	    success = false;
	}
	mv.addObject(SUCCESS_FIELD, success);
	return mv;
    }

    @RequestMapping(value = "/location", method = RequestMethod.GET)
    public @ResponseBody ModelAndView getLocation(
	    HttpServletResponse httpResponse_p, WebRequest request_p,
	    HttpServletRequest request) {
	boolean success = false;
	ModelAndView mv = new ModelAndView();
	mv.setView(jsonView);
	try {
	    mv.addObject(
		    "message",
		    "You can find the closest pharmacy @ https://www.express-scripts.com/TRICARE/pharmacy/findpharmacy.shtml");
	    success = true;
	} catch (Exception e) {
	    success = false;
	}
	mv.addObject(SUCCESS_FIELD, success);
	return mv;
    }

    @RequestMapping(value = "/image", method = RequestMethod.GET)
    public @ResponseBody ModelAndView getWatcher(
	    @PathVariable("sug_id") int sugId,
	    HttpServletResponse httpResponse_p, WebRequest request_p,
	    HttpServletRequest request) {
	boolean success = false;
	try {

	    success = true;
	} catch (Exception e) {
	    success = false;
	}
	ModelAndView mv = new ModelAndView();
	mv.setView(jsonView);
	mv.addObject(SUCCESS_FIELD, success);

	return mv;
    }
}
