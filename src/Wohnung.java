import java.io.Serializable;
import java.text.DecimalFormat;

@SuppressWarnings("serial")
public abstract class Wohnung implements Serializable {
	private int id;
	private double area;
	private int roomNr;
	private int floor;
	private int year;
	private String[] adress;
	
	public Wohnung(int id, double area, int roomNr, 
			int floor, int year, String[] adress){
		if(year>2021) throw new IllegalArgumentException("Error: Baujahr ungueltig.");
		this.id = id; this.area=area; this.roomNr=roomNr; 
		this.floor=floor; this.year=year;
		this.adress=adress;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getArea() {
		return area;
	}


	public void setArea(int area) {
		this.area = area;
	}


	public int getRoomNr() {
		return roomNr;
	}


	public void setRoomNr(int roomNr) {
		this.roomNr = roomNr;
	}


	public int getFloor() {
		return floor;
	}


	public void setFloor(int floor) {
		this.floor = floor;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public String[] getAdress() {
		return adress;
	}


	public void setAdress(String[] adress) {
		this.adress = adress;
	}


	public int alter() {
		return 2021 - year;
	}
		
	public abstract double gesamtKosten();
	
	public String getDecimalFormat(double i) {
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		return decimalFormat.format(i);
	}


	@Override
	public String toString() {
		return  "Id:             " + this.getId() + "\n" +
				"Flaeche:        " + getDecimalFormat(this.getArea()) + "\n" + 
				"Zimmer:         " + this.getRoomNr() + "\n" +
				"Stock:          " + this.getFloor() + "\n" +
				"Baujahr:        " + this.getYear() + "\n" +
				"PLZ:            " + this.getAdress()[0] + "\n" +
				"Strasse:        " + this.getAdress()[1] + "\n" +
				"Hausnummer:     " + this.getAdress()[2] + "\n" +
				"Top:            " + this.getAdress()[3] + "\n";
	}
	
	
	
}
