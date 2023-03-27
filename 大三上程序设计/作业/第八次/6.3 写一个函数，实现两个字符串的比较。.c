#include<stdio.h>
#include<string.h>
/*写一个函数int strcmp（char *p1, char *p2）用来实现两个字符串的比较。在主函数中输入两个字符串，输出对应的结果。
输入：
hello
world
则输出：-1
输入：
world
hello
则输出1
输入：
hello
hello
则输出：0*/

int mystrcmp(char *p1, char *p2){
	int i;
	int len;
	if(strlen(p1)>strlen(p2)){
		len = strlen(p1);
	}else{
		len = strlen(p2);
	}
	for(i=0;i<len;i++){
		if(p1[i]>p2[i]){
			return 1;
		}else if(p1[i]<p2[i]){
			return -1;
		}
	}
	return 0;
}

int main(){
	char str1[500]={0},str2[500]={0};
	scanf("%s%s",str1,str2);
	printf("%d",mystrcmp(str1,str2));
	return 0;
}
