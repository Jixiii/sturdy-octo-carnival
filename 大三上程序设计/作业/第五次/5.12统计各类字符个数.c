#include<stdio.h>
/*����Ŀ������
����һƪ���£���3�����֣�ÿ�в�����80���ַ�����ͳ�Ƴ����ĵĴ�д��ĸ��Сд��ĸ�����֡��ո��Լ������ַ��ĸ�����
���룺����Ӣ�����֣������пո����֡����ȷ��š�
�����5���������ÿո�������ֱ��ʾ��д��ĸ��Сд��ĸ�����֡��ո��Լ������ַ��ĸ�����
���������������
���룺
year 2019
Month 3
DAY 20!
���:
4 8 7 3 1*/
int main(){
	char input[3][1000]={0};
	int i;
	for(i = 0;i<3;i++){
		gets(input[i]);
	}
	int num[5]={0};
	for(i = 0;i<3;i++){
		int j = 0;
		while(input[i][j]){
			if(input[i][j]>='A'&&input[i][j]<='Z'){
				num[0]++;
			}else if(input[i][j]>='a'&&input[i][j]<='z'){
				num[1]++;
			}else if(input[i][j]>='0'&&input[i][j]<='9'){
				num[2]++;
			}else if(input[i][j]==' '){
				num[3]++;
			}else{
				num[4]++;
			}
			j++;
		}
	}
	printf("%d",num[0]);
	for(i = 1;i<5;i++){
		printf(" %d",num[i]);
	}
	return 0;
}
