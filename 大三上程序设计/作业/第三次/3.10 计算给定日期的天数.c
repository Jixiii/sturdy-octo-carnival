#include<stdio.h>
/*
����Ŀ������ ��������������ʾ�ꡢ�¡��գ�����Ӹ����Ԫ�����𵽵����ǵڼ��졣 ������ 2019-1-1�����1
���������������
����1��
2019-01-01
���1:
1
����2��
2019-3-6
���2:
65
ע�⣬Ҫ��������2��29�졣*/
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
