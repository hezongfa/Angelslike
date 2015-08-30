package com.android.angelslike.bean;

import com.hzf.bean.BaseBean;

public class PageInfo extends BaseBean {

	private long page;

	@Override
	public String toString() {
		return "PageInfo [page=" + page + ", maxpage=" + maxpage
				+ ", totalrows=" + totalrows + "]";
	}

	public PageInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PageInfo(long page, long maxpage, long totalrows) {
		super();
		this.page = page;
		this.maxpage = maxpage;
		this.totalrows = totalrows;
	}

	public long getPage() {
		return page;
	}

	public void setPage(long page) {
		this.page = page;
	}

	public long getMaxpage() {
		return maxpage;
	}

	public void setMaxpage(long maxpage) {
		this.maxpage = maxpage;
	}

	public long getTotalrows() {
		return totalrows;
	}

	public void setTotalrows(long totalrows) {
		this.totalrows = totalrows;
	}

	private long maxpage;
	private long totalrows;
}
