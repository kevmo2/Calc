import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kevimoore on 10/8/14.
 */
public class OperationButtonListener implements ActionListener {

    private ButtonTypeEnum operationEnum;

    private String operationValue;




    public OperationButtonListener(OperationButton button) {

        operationEnum = button.returnButtonType();

        operationValue = button.getText();
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Operation pushed: [" + operationValue +"]");
    }
}
