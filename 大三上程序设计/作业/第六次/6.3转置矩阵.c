#include<stdio.h>
/*дһ��������ʹ������һ��n*n�Ķ�ά��������ת�ã������л�����
���룺����һ��������n�����к�����n*n������Ԫ�أ�n��10��
���: ��������ת�� n�У�ÿ����������֮���пո�ĩβ�޿ո�
���������������
���룺
3
1 2 3
4 5 6
7 8 9
�����
1 4 7
2 5 8
3 6 9*/
int main(){
	int input[10][10]={0};
	int n;
	scanf("%d",&n);
	int i,j;
	for(i = 0;i<n;i++){
		for(j=0;j<n;j++){
			scanf("%d",&input[i][j]);
		}
	}
	transfer(input,n);
	myprint(input,n);
	return 0;
}

void transfer(int num[10][10],int n){
	int i,j,temp;
	for(i=0;i<n;i++){
		for(j=i+1;j<n;j++){
			temp = num[i][j];
			num[i][j]=num[j][i];
			num[j][i]=temp;
		}
	}
}

void myprint(int num[10][10], int n){
	int i,j;
	for(i=0;i<n;i++){
		printf("%d",num[i][0]);
		for(j=1;j<n;j++){
			printf(" %d",num[i][j]);
		}
		printf("\n");
	}
}
