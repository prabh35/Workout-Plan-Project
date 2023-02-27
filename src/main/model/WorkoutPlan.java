package model;

import java.util.ArrayList;
import java.util.List;

public class WorkoutPlan {


    private List<Exercise> backWorkoutPlan;
    private List<Exercise> chestWorkoutPlan;
    private List<Exercise> legsWorkoutPlan;
    private List<Exercise> armsWorkoutPlan;



    public WorkoutPlan() {
        backWorkoutPlan = new ArrayList<>();
        chestWorkoutPlan = new ArrayList<>();
        armsWorkoutPlan = new ArrayList<>();
        legsWorkoutPlan = new ArrayList<>();
    }


    public void addBackWorkoutPlan(Exercise exercise) {
        if (exercise.getMuscleGroup().equals("Back")) {
            backWorkoutPlan.add(exercise);
        }
    }


    public void addChestWorkoutPlan(Exercise exercise) {
        if (exercise.getMuscleGroup().equals("Chest")) {
            chestWorkoutPlan.add(exercise);
        }
    }


    public void addArmsWorkoutPlan(Exercise exercise) {
        if (exercise.getMuscleGroup().equals("Arms")) {
            armsWorkoutPlan.add(exercise);
        }
    }

    public void addLegsWorkoutPlan(Exercise exercise) {
        if (exercise.getMuscleGroup().equals("Legs")) {
            legsWorkoutPlan.add(exercise);
        }
    }


    public void deleteBackWorkoutPlan(Exercise exercise) {
        backWorkoutPlan.remove(exercise);
    }


    public void deleteChestWorkoutPlan(Exercise exercise) {
        chestWorkoutPlan.remove(exercise);

    }


    public void deleteLegsWorkoutPlan(Exercise exercise) {
        legsWorkoutPlan.remove(exercise);

    }


    public void deleteArmsWorkoutPlan(Exercise exercise) {
        armsWorkoutPlan.remove(exercise);

    }



    public int chestWorkoutPlanSize() {
        return chestWorkoutPlan.size();
    }


    public int backWorkoutPlanSize() {
        return backWorkoutPlan.size();
    }


    public int armsWorkoutPlanSize() {
        return armsWorkoutPlan.size();
    }


    public int legsWorkoutPlanSize() {
        return legsWorkoutPlan.size();
    }


    public List<Exercise> getChestWorkoutPlan() {
        return chestWorkoutPlan;
    }


    public List<Exercise> getBackWorkoutPlan() {
        return backWorkoutPlan;
    }


    public List<Exercise> getLegsWorkoutPlan() {
        return legsWorkoutPlan;
    }

    public List<Exercise> getArmsWorkoutPlan() {
        return armsWorkoutPlan;
    }


    public boolean containChestExercise(String s) {
        for (Exercise e : chestWorkoutPlan) {
            if (e.getTitle().equals(s)) {

                return true;
            }
        }

        return false;
    }


    public boolean containBackExercise(String s) {
        for (Exercise e : backWorkoutPlan) {
            if (e.getTitle().equals(s)) {

                return true;
            }
        }
        return false;
    }


    public boolean containArmsExercise(String s) {
        for (Exercise e : armsWorkoutPlan) {
            if (e.getTitle().equals(s)) {
                return true;
            }
        }
        return false;
    }

    public boolean containLegsExercise(String s) {
        for (Exercise e : legsWorkoutPlan) {
            if (e.getTitle().equals(s)) {
                return true;
            }
        }
        return false;
    }
}
