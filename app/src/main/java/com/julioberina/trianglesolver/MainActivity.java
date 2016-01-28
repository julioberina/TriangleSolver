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

public class MainActivity extends AppCompatActivity {

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
    }

    public void resetted(View v) {

        LinearLayout leftAnswers = (LinearLayout)findViewById(R.id.angles);
        LinearLayout rightAnswers = (LinearLayout)findViewById(R.id.sides);

        TextView leftA = (TextView)findViewById(R.id.Aanswer);
        TextView leftB = (TextView)findViewById(R.id.Banswer);
        TextView leftC = (TextView)findViewById(R.id.Canswer);
        TextView rightA = (TextView)findViewById(R.id.aanswer);
        TextView rightB = (TextView)findViewById(R.id.banswer);
        TextView rightC = (TextView)findViewById(R.id.canswer);

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
