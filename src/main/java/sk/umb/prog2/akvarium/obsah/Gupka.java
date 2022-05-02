package sk.umb.prog2.akvarium.obsah;

import sk.umb.prog2.akvarium.vynimky.NespravnySmerException;

public class Gupka extends Ryba {

	public Gupka(int x, int y, SmerRyby smer) throws NespravnySmerException {
		super(x, y, smer);
		if (smer!=SmerRyby.DOLAVA && smer!=SmerRyby.DOPRAVA) {
			throw new NespravnySmerException();
		}
	}

	@Override
	public String zobrazSa() {
		return "G";
	}

	@Override
	public void posun(int maxSirka, int maxVyska) {
		if (smer==SmerRyby.DOLAVA) {
			x--;
			if (x<=0) {
				smer = SmerRyby.DOPRAVA;
			}
		} else if (smer==SmerRyby.DOPRAVA) {
			x++;
			if (x>=maxSirka) {
				smer = SmerRyby.DOLAVA;
			}
		}
	}

}
