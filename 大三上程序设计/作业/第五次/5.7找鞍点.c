#include<stdio.h>
/*【题目描述】
编写程序，输入n和n*n的整数矩阵元素，求其鞍点。n不超过10.
如果矩阵A中存在这样的一个元素A[i,j]满足条件:A[i,j]是第i行中值最小的元素,且又是第j列中值最大的元素，则称之为该矩阵的一个马鞍点。
输入：矩阵阶数n, 然后按行输入n*n个矩阵元素。
输出：若干行，每行是矩阵的一个鞍点的行号、列号和数值，用一个空格隔开。若矩阵没有按点，输出"None"。
【输入输出样例1】
输入：
3
1   7  3
5   4  6
17 18  9
输出:
3 3 9
【输入输出样例2】
输入：
3
5  19  20
6  20  9
19 18  5
输出:
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
