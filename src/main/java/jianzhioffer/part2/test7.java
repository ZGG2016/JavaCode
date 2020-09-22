package jianzhioffer.part2;

public class test7 {

    //ASCII�룺
    //��48��57��Ϊ0��9ʮ�����������֣�65��90��Ϊ26����дӢ����ĸ��97��122��Ϊ26��СдӢ����ĸ��

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
