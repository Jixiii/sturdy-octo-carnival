#include<stdio.h>
/*一个数如果等于其因子之和，则称为“完数”。
例如，6的因子是1,2,3，而6=1+2+3，则6是完数。
编程输出1000以内的所有完数，数字在一行输出，数字之间用,分隔（英文标点）。*/
int main(){
	int i = 7;
	printf("6");
	for(;i<=1000;i++){
		int divisor = 1, temp = 0;
		for(;divisor < i;divisor++){
			if(i%divisor==0){
				temp += divisor;
			}
		}
		if(temp == i){
			printf(",%d", i);
		}
	}
	return 0;
}
