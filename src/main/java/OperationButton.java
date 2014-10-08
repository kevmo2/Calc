import javax.swing.*;

/**
 * Created by kevimoore on 10/8/14.
 */
public class OperationButton extends JButton {

    private OperationEnum operationEnum;

    /**
     * Creates a button with text.
     *
     * @param text the text of the button
     * @param operationEnum
     */
    public OperationButton(String text, OperationEnum operationEnum) {
        super(text);

        this.operationEnum = operationEnum;
    }

    public ButtonTypeEnum returnButtonType() {
        return ButtonTypeEnum.OPERATION;
    }

    public OperationEnum getOperationEnum() {
        return operationEnum;
    }
}
