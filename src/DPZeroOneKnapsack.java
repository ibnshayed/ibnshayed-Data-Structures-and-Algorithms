import java.util.Scanner;

public class DPZeroOneKnapsack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of items: ");
        int numOfItem = in.nextInt();
        System.out.println();
        System.out.print("Enter the number of total weight: ");
        int totalWeight = in.nextInt();
        System.out.println();

        int[] weight = new int[numOfItem+1];
        int[] profit = new int[numOfItem+1];
        int row = numOfItem + 1;
        int column = totalWeight + 1;

        int[][] dp = new int[row][column];
        System.out.println("Enter items weight and profit:");
        for (int i = 0; i<numOfItem+1; i++){
            if(i>0){
                weight[i] = in.nextInt();
                profit[i] = in.nextInt();
            }
            else {
                weight[i] = 0;
                profit[i] = 0;
            }
        }

        for(int i = 0; i<row; i++){
            for (int j = 0; j<column; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(j >= weight[i])
                    dp[i][j] = Math.max(dp[i - 1][j],profit[i] + dp[i - 1][j - weight[i]]);
                else dp[i][j] = dp[i - 1][j];

            }
        }
        System.out.println("Ans is : " + dp[row - 1][column - 1]);


    }
}
