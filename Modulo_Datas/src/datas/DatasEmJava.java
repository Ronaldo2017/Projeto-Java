package datas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatasEmJava {

	public static void main(String[] args) throws ParseException {

		
		System.out.println("========= Calendar => novo objeto para instanciar a Data =============");
		
		Calendar calendar = Calendar.getInstance();
		
		Date date = new Date();

		System.out.println("Data: " + date);
		System.out.println("Calendar: " + calendar.get(Calendar.DATE));

		// simple date format
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

		System.out.println("Data atual no formato de string: " + simpleDateFormat.format(date));

		simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm.s");

		System.out.println("Data no formato para banco de dados: " + simpleDateFormat.format(date));

		
		simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("Objeto Date: " + simpleDateFormat.parse("2022-01-27"));
		
		
		
		
		
		
		
		
		
		
	}

}
