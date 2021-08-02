package ExerciciosRecursivos;
//DAVI COSTA BARROSO
public class Fibonacci {

	public static void main(String[] args) {
		int fib = fibonacci(3);
		System.out.println("Resultado: "+ fib);
	}
	
	public static int fibonacci(int n) {
		if (n <= 1) return n;
		else return fibonacci(n-1) + fibonacci(n-2);
	}
}
