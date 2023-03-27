#include<stdio.h>
/*题目内容：
编写程序，对输入的若干单词按词典排序，不区分大小写。
要求字符串的比较、复制、大小写转换、排序等工作均用函数实现（注意是自己编写函数，不能用别人写的函数）。
在主函数中输入单词，调用函数排序，在主函数中输出结果。字符串个数不超过100个，每个单词的长度不超过20。
不能使用系统的字符串处理库函数，不能使用标准模板库的类和函数。
输入格式：
两行：第1行为单词个数n，第2行为n个单词，用空格隔开。
输出格式:
n行，每行一个单词。
输入样例：
5
sin cos log exp sqrt
输出样例：
cos
exp
log
sin
sqrt*/

void change(char str[200][50],int x, int y){
	char temp;
	int i;
	for(i = 0;i<50;i++){
		temp = str[y][i];
		str[y][i]=str[x][i];
		str[x][i]=temp;
	}
}

int compare(char str[200][50],int x, int y){
	int i = 0;
	for(i=0;i<50;i++){
		char tempx = str[x][i];
		char tempy = str[y][i];
		/*tempx = str[x][i]>='a'?str[x][i]-'a'+'A':str[x][i];
		tempy = str[y][i]>='a'?str[y][i]-'a'+'A':str[y][i];*/
		if(str[y][i]>='a'){
			tempy = str[y][i]-'a'+'A';
		}else{
			tempy = str[y][i];
		}
		if(str[x][i]>='a'){
			tempx = str[x][i]-'a'+'A';
		}else{
			tempx = str[x][i];
		}
		if(tempx!=tempy){
			return tempx-tempy;
		}
	}
	return 0;
}


int main(){
	int n;
	char str[200][50]={0};
	scanf("%d",&n);
	int i;
	/*
	for(i = 0;i<n;i++){
		scanf("%s",&str[i]);
	}*/
	i=0;
	while(i<n){
		scanf("%s",&str[i]);
		i++;
	}
	int j;
	for(i = 0;i<n-1;i++){
		for(j=0;j<n-1-i;j++){
			if(compare(str,j,j+1)>0){
				change(str,j,j+1);
			}
		}
	}
	for(j = 0;j<n;j++){
		printf("%s\n",str[j]);
	}
	return 0;
}
