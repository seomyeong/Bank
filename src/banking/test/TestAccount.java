package banking.test;

import banking.domain.Account;
import banking.exception.OverdrawnException;
import banking.exception.CheckingOverdrawnException;

public class TestAccount {
	public static void main(String[] args) {
		Account acct = new Account(500);
		acct.deposit(1500);
		try {
			acct.withdraw(1700);
		} catch (CheckingOverdrawnException e) {
			System.out.println(e.getMessage());
		} catch (OverdrawnException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Final Account Balance is: " + acct.getBalance());
	}
}
