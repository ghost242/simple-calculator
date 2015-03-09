package homework.mobile.simiple_calculator;

import java.util.Stack;

/**
 * Created by User on 2015-03-09.
 * This class is calculator. It makes a result from formula string.
 * Method
 *  formula parser : read input formula, and change pre-order formula, stack by token.
 *  operation : this method makes a result from formula in the stack
 */
public class Calculator {
    Calculator(String input_formula) { formula = input_formula; }

    private void parseFormula()
    {

    }
    public int operation()
    {
        int result = 0;
        parseFormula();

        return result;
    }

    private String formula;
    private Stack<String> op_stack;
}
