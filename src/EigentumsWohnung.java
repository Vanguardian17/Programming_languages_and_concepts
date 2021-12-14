@SuppressWarnings("serial")
public class EigentumsWohnung extends Wohnung {
	private double betriebkosten;
	private double reparatur;
	
	
	
	public EigentumsWohnung(int id, double area, int roomNr, int floor, int year, String[] adress, double betriebkosten,
			double reparatur) {
		super(id, area, roomNr, floor, year, adress);
		this.betriebkosten = betriebkosten;
		this.reparatur = reparatur;
	}
	@Override
	//todo
	public double gesamtKosten() {
		return (betriebkosten*this.getArea() + reparatur*this.getArea()) * (1 + this.getFloor()*0.02);
	}
	@Override
	//todo
	public String toString() {
		return  "Typ:            EW\n" + super.toString() +
				"Betriebskosten: " + this.betriebkosten + "\n" +
				"Ruecklage:      " + this.reparatur + "\n";
	}
	
	
}