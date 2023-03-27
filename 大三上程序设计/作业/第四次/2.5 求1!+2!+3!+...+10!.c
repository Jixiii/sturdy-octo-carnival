#include<stdio.h>
/*输出1!+2!+3!+...+10!的值 。
输出格式如下：
1!+2!+3!+...+10!=求得的值*/
int main(){
	int jiecheng[10] = {1};
	int i;
	int sum=1;
	for(i = 1;i < 10;i++){
		jiecheng[i] = i+1;
		jiecheng[i]*=jiecheng[i-1];
		sum += jiecheng[i];
	}
	printf("1!+2!+3!+...+10!=%d", sum);
	return 0;
}
