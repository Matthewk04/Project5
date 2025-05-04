package PetAdoption.PetAdoption.controller;

import PetAdoption.PetAdoption.model.Shelter;
import PetAdoption.PetAdoption.model.Pet;
import PetAdoption.PetAdoption.model.utils.PetSaver;
import PetAdoption.PetAdoption.model.utils.comparators.AgeComparator;
import PetAdoption.PetAdoption.model.utils.comparators.NameComparator;
import PetAdoption.PetAdoption.model.utils.comparators.SpeciesComparator;
import PetAdoption.PetAdoption.view.PetView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

public class PetController {
	private Shelter<Pet> shelter;
	private PetView view;
	
	public PetController(Shelter<Pet> shelter, PetView view) {
		this.shelter = shelter;
		this.view = view;
		initController();
	}
	
	private void initController() {
		view.getAdoptButton().addActionListener(e->adoptSelectedPet());
		view.getRemoveButton().addActionListener(e->removeSelectedPet());
		view.getSortBox().addActionListener(e->sortPets());
		view.getRefreshButton().addActionListener(e->refreshPetList());
		view.getSaveButton().addActionListener(e->savePets());
		refreshPetList();
	}
	
	private void savePets() {
		String timestamp = java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy_MM_dd HH_mm_ss"));
		String filename = timestamp + "_pets.json";
		
		try {
			PetSaver.savePets(shelter.getPets(), filename);
			JOptionPane.showMessageDialog(null, "Saved Successfully to:\n" + filename);
		} catch(IOException ex) {
			JOptionPane.showMessageDialog(null, "Save Failed" + ex.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void refreshPetList() {
		view.updatePetTable(shelter.getPets());
	}
	
	private void adoptSelectedPet() {
		String petId = view.getSelectedPetId();
	    if (petId != null) {
	        Pet selected = shelter.getPetByID(petId);
	        if (selected != null) {
	            if (!selected.isAdopted()) {
	                selected.setAdopted(true);
	                JOptionPane.showMessageDialog(null, selected.getName() + " has been adopted!");
	                refreshPetList();
	            } else {
	                JOptionPane.showMessageDialog(null, selected.getName() + " is already adopted.");
	            }
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Please select a pet to adopt.");
	    }
	}
	
	private void removeSelectedPet() {
		String petId = view.getSelectedPetId();
		if(petId != null) {
			Pet selected = shelter.getPetByID(petId);
			if (selected!=null) {
				shelter.removePet(selected);
				refreshPetList();
			}else {
				JOptionPane.showMessageDialog(null, "Please select a pet to remove");
			}
		}
	}
	
	private void sortPets() {
		String option = (String) view.getSortBox().getSelectedItem();
		Comparator<Pet> comparator = null;
		switch (option) {
			case "Name":
				comparator = new NameComparator();
				break;
			case "Age":
				comparator = new AgeComparator();
				break;
			case "Species":
				comparator = new SpeciesComparator();
				break;
		}
		if (comparator !=null) {
			shelter.sort(comparator);;
			refreshPetList();
		}
	}
}
