#include<stdio.h>
/* �ַ������򣬾��󵥴ʵ��ֵ�����'a'<'b'�ȵȡ�
��д������ʵ���ַ���������(��С����)�������ִ�Сд������ԭ��Ϊ��
void sortstring(char **r,int n);
����r��ʾ�ַ����׵�ַ������׵�ַ��n��ʾ�ַ����������ַ������׵�ַ�����ַ�ָ�������У�r�����ָ��������׵�ַ��

��д������������n��n�����ʣ����ú������������������������ĵ��ʣ�ÿ��һ�С�ÿ�����ʵĳ��Ȳ�����20���ַ���

���������������
���룺
5
study
student
sting
STRING
STRAY

�����
sting
STRAY
STRING
student
study*/
#include <string.h>
void sort(char c[][21], int n){
	int i,j,k;
	char t[21];
	for(i=0; i<n-1; i++)
	{
		k=i;
		for(j=i+1; j<n; j++)
			if(mystrcmp(c[k],c[j]) > 0)
				k=j;
		if(k!=i){
			strcpy(t,c[i]);
			strcpy(c[i],c[k]);
			strcpy(c[k],t);
		}
	}
}

int mystrcmp(char str1[21],char str2[21]){
	int i = 0;
	for(i=0;i<21;i++){
		int temp1=str1[i]>='a'?str1[i]-'a'+'A':str1[i];
		int temp2=str2[i]>='a'?str2[i]-'a'+'A':str2[i];
		if(temp1!=temp2){
			return temp1-temp2;
		}
	}
	return 0;
}

int main(){
	int i;
	int n;
	char c[500][21]={0};
	scanf("%d",&n);
	for(i=0; i<n; i++){
		scanf("%s",c[i]);
	}
	sort(c,n);
	for(i=0; i<n; i++)
		printf("%s\n",c[i]);
	return 0;
}
