package ocjp.gold.mysecue;

import java.text.Normalizer;
import java.text.Normalizer.Form;

public class Secure {
    public static void main(String[] args) {
        String de = "\u3066\u3099";
        System.out.println(de); // て?
        System.out.println(de.length()); // 2
        
        String result = Normalizer.normalize(de, Form.NFKC);
        System.out.println(result); // で
        System.out.println(result.length()); // 1
    }
}
