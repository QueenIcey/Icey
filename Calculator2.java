import java.util.Scanner;

public class Calculator2 {
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner caculate = new Scanner(System.in);
		int key=0;
		while (key == 0 || key == 1 || key == 2) {
			System.out.println("欢迎使用" + "\n复利计算终值，请按1" + "\n单利计算本息，请按2"
					+ "\n复利计算本金，请按3" + "\n请输入：");
			int key1 = caculate.nextInt();
			if (key1 == 1) {
				Calculator2.Compound(); // 复利计算终值
				break;
			} else if (key1 == 2) {
				Calculator2.Simple(); // 单利计算本息
				break;
			} else if (key1 == 3) {
				Calculator2.Principal(); // 复利计算本金
				break;
			} else {
				System.out.println("\n输入错误！！！");
			}
		}
	}

	// 复利计算本金
	private static void Principal() {
		// TODO 自动生成的方法存根
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入复利终值：");
		double sum = scanner.nextDouble();
		System.out.println("请输入存钱年数：");
		int years = scanner.nextInt();
		System.out.println("请输入利率：");
		double rate = scanner.nextDouble();
		double N = 1, money;
		for (int i = 1; i <= years; i++) {
			N = (1 + rate) * N;
		}
		money = sum / N;
		System.out.println("应投入的本金为：" + money);
	}

	// 单利计算本息
	private static void Simple() {
		// TODO 自动生成的方法存根
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入本金：");
		double money = scanner.nextDouble();
		System.out.println("请输入存钱年数：");
		int years = scanner.nextInt();
		System.out.println("请输入利率：");
		double rate = scanner.nextDouble();
		double sum;
		sum = money + money * years * rate;
		System.out.println("单利本息值为：" + sum);
	}

	// 复利计算终值
	private static void Compound() {
		// TODO 自动生成的方法存根
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入本金：");
		double money = scanner.nextDouble();
		System.out.println("请输入存钱年数：");
		int years = scanner.nextInt();
		System.out.println("请输入利率：");
		double rate = scanner.nextDouble();
		double N = 1, sum;
		for (int i = 1; i <= years; i++) {
			N = (1 + rate) * N;
		}
		sum = N * money;
		System.out.println("复利计算值为：" + sum);
	}
}
