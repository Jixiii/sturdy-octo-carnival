#include<stdio.h>
/*计算分段函数
y=x,当x<1,
y=2x-1,当1<=x<10
y=3x-11,当x>=10
数据类型float，输出格式%g。
【输入输出样例】
输入：
5
输出:
9*/
int main(){
	float x, y;
	scanf("%f",&x);
	if(x < 1){
		y = x;
	}else if(x < 10){
		y = 2 * x - 1;
	}else{
		y = 3 * x - 11;
	}
	printf("%g",y);
	return 0;
}
