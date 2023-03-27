#include<stdio.h>
/*输入n, 求分数序列1/2, 2/3, 3/5, 5/8, 8/13…… 
第n项和前n项的和（每一项分子为前一项的分母，分母是前一项分子与分母的和） 
输入：正整数 
输出：两个实数，用一个空格隔开，格式%g。 
【输入输出样例】 
输入： 10 
输出： 0.618056 6.09796*/
int main(){
	double output = 0.5,sum = 0.5;
	int intnum[1000] = {1, 2};
	int n;
	scanf("%d", &n);
	int i = 2;
	for(;i <= n;i++){
		intnum[i] = intnum[i-1] +intnum[i-2];
		output = (double) intnum[i-1]/intnum[i];
		sum += output;
	}
	printf("%g %g", output, sum);
	return 0;
}
