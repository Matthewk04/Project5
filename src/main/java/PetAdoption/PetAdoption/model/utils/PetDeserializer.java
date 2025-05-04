package PetAdoption.PetAdoption.model.utils;

import java.lang.reflect.Type;

import com.google.gson.*;

import PetAdoption.PetAdoption.model.Cat;
import PetAdoption.PetAdoption.model.Dog;
import PetAdoption.PetAdoption.model.ExoticAnimal;
import PetAdoption.PetAdoption.model.ExoticPetAdapter;
import PetAdoption.PetAdoption.model.Pet;
import PetAdoption.PetAdoption.model.Rabbit;

/**
 * Custom JSON deserializer  that handles both standard pets and exotic animals
 * https://medium.com/@alexandre.therrien3/personalized-serializer-and-deserializer-using-java-gson-library-c079de3974d4
 * implements special logic for converting JSON data to appropriate java objects
 */
public class PetDeserializer implements JsonDeserializer<Pet>{
	/**
	 * Converts JSON element to appropriate Pet subclass
	 * @throws JsonParseException if unknown pet type
	 */
	@Override
	public Pet deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		JsonObject jsonObject = json.getAsJsonObject();
		
		if(jsonObject.has("uniqueId")) {
			ExoticAnimal exotic = context.deserialize(json, ExoticAnimal.class);
			return new ExoticPetAdapter(exotic);
		}
		
		String type = jsonObject.get("type").getAsString();
		int id = jsonObject.get("id").getAsInt();
		String name = jsonObject.get("name").getAsString();
		String species = jsonObject.get("species").getAsString();
		int age = jsonObject.get("age").getAsInt();
		boolean adopted = jsonObject.get("adopted").getAsBoolean();
		
		switch(type) {
		case "Dog":
			return new Dog(String.valueOf(id), name, species, age, adopted);
		case "Cat":
			return new Cat(String.valueOf(id), name, species, age, adopted);
		case "Rabbit":
			return new Rabbit(String.valueOf(id), name, species, age, adopted);
		default:
			throw new JsonParseException("Unknown pet type: " + type);
		}
	}
}
