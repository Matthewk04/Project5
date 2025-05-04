package PetAdoption.PetAdoption;

import java.util.List;

import javax.swing.SwingUtilities;

import PetAdoption.PetAdoption.controller.PetController;
import PetAdoption.PetAdoption.model.Pet;
import PetAdoption.PetAdoption.model.Shelter;
import PetAdoption.PetAdoption.model.utils.PetLoader;
import PetAdoption.PetAdoption.model.utils.comparators.*;
import PetAdoption.PetAdoption.view.PetView;


public class App {
    public static void main(String[] args) {
        Shelter<Pet> shelter = new Shelter<>();
        
        PetLoader.loadPets("pets.json").forEach(shelter::addPet);
        PetLoader.loadPets("exotic_animals.json").forEach(shelter::addPet);
        
        SwingUtilities.invokeLater(() -> {
        	PetView view = new PetView();
        	new PetController(shelter,view);
        	view.setVisible(true);
        });
        
    }
}
