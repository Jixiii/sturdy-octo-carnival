#include<stdio.h>

void input_int(char *arr);

int main()
{
	char arr[100];
	gets(arr);
	input_int(arr);
	return 0;
}

void input_int(char* arr)
{
	int output = 0;
	int i=0;
	for (i = 0; i < 100; i++)
	{
		if (arr[i] >= '0' && arr[i] <= '9')
		{
			output = 10 * output + arr[i]-'0';
		}
		else if(output!=0)
		{
			printf("%d ", output);
			output = 0;
		}

		if (arr[i] == '-' && output == 0)
		{
			char a = '-';
			printf("%c", a);
		}
	}
}
