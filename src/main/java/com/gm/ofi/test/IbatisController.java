package com.gm.ofi.test;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gm.ofi.orm.mybatis.PagerModel;
import com.gm.ofi.orm.mybatis.model.Users;
import com.gm.ofi.orm.mybatis.model.UsersExample;
import com.gm.ofi.orm.mybatis.model.UsersExample.Criteria;
import com.gm.ofi.orm.mybatis.service.impl.UsersServiceImpl;


//@Controller
public class IbatisController {
	@Inject
	private UsersServiceImpl usersService;
	
	@RequestMapping(value="/mybatis_insert",method={RequestMethod.GET})
	public ModelAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		Users usr = new Users();
		usr.setUserid(1);
		usr.setUsername("system");
		usr.setPassword("password");
		int result = usersService.insert(usr);
		ModelAndView modelAndView = new ModelAndView("orm");
		modelAndView.addObject("result", result);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/mybatis_page",method={RequestMethod.GET})
	public ModelAndView handlePage(HttpServletRequest request,HttpServletResponse response) throws Exception {
		PagerModel<Users> pm = new PagerModel<Users>();
		pm.init(1);
		//创建查询条件
		UsersExample ue = new UsersExample();
		Criteria ca = ue.createCriteria();
		ca.andUsernameEqualTo("system");
		ue.setOrderByClause(pm.getOrder("userid"));
		int count=usersService.selectByExample(ue).size();
		ModelAndView modelAndView = new ModelAndView("orm");
		modelAndView.addObject("result", count);
		
		return modelAndView;
	}
}
