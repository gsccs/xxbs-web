package com.gsccs.cmcc.info.model;

public class Specattachs {
	private String id;

	private String title;
	private String url;
	private String state;
	private String speclineid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}

	public String getSpeclineid() {
		return speclineid;
	}

	public void setSpeclineid(String speclineid) {
		this.speclineid = speclineid;
	}

}