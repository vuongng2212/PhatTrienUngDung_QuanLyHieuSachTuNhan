package dao;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
	public static void main(String[] args) throws Exception {
        
        String content = "https://simplifyingtechcode.wordpress.com/";
        String pathToStore = "D:\\QRCodeGenerated.jpg";
         
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, 500, 500);
        MatrixToImageWriter.writeToPath(bitMatrix, "jpg", Paths.get(pathToStore));
        System.out.println("QR Code Generated Successfully");
 
    }
//	public static void main(String[] args) throws Exception {
//        
//        try {
//        	String pathToStore = "D:\\QRCodeGenerated.jpg";
//            BufferedImage readerImage = ImageIO.read(new FileInputStream(pathToStore));
//            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(readerImage)));
//            Result resultObj = new MultiFormatReader().decode(binaryBitmap);
//             
//            System.out.println(resultObj.getText());
//             
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
		//get which week of month
//		Calendar now = Calendar.getInstance();
//
//	    SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
//
//	    String[] days = new String[7];
//	    int delta = -now.get(GregorianCalendar.DAY_OF_WEEK) + 2; //add 2 if your week start on monday
//	    now.add(Calendar.DAY_OF_MONTH, delta );
//	    for (int i = 0; i < 7; i++)
//	    {
//	        days[i] = format.format(now.getTime());
//	        now.add(Calendar.DAY_OF_MONTH, 1);
//	    }
//	    System.out.println(Arrays.toString(days));
//		
//    }
}
