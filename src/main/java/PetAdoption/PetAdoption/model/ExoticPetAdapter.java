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
	
	@Override
	public String getType() {
		return exotic.getCategory();
	}
	
	@Override
	public void setAdopted(boolean adopted) {
		super.setAdopted(adopted);
	}
}
