package Task6;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class values extends JFrame {

	private JPanel contentPane;
	private JTextField textField_hex;
	private JTextField textField_Decimal;
	private JTextField textField_Octal;
	private JTextField textField_Binary;
	private JTextField textField_Speed;
	private JTextField textField_Redval;
	private JTextField textField_Blueval;
	private JTextField textField_Greenval;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					values frame = new values();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param input 
	 * @param settings 
	 * @param settings. 
	 */
	public values(DanceSettings settings, String hex) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 510, 149);
		contentPane.add(panel);
		panel.setLayout(null);
		
	
		JLabel lblValues = new JLabel("Values");
		lblValues.setBounds(20, 20, 61, 16);
		panel.add(lblValues);
		
		JLabel lblHexValue = new JLabel("Hex Value");
		lblHexValue.setBounds(25, 166, 97, 16);
		contentPane.add(lblHexValue);
		
		JLabel lblDecimalValue = new JLabel("Decimal Value");
		lblDecimalValue.setBounds(25, 194, 102, 16);
		contentPane.add(lblDecimalValue);
		
		JLabel lblOctalValue = new JLabel("Octal Value");
		lblOctalValue.setBounds(25, 229, 97, 16);
		contentPane.add(lblOctalValue);
		
		JLabel lblBinaryValue = new JLabel("Binary Value");
		lblBinaryValue.setBounds(25, 271, 97, 16);
		contentPane.add(lblBinaryValue);
		
		JLabel lblSpeedValue = new JLabel("Speed Value");
		lblSpeedValue.setBounds(25, 309, 97, 16);
		contentPane.add(lblSpeedValue);
		
		JLabel lblRedValue = new JLabel("Red Value");
		lblRedValue.setBounds(25, 349, 61, 16);
		contentPane.add(lblRedValue);
		
		JLabel lblBlueValue = new JLabel("Blue Value");
		lblBlueValue.setBounds(25, 387, 82, 16);
		contentPane.add(lblBlueValue);
		
		JLabel lblGreenValue = new JLabel("Green Value");
		lblGreenValue.setBounds(25, 425, 77, 16);
		contentPane.add(lblGreenValue);
		
		textField_hex = new JTextField();
		textField_hex.setBounds(134, 161, 130, 26);
		contentPane.add(textField_hex);
		textField_hex.setColumns(10);
		textField_hex.setText(hex);
		textField_hex.setEditable(false);
		
		textField_Decimal = new JTextField();
		textField_Decimal.setBounds(134, 189, 130, 26);
		contentPane.add(textField_Decimal);
		textField_Decimal.setColumns(10);
		textField_Decimal.setText((Integer.toString(settings.initDecimal)));				textField_Decimal.setEditable(false);
		
		textField_Octal = new JTextField();
		textField_Octal.setBounds(134, 229, 130, 26);
		contentPane.add(textField_Octal);
		textField_Octal.setColumns(10);
		textField_Octal.setText(Integer.toString(settings.initOctal));
		textField_Octal.setEditable(false);
		
		
		textField_Binary = new JTextField();
		textField_Binary.setBounds(134, 266, 130, 26);
		contentPane.add(textField_Binary);
		textField_Binary.setColumns(10);
		textField_Binary.setText((settings.getDanceMovesAsString()));
		textField_Binary.setEditable(false);
		
		textField_Speed = new JTextField();
		textField_Speed.setBounds(134, 304, 130, 26);
		contentPane.add(textField_Speed);
		textField_Speed.setColumns(10);
		textField_Speed.setText(Integer.toString(settings.speed));
		textField_Speed.setEditable(false);
		
		textField_Redval = new JTextField();
		textField_Redval.setBounds(134, 344, 130, 26);
		contentPane.add(textField_Redval);
		textField_Redval.setColumns(10);
		textField_Redval.setText(Integer.toString(settings.redvalue));
		textField_Redval.setEditable(false);
		
		textField_Blueval = new JTextField();
		textField_Blueval.setBounds(134, 382, 130, 26);
		contentPane.add(textField_Blueval);
		textField_Blueval.setColumns(10);
		textField_Blueval.setText(Integer.toString(settings.blueval));
		textField_Blueval.setEditable(false);
		
		textField_Greenval = new JTextField();
		textField_Greenval.setBounds(134, 420, 130, 26);
		contentPane.add(textField_Greenval);
		textField_Greenval.setColumns(10);
		textField_Greenval.setText(Integer.toString(settings.greenval));
		textField_Greenval.setEditable(false);
		
		JTextArea txtrTheseAreThe = new JTextArea();
		txtrTheseAreThe.setBackground(Color.LIGHT_GRAY);
		txtrTheseAreThe.setFont(new Font("Bangla MN", Font.PLAIN, 10));
		txtrTheseAreThe.setLineWrap(true);
		txtrTheseAreThe.setEditable(false);
		txtrTheseAreThe.setText("These are the values generated by your hexadecimal value. If you are unhappy with these values you can choose Try Another Hex Value to select a different hexadecimal value *WARNING* the dance for the current hexadecimal value has not been executed and therefore will not be stored in the hexlog text file.");
		txtrTheseAreThe.setBounds(20, 44, 470, 99);
		txtrTheseAreThe.setWrapStyleWord(true);
		panel.add(txtrTheseAreThe);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnContinue.setBounds(25, 477, 117, 29);
		contentPane.add(btnContinue);
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				task6 t6 = new task6();
				t6.start(hex);
				danceFinish d1 = new danceFinish();
				d1.setVisible(true);
				dispose();
			}
		});
		
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnQuit.setBounds(431, 477, 56, 29);
		contentPane.add(btnQuit);
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JButton btnTryAnotherHex = new JButton("Try Another Hex Value");
		btnTryAnotherHex.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnTryAnotherHex.setBounds(279, 477, 140, 29);
		contentPane.add(btnTryAnotherHex);
		btnTryAnotherHex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enterHex newhex = new enterHex();
				newhex.setVisible(true);
				dispose();
			}
		});
	}
	public values() {		
	}
}
