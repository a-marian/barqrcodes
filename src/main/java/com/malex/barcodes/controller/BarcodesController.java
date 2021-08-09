package com.malex.barcodes.controller;

import com.malex.barcodes.generators.BarbecueBarcodeGenerator;
import com.malex.barcodes.generators.Barcode4jBarcodeGenerator;
import com.malex.barcodes.generators.ZxingBarcodeGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;

@RestController
@RequestMapping("/barcodes")
public class BarcodesController {

    //barbecue library

    @GetMapping(value="/barbacue/upca/{barcode}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> getBarbacueUPCABarcode(@PathVariable("barcode") String barcode) throws Exception{
        return okResponse(BarbecueBarcodeGenerator.generateUPCABarcodeImage(barcode));
    }

    @GetMapping(value="/barbacue/ean13/{barcode}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> getBarbacueEAN13Barcode(@PathVariable("barcode") String barcode) throws Exception{
        return ResponseEntity.ok(BarbecueBarcodeGenerator.generateEAN13BarcodeImage(barcode));
    }

    //barcode4j library
    @GetMapping(value="/barcode4j/upca/{barcode}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> getBarcode4jUPCABarcode(@PathVariable("barcode") String barcode) throws Exception{
        return ResponseEntity.ok(Barcode4jBarcodeGenerator.generateUPCABarcodeImage(barcode));
    }

    @GetMapping(value="/barcode4j/ean13/{barcode}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> getBarcode4jEAN13Barcode(@PathVariable("barcode") String barcode) throws Exception{
        return ResponseEntity.ok(Barcode4jBarcodeGenerator.generateEAN13BarcodeImage(barcode));
    }

    //Zxing library

    @GetMapping(value = "/zxing/upca/{barcode}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> getZxingUPCABarcode(@PathVariable("barcode") String barcode) throws Exception {
        return ResponseEntity.ok(ZxingBarcodeGenerator.generateUPCABarcodeImage(barcode));
    }

    @GetMapping(value = "/zxing/ean13/{barcode}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> getZxingEAN13Barcode(@PathVariable("barcode") String barcode) throws Exception {
        return okResponse(ZxingBarcodeGenerator.generateEAN13BarcodeImage(barcode));
    }
    private ResponseEntity<BufferedImage> okResponse(BufferedImage image) {
        return new ResponseEntity<>(image, HttpStatus.OK);
    }

}
