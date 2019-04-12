import java.util.Scanner;

public class LIS {
    public static void main(String[] args) {
        Scanner  in = new Scanner(System.in);
        System.out.print("Enter the number of element: ");
        int numOfElement = in.nextInt();
        System.out.println();
        System.out.print("Enter the elements of the array: ");
        int[] array = new int[numOfElement];
        for(int i = 0; i<numOfElement; i++){
            array[i] = in.nextInt();
        }
        System.out.println();

        int row = numOfElement + 1;
        int col = numOfElement;

        int[][] dp = new int[row][col];
        for(int i = 0; i<row; i++){
            for (int j = 0; j<col; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 1;
                else if(j >= i && array[i - 1] < array[j]){
                    dp[i][j] = dp[i][i - 1] + 1;
                }

                else dp[i][j] = dp[i - 1][j];
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Ans is : " + dp[row - 1][col - 1]);
    }
}
