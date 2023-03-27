#include<stdio.h>
/*编写函数，根据月份的阿拉伯数字，返回月份英文单词的地址，在主函数中显示英文单词。月份英文单词首字母大写。
函数原型：
char * getmonth(int n)
编写主函数，输入月份的数字，输出对应的英文单词。如果输入1-12以外的数字吗，显示"error"。主函数：
int main()
{
int n,k;
n=inputint();
printf("%s\n",getmonth( n ));
return 0;

输入：一个整数。
输出：代表月份的英文单词或“error”
【输入输出样例1】
输入：
2
输出：
February
【输入输出样例2】
输入：
0
输出：
error*/
char str[12][30]={"January","February","March","April","May","June","July",
	"August","September","October","November","December"};

char *getmonth(int n){
	//char str[12][30]={"January","February","March","April","May","June","July",
	//"August","September","October","November","December"};
	return &str[n-1][0];
}

int main(){
	int n;
	scanf("%d",&n);
	if(n>0&&n<13){
		printf("%s\n",getmonth(n));
	}else{
		printf("error");
	}
	return 0;
}
