package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entities.Employees;

public class Program {

	/*
	 * interface comparable => serve para definir na classe como um 
	 * objeto é comparado com outro
	 */
	
	
	public static void main(String[] args) {
		
		

		List<Employees> list = new ArrayList<Employees>();
		String path = "C:\\in.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String employeeCSV = br.readLine();
			while (employeeCSV != null) {
				String[] fields = employeeCSV.split(",");
				list.add(new Employees(fields[0], Double.parseDouble(fields[1])));
				employeeCSV = br.readLine();
			}
			Collections.sort(list);
			for (Employees s : list) {
				System.out.println(s.getName() + "," + s.getSalary());
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
