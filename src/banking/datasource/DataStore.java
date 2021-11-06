package banking.datasource;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * S, C는 char로 받는게 좋음. (값이 바뀌지 않을거기때문에)
 * 스캐너를 사용했을 때 → next() (문자열) 로 받은다음 char로 형변환시키면 됨.
 * char이 몇번째에있는지  : charAt(index)
 */
public class DataStore {
	private static File dataFile;

	public DataStore() {}
	
	public static void loadCustomerAccountsData() throws IOException{
//		Scanner input = 
	}
	
	public static void main(String[] args) {
		//파일로 값 받아오기
		Scanner s;
		
		FileReader fis = null;
		File file = new File("customer_account.data");
		
		try {
			fis=new FileReader(file);
			try {
				
				for(int customerRead; (customerRead = fis.read()) != -1; ) {
					if(customerRead != 10 && customerRead != 13) {
						System.out.print( (char)customerRead );
					}else if(customerRead == 10) {
						continue;
					}else {
						System.out.println();
					}
				}
			}finally {
				fis.close();
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
