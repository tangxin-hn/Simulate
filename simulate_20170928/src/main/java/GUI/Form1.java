package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * VS1和VS2矩阵
 *
 * @author wf
 *
 */
public class Form1 extends JFrame {

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
					Form1 e = new Form1();
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
	public Form1() {

		frame = new JFrame();
		frame.setBounds(700, 280, 550, 448);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("");
		frame.getContentPane().setLayout(null);

		JLabel label_0 = new JLabel("1234567890");
		label_0.setHorizontalAlignment(SwingConstants.CENTER);
		label_0.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_0.setBounds(47, 50, 108, 30);
		frame.getContentPane().add(label_0);

		JLabel label_1 = new JLabel("1234567890");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_1.setBounds(149, 50, 108, 30);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("1234567890");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_2.setBounds(245, 50, 108, 30);
		frame.getContentPane().add(label_2);

		JLabel label_3 = new JLabel("1234567890");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_3.setBounds(344, 50, 108, 30);
		frame.getContentPane().add(label_3);

		JLabel label_4 = new JLabel("1234567890");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_4.setBounds(47, 90, 108, 30);
		frame.getContentPane().add(label_4);

		JLabel label_5 = new JLabel("1234567890");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_5.setBounds(149, 90, 108, 30);
		frame.getContentPane().add(label_5);

		JLabel label_6 = new JLabel("1234567890");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_6.setBounds(245, 90, 108, 30);
		frame.getContentPane().add(label_6);

		JLabel label_7 = new JLabel("1234567890");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_7.setBounds(344, 90, 108, 30);
		frame.getContentPane().add(label_7);

		JLabel label_8 = new JLabel("1234567890");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_8.setBounds(47, 130, 108, 30);
		frame.getContentPane().add(label_8);

		JLabel label_9 = new JLabel("1234567890");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_9.setBounds(149, 130, 108, 30);
		frame.getContentPane().add(label_9);

		JLabel label_10 = new JLabel("1234567890");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_10.setBounds(245, 130, 108, 30);
		frame.getContentPane().add(label_10);

		JLabel label_11 = new JLabel("1234567890");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_11.setBounds(344, 130, 108, 30);
		frame.getContentPane().add(label_11);

		JLabel label_12 = new JLabel("1234567890");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_12.setBounds(47, 170, 108, 30);
		frame.getContentPane().add(label_12);

		JLabel label_15 = new JLabel("1234567890");
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_15.setBounds(344, 170, 108, 30);
		frame.getContentPane().add(label_15);

		JLabel label_13 = new JLabel("1234567890");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_13.setBounds(149, 170, 108, 30);

		frame.getContentPane().add(label_13);

		JLabel label_14 = new JLabel("1234567890");
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_14.setBounds(245, 170, 108, 30);
		frame.getContentPane().add(label_14);

		JLabel lblS = new JLabel("S1\u6267\u884C\u7684V\u77E9\u9635VS1");
		lblS.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblS.setBounds(36, 10, 159, 30);
		frame.getContentPane().add(lblS);

		JLabel lblSvvs = new JLabel("S2\u6267\u884C\u7684V\u77E9\u9635VS2");
		lblSvvs.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblSvvs.setBounds(36, 206, 159, 30);
		frame.getContentPane().add(lblSvvs);

		JLabel label = new JLabel("1234567890");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label.setBounds(47, 242, 108, 30);
		frame.getContentPane().add(label);

		JLabel label_16 = new JLabel("1234567890");
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_16.setBounds(149, 242, 108, 30);
		frame.getContentPane().add(label_16);

		JLabel label_17 = new JLabel("1234567890");
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_17.setBounds(245, 242, 108, 30);
		frame.getContentPane().add(label_17);

		JLabel label_18 = new JLabel("1234567890");
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		label_18.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_18.setBounds(344, 242, 108, 30);
		frame.getContentPane().add(label_18);

		JLabel label_19 = new JLabel("1234567890");
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_19.setBounds(47, 278, 108, 30);
		frame.getContentPane().add(label_19);

		JLabel label_20 = new JLabel("1234567890");
		label_20.setHorizontalAlignment(SwingConstants.CENTER);
		label_20.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_20.setBounds(149, 278, 108, 30);
		frame.getContentPane().add(label_20);

		JLabel label_21 = new JLabel("1234567890");
		label_21.setHorizontalAlignment(SwingConstants.CENTER);
		label_21.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_21.setBounds(245, 278, 108, 30);
		frame.getContentPane().add(label_21);

		JLabel label_22 = new JLabel("1234567890");
		label_22.setHorizontalAlignment(SwingConstants.CENTER);
		label_22.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_22.setBounds(344, 278, 108, 30);
		frame.getContentPane().add(label_22);

		JLabel label_23 = new JLabel("1234567890");
		label_23.setHorizontalAlignment(SwingConstants.CENTER);
		label_23.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_23.setBounds(47, 312, 108, 30);
		frame.getContentPane().add(label_23);

		JLabel label_24 = new JLabel("1234567890");
		label_24.setHorizontalAlignment(SwingConstants.CENTER);
		label_24.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_24.setBounds(149, 312, 108, 30);
		frame.getContentPane().add(label_24);

		JLabel label_25 = new JLabel("1234567890");
		label_25.setHorizontalAlignment(SwingConstants.CENTER);
		label_25.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_25.setBounds(245, 312, 108, 30);
		frame.getContentPane().add(label_25);

		JLabel label_26 = new JLabel("1234567890");
		label_26.setHorizontalAlignment(SwingConstants.CENTER);
		label_26.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_26.setBounds(344, 312, 108, 30);
		frame.getContentPane().add(label_26);

		JLabel label_27 = new JLabel("1234567890");
		label_27.setHorizontalAlignment(SwingConstants.CENTER);
		label_27.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_27.setBounds(47, 344, 108, 30);
		frame.getContentPane().add(label_27);

		JLabel label_28 = new JLabel("1234567890");
		label_28.setHorizontalAlignment(SwingConstants.CENTER);
		label_28.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_28.setBounds(149, 344, 108, 30);
		frame.getContentPane().add(label_28);

		JLabel label_29 = new JLabel("1234567890");
		label_29.setHorizontalAlignment(SwingConstants.CENTER);
		label_29.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_29.setBounds(245, 344, 108, 30);
		frame.getContentPane().add(label_29);

		JLabel label_30 = new JLabel("1234567890");
		label_30.setHorizontalAlignment(SwingConstants.CENTER);
		label_30.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_30.setBounds(344, 344, 108, 30);
		frame.getContentPane().add(label_30);
		// vs1矩阵
		label_0.setText(Show.vs1[0][0]);
		label_1.setText(Show.vs1[0][1]);
		label_2.setText(Show.vs1[0][2]);
		label_3.setText(Show.vs1[0][3]);

		label_4.setText(Show.vs1[1][0]);
		label_5.setText(Show.vs1[1][1]);
		label_6.setText(Show.vs1[1][2]);
		label_7.setText(Show.vs1[1][3]);

		label_8.setText(Show.vs1[2][0]);
		label_9.setText(Show.vs1[2][1]);
		label_10.setText(Show.vs1[2][2]);
		label_11.setText(Show.vs1[2][3]);

		label_12.setText(Show.vs1[3][0]);
		label_13.setText(Show.vs1[3][1]);
		label_14.setText(Show.vs1[3][2]);
		label_15.setText(Show.vs1[3][3]);

		// vs2矩阵
		label.setText(Show.vs2[0][0]);
		label_16.setText(Show.vs2[0][1]);
		label_17.setText(Show.vs2[0][2]);
		label_18.setText(Show.vs2[0][3]);

		label_19.setText(Show.vs2[1][0]);
		label_20.setText(Show.vs2[1][1]);
		label_21.setText(Show.vs2[1][2]);
		label_22.setText(Show.vs2[1][3]);

		label_23.setText(Show.vs2[2][0]);
		label_24.setText(Show.vs2[2][1]);
		label_25.setText(Show.vs2[2][2]);
		label_26.setText(Show.vs2[2][3]);

		label_27.setText(Show.vs2[3][0]);
		label_28.setText(Show.vs2[3][1]);
		label_29.setText(Show.vs2[3][2]);
		label_30.setText(Show.vs2[3][3]);
	}

}
