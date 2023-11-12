package dao;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
	public LocalDate getMinusTime(int day) {
		LocalDate localDate = LocalDate.now();
		if(day == 1) {
			localDate.minusDays(1);
		}
		else if (day == 7) {
			localDate.minusDays(7);
		}
		else if (day == 30) {
			localDate.minusDays(30);
		}
		return localDate;
	}
	public static void main(String[] args) {

		System.out.println();
	}
}
