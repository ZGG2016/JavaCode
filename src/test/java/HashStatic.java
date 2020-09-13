public class HashStatic {
    private static int x=100;

    public static void main(String args[]){
        HashStatic hsl = new HashStatic();
        hsl.x++;

        HashStatic hs2 = new HashStatic();
        hs2.x++;

        hsl = new HashStatic();
        hsl.x++;

        HashStatic.x--;
        System.out.println("x="+x);

    }
}
