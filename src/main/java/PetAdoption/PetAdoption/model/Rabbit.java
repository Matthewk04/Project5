package PetAdoption.PetAdoption.model;

/**
 * Concrete class for a Rabbit pet
 * Inherits common properties from Pet class
 */

public class Rabbit extends Pet {
	/**
	 * Creates a new Rabbit object
	 * @param id			Pet's id
	 * @param name			Pet's name
	 * @param species		Pet's species
	 * @param age			Pet's age
	 * @param adopted		Pet's adoption status
	 */
	public Rabbit(String id, String name, String species, int age, boolean adopted) {
		super(id, name, species, age, adopted);
	}
	
	@Override
	public String getType() {
		return "Rabbit";
	}
}
