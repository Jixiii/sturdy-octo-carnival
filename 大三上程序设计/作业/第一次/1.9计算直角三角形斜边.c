#include<stdio.h>
#include<math.h>
/*【题目描述】
输入三角形的直角边，计算并输出斜边长度。
例如输入：3 4
输出：c=5
注意，三边会是实数，所以使用float数据类型。输出使用"%g"格式。“c=”是固定的。
【输入输出样例】
输入：
3 4
输出:
c=5*/
int main(){
	float a,b;
	scanf("%f%f",&a,&b);
	printf("c=%g",pow(a*a+b*b,0.5));
	return 0;
}
