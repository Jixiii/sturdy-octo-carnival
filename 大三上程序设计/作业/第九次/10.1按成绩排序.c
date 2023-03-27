#include<stdio.h>
/*定义结构体表示一个人的信息，包括学号、姓名、数学成绩、语文成绩、外语成绩、总成绩。
编写程序，输入4个人的基本信息（不含总成绩），计算每个人的总成绩，按总成绩从高到低排序，再输出。
输入：4行，每行是一个人的信息。成绩的数据类型均用int。
输出：4行，排序后的结果，含总成绩，一行中的数据间以一个空格隔开，末尾无空格。

【输入输出样例】
输入：
001 zhang 61 62 63
002 wang 60 70 80
003 sun 70 80 75
004 zhang 54 88 90
输出：
004 zhang 54 88 90 232
003 sun 70 80 75 225
002 wang 60 70 80 210
001 zhang 61 62 63 186*/

struct Students{
	char xuehao[10];
	char name[20];
	int math;
	int chi;
	int eng;
	int sum;
}stu[5];

void sort(){
	int i=0;
	for(i=0;i<4;i++){
		f(i);
	}
	int j;
	for(i=3;i>=0;i--){
		for(j=0;j<i;j++){
			if(stu[j].sum<stu[j+1].sum){
				change(j,j+1);
			}
		}
	}
}

void f(int i){
	stu[i].sum=stu[i].math+stu[i].chi+stu[i].eng; 
}

void change(int x,int y){
	stu[5].chi=stu[x].chi;
	stu[x].chi=stu[y].chi;
	stu[y].chi=stu[5].chi;
	
	stu[5].eng=stu[x].eng;
	stu[x].eng=stu[y].eng;
	stu[y].eng=stu[5].eng;
	
	stu[5].math=stu[x].math;
	stu[x].math=stu[y].math;
	stu[y].math=stu[5].math;
	
	stu[5].sum=stu[x].sum;
	stu[x].sum=stu[y].sum;
	stu[y].sum=stu[5].sum;
	
	int i=0;
	for(i=0;i<10;i++){
		stu[5].xuehao[i]=stu[x].xuehao[i];
		stu[x].xuehao[i]=stu[y].xuehao[i];
		stu[y].xuehao[i]=stu[5].xuehao[i];
	}
	
	for(i=0;i<20;i++){
		stu[5].name[i]=stu[x].name[i];
		stu[x].name[i]=stu[y].name[i];
		stu[y].name[i]=stu[5].name[i];
	}
}

int main(){
	int i = 0;
	for(i=0;i<4;i++){
		scanf("%s%s%d%d%d",&stu[i].xuehao,&stu[i].name,&stu[i].math,&stu[i].chi,&stu[i].eng);
	}
	sort();
	for(i=0;i<4;i++){
		printf("%s %s %d %d %d %d\n",stu[i].xuehao,stu[i].name,stu[i].math,stu[i].chi,stu[i].eng,stu[i].sum);
	}
	return 0;
}
