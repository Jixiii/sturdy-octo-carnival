#include<stdio.h>
/*写一个函数，使给定的一个n*n的二维整型数组转置，即行列互换。
输入：输入一个正整数n，换行后输入n*n的数组元素（n＜10）
输出: 输出数组的转置 n行，每行相邻数字之间有空格末尾无空格。
【输入输出样例】
输入：
3
1 2 3
4 5 6
7 8 9
输出：
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
