#include<stdio.h>
/*����Ŀ������ ��д��������һ��4λ�����������䷴���ٳ���2���������ʾ����Ļ�ϡ�
��������1234������Ϊ4321������2���Ϊ8642�� 
��������������� 
���룺 1234 
���: 8642*/
int main(){
	int input, output;
	scanf("%d",&input);
	while(input!=0){
		output *= 10;
		output += input%10;
		input/=10;
	}
	printf("%d",output*2);
	return 0;
}
