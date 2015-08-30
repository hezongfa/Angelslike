package com.android.angelslike.bean;

import com.hzf.bean.BaseBean;

public class ClubBean extends BaseBean {

	private long type;
	private String title;
	private String pname;
	private long copies;
	private long currentcopies;
	private String name;
	private String img;
	private double price;
	private double everyprice;
	private long day;
	private long jindu;
	private String status;
	private long isshow;
	private long etime;
	private long is;
	private String outday;
	private String nowstatus;

	@Override
	public String toString() {
		return "ClubBean [type=" + type + ", title=" + title + ", pname="
				+ pname + ", copies=" + copies + ", currentcopies="
				+ currentcopies + ", name=" + name + ", img=" + img
				+ ", price=" + price + ", everyprice=" + everyprice + ", day="
				+ day + ", jindu=" + jindu + ", status=" + status + ", isshow="
				+ isshow + ", etime=" + etime + ", is=" + is + ", outday="
				+ outday + ", nowstatus=" + nowstatus + "]";
	}

	public ClubBean(long type, String title, String pname, long copies,
			long currentcopies, String name, String img, double price,
			double everyprice, long day, long jindu, String status,
			long isshow, long etime, long is, String outday, String nowstatus) {
		super();
		this.type = type;
		this.title = title;
		this.pname = pname;
		this.copies = copies;
		this.currentcopies = currentcopies;
		this.name = name;
		this.img = img;
		this.price = price;
		this.everyprice = everyprice;
		this.day = day;
		this.jindu = jindu;
		this.status = status;
		this.isshow = isshow;
		this.etime = etime;
		this.is = is;
		this.outday = outday;
		this.nowstatus = nowstatus;
	}

	public long getType() {
		return type;
	}

	public void setType(long type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public long getCopies() {
		return copies;
	}

	public void setCopies(long copies) {
		this.copies = copies;
	}

	public long getCurrentcopies() {
		return currentcopies;
	}

	public void setCurrentcopies(long currentcopies) {
		this.currentcopies = currentcopies;
	}

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getEveryprice() {
		return everyprice;
	}

	public void setEveryprice(double everyprice) {
		this.everyprice = everyprice;
	}

	public long getDay() {
		return day;
	}

	public void setDay(long day) {
		this.day = day;
	}

	public long getJindu() {
		return jindu;
	}

	public void setJindu(long jindu) {
		this.jindu = jindu;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getIsshow() {
		return isshow;
	}

	public void setIsshow(long isshow) {
		this.isshow = isshow;
	}

	public long getEtime() {
		return etime;
	}

	public void setEtime(long etime) {
		this.etime = etime;
	}

	public long getIs() {
		return is;
	}

	public void setIs(long is) {
		this.is = is;
	}

	public String getOutday() {
		return outday;
	}

	public void setOutday(String outday) {
		this.outday = outday;
	}

	public String getNowstatus() {
		return nowstatus;
	}

	public void setNowstatus(String nowstatus) {
		this.nowstatus = nowstatus;
	}

	public ClubBean() {
		super();
		// TODO Auto-generated constructor stub
	}

}
