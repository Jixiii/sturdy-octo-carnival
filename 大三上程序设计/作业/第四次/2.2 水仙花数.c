#include<stdio.h>
/*����һ����λ�����ж�������Ƿ���ˮ�ɻ�����������жϽ����
ˮ�ɻ�����ָһ�� n λ����n��3 ��������ÿ��λ�ϵ����ֵ� n ����֮�͵������������磺1^3 + 5^3+ 3^3 = 153����
���磺
���룺153
����� 153 is a narcissistic number
���룺111
�����111 is not a narcissistic number*/
int  main(){
	int input,x1,x2,x3;
	scanf("%d", &input);
	x1 = input/100;
	x2 = input / 10 - x1 * 10;
	x3 = input%10;
	if(x1*x1*x1+x2*x2*x2+x3*x3*x3 == input){
		printf("%d is a narcissistic number", input);
	}else{
		printf("%d is not a narcissistic number", input);
	}
	return 0;
}
