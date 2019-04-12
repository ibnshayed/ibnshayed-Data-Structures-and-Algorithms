public class StringConcat {
    public static void main(String[] args) {
        String s = "ABCD";
        String s2 = "BC";
        char[] c1 = s.toCharArray();
        char[] c2 = s2.toCharArray();

        for(int i = 0; i<s.length(); i++){
            if(c1[i] == c2[0] || c1[i] == c2[1])
                continue;
            else System.out.print(c1[i]);
        }

    }
}
