#include<stdio.h>
/*����ٷ��Ƴɼ���0-100��ʵ����ת��Ϊ5���Ƴɼ���
90������ A
[80,90) B
[70,80) C
[60,70) D
[0,60) E
����,ʵ�������,A,B,C,D,E��д��ĸ֮һ����ʾ����
���������������
���룺
91
���:
A*/
int main(){
	float input;
	char grade;
	scanf("%f", &input);
	if(input>=90){
		grade = 'A';
	}else if(input>=80){
		grade = 'B';
	}else if(input>=70){
		grade = 'C';
	}else if(input>=60){
		grade = 'D';
	}else{
		grade = 'E';
	}
	printf("%c", grade);
	return 0;
}
