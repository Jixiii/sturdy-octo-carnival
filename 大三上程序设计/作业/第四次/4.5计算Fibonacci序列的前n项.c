#include<stdio.h>
/*��д��������n����ʾ쳲�����(Fibonacci)���е�ǰn������ ��f(1)=1,f(2)=1 f ( n ) = f(n-1) + f(n-1), n=3,4,5,6,7�� 
���룺������n 
�����n������������һ���ո������ĩβ�޿ո� 
��������������� 
���룺 10 
���: 1 1 2 3 5 8 13 21 34 55*/
int main(){
	int Fibonacci[1000];
	Fibonacci[0] = Fibonacci[1] = 1;
	int n;
	scanf("%d", &n);
	int i = 2;
	if(n == 1){
		printf("1");
		return 0;
	}else if(n == 2){
		printf("1 1");
		return 0;
	}else{
		printf("1 1");
		while(i < n){
			Fibonacci[i] = 	Fibonacci[i-1] + Fibonacci[i-2];
			printf(" %d", Fibonacci[i]);
			i++;
		}
	}
	return 0;
}
