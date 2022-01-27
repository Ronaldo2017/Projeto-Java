package datas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ManipulandoData {
	
	public static void main(String[] args) throws ParseException {
		
		
		Calendar calendar = Calendar.getInstance();//pega data atual
		
		//data vem do BD
		calendar.setTime(new SimpleDateFormat("dd-MM-yyyy").parse("27-01-2022"));
		
		//adiciona ou subtrai os dias
		calendar.add(Calendar.DAY_OF_MONTH, 5);
		
		System.out.println("Somando o dia do mês: " + new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime()));
		
		
		calendar.add(Calendar.MONTH, 5);
		
		System.out.println("Somando o Mês: " + new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime()));
	}

}
