#include<stdio.h>
/*����n, ���������1/2, 2/3, 3/5, 5/8, 8/13���� 
��n���ǰn��ĺͣ�ÿһ�����Ϊǰһ��ķ�ĸ����ĸ��ǰһ��������ĸ�ĺͣ� 
���룺������ 
���������ʵ������һ���ո��������ʽ%g�� 
��������������� 
���룺 10 
����� 0.618056 6.09796*/
int main(){
	double output = 0.5,sum = 0.5;
	int intnum[1000] = {1, 2};
	int n;
	scanf("%d", &n);
	int i = 2;
	for(;i <= n;i++){
		intnum[i] = intnum[i-1] +intnum[i-2];
		output = (double) intnum[i-1]/intnum[i];
		sum += output;
	}
	printf("%g %g", output, sum);
	return 0;
}
