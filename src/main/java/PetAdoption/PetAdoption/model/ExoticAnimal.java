package PetAdoption.PetAdoption.model;

import com.google.gson.annotations.SerializedName;

/**
 * Exotic animals with different field names than standard pets
 * used with GSON annotations for JSON parsing
 */
public class ExoticAnimal {
	@SerializedName("uniqueId")
	private String uniqueId;
	
	@SerializedName("animalName")
	private String animalName;
	
	@SerializedName("category")
	private String category;
	
	@SerializedName("subSpecies")
	private String subSpecies;
	
	@SerializedName("yearsOld")
	private int yearsOld;
	
	
	//Getters and Setters
	public String getUniqueId() { return uniqueId; }
	public void setUniqueId(String uniqueId) { this.uniqueId = uniqueId; }
	public String getAnimalName() { return animalName; }
	public void setAnimalName(String animalName) { this.animalName = animalName; }
	public String getCategory() { return category; }
	public void setCategory(String category) { this.category = category; }
	public String getSubSpecies() { return subSpecies; }
	public void setSubSpecies(String subSpecies) { this.subSpecies = subSpecies; }
	public int getYearsOld() { return yearsOld; }
	public void setYearsOld(int yearsOld) { this.yearsOld = yearsOld; }
	
}
