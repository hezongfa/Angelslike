package com.android.angelslike.bean;

import com.hzf.bean.BaseBean;

public class Advertisement extends BaseBean {
	/**
	 * 
	 */
	private String name;
	private String img;
	private String link;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Advertisement(String name, String img, String link) {
		super();
		this.name = name;
		this.img = img;
		this.link = link;
	}

	public Advertisement() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Advertisement [name=" + name + ", img=" + img + ", link="
				+ link + "]";
	}

}
