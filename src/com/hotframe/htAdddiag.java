package com.hotframe;
import javax.swing.JDialog;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;
 
public class htAdddiag extends JDialog implements ActionListener {

 JLabel jl1,jl2,jl3,jl4,jl5,jl6;
 JTextField jf1,jf2,jf3,jf4,jf5,jf6;
 JPanel jp1,jp2,jp3;
 JButton jb1,jb2;
 //owner代笔父窗口,title是窗口的名字
 public htAdddiag(Frame owner,String title){
  //调用父类方法
  super(owner,title);
   
  jl1 = new JLabel("身份证");
  jl2 = new JLabel("姓名");
  jl3 = new JLabel("电话"); 
  jl4 = new JLabel("房间号");
  jl5 = new JLabel("待编辑");
  jl6 = new JLabel("待编辑");
   
  jf1 = new JTextField(10);
  jf2 = new JTextField(10);
  jf3 = new JTextField(10);
  jf4 = new JTextField(10);
  jf5 = new JTextField(10);
  jf6 = new JTextField(10);
   
  jb1 = new JButton("添加");
  jb1.addActionListener(this);
  jb2 = new JButton("取消");
  jb2.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			dispose();
		}
	});
  jp1 = new JPanel();
  jp2 = new JPanel();
  jp3 = new JPanel();
   
  //设置布局
  jp1.setLayout(new GridLayout(6,1));
  jp2.setLayout(new GridLayout(6,1));
   
  jp3.add(jb1);
  jp3.add(jb2);
   
  jp1.add(jl1);
  jp1.add(jl2);
  jp1.add(jl3);
  jp1.add(jl4);

   
  jp2.add(jf1);
  jp2.add(jf2);
  jp2.add(jf3);
  jp2.add(jf4);

   
  this.add(jp1, BorderLayout.WEST);
  this.add(jp2, BorderLayout.CENTER);
  this.add(jp3, BorderLayout.SOUTH);
   
  this.setSize(300,200);
  this.setVisible(true);
 }
 @Override
 public void actionPerformed(ActionEvent e) {
  // TODO Auto-generated method stub
  if(e.getSource() == jb1){
   Connection ct = null;
   PreparedStatement pstmt = null;
   ResultSet rs = null;
    
   try{
    //1.加载驱动
    Class.forName("com.mysql.jdbc.Driver");
    System.out.println("加载成功");
    //2.连接数据库
    //定义几个常量
    String url = "jdbc:mysql://localhost:3306/test3";
    String user = "root";
    String passwd = "624077096a";
    ct = DriverManager.getConnection(url,user,passwd);
   
    //与编译语句对象
    
    String strsql = "insert into stu values(?,?,?,?,?,?)";
    pstmt = ct.prepareStatement(strsql);
     
    //给对象赋值
    pstmt.setString(1,jf1.getText());
    pstmt.setString(2,jf2.getText());
    pstmt.setString(3,jf3.getText());
    pstmt.setString(4,jf4.getText());
    pstmt.setString(5,jf5.getText());
    pstmt.setString(6,jf6.getText());
     
    pstmt.executeUpdate();
     
    this.dispose();//关闭学生对话框
     
   }catch(Exception arg1){
    arg1.printStackTrace();
   }finally{
    try{
    if(rs!=null){
    rs.close();
    rs = null;
     }
    if(pstmt != null){
    pstmt.close();
    pstmt = null;
     }
    if(ct != null){
    ct.close();
    ct = null;
     }    
    }catch(Exception arg2){
     arg2.printStackTrace();
    }
   }
    
  }
   
 }
  
  
}