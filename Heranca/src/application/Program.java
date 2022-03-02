package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {
	public static void main(String[] args) {
		
		/*
		 * Account não pode ser intanciada porque, a classe esta como abstract
		
		Account acc1 = new Account(10, "Alex", 1000.0);
		Account acc2 = new SavingsAccount(102, "Bob", 1000.0, 0.01);
		Account acc3 = new BusinessAccount(103, "Maria", 1000.0, 500.0); */
		Locale.setDefault(Locale.US);
		List<Account> list = new ArrayList<Account>();
		list.add(new SavingsAccount(1002, "Re", 1000.0, 200.0));
		list.add(new BusinessAccount(12, "Fer", 3000.0, 500.0));
		list.add(new SavingsAccount(1543, "Lele", 4000.0, 0.01));
		list.add(new BusinessAccount(15434, "Fafa", 500.0, 500.0));
		
		//soma o total das contas
		double sum = 0;
		for(Account acc : list) {
			sum += acc.getBalance();
		}	
		
		System.out.printf("Total balance: %.2f%n", sum);
		
		//deposita 10 em todas as contas
		for (Account account : list) {
			account.deposit(10.0);
		}
		
		//mostra as contas atualizadas
		for (Account account : list) {
			System.out.printf("Updated balance for account %d: %.2f%n", account.getNumber(), account.getBalance());
		}
		
		
		/*
		Account acc = new Account(1001, "Alex", 0.0);
		BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);
		
		//upcasting
		Account acc1 = bacc;
		Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
		Account acc3 = new SavingsAccount(1004, "Ana", 0.0, 0.01);
		
		
		//DOWNCASTING
		BusinessAccount acc4 = (BusinessAccount) acc2;
		acc4.loan(100.0);
		
//		BusinessAccount acc5 = (BusinessAccount) acc3;
		if(acc3 instanceof BusinessAccount) {
			BusinessAccount acc5 = (BusinessAccount) acc3;
			acc5.loan(200.0);
			System.out.println("Loan!");
		}
			
		if(acc3 instanceof SavingsAccount) {
			SavingsAccount acc5 = (SavingsAccount) acc3;
			acc5.updateBalance();
			System.out.println("update!");
		}
		
		Account ac1 = new Account(1008, "Alex", 1000.0);
		ac1.withDraw(200.0);
		System.out.println(ac1.getBalance());
		
		Account ac2 = new SavingsAccount(1009, "Maria", 1000.0, 0.01);
		ac2.withDraw(200.0);
		System.out.println(ac2.getBalance());
		
		Account ac3 = new BusinessAccount(190, "Bob", 1000.0, 500.0);
		ac3.withDraw(200.0);
		System.out.println(ac3.getBalance());
		
	}*/
	}
}
