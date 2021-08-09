package com.malex.barcodes.generators;

import java.awt.*;
import java.awt.image.BufferedImage;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;

public class BarbecueBarcodeGenerator {

    private static final Font BARCODE_TEXT_FONT = new Font(Font.SANS_SERIF, Font.PLAIN, 14);

    public static BufferedImage generateUPCABarcodeImage(String barcodeText) throws  Exception {
        Barcode barcode = BarcodeFactory.createUPCA(barcodeText);
        barcode.setFont(BARCODE_TEXT_FONT);
        barcode.setResolution(400);
        return BarcodeImageHandler.getImage(barcode);
    }

    public static BufferedImage generateEAN13BarcodeImage(String barcodeText) throws Exception {
        Barcode barcode = BarcodeFactory.createEAN13(barcodeText);
        barcode.setFont(BARCODE_TEXT_FONT);
        return BarcodeImageHandler.getImage(barcode);
    }

    public static  BufferedImage generateCode128BarcodeImage(String barcodeText) throws Exception  {
        Barcode barcode = BarcodeFactory.createCode128(barcodeText);
        barcode.setFont(BARCODE_TEXT_FONT);
        return BarcodeImageHandler.getImage(barcode);
    }

    public static BufferedImage generatePDF417BarcodeImage(String barcodeText) throws Exception {
        Barcode barcode = BarcodeFactory.createPDF417(barcodeText);
        barcode.setFont(BARCODE_TEXT_FONT);
        return BarcodeImageHandler.getImage(barcode);
    }

}
