package com.hotframe;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
 
public class hotelManage extends JFrame implements ActionListener {
 //定义一些控件
 JPanel jp1,jp2;
 JLabel jl1,jl2;
 JButton jb1,jb2,jb3,jb4,jb5;
 JTable jt;
 JScrollPane jsp;
 JTextField jtf;
 htModel sm; 
 //定义连接数据库的变量
 Statement stat = null;
 PreparedStatement ps;
 Connection ct = null;
 ResultSet rs = null;
  
 
 //构造函数
 public hotelManage(){
  jp1 = new JPanel();
  jtf = new JTextField(10);
  jb1 = new JButton("查询");
  jb1.addActionListener(this);
  jl1 = new JLabel("请输入名字：");
   
  jp1.add(jl1);
  jp1.add(jtf);
  jp1.add(jb1);
   
  jb2 = new JButton("添加");
  jb2.addActionListener(this);
  jb3 = new JButton("修改");
  jb3.addActionListener(this);
  jb4 = new JButton("删除");
  jb4.addActionListener(this);
  jb5 = new JButton("返回");
  jb5.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			dispose();
		}
	});
  jp2 = new JPanel();
  jp2.add(jb2);
  jp2.add(jb3);
  jp2.add(jb4);
   jp2.add(jb5);
   
  //创建模型对象
  sm = new htModel();
   
   
  //初始化
  jt = new JTable(sm);
   
  jsp = new JScrollPane(jt);
   
  //将jsp放入到jframe中
  this.add(jsp);
  this.add(jp1,"North");
  this.add(jp2,"South");
  this.setSize(600, 400);
  //this.setLocation(300, 200);
  this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
  this.setVisible(true);
  
 }
 public void actionPerformed(ActionEvent arg0) {
  //判断是哪个按钮被点击
  if(arg0.getSource() == jb1){
   System.out.println("查询...");
  //因为把对表的数据封装到htModel中，可以比较简单的完成查询
  String name = this.jtf.getText().trim();
 
  String sql = "select * from stu where stuName = '"+name+"' ";
  //构建一个数据模型类，并更新
  sm = new htModel(sql);
  //更新jtable
   jt.setModel(sm);
     
  }
   
  //一、弹出添加界面
  else if(arg0.getSource() == jb2){
  System.out.println("添加...");
  htAdddiag add = new htAdddiag(this,"添加房间信息");
    
  //重新再获得新的数据模型,
  sm = new htModel();
  jt.setModel(sm);
  }else if(arg0.getSource() == jb4){
  //二、删除记录
  //1.得到学生的ID
  int rowNum = this.jt.getSelectedRow();//getSelectedRow会返回给用户点中的行
  //如果该用户一行都没有选，就返回-1
  if(rowNum == -1){
  //提示
  JOptionPane.showMessageDialog(this, "请选中一行");
  return ;
  }
 //得到学术ID
  String stuId = (String)sm.getValueAt(rowNum, 0);
  System.out.println("Id： "+stuId);
    
  //连接数据库,完成删除任务
  try{
  //1.加载驱动
  Class.forName("com.mysql.jdbc.Driver"); 
  //2.连接数据库
  String url = "jdbc:mysql://localhost:3306/test3";
  String user = "root";
  String passwd = "624077096a";
     
  ct = DriverManager.getConnection(url, user, passwd);
  System.out.println("连接成功");
  ps = ct.prepareStatement("delete from stu where stuId = ?");
  ps.setString(1,stuId);
  ps.executeUpdate();
       
  }catch(Exception e){
   e.printStackTrace();
  }finally{
  try{
   if(rs!= null){
   rs.close();
   rs = null;
       
   }
   if(ps!= null){
   ps.close();
   ps = null;
   }
   if(ct != null){
   ct.close();
   ct = null;
   }
  } catch(Exception e){
   e.printStackTrace();
  }
   }
  sm = new htModel();
 //更新jtable
  jt.setModel(sm); 
  }else if(arg0.getSource() == jb3){
 
  //三、用户希望修改
  int rowNum = this.jt.getSelectedRow();
  if(rowNum == -1){
  //提示
  JOptionPane.showMessageDialog(this, "请选择一行");
  return ;
  }
  //显示对话框
 
 htUpDiag su = new htUpDiag(this, "修改", true, sm, rowNum);
 sm = new htModel();
 jt.setModel(sm);
  } 
 }
}