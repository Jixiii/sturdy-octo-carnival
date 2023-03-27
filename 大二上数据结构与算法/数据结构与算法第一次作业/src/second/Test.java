package second;

import java.math.BigInteger;

public class Test {
    public static void main(String[] args) {
        MyBigInteger myBigInteger1 = new MyBigInteger("999");
        MyBigInteger myBigInteger2 = new MyBigInteger("-999");
        MyBigInteger myBigInteger3 = new MyBigInteger("-123");
        MyBigInteger myBigInteger4 = new MyBigInteger("0");
        MyBigInteger myBigInteger5 = new MyBigInteger("35");
        MyBigInteger myBigInteger6 = new MyBigInteger("7");
        //加法
        System.out.println(myBigInteger1+"+"+myBigInteger2+"="+MyBigInteger.add(myBigInteger1,myBigInteger2));
        System.out.println(myBigInteger5+"+"+myBigInteger3+"="+MyBigInteger.add(myBigInteger5,myBigInteger3));
        //减法
        System.out.println(myBigInteger1+"-"+myBigInteger2+"="+MyBigInteger.subtract(myBigInteger1,myBigInteger2));
        System.out.println(myBigInteger4+"-"+myBigInteger6+"="+MyBigInteger.subtract(myBigInteger4,myBigInteger6));
        //乘法
        System.out.println(myBigInteger1+"*"+myBigInteger4+"="+MyBigInteger.multiplication(myBigInteger1,myBigInteger4));
        System.out.println(myBigInteger5+"*"+myBigInteger6+"="+MyBigInteger.multiplication(myBigInteger5,myBigInteger6));
        //除法
        System.out.println(myBigInteger4+"/"+myBigInteger1+"="+MyBigInteger.multiplication(myBigInteger4,myBigInteger1));
        System.out.println(myBigInteger5+"/"+myBigInteger6+"="+MyBigInteger.multiplication(myBigInteger5,myBigInteger6));

        System.out.println("1/0="+MyBigInteger.division(new MyBigInteger("1"),new MyBigInteger("0")));
    }
}



