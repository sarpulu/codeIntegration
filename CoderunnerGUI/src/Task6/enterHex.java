package Task6;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Pattern;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.awt.event.ActionEvent;

public class enterHex extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnterHexNumber;
	private JTextField txtEnterTextfileLocation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					enterHex frame = new enterHex();
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
	public enterHex() {
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 310);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 450, 80);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Hexadecimal Number");
		lblNewLabel.setFont(new Font("Bangla MN", Font.BOLD, 13));
		lblNewLabel.setBounds(6, 20, 200, 16);
		panel.add(lblNewLabel);
		
		JLabel lblOnlyHexadecimalsOf = new JLabel("Only Hexadecimals of length 2 are accepted!");
		lblOnlyHexadecimalsOf.setFont(new Font("Bangla MN", Font.PLAIN, 10));
		lblOnlyHexadecimalsOf.setBounds(6, 40, 281, 16);
		panel.add(lblOnlyHexadecimalsOf);
		
		txtEnterHexNumber = new JTextField();
		txtEnterHexNumber.setText("Enter Hex Number Here");
		txtEnterHexNumber.setBounds(10, 92, 201, 26);
		contentPane.add(txtEnterHexNumber);
		txtEnterHexNumber.setColumns(10);		
		
		JButton btnContinue = new JButton("Enter");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = txtEnterHexNumber.getText();
				//error checks
				
				
				if ((input.length()>2)||(input.length()<2)) {//this is a check for length.Assignment specifically asks for hex of length 2.
					JOptionPane.showMessageDialog(contentPane, "Error. Please enter a two digit hexadecimal number");
					enterHex newhex = new enterHex();
					newhex.setVisible(true);
					dispose();
				}
				else {
				HexConverter converter = new HexConverter();
				//DanceSettings settings = converter.convert(input);
				
				int decimal = HexConverter.fromHextoInt(input);
				int octal = HexConverter.fromDecimalToOctal(decimal); 
				ArrayList<Integer> binarylist = HexConverter.fromDecimalToBinary(decimal);
				DanceSettings settings = new DanceSettings(decimal, octal, binarylist, input);
				values val = new values(settings, input);
				val.setVisible(true);
				dispose();
				}
			}
		});
		btnContinue.setBounds(10, 243, 117, 29);
		contentPane.add(btnContinue);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(327, 243, 117, 29);
		contentPane.add(btnQuit);
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		
		}
	}

