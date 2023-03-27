#include<stdio.h>
#include <time.h> 
#include <windows.h>
#include <iostream> 
#include<fstream>
using namespace std;
#define MAXINT 214748647
char str1[100],str2[100];
int k;
int val[100][100];   //保存 
ifstream ifile;
void readfile()
{
	ifile>>str1;
	ifile>>str2;
	ifile>>k;
}

int dist(char a,char b)
{
	if(a==' '&&b==' ')
		return 0;
	if((a==' '&&b!=' ')||(a!=' '&&b==' '))
		return k;
	if(a>b) return a-b;
	else 	return b-a;
}

int dp()
{
	int i,j,tmp,len1,len2;
	val[0][0]=0;
	len1=strlen(str1);
	len2=strlen(str2);
	for(i=0;i<=len1;i++){
		for(j=0;j<=len2;j++){
			if(i+j){
				val[i][j]=MAXINT;
				if((i*j)&&(tmp=val[i-1][j-1]+dist(str1[i-1],str2[j-1]))<val[i][j])
					val[i][j]=tmp;						//str1第i-1个字符与str2第j-1个字符是对其的 
				if(i&&(tmp=val[i-1][j]+dist(str1[i-1],' '))<val[i][j])  //str2在j前处扩展空格 
					val[i][j]=tmp;
				if(j&&(tmp=val[i][j-1]+dist(str2[j-1],' '))<val[i][j])   //str1在i前处扩展空格 
					val[i][j]=tmp;
			}
		}
	}
	return val[len1][len2]; 
}

int main()
{
 	ifile.open("input.txt");
 	readfile();
 	ifile.close();
 	int ans; 
	ans=dp();
	cout<<ans;
	ofstream ofile("output.txt");
	ofile<<ans;
	ofile.close();
}
 
