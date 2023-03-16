package persistence;


import model.Exercise;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkExercise(String title, String muscleGroup, int sets, int repetitions, Exercise exercise) {

        assertEquals(title, exercise.getTitle());
        assertEquals(muscleGroup, exercise.getMuscleGroup());
        assertEquals(sets, exercise.getSets());
        assertEquals(repetitions, exercise.getRepetitions());

    }

}
