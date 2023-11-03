package com.example.tiktok;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.example.tiktok.databinding.ActivityResultDialogBinding;

public class ResultDialogActivity extends Dialog {

    private final String message;
    private final MainActivity mainActivity;

    public ResultDialogActivity(@NonNull Context context, String message, MainActivity mainActivity) {
        super(context);
        this.message = message;
        this.mainActivity = mainActivity;
    }

    ActivityResultDialogBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultDialogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.messageText.setText(message);
        binding.startAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.restartMatch();
                dismiss();
            }
        });
    }
}




