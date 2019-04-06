public class EditDistance {

    public static void main(String[] args) {
        String s1 = "ABCXZ";
        String s2 = "BCXAZ";
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        System.out.println("Edit Distance is : " + printDistance(c1,c2));
    }

    public static int printDistance(char[] c1,char[] c2){
        int row = c1.length;
        int col = c2.length;

        if(row == 0) return col;
        if(col == 0) return row;

        int[][] array = new int[row + 1][col + 1];


        for(int i = 0; i<= row; i++){

            for(int j = 0; j<= col; j++){

                if(i == 0 && j == 0)
                    array[i][j] = 0;
                else if(i == 0 && j != 0)
                    array[i][j] = j;
                else if(i != 0 && j == 0)
                    array[i][j] = i;
                else if(c1[i - 1] == c2[j - 1])
                    array[i][j] = array[i - 1][j - 1];
                else array[i][j] = 1 +  Math.min(array[i - 1][j - 1],Math.min(array[i - 1][j],array[i][j-1]));
            }
        }
        return array[row][col];

    }
}