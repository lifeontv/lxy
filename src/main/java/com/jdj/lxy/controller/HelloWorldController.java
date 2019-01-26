package com.jdj.lxy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jdj.lxy.mapper.CategoryMapper;
import com.jdj.lxy.pojo.Category;
import com.jdj.lxy.util.JdjProperties;

@Controller
public class HelloWorldController {
	@Autowired
	CategoryMapper categoryMapper;
	
	@Autowired
	JdjProperties jdjProperties;
	
	
	@RequestMapping("/hello")
	public String index(Model model,@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
		 PageHelper.startPage(start,size,"id desc");
		List<Category> cs=categoryMapper.find();
		PageInfo<Category> page = new PageInfo<>(cs);
		model.addAttribute("cs",cs);
		model.addAttribute("name", "hello world");
		model.addAttribute("page",page);
		 return "hello"; 

    }
	@RequestMapping("/delete")
	public String delete(int id) {
		categoryMapper.delete(id);
		return "redirect:/hello";
	}
	@RequestMapping("/addCategory")
	public String addCategory(Category category) {
		categoryMapper.save(category);
		return "redirect:/hello";
	}
	

	
}
