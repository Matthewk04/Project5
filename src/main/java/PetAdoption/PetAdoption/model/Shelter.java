package PetAdoption.PetAdoption.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * Generic class representing an animal shelter
 * @param <T> Type of pet the shelter contains
 */
public class Shelter<T extends Pet> {
	private List<T> pets = new ArrayList<>();
	
	public void addPet(T pet) {
		pets.add(pet);
	}
	public void removePet(T pet) {
		pets.remove(pet);
	}
	public void sort(Comparator<? super T> comparator) {
		pets.sort(comparator);
	}
	public List<T> getPets(){
		return new ArrayList<>(pets);
	}
	public T getPetByID(String id) {
		for (T pet:pets) {
			if(pet.getId().equals(id)) {
				return pet;
			}
		}
		return null;
	}
}
