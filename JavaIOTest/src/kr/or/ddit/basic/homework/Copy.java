package kr.or.ddit.basic.homework;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copy {
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();

		//Buffered 적용하기
		FileInputStream fis = null;
		FileOutputStream fos = null; 
		BufferedOutputStream bos = null;
		
		
		try {
			fis = new FileInputStream("D:/D_Other/Tulips.jpg");
			fos = new FileOutputStream("d:/D_Other/복사본_Tulips.jpg");
			bos = new BufferedOutputStream(fos);
			
			int data = 0;
			
			
			while ((data=fis.read()) != -1) {
				bos.write(data);
			}
			
			bos.flush();
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				fis.close();
				fos.close();
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		
//		FileInputStream fis = null;
//		FileOutputStream fos = null;
//
//		try {
//			fis = new FileInputStream("D:/D_Other/Tulips.jpg");
//			fos = new FileOutputStream("d:/D_Other/복사본_Tulips.jpg");
//
//			int data = 0;
//
//			while ((data = fis.read()) != -1) {
//				fos.write(data);
//			}
//		} catch (IOException ex) {
//			ex.printStackTrace();
//		} finally {
//			try {
//				fis.close();
//				fos.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		long endTime = System.currentTimeMillis();
		
		System.out.println(endTime - startTime);
	}
}

