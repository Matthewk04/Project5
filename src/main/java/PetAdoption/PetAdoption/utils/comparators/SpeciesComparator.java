package PetAdoption.PetAdoption.utils.comparators;

import java.util.Comparator;

import PetAdoption.PetAdoption.model.Pet;

public class SpeciesComparator implements Comparator<Pet> {
	
	@Override
	public int compare(Pet p1, Pet p2) {
		return p1.getSpecies().compareToIgnoreCase(p2.getSpecies());
	}
}
