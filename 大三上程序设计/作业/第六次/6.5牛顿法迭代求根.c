#include<stdio.h>
/*��ţ�ٵ��������������Ϊax3+bx2+cx+d=0,ϵ��a��b��c��d��ֵ����Ϊ1,2,3,4����x��x0������һ��ʵ��������������float��
���룺����x0�͵�������n��
��������һ��ʵ������%f�����
���������������
���룺
1 10
�����
-1.650629*/
float nX(float x){
	float f1,f2;
	f1=x*x*x+2.0*x*x+3.0*x+4.0;
	f2=3.0*x*x+4.0*x+3;
	return x-f1/f2;
}

int main(){
	int n;
	float x0,temp;
	scanf("%f%d",&x0,&n);
	int i;
	for(i=0;i<n;i++){
		x0 = nX(x0);
	}
	printf("%f",x0);
}


