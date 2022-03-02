package exercicos;

public class Main {

	public static void main(String[] args) {
		
		
		double quadrado = Quadrilatero.area(3);
		System.out.println("Área do retângulo: " + quadrado);
		
		double retangulo = Quadrilatero.area(3, 5);
		System.out.println("Área do retângulo: " + retangulo);
		
		double trapezio = Quadrilatero.area(3, 7, 9);
		System.out.println("Área do retângulo: " + trapezio);
		
		float losango = Quadrilatero.area(3, 9);
		System.out.println("Área do retângulo: " + losango);

	}

}
