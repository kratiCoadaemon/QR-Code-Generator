package com.qr.codeBase.exception;

public class QRException extends Exception {

    private static final long serialVersionUID = 1L;

    public QRException(String message) {
	super(message);
    }

    public QRException(String message, Throwable cause) {
	super(message, cause);
    }

    public QRException(Throwable cause) {
	super(cause);
    }

    public QRException() {
	super();
    }
}