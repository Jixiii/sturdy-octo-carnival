#include<stdio.h>
/*����һ���ַ����ֱ�ͳ�Ƴ�����Ӣ����ĸ�����֡��ո�������ַ��ĸ����� 
���룺һ��ASCII����ʾ�ַ��� 
�����4���Ǹ��������ֱ��ʾ��ĸ�����֡��ո�������ַ��ĸ�������һ���ո������ĩβ�޿ո� 
��ʾ��
(1)ʹ��getchar()ѭ�������ַ��� 
(2)��������ϵͳ��windwos�Ĳ��죬ѭ��������д�� 
while(c!='\r' && c!='\n') 
��������������� 
���룺 Year 2019 Month Mar. 
���: 12 4 3 1 ��ʾ��ʹ��getchar()ѭ�������ַ���*/
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
