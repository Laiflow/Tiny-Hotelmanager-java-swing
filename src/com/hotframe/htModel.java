package com.hotframe;

 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.*;
 
public class htModel extends AbstractTableModel{
 
 //rowData��������ݣ�columnNames�������
 Vector rowData,columnNames;
    
 //�����������ݿ�ı���
 Statement stat = null;
 Connection ct = null;
 ResultSet rs = null;
  
 //��ʼ��
 public void init(String sql){
  if(sql.equals("")){
   sql = "select * from stu";
  }
  //�м�
  //��������
  columnNames = new Vector();
  columnNames.add("���֤");
  columnNames.add("����");
  columnNames.add("�绰");
  columnNames.add("�����");

     
  //rowData��Ŷ���
  rowData = new Vector();
     
  try{
  //1.��������
  Class.forName("com.mysql.jdbc.Driver");
  System.out.println("���سɹ�");
  //2.�������ݿ�
  //���弸������
  String url = "jdbc:mysql://localhost:3306/test3";
  String user = "root";
  String passwd = "624077096a";
      
  ct = DriverManager.getConnection(url,user,passwd);
  stat = ct.createStatement();//����stat����
  rs = stat.executeQuery(sql);//��ѯ���
      
  while(rs.next()){
  Vector hang = new Vector();
  hang.add(rs.getString(1));
  hang.add(rs.getString(2));
  hang.add(rs.getString(3));
  hang.add(rs.getInt(4));
  hang.add(rs.getString(5));
  hang.add(rs.getString(6));
  //���뵽rowData��
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
  
 //����ѧ������
 public void addStu(String sql){
  //�����û������sql��䣬����������
   
   
   
 }
  
 //�ڶ������캯����ͨ�����ݵ�sql������������ģ��
 public htModel(String sql){
  this.init(sql);
 }
  
 //���캯�������ڳ�ʼ���ҵ�����ģ�ͣ���
 public htModel(){
  this.init("");
 }
  
 //�õ����ж�����
 public int getRowCount() {
  // TODO Auto-generated method stub
  return this.rowData.size();
 }
 
 //�õ����ж�����
 public int getColumnCount() {
  // TODO Auto-generated method stub
  return this.columnNames.size();
 }
 
 //�õ�ĳ��ĳ�е�����
 public Object getValueAt(int row, int column) {
  // TODO Auto-generated method stub
  return ((Vector)(this.rowData.get(row))).get(column);
 }
  
 //�õ���������
 public String getColumnName(int column) {
  // TODO Auto-generated method stub
  return (String)this.columnNames.get(column);
 }
}