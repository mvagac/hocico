package sk.umb.prog2.akvarium.obsah;

public abstract class Ryba {

	protected int x;
	protected int y;
	protected SmerRyby smer;

	public Ryba(int x, int y, SmerRyby smer) {
		this.x = x;
		this.y = y;
		this.smer = smer;
	}

	public boolean nachadzaSa(int x, int y) {
		return this.x==x && this.y==y;
	}

	public abstract String zobrazSa();

	public abstract void posun(int maxSirka, int maxVyska);

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public SmerRyby getSmer() {
		return smer;
	}

}
