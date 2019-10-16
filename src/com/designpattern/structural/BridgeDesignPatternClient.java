package com.designpattern.structural;

/**
 * Demonstration of bridge design pattern
 */
public class BridgeDesignPatternClient {
	public static void main(String[] args) {
		Bank icici = new IciciBank(new CurrentAccount());
		Account current = icici.openAccount();
		current.accountType();

		Bank hdfc = new HdfcBank(new SavingAccount());
		Account saving = hdfc.openAccount();
		saving.accountType();
	}
}

/**
 * Abstraction in bridge pattern
 */
abstract class Bank {
	// Composition with implementor
	protected Account account;

	public Bank(Account account) {
		this.account = account;
	}

	abstract Account openAccount();
}

/**
 * Refine abstraction 1 in bridge pattern
 */
class IciciBank extends Bank {

	public IciciBank(Account account) {
		super(account);
	}

	@Override
	Account openAccount() {
		System.out.print("Open your account with ICICI Bank");
		return account;
	}

}

/**
 * Refine abstraction 2 in bridge pattern
 */
class HdfcBank extends Bank {

	public HdfcBank(Account account) {
		super(account);
	}

	@Override
	Account openAccount() {
		System.out.print("Open your account with HDFC Bank");
		return account;
	}

}

/**
 * Implementor for bridge pattern
 */
interface Account {
	Account openAccount();

	void accountType();
}

/**
 * Concrete implementation 1 for bridge pattern
 */
class CurrentAccount implements Account {

	@Override
	public Account openAccount() {
		System.out.println("OPENED: CURRENT ACCOUNT ");
		return new CurrentAccount();
	}

	@Override
	public void accountType() {
		System.out.println("##It is a CURRENT Account##");
	}
}

/**
 * Concrete implementation 2 for bridge pattern
 */
class SavingAccount implements Account {

	@Override
	public Account openAccount() {
		System.out.println("OPENED: SAVING ACCOUNT ");
		return new SavingAccount();
	}

	@Override
	public void accountType() {
		System.out.println("##It is a SAVING Account##");
	}

}
