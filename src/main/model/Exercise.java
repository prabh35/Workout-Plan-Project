package model;

import org.json.JSONObject;

public class Exercise {
    private String title;
    private String muscleGroup;
    private int repetitions;
    private int sets;

    //REQUIRES: sets > 0, repetitions > 0
    //EFFECTS: constructs an exercise with given title, targeted muscle group, number of sets and repetitions
    // to be done of the given exercise.
    public Exercise(String title, String muscleGroup, int sets, int repetitions) {
        this.title = title;
        this.muscleGroup = muscleGroup;
        this.sets = sets;
        this.repetitions = repetitions;
    }

    //EFFECTS: returns Exercises' title
    public String getTitle() {
        return this.title;
    }


    //EFFECTS: returns targeted muscle group
    public String getMuscleGroup() {
        return this.muscleGroup;
    }

    //EFFECTS: returns number of sets to be done for the given exercise
    public int getSets() {
        return this.sets;
    }

    //EFFECTS: returns the number of repetitions to be done for the given exercise
    public int getRepetitions() {
        return this.repetitions;
    }




    //EFFECTS: make the Json object
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("title", title);
        json.put("muscleGroup", muscleGroup);
        json.put("sets", sets);
        json.put("repetitions", repetitions);
        return json;
    }

}
