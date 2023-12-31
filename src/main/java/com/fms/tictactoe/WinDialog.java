package com.fms.tictactoe;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class WinDialog extends Dialog {

    private final String message;
    private final MainActivity mainActivity;


    public WinDialog(@NonNull Context context, String message, MainActivity mainActivity) {
        super(context);
        this.message=message;
        this.mainActivity=mainActivity;


    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.win_dialog_layout);

        final TextView messageText =findViewById(R.id.messageText);
        final Button startAgainBtn=findViewById(R.id.startAgainbtn);
        final Button exitBtn=findViewById(R.id.exit);


        messageText.setText(message);

        startAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.restartMatch();
                dismiss();
            }
        });

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(15);

            }
        });
    }


}
