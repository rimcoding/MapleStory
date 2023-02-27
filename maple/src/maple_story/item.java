package maple_story;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Item extends JLabel {

	private ImageIcon hpPotion;
	private ImageIcon mpPotion;
	private MapleFrame mContext;

	public Item(MapleFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
	}

	public ImageIcon getHpPotion() {
		return hpPotion;
	}

	public void setHpPotion(ImageIcon hpPotion) {
		this.hpPotion = hpPotion;
	}

	public ImageIcon getMpPotion() {
		return mpPotion;
	}

	public void setMpPotion(ImageIcon mpPotion) {
		this.mpPotion = mpPotion;
	}

	public MapleFrame getmContext() {
		return mContext;
	}

	public void setmContext(MapleFrame mContext) {
		this.mContext = mContext;
	}

	private void initData() {
		hpPotion = new ImageIcon("images/item/hp_potion.png");
		mpPotion = new ImageIcon("images/item/mp_potion.png");
	}

	private void setInitLayout() {
		setSize(50, 50);

	}

}
