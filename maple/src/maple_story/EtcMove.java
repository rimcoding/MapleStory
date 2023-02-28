package maple_story;

public interface EtcMove {
	public abstract void left();

	public abstract void right();

	default public void die() {
	}
}
