package maple_story;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Die extends JFrame {

	JLabel label;
	JOptionPane death;

	public Die() {
		initData();
		setInitLayout();
	}

	private void initData() {
		label = new JLabel(new ImageIcon("images/login/you_died.png"));
		setSize(1000, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void setInitLayout() {
		setVisible(true);
		setLocationRelativeTo(null);
		add(label);
		death = new JOptionPane();
		death.showMessageDialog(null, "캐릭터가 사망했습니다.\n확인을 누르시면 새로 시작합니다.");
		dispose();
		new Login();

	}

	public static void main(String[] args) {
		new Die();
	}

}
