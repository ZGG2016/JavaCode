package JianZhiOffer.part2;

import java.util.Arrays;

public class test8 {
    //������ع��ص�˼�룺
    //��һ��������Ϊ��һ��ʿ��������أ�count = 1��
    //������ͬԪ�أ�count++;
    //��������ͬԪ�أ���Ϊ���ˣ�ͬ���ھ�,count--��������countΪ0������������µ�iֵ��Ϊ����ص�ʿ����
    // ������ȥ���������������ϵ�ʿ�����п�������Ԫ�ء�
    //�ټ�һ��ѭ������¼���ʿ���ĸ������Ƿ��������һ�㼴��
    public int MoreThanHalfNum_Solution1(int [] array) {
        int len = array.length;
        if(len == 0) return 0;

        int rlt = array[0];
        int time = 1;
        for(int i=1;i<len;i++){

            if(time==0){
                rlt = array[i];
                time=1;
            }else{
                if(rlt==array[i]){
                    time++;
                }else{
                    time--;
                }
            }
        }

        time=0;
        for(int i=0;i<len;i++){
            if(rlt==array[i]){
                time++;
            }
        }

        if(time*2<=len){
            rlt=0;
        }

        return rlt;
    }

    //���������������������������ڣ���һ���������м��Ǹ���
    public int MoreThanHalfNum_Solution2(int [] array) {
        Arrays.sort(array);
        int count=0;

        for(int i=0;i<array.length;i++){
            if(array[i]==array[array.length/2]){
                count++;
            }
        }
        if(count>array.length/2){
            return array[array.length/2];
        }else{
            return 0;
        }

    }
}