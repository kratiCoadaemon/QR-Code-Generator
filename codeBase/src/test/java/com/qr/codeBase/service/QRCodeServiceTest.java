package com.qr.codeBase.service;

import com.google.zxing.WriterException;
import com.qr.codeBase.exception.QRException;
import com.qr.codeBase.exception.QRWriterException;
import com.qr.codeBase.model.FileDownloadResponse;
import com.qr.codeBase.util.FileUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class QRCodeServiceTest {

    @InjectMocks
    private QRCodeService qrCodeService;

    private MockedStatic<FileUtils> fileUtilsMockedStatic;
    byte[] pngData = new byte[] { 1, 2, 3 };

    /**
     * Test method for QR Code generation service
     * @throws QRWriterException
     * @throws QRException
     * @throws WriterException
     * @throws IOException
     */
    @Test
    public void testGenerateQRCode_Success() throws QRWriterException, QRException, WriterException, IOException {
	String text = "https://example.com";

	FileDownloadResponse expectedResponse = new FileDownloadResponse("qr_code.png", "image/png", pngData.length);
	FileDownloadResponse actualResponse = qrCodeService.generateQRCode(text, "PNG");

	assertNotNull(actualResponse);
	assertEquals(expectedResponse.getFileType(), actualResponse.getFileType());
    }

    /**
     * Test method for QR Code generation service
     * @throws WriterException
     */
    @Test
    public void testGenerateQRCode_QRException() throws WriterException {
	String text = "invalid-url";
	assertThrows(QRException.class, () -> qrCodeService.generateQRCode(text, "PNG"));
    }

}