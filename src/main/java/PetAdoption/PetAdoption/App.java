package PetAdoption.PetAdoption;

import java.util.List;

import PetAdoption.PetAdoption.model.Pet;
import PetAdoption.PetAdoption.model.Shelter;
import PetAdoption.PetAdoption.model.utils.PetLoader;
import PetAdoption.PetAdoption.model.utils.comparators.*;


public class App {
    public static void main(String[] args) {
        Shelter<Pet> shelter = new Shelter<>();
        
        PetLoader.loadPets("pets.json").forEach(shelter::addPet);
        PetLoader.loadPets("exotic_animals.json").forEach(shelter::addPet);
        
        /**
         * testing shelter contents
         */
        System.out.println("Shelter contains: " + shelter.getPets().size() + " pets");
     
        System.out.println("Pets in Shelter:");
        shelter.getPets().forEach(System.out::println);
        System.out.println();
        
        //check that name sorting works
        shelter.sort(new NameComparator());
        System.out.println("Pets sorted by name:");
        shelter.getPets().forEach(System.out::println);
        System.out.println();
        
        
        //check that age sorting works
        shelter.sort(new AgeComparator());
        System.out.println("Pets sorted by age:");
        shelter.getPets().forEach(System.out::println);
        
    }
}
