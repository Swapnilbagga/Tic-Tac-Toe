package com.fms.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_Players extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_add_players);

        Button StartGamebtn=findViewById(R.id.start);
        Button exit=findViewById(R.id.exit);
        EditText PlayerOne=findViewById(R.id.playerOne);
        EditText PlayerTwo=findViewById(R.id.playerTwo);



        StartGamebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String getPlayerOneName=PlayerOne.getText().toString();
                final String getPlayerTwoName=PlayerTwo.getText().toString();


                if(getPlayerOneName.isEmpty() || getPlayerTwoName.isEmpty()){
                            Toast.makeText(Add_Players.this,"Enter Player Name",Toast.LENGTH_SHORT).show();

                }else{
                    Intent intent=new Intent(Add_Players.this,MainActivity.class);
                    intent.putExtra("PlayerOne", getPlayerOneName);
                    intent.putExtra("PlayerTwo", getPlayerTwoName);
                    startActivity(intent);

                }


            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(20);
            }
        });
    }
}