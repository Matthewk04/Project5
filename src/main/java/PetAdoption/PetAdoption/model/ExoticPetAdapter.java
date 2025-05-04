package PetAdoption.PetAdoption.model;

public class ExoticPetAdapter extends Pet {
	private final ExoticAnimal exotic;
	
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
