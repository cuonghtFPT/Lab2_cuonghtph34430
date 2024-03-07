package cuonghtph34430.poly.lab2application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    private ArrayList<CityModal> cityList;
    private RecyclerView recyclerView;
    private CityAdapter cityAdapter;
    private DatabaseReference databaseReference;

    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Home.this, MainActivity.class));
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = findViewById(R.id.recyclerView);
        databaseReference = FirebaseDatabase.getInstance().getReference("name");
        cityList = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cityAdapter = new CityAdapter(this,cityList);
        recyclerView.setAdapter(cityAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                cityList.clear();

                for (DataSnapshot citySnapshot : snapshot.getChildren()) {
                    // Use CityModal class directly, assuming the CityModal class has appropriate getters and setters
                    CityModal cityModal = citySnapshot.getValue(CityModal.class);
                    cityList.add(cityModal);
                }

                cityAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("HomeActivity", "Error fetching data", error.toException());
            }
        });
    }
}