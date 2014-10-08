/**
 * Created by kevimoore on 10/8/14.
 */
public class CalculatorController {

    //Class fields
    private boolean fieldClear;

    private OperationEnum queuedOperation;

    private ButtonTypeEnum previousClick;

    private double visibleNumber;

    private double storedNumber;

    private double plusMinus;

    //Constructor
    public CalculatorController() {

        plusMinus = -1;

        storedNumber = 0;

        visibleNumber = 0;

        fieldClear = true;

        queuedOperation = OperationEnum.NONE;

        previousClick = ButtonTypeEnum.START;
    }

    public boolean isFieldClear() {
        return fieldClear;
    }

    public void setFieldClear(boolean fieldClear) {
        this.fieldClear = fieldClear;
    }

    public void test(){

        System.out.println("Controller called");
    }

    private void printNumbers() {
        System.out.println("visibleNumber: [" + visibleNumber + "]");
        System.out.println("storedNumber: [" + storedNumber + "]");
    }

    private Boolean isLengthSixteen(double storedNumber) {
        return storedNumber < 16;
    }

    private void clearField(CalculatorFrame calculatorFrame) {
        System.out.println("clearField entry");
        System.out.println("Field contents: " + calculatorFrame.getAnsField());
        calculatorFrame.setAnsField("");
        fieldClear = true;
        visibleNumber = 0;
        System.out.println("clearField exit. ansField: " + calculatorFrame.getAnsField());
    }

    public void numericButtonPushed(NumericButton button, CalculatorFrame calculatorFrame) {
        String fieldText = calculatorFrame.getAnsField();
        System.out.println("numericButtonPushed, Queued operation: [" + queuedOperation.toString()+ "]");

        //System.out.println("Checking the previousClick");
        if (previousClick.equals(ButtonTypeEnum.OPERATION)) {
            clearField(calculatorFrame);
            fieldText = calculatorFrame.getAnsField();
        }

        System.out.println("Checking the Length of the field: "+ fieldText.length());
        if(isLengthSixteen(fieldText.length())){
            //System.out.println("Checking if field clear");
            if(fieldClear){
                //System.out.println("Field is clear");
                fieldText = button.getText();
            } else if (!fieldText.contains(".")) {
                //System.out.println("Field does not already contain . ");
                fieldText = fieldText + button.getText();
            } else if (fieldText.contains(".") && !button.getText().equals(".")) {
                //System.out.println("Field already has . and decimal was not pushed");
                fieldText = fieldText + button.getText();
            }
            calculatorFrame.setAnsField(fieldText);
            this.fieldClear = false;
            if (!fieldText.equals(".")) {
                this.visibleNumber = Double.parseDouble(fieldText);
            }
        }

        if (fieldText.equals("0")){
            this.fieldClear = true;
        } else {
            this.fieldClear = false;
        }

        this.previousClick = ButtonTypeEnum.NUMERIC;
        System.out.println("visbileNumber: " + visibleNumber);
    }

    public void operationButtonPushed(OperationButton button, CalculatorFrame calculatorFrame) {
        System.out.println("OperationButtonPushed, Queued operation: [" + queuedOperation.toString()+ "]");
        if (button.getOperationEnum() == OperationEnum.ADD) {
            if (previousClick.equals(ButtonTypeEnum.NUMERIC) && !queuedOperation.equals(OperationEnum.NONE)) {
                executeQueuedOperation();
            }
            queuedOperation = OperationEnum.ADD;
        } else if (button.getOperationEnum() == OperationEnum.SUBTRACT) {
            if (previousClick.equals(ButtonTypeEnum.NUMERIC) && !queuedOperation.equals(OperationEnum.NONE)) {
                executeQueuedOperation();
            }
            queuedOperation = OperationEnum.SUBTRACT;
        } else if (button.getOperationEnum() == OperationEnum.MULTIPLY) {
            if (previousClick.equals(ButtonTypeEnum.NUMERIC) && !queuedOperation.equals(OperationEnum.NONE)) {
                executeQueuedOperation();
            }
            queuedOperation = OperationEnum.MULTIPLY;
        } else if (button.getOperationEnum() == OperationEnum.DIVIDE) {
            if (previousClick.equals(ButtonTypeEnum.NUMERIC) && !queuedOperation.equals(OperationEnum.NONE)) {
                executeQueuedOperation();
            }
            queuedOperation = OperationEnum.DIVIDE;
        } else if (button.getOperationEnum() == OperationEnum.EQUALS){
            executeQueuedOperation();
            queuedOperation = OperationEnum.EQUALS;
            previousClick = ButtonTypeEnum.OPERATION;
        } else if (button.getOperationEnum() == OperationEnum.PLUSMINUS){
                visibleNumber *= plusMinus;
        } else if (button.getOperationEnum() == OperationEnum.CLEAR){
            clearField(calculatorFrame);
            queuedOperation = OperationEnum.NONE;
        }
        storedNumber = visibleNumber;
        System.out.println("storedNumber: " + storedNumber);
        calculatorFrame.setAnsField(String.valueOf(visibleNumber));
        previousClick = ButtonTypeEnum.OPERATION;
    }

    private void executeQueuedOperation(){
        System.out.println("QueuedOperation: [" + queuedOperation.toString() + "]");
        printNumbers();
        switch(queuedOperation) {
            case ADD:
                storedNumber = addNumbers(visibleNumber, storedNumber);
                break;
            case SUBTRACT:
                storedNumber = subtractNumbers(visibleNumber, storedNumber);
                break;
            case MULTIPLY:
                storedNumber = multiplyNumbers(visibleNumber, storedNumber);
                break;
            case DIVIDE:
                storedNumber = divideNumbers(visibleNumber, storedNumber);
                break;
            default:
                //clearField();
                break;
        }
        System.out.println("Operation Results");
        printNumbers();
        // ansField.setText(String.valueOf(storedNumber));
        visibleNumber = storedNumber;
    }

    private Boolean isNumberZero(Double number) {
        return number == 0;
    }

    private Double multiplyNumbers(Double num1, Double num2) {
        return num1 * num2;
    }

    private Double addNumbers(Double num1, Double num2) {
        return num1 + num2;
    }

    private Double subtractNumbers(Double num1, Double num2) {
        return num2 - num1;
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
