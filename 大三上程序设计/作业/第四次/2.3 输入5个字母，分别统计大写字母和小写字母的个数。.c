#include<stdio.h>
/*����5����ĸ���ֱ�ͳ�ƴ�д��ĸ��Сд��ĸ�ĸ�����Ҫ�������ַ��ö��ŷָ��������ʽ���£�
a,A,r,g,R
�����ʽ���£�
��д��ĸ����=2
Сд��ĸ����=3
��������,�ָ������֮���޿��У�*/
int main(){
	char input[100];
	int Bnum=0,Snum=0;
	scanf("%s",input);
	int i;
	for(i = 0;i <strlen(input);i++){
		if(input[i]>='a'&&input[i]<='z'){
			Snum++;
		}else if(input[i]>='A'&&input[i]<='Z'){
			Bnum++;
		}
	}
	printf("��д��ĸ����=%d\nСд��ĸ����=%d", Bnum, Snum);
	return 0;
}
