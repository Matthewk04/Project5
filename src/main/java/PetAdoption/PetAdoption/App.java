package PetAdoption.PetAdoption;

import java.util.List;

import PetAdoption.PetAdoption.model.Pet;
import PetAdoption.PetAdoption.model.Shelter;
import PetAdoption.PetAdoption.utils.PetLoader;


public class App {
    public static void main(String[] args) {
        Shelter<Pet> shelter = new Shelter<>();
        
        PetLoader.loadPets("pets.json").forEach(shelter::addPet);
        
        /**
         * testing shelter contents
         */
        System.out.println("Shelter contains: " + shelter.getPets().size() + " pets");
     
        
        System.out.println("Pets in Shelter:");
        shelter.getPets().forEach(System.out::println);
    }
}
