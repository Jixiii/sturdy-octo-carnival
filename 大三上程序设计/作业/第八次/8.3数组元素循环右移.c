#include<stdio.h>
/*若有n个数，循环右移一位指每个数移到相邻的右边一个位置，最右边的数移到最左边。
如由数1,2,3,4,5；
循环右移一位的结果为5,1,2,3,4。
编写函数，实现数组元素的循环右移k位。
如有数组元素1,2,3,4,5右移3位的 结果为3,4,5,1,2。

编写主函数输入若干元素和右移位数，调用函数右移，在主函数中输出结果。元素个数不超过100.

输入：两行，第1行为若干用空格分隔的整数，以9999表示结束；第2行一个整数，表示右移的位数。
输出:一行，移位的结果，用一个空格隔开，末尾无空格。
【输入输出样例】
输入：
1 2 3 4 5 9999
3
输出：
3 4 5 1 2*/

void turn(int* num,int n,int k){
	int temp[500]={0};
	int i=0;
	for(i=0;i<k;i++){
		temp[i]=num[i+n-k];
	}
	for(i=n-1;i>=k;i--){
		num[i]=num[i-k];
	}
	for(i=0;i<k;i++){
		num[i]=temp[i];
	}
}

int main(){
	int n,num[500]={0},i=0,k;
	while(1){
		scanf("%d",num+n);
		if(num[n]==9999){
			break;
		}
		n++;
	}
	scanf("%d",&k);
	turn(num,n,k);	
	printf("%d",num[0]);
	for(i=1;i<n;i++){
		printf(" %d",num[i]);
	}
	return 0;
}
