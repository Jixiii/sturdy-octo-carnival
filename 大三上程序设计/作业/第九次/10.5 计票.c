#include<stdio.h>
#include<string.h>
/*���ĸ���ѡ��zhao,qian,sun��wang�μ���ѡ����д��Ʊ����ͳ��ÿ���˵ĵ�Ʊ������
����Ʊ�Ӷൽ�ٵ�˳����ʾÿ���˵����ֺ͵�Ʊ����
���룺�����С������еĺ����������������ÿո�����������000��ʾ������
��������У�ÿ����һ���˵����ֺ͵�Ʊ�����м���һ���ո������
���������������
���룺
zhao qian sun wang wang wang wang
sun sun qian 000
�����
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
