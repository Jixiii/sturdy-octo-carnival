#include<stdio.h>
/*��д��������һ�����ں�һ��������k������k���Ժ������졣
���磬���������Ϊ2019��5��15�գ�kΪ16����2019��4��15�յ�16�����2019��5��1�գ����2019-5-1��
���룺�ĸ�������ǰ�����ֱ��ʾ�ꡢ�¡��� ����һ����ʶ����k
�����k��֮������ڣ����ݼ���Ӣ�ļ��Ÿ�����

���������������
���룺
2019 4 15 16
�����
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
