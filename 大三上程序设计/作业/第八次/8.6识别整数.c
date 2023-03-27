#include<stdio.h>

/*有一段文字，其中有若干整数。编写函数，找出其中的整数，存入一个数组中。函数原型为：
int findint(char *s,int *a);
其中s表示带数字的字符串，a表示存整数的数组，返回值为字符串中的整数个数。字符串中只有正整数。

编写主函数，输入字符串，调用函数识别整数，逆序输出它们。
例如，输入字符串
“The Wandering Earth exhibition at the China Science and Technology Museum in Beijing, April 4, 2019.”
识别数字，输出“2019,4”。

输入：带空格字符串
输出：若干整数，用逗号隔开。
【输入输出样例】
输入：
he Wandering Earth exhibition at the China Science and Technology Museum in Beijing, April 4, 2019.
输出：
2019,4

题目延伸：（1）如果字符串中有负整数，如何修改程序。（2）如果字符串中是实数，如何编写程序。*/

int findint(char *str,int *num){
	int i=0;
	int sum=0;
	while(str[i]!='\0'){
		if(str[i]>='0'&&str[i]<='9'){
			num[sum]+=str[i]-'0';
			i++;
			while(str[i]>='0'&&str[i]<='9'){
				num[sum]*=10;
				num[sum]+=str[i]-'0';
				i++;
			}
			sum++;
		}
		i++;
	}
	return sum;
}

int main(){
	char str[5000]={0};
	int num[500]={0};
	gets(str);
	int n = findint(str,num);
	int i;
	printf("%d",num[n-1]);
	for(i=n-2;i>=0;i--){
		printf(",%d",num[i]);
	}
}
