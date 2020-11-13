
import java.util.*;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {
        String str = "ABC789D4E4";
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch<48 || ch>57){
                str = str.replace(ch, ' ');
            }
        }
        String[] ss = str.trim().split(" ");
        HashSet<String> hs = new HashSet<>();
        Collections.addAll(hs, ss);
        String[] rlt = hs.toArray(new String[0]);
        for(String s:rlt){
            System.out.println(s);
        }
    }
}
