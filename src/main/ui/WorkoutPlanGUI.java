package ui;


import model.Exercise;
import model.WorkoutPlan;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


// Graphic-user interface
public class WorkoutPlanGUI implements ActionListener {

    private WorkoutPlan workoutPlan;
    private JPanel jpanel;
    private JFrame jframe;
    private JTextField title;
    private JTextField muscleGroup;
    private JTextField repetitions;
    private JTextField sets;
    private JButton back;
    private static final String JSON_STORE = "./data/workout.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;


    //EFFECTS: constructs panels,frames, and buttons for GUI

    public WorkoutPlanGUI() {
        workoutPlan = new WorkoutPlan();
        jpanel = new JPanel();
        jpanel.setBackground(Color.gray);
        JLabel background = new JLabel();
        background.setBounds(250, 100, 200, 200);
        jpanel.add(background);
        jframe = new JFrame("My Workout Plan ");
        jframe.add(jpanel);
        jframe.setSize(800, 800);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        back = new JButton("Back");
        back.setActionCommand("back");
        back.addActionListener(this);
        button();
        jsonReader = new JsonReader(JSON_STORE);
        jsonWriter = new JsonWriter(JSON_STORE);
        jframe.setVisible(true);
        jframeWindowListener();
    }


    //EFFECTS: creates the jButton for saving and loading the workout plan
    private void saveAndLoadButton() {
        JButton saveWorkoutPlan = new JButton("Save WorkoutPlan");
        JButton loadWorkoutPlan = new JButton("Load WorkoutPlan");
        saveWorkoutPlan.setBounds(100, 50, 200, 40);
        saveWorkoutPlan.setOpaque(true);
        loadWorkoutPlan.setBounds(100, 700, 200, 40);
        loadWorkoutPlan.setOpaque(true);
        saveWorkoutPlan.setActionCommand("save");
        saveWorkoutPlan.addActionListener(this);
        loadWorkoutPlan.setActionCommand("load");
        loadWorkoutPlan.addActionListener(this);
        jpanel.add(saveWorkoutPlan);
        jpanel.add(loadWorkoutPlan);
        jpanel.setLayout(null);
    }

    //EFFECTS: creates jButtons for adding different workout plans
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private void addButton() {
        JButton addBackWorkoutPlan = new JButton("Add BackWorkoutPlan");
        addBackWorkoutPlan.setBounds(100, 100, 200, 40);
        addBackWorkoutPlan.setOpaque(true);
        JButton addChestWorkoutPlan = new JButton("Add ChestWorkoutPlan");
        addChestWorkoutPlan.setBounds(100, 150, 200, 40);
        addChestWorkoutPlan.setOpaque(true);
        JButton addArmsWorkoutPlan = new JButton("Add ArmsWorkoutPlan");
        addArmsWorkoutPlan.setBounds(100, 200, 200, 40);
        addArmsWorkoutPlan.setOpaque(true);
        JButton addLegsWorkoutPlan = new JButton("Add LegsWorkoutPlan");
        addLegsWorkoutPlan.setBounds(100, 250, 200, 40);
        addLegsWorkoutPlan.setOpaque(true);
        addBackWorkoutPlan.setActionCommand("add BackWorkoutPlan");
        addBackWorkoutPlan.addActionListener(this);
        addChestWorkoutPlan.setActionCommand("add ChestWorkoutPlan");
        addChestWorkoutPlan.addActionListener(this);
        addArmsWorkoutPlan.setActionCommand("add ArmsWorkoutPlan");
        addArmsWorkoutPlan.addActionListener(this);
        addLegsWorkoutPlan.setActionCommand("add LegsWorkoutPlan");
        addLegsWorkoutPlan.addActionListener(this);
        jpanel.add(addBackWorkoutPlan);
        jpanel.add(addChestWorkoutPlan);
        jpanel.add(addArmsWorkoutPlan);
        jpanel.add(addLegsWorkoutPlan);
        jpanel.setLayout(null);
    }


    //EFFECTS: create jButtons for deleting different workout plans

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private void deleteButton() {
        JButton deleteBackWorkoutPlan = new JButton("Delete BackWorkoutPlan");
        deleteBackWorkoutPlan.setBounds(100, 300, 200, 40);
        deleteBackWorkoutPlan.setOpaque(true);
        JButton deleteChestWorkoutPlan = new JButton("Delete ChestWorkoutPlan");
        deleteChestWorkoutPlan.setBounds(100, 350, 200, 40);
        deleteChestWorkoutPlan.setOpaque(true);
        JButton deleteArmsWorkoutPlan = new JButton("Delete ArmsWorkoutPlan");
        deleteArmsWorkoutPlan.setBounds(100, 400, 200, 40);
        deleteArmsWorkoutPlan.setOpaque(true);
        JButton deleteLegsWorkoutPlan = new JButton("Delete LegsWorkoutPlan");
        deleteLegsWorkoutPlan.setBounds(100, 450, 200, 40);
        deleteLegsWorkoutPlan.setOpaque(true);
        deleteBackWorkoutPlan.setActionCommand("delete BackWorkoutPlan");
        deleteBackWorkoutPlan.addActionListener(this);
        deleteChestWorkoutPlan.setActionCommand("delete ChestWorkoutPlan");
        deleteChestWorkoutPlan.addActionListener(this);
        deleteArmsWorkoutPlan.setActionCommand("delete ArmsWorkoutPlan");
        deleteArmsWorkoutPlan.addActionListener(this);
        deleteLegsWorkoutPlan.setActionCommand("delete LegsWorkoutPlan");
        deleteLegsWorkoutPlan.addActionListener(this);

        jpanel.add(deleteBackWorkoutPlan);
        jpanel.add(deleteChestWorkoutPlan);
        jpanel.add(deleteArmsWorkoutPlan);
        jpanel.add(deleteLegsWorkoutPlan);
        jpanel.setLayout(null);

    }

    //EFFECTS: creates jButtons to view different workout plans
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private void viewButton() {
        JButton viewBackWorkoutPlan = new JButton("View BackWorkoutPlan");
        viewBackWorkoutPlan.setBounds(100, 500, 200, 40);
        viewBackWorkoutPlan.setOpaque(true);
        JButton viewChestWorkoutPlan = new JButton("View ChestWorkoutPlan");
        viewChestWorkoutPlan.setBounds(100, 550, 200, 40);
        viewChestWorkoutPlan.setOpaque(true);
        JButton viewArmsWorkoutPlan = new JButton("View ArmsWorkoutPlan");
        viewArmsWorkoutPlan.setBounds(100, 600, 200, 40);
        viewArmsWorkoutPlan.setOpaque(true);
        JButton viewLegsWorkoutPlan = new JButton("View LegsWorkoutPlan");
        viewLegsWorkoutPlan.setBounds(100, 650, 200, 40);
        viewLegsWorkoutPlan.setOpaque(true);

        viewBackWorkoutPlan.setActionCommand("view BackWorkoutPlan");
        viewBackWorkoutPlan.addActionListener(this);
        viewChestWorkoutPlan.setActionCommand("view ChestWorkoutPlan");
        viewChestWorkoutPlan.addActionListener(this);
        viewArmsWorkoutPlan.setActionCommand("view ArmsWorkoutPlan");
        viewArmsWorkoutPlan.addActionListener(this);
        viewLegsWorkoutPlan.setActionCommand("view LegsWorkoutPlan");
        viewLegsWorkoutPlan.addActionListener(this);

        jpanel.add(viewBackWorkoutPlan);
        jpanel.add(viewChestWorkoutPlan);
        jpanel.add(viewArmsWorkoutPlan);
        jpanel.add(viewLegsWorkoutPlan);
        jpanel.setLayout(null);
    }


    //EFFECT: creates jButton for the frame
    private void button() {
        addButton();
        deleteButton();
        viewButton();
        saveAndLoadButton();
    }

    //EFFECTS: creates add Back Workout Plan frame and panel
    private void addBackWorkoutPlanFrame() {
        jframe = new JFrame();
        jframe.setSize(500, 500);
        jpanel = new JPanel();
        jpanel.setBackground(Color.gray);
        frameFields();
        frameLabels();
        JButton addBackWorkoutPlan = new JButton("Add");
        addBackWorkoutPlan.setActionCommand("add backWorkoutPlan");
        addBackWorkoutPlan.addActionListener(this);
        addBackWorkoutPlan.setBounds(200, 250, 100, 40);
        back.setBounds(200, 300, 100, 40);
        jpanel.add(title);
        jpanel.add(muscleGroup);
        jpanel.add(repetitions);
        jpanel.add(sets);
        jpanel.add(addBackWorkoutPlan);
        jpanel.add(back);
        jpanel.setLayout(null);
        jframe.add(jpanel);
        jframe.setVisible(true);

    }

    // EFFECTS: creates add Chest Workout Plan frame and panel
    private void addChestWorkoutPlanFrame() {
        jframe = new JFrame();
        jframe.setSize(500, 500);
        jpanel = new JPanel();
        jpanel.setBackground(Color.gray);
        frameFields();
        frameLabels();
        JButton addChestWorkoutPLan = new JButton("Add");
        addChestWorkoutPLan.setActionCommand("add chestWorkoutPlan");
        addChestWorkoutPLan.addActionListener(this);
        addChestWorkoutPLan.setBounds(200, 250, 100, 40);
        back.setBounds(200, 300, 100, 40);
        jpanel.add(title);
        jpanel.add(muscleGroup);
        jpanel.add(repetitions);
        jpanel.add(sets);
        jpanel.add(addChestWorkoutPLan);
        jpanel.add(back);
        jpanel.setLayout(null);
        jframe.add(jpanel);
        jframe.setVisible(true);

    }


    // EFFECTS: creates add Arms Workout Plan frame and panel
    private void addArmsWorkoutPlanFrame() {
        jframe = new JFrame();
        jframe.setSize(500, 500);
        jpanel = new JPanel();
        jpanel.setBackground(Color.gray);
        frameFields();
        frameLabels();
        JButton addArmsWorkoutPLan = new JButton("Add");
        addArmsWorkoutPLan.setActionCommand("add armsWorkoutPlan");
        addArmsWorkoutPLan.addActionListener(this);
        addArmsWorkoutPLan.setBounds(200, 250, 100, 40);
        back.setBounds(200, 300, 100, 40);
        jpanel.add(title);
        jpanel.add(muscleGroup);
        jpanel.add(repetitions);
        jpanel.add(sets);
        jpanel.add(addArmsWorkoutPLan);
        jpanel.add(back);
        jpanel.setLayout(null);
        jframe.add(jpanel);
        jframe.setVisible(true);

    }

    // EFFECTS: creates add Legs Workout Plan frame and panel
    private void addLegsWorkoutPlanFrame() {
        jframe = new JFrame();
        jframe.setSize(500, 500);
        jpanel = new JPanel();
        jpanel.setBackground(Color.gray);
        frameFields();
        frameLabels();
        JButton addArmsWorkoutPLan = new JButton("Add");
        addArmsWorkoutPLan.setActionCommand("add legsWorkoutPlan");
        addArmsWorkoutPLan.addActionListener(this);
        addArmsWorkoutPLan.setBounds(200, 250, 100, 40);
        back.setBounds(200, 300, 100, 40);
        jpanel.add(title);
        jpanel.add(muscleGroup);
        jpanel.add(repetitions);
        jpanel.add(sets);
        jpanel.add(addArmsWorkoutPLan);
        jpanel.add(back);
        jpanel.setLayout(null);
        jframe.add(jpanel);
        jframe.setVisible(true);

    }

    //EFFECTS: creates frame labels
    private void frameLabels() {
        JLabel title1 = new JLabel("Title");
        JLabel muscleGroup1 = new JLabel("MuscleGroup");
        JLabel repetitions1 = new JLabel("Repetitions");
        JLabel sets1 = new JLabel("Sets");

        title1.setBounds(50, 10, 200, 40);
        muscleGroup1.setBounds(50, 50, 200, 40);
        repetitions1.setBounds(50, 90, 200, 40);
        sets1.setBounds(50, 130, 200, 40);
        jpanel.add(title1);
        jpanel.add(muscleGroup1);
        jpanel.add(repetitions1);
        jpanel.add(sets1);

    }

    //EFFECTS: creates frame fields
    private void frameFields() {
        title = new JTextField();
        muscleGroup = new JTextField();
        repetitions = new JTextField();
        sets = new JTextField();

        title.setBounds(150, 10, 100, 40);
        muscleGroup.setBounds(150, 60, 100, 40);
        repetitions.setBounds(150, 110, 100, 40);
        sets.setBounds(150, 160, 100, 40);
    }


    //EFFECTS: adds back exercise with title,muscleGroup,repetitions and sets
    private void addBackWorkoutPlan() {
        int r = Integer.parseInt(repetitions.getText());
        int s = Integer.parseInt(sets.getText());

        Exercise exercise = new Exercise(title.getText(), muscleGroup.getText(), r, s);
        workoutPlan.addBackWorkoutPlan(exercise);
        JOptionPane.showMessageDialog(null, "Back Workout added !!",
                "Message", JOptionPane.PLAIN_MESSAGE);

    }

    //EFFECTS: adds chest exercise with title,muscleGroup,repetitions and sets
    private void addChestWorkoutPlan() {
        int r = Integer.parseInt(repetitions.getText());
        int s = Integer.parseInt(sets.getText());

        Exercise exercise = new Exercise(title.getText(), muscleGroup.getText(), r, s);
        workoutPlan.addChestWorkoutPlan(exercise);
        JOptionPane.showMessageDialog(null, "Chest Workout added !!",
                "Message", JOptionPane.PLAIN_MESSAGE);

    }

    //EFFECTS: adds arms exercise with title,muscleGroup,repetitions and sets
    private void addArmsWorkoutPlan() {
        int r = Integer.parseInt(repetitions.getText());
        int s = Integer.parseInt(sets.getText());

        Exercise exercise = new Exercise(title.getText(), muscleGroup.getText(), r, s);
        workoutPlan.addArmsWorkoutPlan(exercise);
        JOptionPane.showMessageDialog(null, "Arms Workout added !!",
                "Message", JOptionPane.PLAIN_MESSAGE);

    }

    //EFFECTS: adds legs exercise with title,muscleGroup,repetitions and sets
    private void addLegsWorkoutPlan() {
        int r = Integer.parseInt(repetitions.getText());
        int s = Integer.parseInt(sets.getText());

        Exercise exercise = new Exercise(title.getText(), muscleGroup.getText(), r, s);
        workoutPlan.addLegsWorkoutPlan(exercise);
        JOptionPane.showMessageDialog(null, "Leg Workout added !!",
                "Message", JOptionPane.PLAIN_MESSAGE);

    }


    //EFFECTS: creates the frame and panel for deleting Back Workout Plan
    public void deleteBackWorkoutPlanFrame() {
        initializeDeleteFrame();

        JButton deleteBackWorkoutPlan = new JButton("Delete");
        deleteBackWorkoutPlan.setBounds(200, 250, 100, 40);
        back.setBounds(200, 300, 100, 40);
        deleteBackWorkoutPlan.setActionCommand("delete backWorkoutPlan");
        deleteBackWorkoutPlan.addActionListener(this);
        jpanel.add(title);
        jpanel.add(muscleGroup);
        jpanel.add(repetitions);
        jpanel.add(sets);
        jpanel.add(deleteBackWorkoutPlan);
        jpanel.add(back);
        jpanel.setLayout(null);
        jframe.add(jpanel);
        jframe.setVisible(true);
    }

    //EFFECTS: creates the frame and panel for deleting Chest Workout Plan
    public void deleteChestWorkoutPLanFrame() {
        initializeDeleteFrame();
        JButton deleteChestWorkoutPlan = new JButton("Delete");
        deleteChestWorkoutPlan.setBounds(200, 250, 100, 40);
        back.setBounds(200, 300, 100, 40);
        deleteChestWorkoutPlan.setActionCommand("delete chestWorkoutPlan");
        deleteChestWorkoutPlan.addActionListener(this);
        jpanel.add(title);
        jpanel.add(muscleGroup);
        jpanel.add(repetitions);
        jpanel.add(sets);
        jpanel.add(deleteChestWorkoutPlan);
        jpanel.add(back);
        jpanel.setLayout(null);
        jframe.add(jpanel);
        jframe.setVisible(true);
    }


    //EFFECTS: creates the frame and panel for deleting Arms Workout Plan
    public void deleteArmsWorkoutPlanFrame() {
        initializeDeleteFrame();
        JButton deleteArmsWorkoutPlan = new JButton("Delete");
        deleteArmsWorkoutPlan.setBounds(200, 250, 100, 40);
        back.setBounds(200, 300, 100, 40);
        deleteArmsWorkoutPlan.setActionCommand("delete armsWorkoutPlan");
        deleteArmsWorkoutPlan.addActionListener(this);
        jpanel.add(title);
        jpanel.add(muscleGroup);
        jpanel.add(repetitions);
        jpanel.add(sets);
        jpanel.add(deleteArmsWorkoutPlan);
        jpanel.add(back);
        jpanel.setLayout(null);
        jframe.add(jpanel);
        jframe.setVisible(true);
    }

    //EFFECTS: creates the frame and panel for deleting Legs Workout Plan
    public void deleteLegsWorkoutPlanFrame() {
        initializeDeleteFrame();
        JButton deleteLegsWorkoutPlan = new JButton("Delete");
        deleteLegsWorkoutPlan.setBounds(200, 250, 100, 40);
        back.setBounds(200, 300, 100, 40);
        deleteLegsWorkoutPlan.setActionCommand("delete legsWorkoutPlan");
        deleteLegsWorkoutPlan.addActionListener(this);
        jpanel.add(title);
        jpanel.add(muscleGroup);
        jpanel.add(repetitions);
        jpanel.add(sets);
        jpanel.add(deleteLegsWorkoutPlan);
        jpanel.add(back);
        jpanel.setLayout(null);

        jframe.add(jpanel);
        jframe.setVisible(true);
    }


    private void initializeDeleteFrame() {

        jframe = new JFrame();
        jframe.setSize(500, 500);

        jpanel = new JPanel();
        jpanel.setBackground(Color.gray);

        title = new JTextField();
        muscleGroup = new JTextField();
        repetitions = new JTextField();
        sets = new JTextField();
        JLabel label = new JLabel("Title");
        label.setBounds(100, 10, 100, 40);
        title.setBounds(130, 10, 100, 40);

        jpanel.add(label);


    }

    //MODIFIES: workoutPlan
    //EFFECTS: deletes back workout with given title
    private void deleteBackWorkoutPlan() {
        if (!workoutPlan.containBackExercise(title.getText())) {
            JOptionPane.showMessageDialog(null, "Exercise not found!", "Message",
                    JOptionPane.PLAIN_MESSAGE);
        } else {

            for (Exercise e : workoutPlan.getBackWorkoutPlan()) {

                if (e.getTitle().equals(title.getText())) {

                    workoutPlan.getBackWorkoutPlan().remove(e);

                    JOptionPane.showMessageDialog(null, "Exercise deleted", "Message",
                            JOptionPane.PLAIN_MESSAGE);
                }
            }

        }
    }

    //MODIFIES: workoutPlan
    //EFFECTS: deletes Chest workout with given title
    private void deleteChestWorkoutPlan() {
        if (!workoutPlan.containChestExercise(title.getText())) {
            JOptionPane.showMessageDialog(null, "Exercise not found!", "Message",
                    JOptionPane.PLAIN_MESSAGE);
        } else {

            for (Exercise e : workoutPlan.getChestWorkoutPlan()) {

                if (e.getTitle().equals(title.getText())) {

                    workoutPlan.getChestWorkoutPlan().remove(e);

                    JOptionPane.showMessageDialog(null, "Exercise deleted", "Message",
                            JOptionPane.PLAIN_MESSAGE);
                }
            }

        }
    }

    //MODIFIES: workoutPlan
    //EFFECTS: deletes Arms workout with given title
    private void deleteArmsWorkoutPlan() {
        if (!workoutPlan.containArmsExercise(title.getText())) {
            JOptionPane.showMessageDialog(null, "Exercise  not found!", "Message",
                    JOptionPane.PLAIN_MESSAGE);
        } else {
            for (Exercise e : workoutPlan.getArmsWorkoutPlan()) {
                if (e.getTitle().equals(title.getText())) {

                    workoutPlan.getArmsWorkoutPlan().remove(e);

                    JOptionPane.showMessageDialog(null, "Exercise deleted", "Message",
                            JOptionPane.PLAIN_MESSAGE);
                }
            }

        }
    }

    //MODIFIES: workoutPlan
    //EFFECTS: deletes Legs workout with given title
    private void deleteLegsWorkoutPlan() {
        if (!workoutPlan.containLegsExercise(title.getText())) {
            JOptionPane.showMessageDialog(null, "Exercise not found!", "Message",
                    JOptionPane.PLAIN_MESSAGE);
        } else {

            for (Exercise e : workoutPlan.getLegsWorkoutPlan()) {

                if (e.getTitle().equals(title.getText())) {

                    workoutPlan.getLegsWorkoutPlan().remove(e);

                    JOptionPane.showMessageDialog(null, "Exercise deleted", "Message",
                            JOptionPane.PLAIN_MESSAGE);
                }
            }

        }
    }


    //EFFECTS: creates the frame and panel to view back workout plan
    public void viewBackWorkoutPlan() {
        jframe = new JFrame();
        jpanel = new JPanel();
        jpanel.setBackground(Color.gray);
        String str;
        List<String> formatted = new ArrayList<>();
        if (workoutPlan.getBackWorkoutPlan() != null) {
            for (Exercise e : workoutPlan.getBackWorkoutPlan()) {
                str = "Title : " + e.getTitle() + " " + " MuscleGroup : " + e.getMuscleGroup() + " Repetitions : "
                        + e.getRepetitions() + " Sets : " + e.getSets();
                formatted.add(str);
            }
        }

        JList<Object> j = new JList<>(formatted.toArray());
        jpanel.add(j);
        jpanel.add(BorderLayout.SOUTH, back);
        jframe.add(jpanel);
        jframe.pack();
        jframe.setVisible(true);
    }


    //EFFECTS: creates the frame and panel to view chest workout plan
    public void viewChestWorkoutPlan() {
        jframe = new JFrame();
        jpanel = new JPanel();
        jpanel.setBackground(Color.gray);
        String str;
        List<String> formatted = new ArrayList<>();
        if (workoutPlan.getChestWorkoutPlan() != null) {
            for (Exercise e : workoutPlan.getChestWorkoutPlan()) {
                str = "Title : " + e.getTitle() + " " + " MuscleGroup : " + e.getMuscleGroup() + " Repetitions : "
                        + e.getRepetitions() + " Sets : " + e.getSets();
                formatted.add(str);
            }
        }

        JList<Object> j = new JList<>(formatted.toArray());
        jpanel.add(j);
        jpanel.add(BorderLayout.SOUTH, back);
        jframe.add(jpanel);
        jframe.pack();
        jframe.setVisible(true);
    }


    //EFFECTS: creates the frame and panel to view Arms workout plan
    public void viewArmsWorkoutPlan() {
        jframe = new JFrame();
        jpanel = new JPanel();
        jpanel.setBackground(Color.gray);
        String str;
        List<String> formatted = new ArrayList<>();
        if (workoutPlan.getArmsWorkoutPlan() != null) {
            for (Exercise e : workoutPlan.getArmsWorkoutPlan()) {
                str = "Title : " + e.getTitle() + " " + " MuscleGroup : " + e.getMuscleGroup() + " Repetitions : "
                        + e.getRepetitions() + " Sets : " + e.getSets();
                formatted.add(str);
            }
        }

        JList<Object> j = new JList<>(formatted.toArray());
        jpanel.add(j);
        jpanel.add(BorderLayout.SOUTH, back);
        jframe.add(jpanel);
        jframe.pack();
        jframe.setVisible(true);
    }

    //EFFECTS: creates the frame and panel to view Legs workout plan
    public void viewLegsWorkoutPlan() {
        jframe = new JFrame();
        jpanel = new JPanel();
        jpanel.setBackground(Color.gray);
        String str;
        List<String> formatted = new ArrayList<>();
        if (workoutPlan.getLegsWorkoutPlan() != null) {
            for (Exercise e : workoutPlan.getLegsWorkoutPlan()) {
                str = "Title : " + e.getTitle() + " " + " MuscleGroup : " + e.getMuscleGroup() + " Repetitions : "
                        + e.getRepetitions() + " Sets : " + e.getSets();
                formatted.add(str);
            }
        }

        JList<Object> j = new JList<>(formatted.toArray());
        jpanel.add(j);
        jpanel.add(BorderLayout.SOUTH, back);
        jframe.add(jpanel);
        jframe.pack();
        jframe.setVisible(true);
    }

    //EFFECTS: saves the workout Plan
    private void saveWorkoutPlan() {
        try {
            jsonWriter.open();
            jsonWriter.write(workoutPlan);
            jsonWriter.close();

            System.out.println("Saved " + workoutPlan + " to " + JSON_STORE);

        } catch (FileNotFoundException e) {

            System.out.println(" Unable to write to file: " + JSON_STORE);
        }

    }

    //EFFECTS: loads the workout Plan
    private void loadWorkoutPlan() {
        try {
            workoutPlan = jsonReader.read();

            System.out.println("Loaded " + workoutPlan + " from " + JSON_STORE);

        } catch (IOException e) {

            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }


    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    @Override
    //EFFECTS: message to all the action listeners
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("add BackWorkoutPlan")) {
            addBackWorkoutPlanFrame();
        } else if (e.getActionCommand().equals("add ChestWorkoutPlan")) {
            addChestWorkoutPlanFrame();
        } else if (e.getActionCommand().equals("add ArmsWorkoutPlan")) {
            addArmsWorkoutPlanFrame();
        } else if (e.getActionCommand().equals("add LegsWorkoutPlan")) {
            addLegsWorkoutPlanFrame();
        } else if (e.getActionCommand().equals("add backWorkoutPlan")) {
            addBackWorkoutPlan();
        } else if (e.getActionCommand().equals("add chestWorkoutPlan")) {
            addChestWorkoutPlan();
        } else if (e.getActionCommand().equals("add armsWorkoutPlan")) {
            addArmsWorkoutPlan();
        } else if (e.getActionCommand().equals("add legsWorkoutPlan")) {
            addLegsWorkoutPlan();
        } else if (e.getActionCommand().equals("delete BackWorkoutPlan")) {
            deleteBackWorkoutPlanFrame();
        } else if (e.getActionCommand().equals("delete ChestWorkoutPlan")) {
            deleteChestWorkoutPLanFrame();
        } else if (e.getActionCommand().equals("delete ArmsWorkoutPlan")) {
            deleteArmsWorkoutPlanFrame();
        } else if (e.getActionCommand().equals("delete LegsWorkoutPlan")) {
            deleteLegsWorkoutPlanFrame();
        } else {
            actionPerformedContinued(e);
        }
    }

    //EFFECTS: actionPerformed function continued/message to all the action listeners
    private void actionPerformedContinued(ActionEvent e) {
        if (e.getActionCommand().equals("delete backWorkoutPlan")) {
            deleteBackWorkoutPlan();
        } else if (e.getActionCommand().equals("delete chestWorkoutPlan")) {
            deleteChestWorkoutPlan();
        } else if (e.getActionCommand().equals("delete armsWorkoutPlan")) {
            deleteArmsWorkoutPlan();
        } else if (e.getActionCommand().equals("delete legsWorkoutPlan")) {
            deleteLegsWorkoutPlan();
        } else if (e.getActionCommand().equals("load")) {
            loadWorkoutPlan();
        } else if (e.getActionCommand().equals("save")) {
            saveWorkoutPlan();
        } else if (e.getActionCommand().equals("back")) {
            jframe.dispose();
        } else if (e.getActionCommand().equals("view BackWorkoutPlan")) {
            viewBackWorkoutPlan();
        } else if (e.getActionCommand().equals("view ChestWorkoutPlan")) {
            viewChestWorkoutPlan();
        } else if (e.getActionCommand().equals("view ArmsWorkoutPlan")) {
            viewArmsWorkoutPlan();
        } else if (e.getActionCommand().equals("view LegsWorkoutPlan")) {
            viewLegsWorkoutPlan();
        }
    }

    //EFFECTS: prints logged  when program exited
    public void jframeWindowListener() {
        jframe.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);

            }
        });

    }


    //EFFECTS: runs the gui
    public static void main(String[] args) {
        new WorkoutPlanGUI();
    }
}
