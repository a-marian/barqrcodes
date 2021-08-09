package com.malex.barcodes.controller;

import com.malex.barcodes.generators.QRGenBarcodeGenerator;
import com.malex.barcodes.generators.ZxingBarcodeGenerator;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;

@RestController
@RequestMapping("qrcodes")
public class QRCodeController {

    //Zxing library

    @GetMapping(value = "/zxing", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> getZxingQRCode(@RequestBody String barcode) throws Exception {
        return ResponseEntity.ok(ZxingBarcodeGenerator.generateQRCodeImage(barcode));
    }

    @GetMapping(value = "/qrgen", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> getQRGenQRCode(@RequestBody String barcode) throws Exception {
        return ResponseEntity.ok(QRGenBarcodeGenerator.generateQRCodeImage(barcode));
    }
}
