package JianZhiOffer.part1;

public class test8 {
    /*
    * ����������4��
    *       �����һ����һ�ף���ô����Ҫ��3�ף���������3�׾���֮ǰ��3
    *       �����һ�������ף���ô����Ҫ��2��
    *       ����n��������ǰ���n-1�׺�n-2�ף�
    *       ������һ��쳲��������С�
    * */
    public int JumpFloor(int target) {

        if(target==1||target==2) return target;
        int a=1,b=2,c=0;
        for(int i=3;i<=target;i++){
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }
}
