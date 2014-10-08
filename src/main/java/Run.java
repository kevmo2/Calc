/**
 * Created by kevin on 7/10/14.
 */
public class Run {

    static CalculatorController controller = new CalculatorController();

    static CalculatorFrame c = new CalculatorFrame(controller);

    public static void main(String[] args) {
        c.setVisible(true);
    }

}
