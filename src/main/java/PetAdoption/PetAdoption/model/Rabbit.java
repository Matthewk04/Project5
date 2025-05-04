package PetAdoption.PetAdoption.model;

public class Rabbit extends Pet {
	public Rabbit(String id, String name, String species, int age, boolean adopted) {
		super(id, name, species, age, adopted);
	}
	
	@Override
	public String getType() {
		return "Rabbit";
	}
}
