package com.company;


import java.util.Scanner;

import java.math.*;

    class bigintarray{
        private int flag;//符号，1负0正
        private int length;
        int[]list;
        bigintarray(String input){
            char[]bignum=input.toCharArray();
            length=0;
            flag=0;
            if(bignum[0]=='-')
                length= input.length()-1;//若为负数，数组长度-1
            else
                length=input.length();
            list=new int[length];
            if(bignum[0]=='-') {
                {
                    for(int i=0;i<list.length;i++)
                        list[i]=(int)(bignum[list.length-i]-'0');
                }
                flag=1;
            }//为负时
            else {
                {
                    for(int i=0;i<list.length;i++)
                        list[i]=(int)(bignum[list.length-1-i]-'0');
                }
                flag=0;
            }//为正时
        }
        bigintarray(int length){
            flag=0;
            list=new int[length];
        }
        bigintarray setFlag(int it) {
            flag=it;
            return null;
        }
        int flag() {return flag;}
        int length() {return length;}
        bigintarray put() {
            int templength=0;
            if(list[list.length-1]==0) {
                templength=list.length-1;}
            else
                templength=list.length;
            int[]temp=new int[templength];
            for(int i=0;i<temp.length;i++) {
                temp[i]=list[temp.length-1-i];
            }
            if(flag==1)
                System.out.print('-');//负数相加
            for(int x:temp) {
                System.out.print(x);
            }
            System.out.println();
            return null;
        }
    }

    public class BigNumber implements operation {
        //	BigNumber(){setup();}
//	private void setup() {
//	}
        public void add(bigintarray a, bigintarray b) {
            bigintarray c = new bigintarray(Math.max(a.length(), b.length() + 1));//最大位数即为max.length+1
            int carry = 0;//进位
            for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
                c.list[i] = (a.list[i] + b.list[i] + carry) % 10;
                carry = (a.list[i] + b.list[i] + carry) / 10;
            }//相同位数处的加法
            if (a.length() > b.length()) {
                for (int i = b.length(); i < a.length(); i++) {
                    c.list[i] = (a.list[i] + carry) % 10;
                    carry = (a.list[i] + carry) / 10;
                }
                c.list[c.length()] = carry;//最高进位即为carry
            } else if (a.length() == b.length())
                c.list[a.length()] = carry;
            else {
                c.list[a.length()] = (carry + b.list[a.length()]) % 10;
                carry = (carry + b.list[a.length()]) / 10;
                for (int i = a.length() + 1; i < b.length(); i++) {
                    c.list[i] = (b.list[i] + carry) % 10;
                    carry = (b.list[i] + carry) / 10;
                }
            }
            c.setFlag(a.flag() * b.flag());
            c.put();
        }

        public void minus(bigintarray a, bigintarray b) {
            int borrow = 0;
            bigintarray c = new bigintarray(Math.max(a.length(), b.length()));
            if


        }

        public static void main(String[] args) {
            BigNumber test = new BigNumber();
            Scanner sc1 = new Scanner(System.in);
            Scanner sc2 = new Scanner(System.in);
            String big1 = sc1.next();
            String big2 = sc2.next();
            bigintarray bigIntArray1 = new bigintarray(big1);
            bigintarray bigIntArray2 = new bigintarray(big2);
//		bigIntArray1.put();
//		bigIntArray2.put();
            test.add(bigIntArray1, bigIntArray2);
        }
    }
