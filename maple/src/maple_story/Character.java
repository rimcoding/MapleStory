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
