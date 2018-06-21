package com.acme.a3csci3130;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DetailViewActivity extends Activity {
    private EditText nameField,numberField,provinceField,addField,primaryField;
    Contact receivedPersonInfo;
    private MyApplicationData appState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");
        appState=((MyApplicationData)getApplicationContext());
        nameField = (EditText) findViewById(R.id.name);
        numberField=(EditText) findViewById(R.id.number);
        provinceField=(EditText) findViewById(R.id.province);
        addField=(EditText) findViewById(R.id.address);
        primaryField=(EditText) findViewById(R.id.primary);

        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            numberField.setText(receivedPersonInfo.number);
            primaryField.setText(receivedPersonInfo.primary);
            addField.setText(receivedPersonInfo.address);
            provinceField.setText(receivedPersonInfo.province);
        }
    }

    public void updateContact(View v){
        String uid=receivedPersonInfo.uid;
        String number=numberField.getText().toString();
        String name=nameField.getText().toString();
        String primary=primaryField.getText().toString();
        String address=addField.getText().toString();
        String province=provinceField.getText().toString();
        Contact person =new Contact(uid,name,number,primary,address,province);
        appState.firebaseReference.child(uid).setValue(person);
        Toast.makeText(DetailViewActivity.this,"Updated",Toast.LENGTH_SHORT).show();
        finish();
    }

    public void eraseContact(View v)
    {
      appState.firebaseReference.child(receivedPersonInfo.uid).removeValue();
      finish();
      Intent intent =new Intent(this, MainActivity.class);
      startActivity(intent);
    }
}
