import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kevimoore on 10/8/14.
 *
 */
public class NumericButtonListener implements ActionListener {

    private ButtonTypeEnum buttonType;

    private String buttonValue;

    public NumericButtonListener(NumericButton button) {

        buttonType = button.returnButtonType();

        buttonValue = button.getText();

    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Number pushed: [" + buttonValue +"]");
    }
}
