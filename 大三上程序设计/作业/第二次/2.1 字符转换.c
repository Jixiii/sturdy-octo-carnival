#include<stdio.h>
/*��������ַ��������е���ĸ��ԭ����ĸ��ĵ������ĸ������
������'a'ת��Ϊ'f'��'A'ת��Ϊ'F','u'ת��Ϊ��z���Դ����ƣ���
�����ַ����䡣���ת����Ľ�������磺

���룺a123v

�����f123a*/

int main(){
	char input[6];
	scanf("%s",input);
	int i;
	for(i = 0;i < 5;i++){
		if(input[i]>='a'&&input[i]<='z'){
			//input[i]=(char)(((int)input[i]-(int)'a'+5)%(int)'a'+(int)'a');
			input[i]=(char)(((int)input[i]-(int)'a'+5)%26+(int)'a');
		}else if(input[i]>='A'&&input[i]<='Z'){
			input[i]=(char)(((int)input[i]-(int)'A'+5)%26+(int)'A');
		}
	}
	printf("%s",input);
	return 0;
}
