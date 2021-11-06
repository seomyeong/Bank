package banking.domain;

import banking.exception.CheckingOverdrawnException;
import banking.exception.OverdrawnException;

public class CheckingAccount extends Account {

	private double overdraftAmount; //마통초기금액

	public CheckingAccount(double initBalance, double overdraftAmount) {
		super(initBalance);
		this.overdraftAmount=overdraftAmount;
	}


	@Override
	public void withdraw(double amount) throws CheckingOverdrawnException {
		if(balance >= amount) {
			try {
				super.withdraw(amount);
			} catch (CheckingOverdrawnException e) {
				System.out.println(e.getMessage());
			} catch (OverdrawnException e) {
				System.out.println(e.getMessage());
			}
			return;
		}

		double overdraftNeeded =  amount-balance;

		if(overdraftAmount < overdraftNeeded) { //마통한도보다 요구액이 크면
			throw new CheckingOverdrawnException("마이너스통장 출금오류", balance, overdraftAmount);
		}
		balance=0.0;
		overdraftAmount -= overdraftNeeded;
		System.out.println("마이너스통장 출금 : "+amount);
	}

	@Override
	public String toString(){
		return "[CA]";
	}
}
