package PetAdoption.PetAdoption.utils;

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

public class PetLoader {
	public static List<Pet> loadPets(String resourcePath){
		try(InputStream inputStream = PetLoader.class.getClassLoader().getResourceAsStream(resourcePath)){
			if(inputStream == null) {
				System.err.println("File not found in classpath: " + resourcePath);
				return new ArrayList<>();
			}
			Reader reader = new InputStreamReader(inputStream);
			Gson gson = new GsonBuilder().registerTypeAdapter(Pet.class, new PetDeserializer()).create();
			List<Pet> result = gson.fromJson(reader, new TypeToken<List<Pet>>() {}.getType());
			System.out.println("loaded " + result.size() + " pets");
			return result;
		} catch (Exception e) {
			System.err.println("Error in loading pets:");
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
}
