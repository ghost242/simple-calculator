package homework.mobile.simiple_calculator;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    EditText value1;
    EditText value2;
    EditText result;
    TextView setval1_btn;
    TextView setval2_btn;
    TextView result_btn;
    TextView []keypad_btn;
    TextView submit_btn;

    Button reset;

    View cur_view;
    int operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cur_view = null;

        value1 = (EditText)findViewById(R.id.value1);
        value2 = (EditText)findViewById(R.id.value2);
        result = (EditText)findViewById(R.id.result);

        reset = (Button)findViewById(R.id.reset);

        setval1_btn = (TextView)findViewById(R.id.set_val1);
        setval2_btn = (TextView)findViewById(R.id.set_val2);
        result_btn = (TextView)findViewById(R.id.set_result);

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

        setval1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cur_view = value1;
            }
        });

        setval2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cur_view = value2;
            }
        });

        for ( int i = 0; i <  10; i ++)
        {
            keypad_btn[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ( cur_view == null )
                        return ;

                    TextView tmp_text = (TextView)v;
                    EditText tmp_edit = (EditText)cur_view;

                    String text = tmp_edit.getText().toString();
                    text = text + tmp_text.getText().toString();
                    tmp_edit.setText(text);
                }
            });
        }

        for ( int i = 10; i < 14; i++) {
            keypad_btn[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView text = (TextView) v;
                    if (text.getText().toString().compareTo(String.valueOf("+")) == 0) {
                        operator = 0;
                    } else if (text.getText().toString().compareTo(String.valueOf("-")) == 0) {
                        operator = 1;
                    } else if (text.getText().toString().compareTo(String.valueOf("*")) == 0) {
                        operator = 2;
                    } else if (text.getText().toString().compareTo(String.valueOf("/")) == 0) {
                        operator = 3;
                    }
                }
            });
        }

        reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                value1.setText("");
                value2.setText("");
                result.setText("");
            }
        });

        submit_btn = (TextView)findViewById(R.id.submit);

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int val1 = Integer.parseInt(value1.getText().toString());
                int val2 = Integer.parseInt(value2.getText().toString());
                int res = 0;

                if ( operator == 0){
                    res = val1+val2;
                }
                else if ( operator == 1){
                    res = val1-val2;
                }
                else if ( operator == 2){
                    res = val1*val2;
                }
                else if( operator == 3){
                    if ( val2 != 0)
                        res = val1/val2;
                    else
                        res = 0;
                }
                result.setText(String.valueOf(res), TextView.BufferType.NORMAL);
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
