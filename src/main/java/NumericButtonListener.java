import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kevimoore on 10/8/14.
 *
 */
public class NumericButtonListener implements ActionListener {

    private ButtonTypeEnum buttonType;

    private String buttonValue;

    private CalculatorController controller;

    private CalculatorFrame calculatorFrame;

    public NumericButtonListener(NumericButton button, CalculatorController controller, CalculatorFrame calculatorFrame) {

        buttonType = button.returnButtonType();

        buttonValue = button.getText();

        this.controller = controller;

        this.calculatorFrame = calculatorFrame;

    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Number pushed: [" + buttonValue +"]");
        controller.numericButtonPushed((NumericButton) e.getSource(), calculatorFrame);
    }
}
