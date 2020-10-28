package com.example.finalapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity
 implements View.OnClickListener
{
   private TextView tvUsername;
   private EditText etRealname;
   private RadioGroup sexGroup;
   private CheckBox cbPho, cbArt, cbMusic,cbMovie;
   private RadioButton rbMale,rbFemale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        tvUsername = findViewById(R.id.tv_username);
        etRealname = findViewById(R.id.et_realname);
        sexGroup = findViewById(R.id.group_sex);
        cbPho = findViewById(R.id.cb_pho);
        cbArt = findViewById(R.id.cb_art);
        cbMusic = findViewById(R.id.cb_music);
        cbMovie = findViewById(R.id.cb_movie);
        rbMale = findViewById(R.id.rbtn_male);
        rbFemale = findViewById(R.id.rbtn_female);

        Intent intent = getIntent();
        if (intent !=null){
            String name = intent.getStringExtra("username");
            tvUsername.setText(name);
        }

        Button btnConfirm = findViewById(R.id.btn_confirm);
        btnConfirm.setOnClickListener(this);

        etRealname.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (keyCode == KeyEvent. KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (imm != null && imm.isActive()) {
                        imm.hideSoftInputFromWindow((v.getApplicationWindowToken()), 0);
                    }
                    return true;
                }
                return false;
            }
        });
        }


    @Override
    public void onClick(View v) {
  if(v.getId() == R.id.btn_confirm){
      getInfo();
  }
    }
    private void getInfo(){
        String username = tvUsername.getText().toString().trim();
        String realname = etRealname.getText().toString().trim();
        String sex = "男";
        String favorite = "";

        int id = sexGroup.getCheckedRadioButtonId();
        if (id == R.id.rbtn_male){
            sex = "男";

        }else {
            sex = "女";
        }
        if (cbPho.isChecked()){
            favorite += cbPho.getText().toString() +", ";

        }
        if (cbArt.isChecked()){
            favorite += cbArt.getText().toString() +", ";
        }
        if (cbMusic.isChecked()){
            favorite += cbMusic.getText().toString() +", ";
        }
        if (cbMovie.isChecked()){
            favorite += cbMovie.getText().toString() +", ";
        }
        String info = "用户名：" + username + "\n姓名"
                + realname + "\n性别："
                + sex + "\n喜欢的领域："
                + favorite.trim().substring(0, favorite.trim().length() -1);
        Toast.makeText(InfoActivity.this, info ,Toast.LENGTH_LONG).show();

        Intent intent = new Intent(InfoActivity.this,Choose.class);
        startActivity(intent);

    }
}