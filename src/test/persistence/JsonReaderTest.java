package persistence;

import model.Exercise;
import model.WorkoutPlan;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            WorkoutPlan w = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            //pass
        }
    }

    @Test
    void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyWorkout.json");
        try {
            WorkoutPlan w = reader.read();
            assertEquals(0, w.getBackWorkoutPlan().size());
            assertEquals(0, w.getChestWorkoutPlan().size());
            assertEquals(0, w.getArmsWorkoutPlan().size());
            assertEquals(0, w.getLegsWorkoutPlan().size());

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralWorkout.json");
        try {
            WorkoutPlan w = reader.read();
            List<Exercise> backList = w.getBackWorkoutPlan();
            assertEquals(1, w.backWorkoutPlanSize());
            checkExercise("b", "Back",10,10, backList.get(0));

            List<Exercise> chestList = w.getChestWorkoutPlan();
            assertEquals(1, w.chestWorkoutPlanSize());
            checkExercise("c", "Chest",10,10, chestList.get(0));

            List<Exercise> armsList = w.getArmsWorkoutPlan();
            assertEquals(1, w.armsWorkoutPlanSize());
            checkExercise("a", "Arms",10,10, armsList.get(0));

            List<Exercise> legsList = w.getLegsWorkoutPlan();
            assertEquals(1, w.legsWorkoutPlanSize());
            checkExercise("l", "Legs",10,10, legsList.get(0));

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}