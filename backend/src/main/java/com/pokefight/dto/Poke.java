package com.pokefight.dto;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pokefight.util.PokeType.Type;

public class Poke {
	
	    private int id;
	    private int power = 0;
	    private String name;
	    private String sprite;
	    private Type type;

	    public Poke(int id, String name, Type type, String sprite) {
			this.id = id;
			this.name = name;
			this.type = type;
			this.sprite = sprite;
		}
	    
	  
		public int getId() { return id; }
	    public String getName() { return name; }
	    public Type getType() { return type; }
	    public String getSprite() { return sprite; }
	  
	    
	    // Extract first type from JSON
	    @JsonProperty("types")
	    private void unpackTypes(List<Map<String, Object>> types) {
	        if (types != null && !types.isEmpty()) {
	            Map<String, Object> typeObj = (Map<String, Object>) types.get(0).get("type");
	            String typeName = ((String) typeObj.get("name")).toUpperCase();
	            this.type = Enum.valueOf(Type.class, typeName);
	        }
	    }

	    // Extract sprite image URL
	    @JsonProperty("sprites")
	    private void unpackSprites(Map<String, Object> sprites) {
	        this.sprite = (String) sprites.get("front_default");
	    }
		
		public void setPower(int power) {
			this.power = power;
		}
}
