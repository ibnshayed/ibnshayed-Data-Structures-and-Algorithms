package Exam;

public class LCS {
    public static void main(String[] args) {
        String s1 = "ABCXA";
        String s2 = "ACBTYA";
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        System.out.println("Longest Common Subsequence is : " + getLCS(c1,c2));
    }
    public static int getLCS(char[] c1,char[] c2){
        int m = c1.length;
        int n = c2.length;
        int[][] L = new int[m + 1][n + 1];

        for(int i = 0; i<=m; i++){
            for(int j = 0; j<=n; j++){
                if(i == 0 || j ==0)
                    L[i][j] = 0;
                else if(c1[i - 1] == c2[j - 1])
                    L[i][j] = L[i - 1][j - 1] + 1;
                else L[i][j] = Math.max(L[i - 1][j],Math.max(L[i - 1][j - 1],L[i][j - 1]));
                System.out.print(L[i][j] + " ");
            }
            System.out.println();
        }
        return L[m][n];
    }

}
