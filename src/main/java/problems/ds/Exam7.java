package problems.ds;

import java.util.HashMap;
import java.util.Map;

class B1 {
    public B1() {
    }

    private int a = 10;
    /**
     * Line A
     **/
    protected int b = 30;

    protected void sum() {
        new B1().get();
    }

    private void get()   /**Line B**/
    {
        System.out.println(a + b);
    }
}

class B2 extends B1 {
    protected int c = 10;

    protected void add() {
        sum();   /**Line C**/
    }

    final public void Hacker( ) { }
    public static final void Hacker1( ) { }


}

public class Exam7 {
    static String strVal;
    public static void main(String[] args)
    {
        Exam7 h1 = new Exam7();
        strVal = h1.getString("Program");
        System.out.print(" "+strVal);
    }

    public static String getString(String str){

        StringBuffer strBuf = new StringBuffer(str.length());

        for(int i=str.length() -1 ; i>0;i--)
        {
            strBuf.append(str.charAt(i));
        }
        return strBuf.toString();
    }
}
