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
		m[n][j]=0;  			//m[i][j]��ʾi����n��Ʒ��������j����������ֵ��          
	for(int j=w[n];j<=c;j++)
		m[n][j]=v[n];
	for(int i=n-1;i>1;i--){
		jMax=min(w[i]-1,c);  //jmax�������Ǽ��ٱ����ķ�Χ��j���Ե������ֵ�� 
		for(int j=0;j<=jMax;j++)  
			m[i][j]=m[i+1][j];     
		for(int j=w[i];j<=c;j++){   //���ѭ������j��С�������Է���i��Ʒ 
			m[i][j]=max(m[i+1][j],m[i+1][j-w[i]]+v[i]); //�����벻����ȡ��ֵ 
		}
	}
	m[1][c]=m[2][c];	
	if(c>=w[1])        //i=2�� m ��ֵȫ����֪��ֱ�Ӽ���m[1][c]���ɣ�����m[1][j]û��Ҫ���� 
		m[1][c]=max(m[1][c],m[2][c-w[1]]+v[1]);
	return m[1][c];
}
int main()
{
	
	//���� 
	ifile.open("input.txt");
 	readfile();
 	ifile.close();
 	ofile.open("output.txt");
 	ofile<<dp();
 	ofile.close(); 
 	
	//���ֹ�ģ����
	printf("Small size:\n");
 	LARGE_INTEGER frequency;
 	double v,beginoftime,endoftime,dt,t;//ʱ�ӵ�Ƶ�ʣ���ʼ��ʵ��ʱ��ʵ��ʱ�� 
 	
 	ifile.open("10.txt");
 	readfile();
 	ifile.close();
 	QueryPerformanceFrequency(&frequency);//���ʱ��Ƶ��
 	v=(double)frequency.QuadPart;//ȡ��Ƶ��*/
 	QueryPerformanceCounter(&frequency);
    beginoftime=frequency.QuadPart;//��ó�ʼֵ
	cout<<dp();
 	QueryPerformanceCounter(&frequency);
    endoftime=frequency.QuadPart;//�����ֵֹ
    dt=(double)(endoftime-beginoftime);//��ֵ
    t=dt/v;//��ֵ����Ƶ�ʵõ�ʱ��
	cout<<endl<<"Time is "<<t*1000<<"ms\n"; 
	
	printf("Medium size:\n");
 	ifile.open("100.txt");
 	readfile();
 	ifile.close();
 	QueryPerformanceFrequency(&frequency);//���ʱ��Ƶ��
 	v=(double)frequency.QuadPart;//ȡ��Ƶ��*/
 	QueryPerformanceCounter(&frequency);
    beginoftime=frequency.QuadPart;//��ó�ʼֵ
	cout<<dp();
 	QueryPerformanceCounter(&frequency);
    endoftime=frequency.QuadPart;//�����ֵֹ
    dt=(double)(endoftime-beginoftime);//��ֵ
    t=dt/v;//��ֵ����Ƶ�ʵõ�ʱ��
	cout<<endl<<"Time is "<<t*1000<<"ms\n"; 
	
	printf("Large size:\n");
 	ifile.open("1000.txt");
 	readfile();
 	ifile.close();
 	QueryPerformanceFrequency(&frequency);//���ʱ��Ƶ��
 	v=(double)frequency.QuadPart;//ȡ��Ƶ��*/
 	QueryPerformanceCounter(&frequency);
    beginoftime=frequency.QuadPart;//��ó�ʼֵ
	cout<<dp();
 	QueryPerformanceCounter(&frequency);
    endoftime=frequency.QuadPart;//�����ֵֹ
    dt=(double)(endoftime-beginoftime);//��ֵ
    t=dt/v;//��ֵ����Ƶ�ʵõ�ʱ��
	cout<<endl<<"Time is "<<t*1000<<"ms\n"; 
}
 
