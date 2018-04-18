package cn.lvhaosir.controller;


import cn.lvhaosir.entity.Advices;
import cn.lvhaosir.service.AdvicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class BaseController {

	@Autowired
	private AdvicesService advicesService;
	
	@RequestMapping(value="/admin")
	public ModelAndView goAdmin(){
		List<Advices> queryAllList = advicesService.queryAllList();
		return new ModelAndView("admin","adviceList",queryAllList);
	}
	
	@RequestMapping(value="/login")
	public String goLogin(){
		return "login";
	}
}
