import java.util.ArrayList;

//Rule 1= Replace any instance of 's' or 'S' with 5
//Rule 2= if length is odd and middle char is is a digit , replace the midle char with double its value
//Rule 3= if length is even swap first and last character and  flip their capitalization
//Rule 4 = "NextCapital" upper or lower combination, reverse the char of word next , case should be preserved
public class MyPass {
    public static String apply1(String password) {
        String result = "";
        if (password.contains("s")) {
            result = password.replace('s', '5');

        } else {
            result = password.replace('S', '5');
        }
        return result;
    }

    public static String apply2(String password) {
        String result = "";
        int lastIndex = password.length() - 1;

        char midchar = password.charAt(lastIndex / 2);
        if (Character.isDigit(midchar)) {
            int val = Integer.parseInt(Character.toString(midchar));
            val *= 2;
            String value = String.valueOf(val);
            CharSequence cs = value;
            CharSequence csToRep = Character.toString(midchar);
            result = password.replace(csToRep, cs);
        } else {
            return password;
        }
        return result;
    }

    public static String apply3(String password) {
        String result = new String();
        int startIndex = 0;
        int lastIndex = password.length() - 1;

        char startChar = password.charAt(startIndex);
        char lastChar = password.charAt(lastIndex);

        char newLastChar;
        char newFirstChar;

        if (Character.isUpperCase(startChar)) {
            newFirstChar = Character.toLowerCase(startChar);
        } else {
            newFirstChar = Character.toUpperCase(startChar);
        }
        if (Character.isUpperCase(lastChar)) {
            newLastChar = Character.toLowerCase(lastChar);
        } else {
            newLastChar = Character.toUpperCase(lastChar);
        }

        String subString = password.substring(startIndex + 1, lastIndex);
        result = newLastChar + subString + newFirstChar;
        return result;
    }

    public static String apply4(String password) {
        String result = new String();
        String regEx = "[n|N][e|E][x|X][t|T]";

        int index = password.toLowerCase().indexOf("next");
        StringBuilder pass = new StringBuilder(password.substring(index, index + 4));
        String reverse = pass.reverse().toString();

        result = password.replaceFirst(regEx, reverse);
        return result;
    }

    static String[] strenthenPAss(String[] passwords) {
        ArrayList<String> resultList = new ArrayList<String>();
        for (String password : passwords) {
            if (password.length() != 0) {
                if (password.contains("s") || password.contains("S")) {
                    password = apply1(password);
                }
                if ((password.length()) % 2 != 0) {
                    password = apply2(password);
                }
                if ((password.length()) % 2 == 0) {
                    password = apply3(password);
                }
                if (password.toLowerCase().contains("nextcapital")) {
                    password = apply4(password);
                }

            }
            resultList.add(password);
        }
        String[] resultArray = resultList.toArray(new String[resultList.size()]);
        return resultArray;
    }

    public static void main(String[] args) {
        String[] A = {"ThreeSThree", "Doge", "GoCardinals", "nExTcapITalxnextcapital"};
        String[] B = strenthenPAss(A);
        for (int i = 0; i < B.length; i++) {
            System.out.println(B[i]);
        }
    }
}
