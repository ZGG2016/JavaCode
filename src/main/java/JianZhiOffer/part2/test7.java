package JianZhiOffer.part2;

public class test7 {

    //ASCII码：
    //第48～57号为0～9十个阿拉伯数字；65～90号为26个大写英文字母，97～122号为26个小写英文字母，

    public int StrToInt(String str) {
        if(str.equals("")) return 0;

        int fuhao = 0;
        int sum = 0;
        char[] ch = str.trim().toCharArray();
        if(ch[0]=='-'){
            fuhao=1;
        }
        for(int i=fuhao;i<ch.length;i++){

            if(ch[i]=='+'){
                continue;
            }

            if(ch[i]<48 || ch[i]>57){
                return 0;
            }

            sum = sum*10+(ch[i]-48);
        }
        return sum;
    }
}
