package com.android.angelslike.view;

public class PopItem {

	public PopItem(String id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

	public PopItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String id;
	private String text;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}