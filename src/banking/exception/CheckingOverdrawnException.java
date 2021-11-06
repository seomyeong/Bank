package banking.exception;

public class CheckingOverdrawnException extends OverdrawnException {
	private double overdraftAvail;
	
	public CheckingOverdrawnException(String msg, double balance, double overdraftAvail){
		super(msg, balance);
		this.overdraftAvail = overdraftAvail;
	}
	
	@Override
	public String getMessage(){
		return super.getMessage()+"\n[\t사용 가능한 대월액은 "+overdraftAvail+"원 입니다.\t]";
	}
}
