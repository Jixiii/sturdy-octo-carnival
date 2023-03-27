#include<stdio.h>
/*【题目描述】
设有一篇文章，有3行文字，每行不超过80个字符。请统计出该文的大写字母、小写字母、数字、空格以及其他字符的个数。
输入：三行英文文字，可能有空格及数字、标点等符号。
输出：5个整数，用空格隔开，分别表示大写字母、小写字母、数字、空格以及其他字符的个数。
【输入输出样例】
输入：
year 2019
Month 3
DAY 20!
输出:
4 8 7 3 1*/
int main(){
	char input[3][1000]={0};
	int i;
	for(i = 0;i<3;i++){
		gets(input[i]);
	}
	int num[5]={0};
	for(i = 0;i<3;i++){
		int j = 0;
		while(input[i][j]){
			if(input[i][j]>='A'&&input[i][j]<='Z'){
				num[0]++;
			}else if(input[i][j]>='a'&&input[i][j]<='z'){
				num[1]++;
			}else if(input[i][j]>='0'&&input[i][j]<='9'){
				num[2]++;
			}else if(input[i][j]==' '){
				num[3]++;
			}else{
				num[4]++;
			}
			j++;
		}
	}
	printf("%d",num[0]);
	for(i = 1;i<5;i++){
		printf(" %d",num[i]);
	}
	return 0;
}
