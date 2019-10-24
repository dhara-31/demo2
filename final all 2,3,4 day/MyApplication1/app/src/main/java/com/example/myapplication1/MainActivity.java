package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    CheckBox dance,play,read;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dance=(CheckBox)findViewById(R.id.dancing);
        play=(CheckBox)findViewById(R.id.playing);
        read=(CheckBox)findViewById(R.id.reading);
        final EditText useredit = (EditText) findViewById(R.id.useredit);
         final Button dispalyName = (Button) findViewById(R.id.displaybutton);
         final TextView setusername = (TextView) findViewById(R.id.setusername);
         final ImageButton submitbutton = (ImageButton) findViewById(R.id.imageButton);
         RadioGroup radiogroup =(RadioGroup) findViewById(R.id.radioGroup);
        SeekBar seekBar=(SeekBar)findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            int value=0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            value = progress;
        }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            Toast.makeText(MainActivity.this, "Seek bar progress is :" + value,
                    Toast.LENGTH_SHORT).show();
        }

        });



        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        List<String> education = new ArrayList<String>();
        education.add("B.E");
        education .add("Diploma");
        education.add("M.E");
        education.add("P.h.d");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,education);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

       /* dispalyName.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                setusername.setText(useredit.getText());


                if (useredit.getText().toString() != null) {
                    Toast.makeText(getApplicationContext(), useredit.getText().toString(), Toast.LENGTH_LONG).show();

                }
            }
        });*/

        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                Toast.makeText(getApplicationContext(),"you select..."+radioButton.getText(),Toast.LENGTH_LONG).show();

            }
        });
    }


    public void checkHobbies(View v)
    {
        String msg="";

        if(dance.isChecked())
            msg = msg + " Dancing";
        if(play.isChecked())
            msg = msg + "Playing ";
        if(read.isChecked())
            msg = msg + "Reading ";
    Toast.makeText(this,   msg +"are selected",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String item = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
    }

}