#include<stdio.h>

/*��һ�����֣�������������������д�������ҳ����е�����������һ�������С�����ԭ��Ϊ��
int findint(char *s,int *a);
����s��ʾ�����ֵ��ַ�����a��ʾ�����������飬����ֵΪ�ַ����е������������ַ�����ֻ����������

��д�������������ַ��������ú���ʶ������������������ǡ�
���磬�����ַ���
��The Wandering Earth exhibition at the China Science and Technology Museum in Beijing, April 4, 2019.��
ʶ�����֣������2019,4����

���룺���ո��ַ���
����������������ö��Ÿ�����
���������������
���룺
he Wandering Earth exhibition at the China Science and Technology Museum in Beijing, April 4, 2019.
�����
2019,4

��Ŀ���죺��1������ַ������и�����������޸ĳ��򡣣�2������ַ�������ʵ������α�д����*/

int findint(char *str,int *num){
	int i=0;
	int sum=0;
	while(str[i]!='\0'){
		if(str[i]>='0'&&str[i]<='9'){
			num[sum]+=str[i]-'0';
			i++;
			while(str[i]>='0'&&str[i]<='9'){
				num[sum]*=10;
				num[sum]+=str[i]-'0';
				i++;
			}
			sum++;
		}
		i++;
	}
	return sum;
}

int main(){
	char str[5000]={0};
	int num[500]={0};
	gets(str);
	int n = findint(str,num);
	int i;
	printf("%d",num[n-1]);
	for(i=n-2;i>=0;i--){
		printf(",%d",num[i]);
	}
}
