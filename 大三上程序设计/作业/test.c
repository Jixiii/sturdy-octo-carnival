#include<stdio.h>
int main(){
	char str[200]={0};
	gets(str);
	printf("%s\n",str);
	gets(str);
	printf("%s",str);
	return 0; 
}
