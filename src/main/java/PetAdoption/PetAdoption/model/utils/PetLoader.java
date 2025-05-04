package PetAdoption.PetAdoption.model.utils;

import java.io.IOException;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.Reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import PetAdoption.PetAdoption.model.Pet;

/**
 * Utility class for loading pets from JSON files
 */

public class PetLoader {
	/**
	 * Loads pets from a JSON resource file
	 * @param resourcePath Path to JSON file
	 * @return List of parsed Pet objects
	 */
	public static List<Pet> loadPets(String resourcePath){
		try(InputStream inputStream = PetLoader.class.getClassLoader().getResourceAsStream(resourcePath)){
			if(inputStream == null) {
				System.err.println("File not found in classpath: " + resourcePath);
				return new ArrayList<>();
			}
			Reader reader = new InputStreamReader(inputStream);
			Gson gson = new GsonBuilder().registerTypeAdapter(Pet.class, new PetDeserializer()).create();
			List<Pet> result = gson.fromJson(reader, new TypeToken<List<Pet>>() {}.getType());
			return result;
		} catch (Exception e) {
			System.err.println("Error in loading pets:");
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
}
