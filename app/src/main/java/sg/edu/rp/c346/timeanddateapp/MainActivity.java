package sg.edu.rp.c346.timeanddateapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button btnDisplayDate, btnDisplayTime, btnReset;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind UI Components //
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnDisplayDate = findViewById(R.id.buttonDisplayDate);
        btnDisplayTime = findViewById(R.id.buttonDisplayTime);
        btnReset = findViewById(R.id.buttonReset);
        tvDisplay = findViewById(R.id.textViewDisplay);

        // Handle User button press //
        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dateYear = String.valueOf(dp.getYear());
                String dateMonth = String.valueOf(dp.getMonth()+1);
                String dateDayOfMonth = String.valueOf(dp.getDayOfMonth());

                String dateConcat = dateDayOfMonth + "/" + dateMonth + "/" + dateYear;
                tvDisplay.setText("Date is "+dateConcat);
            }
        });

        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String timeHour = tp.getCurrentHour().toString();
                String timeMinute = tp.getCurrentMinute().toString();
                String timeConcat = timeHour + ":" + timeMinute;

                tvDisplay.setText("Time is " + timeConcat);

            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvDisplay.setText("");

                tp.setCurrentHour(0);
                tp.setCurrentMinute(0);

                dp.updateDate(2019,0,1);
            }
        });

    }
}
