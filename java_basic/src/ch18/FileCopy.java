package ch18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileCopy {
	public static void main(String[] args) {
		String str = "";
		BufferedReader reader = null;
		BufferedWriter writer = null;
		String file1 = "c:/data/testone.txt";
		String file2 = "c:/data/copied.txt";

		try {
			reader = new BufferedReader(new FileReader(new File(file1)));
			writer = new BufferedWriter(new FileWriter(new File(file2)));

			while (true) {
				str = reader.readLine();
				if (str == null)
					break;
				writer.write(str + "\r\n"); // null 이 아니면 파일을 저장(복사)
//				\r => 캐리지 리턴 carriage return
//				\n 줄바꿈 new Line
			}

			System.out.println("Done");
			reader.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
