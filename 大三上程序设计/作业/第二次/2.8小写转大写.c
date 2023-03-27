/*编写程序，输入一个长度为4的小写英文单词，将其转换为大写，如输入like，输出LIKE。 
【输入输出样例】 
输入： like 
输出: LIKE 
【提示】输入语句格式"%c%c%c%c"，键盘直接输入连续的四个字母，字母间不需空格。*/
int main(){
	char input[10];
	scanf("%s",input);
	int i;
	for(i = 0;i < 4;i++){
		input[i] += 'A'-'a';
	}
	printf("%s",input);
	return 0;
}
