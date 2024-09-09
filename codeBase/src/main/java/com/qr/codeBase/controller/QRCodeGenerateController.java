package com.qr.codeBase.controller;

import com.qr.codeBase.exception.QRException;
import com.qr.codeBase.exception.QRWriterException;
import com.qr.codeBase.model.FileDownloadResponse;
import com.qr.codeBase.service.QRCodeService;
import com.qr.codeBase.util.FileType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/v1/qrcode")
public class QRCodeGenerateController {

    @Autowired
    private QRCodeService qrCodeService;

    /**
     * Generate QR Code
     * @param text
     * @param filleType
     * @return
     */
    @PostMapping("/generateQRCode")
    public ResponseEntity<Resource> generateQRCode(@RequestParam String text, @RequestParam String filleType) {
        try {
           FileDownloadResponse fileDownloadResponse = qrCodeService.generateQRCode(text, filleType);

            return ResponseEntity.ok()//
                    .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; fileName=" +fileDownloadResponse.getFileName())
                    .contentLength(fileDownloadResponse.getFileSize())
                    .contentType(MediaType.valueOf(fileDownloadResponse.getFileType()))
                    .body(new ByteArrayResource(fileDownloadResponse.getFileData()));
        } catch (QRException | QRWriterException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Give the list of supported file types
     * @return
     */
    @GetMapping("/fileType")
    public ResponseEntity<String> getFileType(){
        return new ResponseEntity<>(FileType.getFileTypeList(), HttpStatus.OK);

    }
}