#include<stdio.h>
/*【题目描述】 编写程序，输入一个4位的整数，将其反序，再乘以2，将结果显示到屏幕上。
例如输入1234，反序为4321，乘以2结果为8642。 
【输入输出样例】 
输入： 1234 
输出: 8642*/
int main(){
	int input, output;
	scanf("%d",&input);
	while(input!=0){
		output *= 10;
		output += input%10;
		input/=10;
	}
	printf("%d",output*2);
	return 0;
}
