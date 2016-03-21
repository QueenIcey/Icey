import java.util.Scanner;


public class Calculator4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        int key=0;
        while (key == 0 || key == 1 || key == 2 || key==3 || key==4 || key==5) {
            System.out.println("欢迎使用" + "\n计算单利和复利终值，请按1" + "\n计算本金，请按2"
                    + "\n股票投资，请按3"
                    + "\n计算利率，请按4"
                    + "\n计算资产总值，请按5"
                    + "\n计算月等额还款金额，请按6"
                    + "\n请输入：");
            int key1 = scanner.nextInt();
            if (key1 == 1) {
                Calculator4.DanliandFuli(); // 计算单利和复利
                break;
            } else if (key1 == 2) {
                Calculator4.Principal(); // 计算本金
                break;
            } else if (key1 == 3) {
                Calculator4.Stock(); // 股票投资(计算时间)
                break;
            } else if (key1 == 4) {
                Calculator4.Rate();  // 计算利率
                break;
            } else if (key1 == 5) {
                Calculator4.Assets();  // 计算资产总值
                break;
            }else if (key1 ==6 ) {
            	Calculator4.Repayment();  // 计算资产总值
                break;
            }else {
                System.out.println("\n输入错误！请重新输入！");
            }
        }
    }
 
    private static void Repayment() {
		// TODO Auto-generated method stub
    	double sum,i;
 	    int month;
 	    Scanner scanner = new Scanner(System.in);
 	    System.out.print("请输入本金：");
        double money = scanner.nextDouble();
        System.out.print("请输入年利率：");
        double rate = scanner.nextDouble();
        System.out.print("请输入贷款年数：");
        int years = scanner.nextInt();
        i=rate/12;//k为月利率
        month=years*12;//month为贷款月数
        sum=money*i*Math.pow(1+i, month)/(Math.pow(1+i,month)-1);
        System.out.println("每月等额还款金额为："+sum);
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
