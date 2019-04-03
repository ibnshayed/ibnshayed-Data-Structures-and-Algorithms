import java.util.Arrays;

public class FibonacciNumber {
    // 0 1 1 2 3 5 8 13 21 34
    private  static long[] fibo;

    public FibonacciNumber() {
        fibo = new long[1000];
        Arrays.fill(fibo,-1);
    }

    public static long fibonacciUsingRecursion(int number){

        if(number == 0 || number == 1) return number;
        if(fibo[number] != -1) return fibo[number];
        return fibo[number] = fibonacciUsingRecursion(number - 1) + fibonacciUsingRecursion(number - 2);

    }

    public static long fibonacciUsingLoop(int number){
        long[] f = new long[number+2];
        f[0] = 0;
        f[1] = 1;

        for(int i = 2; i<f.length; i++)
            f[i] = f[i - 1] + f[i - 2];
        return f[number];
    }

    public static void main(String[] args) {

        new FibonacciNumber();

        System.out.println("\nFibonacci using recursion:");
        for(int i = 0; i<= 20; i++){
            System.out.println("Fibonacci of " + i +" is: " + fibonacciUsingRecursion(i));
        }

        System.out.println("\nFibonacci using loop:");
        for(int i = 0; i<= 20; i++){
            System.out.println("Fibonacci of " + i +" is: " + fibonacciUsingLoop(i));
        }

    }
}
