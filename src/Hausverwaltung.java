import java.util.ArrayList;
import java.util.List;

public class Hausverwaltung {
	private HausverwaltungDAO hausverwaltungDAO;
	
	
	
	public Hausverwaltung(String filename) {
		this.hausverwaltungDAO = new HausverwaltungSerializationDAO(filename);
	}
	
	public void list() {
		for(Wohnung o : hausverwaltungDAO.getWohnungen()) {
			System.out.println(o);
		}
	}
	
	public void list(int id) {
		if(hausverwaltungDAO.getWohnungbyId(id) != null) {
		System.out.println(hausverwaltungDAO.getWohnungbyId(id));
		}
	}

	public void add(Wohnung w) {
		hausverwaltungDAO.saveWohnung(w);
		System.out.println("Info: Wohnung " + w.getId() + " added.");
	}
	
	public void delete(int id) {
		hausverwaltungDAO.deleteWohnung(id);
		System.out.println("Info: Wohnung " + id + " deleted.");
	}
	
	public int count() {
		return hausverwaltungDAO.getWohnungen().size();
	}
	
	public int countType(String s) {
		int count = 0;
		if(s.equals("EW")) {
			for(Wohnung o : hausverwaltungDAO.getWohnungen()) {
				if (o instanceof EigentumsWohnung) count++;
			}
			return count;
		}
		
		if(s.equals("MW")) {
			for(Wohnung o : hausverwaltungDAO.getWohnungen()) {
				if(o instanceof MietWohnung) count++;
			}
			return count;
		}
		
		return count;
	}
	
	
	public double meancost() {
		double ret = 0;
		double count = 0;
		for(Wohnung w : hausverwaltungDAO.getWohnungen()) {
			ret+= w.gesamtKosten();
			count++;
		}
		if(count==0) return 0;
		else return ret/count;
	}
	
	public List<Integer> oldest(){
		ArrayList<Integer> ret = new ArrayList<Integer>();
		int max = 0;
		for(Wohnung v : hausverwaltungDAO.getWohnungen()) {
			if(v.alter() > max) max = v.alter(); 
		}
		for(Wohnung v : hausverwaltungDAO.getWohnungen()) {
			if(v.alter() == max) if(ret.contains(v.getId())) continue; else ret.add(v.getId());
		}
		
		return ret;
	}
	
	
}