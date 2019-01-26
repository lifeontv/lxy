package com.jdj.lxy.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JdjProperties {
	 @Value("${com.jdj.title}")
	 private String title;
	 
	 @Value("${com.jdj.description}")
	 private String description;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	 
}
