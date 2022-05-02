package sk.umb.prog2.akvarium.obsah;

import sk.umb.prog2.akvarium.vynimky.NespravnySmerException;

public class Skalar extends Ryba {

	public Skalar(int x, int y, SmerRyby smer) throws NespravnySmerException {
		super(x, y, smer);
		if (smer!=SmerRyby.HORE && smer!=SmerRyby.DOLE) {
			throw new NespravnySmerException();
		}
	}

	@Override
	public String zobrazSa() {
		return "S";
	}

	@Override
	public void posun(int maxSirka, int maxVyska) {
		if (smer==SmerRyby.HORE) {
			y--;
			if (y<=0) {
				smer = SmerRyby.DOLE;
			}
		} else if (smer==SmerRyby.DOLE) {
			y++;
			if (y>=maxVyska) {
				smer = SmerRyby.HORE;
			}
		}
	}

}
