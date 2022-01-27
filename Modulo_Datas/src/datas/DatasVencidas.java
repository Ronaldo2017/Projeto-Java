package datas;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DatasVencidas {
	
	public static void main(String[] args) throws ParseException {
	
		//Date dataPassada = new SimpleDateFormat("dd/MM/yyyy").parse("27/01/2022");
		
		long dias = ChronoUnit.DAYS.between(LocalDate.parse("01/01/2022"), LocalDate.now());
		
		System.out.println(dias);
	}
	
	
}
