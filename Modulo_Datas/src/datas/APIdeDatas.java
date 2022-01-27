package datas;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class APIdeDatas {
	
	public static void main(String[] args) {
		
		//nova api de data apartir do java 8
		 LocalDate ldNow = LocalDate.now();
		    System.out.println(ldNow);
		    
		    LocalDate ld = LocalDate.of(1990, Month.AUGUST, 6);
		    System.out.println(ld);
		    LocalDate ld2 = ld.plusWeeks(2).plusDays(1).minusMonths(1);
		    System.out.println(ld2);
		    
		    // LocalTime - representa uma hora: 11:40:00
		    LocalTime ltNow = LocalTime.now();
		    System.out.println(ltNow);
		    LocalTime lt = LocalTime.of(11, 10, 01, 100000);
		    System.out.println(lt);
		    
		    // LocalDateTime - representa data+hora:
		    // 06/08/1990 11:40:00
		    LocalDateTime ldtNow = LocalDateTime.now();
		    System.out.println(ldtNow);
		    LocalDateTime ldt = LocalDateTime.of(ld, lt);
		    System.out.println(ldt);
		    
		    // Instant - representa um instante/momento na
		    // linha do tempo (milissegundos a partir de 
		    // 01/01/1970 00:00:00
		    // 06/08/1990 11:40:00 GMT/UTC
		    Instant iNow = Instant.now();
		    System.out.println(iNow);
		    Instant i = Instant.ofEpochMilli(500000000000L);
		    System.out.println(i);
		    Instant plus = i.plus(1, ChronoUnit.MONTHS);
		    System.out.println(plus);
		
	}

}
