package com.example.flames_gamingapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText firstName= (EditText) findViewById(R.id.firstName);
        EditText secondName= (EditText) findViewById(R.id.secondName);
        Button btnStatus= (Button) findViewById(R.id.btnStatus);

        btnStatus.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String flames_str = "FLAMES";
                        HashMap<Character, String> map = new HashMap<>();
                        String userName_1 = firstName.getText().toString().toLowerCase();
                        String userName_2 = secondName.getText().toString().toLowerCase();
                        if (userName_1.isEmpty() || userName_2.isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Invalid Input Entered...", Toast.LENGTH_LONG).show();
                        } else {
                            userName_1 = userName_1.replaceAll("\\s", "");
                            userName_2 = userName_2.replaceAll("\\s", "");
                            String res_combined = UncommonChars(userName_1, userName_2);
                            int len_res = res_combined.length();
                            int len_flames = flames_str.length();
                            map.put('F', "Friends");
                            map.put('L', "Love Birds");
                            map.put('A', "Affectionate");
                            map.put('M', "Marrying");
                            map.put('E', "Enemies");
                            map.put('S', "Siblings");
                            if (res_combined == "-1") {
                                Toast.makeText(getApplicationContext(), "Similar Input Entered", Toast.LENGTH_LONG).show();
                            } else {
                                String res = map.get(flames_str.charAt((len_res - 1) % len_flames));
                                Toast.makeText(getApplicationContext(), "You Would be " + res + " Each other...", Toast.LENGTH_LONG).show();
                            }

                        }
                    }
                }
        );


    }
    static String UncommonChars(String a, String b)
    {
        int MAX_CHAR=26;
        int mp1[] = new int[MAX_CHAR];
        int mp2[] = new int[MAX_CHAR];
        int n = a.length();
        int m = b.length();
        for (int i = 0; i < n; i++) {
            mp1[a.charAt(i) - 'a'] = 1;
        }
        for (int i = 0; i < m; i++) {
            mp2[b.charAt(i) - 'a'] = 1;
        }

        String chars = "";
        for (int i = 0; i < 26; i++) {
            if ((mp1[i] ^ mp2[i]) != 0) {
                chars += (char)(i + 'a');
            }
        }
        if (chars == "")
            return "-1";
        else
            return chars;
    }
}