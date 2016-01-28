package com.julioberina.trianglesolver;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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

        Button sb = (Button)findViewById(R.id.solveButton);
        Button rb = (Button)findViewById(R.id.resetButton);

        //Listener for Solve and Reset buttons
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.solveButton:
                        clicked(v);
                        break;
                    case R.id.resetButton:
                        resetted(v);
                        break;
                }
            }
        };

        sb.setOnClickListener(listener);
        rb.setOnClickListener(listener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    class Triangle {

        //solve for the unknown based on what's missing and what's given
        public Triangle(String unknown) {
            switch (unknown) {
                case "Cbc":
                    angleC = 180 - (angleA + angleB);
                    sideB = lawOfSines(angleB, sideB, angleA, sideA);
                    sideC = lawOfSines(angleC, sideC, angleA, sideA);
                    break;
                case "Cac":
                    angleC = 180 - (angleA + angleB);
                    sideA = lawOfSines(angleA, sideA, angleB, sideB);
                    sideC = lawOfSines(angleC, sideC, angleB, sideB);
                    break;
                case "Cab":
                    angleC = 180 - (angleA + angleB);
                    sideA = lawOfSines(angleA, sideA, angleC, sideC);
                    sideB = lawOfSines(angleB, sideB, angleC, sideC);
                    break;
                case "Bbc":
                    angleB = 180 - (angleA + angleC);
                    sideB = lawOfSines(angleB, sideB, angleA, sideA);
                    sideC = lawOfSines(angleC, sideC, angleA, sideA);
                    break;
                case "Bac":
                    angleB = 180 - (angleA + angleC);
                    sideA = lawOfSines(angleA, sideA, angleB, sideB);
                    sideC = lawOfSines(angleC, sideC, angleB, sideB);
                    break;
                case "Bab":
                    angleB = 180 - (angleA + angleC);
                    sideA = lawOfSines(angleA, sideA, angleC, sideC);
                    sideB = lawOfSines(angleB, sideB, angleC, sideC);
                    break;
                case "Abc":
                    angleA = 180 - (angleB + angleC);
                    sideB = lawOfSines(angleB, sideB, angleA, sideA);
                    sideC = lawOfSines(angleC, sideC, angleA, sideA);
                    break;
                case "Aac":
                    angleA = 180 - (angleB + angleC);
                    sideA = lawOfSines(angleA, sideA, angleB, sideB);
                    sideC = lawOfSines(angleC, sideC, angleB, sideB);
                    break;
                case "Aab":
                    angleA = 180 - (angleB + angleC);
                    sideA = lawOfSines(angleA, sideA, angleC, sideC);
                    sideB = lawOfSines(angleB, sideB, angleC, sideC);
                    break;
                case "BCc":
                    angleB = lawOfSines(angleB, sideB, angleA, sideA);
                    angleC = 180 - (angleA + angleB);
                    sideC = lawOfSines(angleC, sideC, angleA, sideA);
                    break;
                case "BCb":
                    angleC = lawOfSines(angleC, sideC, angleA, sideA);
                    angleB = 180 - (angleA + angleC);
                    sideB = lawOfSines(angleB, sideB, angleA, sideA);
                    break;
                case "BCa":
                    sideA = lawOfCosines(sideB, sideC, sideA, angleA);
                    angleB = lawOfSines(angleB, sideB, angleA, sideA);
                    angleC = 180 - (angleA + angleB);
                    break;
                case "ACc":
                    angleA = lawOfSines(angleA, sideA, angleB, sideB);
                    angleC = 180 - (angleA + angleB);
                    sideC = lawOfSines(angleC, sideC, angleB, sideB);
                    break;
                case "ACb":
                    sideB = lawOfCosines(sideA, sideC, sideB, angleB);
                    angleA = lawOfSines(angleA, sideA, angleB, sideB);
                    angleC = 180 - (angleA + angleB);
                    break;
                case "ACa":
                    angleC = lawOfSines(angleC, sideC, angleB, sideB);
                    angleA = 180 - (angleB + angleC);
                    sideA = lawOfSines(angleA, sideA, angleB, sideB);
                    break;
                case "ABc":
                    sideC = lawOfCosines(sideA, sideB, sideC, angleC);
                    angleA = lawOfSines(angleA, sideA, angleC, sideC);
                    angleB = 180 - (angleA + angleC);
                    break;
                case "ABb":
                    angleA = lawOfSines(angleA, sideA, angleC, sideC);
                    angleB = 180 - (angleA + angleC);
                    sideB = lawOfSines(angleB, sideB, angleC, sideC);
                    break;
                case "ABa":
                    angleB = lawOfSines(angleB, sideB, angleC, sideC);
                    angleA = 180 - (angleB + angleC);
                    sideA = lawOfSines(angleA, sideA, angleC, sideC);
                    break;
                case "ABC":
                    angleA = lawOfCosines(sideB, sideC, sideA, angleA);
                    angleB = lawOfSines(angleB, sideB, angleA, sideA);
                    angleC = 180 - (angleA + angleB);
                    break;
            }
        }

        //Law of Sines function
        double lawOfSines(double X, double x, double Y, double y) {

            double result = 0.0;

            if (X == 0)
                result = Math.asin(x * Math.sin(Y * Math.PI / 180.0) / y) * 180.0 / Math.PI;

            else if (x == 0)
                result = y * Math.sin(X * Math.PI / 180.0) / Math.sin(Y * Math.PI / 180.0);

            return result;
        }

        //Law of Cosines function
        double lawOfCosines(double x, double y, double z, double Z) {

            double result = 0.0;

            if (z == 0)
                result = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) - 2*x*y*Math.cos(Z * Math.PI / 180.0));

            else if (Z == 0)
                result = Math.acos((Math.pow(x, 2) + Math.pow(y, 2) - Math.pow(z, 2)) / 2*x*y) * 180.0 / Math.PI;

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
        if (unknown.length() > 3) {
            Toast error = Toast.makeText(this, "Not enough given", Toast.LENGTH_LONG);
            error.show();
        }

        else if (unknown.length() < 3) {
            Toast error = Toast.makeText(this, "Too many given", Toast.LENGTH_LONG);
            error.show();
        }

        else {
            //Solve the triangle based on unknown
            Triangle triangle = new Triangle(unknown);

            //Allow for modification of angles and sides answers
            leftA = (TextView)findViewById(R.id.Aanswer);
            leftB = (TextView)findViewById(R.id.Banswer);
            leftC = (TextView)findViewById(R.id.Canswer);
            rightA = (TextView)findViewById(R.id.aanswer);
            rightB = (TextView)findViewById(R.id.banswer);
            rightC = (TextView)findViewById(R.id.canswer);

            //Allow for modification of visibility of angles and sides
            leftAnswers = (LinearLayout)findViewById(R.id.angles);
            rightAnswers = (LinearLayout)findViewById(R.id.sides);

            //Add angles and sides to answers field
            leftA.setText("A:  " + String.format("%.4f", angleA));
            leftB.setText("B:  " + String.format("%.4f", angleB));
            leftC.setText("C:  " + String.format("%.4f", angleC));
            rightA.setText("a:  " + String.format("%.4f", sideA));
            rightB.setText("b:  " + String.format("%.4f", sideB));
            rightC.setText("c:  " + String.format("%.4f", sideC));

            //Make answers layout visible
            leftAnswers.setVisibility(View.VISIBLE);
            rightAnswers.setVisibility(View.VISIBLE);
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