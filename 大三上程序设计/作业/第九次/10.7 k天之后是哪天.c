#include<stdio.h>
/*编写程序，输入一个日期和一个正整数k，计算k天以后是哪天。
例如，输入的日期为2019年5月15日，k为16，则2019年4月15日的16天后是2019年5月1日，输出2019-5-1。
输入：四个整数，前三个分别表示年、月、日 ，后一个标识天数k
输出：k天之后的日期，数据间用英文减号隔开。

【输入输出样例】
输入：
2019 4 15 16
输出：
2019-5-1*/

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

void f(int k){
	/*if(d.month==2&&isRun(d.year)){
		if(k+d.day>29){
			d.month++;
			d.day+=k-29;
		}else{
			d.day+=k;
		}
	}else{
		if(k+d.day>m[d.month-1]){
			d.month++;
			d.day+=k-m[d.month-1]+1;
		}else{
			d.day+=k;
		}
	}
	while(d.day>m[d.month-1]){
		d.month++;
		d.day-=m[d.month-1];
		if(d.month==13){
			d.month=1;
			d.year++;
		}
	}
	
	if(d.month==13){
		d.month=1;
		d.year++;
	}
	return; */
	while((k+d.day)>m[d.month-1]){
		if(isRun(d.year)&&d.month==2){
			k-=29;
			d.month++;
		}else{
			k-=m[d.month-1];
			d.month++;
		}
		if(d.month==13){
			d.month=1;
			d.year++;
		}
	} 
	d.day+=k;
}

int main(){

	int k;
	scanf("%d%d%d%d",&d.year,&d.month,&d.day,&k);
	f(k);
	printf("%d-%d-%d",d.year,d.month,d.day);
	return 0;
}
