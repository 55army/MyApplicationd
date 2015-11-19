package SecondActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import myapplication.myapplication.MainActivity;
import myapplication.myapplication.R;

/*
 * Created by com on 2015-11-19.
 */
public class SecondActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newactivity);
        setTitle("SecondActivity");

        Intent inIntent = getIntent();

        String calc = (inIntent.getStringExtra("Calc"));

        int calValue=0;
        if(calc.equals("+")){
            calValue=inIntent.getIntExtra("Num1",0)
                    +inIntent.getIntExtra("Num2",0);
        }
        else if(calc.equals("-")) {
            calValue = inIntent.getIntExtra("Num1", 0)
                    -inIntent.getIntExtra("Num2", 0);
        }
        else if(calc.equals("*")) {
            calValue = inIntent.getIntExtra("Num1", 0)
                    *inIntent.getIntExtra("Num2", 0);
        }
        else {
            calValue = inIntent.getIntExtra("Num1", 0)
                    /inIntent.getIntExtra("Num2", 0);


        }
        final int retValue=calValue;

        Button btnReturn=(Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent outIntent=new Intent(getApplicationContext(),
                        MainActivity.class);
                outIntent.putExtra("Hap",retValue);
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });
    }

}
