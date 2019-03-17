package main;

public class FibonaciNumber {
    // 0 1 1 2 3 5 8 13 21 34

    public static int fibonacciUsingRecursion(int number){

        if(number <= 1) return number;
        else return fibonacciUsingRecursion(number - 1) + fibonacciUsingRecursion(number - 2);
    }

    public static int fibonacciUsingLoop(int number){
        int[] f = new int[number+2];
        f[0] = 0;
        f[1] = 1;

        for(int i = 2; i<f.length; i++)
            f[i] = f[i - 1] + f[i - 2];
        return f[number];
    }

    public static void main(String[] args) {

        System.out.println("Fibonacci using recursion:");
        for(int i = 0; i<= 10; i++){
            System.out.println("Fibonacci of " + i +" is: " + fibonacciUsingRecursion(i));
        }

        System.out.println("\nFibonacci using loop:");
        for(int i = 0; i<= 10 ; i++){
            System.out.println("Fibonacci of " + i +" is: " + fibonacciUsingLoop(i));
        }



    }
}
