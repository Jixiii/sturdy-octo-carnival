#include<stdio.h>
/*【题目描述】 有n个数（n<20）,已按从大到小顺序存放在一个数组中，
输入一个数，要求用折半查找法找出该数是数组中的第几个元素的值（从1开始）。
如果不在数组中输出0。 
Input： 
第一行为数组元素的个数n。 
第二行是n个数组元素的值，整数。 
第三行是要查找的值。 
Output： 查找的值在数组中的位置（从序号1开始），找不到时显示0。 
【输入输出样例】 输入： 
10 
10 9 8 7 6 5 4 3 2 1 
5 
输出: 6/*/
int main(){
	int n;
	scanf("%d",&n);
	int num[1000];
	int i;
	for(i = 0;i < n;i++){
		scanf("%d",num+i);
	}
	int search;
	scanf("%d",&search);
	int left = 0,right = n;
	int mid;
	while(left<right){
		mid = (left+right)/2;
		if(num[mid]==search){
			printf("%d",mid+1);
			return 0;
		}else if(num[mid]>search){
			left = mid;
		}else{
			right = mid;
		}
	}
	printf("0");
	return 0;
}
