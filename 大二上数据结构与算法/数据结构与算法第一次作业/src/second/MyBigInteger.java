package second;

import java.util.Objects;

public class MyBigInteger{
    int signum;     //-1表示负数，0表示0，1表示正数
    int[] mag;      //分位储存该整数
    int length;     //该整数的位数

    @Override
    public String toString() {
        String value;
        switch (this.signum){
            case 0:
                value="0";
                break;
            case -1:
                value = "-";
                for (int i = this.length-1; i >= 0; i--) {
                    value += this.mag[i];
                }
                break;
            default:
                value = "";
                for (int i = this.length-1; i >= 0; i--) {
                    value += this.mag[i];
                }
        }
        return value;
    }


    public MyBigInteger(String string){
        mag = new int[10000];
        if (string=="-0") {
            signum=0;
            length=0;
        } else if (string.charAt(0) == '-') {
            signum = -1;
            for (int i = 0; i < string.length()-1; i++) {
                mag[i] = Character.getNumericValue(string.charAt(string.length()-1-i));
            }
            length = string.length() - 1;
        } else if (string.charAt(0) == '0') {
            signum = 0;
        } else {
            signum = 1;
            for (int i = 0; i < string.length(); i++) {
                mag[i] = Character.getNumericValue(string.charAt(string.length()-1-i));
            }
            length = string.length();
        }
    }


    public MyBigInteger() {
        this.mag = new int[10000];
        this.length=0;
        this.signum=0;
    }


    public boolean isSameSignum(MyBigInteger myBigInteger){
        return this.signum==myBigInteger.signum;
    }


    public static MyBigInteger add(MyBigInteger addend1, MyBigInteger addend2) {
        MyBigInteger result = null;
        if(addend1.isSameSignum(addend2)){
            result = MyBigInteger.absAdd(addend1,addend2);
            result.signum=addend1.signum;
        }else {
            result = MyBigInteger.absSubstrac(addend1,addend2);
            int compare = MyBigInteger.abscompare(addend1, addend2);
            if (compare > 0) {
                result.signum = addend1.signum;
            } else if(compare < 0){
                result.signum = addend2.signum;
            }else {
                result.signum=0;
            }
        }
        return result;
    }


    public static MyBigInteger subtract(MyBigInteger minuend, MyBigInteger subtrahend) {
        MyBigInteger result = null;
        if(!minuend.isSameSignum(subtrahend)){
            result = MyBigInteger.absAdd(minuend,subtrahend);
            result.signum=minuend.signum;
        }else{
            result = MyBigInteger.absSubstrac(minuend, subtrahend);
            int compare = MyBigInteger.abscompare(minuend, subtrahend);
            if (compare > 0) {
                result.signum = minuend.signum;
            } else if(compare < 0){
                result.signum = minuend.signum == 1 ? -1 : 1;
            }else {
                result.signum=0;
            }
        }
        return result;
    }


    public static MyBigInteger absAdd(MyBigInteger addend1, MyBigInteger addend2) {
        if (abscompare(addend1, addend2)<0) {
            return absAdd(addend2, addend1);
        } else {
            MyBigInteger result = new MyBigInteger();
            int carry = 0;
            for (int i = 0; i < addend1.length; i++) {
                int temp = addend1.mag[i] + addend2.mag[i] + carry;
                carry = temp / 10;
                result.mag[i] = temp - carry * 10;
            }
            if (carry != 0) {
                result.mag[addend1.length] = carry;
                result.length = addend1.length + 1;
            } else {
                result.length = addend1.length;
            }
            result.signum = 1;
            return result;
        }
    }


    public static MyBigInteger absSubstrac(MyBigInteger minuend, MyBigInteger substrahend) {
        if (abscompare(minuend, substrahend)<0) {
            return absSubstrac(substrahend, minuend);
        } else if(abscompare(minuend,substrahend)==0){
            return new MyBigInteger();
        } else {
            MyBigInteger result = new MyBigInteger();
            boolean borrowing=false;
            for (int i = 0; i < minuend.length; i++) {
                int temp = minuend.mag[i] - substrahend.mag[i]+(borrowing?-1:0);
                if (temp < 0) {
                    temp += 10;
                    borrowing=true;
                }else {
                    borrowing=false;
                }
                result.mag[i] = temp;
            }
            for(result.length = minuend.length;result.length>0;result.length--){
                if (result.mag[result.length-1]!=0){
                    break;
                }
            }
            result.signum = 1;
            return result;
        }
    }


    public static MyBigInteger multiplication(MyBigInteger multiplier1, MyBigInteger multiplier2) {
        if (multiplier1.signum==0||multiplier2.signum==0){
            return new MyBigInteger();
        }
        MyBigInteger result = new MyBigInteger();
        for (int i = 0; i < multiplier1.length; i++) {
            for (int j = 0; j < multiplier2.length; j++) {
                result.mag[i+j]+=multiplier1.mag[i]*multiplier2.mag[j];
            }
        }
        for(result.length = multiplier1.length+multiplier2.length;result.length>0;result.length--){
            if (result.mag[result.length-1]!=0){
                break;
            }
        }
        result = MyBigInteger.absAdd(result,new MyBigInteger("0"));
        result.signum=multiplier1.isSameSignum(multiplier2)?1:-1;
        return result;
    }


    public static MyBigInteger division(MyBigInteger dividend, MyBigInteger divisor) throws ArithmeticException {
        if (divisor.signum == 0) {
            throw new ArithmeticException("除数不能为0");
        }
        if (dividend.signum == 0) {
            return new MyBigInteger();
        }
        MyBigInteger result = new MyBigInteger();
        MyBigInteger temp = dividend;
        temp.signum = 1;
        while (MyBigInteger.abscompare(temp, divisor) >= 0) {
            temp = MyBigInteger.absSubstrac(temp, divisor);
            result = MyBigInteger.absAdd(result, new MyBigInteger("1"));
        }
        result.signum = dividend.isSameSignum(divisor) ? 1 : -1;
        return result;
    }


    public static int abscompare(MyBigInteger first, MyBigInteger second) {
        if (first.length != second.length) {
            return first.length - second.length;
        } else {
            for (int i = first.length-1;i >-1 ; i--) {
                if (first.mag[i]!=second.mag[i]){
                    return first.mag[i] - second.mag[i];
                }
            }
            return 0;
        }
    }

}
