#include<stdio.h>
/*��д�����������·ݵİ��������֣������·�Ӣ�ĵ��ʵĵ�ַ��������������ʾӢ�ĵ��ʡ��·�Ӣ�ĵ�������ĸ��д��
����ԭ�ͣ�
char * getmonth(int n)
��д�������������·ݵ����֣������Ӧ��Ӣ�ĵ��ʡ��������1-12�������������ʾ"error"����������
int main()
{
int n,k;
n=inputint();
printf("%s\n",getmonth( n ));
return 0;

���룺һ��������
����������·ݵ�Ӣ�ĵ��ʻ�error��
�������������1��
���룺
2
�����
February
�������������2��
���룺
0
�����
error*/
char str[12][30]={"January","February","March","April","May","June","July",
	"August","September","October","November","December"};

char *getmonth(int n){
	//char str[12][30]={"January","February","March","April","May","June","July",
	//"August","September","October","November","December"};
	return &str[n-1][0];
}

int main(){
	int n;
	scanf("%d",&n);
	if(n>0&&n<13){
		printf("%s\n",getmonth(n));
	}else{
		printf("error");
	}
	return 0;
}
