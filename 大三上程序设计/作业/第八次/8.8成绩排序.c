#include<stdio.h>
/*
��д��������������n��n��ѧ����ѧ�ź����ſγ̳ɼ�������ÿ���˵�ƽ���֣���ƽ���ִ�С�������������������
ѧ�ŵĳ��Ȳ�����10λ��
���ſγ̳ɼ�Ϊ������ƽ
���ɼ�Ϊʵ�������ƽ���ɼ�������λС����
ѧ������������50�ˡ� ��ʾ�����ö������ʵ�֡� 
��������������� 
���룺 5 001 80 80 80 002 60 70 80 003 80 90 93 004 50 60 70 005 60 70 83 
����� 004 50 60 70 60.00 002 60 70 80 70.00 005 60 70 83 71.00 001 80 80 80 80.00 003 80 90 93 87.67*/
struct stu{
	char xuehao[20];
	int chengji[3];
	float junfen;
}stu[501];

void f(int k){
	stu[k].junfen=(float) (stu[k].chengji[0]+stu[k].chengji[1]+stu[k].chengji[2]+0.0)/3.0;
}

void sort(int n){
	int i = 0;
	for(i=0;i<n;i++){
		f(i);
	}
	int k=0,j=0;
	for(i=0; i<n-1; i++){
		k=i;
		for(j=i+1; j<n; j++){
			if(stu[k].junfen>stu[j].junfen){
				k=j;
			}
		}
		if(k!=i){
			mycpy(500,i);
			mycpy(i,k);
			mycpy(k,500);
		}
	}
}

void mycpy(int x,int y){
	stu[x].junfen=stu[y].junfen;
	int i=0;
	for(i=0;i<3;i++){
		stu[x].chengji[i]=stu[y].chengji[i];
	}
	for(i=0;i<20;i++){
		stu[x].xuehao[i]=stu[y].xuehao[i];
	}
	return;
}

void print(int i){
	printf("%s %d %d %d %.2f\n",stu[i].xuehao,stu[i].chengji[0],stu[i].chengji[1],stu[i].chengji[2],stu[i].junfen);
}

int main(){
	int n=0;
	scanf("%d",&n);
	int i = 0;
	for(i=0;i<n;i++){
		scanf("%s%d%d%d",&stu[i].xuehao,&stu[i].chengji[0],&stu[i].chengji[1],&stu[i].chengji[2]);
	}
	sort(n);
	for(i=0;i<n;i++){
		print(i);
	}
	return 0;
}
