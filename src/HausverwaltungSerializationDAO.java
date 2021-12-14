
/**
 * @author Jin-Jin Lee
 * @id 11913405
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class HausverwaltungSerializationDAO implements HausverwaltungDAO {
	private String filename;
	private File file;
	private List<Wohnung> savedWohnungen;

	public HausverwaltungSerializationDAO(String filename) {
		this.filename = filename;
		this.file = new File(filename);
		this.savedWohnungen = new ArrayList<Wohnung>();
		if (this.file.exists()) {
			this.savedWohnungen = this.getWohnungen();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Wohnung> getWohnungen() {
		List<Wohnung> ret = new ArrayList<Wohnung>();
		try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
			ret = (List<Wohnung>) objectInputStream.readObject();
		} catch (Exception e) {
			System.out.println("Fehler bei Deserialisierung: " + e.getMessage());
			System.exit(1);
		}
		return ret;
	}

	@Override
	public Wohnung getWohnungbyId(int id) {
		Wohnung wohnung = null;
		for (Wohnung o : this.getWohnungen()) {
			if (o.getId() == id) {
				wohnung = o;
			}
		}
		return wohnung;
		
	}

	@Override
	public void saveWohnung(Wohnung wohnung) {
		for (Wohnung w : savedWohnungen) {
			if (w.getId() == wohnung.getId()) {
				throw new IllegalArgumentException("Error: Wohnung bereits vorhanden. (id=" + wohnung.getId() + ")");
			}
		}
		savedWohnungen.add(wohnung);
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
			objectOutputStream.writeObject(savedWohnungen);
			objectOutputStream.flush();
		} catch (Exception e) {
			System.out.println("Fehler bei Serialisierung: " + e.getMessage());
			System.exit(1);
		}
	}

	@Override
	public void deleteWohnung(int id) {
		for (Wohnung wohnung : savedWohnungen) {
			if (wohnung.getId() == id) {
				savedWohnungen.remove(wohnung);
				file.delete();
				try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
					objectOutputStream.writeObject(savedWohnungen);
					objectOutputStream.flush();
				} catch (Exception e) {
					System.out.println("Fehler bei Serialisierung: " + e.getMessage());
					System.exit(1);
				}
				return;
			}
		}
		throw new IllegalArgumentException("Error: Wohnung nicht vorhanden. (id=" + id + ")");
	}

}