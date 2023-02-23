package maple_story;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Character extends JLabel implements Move {

	// 상태
		protected boolean left;  
		protected boolean right;
		protected boolean up; // 사다리 올라가기
		protected boolean down;
		protected boolean jump;
		protected boolean attack; // 공격 모션중 (공격이나 스킬사용중 움직이지 못하게)
		// 좌표
		protected int x, y;
		// 캐릭터 이미지
		protected ImageIcon[] playerL = new ImageIcon[3];
		protected ImageIcon[] playerR = new ImageIcon[3];
		protected ImageIcon[] playerLadder = new ImageIcon[2];
		protected ImageIcon[] playerSwingL = new ImageIcon[3];
		protected ImageIcon[] playerSwingR = new ImageIcon[3];
		// 속도
		protected final int SPEED = 4;
		protected final int JUMP_SPEED = 2;
		// 캐릭터 스탯
		protected int maxHp;
		protected int hp;
		protected int maxMp;
		protected int mp;
		protected int str;
		protected int wis;
		protected int lv;
		// 배열 숫자용
		protected int arrN;
		
		

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

		public boolean isUp() {
			return up;
		}

		public void setUp(boolean up) {
			this.up = up;
		}

		public boolean isDown() {
			return down;
		}

		public void setDown(boolean down) {
			this.down = down;
		}

		public boolean isJump() {
			return jump;
		}

		public void setJump(boolean jump) {
			this.jump = jump;
		}

		public boolean isAttack() {
			return attack;
		}

		public void setAttack(boolean attack) {
			this.attack = attack;
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

		public ImageIcon[] getPlayerL() {
			return playerL;
		}

		public void setPlayerL(ImageIcon[] playerL) {
			this.playerL = playerL;
		}

		public ImageIcon[] getPlayerR() {
			return playerR;
		}

		public void setPlayerR(ImageIcon[] playerR) {
			this.playerR = playerR;
		}

		public ImageIcon[] getPlayerLadder() {
			return playerLadder;
		}

		public void setPlayerLadder(ImageIcon[] playerLadder) {
			this.playerLadder = playerLadder;
		}

		public ImageIcon[] getPlayerSwingL() {
			return playerSwingL;
		}

		public void setPlayerSwingL(ImageIcon[] playerSwingL) {
			this.playerSwingL = playerSwingL;
		}

		public ImageIcon[] getPlayerSwingR() {
			return playerSwingR;
		}

		public void setPlayerSwingR(ImageIcon[] playerSwingR) {
			this.playerSwingR = playerSwingR;
		}

		public int getMaxHp() {
			return maxHp;
		}

		public void setMaxHp(int maxHp) {
			this.maxHp = maxHp;
		}

		public int getHp() {
			return hp;
		}

		public void setHp(int hp) {
			this.hp = hp;
		}

		public int getMaxMp() {
			return maxMp;
		}

		public void setMaxMp(int maxMp) {
			this.maxMp = maxMp;
		}

		public int getMp() {
			return mp;
		}

		public void setMp(int mp) {
			this.mp = mp;
		}

		public int getStr() {
			return str;
		}

		public void setStr(int str) {
			this.str = str;
		}

		public int getWis() {
			return wis;
		}

		public void setWis(int wis) {
			this.wis = wis;
		}

		public int getLv() {
			return lv;
		}

		public void setLv(int lv) {
			this.lv = lv;
		}

		public int getArrN() {
			return arrN;
		}

		public void setArrN(int arrN) {
			this.arrN = arrN;
		}

		public int getSPEED() {
			return SPEED;
		}

		public int getJUMP_SPEED() {
			return JUMP_SPEED;
		}

		@Override
		public void left() {
			left = true;
			right = false;
			setIcon(playerL[1]);
			// 한번 키보다 왼쪽 방향 키를 누르면 쓰레드 생성
			new Thread(new Runnable() {

				@Override
				public void run() {
					while (left) {
						setIcon(playerL[arrN]);
						x -= SPEED;
						setLocation(x, y);
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} // end of while

				}
			}).start();
		}

		@Override
		public void right() {
			right = true;
			left = false;
			new Thread(new Runnable() {

				@Override
				public void run() {
					while (right) {
						setIcon(playerR[arrN]);
						x += SPEED;
						setLocation(x, y);
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}
			}).start();
		}
		
		@Override
		public void up() {
			up = true;
			new Thread(new Runnable() {

				@Override
				public void run() {
					while (up) {
						setIcon(playerLadder[arrN]);
						y -= SPEED;
						setLocation(x, y);
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					up = false;
				}
			}).start();
		}
		
		@Override
		public void down() {
			down = true;
			new Thread(new Runnable() {

				@Override
				public void run() {
					while (down) {
						setIcon(playerLadder[arrN]);
						y += SPEED;
						setLocation(x, y);
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					down = false;
				}
			}).start();
		}
		
		@Override
		public void jump() {
			
		}
		
		@Override
		public void attack() {
			
		}
		
		abstract void useSkill1();
		
		abstract void useSkill2();
		
		public void useHpPotion() {
			
			
			
		}
		
		public void useMpPotion() {
			
		}

	
}
