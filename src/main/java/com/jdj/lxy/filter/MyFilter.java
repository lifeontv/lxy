package com.jdj.lxy.filter;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@WebFilter(urlPatterns = "/nihso", filterName = "MyFilter")
public class MyFilter implements Filter {
	
	
	@Override

	public void destroy() {

		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterchain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) srequest;
		System.out.println("this is myFilter,url:" + request.getRequestURI());
		System.out.println("被过滤了");
		
		filterchain.doFilter(srequest, sresponse);
	}

	@Override

	public void init(FilterConfig arg0) throws ServletException {

		// TODO Auto-generated method stub

	}

}
