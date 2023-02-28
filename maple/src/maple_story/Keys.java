package maple_story;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Keys extends JLabel {
	private ImageIcon keys;
	private MapleFrame mContext;

	public Keys(MapleFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
	}

	public ImageIcon getKeys() {
		return keys;
	}

	public void setKeys(ImageIcon keys) {
		this.keys = keys;
	}

	public MapleFrame getmContext() {
		return mContext;
	}

	public void setmContext(MapleFrame mContext) {
		this.mContext = mContext;
	}

	private void initData() {
		keys = new ImageIcon("images/keys/keys2.png");
	}

	private void setInitLayout() {
		setLocation(100, 700);
		setSize(619, 130);
		setIcon(keys);
	}
}
