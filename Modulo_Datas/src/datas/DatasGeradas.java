package datas;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatasGeradas {

	
	public static void main(String[] args) throws ParseException {
		
		Date dataInicial = new SimpleDateFormat("dd/MM/yyyy").parse("27/01/2022");
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dataInicial);
		
		
		for(int parcela = 1; parcela <= 12; parcela++) {
			calendar.add(Calendar.MONTH, 1);
			
			System.out.println("Parcela de n�mero: " + parcela + " vencimento � em " + 
			new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime()));
		}
		
	}
}
