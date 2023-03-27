#include<stdio.h>
/*输入一个三位数，判断这个数是否是水仙花数，并输出判断结果。
水仙花数是指一个 n 位数（n≥3 ），它的每个位上的数字的 n 次幂之和等于它本身（例如：1^3 + 5^3+ 3^3 = 153）。
例如：
输入：153
输出： 153 is a narcissistic number
输入：111
输出：111 is not a narcissistic number*/
int  main(){
	int input,x1,x2,x3;
	scanf("%d", &input);
	x1 = input/100;
	x2 = input / 10 - x1 * 10;
	x3 = input%10;
	if(x1*x1*x1+x2*x2*x2+x3*x3*x3 == input){
		printf("%d is a narcissistic number", input);
	}else{
		printf("%d is not a narcissistic number", input);
	}
	return 0;
}
