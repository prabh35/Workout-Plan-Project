package persistence;

import model.Exercise;
import model.WorkoutPlan;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class JsonReader {
    // Represents a reader that reads workout plan from JSON data stored in file
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public WorkoutPlan read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseWorkoutPlan(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses workoutPlan from JSON object and returns it
    private WorkoutPlan parseWorkoutPlan(JSONObject jsonObject) {
        WorkoutPlan w = new WorkoutPlan();
        addExercises(w, jsonObject);
        return w;
    }

    // MODIFIES: w
    // EFFECTS: parses Exercise from JSON object and adds them to workoutPlan
    private void addExercises(WorkoutPlan w, JSONObject jsonObject) {
        JSONArray jsonArrayOne = jsonObject.getJSONArray("BackWorkoutPlan");
        JSONArray jsonArrayTwo = jsonObject.getJSONArray("ChestWorkoutPlan");
        JSONArray jsonArrayThree = jsonObject.getJSONArray("ArmsWorkoutPlan");
        JSONArray jsonArrayFour = jsonObject.getJSONArray("LegsWorkoutPlan");

        for (Object json : jsonArrayOne) {
            JSONObject nextExercise = (JSONObject) json;
            addBackMuscleExercise(w, nextExercise);
        }

        for (Object json : jsonArrayTwo) {
            JSONObject nextExercise = (JSONObject) json;
            addChestMuscleExercise(w, nextExercise);
        }

        for (Object json : jsonArrayThree) {
            JSONObject nextExercise = (JSONObject) json;
            addArmsMuscleExercise(w, nextExercise);
        }

        for (Object json : jsonArrayFour) {
            JSONObject nextExercise = (JSONObject) json;
            addLegsMuscleExercise(w, nextExercise);
        }

    }

    // MODIFIES: w
    // EFFECTS: parses exercise from JSON object and adds it to workoutPlan
    private void addBackMuscleExercise(WorkoutPlan w, JSONObject jsonObject) {
        String title = jsonObject.getString("title");
        String muscleGroup = jsonObject.getString("muscleGroup");
        int sets = jsonObject.getInt("sets");
        int repetitions = jsonObject.getInt("repetitions");

        Exercise e = new Exercise(title, muscleGroup, sets, repetitions);
        w.addBackWorkoutPlan(e);

    }

    // MODIFIES: w
    // EFFECTS: parses Exercise from JSON object and adds it to workoutPlan
    private void addChestMuscleExercise(WorkoutPlan w, JSONObject jsonObject) {
        String title = jsonObject.getString("title");
        String muscleGroup = jsonObject.getString("muscleGroup");
        int sets = jsonObject.getInt("sets");
        int repetitions = jsonObject.getInt("repetitions");

        Exercise e = new Exercise(title, muscleGroup, sets, repetitions);
        w.addChestWorkoutPlan(e);

    }

    // MODIFIES: w
    // EFFECTS: parses Exercise from JSON object and adds it to workoutPlan
    private void addArmsMuscleExercise(WorkoutPlan w, JSONObject jsonObject) {
        String title = jsonObject.getString("title");
        String muscleGroup = jsonObject.getString("muscleGroup");
        int sets = jsonObject.getInt("sets");
        int repetitions = jsonObject.getInt("repetitions");

        Exercise e = new Exercise(title, muscleGroup, sets, repetitions);
        w.addArmsWorkoutPlan(e);



    }

    // MODIFIES: w
    // EFFECTS: parses Exercise from JSON object and adds it to workoutPlan
    private void addLegsMuscleExercise(WorkoutPlan w, JSONObject jsonObject) {
        String title = jsonObject.getString("title");
        String muscleGroup = jsonObject.getString("muscleGroup");
        int sets = jsonObject.getInt("sets");
        int repetitions = jsonObject.getInt("repetitions");

        Exercise e = new Exercise(title, muscleGroup, sets, repetitions);
        w.addLegsWorkoutPlan(e);

    }

}
