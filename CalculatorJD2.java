import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class CalculatorJD {
	public static void main(String args[]) {
		MyFrame frame = new MyFrame();
	}
}

class MyFrame extends JFrame {
	private JPanel c;
	private int index = 0;  
	private static double benjin, lilv, nianxian, zhongzhi, dingtou, huankuan,daikuan;
	JLabel l1 = new JLabel("计算类型:");
	JLabel l2 = new JLabel("本金（元）:");
	JLabel l3 = new JLabel("年利率（%）:");
	JLabel l4 = new JLabel("年限（年）:");
	JLabel l5 = new JLabel("终值（元）:");
	JTextField t2 = new JTextField(10);
	JTextField t3 = new JTextField("0.03",10);
	JTextField t4 = new JTextField(10);
	JTextField t5 = new JTextField(10);

	JButton b1 = new JButton("计算");
	String[] selectedText = { "复利计算", "单利计算", "本金计算", "利率计算", "年限计算","月等额还款计算" };
	JComboBox c1 = new JComboBox(selectedText);
	
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	
    DefaultListModel listModel=new DefaultListModel(); 
	JList resultList=new JList(listModel);	
	
	MyFrame() {
		this.setSize(320,400);
		this.setTitle("复利计算器");
		Container c = this.getContentPane();
		GridLayout f1 = new GridLayout(6, 2, 0, 5);
		GridLayout f2 = new GridLayout(1, 1, 5, 5);
		FlowLayout f3 = new FlowLayout(FlowLayout.CENTER, 20,20);
		
		c.setLayout(f3);
		p1.setLayout(f1);
		p2.setLayout(f2);
		p3.setLayout(f2);
		p1.add(l1);
		p1.add(c1);
		p1.add(l2);
		p1.add(t2);
		p1.add(l3);
		p1.add(t3);
		p1.add(l4);
		p1.add(t4);
		p1.add(l5);
		p1.add(t5);
		p2.add(b1);
		p3.add(resultList);
		c.add(p1);
		c.add(p2);
		c.add(p3);
		
		b1.setForeground(Color.BLUE);
		b1.setBackground(Color.PINK);
		b1.setFont(new Font("幼圆", Font.BOLD, 15));
		c1.setBackground(Color.PINK);
		l1.setForeground(Color.MAGENTA);
		l1.setFont(new Font("幼圆", Font.BOLD, 16));
		l2.setForeground(Color.PINK);
		l2.setFont(new Font("幼圆", Font.BOLD, 15));
		l3.setForeground(Color.PINK);
		l3.setFont(new Font("幼圆", Font.BOLD, 15));
		l4.setForeground(Color.PINK);
		l4.setFont(new Font("幼圆", Font.BOLD, 15));
		l5.setForeground(Color.PINK);
		l5.setFont(new Font("幼圆", Font.BOLD, 15));
		t2.setForeground(Color.YELLOW);
		t2.setFont(new Font("幼圆", Font.BOLD, 14));
		t3.setForeground(Color.CYAN);
		t3.setFont(new Font("幼圆", Font.BOLD, 14));
		t4.setForeground(Color.GREEN);
		t4.setFont(new Font("幼圆", Font.BOLD, 14));
		t5.setForeground(Color.RED);
		t5.setFont(new Font("幼圆", Font.BOLD, 14));
		
		this.setIconImage(Toolkit.getDefaultToolkit().createImage("we.jpg"));//添加窗体图标

		String path = "blue.jpg";// 添加背景图片  
	    ImageIcon background = new ImageIcon(path);// 把背景图片显示在一个标签里面  
	    JLabel label = new JLabel(background);// 把标签的大小位置设置为图片刚好填充整个面板  
	    label.setBounds(0, 0, this.getWidth(), this.getHeight());// 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明  
	    JPanel imagePanel = (JPanel) this.getContentPane();  
	    imagePanel.setOpaque(false);// 把背景图片添加到分层窗格的最底层作为背景  
	        //注意这里，将内容面板设为透明。这样LayeredPane面板中的背景才能显示出来。
	       //jframe窗口的组成部分，最底层是jrootpane面板。
	      //jframe的组成如下：jrootpane中包含glasspane和layeredpane两个面板。而layeredpane面板包含contentpane和jmenubar。
	     //在jframe上添加组件，往往是添加在contentpane中。。但是在contentpane的下面还有两层面板，那就是layeredpane和jrootpane。
	    this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));//设置可见

	    p1.setOpaque(false);//p1面板透明化可显示最底层面板图片
	    p2.setOpaque(false);//p2面板透明化
	    p3.setOpaque(false);//p3面板透明化
	    l1.setOpaque(false);//l1面板透明化
	    l2.setOpaque(false);//l2面板透明化
	    l3.setOpaque(false);//l3面板透明化
	    l4.setOpaque(false);//l4面板透明化
	    l5.setOpaque(false);//l5面板透明化
	    t2.setOpaque(false);//t2面板透明化
	    t3.setOpaque(false);//t3面板透明化
	    t4.setOpaque(false);//t4面板透明化
	    t5.setOpaque(false);//t5面板透明化
	    


	    resultList.setVisibleRowCount(5); 
		c.add(new JScrollPane(resultList)); 
		resultList.setForeground(Color.BLUE);
		resultList.setBackground(Color.PINK);
		listModel.addElement( "动态资金现值显示中...");
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		 b1.addMouseListener(new MouseAdapter() {
	            public void mouseClicked(MouseEvent e){
	                if(index == 0){
	                    zhongzhi = fulicalcutor();
	                    t5.setText(Double.toString(zhongzhi));
	                    listModel.addElement("复利计算："+Double.toString(zhongzhi));
	                    t5.setEnabled(true);
	                }else if(index == 1){
	                    zhongzhi = danlicalcutor();
	                    t5.setText(Double.toString(zhongzhi));
	                    listModel.addElement("单利计算："+Double.toString(zhongzhi));
	                    t5.setEnabled(true);
	                }else if(index == 2){
	                    benjin = benjincalcutor();
	                    t2.setText(Double.toString(benjin));
	                    listModel.addElement("本金计算："+Double.toString(benjin));
	                    t2.setEnabled(true);
	                }else if(index == 3){
	                    lilv = lilvcalcutor();
	                    t3.setText(Double.toString(lilv));
	                    listModel.addElement("利率计算："+Double.toString(lilv));
	                    t3.setEnabled(true);    
	                }else if(index == 4){
	                    nianxian = nianxiancalcutor();
	                    t4.setText(Double.toString(nianxian));
	                    listModel.addElement("年限计算："+Double.toString(nianxian));
	                    t4.setEnabled(true);    
	                }else if(index == 5){
	                    huankuan = yuehuankuanejisuan();
	                   t5.setText(Double.toString(huankuan));
	                   listModel.addElement("还款计算："+Double.toString(huankuan));
	                    t5.setEnabled(true);    
	                }
	            }
	        });
		   c1.addItemListener(new ItemListener() {
	            @Override
	            public void itemStateChanged(ItemEvent e) {
	                if(c1.getSelectedIndex()==0){
	                    index = 0;
	                    change();
	                    clear();
	                    t5.setText("计算所得");
	                    t5.setEnabled(false);
	                    //System.out.println("复利计算");
	                }else if(c1.getSelectedIndex()==1){
	                    index = 1;
	                    change();
	                    clear();
	                    t5.setText("计算所得");
	                   t5.setEnabled(false);
	                    //System.out.println("单利计算");
	                }else if(c1.getSelectedIndex()==2){
	                    index = 2;
	                    change01();
	                    clear();
	                    t2.setText("计算所得");
	                    t2.setEnabled(false);
	                    //System.out.println("本金计算");
	                }else if(c1.getSelectedIndex()==3){
	                    index = 3;
	                    change01();
	                    clear();
	                    t3.setText("计算所得");
	                    t3.setEnabled(false);
	                    //System.out.println("利率计算");
	                }else if(c1.getSelectedIndex()==4){
	                    index = 4;
	                    change01();
	                    clear();
	                    t4.setText("计算所得");
	                    t4.setEnabled(false);
	                }else if(c1.getSelectedIndex()==5){
	                    index = 5;
	                    change02();
	                    clear();
	                    t5.setText("计算所得");
	                    t5.setEnabled(false);
	                }
	            }
	        });
	}

	 private void clear() {
		 t2.setText(null);
	     t3.setText(null);
	     t4.setText(null);
	     t5.setText(null);
	     t2.setEnabled(true);
	     t3.setEnabled(true);
	     t4.setEnabled(true);
	     t5.setEnabled(true);
	     }

	  private void change02() {
	      l2.setText("贷款金额（元）：");
	      l3.setText("年利率（%）：");
	      l4.setText("还款期限（年）：");
	      l5.setText("月还款额（元）：");
	    }
	  private void change01() {
	      l2.setText("本金（元）：");
	      l3.setText("年利率（%）：");
	      l4.setText("年限（年）：");
	      l5.setText("终值（元）：");
	    }
	  private void change() {
	      l2.setText("本金（元）：");
	      l3.setText("年利率（%）：");
	      t3.setText("0.03");
	      l4.setText("年限（年）：");
	      l5.setText("终值（元）：");
	    }

	  private double yuehuankuanejisuan() {
	        try {
	            daikuan = Double.parseDouble(t2.getText());
	            lilv = Double.parseDouble(t3.getText());
	            nianxian = Double.parseDouble(t4.getText());
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(c, "请输入正确的数据");
	            //System.out.println("请输入数据");
	        }
	        return yuehuankuan(daikuan,lilv,nianxian);
	    }
	    //月还款额的计算公式
	    public static double yuehuankuan(double daikuan, double lilv, double nianxian) {
	        huankuan = daikuan * (lilv/12) * Math.pow( 1 + lilv/12 ,12 * nianxian)/(Math.pow(1 + lilv/12, 12 * nianxian)-1);
	        huankuan = Math.round(huankuan*100)/100;
	        return huankuan;
	    }
	    
	    //年限计算
	    private double nianxiancalcutor() {
	        try {
	            zhongzhi = Double.parseDouble(t5.getText());
	            lilv = Double.parseDouble(t3.getText());
	            benjin = Double.parseDouble(t2.getText());
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(c, "请输入正确的数据");
	            //System.out.println("请输入数据");
	        }
	        return nianxian(zhongzhi,lilv,benjin); 
	    }
	    //年限的计算公式
	    public static double nianxian(double zhongzhi, double lilv, double benjin) {
	        nianxian = (Math.log(zhongzhi / benjin) / Math.log(1 + lilv));
	        nianxian = Math.round(nianxian);
	        return nianxian;
	    }

	    //利率计算
	    private double lilvcalcutor() {
	        try {
	            zhongzhi = Double.parseDouble(t5.getText());
	            nianxian = Double.parseDouble(t4.getText());
	            benjin = Double.parseDouble(t2.getText());
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(c, "请输入正确的数据");
	            //System.out.println("请输入数据");
	        }
	        return lilv(zhongzhi,nianxian,benjin); 
	    }
	    //利率的计算公式
	    public static double lilv(double zhongzhi, double nianxian, double benjin) {
	        lilv = Math.pow((zhongzhi / benjin), (1.0 / nianxian)) - 1;
	        lilv = Math.round(lilv*100)/100.0;
	        return lilv;
	    }
	    
	    //本金计算
	    private double benjincalcutor() {
	        try {
	            zhongzhi = Double.parseDouble(t5.getText());
	            lilv = Double.parseDouble(t3.getText());
	            nianxian = Double.parseDouble(t4.getText());
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(c, "请输入正确的数据");
	            //System.out.println("请输入数据");
	        }
	        return benjin(zhongzhi,lilv,nianxian);
	    }
	    //本金的计算公式
	    public static double benjin(double zhongzhi, double lilv, double nianxian) {
	        benjin = zhongzhi / (Math.pow(1 + lilv, nianxian));
	        benjin = Math.round(benjin*100)/100; 
	        return benjin;
	    }

	    //单利计算
	    private double danlicalcutor() {
	        try {
	            benjin = Double.parseDouble(t2.getText());
	            lilv = Double.parseDouble(t3.getText());
	            nianxian = Double.parseDouble(t4.getText());
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(c, "请输入正确的数据");
	            //System.out.println("请输入数据");
	        }
	        return zhongzhi(benjin,lilv,nianxian);
	        
	    }
	    //单利的计算公式
	    public static double zhongzhi(double benjin, double lilv, double nianxian) {
	        zhongzhi = benjin * (1 + lilv * nianxian);
	        zhongzhi = Math.round(zhongzhi*100)/100; 
	        return zhongzhi;
	    }

	    //复利计算
	    private double fulicalcutor() {
	        try {
	            benjin = Double.parseDouble(t2.getText());
	            lilv = Double.parseDouble(t3.getText());
	            nianxian = Double.parseDouble(t4.getText());
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(c, "请输入正确的数据");
	            //System.out.println("请输入数据");
	        }
	        try {
	            dingtou = Double.parseDouble(t5.getText());
	        } catch (NumberFormatException e2) {
	            dingtou = 0;
	        }
	        return zhongzhi(benjin,lilv,nianxian,dingtou);
	    }
	    //复利的计算公式
	    public static double zhongzhi(double benjin, double lilv, double nianxian,
	            double dingtou) {
	        for(int i = 0;i < nianxian;i++){
	            benjin = benjin * (1 + lilv);
	            benjin = benjin + dingtou;
	        }
	        zhongzhi = benjin - dingtou;
	        zhongzhi = Math.round(zhongzhi*100)/100;
	        return zhongzhi;
	    }

	}