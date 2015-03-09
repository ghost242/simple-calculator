package homework.mobile.simiple_calculator;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    EditText formula;
    EditText result;
    TextView []keypad_btn;
    TextView submit_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        formula = (EditText)findViewById(R.id.formula);
        result = (EditText)findViewById(R.id.result);

        keypad_btn = new TextView[14];

        keypad_btn[0] = (TextView)findViewById(R.id.num0);
        keypad_btn[1] = (TextView)findViewById(R.id.num1);
        keypad_btn[2] = (TextView)findViewById(R.id.num2);
        keypad_btn[3] = (TextView)findViewById(R.id.num3);
        keypad_btn[4] = (TextView)findViewById(R.id.num4);
        keypad_btn[5] = (TextView)findViewById(R.id.num5);
        keypad_btn[6] = (TextView)findViewById(R.id.num6);
        keypad_btn[7] = (TextView)findViewById(R.id.num7);
        keypad_btn[8] = (TextView)findViewById(R.id.num8);
        keypad_btn[9] = (TextView)findViewById(R.id.num9);
        keypad_btn[10] = (TextView)findViewById(R.id.plus);
        keypad_btn[11] = (TextView)findViewById(R.id.minus);
        keypad_btn[12] = (TextView)findViewById(R.id.multi);
        keypad_btn[13] = (TextView)findViewById(R.id.divide);

        for ( TextView button:keypad_btn)
        {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView tmp_text = (TextView)v;
                    String text = formula.getText().toString();
                    text = text + tmp_text.getText().toString();
                    formula.setText(text);
                }
            });
        }

        submit_btn = (TextView)findViewById(R.id.submit);

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculator calc = new Calculator(formula.toString());

                calc.operation();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
