#include<stdio.h>
#include <string.h> 
/*【题目描述】
编写程序，输入人名，在屏幕上显示“Hello ”+人名。如
输入：ZhangSan
输出：Hello ZhangSan
注意：第1个字母大写，单词间一个空格，人名中无空格，末尾无标点。对人名，输入什么就输出什么，不需做任何变化。
提示：自学一下字符串和字符数组

【输入输出样例】
输入：
ZhangSan
输出：
Hello ZhangSan*/
int main(){
	char name[20];
	scanf("%s",name);
	printf("Hello %s",name);
	return 0;
}
