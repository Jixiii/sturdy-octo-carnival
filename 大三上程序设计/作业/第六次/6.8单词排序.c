#include<stdio.h>
/*��Ŀ���ݣ�
��д���򣬶���������ɵ��ʰ��ʵ����򣬲����ִ�Сд��
Ҫ���ַ����ıȽϡ����ơ���Сдת��������ȹ������ú���ʵ�֣�ע�����Լ���д�����������ñ���д�ĺ�������
�������������뵥�ʣ����ú��������������������������ַ�������������100����ÿ�����ʵĳ��Ȳ�����20��
����ʹ��ϵͳ���ַ�������⺯��������ʹ�ñ�׼ģ������ͺ�����
�����ʽ��
���У���1��Ϊ���ʸ���n����2��Ϊn�����ʣ��ÿո������
�����ʽ:
n�У�ÿ��һ�����ʡ�
����������
5
sin cos log exp sqrt
���������
cos
exp
log
sin
sqrt*/
int compare(char str[200][50],int x, int y){
	int i = 0;
	for(i=0;i<50;i++){
		char tempx = str[x][i];
		char tempy = str[y][i];
		tempx = str[x][i]>='a'?str[x][i]-'a'+'A':str[x][i];
		tempy = str[y][i]>='a'?str[y][i]-'a'+'A':str[y][i];
		if(tempx!=tempy){
			return tempx-tempy;
		}
	}
	return 0;
}

void change(char str[200][50],int x, int y){
	int i;
	char temp;
	for(i = 0;i<50;i++){
		temp = str[x][i];
		str[x][i]=str[y][i];
		str[y][i]=temp;
	}
}


int main(){
	int n;
	char str[200][50]={0};
	scanf("%d",&n);
	int i;
	for(i = 0;i<n;i++){
		scanf("%s",&str[i]);
	}
	int j;
	for(i = 0;i<n-1;i++){
		for(j=0;j<n-1-i;j++){
			if(compare(str,j,j+1)>0){
				change(str,j,j+1);
			}
		}
	}
	for(i = 0;i<n;i++){
		printf("%s\n",str[i]);
	}
	return 0;
}
