package com.jdj.lxy.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jdj.lxy.mapper.CategoryMapper;
import com.jdj.lxy.mapper.MypictureMapper;
import com.jdj.lxy.pojo.Category;
import com.jdj.lxy.pojo.Mypicture;
import com.jdj.lxy.util.JdjProperties;

@Controller
public class HelloWorldController {
	@Autowired
	CategoryMapper categoryMapper;
	@Autowired
	MypictureMapper mypictureMapper;
	@Autowired
	JdjProperties jdjProperties;

	@RequestMapping("/hello")
	public String index(Model model, @RequestParam(value = "start", defaultValue = "0") int start,
			@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
		PageHelper.startPage(start, size, "id desc");
		List<Category> cs = categoryMapper.find();
		for(Category c:cs) {
			Mypicture picture=mypictureMapper.get(c.getId());
			if(null==picture) {
				picture=new Mypicture(0,"null");
			}
			c.setPicture(picture);
			System.out.println(c.getPicture().getPath());
			
			
		}
		PageInfo<Category> page = new PageInfo<>(cs);
		model.addAttribute("cs", cs);
		model.addAttribute("name", "hello world");
		model.addAttribute("page", page);
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

	@RequestMapping("/upload")
	public String upload(HttpServletRequest req, MultipartFile file, int id) {
			
		try {
			
			String splitName=file.getOriginalFilename();//获取上传文件的名字
			String [] strArray=splitName.split("\\.");//分割字符串
			String suffix=strArray[strArray.length-1];//取最后一段
			String fileName = "mypicture" + id+"."+suffix;//设置文件名
			String destFileName = req.getServletContext().getRealPath("") + "uploaded" + File.separator + fileName;//设置文件路径名
			File destFile = new File(destFileName);//新建文件对象
			destFile.getParentFile().mkdirs();//建立文件夹
			file.transferTo(destFile);//复制上传文件至改文件
			if(null!=mypictureMapper.get(id)) {
				mypictureMapper.update(new Mypicture(id,"uploaded" + File.separator + fileName));
			}else {
				mypictureMapper.insert(new Mypicture(id,"uploaded" + File.separator + fileName));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
            return "上传失败," + e.getMessage();
		} catch (IOException e) {
			e.printStackTrace();
            return "上传失败," + e.getMessage();
		}
		return "redirect:/hello";
	}

}
