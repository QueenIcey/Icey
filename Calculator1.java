package calculator1;

import java.util.Scanner;

public class calculator1 {
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner scanner=new Scanner(System.in);
		System.out.println("�����뱾��");
		double money=scanner.nextDouble();
		System.out.println("�������Ǯ������");
		int years=scanner.nextInt();
		System.out.println("���������ʣ�");
		double rate=scanner.nextDouble();
        double N=1,sum;
        for(int i=1;i<=years;i++){
        	N=(1+rate)*N;
        }
        sum=N*money;
        System.out.println("��������ֵΪ��"+sum);
	}
}
