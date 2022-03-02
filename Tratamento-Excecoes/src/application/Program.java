package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("Room: ");
			int number = sc.nextInt();
			System.out.println("Check-in date (dd/MM/yyyy)");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("Check-out date (dd/MM/yyyy)");
			Date checkOut = sdf.parse(sc.next());
	
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
	
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.println("Check-in date (dd/MM/yyyy)");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check-out date (dd/MM/yyyy)");
			checkOut = sdf.parse(sc.next());
	
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		
		}catch(ParseException e) {
			System.out.println("Invalid date format!");
		}catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}catch(RuntimeException e) {
			System.out.println("Unexpected error!");
		}
	}

}

/*
 * public static void method2() { System.out.println("METODO 2 START"); Scanner
 * sc = new Scanner(System.in); /* try { String[] vect =
 * sc.nextLine().split(" "); int position = sc.nextInt();
 * System.out.println(vect[position]); } catch (ArrayIndexOutOfBoundsException
 * e) { System.out.println("Invalid position!"); } catch (InputMismatchException
 * e) { System.out.println("Input error"); }
 * System.out.println("End of program");
 */

/*
 * File file = new File("C:\\temp\\in.txt"); Scanner sc1 = null; try { sc1 = new
 * Scanner(file); while (sc1.hasNextLine()) {
 * System.out.println(sc1.nextLine()); } } catch (IOException e) {
 * System.out.println("Error opening file: " + e.getMessage()); } finally { if
 * (sc1 != null) { sc1.close(); } System.out.println("Bloco finally executado");
 * }
 */
