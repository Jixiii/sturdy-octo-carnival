#include<stdio.h>
/*����ֶκ���
y=x,��x<1,
y=2x-1,��1<=x<10
y=3x-11,��x>=10
��������float�������ʽ%g��
���������������
���룺
5
���:
9*/
int main(){
	float x, y;
	scanf("%f",&x);
	if(x < 1){
		y = x;
	}else if(x < 10){
		y = 2 * x - 1;
	}else{
		y = 3 * x - 11;
	}
	printf("%g",y);
	return 0;
}
