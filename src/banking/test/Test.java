package banking.test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
	public boolean isKorean(String str) throws IOException {
		byte[] bytes = str.getBytes();
		InputStreamReader reader = new InputStreamReader(new ByteArrayInputStream(bytes));
		for(int r; (r = reader.read()) != -1;) {
			if(r < 44032 || r > 55203) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		try {
			System.out.println("A : " + t.isKorean("A"));
			System.out.println("가나다 : " + t.isKorean("가나다"));
			System.out.println("가A가 : " + t.isKorean("가A가"));
			System.out.println("힣 : " + t.isKorean("힣"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
