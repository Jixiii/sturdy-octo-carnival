#include<stdio.h>
/*定义表示日期的结构体类型，成员包括年、月、日，都用整数表示。
编写函数，计算一个结构体类型的日期是本年中的第几天（要考虑闰年），如2018年1月1日是当年（2018）年的第1天。
编写主函数，定义结构体变量。输入结构体变量的年、月、日，调用函数计算天数并显示。
【输入输出样例】
输入：
2019 4 15
输出：
105
提示：主函数如下：
int main()
{
DATE d1;
scanf("%d %d %d",&d1.year,&d1.month,&d1.day);
printf("%d\n",daysofyear(d1));
return 0;
}*/

int m[12]={31,28,31,30,31,30,31,31,30,31,30,31};

struct data{
	int year;
	int month;
	int day;
};

struct data d;

int isRun(int year){
	if(year%400==0||year%100!=0&&year%4==0){
		return 1;
	}
	return 0;
}

int daysofyear(struct data d){
	int i = 0;
	int result = 0;
	for(i=0;i<d.month-1;i++){
		result+=m[i];
	}
	if(d.month>2&&isRun(d.year)){
		result++;
	}
	return result+d.day;
}

int main(){
	scanf("%d %d %d",&d.year,&d.month,&d.day);
	printf("%d\n",daysofyear(d));
	return 0;
}
