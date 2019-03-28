import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import Task1.*;
import Task2.*;
import Task3.*;
import Task4.*;
import Task5.*;
import Task6.*;
import Task7.*;

public class codeIntegration extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					codeIntegration frame = new codeIntegration();
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
	public codeIntegration() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodeIntegration = new JLabel("Code Integration");
		lblCodeIntegration.setFont(new Font("Apple Color Emoji", Font.BOLD, 13));
		lblCodeIntegration.setBounds(170, 6, 138, 16);
		contentPane.add(lblCodeIntegration);
		
		JButton task_1Btn = new JButton("Task 1");
		task_1Btn.setBounds(30, 60, 117, 29);
		contentPane.add(task_1Btn);
		task_1Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SearchforLight T1 = new SearchforLight();
				dispose();
			}
		});
		
		JButton task_2Btn = new JButton("Task 2");
		task_2Btn.setBounds(310, 60, 117, 29);
		contentPane.add(task_2Btn);
		task_2Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Task2ADIL1723816 T2 = new Task2ADIL1723816();
				dispose();
			}
		});
		
		JButton task_3Btn = new JButton("Task 3");
		task_3Btn.setBounds(30, 130, 117, 29);
		contentPane.add(task_3Btn);
		task_3Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				navigate T3 = new navigate();
				dispose();
			}
		});
		
		JButton task_4Btn = new JButton("Task 4");
		task_4Btn.setBounds(310, 130, 117, 29);
		contentPane.add(task_4Btn);
		task_4Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ZigZag T4 = new ZigZag();
				dispose();
			}
		});
		
		JButton task_6Btn = new JButton("Task 6");
		task_6Btn.setBounds(30, 200, 117, 29);
		contentPane.add(task_6Btn);
		task_6Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
			
		
		JButton task_7Btn = new JButton("Task 7");
		task_7Btn.setBounds(310, 200, 117, 29);
		contentPane.add(task_7Btn);
		task_7Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tilt_Control T7 = new tilt_Control();
				dispose();
			}
		});
		
		
		
		
		JLabel lblSearchForLight = new JLabel("Search For Light");
		lblSearchForLight.setBounds(40, 43, 101, 16);
		contentPane.add(lblSearchForLight);
		
		JLabel lblDrawAShape = new JLabel("Draw a Shape");
		lblDrawAShape.setBounds(327, 43, 90, 16);
		contentPane.add(lblDrawAShape);
		
		JLabel lblNavigate = new JLabel("Navigate");
		lblNavigate.setBounds(55, 112, 61, 16);
		contentPane.add(lblNavigate);
		
		JLabel lblTask = new JLabel("Zigzag");
		lblTask.setBounds(354, 112, 47, 16);
		contentPane.add(lblTask);
		
		JLabel lblTiltControl = new JLabel("Tilt Control");
		lblTiltControl.setBounds(331, 183, 86, 16);
		contentPane.add(lblTiltControl);
		
		JLabel lblDance = new JLabel("Dance");
		lblDance.setBounds(69, 183, 47, 16);
		contentPane.add(lblDance);
	}
}

