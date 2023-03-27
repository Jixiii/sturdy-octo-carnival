#include<stdio.h>
int main(){
	int num[12]={0};
	int i = 0;
	for(i=0;i<10;i++){
		scanf("%d",&num[i]);
	}
	printf("after create:\n");
	for(i=0;i<5;i++){
		printf("student number:%d score:%d.00\n",num[2*i],num[2*i+1]);
	}
	
	printf("\n");
	/*for(i=10;i<12;i++){
		scanf("%d",&num[i]);
	}*/
	num[10]=2019;
	num[11]=88;
	printf("after insert:\n");
	printf("student number:%d score:%d.00\n",num[0],num[1]);
	printf("student number:%d score:%d.00\n",num[10],num[11]);
	for(i=1;i<5;i++){
		printf("student number:%d score:%d.00\n",num[2*i],num[2*i+1]);
	}
	
	printf("\n");
	printf("after delete:\n");
	printf("student number:%d score:%d.00\n",num[0],num[1]);
	printf("student number:%d score:%d.00\n",num[10],num[11]);
	for(i=2;i<5;i++){
		printf("student number:%d score:%d.00\n",num[2*i],num[2*i+1]);
	}
	return 0;
} 
