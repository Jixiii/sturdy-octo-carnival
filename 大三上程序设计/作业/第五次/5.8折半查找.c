#include<stdio.h>
/*����Ŀ������ ��n������n<20��,�Ѱ��Ӵ�С˳������һ�������У�
����һ������Ҫ�����۰���ҷ��ҳ������������еĵڼ���Ԫ�ص�ֵ����1��ʼ����
����������������0�� 
Input�� 
��һ��Ϊ����Ԫ�صĸ���n�� 
�ڶ�����n������Ԫ�ص�ֵ�������� 
��������Ҫ���ҵ�ֵ�� 
Output�� ���ҵ�ֵ�������е�λ�ã������1��ʼ�����Ҳ���ʱ��ʾ0�� 
��������������� ���룺 
10 
10 9 8 7 6 5 4 3 2 1 
5 
���: 6/*/
int main(){
	int n;
	scanf("%d",&n);
	int num[1000];
	int i;
	for(i = 0;i < n;i++){
		scanf("%d",num+i);
	}
	int search;
	scanf("%d",&search);
	int left = 0,right = n;
	int mid;
	while(left<right){
		mid = (left+right)/2;
		if(num[mid]==search){
			printf("%d",mid+1);
			return 0;
		}else if(num[mid]>search){
			left = mid;
		}else{
			right = mid;
		}
	}
	printf("0");
	return 0;
}
