import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author wf
 *
 */
public class Show extends JFrame {

	JFrame frame;

	String[] s=new String[13];

	static String outstr="0";
	// 按钮
	JButton btnNewButton;// 开始按钮
	JButton btnNewButton_1;// 下一步按钮

	// 文本框
	JTextField textField;// a0
	JTextField textField_1;// a1
	JTextField textField_2;// b0
	JTextField textField_3;// b1
	JTextField textField_4;// a0*b0
	JTextField textField_5;// a1*b1

	JTextField textField_6;// 51
	JTextField textField_7;// 52
	JTextField textField_8;// 53
	JTextField textField_9;// 54
	JTextField textField_10;// 5f

	JTextField textField_11;// 21
	JTextField textField_12;// 22
	JTextField textField_13;// 23
	JTextField textField_14;// 24
	JTextField textField_15;// 2f

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					javax.swing.UIManager
							.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
					Show windows = new Show();
					windows.frame.setVisible(true);
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
	public void initialize() {


		frame = new JFrame();
		frame.setBounds(500, 180, 916, 735);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("simulate");
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel("\u8F93\u5165\uFF1A");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		label.setBounds(20, 40, 58, 32);
		frame.getContentPane().add(label);

		JLabel lblNewLabel = new JLabel("a0");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		lblNewLabel.setBounds(88, 25, 25, 23);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("a1");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(363, 25, 25, 23);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("b0");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(88, 84, 25, 23);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("b1");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(363, 84, 25, 23);
		frame.getContentPane().add(lblNewLabel_3);

		textField = new JTextField();
		textField.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		textField.setBounds(113, 26, 205, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		textField_1.setBounds(384, 24, 205, 25);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		textField_2.setBounds(113, 85, 205, 25);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		textField_3.setBounds(384, 83, 205, 25);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		btnNewButton = new JButton("\u5F00\u59CB");
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		btnNewButton.setBounds(689, 16, 132, 40);
		frame.getContentPane().add(btnNewButton);

		btnNewButton_1 = new JButton("\u4E0B\u4E00\u6B65");
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		btnNewButton_1.setBounds(689, 75, 132, 40);
		frame.getContentPane().add(btnNewButton_1);

		JLabel label_1 = new JLabel(
				"\u9884\u8BA1\u7ED3\u679C\uFF1A");//归一化后预计结果：
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		label_1.setBounds(10, 157, 159, 32);
		frame.getContentPane().add(label_1);

		JLabel lblAb = new JLabel("\u04242");
		lblAb.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		lblAb.setBounds(179, 162, 58, 23);
		frame.getContentPane().add(lblAb);

		JLabel lblAb_1 = new JLabel("\u04245");
		lblAb_1.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		lblAb_1.setBounds(179, 202, 58, 23);
		frame.getContentPane().add(lblAb_1);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		textField_4.setBounds(232, 163, 453, 25);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		textField_5.setColumns(10);
		textField_5.setBounds(232, 201, 453, 25);
		frame.getContentPane().add(textField_5);

		JLabel label_2 = new JLabel("\u042421");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		label_2.setBounds(104, 258, 45, 23);
		frame.getContentPane().add(label_2);

		JLabel label_3 = new JLabel("\u042422");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		label_3.setBounds(104, 353, 45, 23);
		frame.getContentPane().add(label_3);

		JLabel label_4 = new JLabel("\u042423");
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		label_4.setBounds(104, 434, 45, 23);
		frame.getContentPane().add(label_4);

		JLabel label_5 = new JLabel("\u042424");
		label_5.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		label_5.setBounds(104, 522, 45, 23);
		frame.getContentPane().add(label_5);

		JLabel lblf = new JLabel("\u04242f");
		lblf.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		lblf.setBounds(104, 610, 45, 23);
		frame.getContentPane().add(lblf);

		JLabel label_7 = new JLabel("\u042451");
		label_7.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		label_7.setBounds(104, 291, 45, 23);
		frame.getContentPane().add(label_7);

		JLabel label_8 = new JLabel("\u042452");
		label_8.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		label_8.setBounds(104, 386, 45, 23);
		frame.getContentPane().add(label_8);

		JLabel label_9 = new JLabel("\u042453");
		label_9.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		label_9.setBounds(104, 467, 45, 23);
		frame.getContentPane().add(label_9);

		JLabel label_10 = new JLabel("\u042454");
		label_10.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		label_10.setBounds(104, 555, 45, 23);
		frame.getContentPane().add(label_10);

		JLabel lblf_1 = new JLabel("\u03A65f");
		lblf_1.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		lblf_1.setBounds(104, 643, 45, 23);
		frame.getContentPane().add(lblf_1);

		textField_6 = new JTextField();
		textField_6.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		textField_6.setColumns(10);
		textField_6.setBounds(159, 257, 715, 25);
		frame.getContentPane().add(textField_6);

		textField_7 = new JTextField();
		textField_7.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		textField_7.setColumns(10);
		textField_7.setBounds(159, 352, 715, 25);
		frame.getContentPane().add(textField_7);

		textField_8 = new JTextField();
		textField_8.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		textField_8.setColumns(10);
		textField_8.setBounds(159, 434, 715, 25);
		frame.getContentPane().add(textField_8);

		textField_9 = new JTextField();
		textField_9.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		textField_9.setColumns(10);
		textField_9.setBounds(159, 521, 715, 25);
		frame.getContentPane().add(textField_9);

		textField_10 = new JTextField();
		textField_10.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		textField_10.setColumns(10);
		textField_10.setBounds(160, 609, 714, 25);
		frame.getContentPane().add(textField_10);

		textField_11 = new JTextField();
		textField_11.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		textField_11.setColumns(10);
		textField_11.setBounds(159, 290, 715, 25);
		frame.getContentPane().add(textField_11);

		textField_12 = new JTextField();
		textField_12.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		textField_12.setColumns(10);
		textField_12.setBounds(159, 385, 715, 25);
		frame.getContentPane().add(textField_12);

		textField_13 = new JTextField();
		textField_13.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		textField_13.setColumns(10);
		textField_13.setBounds(159, 466, 715, 25);
		frame.getContentPane().add(textField_13);

		textField_14 = new JTextField();
		textField_14.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		textField_14.setColumns(10);
		textField_14.setBounds(159, 554, 715, 25);
		frame.getContentPane().add(textField_14);

		textField_15 = new JTextField();
		textField_15.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		textField_15.setColumns(10);
		textField_15.setBounds(159, 642, 715, 25);
		frame.getContentPane().add(textField_15);


		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 开始
				if(!textField_4.getText().equals("")){
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("");
					textField_11.setText("");
					textField_7.setText("");
					textField_12.setText("");
					textField_8.setText("");
					textField_13.setText("");
					textField_9.setText("");
					textField_14.setText("");
					textField_10.setText("");
					textField_15.setText("");
				}

				String a0 = textField.getText();
				String a1 = textField_1.getText();
				String b0 = textField_2.getText();
				String b1 = textField_3.getText();

				// 这里设置str00和str11的值
				Simulate sim = new Simulate();
				sim.mySimulate(a0, b0, a1, b1);
				s=sim.getOutput();
				textField_4.setText(s[0]);
				textField_5.setText(s[1]);
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 下一步
				// 这里设置后面的值



				if (textField_6.getText().equals("")) {
					textField_6.setText(s[2]);
					textField_11.setText(s[3]);
				} else {
					if (textField_7.getText().equals("")) {
						textField_7.setText(s[4]);
						textField_12.setText(s[5]);
					} else {
						if (textField_8.getText().equals("")) {
							textField_8.setText(s[6]);
							textField_13.setText(s[7]);
						} else {
							if (textField_9.getText().equals("")) {
								textField_9.setText(s[8]);
								textField_14.setText(s[9]);
							} else {
								if (textField_10.getText().equals("")) {
									textField_10.setText(s[10]);
									textField_15.setText(s[11]);
								}
								else{
									//System.out.println("-------end-------"+s[12]);
									outstr=s[12];
									End window = new End();
									window.frame.setVisible(true);
								}
							}
						}
					}
				}
			}
		});

	}
	/**
	 * public void trigger(JButton button, final JTextField text, final String
	 * str){ button.addActionListener(new ActionListener() { public void
	 * actionPerformed(ActionEvent arg0) { text.setText(str); } }); }
	 **/
}
