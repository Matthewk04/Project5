package PetAdoption.PetAdoption.model;

/**
 * Adapter class to make ExoticAnimal compatible with the Pet class
 */
public class ExoticPetAdapter extends Pet {
	private final ExoticAnimal exotic;

	/**
	 * Constructs an adapter for exotic animals
	 * @param exotic the exotic animal to adapt
	 */
	public ExoticPetAdapter(ExoticAnimal exotic) {
		super(exotic.getUniqueId(), exotic.getAnimalName(), exotic.getSubSpecies(), exotic.getYearsOld(), false);
		this.exotic = exotic;
	}

	/**
	 * Constructor for rebuilding exotic pets from table data
	 * @param id        pet's unique id
	 * @param name      pet's name
	 * @param species   exotic species (sub-species)
	 * @param age       pet's age
	 * @param adopted   adoption status
	 */
	public ExoticPetAdapter(String id, String name, String species, int age, boolean adopted) {
		super(id, name, species, age, adopted);
		this.exotic = new ExoticAnimal();
	}

	@Override
	public String getType() {
		return exotic.getCategory();
	}

	@Override
	public void setAdopted(boolean adopted) {
		super.setAdopted(adopted);
	}
}
