#include<iostream>
using namespace std;
int m,n;
long long a,b,sum=0;
long long Po(long long A,long long B,int m)
{
    long long ans=1;
    while(B!=0)
    {
        if(B&1)
            ans=ans*A%m;
        B>>=1;
        A=A*A%m;
    }
    return ans;
}
int main()
{
    scanf("%d%d",&m,&n);
    for(int i=0;i<n;i++)
    {
        scanf("%lld%lld",&a,&b);
        sum=(sum+Po(a,b,m))%m;
    }
    printf("%lld",sum);
    return 0;
}
