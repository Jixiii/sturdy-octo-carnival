#include<stdio.h>
/*���벻����5λ�ķǸ��������ж����Ǽ�λ����������1234�����4��
���������������
���룺
1234
���:
4*/
int main(){
	int output, input;
	scanf("%d", &input);
	while(input){
		input/=10;
		output++;
	}
	printf("%d",output);
	return 0;
}
