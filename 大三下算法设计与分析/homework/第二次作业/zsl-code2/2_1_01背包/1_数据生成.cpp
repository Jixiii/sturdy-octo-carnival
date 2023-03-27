#include <iostream>
#include <time.h>
#include <fstream>
//***本程序用于产生随机数据
using namespace std;//RAND_MAX=32767
int w[1000]={0};
int v[1000]={0};
int c,n;
int Size[4]={10,50,100,1000};//文件大小
void print(ofstream &outfile,int n,int c)//输出到文件 
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
    ofstream out_10("10.txt"),out_100("100.txt"),out_1000("1000.txt");//输入代查找数据;
    srand(time(NULL));//时间种子
    //生成测试文件
    for(int i=0;i<Size[0];i++) 
	{	
		w[i]=rand()%10+1;//得到[0,10)内的数
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
 
