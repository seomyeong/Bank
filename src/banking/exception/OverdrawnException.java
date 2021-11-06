package banking.exception;

public class OverdrawnException extends Exception {
	private double balance;
	
	public OverdrawnException(String msg, double balance){
		super(msg);
		this.balance = balance;
	}
	
	@Override
	public String getMessage(){
		return super.getMessage()+"\n[\t현재 잔고는 "+balance+"원 입니다.\t]";
	}
}
