package com.example.assignment2javafx;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    private TextField inputValues;

    @FXML
    private RadioButton addButton;

    @FXML
    private RadioButton averageButton;

    @FXML
    private RadioButton minimumButton;

    @FXML
    private RadioButton maximumButton;

    @FXML
    private Label welcomeText;

    private ToggleGroup operationGroup;

    @FXML
    private Button clearButton;


    @FXML
    private void initialize() {
        operationGroup = new ToggleGroup();

        addButton.setToggleGroup(operationGroup);
        averageButton.setToggleGroup(operationGroup);
        minimumButton.setToggleGroup(operationGroup);
        maximumButton.setToggleGroup(operationGroup);

        addButton.setSelected(true);
    }

    @FXML
    protected void onHelloButtonClick() {
        String input = inputValues.getText();

        String[] valueStrings = input.split(",");

        int[] values = new int[valueStrings.length];

        // Parse the values as integers
        for (int i = 0; i < valueStrings.length; i++) {
            try {
                values[i] = Integer.parseInt(valueStrings[i]);
            } catch (NumberFormatException e) {
                System.err.println("Invalid input: " + valueStrings[i]);
                return;
            }
        }

        int result = 0;
        RadioButton selectedRadioButton = (RadioButton) operationGroup.getSelectedToggle();

        if (selectedRadioButton == addButton) {
            result = Excel.calculateSum(values);
        } else if (selectedRadioButton == averageButton) {
            result = Excel.calculateAverage(values);
        } else if (selectedRadioButton == minimumButton) {
            result = Excel.findMinimum(values);
        } else if (selectedRadioButton == maximumButton) {
            result = Excel.findMaximum(values);
        }

        welcomeText.setText(String.valueOf(result));
    }

    @FXML
    private void onClearButtonClick() {
        inputValues.clear();
        operationGroup.selectToggle(null);
        welcomeText.setText("");
    }
}
