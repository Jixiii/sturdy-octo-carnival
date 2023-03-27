#include<stdio.h>
/*利用公式 π/4=1-1/3+1/5-1/7+… 
求 π 的近似值，舍去绝对值小于eps的通项。
eps由用户输入。数据类型使用双精度。 
输入：双精度实数，输出pai的近似值，保留8位小数。 
注意，级数求和之后再乘以4. 
【输入输出样例】 
输入： 1e-4 
输出: 3.14139265*/
int main(){
	double eps, pi=0;
	scanf("%lf",&eps);
	int i = 1;
	int sign = 1;
	for(i = 1 ; 1.0/i >= eps ; i+=2){
		pi += (double) sign * 1.0/i;
		sign *= -1;
	}
	printf("%.8lf",4.0*pi);
	return 0;
}
