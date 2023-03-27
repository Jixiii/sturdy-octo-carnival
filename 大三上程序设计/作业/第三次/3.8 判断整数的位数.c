#include<stdio.h>
/*输入不超过5位的非负整数，判断它是几位数。如输入1234，输出4。
【输入输出样例】
输入：
1234
输出:
4*/
int main(){
	int output, input;
	scanf("%d", &input);
	while(input){
		input/=10;
		output++;
	}
	printf("%d",output);
	return 0;
}
