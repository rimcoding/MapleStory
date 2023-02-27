package maple_story;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BlueSnail extends JLabel implements MonsterMove {
	private MapleFrame mContext;
	// 살아있는 상태, 물방울에 죽은 상태
	private int state;
	// 체력 데미지 경험치
	private int hp;
	private int damage;
	final int EXP = 4;

	// 위치 상태
	private int x;
	private int y;

	private MonsterWay monsterWay;

	// 움직임 상태
	private boolean left;
	private boolean right;

	// 적군 속도 상태
	private final int SPEED = 2;

	// 적군 이미지
	private ImageIcon monsterR, monsterL;
	private ImageIcon monsterDieR, monsterDieL;


	public BlueSnail(MapleFrame mContext, MonsterWay monsterWay) {
		this.mContext = mContext;
		initData();
		setInitLayout();
		left();
	}

	public ImageIcon getMonsterR() {
		return monsterR;
	}

	public void setMonsterR(ImageIcon monsterR) {
		this.monsterR = monsterR;
	}

	public ImageIcon getMonsterL() {
		return monsterL;
	}

	public void setMonsterL(ImageIcon monsterL) {
		this.monsterL = monsterL;
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

	public MonsterWay getMonsterWay() {
		return monsterWay;
	}

	public void setMonsterWay(MonsterWay monsterWay) {
		this.monsterWay = monsterWay;
	}

	public int getSPEED() {
		return SPEED;
	}

	public void setState(int state) {
		this.state = state;
	}

	private void initData() {
		monsterR = new ImageIcon("images/snail_blue/move/BlueSnailMoveR.gif");
		monsterL = new ImageIcon("images/snail_blue/move/BlueSnailMoveL.gif");
		monsterDieR = new ImageIcon("images/snail_blue/die/BlueSnailDieR.gif");
		monsterDieL = new ImageIcon("images/snail_blue/die/BlueSnailDieL.gif");
		x = 330;
		y = 320;
		left = false;
		right = false;
		hp = 1234;
		damage = 60;
		state = 0;
		mContext.setStateBlueSnail(mContext.ALIVE);
	}

	private void setInitLayout() {

		setIcon(monsterR);
		setSize(50, 50);
		setLocation(x, y);

	}

	public int getState() {
		return state;

	}

	@Override
	public void left() {
		monsterWay = MonsterWay.LEFT;
		left = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				if (left && state == mContext.ALIVE) {
					while (true) {
						if(state == mContext.DEAD) {
							break;
						}
						if (Math.abs(x - mContext.getCharacter().getX()) < 10 && Math.abs(y - mContext.getCharacter().getY()) < 100) {
							mContext.getCharacter().beattackLeft(damage);
						}
						x -= SPEED;
						setIcon(monsterL);
						setLocation(x, y);
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						if (x <= 200) {
							left = false;
							right();
							break;
						}
					}
				}
			}
		}).start();

	}

	@Override
	public void right() {
		monsterWay = MonsterWay.RIGHT;
		right = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				if (right && state == mContext.ALIVE) {
					while (true) {
						if(state == mContext.DEAD) {
							break;
						}
						if (Math.abs(x - mContext.getCharacter().getX()) < 10 && Math.abs(y - mContext.getCharacter().getY()) < 100) {
							mContext.getCharacter().beattackRight(damage);
						}
						x += SPEED;
						setIcon(monsterR);
						setLocation(x, y);
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						if (x >= 900) {
							right = false;
							left();
							break;
						}
					}
				}
			}
		}).start();

	}
	public void damaged(int damage) {
		hp -= damage;
		if(hp > 0) {
			
		} else {
			state = mContext.DEAD;
			mContext.setStateBlueSnail(1);
			die();
		}
	}

	@Override
	public void die() {
		if(monsterWay == MonsterWay.LEFT) {
			setIcon(monsterDieL);
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			setIcon(monsterDieR);
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		setLocation(-100, -100);
		setIcon(null);
		mContext.getCharacter().takeExp(EXP);
	}

}
