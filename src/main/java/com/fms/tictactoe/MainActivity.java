package com.fms.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {
    private final List<int[]> combinationsList =new ArrayList<>();
    private int []boxPositions={0,0,0,0,0,0,0,0,0};
    private int playerTurn=1;

    private int totalSelectedBoxes=1;
    private TextView playerOneName, playerTwoName;
    private ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9;
    private LinearLayout playerOneLayout, playerTwoLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerOneName=findViewById(R.id.PlayerOneName);
        playerTwoName=findViewById(R.id.PlayerTwoName);

        playerOneLayout=findViewById(R.id.PlayerOneLayout);
        playerTwoLayout=findViewById(R.id.PlayerTwoLayout);

        img1=findViewById(R.id.img1);
        img2=findViewById(R.id.img2);
        img3=findViewById(R.id.img3);
        img4=findViewById(R.id.img4);
        img5=findViewById(R.id.img5);
        img6=findViewById(R.id.img6);
        img7=findViewById(R.id.img7);
        img8=findViewById(R.id.img8);
        img9=findViewById(R.id.img9);

        combinationsList.add(new int[]{0,1,2});
        combinationsList.add(new int[]{3,4,5});
        combinationsList.add(new int[]{6,7,8});
        combinationsList.add(new int[]{0,3,6});
        combinationsList.add(new int[]{1,4,7});
        combinationsList.add(new int[]{2,5,8});
        combinationsList.add(new int[]{0,4,8});
        combinationsList.add(new int[]{2,4,6});

        final String getPlayerOneName=getIntent().getStringExtra("PlayerOne");
        final String getPlayerTwoName=getIntent().getStringExtra("PlayerTwo");

        playerOneName.setText(getPlayerOneName);
        playerTwoName.setText(getPlayerTwoName);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(0)){
                    performAction((ImageView) v ,0);
                }
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(1)){
                    performAction((ImageView) v ,1);
                }
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(2)){
                    performAction((ImageView) v ,2);
                }
            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(3)){
                    performAction((ImageView) v ,3);
                }
            }
        });

        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(4)){
                    performAction((ImageView) v ,4);
                }
            }
        });

        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(5)){
                    performAction((ImageView) v ,5);
                }
            }
        });

        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(6)){
                    performAction((ImageView) v ,6);
                }
            }
        });

        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(7)){
                    performAction((ImageView) v ,7);
                }
            }
        });

        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(8)){
                    performAction((ImageView) v ,8);
                }
            }
        });
    }


    private void performAction(ImageView imageView ,  int selectedBoxPosition){
        boxPositions[selectedBoxPosition]=playerTurn;
        if(playerTurn==1){
            imageView.setImageResource(R.drawable.x);
            if (checkPlayerWin()){
                WinDialog winDialog=new WinDialog(MainActivity.this,playerOneName.getText().toString()+" has won the match",MainActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }else if (totalSelectedBoxes==9){
                WinDialog winDialog=new WinDialog(MainActivity.this,"It is a Draw",MainActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }else{
                changePlayerTurn(2);
                totalSelectedBoxes++;
            }
        }
        else{
            imageView.setImageResource(R.drawable.o);

            if(checkPlayerWin()){
                WinDialog winDialog=new WinDialog(MainActivity.this,playerTwoName.getText().toString()+" has won the match",MainActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
            } else if (selectedBoxPosition==9) {
                WinDialog winDialog=new WinDialog(MainActivity.this,"It is a Draw",MainActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();

            }
            else{
                changePlayerTurn((1));
                totalSelectedBoxes++;
            }
        }
    }

    private  void changePlayerTurn(int currentPlayerTurn){
        playerTurn=currentPlayerTurn;
        if(playerTurn==1){
            playerOneLayout.setBackgroundResource(R.drawable.round_back_blue_border);
            playerTwoLayout.setBackgroundResource(R.drawable.round_background_blue);

        }else{
            playerTwoLayout.setBackgroundResource(R.drawable.round_back_blue_border);
            playerOneLayout.setBackgroundResource(R.drawable.round_background_blue);

        }
    }

    private boolean checkPlayerWin(){
        boolean response =false;

        for (int i=0;i<combinationsList.size();i++){
            final int[] combination=combinationsList.get(i);

            if(boxPositions[combination[0]]==playerTurn&&boxPositions[combination[1]]==playerTurn&& boxPositions[combination[2]]==playerTurn){
                response=true;
            }
        }
        return response;
    }

    private boolean isBoxSelectable(int boxPosition){
        boolean response =false;

        if(boxPositions[boxPosition]==0){
            response =true;
        }
        return response;
    }

    void restartMatch(){
        boxPositions=new int[]{0,0,0,0,0,0,0,0,0};
        playerTurn=1;
        totalSelectedBoxes=2;
        img1.setImageResource(R.drawable.tb);
        img2.setImageResource(R.drawable.tb);
        img3.setImageResource(R.drawable.tb);
        img4.setImageResource(R.drawable.tb);
        img5.setImageResource(R.drawable.tb);
        img6.setImageResource(R.drawable.tb);
        img7.setImageResource(R.drawable.tb);
        img8.setImageResource(R.drawable.tb);
        img9.setImageResource(R.drawable.tb);
    }
}