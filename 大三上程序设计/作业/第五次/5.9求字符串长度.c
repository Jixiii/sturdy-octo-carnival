#include<stdio.h>
/*题目内容：
编写程序，输入可能带空格的字符串，计算并输入其长度（即字符个数，含空格数）。字符串最大长度不超过100。
使用字符数组实现，不使用字符串库函数。
输入:可能带空格的字符串。
输出：一个非负整数，字符串的长度。
样例输入：
I like C++.
样例输出：
11*/
int main(){
	char input[1000]={0};
	gets(input);
	int lenth = 0;
	while(input[lenth]){
		lenth++;
	}
	printf("%d",lenth);
	return 0;
}
