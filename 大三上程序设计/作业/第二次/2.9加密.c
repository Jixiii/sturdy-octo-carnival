#include<stdio.h>
/*【题目描述】 输入4字母的小写英文单词和整数k，将单词中的每个字母用其后的第k个字母替换(字母表首尾相接)。
如输入like 4，输出pmoi 
【输入输出样例】 
输入： like 4 
输出: pmoi*/
int main(){
	int k;
	char input[10];
	scanf("%s%d",input, &k);
	int i;
	for(i = 0;i < 4;i++){
		input[i] = (char)(((int)input[i]+k-(int)'a')%26+(int)'a');
	}
	printf("%s",input);
	return 0;
}
