package com.example.tiktok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tiktok.databinding.ActivityAddPlayersBinding;

public class AddPlayersActivity extends AppCompatActivity {

    ActivityAddPlayersBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddPlayersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String getPlayerOneName = binding.playerOne.getText().toString();
                String getPlayerTwoName = binding.playerTwo.getText().toString();

                if (getPlayerOneName.isEmpty() || getPlayerTwoName.isEmpty()) {
                    Toast.makeText(AddPlayersActivity.this, "Please enter player name", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(AddPlayersActivity.this, MainActivity.class);
                    intent.putExtra("playerOne", getPlayerOneName);
                    intent.putExtra("playerTwo", getPlayerTwoName);
                    startActivity(intent);
                }
            }
        });
        binding.startGameAI.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String getPlayerOneName = binding.playerOne.getText().toString();
               if (getPlayerOneName.isEmpty() ) {
                   getPlayerOneName = "Player 1";
                   Intent intent = new Intent(AddPlayersActivity.this, MainActivity2.class);
                   intent.putExtra("playerOne", getPlayerOneName);
                   startActivity(intent);
               } else {
                   Intent intent = new Intent(AddPlayersActivity.this, MainActivity2.class);
                   intent.putExtra("playerOne", getPlayerOneName);
                   startActivity(intent);
               }
           }

        });

    }
}