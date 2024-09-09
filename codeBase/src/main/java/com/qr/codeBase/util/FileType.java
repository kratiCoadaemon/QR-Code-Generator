package com.qr.codeBase.util;

import java.util.Arrays;

/**
 * Enum representing different file types and their MIME types.
 */
public enum FileType {
    /**
     * PNG file type with MIME type "image/png".
     */
    PNG("image/png", "PNG"),

    /**
     * JPG file type with MIME type "image/jpeg".
     */
    JPG("image/jpeg", "JPG"),

    /**
     * PDF file type with MIME type "application/pdf".
     */
    PDF("application/pdf", "PDF");

    // MIME type of the file
    private final String mimeType;

    // Type name of the file
    private final String typeName;

    /**
     * Constructor to initialize the MIME type and type name.
     *
     * @param mimeType the MIME type of the file
     * @param typeName the type name of the file
     */
    FileType(String mimeType, String typeName) {
	this.mimeType = mimeType;
	this.typeName = typeName;
    }

    /**
     * Gets the MIME type of the file.
     *
     * @return the MIME type
     */
    public String getMimeType() {
	return mimeType;
    }

    /**
     * Gets the type name of the file.
     *
     * @return the type name
     */
    public String getTypeName() {
	return typeName;
    }

    /**
     * Gets the MIME type of the file by the given type name.
     * @param typeName
     * @return
     */
    public static String getMimeTypeByTypeName(String typeName) {
        return Arrays.stream(FileType.values()).findAny().filter(fileType -> fileType.getTypeName().equals(typeName)).map(FileType::getMimeType).orElse(PNG.getMimeType());
    }
    public static String getTypeName(String typeName) {
        return Arrays.stream(FileType.values()).findAny().filter(fileType -> fileType.getTypeName().equals(typeName)).map(FileType::getTypeName).orElse(PNG.getTypeName());
    }

    /**
     * Gets the list of file types.
     * @return
     */
    public static String getFileTypeList() {
        String fileTypeList="";
        for (FileType fileType : FileType.values()) {
            fileTypeList.concat(fileType.getTypeName());
        }
     return fileTypeList;
    }
    }

