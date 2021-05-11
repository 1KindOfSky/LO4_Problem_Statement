package sg.edu.rp.c346.id20029443.lo4problemstatement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText editName;
    EditText editNumber;
    EditText editPax;
    CheckBox checkSmoking;
    TimePicker timePicker;
    DatePicker datePicker;
    Button reserveBtn;
    Button resetBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editName);
        editNumber = findViewById(R.id.editNumber);
        editPax = findViewById(R.id.editPax);
        checkSmoking = findViewById(R.id.checkSmoke);
        timePicker = findViewById(R.id.timePicker);
        datePicker = findViewById(R.id.datePicker);
        reserveBtn = findViewById(R.id.reserveBtn);
        resetBtn = findViewById(R.id.resetBtn);


       reserveBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {



               String message = "";

               if(editName.getText().toString().trim().length() != 0 && editNumber.getText().toString().trim().length() != 0 && editPax.getText().toString().trim().length() !=0) {

                   if (Integer.parseInt(editPax.getText().toString()) < 1 || Integer.parseInt(editPax.getText().toString()) > 5) {
                       Toast.makeText(MainActivity.this, "Total pax has to be between 1 to 5" ,Toast.LENGTH_LONG).show();
                   }

                   else {
                       message += "Name: " + editName.getText().toString() + "\n";
                       message += "Number: " + editNumber.getText().toString() + "\n";
                       message += "Pax: " + editPax.getText().toString() + "\n";

                       if (checkSmoking.isChecked()) {
                           message += "You have selected the smoking area.\n";
                       }

                       else {
                           message += "You have not selected the smoking area. \n";
                       }

                       message += "Date: " + datePicker.getDayOfMonth() + "/" + datePicker.getMonth() + "/" + datePicker.getYear() + "\n";
                       DecimalFormat df = new DecimalFormat("00");
                       message += "Time: " + timePicker.getCurrentHour() + ":" + df.format(timePicker.getCurrentMinute());

                       Toast.makeText(MainActivity.this, message ,Toast.LENGTH_LONG).show();
                   }

               }


               else {
                   if (editName.getText().toString().trim().length() == 0) {
                       Toast.makeText(MainActivity.this, "Name Field Is Compulsory" ,Toast.LENGTH_LONG).show();
                   }

                   else if (editNumber.getText().toString().trim().length() == 0) {
                       Toast.makeText(MainActivity.this, "Number Field Is Compulsory" ,Toast.LENGTH_LONG).show();
                   }

                   else {
                       Toast.makeText(MainActivity.this, "Pax Field Is Compulsory" ,Toast.LENGTH_LONG).show();
                   }
               }
           }
       });

       timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
           @Override
           public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
               if (timePicker.getCurrentHour() < 8) {
                   timePicker.setCurrentHour(8);
                   Toast.makeText(MainActivity.this, "We are only opened at 8AM" ,Toast.LENGTH_LONG).show();
               }
               else if (timePicker.getCurrentHour() > 20) {
                   timePicker.setCurrentHour(20);
                   Toast.makeText(MainActivity.this, "We are closed at 9PM" ,Toast.LENGTH_LONG).show();
               }
           }
       });

       resetBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               timePicker.setCurrentHour(19);
               timePicker.setCurrentMinute(30);

               datePicker.updateDate(2020,5,1);
           }
       });
    }
}