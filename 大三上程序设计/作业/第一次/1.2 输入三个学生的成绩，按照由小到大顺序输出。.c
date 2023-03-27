#include<stdio.h>
/*输入三个学生的成绩，按照由小到大顺序输出。输入输出格式如下：

输入：76,85,70

输出格式：70,76,85*/
int main(){
	int input[3];
	scanf("%d,%d,%d",&input[0], &input[1], &input[2]);
	int i;
	for(i=0;i < 2; i++){
		int j;
		for(j=0; j<2-i;j++){
			if(input[j]>input[j+1]){
				int temp = input[j];
				input[j] = input[j+1];
				input[j+1] = temp;
			}
		}
	}
	printf("%d,%d,%d",input[0],input[1],input[2]);
	return 0;
}
