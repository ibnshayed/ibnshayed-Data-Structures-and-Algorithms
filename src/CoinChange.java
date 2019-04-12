import java.util.Scanner;

public class CoinChange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the total amount : ");
        int amount = in.nextInt();
        System.out.println();

        System.out.print("Enter the number of coins : ");
        int numOfCoin = in.nextInt();
        System.out.println();

        int[] coin = new int[numOfCoin];
        System.out.print("Enter the coins : ");
        for(int i = 0; i<numOfCoin; i++)
            coin[i] = in.nextInt();
        System.out.println();

        int row = numOfCoin + 1;
        int col = amount + 1;

        int[][] dp = new int[row][col];
        for(int i = 0; i<row; i++){
            for (int j = 0; j<col; i++){

            }
        }
    }
}
