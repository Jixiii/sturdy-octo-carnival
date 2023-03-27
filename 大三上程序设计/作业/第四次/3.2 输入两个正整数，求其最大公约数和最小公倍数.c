#include<stdio.h>
/*输入两个20以内的正整数，输出其最大公约数和最小公倍数。测试用例如下：
输入：
12
15
输出：
最大公约数为3
最小公倍数为60
输入
2
6
输出
最大公约数为2
最小公倍数为6
（中间无空行，数字和字符之间无空格）*/ 
int main(){
	int x, y,GCD,LCM;
	scanf("%d%d", &x, &y);
	if(x > y){
		GCD = y;
	}else{
		GCD = x;
	}
	for(;GCD >= 1;GCD--){
		if(x%GCD==0&&y%GCD==0){
			break;
		}
	}
	printf("最大公约数为%d\n最小公倍数为%d", GCD,x*y/GCD);
	return 0;
}
