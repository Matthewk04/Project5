package PetAdoption.PetAdoption.controller;

import PetAdoption.PetAdoption.model.Shelter;
import PetAdoption.PetAdoption.model.Pet;
import PetAdoption.PetAdoption.model.utils.comparators.AgeComparator;
import PetAdoption.PetAdoption.model.utils.comparators.NameComparator;
import PetAdoption.PetAdoption.model.utils.comparators.SpeciesComparator;
import PetAdoption.PetAdoption.view.PetView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;

public class PetController {
	private Shelter shelter;
	private PetView view;
	
	public PetController(Shelter shelter, PetView view) {
		this.shelter = shelter;
		this.view = view;
		initController();
	}
	
	private void initController() {
		view.getAdoptButton().addActionListener(e->adoptSelectedPet());
		view.getRemoveButton().addActionListener(e->removeSelectedPet());
		view.getSortBox().addActionListener(e->sortPets());
		view.getRefreshButton().addActionListener(e->refreshPetList());
		refreshPetList();
	}
	
	private void refreshPetList() {
		view.updatePetTable(shelter.getAllPets());
	}
	
	private void adoptSelectedPet() {
		
	}
	
	private void removeSelectedPet() {
		
	}
	
	private void sortPets() {
		
	}
}
