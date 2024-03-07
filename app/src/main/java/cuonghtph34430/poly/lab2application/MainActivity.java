package cuonghtph34430.poly.lab2application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Button btntInsert,btnView;
    EditText edtname,edtpopular;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtname=findViewById(R.id.edtname);
        edtpopular=findViewById(R.id.edtpopular);
        btnView=findViewById(R.id.btnview);
        btntInsert=findViewById(R.id.btninsert);
        databaseReference= FirebaseDatabase.getInstance().getReference();
        btntInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertData();
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Home.class));
                finish();
            }
        });
    }
    private void InsertData() {
        String name = edtname.getText().toString();
        String popular = edtpopular.getText().toString();
        String id = databaseReference.push().getKey();

        CityModal cityModal = new CityModal(name, popular);
        databaseReference.child("name").child(id).setValue(cityModal)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Thành công", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}