package PetAdoption.PetAdoption.model.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import PetAdoption.PetAdoption.model.Pet;

public class PetSaver {
	public static void savePets(List<Pet> pets, String filename) throws IOException {
		
		String resourcesDir = Paths.get("src", "main", "resources", "saved_pets").toString();
		new File(resourcesDir).mkdirs();
		
		String filePath = Paths.get(resourcesDir,filename).toString();
		
		Gson gson = new GsonBuilder().registerTypeHierarchyAdapter(Pet.class, new PetSerializer()).setPrettyPrinting().create();
		
		try(FileWriter writer = new FileWriter(filePath)){
			gson.toJson(pets, writer);
		}
	}

}
