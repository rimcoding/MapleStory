package maple_story;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Monster extends JLabel implements MonsterMove {

	MapleFrame mContext;
	// 살아 있는 상태 (0) 죽은상태(1)
	public int x;
	public int y;

	// 움직임 상태
	public ImageIcon[] monsterL = new ImageIcon[3];
	public ImageIcon[] monsterR = new ImageIcon[3];
	public ImageIcon[] monsterDie = new ImageIcon[3];

	public boolean left;
	public boolean right;

	// 적군 속도 상태
	public final int SPEED = 3;

	// 몬스터 스탯
	public int maxHp;
	public int monsterHp;
	public int power;

	// 배열 숫자
	public int arrN;

	public Monster(MapleFrame mContext) {
		this.mContext = mContext;
		right();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public ImageIcon[] getMonsterL() {
		return monsterL;
	}

	public void setMonsterL(ImageIcon[] monsterL) {
		this.monsterL = monsterL;
	}

	public ImageIcon[] getMonsterR() {
		return monsterR;
	}

	public void setMonsterR(ImageIcon[] monsterR) {
		this.monsterR = monsterR;
	}

	public ImageIcon[] getMonsterDie() {
		return monsterDie;
	}

	public void setMonsterDie(ImageIcon[] monsterDie) {
		this.monsterDie = monsterDie;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getHp() {
		return monsterHp;
	}

	public void setHp(int hp) {
		monsterHp = hp;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getSPEED() {
		return SPEED;
	}

	@Override
	public void left() {
		left = true;
		right = false;
		arrN = 1;
		setIcon(monsterL[1]);
		new Thread(() -> {
			while (left) {
				x -= SPEED;
				setLocation(x, y);
				try {
					Thread.sleep(10);
					setIcon(monsterL[arrN]);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				arrN += 1;
				if (arrN > 2) {
					arrN = 0;
				}

			}
		}).start();
		;

	}

	@Override
	public void right() {
		right = true;
		left = false;
		arrN = 1;
		setIcon(monsterR[1]);
		new Thread(() -> {
			while (right) {
				x += SPEED;
				repaint();
				setLocation(x, y);
				try {
					Thread.sleep(70);
					setIcon(monsterR[arrN]);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				arrN += 1;
				if (arrN > 2) {
					arrN = 0;
				}

			}
		}).start();
		;

	}

	public void monsterHp() {
		if (monsterHp == 0) {

		}
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}
