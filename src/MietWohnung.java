@SuppressWarnings("serial")
public class MietWohnung extends Wohnung {
	private double mietkosten;
	private int mieterNr;
	public MietWohnung(int id, double area, int roomNr, int floor, int year, String[] adress, double mietkosten,
			int mieterNr) {
		super(id, area, roomNr, floor, year, adress);
		this.mietkosten = mietkosten;
		this.mieterNr = mieterNr;
	
	
	}
	@Override
	public double gesamtKosten() {
		double zuschlag = 0;
		switch(mieterNr) {
		case 0: break;
		case 1: break;
		case 2: zuschlag = 0.025; break;
		case 3: zuschlag = 0.05; break;
		case 4: zuschlag = 0.075; break;
		case 5: zuschlag = 0.1; break;
		default: if(mieterNr > 5) zuschlag = 0.1;
		}
		return mietkosten*this.getArea() * (1 + zuschlag);
	}
	@Override
	public String toString() {
		return  "Typ:            MW\n" + super.toString() +
				"Miete/m2:       " + this.mietkosten + "\n" +
				"Anzahl Mieter:  " + this.mieterNr + "\n";
	}
	
	
	
	
}