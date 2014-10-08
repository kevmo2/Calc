import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kevimoore on 7/23/14.
 */
class NumericButton extends JButton{

    /**
     * Creates a button with text.
     *
     * @param text the text of the button
     */

    public NumericButton(String text) {

        super(text);

    }

    public ButtonTypeEnum returnButtonType() {
        return ButtonTypeEnum.NUMERIC;
    }

}
