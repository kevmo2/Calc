import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kevin on 7/10/14.
 */
public class Calc extends JFrame implements ActionListener {

    private JPanel panel;
    static JButton equalsButton,addButton,subButton,multiButton,divButton,clearButton,plusMinusButton,decimalButton;
    static JButton oneButton,twoButton,threeButton,fourButton,fiveButton,sixButton,sevenButton,eightButton,nineButton,zeroButton;
    private static JTextField ansField;
    private double visibleNumber, storedNumber;
    private double plusMinus;
    private Boolean fieldClear;
    private enum Operation {ADD, SUBTRACT, MULTIPLY, DIVIDE, NONE};
    private enum ClickType {NUMERIC, OPERATION, START};
    private Operation queuedOperation;
    private ClickType previousClick;

    public Calc() {

        //Ensure that the application actually closes
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Calculator");
        setResizable(false);
        setSize(230, 370);
        setLocationRelativeTo(null); //null ensures its in the middle of the screen

        //instantiate panel
        panel = new JPanel();
        panel.setSize(230,370);
        panel.setLayout(null);

        //setup buttons
        addButton = new JButton("+");
        addButton.setSize(50,50);
        addButton.setLocation(170,175);
        subButton = new JButton("-");
        subButton.setSize(50,50);
        subButton.setLocation(170,120);
        multiButton = new JButton("*");
        multiButton.setSize(50,50);
        multiButton.setLocation(170, 65);
        divButton = new JButton("/");
        divButton.setSize(50,50);
        divButton.setLocation(115,65);
        equalsButton = new JButton("=");
        equalsButton.setSize(50,105);
        equalsButton.setLocation(170,230);
        zeroButton = new JButton("0");
        zeroButton.setSize(105,50);
        zeroButton.setLocation(5,285);
        oneButton = new JButton("1");
        oneButton.setSize(50,50);
        oneButton.setLocation(5,230);
        twoButton = new JButton("2");
        twoButton.setSize(50,50);
        twoButton.setLocation(60,230);
        threeButton = new JButton("3");
        threeButton.setSize(50,50);
        threeButton.setLocation(115,230);
        fourButton = new JButton("4");
        fourButton.setSize(50,50);
        fourButton.setLocation(5,175);
        fiveButton = new JButton("5");
        fiveButton.setSize(50,50);
        fiveButton.setLocation(60,175);
        sixButton = new JButton("6");
        sixButton.setSize(50,50);
        sixButton.setLocation(115,175);
        sevenButton = new JButton("7");
        sevenButton.setSize(50,50);
        sevenButton.setLocation(5,120);
        eightButton = new JButton("8");
        eightButton.setSize(50,50);
        eightButton.setLocation(60,120);
        nineButton = new JButton("9");
        nineButton.setSize(50,50);
        nineButton.setLocation(115,120);
        clearButton = new JButton("C");
        clearButton.setSize(50,50);
        clearButton.setLocation(5,65);
        decimalButton = new JButton(".");
        decimalButton.setSize(50,50);
        decimalButton.setLocation(115,285);
        plusMinusButton = new JButton("+/-");
        plusMinusButton.setSize(50,50);
        plusMinusButton.setLocation(60,65);
        ansField = new JTextField();
        ansField.setSize(215,50);
        ansField.setLocation(5,10);
        ansField.setFont(new Font("Arial", Font.BOLD,24));
        ansField.setEditable(false);
        panel.add(addButton);
        panel.add(subButton);
        panel.add(multiButton);
        panel.add(divButton);
        panel.add(zeroButton);
        panel.add(oneButton);
        panel.add(twoButton);
        panel.add(threeButton);
        panel.add(fourButton);
        panel.add(fiveButton);
        panel.add(sixButton);
        panel.add(sevenButton);
        panel.add(eightButton);
        panel.add(nineButton);
        panel.add(ansField);
        panel.add(plusMinusButton);
        panel.add(decimalButton);
        panel.add(equalsButton);
        panel.add(clearButton);
        add(panel); //permanently sets the panel
        zeroButton.addActionListener(this);
        oneButton.addActionListener(this);
        twoButton.addActionListener(this);
        threeButton.addActionListener(this);
        fourButton.addActionListener(this);
        fiveButton.addActionListener(this);
        sixButton.addActionListener(this);
        sevenButton.addActionListener(this);
        eightButton.addActionListener(this);
        nineButton.addActionListener(this);
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        multiButton.addActionListener(this);
        divButton.addActionListener(this);
        clearButton.addActionListener(this);
        decimalButton.addActionListener(this);
        plusMinusButton.addActionListener(this);
        equalsButton.addActionListener(this);
        plusMinus = -1;
        storedNumber = 0;
        visibleNumber = 0;
        fieldClear = true;
        queuedOperation = Operation.NONE;
        previousClick = ClickType.START;
    }

    public void actionPerformed(ActionEvent event) {
        if (isNumericButtonPushed(event)) {
            numericButtonPushed((JButton) event.getSource());
        } else if (isClearPushed(event)) {
            clearButtonPushed();
        } else if (isOperationButtonPushed(event)) {
            operationButtonPushed(event);
        } else if (isEqualsButtonPushed(event)) {
            equalButtonPushed();
        } else if (isPlusMinusButtonPushed(event)) {
            plusMinusButtonPushed();
        }
    }

    private Boolean isNumericButtonPushed(ActionEvent event){
        boolean returnValue;

        if (event.getSource() == zeroButton) {
            returnValue = true;
        } else if (event.getSource() == oneButton) {
            returnValue = true;
        } else if (event.getSource() == twoButton) {
            returnValue = true;
        } else if (event.getSource() == threeButton) {
            returnValue = true;
        } else if (event.getSource() == fourButton) {
            returnValue = true;
        } else if (event.getSource() == fiveButton) {
            returnValue = true;
        } else if (event.getSource() == sixButton) {
            returnValue = true;
        } else if (event.getSource() == sevenButton) {
            returnValue = true;
        } else if (event.getSource() == eightButton) {
            returnValue = true;
        } else if (event.getSource() == nineButton) {
            returnValue = true;
        } else if (event.getSource() == decimalButton) {
            returnValue = true;
        } else {
            returnValue = false;
        }

        return returnValue;
    }

    private Boolean isOperationButtonPushed(ActionEvent event) {
        if (event.getSource() == addButton) {
            return true;
        } else if (event.getSource() == subButton) {
            return true;
        } else if (event.getSource() == multiButton) {
            return true;
        } else return event.getSource() == divButton;
    }

    private Boolean isClearPushed(ActionEvent event) {
        return event.getSource() == clearButton;
    }

    private Boolean isEqualsButtonPushed(ActionEvent event) {
        return event.getSource() == equalsButton;
    }

    private Boolean isPlusMinusButtonPushed(ActionEvent event) {
        return event.getSource() == plusMinusButton;
    }

    private Boolean isLengthSixteen(JTextField field) {
        return field.getText().length() < 16;
    }

    private Boolean isNumberNegative(Double number) {
        if (number < 0) {
            return true;
        } else
            return false;
    }

    private void numericButtonPushed(JButton button) {
        String fieldText = ansField.getText();
        System.out.println("numericButtonPushed " + queuedOperation.toString());

        if (previousClick.equals(ClickType.OPERATION)) {
            clearField();
            fieldText = ansField.getText();
        }

        if(isLengthSixteen(ansField)){
            if(fieldClear){
                fieldText = button.getText();
            } else if (!fieldText.contains(".")) {
                fieldText = fieldText + button.getText();

            } else if (fieldText.contains(".") && !button.getText().equals(".")) {
                fieldText = fieldText + button.getText();
            }
            ansField.setText(fieldText);
            this.fieldClear = false;
            if (!fieldText.equals(".")) {
                this.visibleNumber = Double.parseDouble(fieldText);
            }
        }
        this.fieldClear = false;
        this.previousClick = ClickType.NUMERIC;
        System.out.println("visbileNumber: " + visibleNumber);
    }

    private void operationButtonPushed(ActionEvent event) {
        if (event.getSource() == addButton) {
            if (previousClick.equals(ClickType.NUMERIC) && !queuedOperation.equals(Operation.NONE)) {
                executeQueuedOperation();
            }
            queuedOperation = Operation.ADD;
        } else if (event.getSource() == subButton) {
            if (previousClick.equals(ClickType.NUMERIC) && !queuedOperation.equals(Operation.NONE)) {
                executeQueuedOperation();
            }
            queuedOperation = Operation.SUBTRACT;
        } else if (event.getSource() == multiButton) {
            if (previousClick.equals(ClickType.NUMERIC) && !queuedOperation.equals(Operation.NONE)) {
                executeQueuedOperation();
            }
            queuedOperation = Operation.MULTIPLY;
        } else if (event.getSource() == divButton) {
            if (previousClick.equals(ClickType.NUMERIC) && !queuedOperation.equals(Operation.NONE)) {
                executeQueuedOperation();
            }
            queuedOperation = Operation.DIVIDE;
        }
        storedNumber = visibleNumber;
        System.out.println("storedNumber: " + storedNumber);
        previousClick = ClickType.OPERATION;
    }

    private void equalButtonPushed() {
        executeQueuedOperation();
        storedNumber = visibleNumber;
        queuedOperation = Operation.NONE;
        previousClick = ClickType.OPERATION;
    }

    private void plusMinusButtonPushed() {
        if (isNumberNegative(visibleNumber)) {
            ansField.setText(ansField.getText().replace("-", ""));
            visibleNumber *= plusMinus;
        } else {
            ansField.setText("-" + ansField.getText());
            visibleNumber *= plusMinus;
        }
    }

    private void clearButtonPushed() {
        clearField();
        queuedOperation = Operation.NONE;
        storedNumber = 0;
        visibleNumber = 0;
    }

    private void clearField() {
        System.out.println("clearField entry");
        System.out.println("Field contents: " + ansField.getText());
        ansField.setText("");
        fieldClear = true;
        visibleNumber = 0;
        System.out.println("clearField exit. ansField: " + ansField.getText());
    }

    private Boolean isNumberZero(Double number) {
        return number == 0;
    }

    private void printNumbers() {
        System.out.println("visibleNumber: [" + visibleNumber + "]");
        System.out.println("storedNumber: [" + storedNumber + "]");
    }

    private void executeQueuedOperation(){
        System.out.println("QueuedOperation: [" + queuedOperation.toString() + "]");
        printNumbers();
        switch(queuedOperation) {
            case ADD:
                storedNumber = addNumbers(visibleNumber, storedNumber);
                break;
            case SUBTRACT:
                storedNumber = subractNumbers(visibleNumber, storedNumber);
                break;
            case MULTIPLY:
                storedNumber = multiplyNumbers(visibleNumber, storedNumber);
                break;
            case DIVIDE:
                storedNumber = divideNumbers(visibleNumber, storedNumber);
                break;
            default:
                clearField();
                break;
        }
        System.out.println("Operation Results");
        printNumbers();
        ansField.setText(String.valueOf(storedNumber));
        visibleNumber = storedNumber;
    }

    private Double addNumbers(Double num1, Double num2) {
        return num1 + num2;
    }

    private Double subractNumbers(Double num1, Double num2) {
        return num2 - num1;
    }

    private Double multiplyNumbers(Double num1, Double num2) {
        return num1 * num2;
    }

    private Double divideNumbers(Double num1, Double num2) {
        if (isNumberZero(num1)) {
            System.out.println("you dumb fuck you can't divide by zero!");
            return 0D;
        } else {
            return num2 / num1;
        }
    }

}
