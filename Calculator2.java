import java.util.Scanner;

public class Calculator2 {
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner caculate = new Scanner(System.in);
		int key=0;
		while (key == 0 || key == 1 || key == 2) {
			System.out.println("��ӭʹ��" + "\n����������ֵ���밴1" + "\n�������㱾Ϣ���밴2"
					+ "\n�������㱾���밴3" + "\n�����룺");
			int key1 = caculate.nextInt();
			if (key1 == 1) {
				Calculator2.Compound(); // ����������ֵ
				break;
			} else if (key1 == 2) {
				Calculator2.Simple(); // �������㱾Ϣ
				break;
			} else if (key1 == 3) {
				Calculator2.Principal(); // �������㱾��
				break;
			} else {
				System.out.println("\n������󣡣���");
			}
		}
	}

	// �������㱾��
	private static void Principal() {
		// TODO �Զ����ɵķ������
		Scanner scanner = new Scanner(System.in);
		System.out.println("�����븴����ֵ��");
		double sum = scanner.nextDouble();
		System.out.println("�������Ǯ������");
		int years = scanner.nextInt();
		System.out.println("���������ʣ�");
		double rate = scanner.nextDouble();
		double N = 1, money;
		for (int i = 1; i <= years; i++) {
			N = (1 + rate) * N;
		}
		money = sum / N;
		System.out.println("ӦͶ��ı���Ϊ��" + money);
	}

	// �������㱾Ϣ
	private static void Simple() {
		// TODO �Զ����ɵķ������
		Scanner scanner = new Scanner(System.in);
		System.out.println("�����뱾��");
		double money = scanner.nextDouble();
		System.out.println("�������Ǯ������");
		int years = scanner.nextInt();
		System.out.println("���������ʣ�");
		double rate = scanner.nextDouble();
		double sum;
		sum = money + money * years * rate;
		System.out.println("������ϢֵΪ��" + sum);
	}

	// ����������ֵ
	private static void Compound() {
		// TODO �Զ����ɵķ������
		Scanner scanner = new Scanner(System.in);
		System.out.println("�����뱾��");
		double money = scanner.nextDouble();
		System.out.println("�������Ǯ������");
		int years = scanner.nextInt();
		System.out.println("���������ʣ�");
		double rate = scanner.nextDouble();
		double N = 1, sum;
		for (int i = 1; i <= years; i++) {
			N = (1 + rate) * N;
		}
		sum = N * money;
		System.out.println("��������ֵΪ��" + sum);
	}
}
