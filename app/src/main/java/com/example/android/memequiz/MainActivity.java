package com.example.android.memequiz;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout1;
    LinearLayout linearLayout2;
    LinearLayout linearLayout3;
    LinearLayout linearLayout4;
    LinearLayout linearLayout5;
    RelativeLayout relativeLayout;

    CheckBox chkSadFrog;
    CheckBox chkFeelsBad;
    CheckBox chkCryingPepe;
    CheckBox chkSadPepe;

    RadioButton rdInternet;
    RadioButton rdVendetta;
    RadioButton rdMasks;
    RadioButton rdSocializing;
    RadioButton rdMans;
    RadioButton rdRoll;
    RadioButton rdImpossibru;
    RadioButton rdScumbag;
    RadioButton rdTrue;
    RadioButton rdFalse;

    ImageView imgMeme;
    EditText txtMemeName;

    int noGoodAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgMeme = (ImageView) findViewById(R.id.imgMeme);
        txtMemeName = (EditText) findViewById(R.id.txtMemeName);
        hideLayouts();
        activateCheckBoxes();
    }

    public void submitFirstQuestion(View view) {
        boolean isFeelsBad = chkFeelsBad.isChecked();
        boolean isSadFrog = chkSadFrog.isChecked();
        boolean isSadPepe = chkSadPepe.isChecked();
        boolean isCrying = chkCryingPepe.isChecked();
        if (!isCrying && !isFeelsBad && !isSadFrog && !isSadPepe) {
            Toast.makeText(this, "You must choose at least one to continue", Toast.LENGTH_SHORT).show();
        } else {
            linearLayout1.setVisibility(LinearLayout.GONE);
            linearLayout2.setVisibility(LinearLayout.VISIBLE);
            linearLayout3.setVisibility(LinearLayout.GONE);
            linearLayout4.setVisibility(LinearLayout.GONE);
            Resources res = getResources();
            imgMeme.setImageDrawable(res.getDrawable(R.drawable.reece));
            showRadioButtons();
        }

        if (isFeelsBad && isSadFrog && isSadPepe) {
            noGoodAnswer = noGoodAnswer + 1;
        }
    }

    public void submitSecondQuestion(View view) {
        boolean isMansHot = rdMans.isChecked();
        boolean isRollsafe = rdRoll.isChecked();
        boolean isImpossibru = rdImpossibru.isChecked();
        boolean isSteve = rdScumbag.isChecked();

        if (!isMansHot && !isRollsafe && !isImpossibru && !isSteve) {
            Toast.makeText(this, "You must choose at least one to continue", Toast.LENGTH_SHORT).show();
        } else {
            linearLayout1.setVisibility(LinearLayout.GONE);
            linearLayout2.setVisibility(LinearLayout.GONE);
            linearLayout3.setVisibility(LinearLayout.VISIBLE);
            linearLayout4.setVisibility(LinearLayout.GONE);
            Resources res = getResources();
            imgMeme.setImageDrawable(res.getDrawable(R.drawable.rules));
            showRadioButtons();
        }

        if (rdRoll.isChecked()) {
            noGoodAnswer = noGoodAnswer + 1;
        }
    }

    public void submitThirdQuestion(View view) {
        boolean isInternet = rdInternet.isChecked();
        boolean isVendetta = rdVendetta.isChecked();
        boolean isMasks = rdMasks.isChecked();
        boolean isSocial = rdSocializing.isChecked();

        if (!isInternet && !isMasks && !isVendetta && !isSocial) {
            Toast.makeText(this, "You must choose at least one to continue", Toast.LENGTH_SHORT).show();
        } else {
            linearLayout1.setVisibility(LinearLayout.GONE);
            linearLayout2.setVisibility(LinearLayout.GONE);
            linearLayout3.setVisibility(LinearLayout.GONE);
            linearLayout4.setVisibility(LinearLayout.VISIBLE);
            Resources res = getResources();
            imgMeme.setImageDrawable(res.getDrawable(R.drawable.doge));
            showRadioButtons();
        }

        if (rdInternet.isChecked()) {
            noGoodAnswer = noGoodAnswer + 1;
        }
    }

    public void submitForthQuestion(View view) {
        boolean isTrue = rdTrue.isChecked();
        boolean isFalse = rdFalse.isChecked();

        if (!isTrue && !isFalse) {
            Toast.makeText(this, "You must choose at least one to continue", Toast.LENGTH_SHORT).show();
        } else {
            linearLayout1.setVisibility(LinearLayout.GONE);
            linearLayout2.setVisibility(LinearLayout.GONE);
            linearLayout3.setVisibility(LinearLayout.GONE);
            linearLayout4.setVisibility(LinearLayout.GONE);
            linearLayout5.setVisibility(LinearLayout.VISIBLE);
            Resources res = getResources();
            imgMeme.setImageDrawable(res.getDrawable(R.drawable.rsz_trollface));
        }

        if (rdFalse.isChecked()) {
            noGoodAnswer = noGoodAnswer + 1;
        }
    }

    public void submitResult(View view) {
        String txt = txtMemeName.getText().toString().toLowerCase();
        ImageView imgIcon = (ImageView) findViewById(R.id.img_icon);
        TextView txtResult = (TextView) findViewById(R.id.txtResult);

        String value = null;
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            value = bundle.getString("com.sandica.name");
        }

        Log.v("Intent passed the val: ", value);

        if (txt.isEmpty()) {
            Toast.makeText(this, "You need to take a guess to continue...", Toast.LENGTH_SHORT).show();
        } else {
            linearLayout5.setVisibility(LinearLayout.GONE);
            imgMeme.setVisibility(ImageView.GONE);
            relativeLayout.setVisibility(RelativeLayout.VISIBLE);
            if (txt.equals("trollface") || txt.equals("troll face") || txt.equals("troll") || txt.equals("you mad bro") || txt.equals("u mad bro")) {
                noGoodAnswer = noGoodAnswer + 1;
            }
            txtResult.setText("Good try " + value + "\nYour score was: " + noGoodAnswer + " out of 5");
            if (noGoodAnswer >= 3) {
                imgIcon.setImageDrawable(getResources().getDrawable(R.drawable.thumb));
            } else {
                imgIcon.setImageDrawable(getResources().getDrawable(R.drawable.thumb_down));
            }

            Toast.makeText(this, "You answered to " + noGoodAnswer + " of 5 questions", Toast.LENGTH_LONG).show();
        }


    }

    public void hideLayouts() {
        linearLayout1 = (LinearLayout) findViewById(R.id.linear1);
        linearLayout2 = (LinearLayout) findViewById(R.id.linear2);
        linearLayout3 = (LinearLayout) findViewById(R.id.linear3);
        linearLayout4 = (LinearLayout) findViewById(R.id.linear4);
        linearLayout5 = (LinearLayout) findViewById(R.id.linear5);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout1);

        linearLayout2.setVisibility(LinearLayout.GONE);
        linearLayout3.setVisibility(LinearLayout.GONE);
        linearLayout4.setVisibility(LinearLayout.GONE);
        linearLayout5.setVisibility(LinearLayout.GONE);
        relativeLayout.setVisibility(RelativeLayout.GONE);
    }

    public void showRadioButtons() {
        rdInternet = (RadioButton) findViewById(R.id.radioInternet);
        rdVendetta = (RadioButton) findViewById(R.id.radioVendetta);
        rdMasks = (RadioButton) findViewById(R.id.radioMasks);
        rdSocializing = (RadioButton) findViewById(R.id.radioSocial);

        rdMans = (RadioButton) findViewById(R.id.radioHot);
        rdRoll = (RadioButton) findViewById(R.id.radioRoll);
        rdImpossibru = (RadioButton) findViewById(R.id.radioImposs);
        rdScumbag = (RadioButton) findViewById(R.id.radioSteve);

        rdTrue = (RadioButton) findViewById(R.id.radioTrue);
        rdFalse = (RadioButton) findViewById(R.id.radioFalse);
    }

    public void activateCheckBoxes() {
        chkCryingPepe = (CheckBox) findViewById(R.id.chk_crying);
        chkSadFrog = (CheckBox) findViewById(R.id.chk1_frog);
        chkSadPepe = (CheckBox) findViewById(R.id.chk_pepe);
        chkFeelsBad = (CheckBox) findViewById(R.id.chk_feelsbad);
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
