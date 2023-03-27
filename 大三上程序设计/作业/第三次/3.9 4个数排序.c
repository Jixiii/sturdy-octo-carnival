#include<stdio.h>
/*【题目描述】
输入4个整数，按从小到大顺序输出。如输入4 3 2 1，输出1 2 3 4.
输入，4个整数，用空格隔开，输出4个有序整数，用一个空格隔开。
注意：不使用数组，不使用库函数排序。
【输入输出样例】
输入：
4 3 2 1
输出:
1 2 3 4*/
int main(){
	int input1, input2, input3, input4, temp;
	scanf("%d%d%d%d",&input1, &input2, &input3, &input4);
	if(input1 > input2){
		temp = input1;
		input1 = input2;
		input2 = temp;
	}
	if(input2 > input3){
		temp = input2;
		input2 = input3;
		input3 = temp;
	}
	if(input3 > input4){
		temp = input3;
		input3 = input4;
		input4 = temp;
	}
	if(input1 > input2){
		temp = input1;
		input1 = input2;
		input2 = temp;
	}
	if(input2 > input3){
		temp = input2;
		input2 = input3;
		input3 = temp;
	}
	if(input1 > input2){
		temp = input1;
		input1 = input2;
		input2 = temp;
	}
	printf("%d %d %d %d",input1,input2,input3,input4);
	return 0;
}
