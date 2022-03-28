package edu.uco.ythiam.p6younouss_t;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class BaseballActivity extends Activity {
    private Button buttonHint,buttonNew, buttonClear, button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    private int first, second, third, numberOfStrikes = 0, numberOfBalls = 0;
    private char  firstChar, secondChar, thirdChar;
    private String textField, guess ="";
    private TextView result;
    int alpha = 127;
    ArrayList<String> game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baseball);
        game = new ArrayList<String>();
        buttonNew = (Button) findViewById(R.id.buttonNew);
        buttonClear = (Button) findViewById(R.id.buttonClear);
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonHint = (Button) findViewById(R.id.buttonHint);
        buttonClear.setEnabled(false);
        disable();
        result = (TextView) findViewById(R.id.result);
        MyListener listen =  new MyListener();
        buttonNew.setOnClickListener(listen);
        buttonClear.setOnClickListener(listen);
        button0.setOnClickListener(listen);
        button1.setOnClickListener(listen);
        button2.setOnClickListener(listen);
        button3.setOnClickListener(listen);
        button4.setOnClickListener(listen);
        button5.setOnClickListener(listen);
        button6.setOnClickListener(listen);
        button7.setOnClickListener(listen);
        button8.setOnClickListener(listen);
        button9.setOnClickListener(listen);
        buttonHint.setOnClickListener(listen);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_baseball, menu);
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

    private class MyListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if(v == buttonNew) {
                guess = "";
                GridLayout rl = (GridLayout) findViewById(R.id.ballShape);
                GridLayout r2 = (GridLayout) findViewById(R.id.strikeShape);
                TextView balls = (TextView)findViewById(R.id.balls);
                balls.setText("");
                TextView strikes = (TextView)findViewById(R.id.strikes);
                strikes.setText("");
                if(rl.getChildCount() > 1){
                    rl.removeViews(1,rl.getChildCount() - 1);
                }
                if(r2.getChildCount() > 1){
                    r2.removeViews(1,r2.getChildCount() - 1);
            }

                buttonClear.setEnabled(true);
                button0.setEnabled(true);
                button1.setEnabled(true);
                button2.setEnabled(true);
                button3.setEnabled(true);
                button4.setEnabled(true);
                button5.setEnabled(true);
                button6.setEnabled(true);
                button7.setEnabled(true);
                button8.setEnabled(true);
                button9.setEnabled(true);
                first = (int) (Math.random() * 10);
                do {
                    second = (int) (Math.random() * 10);
                }
                while (second == first);
                do {
                    third = (int) (Math.random() * 10);
                }
                while (third == second || third == first);
                firstChar = Integer.toString(first).charAt(0);
                secondChar = Integer.toString(second).charAt(0);
                thirdChar = Integer.toString(third).charAt(0);
                textField = "key = " + firstChar + secondChar + thirdChar;
                String key= ""+ firstChar + secondChar + thirdChar;
                game.add( "Key = " + key + "\n" + "Guess Balls Strikes\n" + "  ");
                result.setText(textField);
            }
                if(v == button0){
                    guess = guess+"0";
                    result.setText(textField + " " + "|" + guess);
                    checkGuess();
                }
                if(v == button1){
                    guess = guess+"1";
                    result.setText(textField + " " + "|" + guess);
                    checkGuess();
                }
                if(v == button2){
                    guess = guess+"2";
                    result.setText(textField + " " + "|" + guess);
                    checkGuess();
                }
                if(v == button3){
                    guess = guess+"3";
                    result.setText(textField + " " + "|" + guess);
                    checkGuess();
                }
                if(v == button4){
                    guess = guess+"4";
                    result.setText(textField + " " + "|" + guess);
                    checkGuess();
                }
                if(v == button5){
                    guess =guess+"5";
                    result.setText(textField+" "+"|"+guess);
                    checkGuess();
                }
                if(v == button6){
                    guess = guess+"6";
                    result.setText(textField + " " + "|" + guess);
                    checkGuess();
                }
                if(v == button7){
                    guess =guess+"7";
                    result.setText(textField+" "+"|"+guess);
                    checkGuess();
                }
                if(v == button8){
                    guess = guess+"8";
                    result.setText(textField + " " + "|" + guess);
                    checkGuess();
                }
                if(v == button9){
                    guess =guess+"9";
                    result.setText(textField + " " + "|" + guess);
                    checkGuess();
                }
                if(v == buttonClear){
                    guess = "";
                    textField = "key = "+firstChar+secondChar+thirdChar;
                    result.setText(textField);
                    button0.setEnabled(true);
                    button1.setEnabled(true);
                    button2.setEnabled(true);
                    button3.setEnabled(true);
                    button4.setEnabled(true);
                    button5.setEnabled(true);
                    button6.setEnabled(true);
                    button7.setEnabled(true);
                    button8.setEnabled(true);
                    button9.setEnabled(true);
                    buttonClear.setEnabled(false);
                    TextView balls = (TextView)findViewById(R.id.balls);
                    balls.setText("");
                    TextView strikes = (TextView)findViewById(R.id.strikes);
                    strikes.setText("");
                    GridLayout rl = (GridLayout) findViewById(R.id.ballShape);
                    GridLayout r2 = (GridLayout) findViewById(R.id.strikeShape);
                    if(rl.getChildCount() > 1){
                        rl.removeViews(1,rl.getChildCount() - 1);
                    }
                    if(r2.getChildCount() > 1){
                        r2.removeViews(1,r2.getChildCount() - 1);
                    }
                }
                if(v == buttonHint){

                    Intent intent = new Intent(BaseballActivity.this, GuessHintActivity.class);

                        Bundle bundle = new Bundle();

                    bundle.putStringArrayList("game", game);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    }

                }
            }


    void checkGuess(){
        if(guess.length() == 3){
            numberOfStrikes();
            numberOfBalls();
            game.add(guess + "     " + Integer.toString(numberOfBalls) + "       " + Integer.toString(numberOfStrikes) + "\n");
            result.setText(textField + " " + "|" + guess + " " + "|" + "B = " + numberOfBalls + " S = " + numberOfStrikes);
            TextView balls = (TextView)findViewById(R.id.balls);
            balls.setTextColor(Color.BLUE);
            balls.setText("Balls:");
            for(int i = 0; i < numberOfBalls; i++){
                int width = (int)getResources().getDimension(R.dimen.image_width);
                int height = (int)getResources().getDimension(R.dimen.image_height);
                int padding = (int) getResources().getDimension(R.dimen.padding);

                GridLayout rl = (GridLayout) findViewById(R.id.ballShape);
                ShapeDrawable cyanShape = new ShapeDrawable(new OvalShape());
                cyanShape.getPaint().setColor(Color.BLUE);
                cyanShape.setIntrinsicHeight(height);
                cyanShape.setIntrinsicWidth(width);
                cyanShape.setAlpha(alpha);

                ImageView cyanView = new ImageView(getApplicationContext());
                cyanView.setImageDrawable(cyanShape);
                cyanView.setPadding(padding, padding, padding, padding);

                RelativeLayout.LayoutParams cyanViewLayoutParams = new RelativeLayout.LayoutParams(height, width);
                cyanView.setLayoutParams(cyanViewLayoutParams);
                rl.addView(cyanView);

            }
            TextView strikes = (TextView)findViewById(R.id.strikes);
            strikes.setTextColor(Color.RED);
            strikes.setText("Strikes:");
            for(int i = 0; i < numberOfStrikes; i++){
                int width = (int)getResources().getDimension(R.dimen.image_width);
                int height = (int)getResources().getDimension(R.dimen.image_height);
                int padding = (int) getResources().getDimension(R.dimen.padding);

                GridLayout rl = (GridLayout) findViewById(R.id.strikeShape);
                ShapeDrawable cyanShape = new ShapeDrawable(new OvalShape());
                cyanShape.getPaint().setColor(Color.RED);
                cyanShape.setIntrinsicHeight(height);
                cyanShape.setIntrinsicWidth(width);
                cyanShape.setAlpha(alpha);

                ImageView cyanView = new ImageView(getApplicationContext());
                cyanView.setImageDrawable(cyanShape);
                cyanView.setPadding(padding, padding, padding, padding);

                RelativeLayout.LayoutParams cyanViewLayoutParams = new RelativeLayout.LayoutParams(height, width);
                cyanView.setLayoutParams(cyanViewLayoutParams);
                rl.addView(cyanView);

            }
            guess = "";
            numberOfStrikes = 0;
            numberOfBalls = 0;
            disable();

            buttonClear.setEnabled(true);
        }
    }
    void numberOfStrikes(){
        if(firstChar == guess.charAt(0)){
            numberOfStrikes++;
        }
        if(secondChar == guess.charAt(1)){
            numberOfStrikes++;
        }
        if(thirdChar == guess .charAt(2)){
            numberOfStrikes++;
        }
    }
    void numberOfBalls(){
        if(firstChar == guess.charAt(1) || firstChar == guess.charAt(2)){
            numberOfBalls++;
        }
        if(secondChar == guess.charAt(0) || secondChar == guess.charAt(2)){
            numberOfBalls++;
        }
        if(thirdChar == guess.charAt(0) || thirdChar == guess.charAt(1)){
            numberOfBalls++;
        }
    }
    void disable(){
        button0.setEnabled(false);
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);
        button5.setEnabled(false);
        button6.setEnabled(false);
        button7.setEnabled(false);
        button8.setEnabled(false);
        button9.setEnabled(false);
    }
}


