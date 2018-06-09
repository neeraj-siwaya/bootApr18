package com.techmentro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.techmentro.entity.Emp;
import com.techmentro.repository.EmpDao;

@Controller
public class EmpController {

	@Autowired
	EmpDao dao;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String home()
	{
		return "index";
	}
	@RequestMapping(path="/save", method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute Emp emp)
	{
		dao.save(emp);
		ModelAndView mav = new ModelAndView("saved");
		return mav;
	}
	@RequestMapping(path="/edit", method=RequestMethod.GET)
	public ModelAndView save(@RequestParam int id)
	{
		Emp emp=dao.findOne(id);
		ModelAndView mav = new ModelAndView("edit");
		mav.addObject("emp",emp);
		return mav;
	}
	@RequestMapping(path="/update", method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute Emp emp)
	{
		dao.save(emp);
		ModelAndView mav = allEmp();
		mav.addObject("message","successfully updated.");
		return mav;
	}
	@RequestMapping(path="/delete", method=RequestMethod.GET)
	public ModelAndView delete(@RequestParam int id)
	{
		dao.delete(id);
		ModelAndView mav = allEmp();
		mav.addObject("message","successfully deleted.");
		return mav;
	}
	@RequestMapping(path="/emps", method=RequestMethod.GET)
	public ModelAndView allEmp()
	{
		Iterable<Emp> list = dao.findAll();
		ModelAndView mav = new ModelAndView("allEmp");
		mav.addObject("empList",list);
		return mav;
	}
}
