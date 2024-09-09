package com.qr.codeBase.exception;

public class QRWriterException extends Exception{

    private static final long serialVersionUID = 1L;

    public QRWriterException(String message) {
	super(message);
    }

    public QRWriterException(String message, Throwable cause) {
	super(message, cause);
    }

    public QRWriterException(Throwable cause) {
	super(cause);
    }

    public QRWriterException() {
	super();
    }
}
