#include<stdio.h>
#include <string.h>
/*输入字符串1和字符串2，
如果两个字符串相同，输出0；
如果字符串1大于字符串2，输出1；
如果字符串1小于字符串2，输出-1。
注意，本题不得使用系统函数。若使用，记0分。比如：
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
int main(){
	char input1[50]={0},input2[50]={0};
	scanf("%s",input1);
	scanf("%s",input2);
	int i = 0;
	for(;i<strlen(input1);i++){
		if(input1[i]>input2[i]){
			printf("1");
			return 0;
		}else if(input1[i]<input2[i]){
			printf("-1");
			return 0;
		}
	}
	printf("0");
	return 0;
}
