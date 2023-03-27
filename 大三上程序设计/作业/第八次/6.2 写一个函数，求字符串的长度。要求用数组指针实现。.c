#include<stdio.h>
/*写一个函数int slen(char *s)，返回值为字符串s的长度。
要求在主函数中输入一个长度不大于20的字符串，调用函数slen，输出字符串对应的长度。
输入：
hello world
输出：
11（空格算作有效字符）*/

int slen(char* s){
	int len =0;
	while(s[len]!=0){
		len++;
	}
	return len;
}

int main(){
	char str[21]={0};
	gets(str);
	printf("%d",slen(str));
	return 0;
}
