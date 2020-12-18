package com.example.enigmapp;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;


/**
 * EnigmApp is a basic application that encrypts and decrypts
 * text information on the basis of given secret 4 symbol code. The engine works on the principle
 * of classic Enigma from WWII
 *
 * @author Piotr Dymala p.dymala@gmail.com
 * @version 1.0
 * @since 2020-22-27
 */


public class MainActivity extends AppCompatActivity {

    TextView secretCode;
    EditText textToEncode;
    EditText textDecoded;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         secretCode = (TextView) findViewById(R.id.secretCode);
         textToEncode = (EditText) findViewById(R.id.textToEncode);
         textDecoded = (EditText) findViewById(R.id.textDecoded);
        mTextView =
                (TextView) findViewById(R.id.secretCode);
    }


    /**
     * Generates 4 random symbol code (all characters writable) and passes it into EditText field
     */
    public void randomSecretNumberButtonClicked(View v) {

        RandomSecretCode randomSecretCode = new RandomSecretCode(4);

        mTextView.setText(randomSecretCode.getSecretCode());
        Toast.makeText(MainActivity.this, "Secret code generated", Toast.LENGTH_LONG).show();

    }


    /**
     * Encrypts the text in "Text to encode" text field and passes the result to "Encoded text" text field
     */
    public void runEnigma(View v) throws IOException {



        if (secretCode.getText().toString().length() < 4) {
            Toast.makeText(MainActivity.this, "Too short or no secret code given ", Toast.LENGTH_SHORT).show();

        } else if (textToEncode.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "No text given to encode", Toast.LENGTH_SHORT).show();

        } else {

            TextCoding textCoding;
            textCoding = new TextCoding(textToEncode.getText().toString(), String.valueOf(secretCode.getText()));


            textDecoded.setText(textCoding.getOutputText());

            Toast.makeText(MainActivity.this, "Encoding successful", Toast.LENGTH_SHORT).show();

        }

    }

    /**
     * Button for sharing the secret code
     */
    public void pasteCodeButton(View v) {


        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        try {
            CharSequence textToPaste = clipboard.getPrimaryClip().getItemAt(0).getText().subSequence(0, 4);
            secretCode.setText(textToPaste);
        } catch (Exception e) {
            return;
        }
        Toast.makeText(MainActivity.this, "Code passed ", Toast.LENGTH_SHORT).show();

    }

    /**
     * Button for sharing the secret code
     */
    public void shareCodeButton(View v) {


        if (secretCode.getText().toString().length() < 4) {
            Toast.makeText(MainActivity.this, "Too short or no code given to share", Toast.LENGTH_SHORT).show();
        } else {

            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, secretCode.getText().toString());
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Secret code");
            startActivity(Intent.createChooser(shareIntent, "Secret code"));

        }


    }

    /**
     * Button for passing text from clipboard into input text field
     */
    public void pasteButton(View v) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        try {
            CharSequence textToPaste = clipboard.getPrimaryClip().getItemAt(0).getText();
            textToEncode.setText(textToPaste);
        } catch (Exception e) {
            return;
        }
        Toast.makeText(MainActivity.this, "Text passed into encoded frame", Toast.LENGTH_SHORT).show();
    }


    /**
     * Button for sharing output text
     */
    public void shareButton(View v) {

        if (textDecoded.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "No text given to share", Toast.LENGTH_SHORT).show();
        } else {

            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, textDecoded.getText().toString());
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Secret information");
            startActivity(Intent.createChooser(shareIntent, "Secret information"));

        }


    }

}