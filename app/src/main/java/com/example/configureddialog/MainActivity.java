package com.example.configureddialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4;
    AlertDialog.Builder adb;
    View layout;
    String[] colors = {"Red", "Green", "Blue"};
    int[] color = new int[]{0, 0, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        layout = (android.widget.LinearLayout) findViewById(R.id.main);
    }

    /**
     * Displays a single-choice alert dialog allowing the user to select a color.
     * Changes the background color based on the selection.
     *
     * @param view The button that was clicked.
     */
    public void goBtn1(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Skibidi title");
        adb.setMessage("ohio");

        adb = new AlertDialog.Builder(this);

        adb.setTitle("colors:");
        adb.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                color[which] = 255;
                layout.setBackgroundColor(Color.rgb(color[0], color[1], color[2]));
            }
        });
        adb.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        adb.setCancelable(false);
        AlertDialog alertDialog = adb.create();
        alertDialog.show();
    }

    /**
     * Displays a multi-choice alert dialog allowing the user to select multiple colors.
     * Changes the background color based on the selections.
     *
     * @param view The button that was clicked.
     */
    public void goBtn2(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("TITLE");
        adb.setMessage("hello kitty");
        adb = new AlertDialog.Builder(this);
        adb.setTitle("colors:");

        adb.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        adb.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) color[which] = 255;
                else if (color[which] == 255) color[which] = 0;
            }
        });
        adb.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        adb.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                layout.setBackgroundColor(Color.rgb(color[0], color[1], color[2]));
            }
        });
        adb.setCancelable(false);
        AlertDialog alertDialog = adb.create();
        alertDialog.show();
    }

    /**
     * Resets the background color of the layout to white.
     *
     * @param view The button that was clicked.
     */
    public void goBtn3(View view) {
        layout.setBackgroundColor(Color.WHITE);
    }

    /**
     * Displays an alert dialog with an EditText field.
     * Shows a toast message with the user's input when "OK" is clicked.
     *
     * @param view The button that was clicked.
     */
    public void goBtn4(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("TITLE skibidi msg");
        adb.setMessage("hello kitty");

        EditText eT = new EditText(this);
        eT.setHint("Edit Text!!!");
        adb.setView(eT);

        adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = eT.getText().toString();
                dialog.cancel();
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        });
        adb.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        adb.setCancelable(false);
        AlertDialog alertDialog = adb.create();
        alertDialog.show();
    }

    /**
     * Inflates the options menu for the activity.
     *
     * @param menu The options menu in which items are placed.
     * @return True if the menu is to be displayed.
     */
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
    /**
     * Handles item selection from the options menu.
     *
     * @param item The menu item that was selected.
     * @return True if the item was successfully handled.
     */
//    @Override
//    public boolean onOptionsItemSelected(@Nullable MenuItem item) {
////        int id = item.getItemId();
////        if(id == R.id.credits) {
////            Intent si = new Intent(this, Credits.class);
////            startActivity(si);
////        }
////        return true;
//    }
}
