package com.mabsapps.spring5webapp.restservice;

public class Greeting {
	private final Long id;
	private final String content;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param id
	 * @param content
	 */
	public Greeting(Long id, String content) {
		this.id = id;
		this.content = content;
	}

}
