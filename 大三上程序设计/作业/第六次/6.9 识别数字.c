#include<stdio.h>
#include<string.h>
/*��Ŀ���ݣ�
��д����������ַ����е�����������Ҫ��������������
��д��������������ո���ַ��������ú���������е�������
�����ʽ��
һ�У���ʾһ�����ӣ��м�����пո�������������
�����ʽ��
һ�У�������������һ���ո������ĩβ�޿ո�
ע�⣺�������Ų������֣���-0Ϊ0,+0ҲΪ0��
����������
CHINA DAILY | Updated: 2020-03-21 07:57
���������
2020 -3 -21 7 57*/
int main(){
	char str[100]={0};
	gets(str);
	int num[100]={0},sum=0,i=0;
	//printf("%s",str);
	
	while(i<strlen(str)){
		if(str[i]=='-'){
			i++;
			if(str[i]<='9'&&str[i]>='0'){
				while(str[i]<='9'&&str[i]>='0'){
					num[sum]*=10;
					num[sum]+=str[i]-'0';
					i++;
				}
				num[sum] *= -1;
				sum++;
				i--;
			}
		}else if(str[i]=='+'){
			i++;
			if(str[i]<='9'&&str[i]>='0'){
				while(str[i]<='9'&&str[i]>='0'){
					num[sum]*=10;
					num[sum]+=str[i]-'0';
					i++;
				}
				sum++;
				i--;
			}
		}else if(str[i]<='9'&&str[i]>='0'){
			num[sum]+=str[i]-'0';
			i++;
			while(str[i]<='9'&&str[i]>='0'){
				num[sum]*=10;
				num[sum]+=str[i]-'0';
				i++;
			}
			sum++;
			i--;
		}
		i++;
	}
	if(sum==0){
		return 0;
	}
	printf("%d",num[0]); 
	for(i = 1;i<sum;i++){
		printf(" %d",num[i]); 
	}
	return 0;
}
