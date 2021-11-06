package banking.domain;

import banking.exception.CheckingOverdrawnException;
import banking.exception.OverdrawnException;

public class Account {
	protected double balance;

	public Account(double initBalance) {
		balance=initBalance;
	}

	public double getBalance() {
		return balance;
	}

	//입금
	public void deposit(double amount) {
		this.balance+=amount;
	}

	//출금
	public void withdraw(double amount) throws OverdrawnException, CheckingOverdrawnException{
		if(this.balance < amount) {
			throw new OverdrawnException("잔액부족", balance);
		}else {
			this.balance-=amount;
			System.out.print(amount+"원 출금 성공~!");
		}
	}
}
