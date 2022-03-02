package entities;

public class BusinessAccount extends Account {

	private Double loanLimt;

	public BusinessAccount() {
		super();
	}

	public BusinessAccount(Integer number, String holder, Double balance, Double loanLimt) {
		super(number, holder, balance);
		this.loanLimt = loanLimt;
	}

	public Double getloanLimt() {
		return loanLimt;
	}

	public void setLoanList(Double loanLimt) {
		this.loanLimt = loanLimt;
	}

	public void loan(double amount) {
		if (amount <= loanLimt) {
			balance += amount - 10.0;
		}

	}
	
	@Override
	public void withDraw(double amount) {
		super.withDraw(amount);
		balance -= 2.0;
	}

}
