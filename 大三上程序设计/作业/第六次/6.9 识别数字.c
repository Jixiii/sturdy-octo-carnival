#include<stdio.h>
#include<string.h>
/*题目内容：
编写函数，输出字符串中的所有整数。要考虑正、负数。
编写主函数，输入带空格的字符串，调用函数输出其中的整数。
输入格式：
一行，表示一个句子，中间可能有空格，有若干整数。
输出格式：
一行，若干整数，用一个空格隔开，末尾无空格。
注意：单独符号不算数字，但-0为0,+0也为0。
输入样例：
CHINA DAILY | Updated: 2020-03-21 07:57
输出样例：
2020 -3 -21 7 57*/
int main(){
	char str[100]={0};
	gets(str);
	int num[100]={0},sum=0,i=0;
	//printf("%s",str);
	
	while(i<strlen(str)){
		if(str[i]=='-'){
			i++;
			if(str[i]<='9'&&str[i]>='0'){
				while(str[i]<='9'&&str[i]>='0'){
					num[sum]*=10;
					num[sum]+=str[i]-'0';
					i++;
				}
				num[sum] *= -1;
				sum++;
				i--;
			}
		}else if(str[i]=='+'){
			i++;
			if(str[i]<='9'&&str[i]>='0'){
				while(str[i]<='9'&&str[i]>='0'){
					num[sum]*=10;
					num[sum]+=str[i]-'0';
					i++;
				}
				sum++;
				i--;
			}
		}else if(str[i]<='9'&&str[i]>='0'){
			num[sum]+=str[i]-'0';
			i++;
			while(str[i]<='9'&&str[i]>='0'){
				num[sum]*=10;
				num[sum]+=str[i]-'0';
				i++;
			}
			sum++;
			i--;
		}
		i++;
	}
	if(sum==0){
		return 0;
	}
	printf("%d",num[0]); 
	for(i = 1;i<sum;i++){
		printf(" %d",num[i]); 
	}
	return 0;
}
