#include<stdio.h>
/*定义表示复数的结构体类型，成员为实部和虚部，float。
定义函数计算两个复数的和，返回复数。
定义函数显示复数格式为：1+1j ,1-1j，如果是0，显示0+0j。
输入：两行，每行表示一个复数的实部和虚部。
输出：一行，两个复数的和。
【输入输出样例】
输入：
-1 -2
-3 -4
输出：
-4-6j

提示：主函数从如下：
int main()
{
COMPLEX a,b,c;
scanf("%f%f",&a.real,&a.imag);
scanf("%f%f",&b.real,&b.imag);
c=add(a,b);
show(c);
return 0;
}

输出格式%g.*/

typedef struct COMPLEX{
	float real;
	float imag; 
}com;

struct COMPLEX add(com a,com b){
	com c;
	c.real=a.real+b.real;
	c.imag=a.imag+b.imag;
	return c;
}

void show(com c){
	if(c.imag<0){
		printf("%g%gj",c.real,c.imag); 
	}else{
		printf("%g+%gj",c.real,c.imag);
	}
	
}

int main(){
	com a,b,d;
	scanf("%f%f",&a.real,&a.imag);
	scanf("%f%f",&b.real,&b.imag);
	d=add(a,b);
	show(d);
	return 0;
}
