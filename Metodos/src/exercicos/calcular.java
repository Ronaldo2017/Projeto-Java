package exercicos;

public class calcular {

	static int a = 10, b = 5;
	static float result;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		soma(a, b);
		subtrair(a, b);
		multiplicar(a, b);
		dividir(a, b);

	}
	
	public static void soma(int a, int b) {
		result = a + b;
		System.out.println("A soma �: " + result);
		
	}
	
	public static void subtrair(int a, int b) {
		result = a - b;
		System.out.println("A subtra��o �: " + result);
	}
	
	public static void multiplicar(int a, int b) {
		result = a * b;
		System.out.println("A multiplica��o �: " + result);
	}
	
	public static void dividir(int a, int b) {
		result = a / b;
		System.out.println("A divis�o �: " + result);
	}

}
