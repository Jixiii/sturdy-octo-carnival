
#include "stdio.h"
#include <iostream>
#include <windows.h>
#include <iomanip>
#include <fstream>
using namespace std;
#define MIN(a,b) (a<b ? a:b)
#define MAXINT  1000000
int N0,K0,A0,B0,C0;
int p[102][102];		//��·״̬ 
ifstream ifile;         //�����������ļ��Լ�Ҫд����ļ�
				
void readfile()
{
	ifile>>N0>>K0>>A0>>B0>>C0;
	for (int i=1;i<=N0;i++)          //��ÿһ��λ�ø�ֵ
	{
	  	for (int j=1;j<=N0;j++)
	  	{
	   		ifile>>p[i][j];
	  	} 
	}	
}		
int dp()
{
	int N=N0,K=K0,A=A0,B=B0,C=C0;
	int f[N+1][N+1][2];		 //��ά���飬��¼��С�����Լ�������ʻ��·��,f(x,y,0)��f(x,y,1)
	int i,j,k;
	int s[4][3]={-1,0,0,0,-1,0,1,0,B,0,1,B};   //��x-1��x��y-1��y����0�� 
	for (i=1;i<=N;i++)
	{
	  	for (j=1;j<=N;j++)
	  		f[i][j][0]=MAXINT;             //f��i��j��0����ʼ��Ϊ���ֵ 
	}
	for (i=1;i<=N;i++)
	  	for (j=1;j<=N;j++)
	   		f[i][j][1]=K;			//f��i��j��1����ʼ��ΪK 
	f[1][1][0]=0;
	f[1][1][1]=K;
	
	int x,y;
	bool pd=true;
	while(pd)
	{
	  	pd=false;			//�ж��Ƿ�����˵㣬����и�����Ҫ���½���һ�α��� 
	  	for (x=1;x<=N;x++)           //��ʵxΪ�ڲ㣬yΪ��㣬��Ӧ�����Լ�s������ϵ
	  	{
	   		for (y=1;y<=N;y++)
	   		{
	    		if (x==1&&y==1)
	     			continue;
	    		int minf0=MAXINT;
	    		int nowf0;
	    		int Prex,Prey;			//�仯�ɣ�x��y��ǰ�����꣨�ĸ�λ�ÿɵִ�x��y�� 
	    		int nowf1;
	    		int minf1;         // ��Сf0��Ӧ�� f1 
	    		for (k=0;k<4;k++)	//�����ƶ���ʽ 
	    		{
	     			Prex=x+s[k][0];
	     			Prey=y+s[k][1];
	     			if (Prex<1||Prex>N||Prey<1||Prey>N)   //�߽��飡��
	     		 	continue;
	     		 	
	     			nowf0=f[Prex][Prey][0]+s[k][2];
	     			nowf1=f[Prex][Prey][1]-1;			//�ӣ�px��py������x��y����f��x��y��0/1�� 
	     			
	     			if (p[x][y]==1)        //�м���վ
	     			{
	      				nowf0+=A;
	      				nowf1=K;
	     			}
	     			else if ((nowf1==0)&&(x!=N||y!=N)) //û�м���վ������û������
	     			{
	      				nowf0+=A+C;
	      				nowf1=K;
	     			}
	     											//��������վ 
	     			if (nowf0<minf0||(nowf0==minf0&&nowf1>minf1))       //��������е���Сֵ 
	     			{
	      				minf0=nowf0;
	      				minf1=nowf1;
	     			}
	    		}
	    		if (f[x][y][0]>minf0||(f[x][y][0]==minf0&&f[x][y][1]<minf1))      //���������Χ�и��õĽ⣬���滻f
	    		{
	     			pd=true;				//�и��µĵ㣬���֮��Ҫ����һ�����±��� 
	     			f[x][y][0]=minf0;		//Ҳ����ֱ�ӽ��д�ͷ��ʼ�����ٶȻ���� 
	     			f[x][y][1]=minf1;
	    		}
	   		}
	  	}
	}  
	for(i=1;i<=N;i++){
		for(j=1;j<=N;j++){
			cout<<f[i][j][0]<<"    ";
		}
		cout<<endl;
	}
	return f[N][N][0];
} 
		  
int main()
{

	int ans;
	ifile.open("input2.txt");
	readfile(); 
	ifile.close();
   
	ans=dp();     //������� 

	ofstream ofile("output2.txt");
	ofile<<ans;
	ofile.close();
}
