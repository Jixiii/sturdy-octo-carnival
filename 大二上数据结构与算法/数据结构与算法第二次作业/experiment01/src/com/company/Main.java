package com.company;

public class Main {

    public static void main(String[] args) {
        String string = "able was  i  ere  saw  elba";
        TestPalindrome testPalindrome = new TestPalindrome(string);
        System.out.println(testPalindrome.getString()+
                " 递归结果为"+testPalindrome.testPalindromeByStack()+" 栈结果为"+testPalindrome.testPalindromeByStack());
        testPalindrome.setString("");
        System.out.println(testPalindrome.getString()+
                " 递归结果为"+testPalindrome.testPalindromeByStack()+" 栈结果为"+testPalindrome.testPalindromeByStack());
        testPalindrome.setString("1");
        System.out.println(testPalindrome.getString()+
                " 递归结果为"+testPalindrome.testPalindromeByStack()+" 栈结果为"+testPalindrome.testPalindromeByStack());
        testPalindrome.setString("12");
        System.out.println(testPalindrome.getString()+
                " 递归结果为"+testPalindrome.testPalindromeByStack()+" 栈结果为"+testPalindrome.testPalindromeByStack());
        testPalindrome.setString("123");
        System.out.println(testPalindrome.getString()+
                " 递归结果为"+testPalindrome.testPalindromeByStack()+" 栈结果为"+testPalindrome.testPalindromeByStack());
        testPalindrome.setString("12321");
        System.out.println(testPalindrome.getString()+
                " 递归结果为"+testPalindrome.testPalindromeByStack()+" 栈结果为"+testPalindrome.testPalindromeByStack());
        testPalindrome.setString("123321");
        System.out.println(testPalindrome.getString()+
                " 递归结果为"+testPalindrome.testPalindromeByStack()+" 栈结果为"+testPalindrome.testPalindromeByStack());

    }
}
