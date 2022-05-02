package sk.umb.prog2.akvarium;

public class Hlavna {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Akvarium a = new Akvarium(30, 5, 5);
		while (true) {
			a.kresli();
			a.posun();
			System.out.println();
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				System.exit(0);
			}
		}
	}

}
