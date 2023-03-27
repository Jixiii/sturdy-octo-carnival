#include<stdio.h>
/*
【题目描述】 输入三个整数表示年、月、日，计算从该年的元旦算起到当日是第几天。 如输入 2019-1-1，输出1
【输入输出样例】
输入1：
2019-01-01
输出1:
1
输入2：
2019-3-6
输出2:
65
注意，要考虑闰年2月29天。*/
int main(){
	int year, month, day;
	scanf("%d-%d-%d",&year, &month, &day);
	int monthDays[12] = {31,28,31,30,31,30,31,31,30,31,30,31};
	int output = day;
	int i;
	for(i = 0;i < month - 1;i++){
		output += monthDays[i];
	} 
	if(month>1&&isRunNian(year)){
		output++;
	}
	printf("%d",output);
	return 0;
}

int isRunNian(int year){
	if(year%4==0&&year%100!=0){
		return 1;
	}
	return 0;
}
