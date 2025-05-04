package PetAdoption.PetAdoption.model.utils;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import PetAdoption.PetAdoption.model.ExoticPetAdapter;
import PetAdoption.PetAdoption.model.Pet;

public class PetSerializer implements JsonSerializer<Pet> {
	@Override
	public JsonElement serialize(Pet src, Type typeOfSrc, JsonSerializationContext context) {
		if(src instanceof ExoticPetAdapter) {
			return serializeExoticPet((ExoticPetAdapter) src);
		}
		return serializeRegularPet(src);
	}
	
	private JsonElement serializeRegularPet(Pet pet) {
		JsonObject obj = new JsonObject();
		obj.addProperty("id", pet.getId());
		obj.addProperty("name", pet.getName());
		obj.addProperty("type", pet.getType());
		obj.addProperty("species", pet.getSpecies());
		obj.addProperty("age", pet.getAge());
		obj.addProperty("adopted", pet.isAdopted());
		return obj;
	}
	
	private JsonElement serializeExoticPet(ExoticPetAdapter pet) {
		JsonObject obj = new JsonObject();
		obj.addProperty("uniqueId", pet.getId());
        obj.addProperty("animalName", pet.getName());
        obj.addProperty("category", pet.getType());
        obj.addProperty("subSpecies", pet.getSpecies());
        obj.addProperty("yearsOld", pet.getAge());
        obj.addProperty("adopted", pet.isAdopted());
        return obj;
	}
}
