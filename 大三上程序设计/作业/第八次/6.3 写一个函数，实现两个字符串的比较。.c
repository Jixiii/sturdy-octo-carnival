#include<stdio.h>
#include<string.h>
/*дһ������int strcmp��char *p1, char *p2������ʵ�������ַ����ıȽϡ��������������������ַ����������Ӧ�Ľ����
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

int mystrcmp(char *p1, char *p2){
	int i;
	int len;
	if(strlen(p1)>strlen(p2)){
		len = strlen(p1);
	}else{
		len = strlen(p2);
	}
	for(i=0;i<len;i++){
		if(p1[i]>p2[i]){
			return 1;
		}else if(p1[i]<p2[i]){
			return -1;
		}
	}
	return 0;
}

int main(){
	char str1[500]={0},str2[500]={0};
	scanf("%s%s",str1,str2);
	printf("%d",mystrcmp(str1,str2));
	return 0;
}
