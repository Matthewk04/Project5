package PetAdoption.PetAdoption.utils;

import java.lang.reflect.Type;

import com.google.gson.*;

import PetAdoption.PetAdoption.model.Cat;
import PetAdoption.PetAdoption.model.Dog;
import PetAdoption.PetAdoption.model.Pet;
import PetAdoption.PetAdoption.model.Rabbit;

public class PetDeserializer implements JsonDeserializer<Pet>{
	@Override
	public Pet deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		JsonObject jsonObject = json.getAsJsonObject();
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
