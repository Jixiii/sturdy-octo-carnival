#include<stdio.h>
/*题目内容：
编写程序，输入字符串（不含空格），保存在字符数组s2中，再将s2中的复制到字符数组s1中，输出s1。
使用字符数组实现，不使用字符串库函数。
字符串最大长度不超过100。
输入:字符串，一行，可能带空格。
输出：字符串
注意：本题的输入和输出是一样的，关键是有没有实现复制！！！
【提示】逐个赋值s2[i]给s1[i]，直到遇到结束符。特别注意在s1末尾加结束符'\0'。
样例1输入：
copy
样例1输出：
copy*/
int main(){
	char input[1000]={0},output[1000]={0};
	gets(input);
	int i = 0;
	while(input[i]){
		output[i]=input[i];
		i++;
	}
	printf("%s",output);
	return 0;
}
