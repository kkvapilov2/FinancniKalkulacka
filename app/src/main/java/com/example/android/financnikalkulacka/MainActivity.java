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

public class MainActivity extends AppCompatActivity {
    int urokovaSazba = 0;
    int pocetObdobi = 0;
    int pravidelnaPlatba = 0;
    int pocatecniJistina = 0;


    private EditText etUrokovaSazba;
    private EditText etPocetObdobi;
    private EditText etPravidelnaPlatba;
    private EditText etPocatecniJistina;
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

        etUrokovaSazba = (EditText) findViewById(R.id.etUrokovaSazba);
        etPocetObdobi = (EditText) findViewById(R.id.etPocetObdobi);
        etPravidelnaPlatba = (EditText) findViewById(R.id.etPravidelnaPlatba);
        etPocatecniJistina = (EditText) findViewById(R.id.etPocatecniJistina);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnReset = (Button) findViewById(R.id.btnReset);
        txtVystup = (TextView) findViewById(R.id.txtVystup);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    public void spocitejHodnotu(View view) {
        urokovaSazba = Integer.parseInt(String.valueOf(etUrokovaSazba.getText()));
        pocetObdobi = Integer.parseInt(String.valueOf(etPocetObdobi.getText()));
        pravidelnaPlatba = Integer.parseInt(String.valueOf(etPravidelnaPlatba.getText()));
        pocatecniJistina = Integer.parseInt(String.valueOf(etPocatecniJistina.getText()));
        int urocitel = urokovaSazba + 1;
        int futureValue = (pocatecniJistina * (urocitel ^ pocetObdobi)) + (pravidelnaPlatba * ((urocitel ^ pocetObdobi) - 1)) / (urocitel - 1);

        txtVystup.setText("In " + pocetObdobi + " years you will have " + futureValue + " CZK.");
    }

    public void resetuj(View view) {
        urokovaSazba = 0;
        pocetObdobi = 0;
        pravidelnaPlatba = 0;
        pocatecniJistina = 0;

        etUrokovaSazba.setText("");
        etPocatecniJistina.setText("");
        etPravidelnaPlatba.setText("");
        etPocetObdobi.setText("");

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
    public void sendMessage(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
}
