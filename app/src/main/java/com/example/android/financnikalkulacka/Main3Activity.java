package com.example.android.financnikalkulacka;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class Main3Activity extends AppCompatActivity {
    int numberOfYears = 0;
    int living = 0;
    int food = 0;
    int fun = 0;


    private EditText etNumberOfYears;
    private EditText etLiving;
    private EditText etFood;
    private EditText etFun;
    private Button btnOk;
    private Button btnReset;
    private TextView txtVystup;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumberOfYears = (EditText) findViewById(R.id.etNumberOfYears);
        etLiving = (EditText) findViewById(R.id.etLiving);
        etFood = (EditText) findViewById(R.id.etFood);
        etFun = (EditText) findViewById(R.id.etFun);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnReset = (Button) findViewById(R.id.btnReset);
        txtVystup = (TextView) findViewById(R.id.txtVystup);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    public void spocitejHodnotu(View view) {
        numberOfYears = Integer.parseInt(String.valueOf(etNumberOfYears.getText()));
        living = Integer.parseInt(String.valueOf(etLiving.getText()));
        food = Integer.parseInt(String.valueOf(etFood.getText()));
        fun = Integer.parseInt(String.valueOf(etFun.getText()));

        int futureValue = (90 - numberOfYears) * 12 * (living + food + fun);

        txtVystup.setText("When you will be " + numberOfYears + " years old you need to have " + futureValue + " CZK.");
    }

    public void resetuj(View view) {
        numberOfYears = 0;
        living = 0;
        food = 0;
        fun = 0;

        etNumberOfYears.setText("");
        etFun.setText("");
        etFood.setText("");
        etLiving.setText("");

    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.android.financnikalkulacka/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.android.financnikalkulacka/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    /**
     * Called when the user clicks the Send button
     */
    public void sendMessage1(View view) {
        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);
    }
}
