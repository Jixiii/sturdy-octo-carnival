#include<stdio.h>
/*题目内容：
分别编写函数输入数组元素（输入-9999表示结束）、从小到大排序数组元素、用二分法在有序数组中查找（返回下标）。
编写主函数，调用函数进行输入、排序和查找。数组元素不超过100个，均为整数。
输入格式：
两行，第1行为输入的数组元素，以-9999结束；第2行输入5个待查找的元素。数据用空格隔开。
输出格式：
5行，每行是查找到的元素的下标，找不到时结果为-1。
输入样例：
2 1 3 4 5 -9999
2 3 4 -10 10
输出样例：
1
2
3
-1
-1*/
int find(int num[101],int lenth,int search){
	int left,right,mid;
	left = 0;
	right = lenth;
	while(right-left>0){
		mid = (left+right)/2;
		if(num[mid]==search){
			return mid;
		}else if(num[mid]>search){
			right = mid;
		}else{
			left = mid+1;
		}
	}
	return -1;
}

void maoPao(int num[101],int n){
	int i,j,temp;
	for(i=0;i<n;i++){
		for(j=0;j<n-i-1;j++){
			if(num[j]>num[j+1]){
				temp = num[j];
				num[j]=num[j+1];
				num[j+1]=temp;
			}
		}
	}
}

int main(){
	int num[101],i=0,j,search;
	scanf("%d",&num[i]);
	while(num[i]!=-9999){
		i++;
		scanf("%d",&num[i]);
	}
	maoPao(num,i);
	for(j=0;j<5;j++){
		scanf("%d",&search);
		printf("%d\n",find(num,i,search));
	}
	return 0;
}


