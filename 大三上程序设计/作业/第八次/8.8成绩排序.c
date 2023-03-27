#include<stdio.h>
/*
编写程序，输入正整数n和n个学生的学号和三门课程成绩，计算每个人的平均分，按平均分从小到大排序，输出排序结果。
学号的长度不超过10位；
三门课程成绩为整数；平
均成绩为实数，输出平均成绩保留两位小数；
学生人数不超过50人。 提示：请用多个函数实现。 
【输入输出样例】 
输入： 5 001 80 80 80 002 60 70 80 003 80 90 93 004 50 60 70 005 60 70 83 
输出： 004 50 60 70 60.00 002 60 70 80 70.00 005 60 70 83 71.00 001 80 80 80 80.00 003 80 90 93 87.67*/
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
