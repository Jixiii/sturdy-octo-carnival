#include<stdio.h> 
/*дһ���ж������ĺ�������������������һ�������������������YES���������������NO�����Ƿ������������ERROR��
���룺����
���: YES,NO,ERROR֮һ��
���������������
���룺
2
�����
YES*/
int main(){
	int input;
	scanf("%d",&input);
	switch(isSuShu(input)){
		case -1:
		printf("ERROR");
		break;
		case 0:
		printf("NO");
			break;
		case 1:
		printf("YES");
		break;
	}
	return 0;
}
int isSuShu(int x){
	if(x<=0){
		return -1;
	}
	int i;
	if(x==1){
		return 0;
	}
	for(i = 2;i<x;i++){
		if(x%i==0){
			return 0;
		}
	}
	return 1;
}
