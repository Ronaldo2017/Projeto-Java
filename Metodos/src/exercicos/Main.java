package exercicos;

public class Main {

	public static void main(String[] args) {
		
		
		double quadrado = Quadrilatero.area(3);
		System.out.println("�rea do ret�ngulo: " + quadrado);
		
		double retangulo = Quadrilatero.area(3, 5);
		System.out.println("�rea do ret�ngulo: " + retangulo);
		
		double trapezio = Quadrilatero.area(3, 7, 9);
		System.out.println("�rea do ret�ngulo: " + trapezio);
		
		float losango = Quadrilatero.area(3, 9);
		System.out.println("�rea do ret�ngulo: " + losango);

	}

}
