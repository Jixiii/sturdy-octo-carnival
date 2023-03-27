#include<stdio.h>
/*输入5个字母，分别统计大写字母和小写字母的个数，要求输入字符用逗号分隔，输入格式如下：
a,A,r,g,R
输出格式如下：
大写字母个数=2
小写字母个数=3
（输入用,分隔，输出之间无空行）*/
int main(){
	char input[100];
	int Bnum=0,Snum=0;
	scanf("%s",input);
	int i;
	for(i = 0;i <strlen(input);i++){
		if(input[i]>='a'&&input[i]<='z'){
			Snum++;
		}else if(input[i]>='A'&&input[i]<='Z'){
			Bnum++;
		}
	}
	printf("大写字母个数=%d\n小写字母个数=%d", Bnum, Snum);
	return 0;
}
