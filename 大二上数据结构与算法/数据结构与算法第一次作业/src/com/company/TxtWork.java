package com.company;

import java.io.*;

public class TxtWork {
    public static void main(String args[]) {
        MyList myList = new MyList();
        InputStreamReader reader = null;
        try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw

            /* 读入TXT文件 */
            String pathname = "D:\\Javaaaa\\数据结构与算法第一次作业\\src\\testcase.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
            File filename = new File(pathname); // 要读取以上路径的input。txt文件
            reader = new InputStreamReader(new FileInputStream(filename)); // 建立一个输入流对象reader
            StreamTokenizer streamTokenizer = new StreamTokenizer(new BufferedReader(reader));// 建立一个对象，它把文件内容转成计算机能读懂的语言
            //ordinaryChar方法指定字符参数在此标记生成器中是“普通”字符。
            //下面指定-是普通字符
            streamTokenizer.ordinaryChar('-');

            streamTokenizer.eolIsSignificant(true);
            streamTokenizer.whitespaceChars('\r', '\r');
            streamTokenizer.whitespaceChars('\n', '\n');

            //nextToken方法读取下一个Token.
            //TT_EOF指示已读到流末尾的常量。
            while (streamTokenizer.nextToken() != StreamTokenizer.TT_EOF) {
                switch (streamTokenizer.ttype){
                    case StreamTokenizer.TT_EOL:
                        myList.showStructure();
//                        System.out.println("end");
                        break;
                    case StreamTokenizer.TT_WORD:
                        break;
                    default:
                        //如果以上2种类型都不是，则为英文的标点符号
                        switch (String.valueOf((char) streamTokenizer.ttype)){
                            case "+":
                                streamTokenizer.nextToken();
                                myList.insert(streamTokenizer.sval);
                                break;
                            case "-":
                                myList.remove();
                                break;
                            case "=":
                                streamTokenizer.nextToken();
                                myList.replace(streamTokenizer.sval);
                                break;
                            case "#":
                                myList.gotoBeginning();
                                break;
                            case "*":
                                myList.gotoEnd();
                                break;
                            case ">":
                                myList.gotoNext();
                                break;
                            case "<":
                                myList.gotoPrev();
                                break;
                            case "~":
                                myList.clear();
                                break;
                        }
                }
            }
//            myList.showStructure();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}