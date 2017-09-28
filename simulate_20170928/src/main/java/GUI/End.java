package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * 最后结果弹窗
 *
 * @author wf
 *
 */
public class End extends JFrame {

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
					End e = new End();
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
	public End() {
		frame = new JFrame();
		frame.setBounds(700, 280, 443, 285);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("");
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel("由于协议为概率性，其一次成功概率为" + Show.prob + "。");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label.setBounds(70, 45, 500, 50);
		frame.getContentPane().add(label);

		JLabel lblNewLabel = new JLabel("因此为使协议成功，共执行了" + Show.outstr + "次。");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel.setBounds(70, 124, 276, 36);
		frame.getContentPane().add(lblNewLabel);
	}
}
