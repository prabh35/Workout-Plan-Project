package persistence;

import model.Exercise;
import model.WorkoutPlan;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest {


    @Test
    void testWriterInvalidFile() {
        try {

            WorkoutPlan w = new WorkoutPlan();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {

            WorkoutPlan w = new WorkoutPlan();
            w.addBackWorkoutPlan(new Exercise("b", "Back",10,10));
            w.addChestWorkoutPlan(new Exercise("c","Chest",10,10));
            w.addArmsWorkoutPlan(new Exercise("a","Arms",10,10));
            w.addLegsWorkoutPlan(new Exercise("l","Legs",10,10));

            JsonWriter writer = new JsonWriter("./data/testWriterGeneralWorkout.json");
            writer.open();
            writer.write(w);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralWorkout.json");
            w = reader.read();

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
            fail("Exception not thrown ");
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {

            WorkoutPlan w = new WorkoutPlan();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyWorkout.json");
            writer.open();

            writer.write(w);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyWorkout.json");
            w = reader.read();

            assertEquals(0, w.getBackWorkoutPlan().size());
            assertEquals(0, w.getChestWorkoutPlan().size());
            assertEquals(0, w.getArmsWorkoutPlan().size());
            assertEquals(0, w.getLegsWorkoutPlan().size());

        } catch (IOException e) {
            fail("Exception not thrown");
        }
    }


}
