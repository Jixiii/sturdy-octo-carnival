#include<stdio.h>
/*��Ŀ���ݣ�
�ֱ��д������������Ԫ�أ�����-9999��ʾ����������С������������Ԫ�ء��ö��ַ������������в��ң������±꣩��
��д�����������ú����������롢����Ͳ��ҡ�����Ԫ�ز�����100������Ϊ������
�����ʽ��
���У���1��Ϊ���������Ԫ�أ���-9999��������2������5�������ҵ�Ԫ�ء������ÿո������
�����ʽ��
5�У�ÿ���ǲ��ҵ���Ԫ�ص��±꣬�Ҳ���ʱ���Ϊ-1��
����������
2 1 3 4 5 -9999
2 3 4 -10 10
���������
1
2
3
-1
-1*/
int find(int num[101],int lenth,int search){
	int left,right,mid;
	left = 0;
	right = lenth;
	while(right-left>0){
		mid = (left+right)/2;
		if(num[mid]==search){
			return mid;
		}else if(num[mid]>search){
			right = mid;
		}else{
			left = mid+1;
		}
	}
	return -1;
}

void maoPao(int num[101],int n){
	int i,j,temp;
	for(i=0;i<n;i++){
		for(j=0;j<n-i-1;j++){
			if(num[j]>num[j+1]){
				temp = num[j];
				num[j]=num[j+1];
				num[j+1]=temp;
			}
		}
	}
}

int main(){
	int num[101],i=0,j,search;
	scanf("%d",&num[i]);
	while(num[i]!=-9999){
		i++;
		scanf("%d",&num[i]);
	}
	maoPao(num,i);
	for(j=0;j<5;j++){
		scanf("%d",&search);
		printf("%d\n",find(num,i,search));
	}
	return 0;
}


