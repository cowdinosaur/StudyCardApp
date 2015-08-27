package com.akmal.studycardapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CardActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        Intent i = getIntent();
        final StudyCard card = i.getParcelableExtra("study card");

        TextView questionText = (TextView) findViewById(R.id.question_text);
        Button choiceABtn = (Button) findViewById(R.id.choice_a_btn);
        Button choiceBBtn = (Button) findViewById(R.id.choice_b_btn);
        Button choiceCBtn = (Button) findViewById(R.id.choice_c_btn);
        Button choiceDBtn = (Button) findViewById(R.id.choice_d_btn);

        questionText.setText(card.question);
        choiceABtn.setText(card.choices[0]);
        choiceBBtn.setText(card.choices[1]);
        choiceCBtn.setText(card.choices[2]);
        choiceDBtn.setText(card.choices[3]);

        choiceABtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (card.answerIndex == 0) {
                    Toast.makeText(getApplicationContext(), "RIGHT!!!",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "WRONG!!!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_card, menu);
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
