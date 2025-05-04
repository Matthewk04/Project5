package PetAdoption.PetAdoption.model;

/**
 * Concrete class for a Cat pet
 * Inherits common properties from Pet class
 */

public class Cat extends Pet {
	/**
	 * Creates a new Cat object
	 * @param id			Pet's id
	 * @param name			Pet's name
	 * @param species		Pet's species
	 * @param age			Pet's age
	 * @param adopted		Pet's adoption status
	 */
	public Cat(String id, String name, String species, int age, boolean adopted) {
		super(id, name, species, age, adopted);
	}
	
	@Override
	public String getType() {
		return "Cat";
	}
}
