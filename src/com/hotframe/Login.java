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
	private JButton jbSearch=new JButton("检索");
	private JButton jbLoad=new JButton("登录");
	private JButton jbRestart=new JButton("重填");
	private JButton jbCancel=new JButton("取消");
	private static Operater user;

	private ResultSet rs;
	int i=0;
	Login(){
		draw();
	}
	public void draw(){
		//整体
		this.setSize(800,600);
		this.setTitle("东软酒店管理系统");
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
		pCenter.setBorder(new TitledBorder("房间信息"));
		pEast.setBorder(new LineBorder(new Color(81,147,253),1));
		pSouth.setBorder(new LineBorder(new Color(81,147,253),2));
		
		//北边
		pNorth.setLayout(new BorderLayout());
		
		JPanel pNorth1=new JPanel();
		JPanel pNorth2=new JPanel();
		JPanel pNorth3=new JPanel();
		JPanel pNorth4=new JPanel();
		
		pNorth.add(pNorth1,BorderLayout.CENTER);
		pNorth.add(pNorth2,BorderLayout.WEST);
		
		Date now=new Date();	
		
		pNorth2.setLayout(new GridLayout(2,1));
		//pNorth2.add(new JLabel("站内收索，欢迎使用！！"));
		pNorth2.add(pNorth3);
		
		pNorth3.setLayout(new FlowLayout(FlowLayout.CENTER));
		//pNorth3.add(jtpSearch);
		//pNorth3.add(jbSearch);
		
		pNorth4.setBackground(new Color(80,113,255));
		pNorth2.setBackground(new Color(80,113,255));
		pNorth3.setBackground(new Color(80,113,255));
		pNorth1.setBackground(new Color(80,113,255));
		
		//东边
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
		pEast1.setBorder(new TitledBorder("登录"));
		
		pEast1.add(pEast3,BorderLayout.CENTER);
		pEast1.add(pEast4,BorderLayout.SOUTH);
		
		pEast3.setLayout(new GridLayout(2,1));
		pEast3.add(pEast5);
		pEast3.add(pEast6);
		
		pEast5.setLayout(new FlowLayout(FlowLayout.LEFT));
		pEast6.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		pEast5.add(new JLabel("用户名"));
		pEast5.add(jtpUser);
		pEast6.add(new JLabel("密    码"));
		pEast6.add(jtpPsw);
		
		pEast4.setLayout(new FlowLayout(FlowLayout.CENTER));
		pEast4.add(jbLoad);
		pEast4.add(jbRestart);
	
		
		pEast2.setLayout(new GridLayout(4,1));
		pEast2.setBorder(new TitledBorder("新闻"));
		JLabel jl=new JLabel("欢迎您");
		jl.setForeground(new Color(81,147,253));
		JLabel jl1=new JLabel("度假休闲的好选择");
		jl1.setForeground(new Color(81,147,253));
		JLabel jl2=new JLabel("出差工作的好选择");
		jl2.setForeground(new Color(81,147,253));
		JLabel jl3=new JLabel("完善的酒店预订系统，让您预订酒店客房更加轻松快捷");
		jl3.setForeground(new Color(81,147,253));
		pEast2.add(jl);	
		pEast2.add(jl1);	
		pEast2.add(jl2);	
		pEast2.add(jl3);	
		
		
		pEast7.setLayout(new GridLayout(4,1));
		JLabel jl71=new JLabel("【温馨提示】");
		JLabel jl72=new JLabel("1、您预订了N间房，请您提供不少于N位的入住客人姓名；");
		JLabel jl73=new JLabel("2、按照酒店规定：12点前入住需等房；");
		JLabel jl74=new JLabel("3、预订此酒店务必留入住客人真实姓名。");
		jl71.setForeground(new Color(81,147,253));
		jl72.setForeground(new Color(81,147,253));
		jl73.setForeground(new Color(81,147,253));
		jl74.setForeground(new Color(81,147,253));
		pEast7.add(jl71);
		pEast7.add(jl72);
		pEast7.add(jl73);
		pEast7.add(jl74);
		
		//南边
		pSouth.setLayout(new GridLayout(2,1));
		JPanel pSouth1=new JPanel();
		JPanel pSouth2=new JPanel();
		pSouth1.setLayout(new FlowLayout(FlowLayout.CENTER));
		pSouth2.setLayout(new FlowLayout(FlowLayout.CENTER));
		pSouth.add(pSouth1);
		pSouth.add(pSouth2);
		
		JLabel jl5=new JLabel("东软酒店");
		jl5.setForeground(new Color(81,147,253));
		pSouth1.add(jl5);
		
		
		
		//中间
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
		
		
		jtp.add(pCenter1,"酒店全景");
		jtp.add(pCenter2,"标准间");
		jtp.add(pCenter3,"商务间");
		jtp.add(pCenter4,"豪华间");
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
					JOptionPane.showMessageDialog(null, "账号或者密码错误！");
		
				}
			}
	
	
	public static void main(String[] args) {
		Login login=new Login();
		login.setVisible(true);
		login.setDefaultCloseOperation(3);
	}
}
