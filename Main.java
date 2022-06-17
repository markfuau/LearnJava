package mark.leetCode;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        try {
            ArrayList<String> strings = new ArrayList<>();
            strings.add("[]");
            strings.add("[]{}");
            strings.add("{[]}");
            strings.add("[}");
            strings.add("[]}");

            System.out.println(isValid(strings.get(0)));
            System.out.println(isValid(strings.get(1)));
            System.out.println(isValid(strings.get(2)));
            System.out.println(isValid(strings.get(3)));
            System.out.println(isValid(strings.get(4)));
        }
        catch ( Exception e){
            System.out.println("Something went wrong.");
        }

    }

    public static boolean isEven(String str){
        return str.length() % 2 == 0 && str.length() != 0;
    }
    public static boolean isValid(String s){
        s = s.strip();

        // if the string length is even
        if(isEven(s)){
            // check if continuous 2 chars are in pair
            if(isContinuousAsymmetric(s))
                return true;
            // else judge if string is centrosymmetric
            if(isCentrosymmetric(s))
                return true;
            else return false;

        }
        else return false;
    }

    public static boolean isCentrosymmetric(String str){
        int half = str.length()/2;
        String first = str.substring(0,half);
        String second = str.substring(half);

        for (int i = 0; i < half; i++) {
            if(!isPair(first.charAt(i), second.charAt(half-1-i)))
                return false;
        }
        return true;
    }

    public static boolean isContinuousAsymmetric(String evenStr){
        for (int i = 0; i < evenStr.length(); i=i+2) {
            if(!isPair(evenStr.charAt(i),evenStr.charAt(i+1))) return false;

        }

        return true;
    }
    public static boolean isPair(char a, char b){
        if(a=='(' && b ==')') return true;
        if(a =='[' && b ==']') return true;
        return a == '{' && b == '}';
    }
}

