package net.valorweb.services.exception;

public class FileExeption extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FileExeption(String msg) {
		super(msg);
	}

	public FileExeption(String msg, Throwable cause) {

		super(msg, cause);
	}


}
