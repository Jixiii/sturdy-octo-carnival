#include<stdio.h>
#include <time.h> 
#include <windows.h>
#include <iostream> 
#include<algorithm>
#include<fstream>
using namespace std;
int n,c;
float w[10000],v[10000];
struct Average{
	int id;     //第几个物品
	float aver; //单位均值 
};
ifstream ifile;
ofstream ofile; 
Average x[10000]; 
void readfile()
{
	ifile>>n>>c;
	for(int i=0;i<n;i++){
		ifile>>w[i]>>v[i];
		x[i].id=i;
		x[i].aver=v[i]/w[i];
	}
}
//sort函数第三个参数，降序排列 
bool cmp1(Average a,Average b){
	return a.aver>b.aver;
}
float tx()
{
	float sum=0;    //总价值 
	sort(x,x+n,cmp1);
	for(int i=0;i<n;i++){
		if(c<w[x[i].id]){         //当某个商品无法全部放入时，就将背包的剩余部分塞满并结束； 
			sum+=c*x[i].aver;
			break;                  
		}
		c-=w[x[i].id];
		sum+=v[x[i].id];
	}
	return sum; 
}
int main()
{
	//例题 
	ifile.open("input.txt");
 	readfile();
 	ifile.close();
 	ofile.open("output.txt");
 	ofile<<tx();
 	
 	LARGE_INTEGER frequency;
 	double v,beginoftime,endoftime,dt,t;//时钟的频率，起始，实际时间差，实际时间 

	printf("Small size:\n");
	ifile.open("10.txt");
 	readfile();
 	ifile.close();
	QueryPerformanceFrequency(&frequency);//获得时钟频率
 	v=(double)frequency.QuadPart;//取得频率*/
 	QueryPerformanceCounter(&frequency);
    beginoftime=frequency.QuadPart;//获得初始值
	cout<<tx();
 	QueryPerformanceCounter(&frequency);
    endoftime=frequency.QuadPart;//获得终止值
    dt=(double)(endoftime-beginoftime);//差值
    t=dt/v;//差值除以频率得到时间
	printf("\nTime is %f ms\n",t*1000); 
	
	printf("Medium size:\n");
	ifile.open("100.txt");
 	readfile();
 	ifile.close();
	QueryPerformanceFrequency(&frequency);//获得时钟频率
 	v=(double)frequency.QuadPart;//取得频率*/
 	QueryPerformanceCounter(&frequency);
    beginoftime=frequency.QuadPart;//获得初始值
	cout<<tx();
 	QueryPerformanceCounter(&frequency);
    endoftime=frequency.QuadPart;//获得终止值
    dt=(double)(endoftime-beginoftime);//差值
    t=dt/v;//差值除以频率得到时间
	printf("\nTime is %f ms\n",t*1000); 
	
	printf("Large size:\n");
	ifile.open("10000.txt");
 	readfile();
 	ifile.close();
	QueryPerformanceFrequency(&frequency);//获得时钟频率
 	v=(double)frequency.QuadPart;//取得频率*/
 	QueryPerformanceCounter(&frequency);
    beginoftime=frequency.QuadPart;//获得初始值
	cout<<tx();
 	QueryPerformanceCounter(&frequency);
    endoftime=frequency.QuadPart;//获得终止值
    dt=(double)(endoftime-beginoftime);//差值
    t=dt/v;//差值除以频率得到时间
	printf("\nTime is %f ms\n",t*1000); 
}
 
