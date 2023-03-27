#include<stdio.h>
/*【题目描述】
输入n，然后输入n个整数，逆序显示这n个数，每5个一行，用空格隔开，行末无空格。n<=100。
输入：正整数n以及n个用空格隔开的整数。
输出：逆序输出n个整数，每5个一行，用空格隔开，行末无空格。
【输入输出样例】
输入：
10
1 2 3 4 5 6 7 8 9 10
输出:
10 9 8 7 6
5 4 3 2 1*/
int main(){
	int input[100];
	int n;
	scanf("%d",&n);
	int i;
	for(i = 0;i<n;i++){
		scanf("%d",input+i);
	}
	for(i = 0;i < n;i++){
		if(i%5==4){
			printf("%d\n",input[n-i-1]);
		}else{
			printf("%d ",input[n-i-1]);
		}
	}
	return 0;
}
