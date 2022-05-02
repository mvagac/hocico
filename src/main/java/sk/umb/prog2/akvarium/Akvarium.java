package sk.umb.prog2.akvarium;

import java.util.ArrayList;
import java.util.Random;

import sk.umb.prog2.akvarium.obsah.Skalar;
import sk.umb.prog2.akvarium.obsah.Gupka;
import sk.umb.prog2.akvarium.obsah.Ryba;
import sk.umb.prog2.akvarium.obsah.SmerRyby;
import sk.umb.prog2.akvarium.vynimky.NepovoleneRozmeryAkvariaException;
import sk.umb.prog2.akvarium.vynimky.NepovolenyPocetRybException;
import sk.umb.prog2.akvarium.vynimky.NespravnySmerException;

public class Akvarium {

	private static final int CONST_MIN_SIRKA = 3;
	private static final int CONST_MIN_VYSKA = 3;

	int sirka;
	int vyska;
	ArrayList<Ryba> ryby = new ArrayList<Ryba>();

	public Akvarium(int sirka, int vyska, int pocRyb) throws NespravnySmerException, NepovolenyPocetRybException, NepovoleneRozmeryAkvariaException {
		if (sirka < CONST_MIN_SIRKA || vyska < CONST_MIN_VYSKA) {
			throw new NepovoleneRozmeryAkvariaException();
		}
		if (pocRyb > (sirka * vyska)/2) {
			throw new NepovolenyPocetRybException();
		}

		this.sirka = sirka;
		this.vyska = vyska;
		// generuj ryby
		Random rnd = new Random();
		for (int i = 0; i < pocRyb; i++) {
			SmerRyby smer;
			Ryba r;

			//r = new Ryba(rnd.nextInt(sirka), rnd.nextInt(vyska), smer);
			if (rnd.nextInt(10)<5) {
				if (rnd.nextInt(10)<5) {
					smer = SmerRyby.DOLAVA;
				} else {
					smer = SmerRyby.DOPRAVA;
				}
				r = new Gupka(rnd.nextInt(sirka), rnd.nextInt(vyska), smer);
			} else {
				if (rnd.nextInt(10)<5) {
					smer = SmerRyby.HORE;
				} else {
					smer = SmerRyby.DOLE;
				}
				r = new Skalar(rnd.nextInt(sirka), rnd.nextInt(vyska), smer);
			}


			ryby.add(r);
		}
	}

	int getSirka() {
		return sirka;
	}

	int getVyska() {
		return vyska;
	}

	void pridajRybu(Ryba r) {
		ryby.add(r);
	}

	void kresli() {		// display
		for (int j = 0; j < vyska; j++) {
			for (int i = 0; i < sirka; i++) {
				// zisti, ci sa na danej pozicii nachadza ryba
				Ryba najdenaRyba = null;
				for (Ryba r : ryby) {
					if (r.nachadzaSa(i, j)) {
						najdenaRyba = r;
						break;
					}
				}
				if (najdenaRyba!=null) {
					System.out.print(najdenaRyba.zobrazSa());
				} else {
					System.out.print(".");
				}
			}
			System.out.println();
		}
	}

	void posun() {
		for (Ryba r : ryby) {
			r.posun(sirka - 1, vyska - 1);
		}
	}

}
