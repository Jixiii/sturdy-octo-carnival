#include<stdio.h>
/*д�����������ֱ������������������Լ������С��������
�������������������������������������������ɼ������롣������15��18�����3��90 ��
���������������
���룺
15 18
�����
3 90*/
int main(){
	int input1,input2;
	scanf("%d%d",&input1,&input2);
	printf("%d %d",gcd(input1,input2),lcm(input1,input2));
	return 0;
}

int gcd(int x,int y){
	int result = 1;
	int i;
	for(i = 1;i<=x;i++){
		if(x%i==0&&y%i==0){
			result = i;
		}
	}
	return result;
}

int lcm(int x,int y){
	return x*y/gcd(x,y);
}
