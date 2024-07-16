package model.entities;

import model.exceptions.DomainException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;

	public Account(int number, String holder, Double balance) {

		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = 300.00;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Integer getNumber() {
		return number;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void deposit(Double amount) {
		this.balance += amount;
	}
	
	public void withdraw(Double amount) {
		
		if(balance < amount) {
			throw new DomainException("Not enough balance");
		}
		else if(amount > withdrawLimit) {
			throw new DomainException("The amount exceeds withdraw limit");
		}
		else {
			this.balance -= amount;
		}
		
	}
	
	public String toString() {
		return "Number: "
				+ this.number 
				+ ", Holder: "
				+ this.holder 
				+ ", Balance: "
				+ this.balance 
				+ ", Withdraw limit: "
				+ this.withdrawLimit;
				
	}
	
}
