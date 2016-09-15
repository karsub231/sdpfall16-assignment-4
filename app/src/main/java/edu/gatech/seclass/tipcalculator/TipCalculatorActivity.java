package edu.gatech.seclass.tipcalculator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TipCalculatorActivity extends AppCompatActivity {

    EditText etCheckAmount, etPartySize, etFifteenPercentTipValue,
            etTwentyPercentTipValue, etTwentyFivePercentTipValue,
            etFifteenPercentTotalValue, etTwentyPercentTotalValue, etTwentyFivePercentTotalValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        etCheckAmount = (EditText) findViewById(R.id.checkAmountValue);
        etPartySize = (EditText) findViewById(R.id.partySizeValue);
        etFifteenPercentTipValue = (EditText) findViewById(R.id.fifteenPercentTipValue);
        etTwentyPercentTipValue = (EditText) findViewById(R.id.twentyPercentTipValue);
        etTwentyFivePercentTipValue = (EditText) findViewById(R.id.twentyfivePercentTipValue);
        etFifteenPercentTotalValue = (EditText)findViewById(R.id.fifteenPercentTotalValue);
        etTwentyPercentTotalValue = (EditText)findViewById(R.id.twentyPercentTotalValue);
        etTwentyFivePercentTotalValue = (EditText)findViewById(R.id.twentyfivePercentTotalValue);
    }

    public void computeTip(View view) {

        etFifteenPercentTipValue.setText("");
        etTwentyPercentTipValue.setText("");
        etTwentyFivePercentTipValue.setText("");

        etFifteenPercentTotalValue.setText("");
        etTwentyPercentTotalValue.setText("");
        etTwentyFivePercentTotalValue.setText("");

        String checkAmountString = etCheckAmount.getText().toString();
        String partySizeString = etPartySize.getText().toString();
        if (checkAmountString == null || checkAmountString == "") {
            Context context = getApplicationContext();
            CharSequence text = "Empty or incorrect value(s)";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else {
            if (isNumeric(checkAmountString) && isNumeric(partySizeString)) {

                float amount = Float.parseFloat(checkAmountString);
                float partySize = Float.parseFloat(partySizeString);

                double fifteenPercentTip = Math.round((amount * 0.15) / partySize);
                double twentyPercentTip = Math.round((amount * 0.2) / partySize);
                double twentyFivePercentTip = Math.round((amount * 0.25) / partySize);

                double fifteenTotal = Math.round((amount ) / partySize + fifteenPercentTip);
                double twentyTotal = Math.round((amount ) / partySize+ twentyPercentTip);
                double twentyFiveTotal = Math.round((amount ) / partySize+ twentyFivePercentTip);

                etFifteenPercentTipValue.setText(Integer.toString((int)fifteenPercentTip));
                etTwentyPercentTipValue.setText(Integer.toString((int)twentyPercentTip));
                etTwentyFivePercentTipValue.setText(Integer.toString((int)twentyFivePercentTip));

                etFifteenPercentTotalValue.setText(Integer.toString((int)fifteenTotal));
                etTwentyPercentTotalValue.setText(Integer.toString((int)twentyTotal));
                etTwentyFivePercentTotalValue.setText(Integer.toString((int)twentyFiveTotal));
            }
            else{
                Context context = getApplicationContext();
                CharSequence text = "Empty or incorrect value(s)";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        }
    }

    private boolean isNumeric(String s) {
        return s.matches("\\d*\\.?\\d+");
    }
}
