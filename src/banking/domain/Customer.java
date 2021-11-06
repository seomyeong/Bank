package banking.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private String name;
	private String ssn;
	private List<Account> accounts = new ArrayList<Account>();
	private int numberOfAccounts;

	public Customer(String name, String ssn) {
		this.name=name;
		this.ssn=ssn;
	}

	//Customer가 계좌를 추가
	public void addAccount(Account acct) {
		if(accounts.add(acct)) {
			System.out.println(name+"님의 "+acct+"계좌 개설에 성공했습니다.");
		}else {
			System.out.println(name+"님의 "+acct+"계좌 개설에 실패했습니다.");
		}
	}

	public Account getAccount(int accountIndex) {
		return accounts.get(accountIndex);
	}

	public int getNumOfAccounts() {
		return accounts.size();
	}

	public String getName() {return name;}
	public String getSsn() {return ssn;}

}
