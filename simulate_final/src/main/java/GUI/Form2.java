package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * S1执行的Pauli阵和S2执行的Pauli阵
 *
 * @author wf
 *
 */
public class Form2 extends JFrame {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					javax.swing.UIManager
							.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
					Form2 e = new Form2();
					e.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Form2() {
		frame = new JFrame();
		frame.setBounds(700, 280, 461, 322);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("");
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("S1\u6267\u884C\u7684Pauli\u9635");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 63, 141, 27);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblSpauli = new JLabel("S2\u6267\u884C\u7684Pauli\u9635");
		lblSpauli.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpauli.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblSpauli.setBounds(10, 187, 141, 27);
		frame.getContentPane().add(lblSpauli);

		JLabel label1_0 = new JLabel("1234567890");
		label1_0.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label1_0.setHorizontalAlignment(SwingConstants.CENTER);
		label1_0.setBounds(161, 45, 112, 27);
		frame.getContentPane().add(label1_0);

		JLabel label1_1 = new JLabel("1234567890");
		label1_1.setHorizontalAlignment(SwingConstants.CENTER);
		label1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label1_1.setBounds(283, 45, 112, 27);
		frame.getContentPane().add(label1_1);

		JLabel label1_2 = new JLabel("1234567890");
		label1_2.setHorizontalAlignment(SwingConstants.CENTER);
		label1_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label1_2.setBounds(161, 82, 112, 27);
		frame.getContentPane().add(label1_2);

		JLabel label1_3 = new JLabel("1234567890");
		label1_3.setHorizontalAlignment(SwingConstants.CENTER);
		label1_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label1_3.setBounds(283, 82, 112, 27);
		frame.getContentPane().add(label1_3);

		JLabel label2_0 = new JLabel("1234567890");
		label2_0.setHorizontalAlignment(SwingConstants.CENTER);
		label2_0.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label2_0.setBounds(161, 167, 112, 27);
		frame.getContentPane().add(label2_0);

		JLabel label2_1 = new JLabel("1234567890");
		label2_1.setHorizontalAlignment(SwingConstants.CENTER);
		label2_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label2_1.setBounds(283, 167, 112, 27);
		frame.getContentPane().add(label2_1);

		JLabel label2_2 = new JLabel("1234567890");
		label2_2.setHorizontalAlignment(SwingConstants.CENTER);
		label2_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label2_2.setBounds(161, 200, 112, 27);
		frame.getContentPane().add(label2_2);

		JLabel label2_3 = new JLabel("1234567890");
		label2_3.setHorizontalAlignment(SwingConstants.CENTER);
		label2_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label2_3.setBounds(283, 200, 112, 27);
		frame.getContentPane().add(label2_3);

		label1_0.setText(Show.s1[0][0]);
		label1_1.setText(Show.s1[0][1]);
		label1_2.setText(Show.s1[1][0]);
		label1_3.setText(Show.s1[1][1]);

		label2_0.setText(Show.s2[0][0]);
		label2_1.setText(Show.s2[0][1]);
		label2_2.setText(Show.s2[1][0]);
		label2_3.setText(Show.s2[1][1]);
	}
}
