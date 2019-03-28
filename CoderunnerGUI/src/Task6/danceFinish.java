package Task6;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class danceFinish extends JFrame {

private JPanel contentPane;

/**

* Launch the application.

*/

public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
danceFinish frame = new danceFinish();
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

public danceFinish() {
	setBackground(Color.WHITE);
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBackground(Color.WHITE);
	contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
	setContentPane(contentPane);
	contentPane.setLayout(null);


	JPanel panel = new JPanel();
	panel.setBackground(Color.LIGHT_GRAY);
	panel.setBounds(0, 0, 450, 70);
	contentPane.add(panel);
	panel.setLayout(null);


	JLabel lblDanceFinished = new JLabel("Dance Finished!");
	lblDanceFinished.setFont(new Font("Bangla MN", Font.BOLD, 13));
	lblDanceFinished.setBounds(6, 20, 178, 16);
	panel.add(lblDanceFinished);


	JTextArea txtrTheDanceHad = new JTextArea();
	txtrTheDanceHad.setEditable(false);
	txtrTheDanceHad.setFont(new Font("Lucida Bright", Font.PLAIN, 12));
	txtrTheDanceHad.setWrapStyleWord(true);
	txtrTheDanceHad.setLineWrap(true);
	txtrTheDanceHad.setText("The dance had finished, select Try Another Hex Value to return to the start, or select quit to terminate the program. A textfile will be generated with all the hexadecimal values that you have used so far.");
	txtrTheDanceHad.setBounds(10, 82, 434, 70);
	contentPane.add(txtrTheDanceHad);


	JButton btnTryAnotherHex = new JButton("Try Another Hex Value");
	btnTryAnotherHex.setBounds(10, 243, 185, 29);
	contentPane.add(btnTryAnotherHex);
	btnTryAnotherHex.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			enterHex hex = new enterHex();
			hex.setVisible(true);
			dispose();
		}
	});


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
