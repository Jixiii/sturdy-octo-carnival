#include<stdio.h>
/*��Ŀ���ݣ� ��д��������һ���ַ���
��ʾ���ַ�����ASCII��ʮ���ơ��˽��ƺ�ʮ��������ʽ��
������A����ʾA 65 101 41����ʮ��������ĸ��Сд�� 
����:һ���ַ��� 
������ַ����ַ���ʮ���ơ��˽��ƺ�ʮ�����ƣ�Сд����ʽ�����ݼ���һ���ո������ 
��������1�� A 
�������1�� A 65 101 41*/
int main(){
	char input;
	scanf("%c",&input);
	int decimal = (int)input;
	printf("%c %d %o %x",input,(int)input,(int)input,(int)input);
	return 0;
}
