package entities;

public class OutSourcedEmployee extends Employee {

	private Double additionalChage;

	public OutSourcedEmployee() {
		super();
	}

	public OutSourcedEmployee(String name, Integer hours, Double valuePerHour, Double additionalChage) {
		super(name, hours, valuePerHour);
		this.additionalChage = additionalChage;
	}

	public Double getAdditionalChage() {
		return additionalChage;
	}

	public void setAdditionalChage(Double additionalChage) {
		this.additionalChage = additionalChage;
	}
	
	@Override
	public double payment() {
		return super.payment() + additionalChage * 1.1; 
	}

}
