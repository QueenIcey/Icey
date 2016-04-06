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
	JLabel l1 = new JLabel("��������:");
	JLabel l2 = new JLabel("����Ԫ��:");
	JLabel l3 = new JLabel("�����ʣ�%��:");
	JLabel l4 = new JLabel("���ޣ��꣩:");
	JLabel l5 = new JLabel("��ֵ��Ԫ��:");
	JTextField t2 = new JTextField(10);
	JTextField t3 = new JTextField(10);
	JTextField t4 = new JTextField(10);
	JTextField t5 = new JTextField(10);

	JButton b1 = new JButton("����");
	String[] selectedText = { "��������", "��������", "�������", "���ʼ���", "���޼���","�µȶ�����" };
	JComboBox c1 = new JComboBox(selectedText);
	
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	
    DefaultListModel listModel=new DefaultListModel(); 
	JList resultList=new JList(listModel);	
	
	MyFrame() {
		this.setSize(320,400);
		this.setTitle("����������");
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
		
		b1.setFont(new Font(null, Font.BOLD, 15));
		b1.setForeground(Color.BLACK);
		
	    resultList.setVisibleRowCount(5); 
		c.add(new JScrollPane(resultList)); 
		resultList.setForeground(Color.BLACK);
		resultList.setBackground(Color.LIGHT_GRAY);
		listModel.addElement( "��̬�ʽ���ֵ��ʾ��...");
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		 b1.addMouseListener(new MouseAdapter() {
	            public void mouseClicked(MouseEvent e){
	                if(index == 0){
	                    zhongzhi = fulicalcutor();
	                    t5.setText(Double.toString(zhongzhi));
	                    listModel.addElement("�������㣺"+Double.toString(zhongzhi));
	                    t5.setEnabled(true);
	                }else if(index == 1){
	                    zhongzhi = danlicalcutor();
	                    t5.setText(Double.toString(zhongzhi));
	                    listModel.addElement("�������㣺"+Double.toString(zhongzhi));
	                    t5.setEnabled(true);
	                }else if(index == 2){
	                    benjin = benjincalcutor();
	                    t2.setText(Double.toString(benjin));
	                    listModel.addElement("������㣺"+Double.toString(benjin));
	                    t2.setEnabled(true);
	                }else if(index == 3){
	                    lilv = lilvcalcutor();
	                    t3.setText(Double.toString(lilv));
	                    listModel.addElement("���ʼ��㣺"+Double.toString(lilv));
	                    t3.setEnabled(true);    
	                }else if(index == 4){
	                    nianxian = nianxiancalcutor();
	                    t4.setText(Double.toString(nianxian));
	                    listModel.addElement("���޼��㣺"+Double.toString(nianxian));
	                    t4.setEnabled(true);    
	                }else if(index == 5){
	                    huankuan = yuehuankuanejisuan();
	                   t5.setText(Double.toString(huankuan));
	                   listModel.addElement("������㣺"+Double.toString(huankuan));
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
	                    t5.setText("��������");
	                    t5.setEnabled(false);
	                    //System.out.println("��������");
	                }else if(c1.getSelectedIndex()==1){
	                    index = 1;
	                    change();
	                    clear();
	                    t5.setText("��������");
	                   t5.setEnabled(false);
	                    //System.out.println("��������");
	                }else if(c1.getSelectedIndex()==2){
	                    index = 2;
	                    change01();
	                    clear();
	                    t2.setText("��������");
	                    t2.setEnabled(false);
	                    //System.out.println("�������");
	                }else if(c1.getSelectedIndex()==3){
	                    index = 3;
	                    change01();
	                    clear();
	                    t3.setText("��������");
	                    t3.setEnabled(false);
	                    //System.out.println("���ʼ���");
	                }else if(c1.getSelectedIndex()==4){
	                    index = 4;
	                    change01();
	                    clear();
	                    t4.setText("��������");
	                    t4.setEnabled(false);
	                }else if(c1.getSelectedIndex()==5){
	                    index = 5;
	                    change02();
	                    clear();
	                    t5.setText("��������");
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
	      l2.setText("�����Ԫ����");
	      l3.setText("�����ʣ�%����");
	      l4.setText("�������ޣ��꣩��");
	      l5.setText("�»���Ԫ����");
	    }
	  private void change01() {
	      l2.setText("����Ԫ����");
	      l3.setText("�����ʣ�%����");
	      l4.setText("���ޣ��꣩��");
	      l5.setText("��ֵ��Ԫ����");
	    }
	  private void change() {
	      l2.setText("����Ԫ����");
	      l3.setText("�����ʣ�%����");
	      l4.setText("���ޣ��꣩��");
	      l5.setText("��ֵ��Ԫ����");
	    }

	  private double yuehuankuanejisuan() {
	        try {
	            daikuan = Double.parseDouble(t2.getText());
	            lilv = Double.parseDouble(t3.getText());
	            nianxian = Double.parseDouble(t4.getText());
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(c, "��������ȷ������");
	            //System.out.println("����������");
	        }
	        return yuehuankuan(daikuan,lilv,nianxian);
	    }
	    //�»����ļ��㹫ʽ
	    public static double yuehuankuan(double daikuan, double lilv, double nianxian) {
	        huankuan = daikuan * (lilv/12) * Math.pow( 1 + lilv/12 ,12 * nianxian)/(Math.pow(1 + lilv/12, 12 * nianxian)-1);
	        huankuan = Math.round(huankuan*100)/100;
	        return huankuan;
	    }
	    
	    //���޼���
	    private double nianxiancalcutor() {
	        try {
	            zhongzhi = Double.parseDouble(t5.getText());
	            lilv = Double.parseDouble(t3.getText());
	            benjin = Double.parseDouble(t2.getText());
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(c, "��������ȷ������");
	            //System.out.println("����������");
	        }
	        return nianxian(zhongzhi,lilv,benjin); 
	    }
	    //���޵ļ��㹫ʽ
	    public static double nianxian(double zhongzhi, double lilv, double benjin) {
	        nianxian = (Math.log(zhongzhi / benjin) / Math.log(1 + lilv));
	        nianxian = Math.round(nianxian);
	        return nianxian;
	    }

	    //���ʼ���
	    private double lilvcalcutor() {
	        try {
	            zhongzhi = Double.parseDouble(t5.getText());
	            nianxian = Double.parseDouble(t4.getText());
	            benjin = Double.parseDouble(t2.getText());
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(c, "��������ȷ������");
	            //System.out.println("����������");
	        }
	        return lilv(zhongzhi,nianxian,benjin); 
	    }
	    //���ʵļ��㹫ʽ
	    public static double lilv(double zhongzhi, double nianxian, double benjin) {
	        lilv = Math.pow((zhongzhi / benjin), (1.0 / nianxian)) - 1;
	        lilv = Math.round(lilv*100)/100.0;
	        return lilv;
	    }
	    
	    //�������
	    private double benjincalcutor() {
	        try {
	            zhongzhi = Double.parseDouble(t5.getText());
	            lilv = Double.parseDouble(t3.getText());
	            nianxian = Double.parseDouble(t4.getText());
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(c, "��������ȷ������");
	            //System.out.println("����������");
	        }
	        return benjin(zhongzhi,lilv,nianxian);
	    }
	    //����ļ��㹫ʽ
	    public static double benjin(double zhongzhi, double lilv, double nianxian) {
	        benjin = zhongzhi / (Math.pow(1 + lilv, nianxian));
	        benjin = Math.round(benjin*100)/100; 
	        return benjin;
	    }

	    //��������
	    private double danlicalcutor() {
	        try {
	            benjin = Double.parseDouble(t2.getText());
	            lilv = Double.parseDouble(t3.getText());
	            nianxian = Double.parseDouble(t4.getText());
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(c, "��������ȷ������");
	            //System.out.println("����������");
	        }
	        return zhongzhi(benjin,lilv,nianxian);
	        
	    }
	    //�����ļ��㹫ʽ
	    public static double zhongzhi(double benjin, double lilv, double nianxian) {
	        zhongzhi = benjin * (1 + lilv * nianxian);
	        zhongzhi = Math.round(zhongzhi*100)/100; 
	        return zhongzhi;
	    }

	    //��������
	    private double fulicalcutor() {
	        try {
	            benjin = Double.parseDouble(t2.getText());
	            lilv = Double.parseDouble(t3.getText());
	            nianxian = Double.parseDouble(t4.getText());
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(c, "��������ȷ������");
	            //System.out.println("����������");
	        }
	        try {
	            dingtou = Double.parseDouble(t5.getText());
	        } catch (NumberFormatException e2) {
	            dingtou = 0;
	        }
	        return zhongzhi(benjin,lilv,nianxian,dingtou);
	    }
	    //�����ļ��㹫ʽ
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