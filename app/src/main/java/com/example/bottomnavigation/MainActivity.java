package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.bottomnavigation.fragment.call_Fragment;
import com.example.bottomnavigation.fragment.chat_Fragment;
import com.example.bottomnavigation.fragment.home_Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity {
BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView=findViewById(R.id.bottomnavigation);
        openfragment(new home_Fragment());
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id= item.getItemId();
                switch (id)
                {
                    case R.id.homeicon:
                        openfragment(new home_Fragment());
                        break;
                    case R.id.callicon:
                        openfragment(new call_Fragment());
                        break;
                    case R.id.chaticon:
                        openfragment(new chat_Fragment());
                        break;
                }
                return true;
            }
        });
    }
    public void openfragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentcontainer,fragment);
        fragmentTransaction.commit();

    }
}