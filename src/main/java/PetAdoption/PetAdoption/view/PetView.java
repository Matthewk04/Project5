package PetAdoption.PetAdoption.view;

import PetAdoption.PetAdoption.model.Cat;
import PetAdoption.PetAdoption.model.Dog;
import PetAdoption.PetAdoption.model.ExoticPetAdapter;
import PetAdoption.PetAdoption.model.Pet;
import PetAdoption.PetAdoption.model.Rabbit;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PetView extends JFrame {
	private JTable petTable;
	private DefaultTableModel tableModel;
	private JButton adoptButton;
	private JButton removeButton;
	private JButton refreshButton;
	private JComboBox<String> sortBox;
	
	public PetView() {
		setTitle("Pet Adoption Center");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        tableModel = new DefaultTableModel(new Object[]{"Name", "Species", "Age", "Adopted"}, 0);
        petTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(petTable);
        add(scrollPane, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        adoptButton = new JButton("Adopt");
        removeButton = new JButton("Remove");
        refreshButton = new JButton("Refresh");
        sortBox = new JComboBox<>(new String[]{"Name", "Age", "Species"});
        buttonPanel.add(new JLabel("Sort by:"));
        buttonPanel.add(sortBox);
        buttonPanel.add(adoptButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(refreshButton);
        add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);

	}

	public JButton getAdoptButton() {
		return adoptButton;
	}
	
	public JButton getRemoveButton() {
		return removeButton;
	}
	
	public JButton getRefreshButton() {
		return refreshButton;
	}
	
	public JComboBox<String> getSortBox(){
		return sortBox;
	}
	
	public Pet getSelectedPet() {
		int row = petTable.getSelectedRow();
		if (row >= 0) {
			String id = tableModel.getValueAt(row, 0).toString();
			String name = tableModel.getValueAt(row, 1).toString();
			String species = tableModel.getValueAt(row, 2).toString();
			int age = Integer.parseInt(tableModel.getValueAt(row, 3).toString());
			boolean adopted = Boolean.parseBoolean(tableModel.getValueAt(row, 4).toString());

			switch (species.toLowerCase()) {
				case "dog":
					return new Dog(id, name, species, age, adopted);
				case "cat":
					return new Cat(id, name, species, age, adopted);
				case "rabbit":
					return new Rabbit(id, name, species, age, adopted);
				case "exotic":
				case "exoticanimal":
					return new ExoticPetAdapter(id, name, species, age, adopted);
				default:
					System.err.println("Unknown species: " + species);
			}
		}
		return null;
	}
	
	public void updatePetTable(List<Pet> pets) {
		tableModel.setRowCount(0);
		for(Pet pet:pets) {
			tableModel.addRow(new Object[] {
					pet.getName(),
					pet.getSpecies(),
					pet.getAge(),
					pet.isAdopted()
					});
			}
		}
	}
