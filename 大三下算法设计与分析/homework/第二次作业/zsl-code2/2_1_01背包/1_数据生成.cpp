#include <iostream>
#include <time.h>
#include <fstream>
//***���������ڲ����������
using namespace std;//RAND_MAX=32767
int w[1000]={0};
int v[1000]={0};
int c,n;
int Size[4]={10,50,100,1000};//�ļ���С
void print(ofstream &outfile,int n,int c)//������ļ� 
{
	outfile<<n<<" "<<c<<endl;
	for(int i=0;i<n;i++)
	{
		outfile<<w[i]<<' '<<v[i]<<endl;
	}
}
int main()
{
    int n=0;
    //ifstream
    ofstream out_10("10.txt"),out_100("100.txt"),out_1000("1000.txt");//�������������;
    srand(time(NULL));//ʱ������
    //���ɲ����ļ�
    for(int i=0;i<Size[0];i++) 
	{	
		w[i]=rand()%10+1;//�õ�[0,10)�ڵ���
		v[i]=rand()%10+1;
	}
    print(out_10,Size[0],20);
    for(int i=0;i<Size[2];i++) 
	{
		w[i]=rand()%10+1;	
		v[i]=rand()%10+1;
	}
    print(out_100,Size[2],20);
    for(int i=0;i<Size[3];i++) 
	{
		w[i]=rand()%10+1;	
		v[i]=rand()%10+1;
	}
    print(out_1000,Size[3],20);
}
 
