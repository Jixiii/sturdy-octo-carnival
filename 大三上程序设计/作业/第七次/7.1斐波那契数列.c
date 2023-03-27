#include<stdio.h> 
/*用递归函数求斐波那契数列的第n项。
f（1）=1
f（2）=1
f ( n ) =f(n-1)+f(n-2), n=3,4,5,6…

输入：项数n
输出：输出一个正整数，若n为非正整数输出’ERROR’.
【输入输出要求】
输入：项数n
输出：输出一个正整数，若n为非正整数输出"ERROR".
【输入输出样例】
输入：
5
输出：
5
输入：
-1
输出：
ERROR*/
int num[200]={0};

int f(int n){
	if(n==1||n==2){
		return 1;
	}
	if(num[n]==0){
		return f(n-1)+f(n-2);
	}else{
		return num[n];
	}
}

int main(){
	int n;
	scanf("%d",&n);
	if(n>0){
		printf("%d",f(n));
	}else{
		printf("ERROR");
	}
	return 0;
}
