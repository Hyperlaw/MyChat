package com.example.mychat;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements InputFragment.MessageListener {

    private ChatFragment chatFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chatFragment = new ChatFragment();
        InputFragment inputFragment = new InputFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.chatContainer, chatFragment)
                .replace(R.id.inputContainer, inputFragment)
                .commit();
    }

    @Override
    public void onMessageSent(String message) {
        if (chatFragment != null) {
            chatFragment.addMessage(message);
        }
    }
}
