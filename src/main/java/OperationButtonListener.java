import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kevimoore on 10/8/14.
 */
public class OperationButtonListener implements ActionListener {

    private ButtonTypeEnum operationEnum;

    private String operationValue;

    private CalculatorController controller;

    private CalculatorFrame calculatorFrame;

    public OperationButtonListener(OperationButton button, CalculatorController controller, CalculatorFrame calculatorFrame) {

        operationEnum = button.returnButtonType();

        operationValue = button.getText();

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
        System.out.println("Operation pushed: [" + operationValue +"]");
        controller.operationButtonPushed((OperationButton) e.getSource(), calculatorFrame);
    }
}
