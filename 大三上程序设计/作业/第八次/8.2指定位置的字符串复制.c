#include<stdio.h>
#include<string.h>
/*��д���������ַ���s1�дӵ�n���ַ���ʼ�����k���ַ����Ƶ��ַ���s2�С�
������˼�����s1��n��ʼ���ַ�����k�������Ƶ�ĩβΪֹ��
��s1="study",n=4,k=5,��ֻ����dy�������ַ�����������s2���׵�ַ������ԭ��Ϊ��
char * copykn(char *s1,char *s2,int n,int k)
��д�������������ַ���n��k�����ú������ƣ��������ַ�����������Ϊ��
int main(){
char s1[100],s2[100];
int n,k;
gets(s1);
scanf("%d %d",&n,&k);
puts(copykn(s1,s2,n,k));
return 0;
}
���������������
���룺
communication
2 3
���:
omm*/
char *copykn(char *s1,char *s2,int n,int k){
	int i=0;
	if(n>strlen(s1)){
		return s2;
	}
	for(i=0;i<k;i++){
		s2[i]=s1[i+n-1];
	}
	return s2;
}


int main(){
	char s1[100]={0},s2[100]={0};
	int n,k;
	scanf("%s",s1);
	scanf("%d%d",&n,&k);
	printf("%s",copykn(s1,s2,n,k));
	return 0;
}
