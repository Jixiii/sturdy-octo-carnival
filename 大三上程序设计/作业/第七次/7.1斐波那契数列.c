#include<stdio.h> 
/*�õݹ麯����쳲��������еĵ�n�
f��1��=1
f��2��=1
f ( n ) =f(n-1)+f(n-2), n=3,4,5,6��

���룺����n
��������һ������������nΪ�������������ERROR��.
���������Ҫ��
���룺����n
��������һ������������nΪ�����������"ERROR".
���������������
���룺
5
�����
5
���룺
-1
�����
ERROR*/
int num[200]={0};

int f(int n){
	if(n==1||n==2){
		return 1;
	}
	if(num[n]==0){
		return f(n-1)+f(n-2);
	}else{
		return num[n];
	}
}

int main(){
	int n;
	scanf("%d",&n);
	if(n>0){
		printf("%d",f(n));
	}else{
		printf("ERROR");
	}
	return 0;
}
