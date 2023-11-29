package ch19;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class ImageDown {
	public static void main(String[] args) throws Exception {
		String img = "https://cdn.pixabay.com/photo/2014/02/01/17/28/apple-256261_640.jpg";
		URL url = new URL(img);
		byte[] buffer = new byte[4096];
//		바이트배열				 버퍼사이즈 설정

		InputStream in = url.openStream();
//						    InputStream 생성
		OutputStream out = new FileOutputStream("c:/data/test.jpg");
		int length = 0;

		while ((length = in.read(buffer)) != -1) {
//				length = in.read(buffer) 	 -1	
//			==> 바이트수	  읽어오기	 버퍼사용	   (다 읽음)		
			System.out.println(length + " byte 읽음");
			out.write(buffer, 0, length);
//				파일저장 	    기준	  사이즈
		}
		System.out.println("Done");
	}
}
