import java.util.Scanner;


public class Calculator3 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner scanner = new Scanner(System.in);
		int key=0;
		while (key == 0 || key == 1 || key == 2 || key==3 || key==4 || key==5) {
			System.out.println("��ӭʹ��" + "\n���㵥���͸�����ֵ���밴1" + "\n���㱾���밴2"
					+ "\n��ƱͶ�ʣ��밴3"
					+ "\n�������ʣ��밴4"
					+ "\n�����ʲ���ֵ���밴5" 
					+ "\n�����룺");
			int key1 = scanner.nextInt();
			if (key1 == 1) {
				Calculator3.DanliandFuli(); // ���㵥���͸���
				break;
			} else if (key1 == 2) {
				Calculator3.Principal(); // ���㱾��
				break;
			} else if (key1 == 3) {
				Calculator3.Stock(); // ��ƱͶ��(����ʱ��)
				break;
			} else if (key1 == 4) {
				Calculator3.Rate();  // ��������
				break;
			} else if (key1 == 5) {
				Calculator3.Assets();  // �����ʲ���ֵ
				break;
			}else {
				System.out.println("\n������󣡣���");
			}
		}
	}

	private static void DanliandFuli() {
		// TODO �Զ����ɵķ������
		double N = 1, sum;
		Scanner scanner = new Scanner(System.in);
		System.out.println("�����뱾��");
		double money = scanner.nextDouble();
		System.out.println("�������Ǯ������");
		int years = scanner.nextInt();
		System.out.println("�����������ʣ�");
		double rate = scanner.nextDouble();
        sum=money+money*years*rate;
        System.out.println("��������ֵΪ��" + sum);
        sum=0;
		for (int i = 1; i <= years; i++) {
			N = (1 + rate) * N;
		}
		sum = N * money;
		System.out.println("��������ֵΪ��" + sum);
	}

	private static void Principal() {
		// TODO �Զ����ɵķ������
		double N = 1, money;
		Scanner scanner = new Scanner(System.in);
		System.out.println("�����븴����ֵ��");
		double sum = scanner.nextDouble();
		System.out.println("�������Ǯ������");
		int years = scanner.nextInt();
		System.out.println("�����������ʣ�");
		double rate = scanner.nextDouble();
		for (int i = 1; i <= years; i++) {
			N = (1 + rate) * N;
		}
		money = sum / N;
		System.out.println("ӦͶ��ı���Ϊ��" + money);
	}

	private static void Stock() {
		// TODO �Զ����ɵķ������
		Scanner scanner = new Scanner(System.in);
		System.out.println("�����뱾��");
		double money = scanner.nextDouble();
		System.out.println("�����븴����ֵ��");
		int sum = scanner.nextInt();
		System.out.println("�����������ʣ�");
		double rate = scanner.nextDouble();
		int years=(int) ((Math.log(sum)/Math.log(1+rate))-(Math.log(money)/Math.log(1+rate)));
		System.out.println("��������Ϊ��" + years);
	}

	private static void Rate() {
		// TODO �Զ����ɵķ������
		double rate;
		Scanner scanner = new Scanner(System.in);
        System.out.print("�����뱾��");
        double money = scanner.nextDouble();
        System.out.print("���������õ��ʲ���ֵ��");
        double sum = scanner.nextDouble();
        System.out.print("�������Ǯ������");
        int years = scanner.nextInt();
        rate=sum/(money*years);
        System.out.println("����Ϊ��" + rate);
	}

	private static void Assets() {
		// TODO �Զ����ɵķ������
		double sum;
		Scanner scanner = new Scanner(System.in);
        System.out.print("�����뱾��");
        double money = scanner.nextDouble();
        System.out.print("���������ʣ�");
        double rate = scanner.nextDouble();
        System.out.print("�������Ǯ������");
        int years = scanner.nextInt();
        sum=money*rate*years;
        System.out.println("��Ͷ�ʱ���ÿ��̶����䣬���õ����ʲ���ֵΪ��" + sum);
        sum=0;
        for(int i=1;i<=years;i++){
            sum=money*rate*1;
            money=sum;                
        }
        System.out.println("����������Ͷ�ʣ����õ����ʲ���ֵΪ��" + sum);
	}
}