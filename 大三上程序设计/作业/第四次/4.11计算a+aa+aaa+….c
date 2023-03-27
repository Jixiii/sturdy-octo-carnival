#include<stdio.h>
/*编写程序，输入n和a，计算a+aa+aaa+…+aa…a（最后一项由n个a组成）。n是正整数，a是0到9的数字。 
例如输入 5 1，实际是求1+11+111+1111+11111的和，结果为12345。 
【输入输出样例】 输入： 5 1 输出: 12345*/
int main(){
	int n, a,sum = 0;
	scanf("%d%d",&n,&a);
	int i = 1;
	for(;i<=n;i++){
		sum*=10;
		sum += i*a;
	}
	printf("%d", sum);
	return 0;
}
