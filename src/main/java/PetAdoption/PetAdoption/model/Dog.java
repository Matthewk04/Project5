package PetAdoption.PetAdoption.model;

public class Dog extends Pet {
	public Dog(String id, String name, String species, int age, boolean adopted) {
		super(id, name, species, age, adopted);
	}
	
	@Override
	public String getType() {
		return "Dog";
	}
}
