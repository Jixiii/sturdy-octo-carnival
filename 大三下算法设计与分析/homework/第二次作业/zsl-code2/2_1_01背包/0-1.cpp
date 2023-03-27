#include<stdio.h>
#include <time.h> 
#include <windows.h>
#include <iostream> 
#include<fstream>
using namespace std;
int m[1002][1002];
int n,c;
int w[1002],v[1002];
ifstream ifile;
ofstream ofile;
void readfile()
{
	ifile>>n>>c;
	for(int i=1;i<=n;i++){
		ifile>>w[i]>>v[i];
	}
}
int dp()
{
	int jMax=min(w[n]-1,c);
	for(int j=0;j <= jMax;j++)
		m[n][j]=0;  			//m[i][j]表示i。。n物品放入容量j背包的最大价值；          
	for(int j=w[n];j<=c;j++)
		m[n][j]=v[n];
	for(int i=n-1;i>1;i--){
		jMax=min(w[i]-1,c);  //jmax的作用是减少遍历的范围（j可以到的最大值） 
		for(int j=0;j<=jMax;j++)  
			m[i][j]=m[i+1][j];     
		for(int j=w[i];j<=c;j++){   //这个循环代表j大小背包可以放入i物品 
			m[i][j]=max(m[i+1][j],m[i+1][j-w[i]]+v[i]); //放入与不放入取大值 
		}
	}
	m[1][c]=m[2][c];	
	if(c>=w[1])        //i=2的 m 的值全部已知，直接计算m[1][c]即可，其余m[1][j]没必要再算 
		m[1][c]=max(m[1][c],m[2][c-w[1]]+v[1]);
	return m[1][c];
}
int main()
{
	
	//例题 
	ifile.open("input.txt");
 	readfile();
 	ifile.close();
 	ofile.open("output.txt");
 	ofile<<dp();
 	ofile.close(); 
 	
	//三种规模数据
	printf("Small size:\n");
 	LARGE_INTEGER frequency;
 	double v,beginoftime,endoftime,dt,t;//时钟的频率，起始，实际时间差，实际时间 
 	
 	ifile.open("10.txt");
 	readfile();
 	ifile.close();
 	QueryPerformanceFrequency(&frequency);//获得时钟频率
 	v=(double)frequency.QuadPart;//取得频率*/
 	QueryPerformanceCounter(&frequency);
    beginoftime=frequency.QuadPart;//获得初始值
	cout<<dp();
 	QueryPerformanceCounter(&frequency);
    endoftime=frequency.QuadPart;//获得终止值
    dt=(double)(endoftime-beginoftime);//差值
    t=dt/v;//差值除以频率得到时间
	cout<<endl<<"Time is "<<t*1000<<"ms\n"; 
	
	printf("Medium size:\n");
 	ifile.open("100.txt");
 	readfile();
 	ifile.close();
 	QueryPerformanceFrequency(&frequency);//获得时钟频率
 	v=(double)frequency.QuadPart;//取得频率*/
 	QueryPerformanceCounter(&frequency);
    beginoftime=frequency.QuadPart;//获得初始值
	cout<<dp();
 	QueryPerformanceCounter(&frequency);
    endoftime=frequency.QuadPart;//获得终止值
    dt=(double)(endoftime-beginoftime);//差值
    t=dt/v;//差值除以频率得到时间
	cout<<endl<<"Time is "<<t*1000<<"ms\n"; 
	
	printf("Large size:\n");
 	ifile.open("1000.txt");
 	readfile();
 	ifile.close();
 	QueryPerformanceFrequency(&frequency);//获得时钟频率
 	v=(double)frequency.QuadPart;//取得频率*/
 	QueryPerformanceCounter(&frequency);
    beginoftime=frequency.QuadPart;//获得初始值
	cout<<dp();
 	QueryPerformanceCounter(&frequency);
    endoftime=frequency.QuadPart;//获得终止值
    dt=(double)(endoftime-beginoftime);//差值
    t=dt/v;//差值除以频率得到时间
	cout<<endl<<"Time is "<<t*1000<<"ms\n"; 
}
 
