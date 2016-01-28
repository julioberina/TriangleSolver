package com.julioberina.trianglesolver;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LinearLayout leftAnswers;
    private LinearLayout rightAnswers;
    private TextView leftA;
    private TextView leftB;
    private TextView leftC;
    private TextView rightA;
    private TextView rightB;
    private TextView rightC;
    private EditText AText;
    private EditText BText;
    private EditText CText;
    private EditText atext;
    private EditText btext;
    private EditText ctext;
    private double angleA;
    private double angleB;
    private double angleC;
    private double sideA;
    private double sideB;
    private double sideC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private class Triangle {

        //solve for the unknown based on what's missing and what's given
        public Triangle(String unknown) {
            switch (unknown) {
                case "Cbc":
                    angleC = angleA + angleB;
                    sideB = lawOfSines(angleB, sideB, angleA, sideA);
                    sideC = lawOfSines(angleC, sideC, angleA, sideA);
                    break;
                case "Cac":
                    break;
            }
        }

        //Law of Sines function
        double lawOfSines(double X, double x, double Y, double y) {

            double result = 0.0;

            if (X == 0) {
                result = Math.asin(x * Math.sin(Y * Math.PI / 180.0) / y) * 180.0 / Math.PI;
            }

            else if (x == 0) {
                result = y * Math.sin(X * Math.PI / 180.0) / Math.sin(Y * Math.PI / 180.0);
            }

            return result;
        }

        //Law of Cosines function
        double lawOfCosines(double x, double y, double z, double Z) {

            double result = 0.0;

            if (z == 0) {
                result = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) - 2*x*y*Math.cos(Z * Math.PI / 180.0));
            }

            else if (Z == 0) {
                result = Math.acos((Math.pow(x, 2) + Math.pow(y, 2) - Math.pow(z, 2)) / 2*x*y) * 180.0 / Math.PI;
            }

            return result;
        }
    }

    public void clicked(View v) {

        String unknown = "";
        AText = (EditText)findViewById(R.id.Afield);
        BText = (EditText)findViewById(R.id.Bfield);
        CText = (EditText)findViewById(R.id.Cfield);
        atext = (EditText)findViewById(R.id.afield);
        btext = (EditText)findViewById(R.id.bfield);
        ctext = (EditText)findViewById(R.id.cfield);

        //Angle A
        try { angleA = Double.parseDouble(AText.getText().toString()); }
        catch (Exception e) { angleA = 0; unknown += "A"; }

        //Angle B
        try { angleB = Double.parseDouble(BText.getText().toString()); }
        catch (Exception e) { angleB = 0; unknown += "B"; }

        //Angle C
        try { angleC = Double.parseDouble(CText.getText().toString()); }
        catch (Exception e) { angleC = 0; unknown += "C"; }

        //Side A
        try { sideA = Double.parseDouble(atext.getText().toString()); }
        catch (Exception e) { sideA = 0; unknown += "a"; }

        //Side B
        try { sideB = Double.parseDouble(btext.getText().toString()); }
        catch (Exception e) { sideB = 0; unknown += "b"; }

        //Side C
        try { sideC = Double.parseDouble(ctext.getText().toString()); }
        catch (Exception e) { sideC = 0; unknown += "c"; }

        //Solve the triangle based on the unknown
        if (unknown.length() < 3) {
            Toast error = Toast.makeText(this, "Not enough given", Toast.LENGTH_LONG);
            error.show();
        }
        else if (unknown.length() > 3) {
            Toast error = Toast.makeText(this, "Too many given", Toast.LENGTH_LONG);
            error.show();
        }
        else {

        }
    }

    public void resetted(View v) {

        leftAnswers = (LinearLayout)findViewById(R.id.angles);
        rightAnswers = (LinearLayout)findViewById(R.id.sides);

        leftA = (TextView)findViewById(R.id.Aanswer);
        leftB = (TextView)findViewById(R.id.Banswer);
        leftC = (TextView)findViewById(R.id.Canswer);
        rightA = (TextView)findViewById(R.id.aanswer);
        rightB = (TextView)findViewById(R.id.banswer);
        rightC = (TextView)findViewById(R.id.canswer);

        AText = (EditText)findViewById(R.id.Afield);
        BText = (EditText)findViewById(R.id.Bfield);
        CText = (EditText)findViewById(R.id.Cfield);
        atext = (EditText)findViewById(R.id.afield);
        btext = (EditText)findViewById(R.id.bfield);
        ctext = (EditText)findViewById(R.id.cfield);

        //Set all EditText fields to empty strings
        AText.setText("");
        BText.setText("");
        CText.setText("");
        atext.setText("");
        btext.setText("");
        ctext.setText("");

        //Make answer field layouts invisible and erase answers beside angle/side label
        leftAnswers.setVisibility(View.INVISIBLE);
        rightAnswers.setVisibility(View.INVISIBLE);
        leftA.setText("A:  ");
        leftB.setText("B:  ");
        leftC.setText("C:  ");
        rightA.setText("a:  ");
        rightB.setText("b:  ");
        rightC.setText("c:  ");

        //Set all doubles back to zero
        angleA = angleB = angleC = 0.0;
        sideA = sideB = sideC = 0.0;
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