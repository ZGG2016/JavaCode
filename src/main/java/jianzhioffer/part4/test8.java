package jianzhioffer.part4;

public class test8 {

    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        // '.'������
        int pointCount = 0;
        // �Ƿ�������'E'����'e'
        boolean isMeetE = false;
        for (int i = 0; i < str.length; i++) {
            if(str[i] == 'e' || str[i] == 'E') {
                // ����Ѿ�����e������������e������e���������λ�ã�����false
                if (isMeetE == true || i == str.length - 1) {
                    return false;
                } else {
                    isMeetE = true;
                    continue;
                }
            }

            // ���ַ��Ƿ���0~9֮������Ƿ�Ϊe
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

            // ����E֮ǰ
            if(!isMeetE) {
                // ��E֮ǰ���±�0������+=��
                if (i != 0 && (str[i] == '+' || str[i] == '-')) {
                    return false;
                }
                // E֮ǰ.����>1��
                if (str[i] == '.' && ++pointCount > 1) {
                    return false;
                }
            } else {
                // E֮�����'.'�ķ���false
                if(str[i] == '.') {
                    return false;
                }
            }
        }
        return true;
    }
}
