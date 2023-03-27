#include<stdio.h>
/*编写函数，使用指针传递实现三个整数的从大到小排序。
编写主函数，输入三个整数，调用函数排序，输出三个从大到小排序的整数。
输入：三个整数，用空格隔开
输出，三个整数，从大到小，用一个空格隔开。
【输入输出样例】
输入：
1 2 3
输出:
3 2 1
注意，本题的关键是要用函数实现三个数的排序，用指针，不用数组。*/

void change(int* a,int*b,int*c){
	int temp;
	if(*a<*b){
		temp = *a;
		*a = *b;
		*b=temp;
	}
	if(*b<*c){
		temp = *c;
		*c = *b;
		*b=temp;
	}
	if(*a<*b){
		temp = *a;
		*a = *b;
		*b=temp;
	}
}

int main(){
	int a,b,c;
	scanf("%d%d%d",&a,&b,&c);
	change(&a,&b,&c);
	printf("%d %d %d",a,b,c);
	return 0;
}
