import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JLabel;
import java.awt.Font;

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

		JLabel label = new JLabel("为使协议成功，共执行了"+Show.outstr+"次");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		label.setBounds(96, 86, 289, 50);
		frame.getContentPane().add(label);

	}
}
