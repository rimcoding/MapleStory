package maple_story;

import javax.swing.ImageIcon;

public class Snail extends Monster {

	public Snail(MapleFrame mContext) {
		super(mContext);
		initData();
		setInitlayout();
		right();
	}

	private void initData() {
		monsterL[0] = new ImageIcon("images/snail/move/move.0.png");
		monsterL[1] = new ImageIcon("images/snail/move/move.1.png");
		monsterL[2] = new ImageIcon("images/snail/move/move.2.png");

		monsterR[0] = new ImageIcon("images/snail/move/moveR.2.png");
		monsterR[1] = new ImageIcon("images/snail/move/moveR.2.png");
		monsterR[2] = new ImageIcon("images/snail/move/moveR.2.png");
	}

	private void setInitlayout() {
		setSize(50, 50);
		x = 50;
		y = 300;
		setLocation(x, y);
		setIcon(monsterR[0]);
	}
}