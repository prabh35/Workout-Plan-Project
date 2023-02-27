package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExerciseTest {


    private Exercise exercise1;
    private Exercise exercise2;
    private Exercise exercise3;
    private Exercise exercise4;
    private Exercise exercise5;
    private Exercise exercise6;
    private Exercise exercise7;


    @BeforeEach

    public void runBefore() {
        exercise1 = new Exercise("Bench Press", "Chest", 3, 15);
        exercise2 = new Exercise("Dead lift", "Back", 4, 10);
        exercise3 = new Exercise("Hammer Curl", "Arms", 3, 13);
        exercise4 = new Exercise("Lats Pull Down", "Back", 4, 13);
        exercise5 = new Exercise("Dips", "Arms", 3, 10);
        exercise6 = new Exercise("Leg Press", "Legs", 5, 8);
        exercise7 = new Exercise("Leg Extension", "Legs", 3, 12);


    }


    @Test

    public void testGetTitle() {
        assertEquals("Bench Press", exercise1.getTitle());
        assertEquals("Leg Press", exercise6.getTitle());
        assertEquals("Hammer Curl", exercise3.getTitle());
    }
}
