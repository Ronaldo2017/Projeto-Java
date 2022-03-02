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
		System.out.println("A soma é: " + result);
		
	}
	
	public static void subtrair(int a, int b) {
		result = a - b;
		System.out.println("A subtração é: " + result);
	}
	
	public static void multiplicar(int a, int b) {
		result = a * b;
		System.out.println("A multiplicação é: " + result);
	}
	
	public static void dividir(int a, int b) {
		result = a / b;
		System.out.println("A divisão é: " + result);
	}

}
