package dao;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.nio.file.Path;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

public class TestQR {
//	public static void main(String[] args) throws Exception {
//        
//        String content = "https://simplifyingtechcode.wordpress.com/";
//        String pathToStore = "D:\\QRCodeGenerated.jpg";
//         
//        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, 500, 500);
//        MatrixToImageWriter.writeToPath(bitMatrix, "jpg", Path.get(pathToStore));
//        System.out.println("QR Code Generated Successfully");
// 
//    }
	public static void main(String[] args) throws Exception {
        
        try {
        	String pathToStore = "D:\\QRCodeGenerated.jpg";
            BufferedImage readerImage = ImageIO.read(new FileInputStream(pathToStore));
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(readerImage)));
            Result resultObj = new MultiFormatReader().decode(binaryBitmap);
             
            System.out.println(resultObj.getText());
             
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
