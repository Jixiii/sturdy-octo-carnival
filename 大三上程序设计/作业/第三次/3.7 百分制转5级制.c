#include<stdio.h>
/*输入百分制成绩，0-100，实数，转换为5级制成绩，
90及以上 A
[80,90) B
[70,80) C
[60,70) D
[0,60) E
输入,实数；输出,A,B,C,D,E大写字母之一，表示级别。
【输入输出样例】
输入：
91
输出:
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
