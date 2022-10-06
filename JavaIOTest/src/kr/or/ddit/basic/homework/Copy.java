package kr.or.ddit.basic.homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copy {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("D:/D_Other/Tulips.jpg");
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream("d:/D_Other/복사본_Tulips.jpg");
			
			int data = 0;
			
			while ((data=fis.read()) != -1) {
				fos.write(data);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}
}