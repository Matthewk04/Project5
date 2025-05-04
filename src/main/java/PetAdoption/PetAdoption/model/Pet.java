package PetAdoption.PetAdoption.model;

/**
 * Abstract class for pets in the shelter
 * 
 * Variables:
 * id - pet's id
 * name - pet's name
 * species - pet's species(dog, cat, rabbit)
 * age - pet's age
 * adopted - if pet was adopted
 * 
 */
public abstract class Pet {
	protected String id;
	protected String name;
	protected String species;
	protected int age;
	protected boolean adopted;
	
	public Pet(String id, String name, String species, int age, boolean adopted) {
		this.id = id;
		this.name = name;
		this.species = species;
		this.age = age;
		this.adopted = adopted;
	}
	
	public abstract String getspecies();

	
	
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public void setSpecies(String species) { this.species = species; }
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
	public boolean isAdopted() { return adopted; }
	public void setAdopted(boolean adopted) { this.adopted = adopted; }
	
}
