import javax.swing.*;

/**
 * Created by kevimoore on 10/8/14.
 */
public class OperationButton extends JButton {

    /**
     * Creates a button with text.
     *
     * @param text the text of the button
     */
    public OperationButton(String text) {
        super(text);
    }

    public ButtonTypeEnum returnButtonType() {
        return ButtonTypeEnum.OPERATION;
    }

}
