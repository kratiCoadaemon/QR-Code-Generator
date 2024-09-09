package com.qr.codeBase.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents a response containing file download information.
 */
@Getter
@Setter
public class FileDownloadResponse {
    // Name of the file
    private String fileName;

    // Type of the file
    private String fileType;

    // Data of the file in byte array format
    private byte[] fileData;

    // MIME type of the file
    private String mimeType;

    // Size of the file in bytes
    private long fileSize;

    /**
     * Constructs a new FileDownloadResponse with the specified file name, file type, and file size.
     *
     * @param fileName the name of the file
     * @param fileType the type of the file
     * @param fileSize the size of the file in bytes
     */
    public FileDownloadResponse(String fileName, String fileType, long fileSize) {
	this.fileName = fileName;
	this.fileType = fileType;
	this.fileSize = fileSize;
    }
}