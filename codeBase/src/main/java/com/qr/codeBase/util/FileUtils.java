package com.qr.codeBase.util;

import com.qr.codeBase.model.FileDownloadResponse;

/**
 * Utility class for file-related operations.
 */
public class FileUtils {

    /**
     * Converts the given PNG data to a FileDownloadResponse object.
     *
     * @param pngData the byte array containing PNG data
     * @return a FileDownloadResponse object containing the file name, file type, and file size
     */
    public static FileDownloadResponse convertToResponse(byte[] pngData,String fileType) {
	long currentTime = System.currentTimeMillis();
	String fileName = QRConstant.FILE_NAME.concat(String.valueOf(currentTime));
	return new FileDownloadResponse(fileName, FileType.getMimeTypeByTypeName(fileType), pngData.length);
    }
}