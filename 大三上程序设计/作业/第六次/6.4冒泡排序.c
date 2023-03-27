#include<stdio.h>
/*编写函数，用“冒泡法”对输入的n个整数按从小到大的顺序排列。
编写主函数，输入n和n个数组元素，调用函数排序，在主函数中输出。
注意，输入、输出可以通过单独的函数实现，在排序函数中不能输出数组元素。 
输入：输入n，换行后输入n个整数。（n不超过20） 
输出：从小到大的排列，数字之间有空格，末尾无空格。 
【输入输出样例】 
输入： 5 5 4 3 2 1 
输出： 1 2 3 4 5*/
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
