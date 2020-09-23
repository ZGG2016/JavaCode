import com.google.common.collect.Multiset;
import org.apache.commons.collections.Bag;

import java.util.*;

public class test {
    public static void main(String[] args) {
        String s = "abaad";
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));

        System.out.println(dic);
    }

}
