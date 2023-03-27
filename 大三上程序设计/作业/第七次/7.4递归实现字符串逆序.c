#include<stdio.h>
#include<string.h>
/*编写函数，使用递归实现字符串的逆序。编写主函数，输入字符串，调用函数逆序，输出字符串。
要求1不使用库函数，2采用递归，3不在逆序函数中输出。 
输入：不带空格的字符串,长度小于200。 输出：逆序的字符串。 
【输入输出样例】 
输入： abcdef 输出: fedcba 
提示：逆序函数的参考原型： void mystrrev(char s[],int I,int j);
 其中i,j为要交换的两个字符的下标，起始值为0,n-1。*/
 void mystrrev(char str[],int i,int j){
 	if(j-i>=1){
 		char temp = str[i];
 		str[i]=str[j];
 		str[j]=temp;
 		i++;
 		j--;
 		mystrrev(str,i,j);
	 }
 }
 int main(){
 	char str[200]={0};
 	scanf("%s",str);
 	mystrrev(str,0,strlen(str)-1);
 	printf("%s",str);
	return 0;
}
