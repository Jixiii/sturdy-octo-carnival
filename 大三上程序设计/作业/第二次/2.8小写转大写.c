/*��д��������һ������Ϊ4��СдӢ�ĵ��ʣ�����ת��Ϊ��д��������like�����LIKE�� 
��������������� 
���룺 like 
���: LIKE 
����ʾ����������ʽ"%c%c%c%c"������ֱ�������������ĸ���ĸ����ĸ�䲻��ո�*/
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
