import org.junit.Test;


import org.junit.Assert;

import junit.framework.TestCase;


public class CalculatorTest extends TestCase {
	//所有的终值误差在1.0以内算是正确的
	@Test
	public void testFuli(){
		Calculator4 k=new Calculator4();
		double money=1000000;
		double rate=0.03;
		int years=30;
		double sum;
		sum=money*(Math.pow(1+rate, years));
		System.out.println("sum="+sum);
		Assert.assertEquals(2427262, sum,1.0);
	}

	@Test
	public void testPrincipal(){
		Calculator4 k=new Calculator4();
		double sum=3000000;
		int years=30;
		double rate=0.03;
		double money;
		money=sum/(Math.pow(1+rate, years));
		System.out.println("money="+money);
		Assert.assertEquals(1235960, money,1.0);
	}
	
	@Test
	public void testStock(){
		Calculator4 k=new Calculator4();
		double money=1000000;
		double sum=3000000;
		double rate=0.03;
		int years;
		years=(int) ((Math.log(sum)/Math.log(1+rate))-(Math.log(money)/Math.log(1+rate)));
		System.out.println("years="+years);
		Assert.assertEquals(37, years,1.0);
	}
	
	@Test
	public void testRate(){
		Calculator4 k=new Calculator4();
		double money=1000000;
		double sum=3000000;
		int years=30;
		double rate;
		rate=sum/(money*years);
		System.out.println("rate="+rate);
		Assert.assertEquals(0.1, rate,1.0);
	}
	
	@Test
	public void testAssets(){
		Calculator4 k=new Calculator4();
		double money=1000000;
		double rate=0.03;
		int years=30;
		double sum1;
		sum1=money*rate*years;
		System.out.println("sum1="+sum1);
		Assert.assertEquals(900000.0, sum1,1.0);
	}
	
	@Test
	public void testRepayment(){
		Calculator4 k=new Calculator4();
		double money=1000000;
		double rate=0.03;
		int years=10;
		double sum2;
		double i=rate/12;//k为月利率
        int month=years*12;//month为贷款月数
        sum2=money*i*Math.pow(1+i, month)/(Math.pow(1+i,month)-1);
        System.out.println("sum2="+sum2);
		Assert.assertEquals(9656, sum2,1.0);
	}
}
