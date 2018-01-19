package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 public int goodScore =0;
 public int wrongScore =0;
 public int noScore =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


public void display(){
String messageText ="";

EditText UserName = (EditText) findViewById(R.id.name);
String hasName = UserName.getText().toString();


messageText = hasName;
messageText += "\nCorrect answer:: "+goodScore;
messageText += "\nWrong answer: "+wrongScore;
messageText += "\nMissing answer: " +noScore;

if (goodScore == 5){
    messageText += "\n Flawless Congratulations!";

}
else{
    messageText += "\n Try again.";
}


    Toast.makeText(getApplicationContext(), messageText,
            Toast.LENGTH_LONG).show();

//user name delet
UserName.getText().clear();
}


    /**
     *
     * @param groupId  //answer radiogrup id
     * @param derButtonId // answer radioButton id
     * @param dieButtonId // answer radioButton id
     * @param dasButtonId // answer radioButton id
     * @param goodAnswer // correct answer
     */
    public void answerControl(int groupId, int derButtonId, int dieButtonId, int dasButtonId,String goodAnswer
    )
    {
        RadioGroup radioGroup = (RadioGroup) findViewById( groupId);
        int selectedId = radioGroup.getCheckedRadioButtonId();

        RadioButton radioButtonDer = (RadioButton) findViewById(derButtonId);
        RadioButton radioButtonDie = (RadioButton) findViewById(dieButtonId);
        RadioButton radioButtonDas = (RadioButton) findViewById(dasButtonId);



   // This is checking of RadioButton designation

        if(selectedId == radioButtonDer.getId()) {
            //correct answer verification
            if (goodAnswer.equalsIgnoreCase("der")){
                goodScore++;
            } else {
                wrongScore++;
            }
        } else if(selectedId == radioButtonDie.getId()) {
            //correct answer verification
            if (goodAnswer.equalsIgnoreCase("die")){
                goodScore++;
            }else {
                wrongScore++;
            }
        } else  if(selectedId == radioButtonDas.getId()){
            //correct answer verification
            if (goodAnswer.equalsIgnoreCase("das")){
                goodScore++;
            }else {
                wrongScore++;
            }

        } else{
            //no checked answer
            noScore++;
        }


    }

    public void enabledButton(boolean value){
        Button buttonEvaluation = (Button) findViewById(R.id.evaluation);
        buttonEvaluation.setEnabled(value);

    }
    public void enableGroupe(boolean value){


        RadioGroup dataRadio;
//1.Question Radiogrup clear
        dataRadio = (RadioGroup) findViewById(R.id.aQuestionRadioGroup);
        for (int i = 0; i < dataRadio.getChildCount(); i++) {
            dataRadio.getChildAt(i).setEnabled(value);
        }


//2.Question Radiogrup clear

        dataRadio = (RadioGroup) findViewById(R.id.bQuestionRadioGroup);
        for (int i = 0; i < dataRadio.getChildCount(); i++) {
            dataRadio.getChildAt(i).setEnabled(value);
        }
//3.Question Radiogrup clear

        dataRadio = (RadioGroup) findViewById(R.id.cQuestionRadioGroup);
        for (int i = 0; i < dataRadio.getChildCount(); i++) {
            dataRadio.getChildAt(i).setEnabled(value);
        }

//4.Question Radiogrup clear

        dataRadio = (RadioGroup) findViewById(R.id.dQuestionRadioGroup);
        for (int i = 0; i < dataRadio.getChildCount(); i++) {
            dataRadio.getChildAt(i).setEnabled(value);
        }
//5.Question Radiogrup clear

        dataRadio = (RadioGroup) findViewById(R.id.eQuestionRadioGroup);
        for (int i = 0; i < dataRadio.getChildCount(); i++) {
            dataRadio.getChildAt(i).setEnabled(value);
        }


    }

    //answer clear
    public void reset(View view){

        goodScore = 0;
        wrongScore =0;
        noScore =0;
        RadioGroup dataRadio;
//1.Question Radiogrup clear
        dataRadio = (RadioGroup) findViewById(R.id.aQuestionRadioGroup);
        dataRadio.clearCheck();

//2.Question Radiogrup clear

        dataRadio = (RadioGroup) findViewById(R.id.bQuestionRadioGroup);
        dataRadio.clearCheck();
//3.Question Radiogrup clear

        dataRadio = (RadioGroup) findViewById(R.id.cQuestionRadioGroup);
        dataRadio.clearCheck();
//4.Question Radiogrup clear

        dataRadio = (RadioGroup) findViewById(R.id.dQuestionRadioGroup);
        dataRadio.clearCheck();
//5.Question Radiogrup clear

        dataRadio = (RadioGroup) findViewById(R.id.eQuestionRadioGroup);
        dataRadio.clearCheck();

//RadioGroup enable true
        enableGroupe(true);
//button enabled true
        enabledButton(true);
    }

    public void onClick(View v) {

        //answers control 1-5 questions
        answerControl(R.id.aQuestionRadioGroup,R.id.aDer,R.id.aDie,R.id.aDas,"der");
        answerControl(R.id.bQuestionRadioGroup,R.id.bDer,R.id.bDie,R.id.bDas,"der");
        answerControl(R.id.cQuestionRadioGroup,R.id.cDer,R.id.cDie,R.id.cDas,"der");
        answerControl(R.id.dQuestionRadioGroup,R.id.dDer,R.id.dDie,R.id.dDas,"der");
        answerControl(R.id.eQuestionRadioGroup,R.id.eDer,R.id.eDie,R.id.eDas,"der");


      //  RadioGroup Enable false
        enableGroupe(false);
        // Button Enable false
        enabledButton(false);
        //result display
        display();

    }




}
