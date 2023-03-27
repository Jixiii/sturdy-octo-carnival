#include<iostream>
#include<cstdio>
#include<cstring>
#include<queue>
#include<fstream>
#define maxn 105
#define maxk 15 
#define INF 0x3f3f3f3f
using namespace std;
int n,k,a,b,c;
int graph[maxn][maxn];
int dist[maxn][maxn][maxk];
int inq[maxn][maxn][maxk];
struct node{
    int x;
    int y;
    int k;
    node(){}
    node(int xpos,int ypos,int oil){
        x=xpos;
        y=ypos;
        k=oil;
    }
};
queue<node>q;
const int walkx[4]={1,-1,0,0},walky[4]={0,0,1,-1};
int spfa(){
    memset(dist,0x3f,sizeof(dist));
    dist[1][1][k]=0;
    inq[1][1][k]=1;
    q.push(node(1,1,k));
    while(!q.empty()){
        node now=q.front();
        q.pop();
//		now.debug();
        inq[now.x][now.y][now.k]=0;
        if(graph[now.x][now.y]&&now.k!=k){//���ͣ������ﵽk 
            if(dist[now.x][now.y][k]>dist[now.x][now.y][now.k]+a){
                dist[now.x][now.y][k]=dist[now.x][now.y][now.k]+a;
                if(!inq[now.x][now.y][k]){
                    inq[now.x][now.y][k]=1;
                    q.push(node(now.x,now.y,k));
                } 
            } 
            continue;//�����Ϳ������ͣ����ܲ����;��ߣ�����Ҫcontinue����һ�δӼ����͵�״̬��ʼ����
        }
        else{//���Ϳ� 
            if(dist[now.x][now.y][k]>dist[now.x][now.y][now.k]+a+c){
                dist[now.x][now.y][k]=dist[now.x][now.y][now.k]+a+c;
                if(!inq[now.x][now.y][k]){
                    inq[now.x][now.y][k]=1;
                    q.push(node(now.x,now.y,k));
                } 
            } 
        }
        for(int i=0;i<4;i++){
            node nex;
            nex.x=now.x+walkx[i];
            nex.y=now.y+walky[i];
            if(now.k<1) continue;
            int w=0;//�ߵĴ���
            if(nex.x<now.x||nex.y<now.y) w=b;
            nex.k=now.k-1;
            if(nex.x>=1&&nex.y>=1&&nex.x<=n&&nex.y<=n){
                if(dist[nex.x][nex.y][nex.k]>dist[now.x][now.y][now.k]+w){
                    dist[nex.x][nex.y][nex.k]=dist[now.x][now.y][now.k]+w;
                    if(!inq[nex.x][nex.y][nex.k]){
                        inq[nex.x][nex.y][nex.k]=1;
                        q.push(nex);
                    }
                }
            }
        }
    }
    int ans=INF;
    for(int i=0;i<=k;i++) ans=min(ans,dist[n][n][i]);
    return ans;
}
int main(){
    ifstream ifile("input2.txt");
    ifile>>n>>k>>a>>b>>c;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            ifile>>graph[i][j];
            cout<<graph[i][j]<<" ";
        }
        cout<<endl;
    }
    printf("%d",spfa());
}
