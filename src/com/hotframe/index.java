package com.hotframe;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import frame.MainFrame;

import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Window.Type;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class index extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					index frame = new index();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 
	/**
	 * Create the frame.
	 */
	public index() {
		setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 12));
		setTitle("\u4E1C\u8F6F\u9152\u5E97\u4FE1\u606F\u7BA1\u7406\u5E73\u53F0");
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 577);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u623F\u95F4\u4FE1\u606F");
		mnNewMenu.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 12));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_2 = new JMenu("\u5269\u4F59\u623F\u95F4\u67E5\u770B");
		mnNewMenu_2.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 12));
		mnNewMenu.add(mnNewMenu_2);
		
		JMenu mnNewMenu_1 = new JMenu("\u7BA1\u7406\u5458\u4FE1\u606F");
		mnNewMenu_1.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_5 = new JMenu("\u5173\u4E8E");
		mnNewMenu_5.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 12));
		mnNewMenu_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "东软酒店信息系统1.0beta /n"
					
		                , "关于本软件", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		menuBar.add(mnNewMenu_5);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(173, 216, 230));
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u9152\u5E97\u623F\u95F4\u7CFB\u7EDF");
		btnNewButton.setBackground(new Color(230, 230, 250));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MainFrame.instance().open();
			}
		});
		btnNewButton.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 14));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(54, 75, 144, 112);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("\u5546\u54C1\u8D2D\u4E70\u7CFB\u7EDF");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "时间关系，尚未开发，等待更新。"
						
		                , "商品管理系统", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		button.setBackground(new Color(211, 211, 211));
		button.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 14));
		button.setBounds(54, 336, 144, 112);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u9000\u51FA\u7CFB\u7EDF");
		button_1.setBackground(new Color(192, 192, 192));
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 System.exit(0);
			}
		});
		button_1.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 14));
		button_1.setBounds(297, 336, 144, 112);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u7528\u6237\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		button_2.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				hotelManage sa = new hotelManage();
			}
		});
		button_2.setBackground(new Color(205, 92, 92));
		button_2.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 14));
		button_2.setBounds(297, 75, 144, 112);
		contentPane.add(button_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(index.class.getResource("/res/3.jpg")));
		lblNewLabel.setBounds(0, 0, 523, 517);
		contentPane.add(lblNewLabel);
	}
}
