package JianZhiOffer.part2;

public class test11 {
    //????
    //https://www.nowcoder.com/questionTerminal/bd7f978302044eee894445e244c7eee6

    public static void main(String[] args){
        System.out.println(NumberOf1Between1AndN_Solution(1));
    }
    public static int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for(int i=1;i<=n;i++){
            char[] ch = String.valueOf(i).toCharArray();
            for(int j=0;j<ch.length;j++){
                if(ch[j]=='1'){
                    count++;
                }
            }
        }
        return count;
    }
}
