#include<stdio.h>
/*����ṹ���ʾһ���˵���Ϣ������ѧ�š���������ѧ�ɼ������ĳɼ�������ɼ����ܳɼ���
��д��������4���˵Ļ�����Ϣ�������ܳɼ���������ÿ���˵��ܳɼ������ܳɼ��Ӹߵ��������������
���룺4�У�ÿ����һ���˵���Ϣ���ɼ����������;���int��
�����4�У������Ľ�������ܳɼ���һ���е����ݼ���һ���ո������ĩβ�޿ո�

���������������
���룺
001 zhang 61 62 63
002 wang 60 70 80
003 sun 70 80 75
004 zhang 54 88 90
�����
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
