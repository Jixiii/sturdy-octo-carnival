#include<stdio.h>
/*输入五个字符，将其中的字母用原来字母后的第五个字母来代替
（比如'a'转换为'f'，'A'转换为'F','u'转换为‘z，以此类推），
其他字符不变。输出转换后的结果。例如：

输入：a123v

输出：f123a*/

int main(){
	char input[6];
	scanf("%s",input);
	int i;
	for(i = 0;i < 5;i++){
		if(input[i]>='a'&&input[i]<='z'){
			//input[i]=(char)(((int)input[i]-(int)'a'+5)%(int)'a'+(int)'a');
			input[i]=(char)(((int)input[i]-(int)'a'+5)%26+(int)'a');
		}else if(input[i]>='A'&&input[i]<='Z'){
			input[i]=(char)(((int)input[i]-(int)'A'+5)%26+(int)'A');
		}
	}
	printf("%s",input);
	return 0;
}
