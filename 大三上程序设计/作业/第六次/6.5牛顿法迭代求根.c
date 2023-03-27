#include<stdio.h>
/*用牛顿迭代法求根。方程为ax3+bx2+cx+d=0,系数a，b，c，d的值依次为1,2,3,4。求x在x0附近的一个实根。数据类型用float。
输入：输入x0和迭代次数n。
输出：输出一个实数（用%f输出）
【输入输出样例】
输入：
1 10
输出：
-1.650629*/
float nX(float x){
	float f1,f2;
	f1=x*x*x+2.0*x*x+3.0*x+4.0;
	f2=3.0*x*x+4.0*x+3;
	return x-f1/f2;
}

int main(){
	int n;
	float x0,temp;
	scanf("%f%d",&x0,&n);
	int i;
	for(i=0;i<n;i++){
		x0 = nX(x0);
	}
	printf("%f",x0);
}


