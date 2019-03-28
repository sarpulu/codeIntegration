package Task6;

import java.awt.BorderLayout;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;

public class welcomeScreen extends JFrame{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					welcomeScreen frame = new welcomeScreen();
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
	public welcomeScreen() {
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 1, 450, 75);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Dancer Program");
		lblWelcomeToThe.setFont(new Font("Bangla MN", Font.BOLD, 13));
		lblWelcomeToThe.setBounds(20, 20, 303, 16);
		panel.add(lblWelcomeToThe);
		
		
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.setBounds(243, 240, 85, 20);
		contentPane.add(btnContinue);
		
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				enterHex hex = new enterHex();
				hex.setVisible(true);
				dispose();
			}
		});
	
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(340, 240, 85, 20);
		contentPane.add(btnQuit);
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JTextArea txtrThisProgramTakes = new JTextArea();
		txtrThisProgramTakes.setFont(new Font("Lucida Bright", Font.PLAIN, 12));
		txtrThisProgramTakes.setText("This program takes a two digit hexadecimal number from the user and converts it to binary, octal and decimal. The binary number is used to set the direction. The octal is used to set the speed and the decimal is used to set the colour of the LED.");
		txtrThisProgramTakes.setBounds(20, 88, 406, 140);
		contentPane.add(txtrThisProgramTakes);
		txtrThisProgramTakes.setLineWrap(true);
	}
}
