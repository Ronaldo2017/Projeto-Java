package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {
	
	private Double pricePerDay;
	private Double pricePerHour;
	
	private TaxService taxServices;

	public RentalService(Double pricePerDay, Double pricePerHour, TaxService taxServices) {
		this.pricePerDay = pricePerDay;
		this.pricePerHour = pricePerHour;
		this.taxServices = taxServices;
	}
	
	public void processInvoice(CarRental carRental) {
		long t1 = carRental.getStart().getTime();//pega o valor em milisegundo
		long t2 = carRental.getFinish().getTime();		
		double hours = (double) (t2 - t1) / 1000 / 60 / 60;
		double basicPayment ;
		if(hours <= 12) {
			basicPayment = Math.ceil(hours) * pricePerHour;
		}else {
			basicPayment = Math.ceil(hours / 24) * pricePerDay;
		}
		
		//calcula valor do imposto
		double tax = taxServices.tax(basicPayment);
		
		carRental.setInvoice(new Invoice(basicPayment, tax));
	}

}
