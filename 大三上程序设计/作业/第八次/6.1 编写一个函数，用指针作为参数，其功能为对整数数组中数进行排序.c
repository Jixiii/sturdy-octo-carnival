#include<stdio.h>
/*��дһ������void fun(int *p, int n)���书��Ϊ����������p[5]�е����ֽ�������
��������������������� 
���룺 34 78 23 12 69 ������£� 78,69,34,23,12
ע�⣺��������֮����һ���ո�ָ�*/

void fun(int *p,int n){
	int i=0,j=0;
	for(i=n;i>0;i--){
		for(j=0;j<i-1;j++){
			if(p[j]<p[j+1]){
				int temp = p[j];
				p[j]=p[j+1];
				p[j+1]=temp;
			}
		}
	}
}

int main(){
	int num[5];
	int i;
	for(i=0;i<5;i++){
		scanf("%d",&num[i]);
	}
	fun(num,5);
	printf("%d",num[0]);
	for(i=1;i<5;i++){
		printf(",%d",num[i]);
	}
	return 0;
} 
