#include<stdio.h>
/*����Ŀ������
����n��n��������ʹ��ѡ����������Ӵ�С�����С�Ԫ�ظ���������100.
���룺������n��n��������
������Ӵ�С���������У���һ���ո������ĩβ�޿ո�
���������������
���룺
4
1 2 3 4
���:
4 3 2 1*/
int main(){
	int num[1000];
	int n,i;
	scanf("%d",&n);
	for(i = 0;i<n;i++){
		scanf("%d",num + i);
	}
	for(i = 0;i<n;i++){
		int max = num[i];
		int j = i;
		int maxIndex = i;
		for(;j<n;j++){
			if(max<num[j]){
				max = num[j];
				maxIndex = j;
			}
		}
		if(maxIndex!=i){
			swap(num,i,maxIndex);
		}
	}
	printf("%d",num[0]);
	for(i = 1;i<n;i++){
		printf(" %d",num[i]);
	}
}

void swap(int* num,int i,int j){
	int temp = num[i];
	num[i] = num[j];
	num[j] = temp;
}
