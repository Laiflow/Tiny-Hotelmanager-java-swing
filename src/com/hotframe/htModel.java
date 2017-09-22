package com.hotframe;

 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.*;
 
public class htModel extends AbstractTableModel{
 
 //rowData存放行数据，columnNames存放列名
 Vector rowData,columnNames;
    
 //定义连接数据库的变量
 Statement stat = null;
 Connection ct = null;
 ResultSet rs = null;
  
 //初始化
 public void init(String sql){
  if(sql.equals("")){
   sql = "select * from stu";
  }
  //中间
  //设置列名
  columnNames = new Vector();
  columnNames.add("身份证");
  columnNames.add("名字");
  columnNames.add("电话");
  columnNames.add("房间号");

     
  //rowData存放多行
  rowData = new Vector();
     
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
  stat = ct.createStatement();//创建stat对象
  rs = stat.executeQuery(sql);//查询结果
      
  while(rs.next()){
  Vector hang = new Vector();
  hang.add(rs.getString(1));
  hang.add(rs.getString(2));
  hang.add(rs.getString(3));
  hang.add(rs.getInt(4));
  hang.add(rs.getString(5));
  hang.add(rs.getString(6));
  //加入到rowData中
  rowData.add(hang);
       
  }
      
 }catch(Exception e){
  e.printStackTrace();
 }finally{
  try{
  if(rs!=null){
  rs.close();
  rs = null;
   }
  if(stat != null){
  stat.close();
  stat = null;
   }
  if(ct != null){
  ct.close();
  ct = null;
   }
    }catch(Exception e){
   e.printStackTrace();
   }
  }
 }
  
 //增加学生函数
 public void addStu(String sql){
  //根据用户输入的sql语句，完成添加任务
   
   
   
 }
  
 //第二个构造函数，通过传递的sql语句来获得数据模型
 public htModel(String sql){
  this.init(sql);
 }
  
 //构造函数，用于初始化我的数据模型（表）
 public htModel(){
  this.init("");
 }
  
 //得到共有多少行
 public int getRowCount() {
  // TODO Auto-generated method stub
  return this.rowData.size();
 }
 
 //得到共有多少列
 public int getColumnCount() {
  // TODO Auto-generated method stub
  return this.columnNames.size();
 }
 
 //得到某行某列的数据
 public Object getValueAt(int row, int column) {
  // TODO Auto-generated method stub
  return ((Vector)(this.rowData.get(row))).get(column);
 }
  
 //得到属性名字
 public String getColumnName(int column) {
  // TODO Auto-generated method stub
  return (String)this.columnNames.get(column);
 }
}