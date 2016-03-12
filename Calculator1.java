package calculator1;

import java.util.Scanner;

public class calculator1 {
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入本金：");
		double money=scanner.nextDouble();
		System.out.println("请输入存钱年数：");
		int years=scanner.nextInt();
		System.out.println("请输入利率：");
		double rate=scanner.nextDouble();
        double N=1,sum;
        for(int i=1;i<=years;i++){
        	N=(1+rate)*N;
        }
        sum=N*money;
        System.out.println("复利计算值为："+sum);
	}
}
