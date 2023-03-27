#include<stdio.h>
/*输入五个字符，按照逆序输出

输入：o,l,l,e,h 输出：hello*/
int main(){
	char input[5];
	scanf("%c,%c,%c,%c,%c",input,input+1,input+2,input+3,input+4); 
	int i;
	for(i = 4;i >= 0;i--){
		printf("%c",input[i]);
	}
	return 0;
}
