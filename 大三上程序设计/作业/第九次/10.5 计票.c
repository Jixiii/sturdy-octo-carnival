#include<stdio.h>
#include<string.h>
/*有四个候选人zhao,qian,sun，wang参加评选，编写计票程序，统计每个人的得票数量，
按得票从多到少的顺序显示每个人的名字和得票数。
输入：若干行、若干列的合理人名，人名间用空格隔开，最后是000表示结束。
输出：四行，每行是一个人的名字和得票数，中间用一个空格隔开。
【输入输出样例】
输入：
zhao qian sun wang wang wang wang
sun sun qian 000
输出：
wang 4
sun 3
qian 2
zhao 1*/

struct r{
	char name[10];
	int piao;
}ren[4];

void sort(){
	struct r change;
	int i = 0;
	int j=0;
	for(i=3;i>=0;i--){
		for(j=0;j<i;j++){
			if(ren[j].piao<ren[j+1].piao){
				change.piao=ren[j].piao;
				ren[j].piao=ren[j+1].piao;
				ren[j+1].piao=change.piao;
				
				strcpy(change.name,ren[j].name);
				strcpy(ren[j].name,ren[j+1].name);
				strcpy(ren[j+1].name,change.name);
				

			}
		}
	}
}

int main(){
	strcpy(ren[0].name,"zhao");
	strcpy(ren[1].name,"qian");
	strcpy(ren[2].name,"sun");
	strcpy(ren[3].name,"wang");
	/*
	ren[0].name="zhao";
	ren[1].name="qian"; 
	ren[2].name="sun";
	ren[3].name="wang";*/
	ren[0].piao=0;
	ren[1].piao=0;
	ren[2].piao=0;
	ren[3].piao=0;
	
	char temp[10]={0};
	while(1){
		scanf("%s",temp);
		if(temp[0]=='0'){
			break;
		}else if(temp[0]=='z'){
			ren[0].piao++;
		}else if(temp[0]=='q'){
			ren[1].piao++;
		}else if(temp[0]=='s'){
			ren[2].piao++;
		}else if(temp[0]=='w'){
			ren[3].piao++;
		}
	}
	sort();
	
	int i = 0;
	for(i=0;i<4;i++){
		printf("%s %d\n",ren[i].name,ren[i].piao);
	}
	return 0;
}
