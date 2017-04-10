package com.example.serwis.gamesofthronesquizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static android.R.attr.duration;

public class MainActivity extends AppCompatActivity {

    RadioButton radio1;
    RadioButton radio2;
    RadioButton radio3;
    RadioButton radio4;
    RadioButton radio5;
    RadioButton radio6;
    RadioButton radio7;
    RadioButton radio8;
    RadioButton radio9;
    RadioButton radio10;
    RadioButton radio11;
    RadioButton radio12;

    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;

    int stark;
    int lannister;
    int tar;
    int baratheon;

    String name;
    String family;
    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        radio1 = (RadioButton) (findViewById(R.id.radio1));
        radio2 = (RadioButton) (findViewById(R.id.radio2));
        radio3 = (RadioButton) (findViewById(R.id.radio3));
        radio4 = (RadioButton) (findViewById(R.id.radio4));
        radio5 = (RadioButton) (findViewById(R.id.radio5));
        radio6 = (RadioButton) (findViewById(R.id.radio6));
        radio7 = (RadioButton) (findViewById(R.id.radio7));
        radio8 = (RadioButton) (findViewById(R.id.radio8));
        radio9 = (RadioButton) (findViewById(R.id.radio9));
        radio10 = (RadioButton) (findViewById(R.id.radio10));
        radio11 = (RadioButton) (findViewById(R.id.radio11));
        radio12 = (RadioButton) (findViewById(R.id.radio12));

        checkBox1 = (CheckBox) findViewById(R.id.check1);
        checkBox2 = (CheckBox) findViewById(R.id.check2);
        checkBox3 = (CheckBox) findViewById(R.id.check3);

        text = (EditText) findViewById(R.id.name);

    }
    void getName (){
        name=text.getText().toString();
    }
    void Check (){
        stark = 0;
        if (radio1.isChecked()) stark += 1;
        if (radio6.isChecked()) stark += 1;
        if (radio12.isChecked()) stark += 1;
        if (checkBox2.isChecked()) stark +=1;

        lannister = 0;
        if (radio2.isChecked()) lannister +=1;
        if (radio5.isChecked()) lannister +=1;
        if (radio9.isChecked()) lannister +=1;
        if (checkBox1.isChecked()) lannister +=1;

        tar = 0;
        if (radio3.isChecked()) tar +=1;
        if (radio7.isChecked()) tar +=1;
        if (radio10.isChecked()) tar +=1;
        if (checkBox2.isChecked()) tar +=1;
        if (checkBox3.isChecked()) tar +=1;

        baratheon = 0;
        if (radio4.isChecked()) baratheon +=1;
        if (radio8.isChecked()) baratheon +=1;
        if (radio11.isChecked()) baratheon +=1;
        if (checkBox2.isChecked()) baratheon +=1;
        if (checkBox3.isChecked()) baratheon +=1;
    }
    void Score (View view) {
        Check();
        family = "";
        int[] tablica = {stark, lannister, baratheon, tar};
        int max = tablica[0];
        for (int i = 1; i < tablica.length; i++) {
            if (max < tablica[i]) max = tablica[i];
        }
        getName();
        if (max>1) {
        if (max == stark) {
            if (family.equals("")) family = "Stark";
            else family += " or Stark";
        }
        if (max == lannister) {
            if (family.equals("")) family = "Lannister";
            else family += " or Lannister";
        }
        if (max == baratheon) {
            if (family.equals("")) family = "Baratheon";
            else family += " or Baratheon";
        }
        if (max == tar) {
            if (family.equals("")) family = "Targaryen";
            else family += " or Targaryen";
        }
        if (!name.equals("")){
        Toast toast = Toast.makeText(getApplicationContext(), "Thank you, kind "+name+"! I think that you come from family "+family, Toast.LENGTH_LONG);
        toast.show();}
        else{
            Toast toast = Toast.makeText(getApplicationContext(), "I think that you come from family "+family, Toast.LENGTH_LONG);
            toast.show();
        }
    }

}
}
