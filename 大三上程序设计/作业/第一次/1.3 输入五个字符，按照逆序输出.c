#include<stdio.h>
/*��������ַ��������������

���룺o,l,l,e,h �����hello*/
int main(){
	char input[5];
	scanf("%c,%c,%c,%c,%c",input,input+1,input+2,input+3,input+4); 
	int i;
	for(i = 4;i >= 0;i--){
		printf("%c",input[i]);
	}
	return 0;
}
