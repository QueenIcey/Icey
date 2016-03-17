import java.util.Scanner;


public class Calculator3 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner scanner = new Scanner(System.in);
		int key=0;
		while (key == 0 || key == 1 || key == 2 || key==3 || key==4 || key==5) {
			System.out.println("欢迎使用" + "\n计算单利和复利终值，请按1" + "\n计算本金，请按2"
					+ "\n股票投资，请按3"
					+ "\n计算利率，请按4"
					+ "\n计算资产总值，请按5" 
					+ "\n请输入：");
			int key1 = scanner.nextInt();
			if (key1 == 1) {
				Calculator3.DanliandFuli(); // 计算单利和复利
				break;
			} else if (key1 == 2) {
				Calculator3.Principal(); // 计算本金
				break;
			} else if (key1 == 3) {
				Calculator3.Stock(); // 股票投资(计算时间)
				break;
			} else if (key1 == 4) {
				Calculator3.Rate();  // 计算利率
				break;
			} else if (key1 == 5) {
				Calculator3.Assets();  // 计算资产总值
				break;
			}else {
				System.out.println("\n输入错误！！！");
			}
		}
	}

	private static void DanliandFuli() {
		// TODO 自动生成的方法存根
		double N = 1, sum;
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入本金：");
		double money = scanner.nextDouble();
		System.out.println("请输入存钱年数：");
		int years = scanner.nextInt();
		System.out.println("请输入年利率：");
		double rate = scanner.nextDouble();
        sum=money+money*years*rate;
        System.out.println("单利计算值为：" + sum);
        sum=0;
		for (int i = 1; i <= years; i++) {
			N = (1 + rate) * N;
		}
		sum = N * money;
		System.out.println("复利计算值为：" + sum);
	}

	private static void Principal() {
		// TODO 自动生成的方法存根
		double N = 1, money;
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入复利终值：");
		double sum = scanner.nextDouble();
		System.out.println("请输入存钱年数：");
		int years = scanner.nextInt();
		System.out.println("请输入年利率：");
		double rate = scanner.nextDouble();
		for (int i = 1; i <= years; i++) {
			N = (1 + rate) * N;
		}
		money = sum / N;
		System.out.println("应投入的本金为：" + money);
	}

	private static void Stock() {
		// TODO 自动生成的方法存根
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入本金：");
		double money = scanner.nextDouble();
		System.out.println("请输入复利终值：");
		int sum = scanner.nextInt();
		System.out.println("请输入年利率：");
		double rate = scanner.nextDouble();
		int years=(int) ((Math.log(sum)/Math.log(1+rate))-(Math.log(money)/Math.log(1+rate)));
		System.out.println("所需年限为：" + years);
	}

	private static void Rate() {
		// TODO 自动生成的方法存根
		double rate;
		Scanner scanner = new Scanner(System.in);
        System.out.print("请输入本金：");
        double money = scanner.nextDouble();
        System.out.print("请输入最后得到资产总值：");
        double sum = scanner.nextDouble();
        System.out.print("请输入存钱年数：");
        int years = scanner.nextInt();
        rate=sum/(money*years);
        System.out.println("利率为：" + rate);
	}

	private static void Assets() {
		// TODO 自动生成的方法存根
		double sum;
		Scanner scanner = new Scanner(System.in);
        System.out.print("请输入本金：");
        double money = scanner.nextDouble();
        System.out.print("请输入利率：");
        double rate = scanner.nextDouble();
        System.out.print("请输入存钱年数：");
        int years = scanner.nextInt();
        sum=money*rate*years;
        System.out.println("若投资本金每年固定不变，最后得到的资产总值为：" + sum);
        sum=0;
        for(int i=1;i<=years;i++){
            sum=money*rate*1;
            money=sum;                
        }
        System.out.println("若连本带利投资，最后得到的资产总值为：" + sum);
	}
}