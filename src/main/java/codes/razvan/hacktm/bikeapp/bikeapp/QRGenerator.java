package codes.razvan.hacktm.bikeapp.bikeapp;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import lombok.SneakyThrows;

import java.awt.image.BufferedImage;
import java.nio.charset.StandardCharsets;

public class QRGenerator {
    @SneakyThrows
    public static BufferedImage generate(String data, int h, int w) {
        BitMatrix matrix = new MultiFormatWriter().encode(new String(data.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8), BarcodeFormat.QR_CODE, w, h);
        return MatrixToImageWriter.toBufferedImage(matrix);
//        MatrixToImageWriter.writeToFile(matrix, "png", new File("qr.png"));
    }

}
