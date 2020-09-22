package jianzhioffer.part3;

public class test12 {

    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0) return "";
        StringBuilder sb1 = new StringBuilder(str.substring(0, n));
        StringBuilder sb2 = new StringBuilder(str.substring(n, str.length()));
        sb2.append(sb1);
        return sb2.toString();
    }
}
