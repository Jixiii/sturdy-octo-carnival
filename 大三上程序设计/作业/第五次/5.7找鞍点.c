#include<stdio.h>
/*����Ŀ������
��д��������n��n*n����������Ԫ�أ����䰰�㡣n������10.
�������A�д���������һ��Ԫ��A[i,j]��������:A[i,j]�ǵ�i����ֵ��С��Ԫ��,�����ǵ�j����ֵ����Ԫ�أ����֮Ϊ�þ����һ�����㡣
���룺�������n, Ȼ��������n*n������Ԫ�ء�
����������У�ÿ���Ǿ����һ��������кš��кź���ֵ����һ���ո������������û�а��㣬���"None"��
�������������1��
���룺
3
1   7  3
5   4  6
17 18  9
���:
3 3 9
�������������2��
���룺
3
5  19  20
6  20  9
19 18  5
���:
None*/
int main(){
	int num[100][100]={0};
	int n;
	scanf("%d",&n);
	int i = 0;
	for(;i < n;i++){
		int j = 0;
		for(;j < n;j++){
			scanf("%d",&num[i][j]);
		}
	}
	int y = 0;
	int have = 0;
	for(;y < n;y++){
		int minAtY = num[y][0];
		int minAtYIndexX = 0;
		int i = 0;
		for(;i<n;i++){
			if(num[y][i]<minAtY){
				minAtYIndexX = i;
				minAtY = num[y][i];
			}
		}
		int isMax = 1;
		int j = 0;
		for(;j < n;j++){
			if(num[j][minAtYIndexX]>num[y][minAtYIndexX]){
				isMax = 0;
				break;
			}
		}
		if(isMax){
			printf("%d %d %d",y+1,minAtYIndexX+1,minAtY);
			have = 1;
		}
	}
	if(have==0){
		printf("None");
	}
	return 0;
}
