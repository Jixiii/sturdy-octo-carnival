#include<stdio.h>
#include <string.h>
/*�����ַ���1���ַ���2��
��������ַ�����ͬ�����0��
����ַ���1�����ַ���2�����1��
����ַ���1С���ַ���2�����-1��
ע�⣬���ⲻ��ʹ��ϵͳ��������ʹ�ã���0�֡����磺
���룺
hello
world
�������-1
���룺
world
hello
�����1
���룺
hello
hello
�������0*/
int main(){
	char input1[50]={0},input2[50]={0};
	scanf("%s",input1);
	scanf("%s",input2);
	int i = 0;
	for(;i<strlen(input1);i++){
		if(input1[i]>input2[i]){
			printf("1");
			return 0;
		}else if(input1[i]<input2[i]){
			printf("-1");
			return 0;
		}
	}
	printf("0");
	return 0;
}
