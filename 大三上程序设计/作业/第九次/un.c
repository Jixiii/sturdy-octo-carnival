#include<stdio.h>
/*编写建立链表的函数creat,输出链表的函数print,删除链表的函数del,插入结点的函数insert,再编写一个主函数，
先后调用这些函数。用以上5个函数组成一个程序，实现链表的建立、输出、删除和插入，
在主函数中指定需要删除和插入的结点的数据。
格式要求：
1.链表的数据域存放5个学生的学号和成绩，输入格式如下：
1801 91
1802 71
1803 88
1804 87
1805 91
2.先插入结点，插入在第一个结点之后，学号为：2019,成绩为88（请在程序内直接给定）；
3.删除的结点，结点位置在第2个结点之后。
输出格式如下(成绩保留小数点后两位)：
after creat:
student number:1801 score:91.00
student number:1802 score:71.00
student number:1803 score:88.00
student number:1804 score:87.00
student number:1805 score:91.00

after insert:
student number:1801 score:91.00
student number:2019 score:88.00
student number:1802 score:71.00
student number:1803 score:88.00
student number:1804 score:87.00
student number:1805 score:91.00

after delete:
student number:1801 score:91.00
student number:2019 score:88.00
student number:1803 score:88.00
student number:1804 score:87.00
student number:1805 score:91.00*/

typedef struct no_de{
	Node nextnode;
	int xuehao;
	int chengji;
}Node;



int main(){
	
	return 0;
}
