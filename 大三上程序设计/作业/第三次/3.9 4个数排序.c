#include<stdio.h>
/*����Ŀ������
����4������������С����˳�������������4 3 2 1�����1 2 3 4.
���룬4���������ÿո���������4��������������һ���ո������
ע�⣺��ʹ�����飬��ʹ�ÿ⺯������
���������������
���룺
4 3 2 1
���:
1 2 3 4*/
int main(){
	int input1, input2, input3, input4, temp;
	scanf("%d%d%d%d",&input1, &input2, &input3, &input4);
	if(input1 > input2){
		temp = input1;
		input1 = input2;
		input2 = temp;
	}
	if(input2 > input3){
		temp = input2;
		input2 = input3;
		input3 = temp;
	}
	if(input3 > input4){
		temp = input3;
		input3 = input4;
		input4 = temp;
	}
	if(input1 > input2){
		temp = input1;
		input1 = input2;
		input2 = temp;
	}
	if(input2 > input3){
		temp = input2;
		input2 = input3;
		input3 = temp;
	}
	if(input1 > input2){
		temp = input1;
		input1 = input2;
		input2 = temp;
	}
	printf("%d %d %d %d",input1,input2,input3,input4);
	return 0;
}
