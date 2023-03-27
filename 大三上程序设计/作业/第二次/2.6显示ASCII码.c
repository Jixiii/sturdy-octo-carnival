#include<stdio.h>
/*题目内容： 编写程序，输入一个字符，
显示该字符及其ASCII的十进制、八进制和十六进制形式。
如输入A，显示A 65 101 41。（十六进制字母用小写） 
输入:一个字符。 
输出：字符及字符的十进制、八进制和十六进制（小写）形式，数据间用一个空格隔开。 
输入样例1： A 
输出样例1： A 65 101 41*/
int main(){
	char input;
	scanf("%c",&input);
	int decimal = (int)input;
	printf("%c %d %o %x",input,(int)input,(int)input,(int)input);
	return 0;
}
