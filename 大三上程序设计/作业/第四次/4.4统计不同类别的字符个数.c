#include<stdio.h>
/*输入一行字符，分别统计出其中英文字母、数字、空格和其他字符的个数。 
输入：一行ASCII可显示字符。 
输出：4个非负整数，分别表示字母、数字、空格和其他字符的个数，用一个空格隔开，末尾无空格。 
提示，
(1)使用getchar()循环输入字符。 
(2)由于评测系统和windwos的差异，循环条件请写： 
while(c!='\r' && c!='\n') 
【输入输出样例】 
输入： Year 2019 Month Mar. 
输出: 12 4 3 1 提示，使用getchar()循环输入字符。*/
int main(){
	char str[100];
	int charsum = 0, intsum = 0, blankspacesum = 0,othersum = 0;
	/*char temp = getchar();
	while(temp != '\r' && temp != '\n' && temp != '\0'){
		if(temp>='0'&&temp<='9'){
			intsum++;	
		}else if((temp>='a'&&temp<='z')||(temp>='A'&&temp<='Z')){
			charsum++;
		}else if(temp==' '){
			blankspacesum++;
		}else{
			othersum++;
		}
		temp = getchar();
	}
	printf("%d %d %d %d", charsum, intsum, blankspacesum, othersum);
	return 0;*/
	//scanf("%s", str);
	gets(str);
	int i;
	for(i = 0;i < strlen(str);i++){
		if(str[i]>='0'&&str[i]<='9'){
			intsum++;	
		}else if((str[i]>='a'&&str[i]<='z')||(str[i]>='A'&&str[i]<='Z')){
			charsum++;
		}else if(str[i]==' '){
			blankspacesum++;
		}else{
			othersum++;
		}
	}
	printf("%d %d %d %d", charsum, intsum, blankspacesum, othersum);
	return 0;
}
