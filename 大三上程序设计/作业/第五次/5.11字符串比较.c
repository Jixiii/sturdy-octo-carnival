#include<stdio.h>
/*【题目描述】
编写程序，输入两个字符串，比较它们的大小(区分大小写)，
若s1＞s2输出1，若s1＜s2输出-1，若s1=s2输入0。字符串用字符数组存放，最大长度不超过20.
输入：两个不带空格的字符串，用空格隔开。
输出：1,0,-1之一
【输入输出样例】
输入：
valid void
输出:
-1
注意，不是使用库函数直接比较。投机取巧记0分。*/
int main(){
	char str1[1000] = {0},str2[1000] = {0};
	scanf("%s%s",str1,str2);
	int i = 0;
	while(str1[i]){
		if(str1[i]<str2[i]){
			printf("-1");
			return 0;
		}else if(str1[i]>str2[i]){
			printf("1");
			return 0;
		}
		i++;
	}
	printf("0");
	return 0;
}
