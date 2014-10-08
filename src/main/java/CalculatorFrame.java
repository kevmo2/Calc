import javax.swing.*;
import java.awt.*;

/**
 * Created by kevin on 7/10/14.
 */
public class CalculatorFrame extends JFrame //implements ActionListener
{

    private JPanel panel;
    static OperationButton equalsButton, addButton, subButton, multiButton, divButton, clearButton, plusMinusButton;
    static NumericButton oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton, eightButton, nineButton, zeroButton, decimalButton;
    private static JTextField ansField;
    private double visibleNumber, storedNumber;
    private double plusMinus;
    private Boolean fieldClear;


    private OperationEnum queuedOperation;
    private ButtonTypeEnum previousClick;

    public CalculatorFrame() {

        //Ensure that the application actually closes
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Calculator");
        setResizable(false);
        setSize(230, 370);
        setLocationRelativeTo(null); //null ensures its in the middle of the screen

        //instantiate panel
        panel = new JPanel();
        panel.setSize(230, 370);
        panel.setLayout(null);

        //setup buttons
        addButton = new OperationButton("+");
        addButton.setSize(50, 50);
        addButton.setLocation(170, 175);
        subButton = new OperationButton("-");
        subButton.setSize(50, 50);
        subButton.setLocation(170, 120);
        multiButton = new OperationButton("*");
        multiButton.setSize(50, 50);
        multiButton.setLocation(170, 65);
        divButton = new OperationButton("/");
        divButton.setSize(50, 50);
        divButton.setLocation(115, 65);
        equalsButton = new OperationButton("=");
        equalsButton.setSize(50, 105);
        equalsButton.setLocation(170, 230);
        zeroButton = new NumericButton("0");
        zeroButton.setSize(105, 50);
        zeroButton.setLocation(5, 285);
        oneButton = new NumericButton("1");
        oneButton.setSize(50, 50);
        oneButton.setLocation(5, 230);
        twoButton = new NumericButton("2");
        twoButton.setSize(50, 50);
        twoButton.setLocation(60, 230);
        threeButton = new NumericButton("3");
        threeButton.setSize(50, 50);
        threeButton.setLocation(115, 230);
        fourButton = new NumericButton("4");
        fourButton.setSize(50, 50);
        fourButton.setLocation(5, 175);
        fiveButton = new NumericButton("5");
        fiveButton.setSize(50, 50);
        fiveButton.setLocation(60, 175);
        sixButton = new NumericButton("6");
        sixButton.setSize(50, 50);
        sixButton.setLocation(115, 175);
        sevenButton = new NumericButton("7");
        sevenButton.setSize(50, 50);
        sevenButton.setLocation(5, 120);
        eightButton = new NumericButton("8");
        eightButton.setSize(50, 50);
        eightButton.setLocation(60, 120);
        nineButton = new NumericButton("9");
        nineButton.setSize(50, 50);
        nineButton.setLocation(115, 120);
        clearButton = new OperationButton("C");
        clearButton.setSize(50, 50);
        clearButton.setLocation(5, 65);
        decimalButton = new NumericButton(".");
        decimalButton.setSize(50, 50);
        decimalButton.setLocation(115, 285);
        plusMinusButton = new OperationButton("+/-");
        plusMinusButton.setSize(50, 50);
        plusMinusButton.setLocation(60, 65);
        ansField = new JTextField();
        ansField.setSize(215, 50);
        ansField.setLocation(5, 10);
        ansField.setFont(new Font("Arial", Font.BOLD, 24));
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
        zeroButton.addActionListener(new NumericButtonListener(zeroButton));
        oneButton.addActionListener(new NumericButtonListener(oneButton));
        twoButton.addActionListener(new NumericButtonListener(twoButton));
        threeButton.addActionListener(new NumericButtonListener(threeButton));
        fourButton.addActionListener(new NumericButtonListener(fourButton));
        fiveButton.addActionListener(new NumericButtonListener(fiveButton));
        sixButton.addActionListener(new NumericButtonListener(sixButton));
        sevenButton.addActionListener(new NumericButtonListener(sevenButton));
        eightButton.addActionListener(new NumericButtonListener(eightButton));
        nineButton.addActionListener(new NumericButtonListener(nineButton));
        addButton.addActionListener(new OperationButtonListener(addButton));
        subButton.addActionListener(new OperationButtonListener(subButton));
        multiButton.addActionListener(new OperationButtonListener(multiButton));
        divButton.addActionListener(new OperationButtonListener(divButton));
        clearButton.addActionListener(new OperationButtonListener(clearButton));
        decimalButton.addActionListener(new NumericButtonListener(decimalButton));
        plusMinusButton.addActionListener(new OperationButtonListener(plusMinusButton));
        equalsButton.addActionListener(new OperationButtonListener(equalsButton));
        plusMinus = -1;
        storedNumber = 0;
        visibleNumber = 0;
        fieldClear = true;
        queuedOperation = OperationEnum.NONE;
        previousClick = ButtonTypeEnum.START;

    }

    public static String getAnsField() {
        return ansField.getText();
    }

    public static void setAnsField(String ansField) {
        CalculatorFrame.ansField.setText(ansField);
    }
}