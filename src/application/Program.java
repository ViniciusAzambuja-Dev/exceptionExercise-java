package application;

import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter account data");
		
		try {
			System.out.print("Number: ");
			int number = sc.nextInt();
			sc.nextLine(); 
			
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			
			System.out.print("Initial balance: ");
			Double initialBalance = sc.nextDouble();
			
			Account account = new Account(number, holder, initialBalance);
			
			System.out.printf("Withdraw limit: %.2f\n", account.getWithdrawLimit());
			System.out.println();
			
		
			System.out.print("Enter amount for withdraw: ");
			Double amount = sc.nextDouble();
			account.withdraw(amount);
			System.out.println();
			
			System.out.print(account.toString());
		}
		catch(DomainException e) {
			System.out.print("Withdraw error: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.print("Unexpected error");
		}
		
		sc.close();
	}

}
