#include<stdio.h>
/*写两个函数，分别求两个正整数的最大公约数与最小公倍数，
用主函数调用这两个函数，并输出结果。两个整数由键盘输入。如输入15和18，输出3和90 。
【输入输出样例】
输入：
15 18
输出：
3 90*/
int main(){
	int input1,input2;
	scanf("%d%d",&input1,&input2);
	printf("%d %d",gcd(input1,input2),lcm(input1,input2));
	return 0;
}

int gcd(int x,int y){
	int result = 1;
	int i;
	for(i = 1;i<=x;i++){
		if(x%i==0&&y%i==0){
			result = i;
		}
	}
	return result;
}

int lcm(int x,int y){
	return x*y/gcd(x,y);
}
