#include<stdio.h>
/*����Ŀ������ ����4��ĸ��СдӢ�ĵ��ʺ�����k���������е�ÿ����ĸ�����ĵ�k����ĸ�滻(��ĸ����β���)��
������like 4�����pmoi 
��������������� 
���룺 like 4 
���: pmoi*/
int main(){
	int k;
	char input[10];
	scanf("%s%d",input, &k);
	int i;
	for(i = 0;i < 4;i++){
		input[i] = (char)(((int)input[i]+k-(int)'a')%26+(int)'a');
	}
	printf("%s",input);
	return 0;
}
