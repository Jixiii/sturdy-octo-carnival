#include<stdio.h>
/*�����ʾ�����Ľṹ�����ͣ���ԱΪʵ�����鲿��float��
���庯���������������ĺͣ����ظ�����
���庯����ʾ������ʽΪ��1+1j ,1-1j�������0����ʾ0+0j��
���룺���У�ÿ�б�ʾһ��������ʵ�����鲿��
�����һ�У����������ĺ͡�
���������������
���룺
-1 -2
-3 -4
�����
-4-6j

��ʾ�������������£�
int main()
{
COMPLEX a,b,c;
scanf("%f%f",&a.real,&a.imag);
scanf("%f%f",&b.real,&b.imag);
c=add(a,b);
show(c);
return 0;
}

�����ʽ%g.*/

typedef struct COMPLEX{
	float real;
	float imag; 
}com;

struct COMPLEX add(com a,com b){
	com c;
	c.real=a.real+b.real;
	c.imag=a.imag+b.imag;
	return c;
}

void show(com c){
	if(c.imag<0){
		printf("%g%gj",c.real,c.imag); 
	}else{
		printf("%g+%gj",c.real,c.imag);
	}
	
}

int main(){
	com a,b,d;
	scanf("%f%f",&a.real,&a.imag);
	scanf("%f%f",&b.real,&b.imag);
	d=add(a,b);
	show(d);
	return 0;
}
