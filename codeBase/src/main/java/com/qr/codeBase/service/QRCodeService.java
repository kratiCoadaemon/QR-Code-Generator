package com.qr.codeBase.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.qr.codeBase.exception.QRException;
import com.qr.codeBase.exception.QRWriterException;
import com.qr.codeBase.model.FileDownloadResponse;
import com.qr.codeBase.util.FileType;
import com.qr.codeBase.util.FileUtils;
import com.qr.codeBase.util.QRConstant;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Service class to generate QR code
 */
@Service
public class QRCodeService {

    /**
     * Method to generate QR code
     * @param text text to be encoded in QR code
     * @param fileType 	file type of QR code
     * @return 	FileDownloadResponse object containing the file name, file type, and file size
     * @throws QRWriterException
     * @throws QRException
     */
    public FileDownloadResponse generateQRCode(String text, String fileType) throws QRWriterException, QRException {
	try {
	    QRCodeWriter qrCodeWriter = new QRCodeWriter();
	    BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, QRConstant.QR_WIDTH, QRConstant.QR_HEIGHT);

	    ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
	    MatrixToImageWriter.writeToStream(bitMatrix,  FileType.getTypeName(fileType), pngOutputStream);
	    byte[] pngData = pngOutputStream.toByteArray();
	    File outputFile = new File(QRConstant.FILE_PATH + QRConstant.FILE_NAME + System.currentTimeMillis() + "." + fileType);
	    try (FileOutputStream fileOutputStream = new FileOutputStream(outputFile)) {
		fileOutputStream.write(pngData);
	    }
	    return FileUtils.convertToResponse(pngData,fileType);
	} catch (WriterException e)  {
	    throw new QRWriterException("Error in converting or encoding  QR code ", e);
	}catch (IOException e)  {
	    throw new QRException("Error generating QR code", e);

	}
    }

}