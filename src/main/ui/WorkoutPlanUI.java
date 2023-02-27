package ui;

import model.Exercise;
import model.WorkoutPlan;

import java.util.Scanner;

public class WorkoutPlanUI {
    private WorkoutPlan workoutPlan;
    private Scanner input;

    //EFFECTS: run the tracker application
    public WorkoutPlanUI() {
        workoutPlan = new WorkoutPlan();
        input = new Scanner(System.in);
        start();
        startTracker();
    }


    //EFFECTS : prints out the starting statement
    private void start() {
        System.out.println(" Welcome! Here's your workout plan");
    }

    private void startTracker() {
        displayMenu();
        input = new Scanner(System.in);
        String command = input.nextLine();
        processCommand(command);


    }

    //MODIFIES: this
    //EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("c")) {
            addChestWorkoutPlan();
        } else if (command.equals("dc")) {
            deleteChestWorkoutPlan();
        } else if (command.equals("vc")) {
            viewChestWorkoutPlan();
        } else if (command.equals("b")) {
            addBackWorkoutPlan();
        } else if (command.equals("db")) {
            deleteBackWorkoutPlan();
        } else if (command.equals("vb")) {
            viewBackWorkoutPlan();
        } else {
            continuedProcessCommand(command);
        }
    }

    //EFFECTS: processes command for the user
    public void continuedProcessCommand(String command) {
        if (command.equals("a")) {
            addArmsWorkoutPlan();
        } else if (command.equals("da")) {
            deleteArmsWorkoutPlan();
        } else if (command.equals("va")) {
            viewArmsWorkoutPlan();
        } else if (command.equals("l")) {
            addLegsWorkoutPlan();
        } else if (command.equals("vd")) {
            deleteLegsWorkoutPlan();
        } else if (command.equals("vl")) {
            viewLegsWorkoutPlan();
        } else {
            System.out.println("Invalid Selection....");
            startTracker();
        }
    }

    //EFFECTS : displays menu options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tc -> Chest Workout");
        System.out.println("\tb -> Back Workout");
        System.out.println("\ta -> Arms Workout");
        System.out.println("\tl -> Legs Workout");
        System.out.println("\tdc -> Delete Chest Workout");
        System.out.println("\tdb -> Delete Back Workout");
        System.out.println("\tdl -> Delete Legs Workout");
        System.out.println("\tda -> Delete Arms Workout");
        System.out.println("\tvc -> View Chest Workout");
        System.out.println("\tvb -> View Back Workout");
        System.out.println("\tvl -> View Legs Workout");
        System.out.println("\tva -> View Arms Workout");
        System.out.println("\te -> Exit");
    }

    // MODIFIES: this
    private void addChestWorkoutPlan() {

        String title;
        System.out.println("Title :");
        title = input.nextLine();

        String muscleGroup;
        System.out.println("MuscleGroup :");
        muscleGroup = input.nextLine();

        int sets;
        System.out.println("Sets :");
        sets = input.nextInt();

        int repetitions;
        System.out.println("Repetitions :");
        repetitions = input.nextInt();

        Exercise exercise = new Exercise(title, muscleGroup, sets, repetitions);
        workoutPlan.addChestWorkoutPlan(exercise);

        startTracker();

    }

    // MODIFIES: this
    private void addBackWorkoutPlan() {

        String title;
        System.out.println("Title :");
        title = input.nextLine();

        String muscleGroup;
        System.out.println("MuscleGroup :");
        muscleGroup = input.nextLine();

        int sets;
        System.out.println("Sets :");
        sets = input.nextInt();

        int repetitions;
        System.out.println("Repetitions :");
        repetitions = input.nextInt();

        Exercise exercise = new Exercise(title, muscleGroup, sets, repetitions);
        workoutPlan.addBackWorkoutPlan(exercise);

        startTracker();

    }

    // MODIFIES: this
    private void addArmsWorkoutPlan() {

        String title;
        System.out.println("Title :");
        title = input.nextLine();

        String muscleGroup;
        System.out.println("MuscleGroup :");
        muscleGroup = input.nextLine();

        int sets;
        System.out.println("Sets :");
        sets = input.nextInt();

        int repetitions;
        System.out.println("Repetitions :");
        repetitions = input.nextInt();

        Exercise exercise = new Exercise(title, muscleGroup, sets, repetitions);
        workoutPlan.addArmsWorkoutPlan(exercise);

        startTracker();

    }

    // MODIFIES: this
    private void addLegsWorkoutPlan() {

        String title;
        System.out.println("Title :");
        title = input.nextLine();

        String muscleGroup;
        System.out.println("MuscleGroup :");
        muscleGroup = input.nextLine();

        int sets;
        System.out.println("Sets :");
        sets = input.nextInt();

        int repetitions;
        System.out.println("Repetitions :");
        repetitions = input.nextInt();

        Exercise exercise = new Exercise(title, muscleGroup, sets, repetitions);
        workoutPlan.addLegsWorkoutPlan(exercise);

        startTracker();

    }


    // MODIFIES: this
    private void deleteChestWorkoutPlan() {

        String title;
        System.out.println(" Title: ");
        title = input.nextLine();
        boolean contains = false;

        Exercise toRemove = new Exercise("title", "muscle group", 1, 1);
        for (Exercise exercise : workoutPlan.getChestWorkoutPlan()) {
            if (exercise.getTitle().equals(title)) {
                contains = true;
                toRemove = exercise;
            }
        }
        if (!contains) {
            System.out.println("Error: List doesn't contain the given exercise");
        } else {

            workoutPlan.deleteChestWorkoutPlan(toRemove);
        }
        startTracker();

    }
    //MODIFIES: this

    private void deleteBackWorkoutPlan() {

        String title;
        System.out.println(" Title: ");
        title = input.nextLine();

        boolean contains = false;

        Exercise toRemove = new Exercise("title", "muscle group", 1, 1);
        for (Exercise exercise : workoutPlan.getArmsWorkoutPlan()) {
            if (exercise.getTitle().equals(title)) {
                contains = true;
                toRemove = exercise;
            }
        }

        if (!contains) {
            System.out.println("Error: List doesn't contain the given exercise");
        } else {

            workoutPlan.deleteBackWorkoutPlan(toRemove);
        }

        startTracker();

    }

    //MODIFIES: This
    private void deleteArmsWorkoutPlan() {

        String title;
        System.out.println(" Title: ");
        title = input.nextLine();

        boolean contains = false;

        Exercise toRemove = new Exercise("title", "muscle group", 1, 1);
        for (Exercise exercise : workoutPlan.getArmsWorkoutPlan()) {
            if (exercise.getTitle().equals(title)) {
                contains = true;
                toRemove = exercise;
            }
        }

        if (!contains) {
            System.out.println("Error: List doesn't contain the given exercise");
        } else {

            workoutPlan.deleteArmsWorkoutPlan(toRemove);
        }

        startTracker();

    }


    //MODIFIES: This
    private void deleteLegsWorkoutPlan() {

        String title;
        System.out.println(" Title: ");
        title = input.nextLine();

        boolean contains = false;

        Exercise toRemove = new Exercise("title", "muscle group", 1, 1);
        for (Exercise exercise : workoutPlan.getLegsWorkoutPlan()) {
            if (exercise.getTitle().equals(title)) {
                contains = true;
                toRemove = exercise;
            }

        }

        if (!contains) {
            System.out.println("Error: List doesn't contain the given exercise");
        } else {

            workoutPlan.deleteLegsWorkoutPlan(toRemove);
        }

        startTracker();

    }

    //MODIFIES: This
    private void viewChestWorkoutPlan() {
        if (!workoutPlan.getChestWorkoutPlan().isEmpty()) {

            for (Exercise exercise : workoutPlan.getChestWorkoutPlan()) {
                System.out.println(" Title : " + exercise.getTitle() + " Targeted Muscle Group : "
                        + exercise.getMuscleGroup() + " Sets : " + exercise.getSets() + " Repetitions :"
                        + exercise.getRepetitions());
            }

        } else {
            System.out.println("Empty Chest Workout Plan");
        }

        startTracker();
    }

    //MODIFIES: This
    private void viewBackWorkoutPlan() {
        if (!workoutPlan.getBackWorkoutPlan().isEmpty()) {

            for (Exercise exercise : workoutPlan.getBackWorkoutPlan()) {
                System.out.println(" Title : " + exercise.getTitle() + " Targeted Muscle Group : "
                        + exercise.getMuscleGroup() + " Sets : " + exercise.getSets() + " Repetitions :"
                        + exercise.getRepetitions());
            }

        } else {
            System.out.println("Empty Back Workout Plan");
        }

        startTracker();
    }

    //MODIFIES: This
    private void viewLegsWorkoutPlan() {
        if (!workoutPlan.getLegsWorkoutPlan().isEmpty()) {

            for (Exercise exercise : workoutPlan.getLegsWorkoutPlan()) {
                System.out.println(" Title : " + exercise.getTitle() + " Targeted Muscle Group : "
                        + exercise.getMuscleGroup() + " Sets : " + exercise.getSets() + " Repetitions :"
                        + exercise.getRepetitions());
            }

        } else {
            System.out.println("Empty Legs Workout Plan");
        }

        startTracker();
    }


    //MODIFIES: This
    private void viewArmsWorkoutPlan() {
        if (!workoutPlan.getArmsWorkoutPlan().isEmpty()) {

            for (Exercise exercise : workoutPlan.getArmsWorkoutPlan()) {
                System.out.println(" Title : " + exercise.getTitle() + " Targeted Muscle Group : "
                        + exercise.getMuscleGroup()
                        + " Sets : " + exercise.getSets() + " Repetitions :" + exercise.getRepetitions());
            }

        } else {
            System.out.println("Empty Arms Workout Plan");
        }

        startTracker();
    }


}
