#include<stdio.h>
/*���1!+2!+3!+...+10!��ֵ ��
�����ʽ���£�
1!+2!+3!+...+10!=��õ�ֵ*/
int main(){
	int jiecheng[10] = {1};
	int i;
	int sum=1;
	for(i = 1;i < 10;i++){
		jiecheng[i] = i+1;
		jiecheng[i]*=jiecheng[i-1];
		sum += jiecheng[i];
	}
	printf("1!+2!+3!+...+10!=%d", sum);
	return 0;
}
