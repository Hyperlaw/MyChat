package com.example.mychat;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;



public class InputFragment extends Fragment {

    private MessageListener messageListener;

    public interface MessageListener {
        void onMessageSent(String message);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof MessageListener) {
            messageListener = (MessageListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement MessageListener");
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_input, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText editText = view.findViewById(R.id.editTextMessage);
        Button sendButton = view.findViewById(R.id.buttonSend);

        sendButton.setOnClickListener(v -> {
            String message = editText.getText().toString();
            if (!message.isEmpty()) {
                messageListener.onMessageSent(message);
                editText.setText("");
            }
        });

    }
}