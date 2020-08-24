package JianZhiOffer.part4;

public class test8 {

    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        // '.'的数量
        int pointCount = 0;
        // 是否遇到过'E'或者'e'
        boolean isMeetE = false;
        for (int i = 0; i < str.length; i++) {
            if(str[i] == 'e' || str[i] == 'E') {
                // 如果已经遇过e现在又遇到了e，或者e出现在最后位置，返回false
                if (isMeetE == true || i == str.length - 1) {
                    return false;
                } else {
                    isMeetE = true;
                    continue;
                }
            }

            // 看字符是否在0~9之间或者是否为e
            if((str[i] > '9' || str[i] < '0') && (str[i] != 'e' || str[i] != 'E')) {
                if (str[i] == '+' || str[i] == '-' || str[i] == '.') {
                    if (str[i] == '.' && pointCount > 1) {
                        return false;
                    } else if((str[i] == '+' || str[i] == '-') && i != 0 && !isMeetE) {
                        return false;
                    }
                } else {
                    return false;
                }
            }

            // 遇到E之前
            if(!isMeetE) {
                // 在E之前，下标0后遇到+=的
                if (i != 0 && (str[i] == '+' || str[i] == '-')) {
                    return false;
                }
                // E之前.数量>1的
                if (str[i] == '.' && ++pointCount > 1) {
                    return false;
                }
            } else {
                // E之后存在'.'的返回false
                if(str[i] == '.') {
                    return false;
                }
            }
        }
        return true;
    }
}
