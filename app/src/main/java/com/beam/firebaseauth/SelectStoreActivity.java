package com.beam.firebaseauth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class SelectStoreActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt1;
    private Button bt2;
//    private Button bt3;

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_store);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
//        bt3 = findViewById(R.id.bt3);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
//        bt3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v == bt1) {
            Query storeQuery = databaseReference.child("Store").orderByChild("closeTime");
            storeQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    System.out.println(dataSnapshot.getValue());
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
        if (v == bt2) {
            startActivity(new Intent(this, ReserveActivity.class));
        }
    }

}
