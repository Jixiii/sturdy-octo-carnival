package com.company;

public class TestPalindrome {
    private String string;

    public TestPalindrome(String string) {
        this.string = string;
    }
    public TestPalindrome() {
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    boolean testPalindromeByRecursion(){
        return testPalindromeByRecursion(0,string.length()-1);
    }

    boolean testPalindromeByRecursion(int start,int end){
        if(end-start<1){
            return true;
        }
        if (string.charAt(start)==' '){
            return testPalindromeByRecursion(start+1,end);//后移起始下标
        }
        if (string.charAt(end)==' '){
            return testPalindromeByRecursion(start,end-1);//前移终止下标
        }
        if (string.charAt(start)!=string.charAt(end)){
            return false;
        }
        return testPalindromeByRecursion(start+1,end-1);//后移起始下标，前移终止下标
    }

    boolean testPalindromeByStack(){
        MyStack myStack1 = new MyStack();//原始顺序
        MyStack myStack2 = new MyStack();//暂存栈
        MyStack myStack3 = new MyStack();//倒序
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != ' ') {
                myStack1.push(string.charAt(i));
                myStack2.push(string.charAt(i));
            }
        }
        for (int i = 0; i < myStack1.getLength(); i++) {
            myStack3.push(myStack2.pop());//倒序存入
        }
        for (int i = 0; i < myStack1.getLength(); i++) {
            if(myStack1.pop()!=myStack3.pop()){
                return false;
            }
        }
        return true;
    }

}
