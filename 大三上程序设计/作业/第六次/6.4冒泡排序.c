#include<stdio.h>
/*��д�������á�ð�ݷ����������n����������С�����˳�����С�
��д������������n��n������Ԫ�أ����ú����������������������
ע�⣬���롢�������ͨ�������ĺ���ʵ�֣����������в����������Ԫ�ء� 
���룺����n�����к�����n����������n������20�� 
�������С��������У�����֮���пո�ĩβ�޿ո� 
��������������� 
���룺 5 5 4 3 2 1 
����� 1 2 3 4 5*/
int main(){
	int input[30];
	int n,i;
	scanf("%d",&n);
	for(i = 0;i<n;i++){
		scanf("%d",input+i);
	}
	
	maoPao(input,n);
	
	printf("%d",input[0]);
	for(i = 1;i<n;i++){
		printf(" %d",input[i]);
	}
	return 0;
}

void maoPao(int num[30],int n){
	int i,j,temp;
	for(i=0;i<n;i++){
		for(j=0;j<n-i-1;j++){
			if(num[j]>num[j+1]){
				temp = num[j];
				num[j]=num[j+1];
				num[j+1]=temp;
			}
		}
	}
}
