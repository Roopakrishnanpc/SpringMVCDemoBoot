package com.SpringMVC.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.SpringMVC.model.SpringMVCModel;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
//	@RequestMapping("/")
//	public String home()
//	{
//		System.out.println("Home page requested");
//		return "index.jsp";
//	}
//	@RequestMapping("/")
//	public String home()
//	{
//		System.out.println("Home page requested");
//		return "index";
//	}

	//1. Uing httpsesson & httprequest
//	@RequestMapping("add")
//	public String add(HttpServletRequest request )
//	{
//		int i=Integer.parseInt(request.getParameter("num1"));
//		int j=Integer.parseInt(request.getParameter("num2"));
//		int result=i+j;
//		//return "result.jsp?result=" +result";
//		//We can do using session usig setattribute
//		HttpSession session=request.getSession();
//		session.setAttribute("result", result);
//		return "result.jsp";
//	}
//Using RequestParam
//	@RequestMapping("add")
//	public String add(@RequestParam("num1")int i,@RequestParam("num2") int j,HttpSession session )
//	{
//
//		int result=i+j;
//
//		session.setAttribute("result", result);
//		return "result.jsp";
//	}
	//Using ModelAndView
//	@RequestMapping("add")
//	public ModelAndView add(@RequestParam("num1")int i,@RequestParam("num2") int j)
//	{
//		ModelAndView modelvew =new ModelAndView();
//		modelvew.setViewName("result.jsp");
//		int result=i+j;
//
//		modelvew.addObject("result",result);
//		return modelvew;
//	}
	//check applicatio propertes - o remove the extenstion and pathame
	//when client send request, client expect response in html or a view. we also send data
	//seo what we do is send modelandview using below class. basically our jsp converted to html after rendering
//	@RequestMapping("add")
//	public ModelAndView addMethod(@RequestParam("num1")int i,@RequestParam("num2") int j)
//	{
////		ModelAndView modelvew =new ModelAndView();
////		modelvew.setViewName("result");
//		//we can also gie directly instead of giving above line result drectly you can give
//		ModelAndView modelvew =new ModelAndView("result");
//
//		int result=i+j;
//
//		modelvew.addObject("result",result);
//		return modelvew;
//	}
	//when you want to specify both model and view then we can use modeladview, oly when you want to concentrate on model and 
	//consider view later then use model
//	@RequestMapping("add")
//	public String addMethod(@RequestParam("num1")int i,@RequestParam("num2") int j, Model m)
//	{
//
//		int result=i+j;
//		
//		m.addAttribute("result",result);
//		return "result";
//	}
	//modelmap your data will automically changed in map format
	@RequestMapping("add")
	public String addMethod(@RequestParam("num1")int i,@RequestParam("num2") int j, ModelMap m)
	{

		int result=i+j;
		
		m.addAttribute("result",result);
		return "result";
	}
	//ModelAttribte on method level
	@ModelAttribute
	public void modelData(Model m)
	{
		m.addAttribute("name","springMVCModels");
		
	}
	@RequestMapping("/")
	public String home()
	{
		System.out.println("Home page requested");
		//return "index";
		
		return "indexModel";
	}
//	@RequestMapping("addModel")
//	public String addMethod(@RequestParam("id")int i,@RequestParam("name") String j, Model m)
//	{
//		SpringMVCModel springMVCModel=new SpringMVCModel();
//		
//		springMVCModel.setId(i);
//		springMVCModel.setName(j);
//		m.addAttribute("result",springMVCModel);
//		return "result";
//	}
	
	//@RequestMapping(value="addModel")
	//@RequestMapping(value="addModel",method=RequestMethod.POST)
	@PostMapping(value="addModel")//sending data
	public String addMethod(@ModelAttribute SpringMVCModel springMVCModel )//Model m)
//	public String addMethod(@ModelAttribute("result") SpringMVCModel springMVCModel )//Model m)
	//public String addMethod(SpringMVCModel s )//Model m)
	{

		//m.addAttribute("result",springMVCModel);
		return "result";
	}
	@GetMapping("getModels")
	public String getModel(Model m)
	{
	List<SpringMVCModel>	spring=Arrays.asList(new SpringMVCModel(1,"Roopa"), new SpringMVCModel(2,"Sam"));
	m.addAttribute("result", spring);
	//return spring.toString();
	return "showSpringMVCData";
	}

}
