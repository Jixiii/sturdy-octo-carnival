#include<stdio.h>
/*һ�����������������֮�ͣ����Ϊ����������
���磬6��������1,2,3����6=1+2+3����6��������
������1000���ڵ�����������������һ�����������֮����,�ָ���Ӣ�ı�㣩��*/
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
