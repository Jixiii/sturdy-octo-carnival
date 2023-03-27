#include<stdio.h>
#include<string.h>
/*编写函数，将字符串s1中从第n个字符开始的最多k个字符复制到字符串s2中。
最多的意思是如果s1从n开始的字符不够k个，则复制到末尾为止。
如s1="study",n=4,k=5,则只复制dy”两个字符。函数返回s2的首地址。函数原型为：
char * copykn(char *s1,char *s2,int n,int k)
编写主函数，输入字符，n和k，调用函数复制，输出结果字符串。主函数为：
int main(){
char s1[100],s2[100];
int n,k;
gets(s1);
scanf("%d %d",&n,&k);
puts(copykn(s1,s2,n,k));
return 0;
}
【输入输出样例】
输入：
communication
2 3
输出:
omm*/
char *copykn(char *s1,char *s2,int n,int k){
	int i=0;
	if(n>strlen(s1)){
		return s2;
	}
	for(i=0;i<k;i++){
		s2[i]=s1[i+n-1];
	}
	return s2;
}


int main(){
	char s1[100]={0},s2[100]={0};
	int n,k;
	scanf("%s",s1);
	scanf("%d%d",&n,&k);
	printf("%s",copykn(s1,s2,n,k));
	return 0;
}
