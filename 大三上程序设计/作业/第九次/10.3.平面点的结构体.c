#include<stdio.h>
#include<math.h>
/*定义表示平面点的结构体类型，成员有x坐标和y坐标，数据类型用float。
定义计算两个点的距离的函数，计算两个平面点的距离，返回float。
主函数中定义两个平面点的结构体变量，输入点的坐标，调用函数求距离，显示它们的距离(输出%f)。
输入：四个实数，前两个表示一个点的x,y坐标；后两个表示另一个点的x,y坐标.
输出：两个点的距离。
注意，距离函数的参数是结构体类型！！！
【输入输出样例】
输入：
2 2 1 1
输出：
1.414214*/

typedef struct pmd{
	float x;
	float y;
}dian;

float f(dian d1,dian d2){
	return sqrt((d1.x-d2.x)*(d1.x-d2.x)+(d1.y-d2.y)*(d1.y-d2.y));
}

int main(){
	dian d1,d2;
	scanf("%f%f%f%f",&d1.x,&d1.y,&d2.x,&d2.y);
	printf("%f",f(d1,d2));
	return 0;
}
