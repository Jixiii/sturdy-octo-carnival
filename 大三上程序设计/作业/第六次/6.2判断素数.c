#include<stdio.h> 
/*写一个判断素数的函数，在主函数中输入一个整数，若是素数输出YES，若不是素数输出NO，若是非正整数则输出ERROR。
输入：整数
输出: YES,NO,ERROR之一。
【输入输出样例】
输入：
2
输出：
YES*/
int main(){
	int input;
	scanf("%d",&input);
	switch(isSuShu(input)){
		case -1:
		printf("ERROR");
		break;
		case 0:
		printf("NO");
			break;
		case 1:
		printf("YES");
		break;
	}
	return 0;
}
int isSuShu(int x){
	if(x<=0){
		return -1;
	}
	int i;
	if(x==1){
		return 0;
	}
	for(i = 2;i<x;i++){
		if(x%i==0){
			return 0;
		}
	}
	return 1;
}
