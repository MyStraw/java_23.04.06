package BaekJoon.notyet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _6841_I_Speak_TXTMSG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> trans = new HashMap<>();
       
        trans.put("CU", "see you");
        trans.put(":-)", "I’m happy");
        trans.put(":-(", "I’m unhappy");
        trans.put(";-)", "wink");
        trans.put(":-P", "stick out my tongue");
        trans.put("(~.~)", "sleepy");
        trans.put("TA", "totally awesome");
        trans.put("CCC", "Canadian Computing Competition");
        trans.put("CUZ", "because");
        trans.put("TY", "thank-you");
        trans.put("YW", "you’re welcome");
        trans.put("TTYL", "talk to you later");

        while (true) {
            String input = sc.nextLine();
            
            if (trans.containsKey(input)) {
                System.out.println(trans.get(input));
                if ("TTYL".equals(input)) {
                    break;
                }
            } else {
                System.out.println(input);
            }
        }
       
    }

}
