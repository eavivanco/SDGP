package models;

import org.json.simple.JSONObject;

public class Pokemon {
    public Object id;
    public Object name;
    public Object height;
    public Object weight;
    public Object description;

    // getters
    public Object getId () {
        return id;
    }
    public Object getName () {
        return name;
    }
    public Object getHeight () {
        return height;
    }
    public Object getWeight () {
        return weight;
    }
    public Object getDescription () {
        return description;
    }

    // setters
    public void setId ( Object newId) {
        this.id = newId;
    }
    public void setName ( Object newName) {
        this.name = newName;
    }
    public void setHeight ( Object newHeight) {
        this.height = newHeight;
    }
    public void setWeight ( Object newWeight) {
        this.weight = newWeight;
    }
    public void setDescription ( Object newDescription) {
        this.description = newDescription;
    }
}
