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
	int id;     //�ڼ�����Ʒ
	float aver; //��λ��ֵ 
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
//sort������������������������ 
bool cmp1(Average a,Average b){
	return a.aver>b.aver;
}
float tx()
{
	float sum=0;    //�ܼ�ֵ 
	sort(x,x+n,cmp1);
	for(int i=0;i<n;i++){
		if(c<w[x[i].id]){         //��ĳ����Ʒ�޷�ȫ������ʱ���ͽ�������ʣ�ಿ�������������� 
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
	//���� 
	ifile.open("input.txt");
 	readfile();
 	ifile.close();
 	ofile.open("output.txt");
 	ofile<<tx();
 	
 	LARGE_INTEGER frequency;
 	double v,beginoftime,endoftime,dt,t;//ʱ�ӵ�Ƶ�ʣ���ʼ��ʵ��ʱ��ʵ��ʱ�� 

	printf("Small size:\n");
	ifile.open("10.txt");
 	readfile();
 	ifile.close();
	QueryPerformanceFrequency(&frequency);//���ʱ��Ƶ��
 	v=(double)frequency.QuadPart;//ȡ��Ƶ��*/
 	QueryPerformanceCounter(&frequency);
    beginoftime=frequency.QuadPart;//��ó�ʼֵ
	cout<<tx();
 	QueryPerformanceCounter(&frequency);
    endoftime=frequency.QuadPart;//�����ֵֹ
    dt=(double)(endoftime-beginoftime);//��ֵ
    t=dt/v;//��ֵ����Ƶ�ʵõ�ʱ��
	printf("\nTime is %f ms\n",t*1000); 
	
	printf("Medium size:\n");
	ifile.open("100.txt");
 	readfile();
 	ifile.close();
	QueryPerformanceFrequency(&frequency);//���ʱ��Ƶ��
 	v=(double)frequency.QuadPart;//ȡ��Ƶ��*/
 	QueryPerformanceCounter(&frequency);
    beginoftime=frequency.QuadPart;//��ó�ʼֵ
	cout<<tx();
 	QueryPerformanceCounter(&frequency);
    endoftime=frequency.QuadPart;//�����ֵֹ
    dt=(double)(endoftime-beginoftime);//��ֵ
    t=dt/v;//��ֵ����Ƶ�ʵõ�ʱ��
	printf("\nTime is %f ms\n",t*1000); 
	
	printf("Large size:\n");
	ifile.open("10000.txt");
 	readfile();
 	ifile.close();
	QueryPerformanceFrequency(&frequency);//���ʱ��Ƶ��
 	v=(double)frequency.QuadPart;//ȡ��Ƶ��*/
 	QueryPerformanceCounter(&frequency);
    beginoftime=frequency.QuadPart;//��ó�ʼֵ
	cout<<tx();
 	QueryPerformanceCounter(&frequency);
    endoftime=frequency.QuadPart;//�����ֵֹ
    dt=(double)(endoftime-beginoftime);//��ֵ
    t=dt/v;//��ֵ����Ƶ�ʵõ�ʱ��
	printf("\nTime is %f ms\n",t*1000); 
}
 
