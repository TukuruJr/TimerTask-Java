/**
 * this program uses timer class and timertask class
 * to schedule a task to be done in a given time interval
 * this program generates a random value in every two seconds and shows them.
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;

public class Show {

	private JFrame frmTimer;
	private JTextField number;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Show window = new Show();
					window.frmTimer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Show() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTimer = new JFrame();
		frmTimer.getContentPane().setBackground(Color.ORANGE);
		frmTimer.setTitle("Timer");
		frmTimer.setBounds(100, 100, 450, 300);
		frmTimer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTimer.getContentPane().setLayout(null);
		
		JLabel lblTimertaskAndTimer = new JLabel("TimerTask and Timer Class in Java");
		lblTimertaskAndTimer.setForeground(Color.BLACK);
		lblTimertaskAndTimer.setBounds(75, 12, 292, 15);
		frmTimer.getContentPane().add(lblTimertaskAndTimer);
		
		JButton btnStart = new JButton("START");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Timer().schedule(new TimerTask() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						ChangeValue();
						
					}
					
				}, 0,2000);
				
			}
		});
		btnStart.setBounds(131, 56, 117, 25);
		frmTimer.getContentPane().add(btnStart);
		
		number = new JTextField();
		number.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		number.setForeground(Color.RED);
		number.setHorizontalAlignment(SwingConstants.CENTER);
		number.setText("0");
		number.setEditable(false);
		number.setBounds(134, 199, 114, 31);
		frmTimer.getContentPane().add(number);
		number.setColumns(10);
		
		JLabel lblTheBelowValue = new JLabel("the below value changes after every two seconds");
		lblTheBelowValue.setForeground(Color.BLACK);
		lblTheBelowValue.setBounds(31, 142, 383, 15);
		frmTimer.getContentPane().add(lblTheBelowValue);
		
		JLabel lblRange = new JLabel("Range (0-100)");
		lblRange.setForeground(Color.BLACK);
		lblRange.setBounds(141, 172, 107, 15);
		frmTimer.getContentPane().add(lblRange);
	}
	
	private void ChangeValue() {
		Random ran = new Random();
		int num = ran.nextInt(100)+1;
		number.setText(num+"");
	}
}
