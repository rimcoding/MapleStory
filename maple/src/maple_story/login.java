package maple_story;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {

	ImagePanel imagePanel;

	class ImagePanel extends JPanel {
		private Image image;

		public ImagePanel() {
			image = new ImageIcon("images/login/start.png").getImage();
		}

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(image, 0, 0, 500, 500, null);
		}
	} // end of inner class

	public Login() {

		initData();
		setInitLayout();

	}

	private void initData() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("로그인");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		imagePanel = new ImagePanel();
	}

	private void setInitLayout() {
		// 버튼 패널
		JPanel btnPanel = new JPanel();
		JLabel id = new JLabel("아이디");
		btnPanel.add(id);
		JTextField txtID = new JTextField(10);
		btnPanel.add(txtID);
		JLabel password = new JLabel("비밀번호");
		btnPanel.add(password);
		JTextField txtPass = new JTextField(10);
		btnPanel.add(txtPass);
		JButton logbtn = new JButton("로그인");
		btnPanel.add(logbtn);

		logbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = "maple";
				String password = "1234";

				if (id.equals(txtID.getText()) && password.equals(txtPass.getText())) {
					JOptionPane.showMessageDialog(null, "로그인 성공");

					MapleFrame frame = new MapleFrame();
					frame.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "로그인 실패");

//				else {
//					JOptionPane.showMessageDialog(null, "로그인 실패");
//				}
				}
			}
		});

		// 레이아웃 설정
		setLayout(new BorderLayout());
		add(imagePanel, BorderLayout.CENTER);
		add(btnPanel, BorderLayout.SOUTH);
		setVisible(true);

	}

	public static void main(String[] args) {
		new Login();
	}

}