package net.valorweb.recource.exceptions;

import java.io.Serializable;

public class FieldMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FieldMessage() {
		// TODO Auto-generated constructor stub
	}

	public FieldMessage(String fildName, String message) {
		super();
		this.fildName = fildName;
		this.message = message;
	}

	private String fildName;
	private String message;

	public String getFildName() {
		return fildName;
	}

	public void setFildName(String fildName) {
		this.fildName = fildName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
