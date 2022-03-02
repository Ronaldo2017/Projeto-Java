package exercicos;

public class emprestimp {

	//static double a;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//emprestar(a);
		
		Emprestimo.calcular(1000.25, Emprestimo.getDuasParcelas());
		Emprestimo.calcular(1000, Emprestimo.getTresParcelas());
		Emprestimo.calcular(1000, 10);

	}
	


	/*public static void emprestar(double a) {
		double valorEmp = 2000;
		double novoValorEmp;
		
		if(valorEmp > 1000) {
			novoValorEmp = valorEmp + (valorEmp * 0.10);
			System.out.println(novoValorEmp);
		}else {
			novoValorEmp = valorEmp;
			System.out.println(novoValorEmp);
		}
	}*/
	
	/**
	 * Classe de exemplo para o exercício da Aula 1 de Métodos.
	 */
	public static class Emprestimo {

	    public static int getDuasParcelas() {
	        return 2;
	    }

	    public static int getTresParcelas() {

	        return 3;
	    }

	    public static double getTaxaDuasParcelas() {

	        return 0.3;
	    }

	    public static double getTaxaTresParcelas() {

	        return 0.45;
	    }

	    public static void calcular(double valor, int parcelas) {

	        if (parcelas == 2) {

	            double valorFinal = valor + (valor * getTaxaDuasParcelas());

	            System.out.println("Valor final do empréstimo para 2 parcelas: R$ " + valorFinal);
	        } else if (parcelas == 3) {

	            double valorFinal = valor + (valor * getTaxaTresParcelas());

	            System.out.println("Valor final do empréstimo para 3 parcelas: R$ " + valorFinal);
	        } else {
	            System.out.println("Quantidade de parcelas não aceita.");
	        }

	    }

	}

}
