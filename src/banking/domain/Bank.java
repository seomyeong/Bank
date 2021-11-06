package banking.domain;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	private static List<Customer> customers= new ArrayList<>();

	static {
	}
	
	public Bank() {}

	//Bank에서 고객을 추가
	public static void addCustomer(String name, String ssn) {
		if(customers.add(new Customer(name, ssn))) {
			System.out.println(name+"님의 은행 가입을 축하합니다.");
		}else {
			System.out.println(name+"님 가입에 실패했습니다.");
		}
		
	}

	public static int getNumOfCustomers() {
		return customers.size();
	}

	public static Customer getCustomer(int customerIndex) {
		return customers.get(customerIndex);
	}
}
