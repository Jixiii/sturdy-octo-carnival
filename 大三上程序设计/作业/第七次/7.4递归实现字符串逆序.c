#include<stdio.h>
#include<string.h>
/*��д������ʹ�õݹ�ʵ���ַ��������򡣱�д�������������ַ��������ú�����������ַ�����
Ҫ��1��ʹ�ÿ⺯����2���õݹ飬3����������������� 
���룺�����ո���ַ���,����С��200�� �����������ַ����� 
��������������� 
���룺 abcdef ���: fedcba 
��ʾ���������Ĳο�ԭ�ͣ� void mystrrev(char s[],int I,int j);
 ����i,jΪҪ�����������ַ����±꣬��ʼֵΪ0,n-1��*/
 void mystrrev(char str[],int i,int j){
 	if(j-i>=1){
 		char temp = str[i];
 		str[i]=str[j];
 		str[j]=temp;
 		i++;
 		j--;
 		mystrrev(str,i,j);
	 }
 }
 int main(){
 	char str[200]={0};
 	scanf("%s",str);
 	mystrrev(str,0,strlen(str)-1);
 	printf("%s",str);
	return 0;
}
