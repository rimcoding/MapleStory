package maple_story;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DamagedSkin extends JLabel {

	MapleFrame mContext;
	private ImageIcon skin50;
	private ImageIcon skin80;
	private ImageIcon skin100;
	private int damage;
	private int x, y;

	public DamagedSkin(MapleFrame mContext, int damage) {
		this.mContext = mContext;
		this.damage = damage;
		initData();
		setInitLayout();
		initThread();
	}

	private void initData() {
		skin50 = new ImageIcon("images/skin/50.png");
		skin80 = new ImageIcon("images/skin/80.png");
		skin100 = new ImageIcon("images/skin/100.png");
	}

	private void setInitLayout() {
		x = mContext.getCharacter().getX();
		y = mContext.getCharacter().getY();
		setLocation(x, y);
		setSize(114, 79);

	}

	private void initThread() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				up(damage);
			}
		}).start();
	}

	public void up(int damage) {
		if(damage == 50) {
			for (int i = 0; i < 50; i++) {
				setIcon(skin50);
				y--;
				setLocation(x, y);
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else if(damage == 80) {
			for (int i = 0; i < 50; i++) {
				setIcon(skin80);
				y--;
				setLocation(x, y);
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else if(damage == 100) {
			for (int i = 0; i < 50; i++) {
				setIcon(skin100);
				y--;
				setLocation(x, y);
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		setIcon(null);
	}
	
	
}
