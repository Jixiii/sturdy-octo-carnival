#include<stdio.h>
/*【题目描述】
输入n和n个整数，使用选择法排序，输出从大到小的序列。元素个数不超过100.
输入：正整数n和n个整数。
输出：从大到小的有序序列，用一个空格隔开，末尾无空格。
【输入输出样例】
输入：
4
1 2 3 4
输出:
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
