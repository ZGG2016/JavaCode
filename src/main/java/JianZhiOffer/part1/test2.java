package JianZhiOffer.part1;

public class test2 {

    //https://blog.csdn.net/l_xrui/article/details/51685552
    public String replaceSpace1(StringBuffer str) {
        //�½�һ������
        if(str==null) {
            return null;
        }
        String sti = str.toString();
        char[] strChar = sti.toCharArray();
        StringBuffer stb = new StringBuffer();
        for(int i=0;i<strChar.length;i++){
            if(strChar[i]==' '){
                stb.append("%20");
            }else{
                stb.append(strChar[i]);
            }
        }
        return stb.toString();
    }

    public String replaceSpace2(StringBuffer str){
        //��ԭ�������ϲ���

        if(str==null) {
            return null;
        }
        int oldLen = str.length();
        int numsOfBlank = 0;
        for(int i=0;i<oldLen;i++){
            if(str.charAt(i)==' '){
                numsOfBlank++;
            }
        }
        int lengthOfNewStr = oldLen+2*numsOfBlank;
        int oldIndex = oldLen-1;
        int newIndex = lengthOfNewStr-1;
        str.setLength(lengthOfNewStr);
        for(;oldIndex>=0&&oldIndex<newIndex;oldIndex--){ //��oldIndex==newIndexʱ��û��Ҫ�������滻��
            if(str.charAt(oldIndex)==' '){
                str.setCharAt(newIndex--,'0');
                str.setCharAt(newIndex--,'2');
                str.setCharAt(newIndex--,'%');
            }else{
                str.setCharAt(newIndex--, str.charAt(oldIndex));
            }
        }
            return str.toString();
        }
    }
