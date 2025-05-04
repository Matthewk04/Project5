package PetAdoption.PetAdoption.comparators;

import java.util.Comparator;

import PetAdoption.PetAdoption.model.Pet;

public class AgeComparator implements Comparator<Pet>{
	
	@Override
	public int compare(Pet p1, Pet p2) {
		return Integer.compare(p1.getAge(), p2.getAge());
	}
}
