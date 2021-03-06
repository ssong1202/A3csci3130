package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


/**
 * The type Create contact acitivity.
 */
public class CreateContactAcitivity extends Activity {
    private Button submitButton;
    private EditText nameField, addField,provinceField,numberField,primaryField;
    private MyApplicationData appState;

    @Override
    /**
     * the create contact acitivity
     * Shengnan
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());
        nameField = (EditText) findViewById(R.id.name);
        submitButton=(Button)findViewById(R.id.submitButton3);
        numberField=(EditText)findViewById(R.id.number);
        primaryField=(EditText) findViewById(R.id.primary);
        addField=(EditText) findViewById(R.id.address);
        provinceField=(EditText)findViewById(R.id.province);
    }

    /**
     * Submit info button.
     *
     * @param v the v
     */
    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String personID = appState.firebaseReference.push().getKey();
        String name = nameField.getText().toString();
        String number=numberField.getText().toString();
        String primary=primaryField.getText().toString();
        String address= addField.getText().toString();
        String province= provinceField.getText().toString();
        Contact person = new Contact(personID, name,number,primary,address,province);

        appState.firebaseReference.child(personID).setValue(person);

        finish();

    }
}
