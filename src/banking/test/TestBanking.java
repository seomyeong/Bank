package banking.test;

import banking.domain.Account;
import banking.domain.Bank;
import banking.domain.CheckingAccount;
import banking.domain.Customer;
import banking.domain.SavingsAccount;
import banking.exception.OverdrawnException;
import banking.exception.CheckingOverdrawnException;

public class TestBanking {
	public static void main(String[] args) {
		Account account;
		Customer customer;
		
		
		

		/*STEP 1 : Bank에 고객등록*/
		System.out.println("*\t은행에 고객을 등록합니다.\t*");
		Bank.addCustomer("유비", "700101-1234567");
		Bank.addCustomer("관우", "700102-1234567");
		Bank.addCustomer("장비", "700103-1234567");
		Bank.addCustomer("조조", "700104-1234567");
		Bank.addCustomer("동탁", "700105-1234567");


		/*STEP 2 : 등록된 고객들의 계좌개설*/
		System.out.println("*\t고객의 계좌를 개설합니다.\t*");


		//유비
		customer=Bank.getCustomer(0);
		customer.addAccount(new SavingsAccount(2000.0, 0.03));
		//관우
		customer=Bank.getCustomer(1);
		customer.addAccount(new SavingsAccount(1700.0, 0.03));
		//장비
		customer=Bank.getCustomer(2);
		customer.addAccount(new SavingsAccount(1000.0, 0.03));
		//조조
		customer=Bank.getCustomer(3);
		customer.addAccount(new SavingsAccount(2000.0, 0.03));
		customer.addAccount(new CheckingAccount(2000.0, 1000.0));
		//동탁
		customer=Bank.getCustomer(4);
		customer.addAccount(new SavingsAccount(5000.0, 0.05));
		customer.addAccount(new CheckingAccount(1500.0, 1500.0));

		/*STEP 3 : 등록된 고객들의 개인정보 조회*/
		System.out.println("\n*\t은행에 등록된 고객들의 정보를 조회합니다.\t*");
		for(int i=0; i<Bank.getNumOfCustomers(); i++) {
			customer=Bank.getCustomer(i);
			System.out.println();

			for(int j=0; j<customer.getNumOfAccounts(); j++) {
				account=customer.getAccount(j);
				System.out.print(customer.getName()+"\t"+customer.getSsn()+"\t");
				System.out.print(account+"통장 : "+account.getBalance()+"원\n");
			}
		}

		/*STEP 4 : 계좌출금 및 잔고조회
		 * 조조 계좌에서 500원씩 5번 출금 후 최종잔고 조회*/
		System.out.println("\n*\t조조계좌 출금 및 잔고조회\t*");
		customer=Bank.getCustomer(3); //조조
		for(int i=0; i<customer.getNumOfAccounts(); i++) {
			account=customer.getAccount(i);
			System.out.println();

			for(int j=0; j<5; j++) {
				System.out.print(customer.getName()+"님 ");
				try {
					account.withdraw(500);
				} catch (CheckingOverdrawnException e) {
					System.out.println(e.getMessage());
				} catch (OverdrawnException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("\t---> 잔액 : "+account.getBalance());
			}
		}


		/*STEP 5 : Checking계좌출금 및 잔고조회
		 * 조조 계좌에서 500원씩 3번 출금 후 최종잔고 조회*/
		System.out.println("\n*\t조조 Checking계좌 출금 및 잔고조회\t*");
		customer=Bank.getCustomer(3); //조조
		for(int i=0; i<customer.getNumOfAccounts(); i++) {
			account=customer.getAccount(i);

			if(account instanceof CheckingAccount) { //CheckingAccount로 형변환검사
				System.out.println();

				for(int j=0; j<3; j++) {
					System.out.print(customer.getName()+"님 ");
					try {
						account.withdraw(500);
					} catch (CheckingOverdrawnException e) {
						System.out.println(e.getMessage());
					} catch (OverdrawnException e) {
						System.out.println(e.getMessage());
					}
					System.out.println("잔액 : "+account.getBalance());
				}
			}
		}



	}//end of main
}//end of class
