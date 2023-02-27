package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WorkoutPlanTest {
    private WorkoutPlan workoutPlan;
    private Exercise exercise1;
    private Exercise exercise2;
    private Exercise exercise3;
    private Exercise exercise4;
    private Exercise exercise5;
    private Exercise exercise6;
    private Exercise exercise7;


    @BeforeEach

    public void runBefore() {

        workoutPlan = new WorkoutPlan();
        exercise1 = new Exercise("Bench Press", "Chest", 3, 15);
        exercise2 = new Exercise("Dead lift", "Back", 4, 10);
        exercise3 = new Exercise("Hammer Curl", "Arms", 3, 13);
        exercise4 = new Exercise("Lats Pull Down", "Back", 4, 13);
        exercise5 = new Exercise("Dips", "Arms", 3, 10);
        exercise6 = new Exercise("Leg Press", "Legs", 5, 8);
        exercise7 = new Exercise("Leg Extension", "Legs", 3, 12);

    }

    @Test
    public void testAddBackWorkoutPlan() {

        workoutPlan.addBackWorkoutPlan(exercise2);
        assertEquals(1, workoutPlan.backWorkoutPlanSize());
        workoutPlan.addBackWorkoutPlan(exercise4);
        assertEquals(2, workoutPlan.backWorkoutPlanSize());

    }

    @Test
    public void testAddChestWorkoutPlan() {

        workoutPlan.addChestWorkoutPlan(exercise1);
        assertEquals(1, workoutPlan.chestWorkoutPlanSize());
        workoutPlan.addChestWorkoutPlan(exercise1);
        assertEquals(2, workoutPlan.chestWorkoutPlanSize());

    }

    @Test
    public void testAddLegsWorkoutPlan() {

        workoutPlan.addLegsWorkoutPlan(exercise6);
        assertEquals(1, workoutPlan.legsWorkoutPlanSize());
        workoutPlan.addLegsWorkoutPlan(exercise7);
        assertEquals(2, workoutPlan.legsWorkoutPlanSize());
        workoutPlan.addLegsWorkoutPlan(exercise3);
        assertEquals(2, workoutPlan.legsWorkoutPlanSize());

    }

    @Test
    public void testAddArmsWorkoutPlan() {

        workoutPlan.addArmsWorkoutPlan(exercise3);
        assertEquals(1, workoutPlan.armsWorkoutPlanSize());
        workoutPlan.addArmsWorkoutPlan(exercise5);
        assertEquals(2, workoutPlan.armsWorkoutPlanSize());
        workoutPlan.addArmsWorkoutPlan(exercise7);
        assertEquals(2, workoutPlan.armsWorkoutPlanSize());

    }

    @Test
    public void testDeleteArmsWorkoutPlan() {

        assertEquals(0, workoutPlan.armsWorkoutPlanSize());
        workoutPlan.addArmsWorkoutPlan(exercise3);
        assertEquals(1, workoutPlan.armsWorkoutPlanSize());
        workoutPlan.addArmsWorkoutPlan(exercise5);
        assertEquals(2, workoutPlan.armsWorkoutPlanSize());
        workoutPlan.deleteArmsWorkoutPlan(exercise5);
        assertEquals(1, workoutPlan.armsWorkoutPlanSize());

    }


    @Test
    public void testDeleteBackWorkoutPlan() {

        workoutPlan.addBackWorkoutPlan(exercise2);
        assertEquals(1, workoutPlan.backWorkoutPlanSize());
        workoutPlan.addBackWorkoutPlan(exercise4);
        assertEquals(2, workoutPlan.backWorkoutPlanSize());
        workoutPlan.deleteBackWorkoutPlan(exercise4);
        assertEquals(1, workoutPlan.backWorkoutPlanSize());

    }

    @Test
    public void testDeleteChestWorkoutPlan() {

        workoutPlan.addChestWorkoutPlan(exercise1);
        assertEquals(1, workoutPlan.chestWorkoutPlanSize());
        workoutPlan.deleteChestWorkoutPlan(exercise1);
        assertEquals(0, workoutPlan.chestWorkoutPlanSize());

    }

    @Test
    public void testDeleteLegsWorkoutPlan() {

        assertEquals(0, workoutPlan.legsWorkoutPlanSize());
        workoutPlan.addLegsWorkoutPlan(exercise6);
        assertEquals(1, workoutPlan.legsWorkoutPlanSize());
        workoutPlan.addLegsWorkoutPlan(exercise7);
        assertEquals(2, workoutPlan.legsWorkoutPlanSize());
        workoutPlan.deleteLegsWorkoutPlan(exercise6);
        assertEquals(1, workoutPlan.legsWorkoutPlanSize());

    }


    @Test

    public void testGetChestWorkoutPlan() {

        workoutPlan.addChestWorkoutPlan(exercise1);
        assertEquals(1, workoutPlan.getChestWorkoutPlan().size());

    }

    @Test

    public void testGetBackWorkoutPlan() {

        workoutPlan.addBackWorkoutPlan(exercise2);
        assertEquals(1, workoutPlan.getBackWorkoutPlan().size());

    }

    @Test

    public void testGetLegsWorkoutPlan() {

        workoutPlan.addLegsWorkoutPlan(exercise6);
        workoutPlan.addLegsWorkoutPlan(exercise7);
        assertEquals(2, workoutPlan.getLegsWorkoutPlan().size());

    }

    @Test

    public void testGetArmsWorkoutPlan() {

        workoutPlan.addArmsWorkoutPlan(exercise3);
        workoutPlan.addArmsWorkoutPlan(exercise5);
        assertEquals(2, workoutPlan.getArmsWorkoutPlan().size());

    }

    @Test

    public void testContainsChestWorkoutPlan() {

        workoutPlan.addChestWorkoutPlan(exercise1);
        assertEquals(1, workoutPlan.chestWorkoutPlanSize());
        assertTrue(workoutPlan.containChestExercise("Bench Press"));
        assertFalse(workoutPlan.containChestExercise("BENCH PRESS"));

    }

    @Test

    public void testContainsBackWorkoutPlan() {

        workoutPlan.addBackWorkoutPlan(exercise2);
        assertEquals(1, workoutPlan.backWorkoutPlanSize());
        workoutPlan.addBackWorkoutPlan(exercise4);
        assertEquals(2, workoutPlan.backWorkoutPlanSize());
        assertTrue(workoutPlan.containBackExercise("Dead lift"));
        assertFalse(workoutPlan.containBackExercise("Hammer Curl"));

    }

    @Test

    public void testContainsLegsWorkoutPlan() {

        workoutPlan.addLegsWorkoutPlan(exercise6);
        assertEquals(1, workoutPlan.legsWorkoutPlanSize());
        workoutPlan.addLegsWorkoutPlan(exercise7);
        assertEquals(2, workoutPlan.legsWorkoutPlanSize());
        assertTrue(workoutPlan.containLegsExercise("Leg Press"));
        assertFalse(workoutPlan.containLegsExercise("LEg Extension"));

    }

    @Test

    public void testContainsArmsWorkoutPlan() {

        workoutPlan.addArmsWorkoutPlan(exercise3);
        assertEquals(1, workoutPlan.armsWorkoutPlanSize());
        assertTrue(workoutPlan.containArmsExercise("Hammer Curl"));

    }


}