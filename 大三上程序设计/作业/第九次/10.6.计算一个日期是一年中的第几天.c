#include<stdio.h>
/*�����ʾ���ڵĽṹ�����ͣ���Ա�����ꡢ�¡��գ�����������ʾ��
��д����������һ���ṹ�����͵������Ǳ����еĵڼ��죨Ҫ�������꣩����2018��1��1���ǵ��꣨2018����ĵ�1�졣
��д������������ṹ�����������ṹ��������ꡢ�¡��գ����ú���������������ʾ��
���������������
���룺
2019 4 15
�����
105
��ʾ�����������£�
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
