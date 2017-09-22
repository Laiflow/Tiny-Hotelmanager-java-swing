package com.hotframe;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.htdao.Dao;
import com.htutil.Operater;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.htutil.Operater;
import com.hotframe.index;
import com.htdao.*;
public class Login extends JFrame implements ActionListener{
	private JTextField jtpSearch=new JTextField(10);
	private JTextField jtpUser=new JTextField(10);
	private JPasswordField jtpPsw=new JPasswordField(10);
	private JButton jbSearch=new JButton("����");
	private JButton jbLoad=new JButton("��¼");
	private JButton jbRestart=new JButton("����");
	private JButton jbCancel=new JButton("ȡ��");
	private static Operater user;

	private ResultSet rs;
	int i=0;
	Login(){
		draw();
	}
	public void draw(){
		//����
		this.setSize(800,600);
		this.setTitle("����Ƶ����ϵͳ");
		Container t=this.getContentPane();
		t.setLayout(new BorderLayout());
		
		JPanel pNorth=new JPanel();
		JPanel pCenter=new JPanel();
		JPanel pEast=new JPanel();
		JPanel pSouth=new JPanel();
		
		t.add(pNorth,BorderLayout.NORTH);
		t.add(pCenter,BorderLayout.CENTER);
		t.add(pEast,BorderLayout.EAST);
		t.add(pSouth,BorderLayout.SOUTH);
		
		pNorth.setBorder(new LineBorder(new Color(81,147,253),2));
		pCenter.setBorder(new TitledBorder("������Ϣ"));
		pEast.setBorder(new LineBorder(new Color(81,147,253),1));
		pSouth.setBorder(new LineBorder(new Color(81,147,253),2));
		
		//����
		pNorth.setLayout(new BorderLayout());
		
		JPanel pNorth1=new JPanel();
		JPanel pNorth2=new JPanel();
		JPanel pNorth3=new JPanel();
		JPanel pNorth4=new JPanel();
		
		pNorth.add(pNorth1,BorderLayout.CENTER);
		pNorth.add(pNorth2,BorderLayout.WEST);
		
		Date now=new Date();	
		
		pNorth2.setLayout(new GridLayout(2,1));
		//pNorth2.add(new JLabel("վ����������ӭʹ�ã���"));
		pNorth2.add(pNorth3);
		
		pNorth3.setLayout(new FlowLayout(FlowLayout.CENTER));
		//pNorth3.add(jtpSearch);
		//pNorth3.add(jbSearch);
		
		pNorth4.setBackground(new Color(80,113,255));
		pNorth2.setBackground(new Color(80,113,255));
		pNorth3.setBackground(new Color(80,113,255));
		pNorth1.setBackground(new Color(80,113,255));
		
		//����
		pEast.setLayout(new GridLayout(3,1));
		
		JPanel pEast1=new JPanel();
		JPanel pEast2=new JPanel();
		JPanel pEast3=new JPanel();
		JPanel pEast4=new JPanel();
		JPanel pEast5=new JPanel();
		JPanel pEast6=new JPanel();
		JPanel pEast7=new JPanel();
		pEast.add(pEast2);
		pEast.add(pEast7);
		pEast.add(pEast1);
		
		
		
		pEast1.setLayout(new BorderLayout());
		pEast1.setBorder(new TitledBorder("��¼"));
		
		pEast1.add(pEast3,BorderLayout.CENTER);
		pEast1.add(pEast4,BorderLayout.SOUTH);
		
		pEast3.setLayout(new GridLayout(2,1));
		pEast3.add(pEast5);
		pEast3.add(pEast6);
		
		pEast5.setLayout(new FlowLayout(FlowLayout.LEFT));
		pEast6.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		pEast5.add(new JLabel("�û���"));
		pEast5.add(jtpUser);
		pEast6.add(new JLabel("��    ��"));
		pEast6.add(jtpPsw);
		
		pEast4.setLayout(new FlowLayout(FlowLayout.CENTER));
		pEast4.add(jbLoad);
		pEast4.add(jbRestart);
	
		
		pEast2.setLayout(new GridLayout(4,1));
		pEast2.setBorder(new TitledBorder("����"));
		JLabel jl=new JLabel("��ӭ��");
		jl.setForeground(new Color(81,147,253));
		JLabel jl1=new JLabel("�ȼ����еĺ�ѡ��");
		jl1.setForeground(new Color(81,147,253));
		JLabel jl2=new JLabel("������ĺ�ѡ��");
		jl2.setForeground(new Color(81,147,253));
		JLabel jl3=new JLabel("���ƵľƵ�Ԥ��ϵͳ������Ԥ���Ƶ�ͷ��������ɿ��");
		jl3.setForeground(new Color(81,147,253));
		pEast2.add(jl);	
		pEast2.add(jl1);	
		pEast2.add(jl2);	
		pEast2.add(jl3);	
		
		
		pEast7.setLayout(new GridLayout(4,1));
		JLabel jl71=new JLabel("����ܰ��ʾ��");
		JLabel jl72=new JLabel("1����Ԥ����N�䷿�������ṩ������Nλ����ס����������");
		JLabel jl73=new JLabel("2�����վƵ�涨��12��ǰ��ס��ȷ���");
		JLabel jl74=new JLabel("3��Ԥ���˾Ƶ��������ס������ʵ������");
		jl71.setForeground(new Color(81,147,253));
		jl72.setForeground(new Color(81,147,253));
		jl73.setForeground(new Color(81,147,253));
		jl74.setForeground(new Color(81,147,253));
		pEast7.add(jl71);
		pEast7.add(jl72);
		pEast7.add(jl73);
		pEast7.add(jl74);
		
		//�ϱ�
		pSouth.setLayout(new GridLayout(2,1));
		JPanel pSouth1=new JPanel();
		JPanel pSouth2=new JPanel();
		pSouth1.setLayout(new FlowLayout(FlowLayout.CENTER));
		pSouth2.setLayout(new FlowLayout(FlowLayout.CENTER));
		pSouth.add(pSouth1);
		pSouth.add(pSouth2);
		
		JLabel jl5=new JLabel("����Ƶ�");
		jl5.setForeground(new Color(81,147,253));
		pSouth1.add(jl5);
		
		
		
		//�м�
		pCenter.setLayout(new BorderLayout());
		JTabbedPane jtp=new JTabbedPane();
		pCenter.add(jtp,BorderLayout.CENTER);
		
		JPanel pCenter1=new JPanel();
		pCenter1.setLayout(new BorderLayout());
		pCenter1.add(new JLabel(new ImageIcon("res/r1.jpg") ));
		
		JPanel pCenter2=new JPanel();
		pCenter2.setLayout(new BorderLayout());
		pCenter2.add(new JLabel(new ImageIcon("res/r2.jpg") ));
		
		JPanel pCenter3=new JPanel();
		pCenter3.setLayout(new BorderLayout());
		pCenter3.add(new JLabel(new ImageIcon("res/r3.jpg") ));
		
		JPanel pCenter4=new JPanel();
		pCenter4.setLayout(new BorderLayout());
		pCenter4.add(new JLabel(new ImageIcon("res/r4.jpg") ));
		
		
		jtp.add(pCenter1,"�Ƶ�ȫ��");
		jtp.add(pCenter2,"��׼��");
		jtp.add(pCenter3,"�����");
		jtp.add(pCenter4,"������");
		jtp.setForeground(new Color(81,147,253));
		
		jbLoad.addActionListener(this);
		jbCancel.addActionListener(this);
		jbRestart.addActionListener(this);
	}
	public void actionPerformed(ActionEvent arg0) {
						user = Dao.check(jtpUser.getText(), jtpPsw.getText());
				if (user.getName() != null) {

					try {

						index frame = new index();
						frame.setVisible(true);
						Login.this.setVisible(false);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "�˺Ż����������");
		
				}
			}
	
	
	public static void main(String[] args) {
		Login login=new Login();
		login.setVisible(true);
		login.setDefaultCloseOperation(3);
	}
}
