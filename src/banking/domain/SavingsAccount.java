package banking.domain;

public class SavingsAccount extends Account {

	private double interestRate;

	public SavingsAccount(double initBalance, double interestRate) {
		super(initBalance);
		this.interestRate=interestRate;
	}

	//이율계산
	public void accumulateInterest() {
		balance+=(balance*interestRate);
	}
	
	@Override
	public String toString(){
		return "[SA]";
	}
}
