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
		Pet selected = view.getSelectedPet();
		if (selected != null) {
			if (!selected.isAdopted()) {
				selected.setAdopted(true);
				JOptionPane.showMessageDialog(null, selected.getName() +" has been adopted!");
				refreshPetList();
			} else {
				JOptionPane.showMessageDialog(null, selected.getName()+" is already adopted.");
			}
		}else {
			JOptionPane.showMessageDialog(null,"Please select a pet to adopt.");
		}
	}
	
	private void removeSelectedPet() {
		Pet selected = view.getSelectedPet();
		if (selected!=null) {
			shelter.removePet(selected);
		}else {
			JOptionPane.showMessageDialog(null, "Please select a pet to remove");
		}
	}
	
	private void sortPets() {
		
	}
}
