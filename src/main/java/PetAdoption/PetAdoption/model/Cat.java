package PetAdoption.PetAdoption.model;

public class Cat extends Pet {
	public Cat(String id, String name, String species, int age, boolean adopted) {
		super(id, name, species, age,adopted);
	}
	
	@Override
	public String getspecies() {
		return "Cat";
	}
}
