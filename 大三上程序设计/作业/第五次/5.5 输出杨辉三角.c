#include<stdio.h>
/*��ӡ�����µ���������� ��Ҫ���û�����������
���Ϊ20��
�������н�����£�
6
1
1 1
1 2 1
1 3 3 1
1 4 6 4 1
1 5 10 10 5 1
��ע���������֮����һ���ո�ָ���ÿ�����û�пո���֮�䲻������У�*/
int main(){
	int row;
	scanf("%d",&row);
	int i,j;
	int num[100][21]={0};
	num[0][0]=1;
	printf("1\n");
	for(i = 1;i <row;i++){
		num[i][0]=1;
		printf("1") ;
		int j = 1;
		for(;j<=i;j++){
			num[i][j]=num[i-1][j-1]+num[i-1][j];
			printf(" %d",num[i][j]);
		}
		printf("\n");
	}
	return 0;
}
