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

void change(char str[200][50],int x, int y){
	char temp;
	int i;
	for(i = 0;i<50;i++){
		temp = str[y][i];
		str[y][i]=str[x][i];
		str[x][i]=temp;
	}
}

int compare(char str[200][50],int x, int y){
	int i = 0;
	for(i=0;i<50;i++){
		char tempx = str[x][i];
		char tempy = str[y][i];
		/*tempx = str[x][i]>='a'?str[x][i]-'a'+'A':str[x][i];
		tempy = str[y][i]>='a'?str[y][i]-'a'+'A':str[y][i];*/
		if(str[y][i]>='a'){
			tempy = str[y][i]-'a'+'A';
		}else{
			tempy = str[y][i];
		}
		if(str[x][i]>='a'){
			tempx = str[x][i]-'a'+'A';
		}else{
			tempx = str[x][i];
		}
		if(tempx!=tempy){
			return tempx-tempy;
		}
	}
	return 0;
}


int main(){
	int n;
	char str[200][50]={0};
	scanf("%d",&n);
	int i;
	/*
	for(i = 0;i<n;i++){
		scanf("%s",&str[i]);
	}*/
	i=0;
	while(i<n){
		scanf("%s",&str[i]);
		i++;
	}
	int j;
	for(i = 0;i<n-1;i++){
		for(j=0;j<n-1-i;j++){
			if(compare(str,j,j+1)>0){
				change(str,j,j+1);
			}
		}
	}
	for(j = 0;j<n;j++){
		printf("%s\n",str[j]);
	}
	return 0;
}
