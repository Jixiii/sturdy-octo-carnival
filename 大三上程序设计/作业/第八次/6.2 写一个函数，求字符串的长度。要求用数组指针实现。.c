#include<stdio.h>
/*дһ������int slen(char *s)������ֵΪ�ַ���s�ĳ��ȡ�
Ҫ����������������һ�����Ȳ�����20���ַ��������ú���slen������ַ�����Ӧ�ĳ��ȡ�
���룺
hello world
�����
11���ո�������Ч�ַ���*/

int slen(char* s){
	int len =0;
	while(s[len]!=0){
		len++;
	}
	return len;
}

int main(){
	char str[21]={0};
	gets(str);
	printf("%d",slen(str));
	return 0;
}
