package stringproblems;

import java.util.ArrayList;
import java.util.List;

public class StringRotation {
    public static void main(String args[]){
        String s1 = "ABCD";
        String s2 = "CDABA";
        boolean isTrue = isStringRotation(s1,s2);
        System.out.println(isTrue);
    }

    private static boolean isStringRotation(String s1, String s2) {
        boolean isRotation = true;
        if (s1.length()!=s2.length()){
            return false;
        }
        String s = s1+s2;
        return s.contains(s2);
    }

}
