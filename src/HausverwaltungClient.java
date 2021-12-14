
public class HausverwaltungClient {

	public static void main(String[] args) {	
		try {
			Hausverwaltung hausverwaltung = new Hausverwaltung(args[0]);
			
			switch(args[1]) {
			case "list": 
			
				if(args.length < 3) hausverwaltung.list(); 
				else {hausverwaltung.list(Integer.parseInt(args[2]));}
				break;
				
			case "add": {
				String[] adress = {args[8],args[9],args[10],args[11]};
				
				if(args[2].equals("EW")) {
					
					EigentumsWohnung EW = new EigentumsWohnung(Integer.parseInt(args[3]),
						Double.parseDouble(args[4]),
						Integer.parseInt(args[5]),
						Integer.parseInt(args[6]),
						Integer.parseInt(args[7]),
						adress,
						Double.parseDouble(args[12]),
						Double.parseDouble(args[13]));
				
				hausverwaltung.add(EW); break;
				
				}
				if(args[2].equals("MW")) {
					
					MietWohnung MW = new MietWohnung(Integer.parseInt(args[3]),
						Double.parseDouble(args[4]),
						Integer.parseInt(args[5]),
						Integer.parseInt(args[6]),
						Integer.parseInt(args[7]),
						adress,
						Double.parseDouble(args[12]),
						Integer.parseInt(args[13]));
					
				hausverwaltung.add(MW); break;
				}
				
			}
			
			case "delete": 
				hausverwaltung.delete(Integer.parseInt(args[2])); break;
				
			case "count": 
				if(args.length < 3) System.out.println(hausverwaltung.count());
				else {System.out.println(hausverwaltung.countType(args[2]));} break;
				
			case "meancosts":
				System.out.println(hausverwaltung.meancost()); break;
				
			case "oldest": 
				for(int i : hausverwaltung.oldest()) {
					System.out.println("Id: " + i);
				}
				break;
				
			default: throw new IllegalArgumentException("Error: Parameter ungueltig.");
				
			}
		} catch (NumberFormatException e) {
			System.out.println("Error: Parameter ungueltig.");
			return;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Error: Parameter ungueltig.");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}