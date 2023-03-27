#include<stdio.h>
/* 字符串排序，就象单词的字典排序。'a'<'b'等等。
编写函数，实现字符串的排序(从小到大)，不区分大小写。函数原型为：
void sortstring(char **r,int n);
其中r表示字符串首地址数组的首地址，n表示字符串个数。字符串的首地址放在字符指针数组中，r是这个指针数组的首地址。

编写主函数，输入n和n个单词，调用函数拍序，在主函数中输出排序的单词，每个一行。每个单词的长度不超过20个字符。

【输入输出样例】
输入：
5
study
student
sting
STRING
STRAY

输出：
sting
STRAY
STRING
student
study*/
#include <string.h>
void sort(char c[][21], int n){
	int i,j,k;
	char t[21];
	for(i=0; i<n-1; i++)
	{
		k=i;
		for(j=i+1; j<n; j++)
			if(mystrcmp(c[k],c[j]) > 0)
				k=j;
		if(k!=i){
			strcpy(t,c[i]);
			strcpy(c[i],c[k]);
			strcpy(c[k],t);
		}
	}
}

int mystrcmp(char str1[21],char str2[21]){
	int i = 0;
	for(i=0;i<21;i++){
		int temp1=str1[i]>='a'?str1[i]-'a'+'A':str1[i];
		int temp2=str2[i]>='a'?str2[i]-'a'+'A':str2[i];
		if(temp1!=temp2){
			return temp1-temp2;
		}
	}
	return 0;
}

int main(){
	int i;
	int n;
	char c[500][21]={0};
	scanf("%d",&n);
	for(i=0; i<n; i++){
		scanf("%s",c[i]);
	}
	sort(c,n);
	for(i=0; i<n; i++)
		printf("%s\n",c[i]);
	return 0;
}
