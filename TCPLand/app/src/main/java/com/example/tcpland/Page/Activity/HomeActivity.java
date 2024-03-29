package com.example.tcpland.Page.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.tcpland.Page.Taisan.Profile;
import com.example.tcpland.R;
import com.example.tcpland.View.Account.ui.login.LoginActivity;
import com.example.tcpland.Page.Fragments.Fragments.DashBoard.DashBoard;
import com.example.tcpland.Page.Fragments.Duan.DuAnFragment;
import com.example.tcpland.Page.Fragments.Fragments.Wallet.Wallet;
import com.example.tcpland.Page.Fragments.NapTien.NapTienFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class HomeActivity extends AppCompatActivity {
    DataStored data;
    public List<DuAnFragment> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<DuAnFragment> newsList) {
        this.newsList = newsList;
    }
    BottomNavigationView bottomNav;
    List<DuAnFragment> newsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_activity);


        Intent intent=getIntent();
        Log.e("bundle", "onCreate: "+intent.getSerializableExtra("userInfo") );
        data= new DataStored();
        if(intent.getSerializableExtra("userInfo")!=null){

        data.setEmail(intent.getSerializableExtra("email").toString());
            data.setPassword(intent.getSerializableExtra("password").toString());
            data.setUserid(intent.getSerializableExtra("userid").toString());
        }


         bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(navListener);
//        FloatingActionButton btn=findViewById(R.id.deposit);
//        btn.setOnClickListener(v -> {
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.fragment_container, new NapTienFragment())
//                    .addToBackStack(null)
//                    .commit();
//        });
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new DashBoard())
                    .commit();


    }
    public static void setCheckable(BottomNavigationView view, boolean checkable) {
        final Menu menu = view.getMenu();
        for(int i = 0; i < menu.size(); i++) {
            menu.getItem(i).setCheckable(checkable);
        }
    }


    private final BottomNavigationView.OnItemSelectedListener navListener = item -> {
        // By using switch we can easily get
        // the selected fragment
        // by using there id.
        Intent stopToLogin= new Intent(getApplicationContext(), LoginActivity.class);
        Fragment selectedFragment = null;
        int itemId = item.getItemId();
        switch (itemId){
            case R.id.real_estate:
                if(!data.isUsable()){
                    Toast.makeText(getApplicationContext(), "Tác vụ yêu cầu đăng nhập", Toast.LENGTH_SHORT).show();
                    HomeActivity.this.startActivity(stopToLogin);
                }else
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new NapTienFragment())
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.homeD:
                selectedFragment = new DashBoard();
                break;
            case R.id.wallet:
                if(data.isUsable()){
                selectedFragment = new Wallet();
                }else
                {
                    Toast.makeText(getApplicationContext(), "Tác vụ yêu cầu đăng nhập", Toast.LENGTH_SHORT).show();
                    HomeActivity.this.startActivity(stopToLogin);
                }
                break;
            case R.id.profile:
                Intent continudeProfile= new Intent(getApplicationContext(), Profile.class);
                continudeProfile.putExtra("userInfo",getIntent().getSerializableExtra("userInfo"));
               RequireLoginRoute(continudeProfile,stopToLogin);
                break;
        }
        // It will help to replace the
        // one fragment to other.
        if (selectedFragment != null) {
            LoadFragmentSelected(selectedFragment);
        }
        return true;
    };
    public void RequireLoginRoute(Intent continudeI, Intent stopI) {
        if(data.isUsable()){
            Log.e("testStoredData",String.valueOf(data.isUsable()) );

            HomeActivity.this.startActivity(continudeI);
        }
        else {
            Toast.makeText(getApplicationContext(), "Tác vụ yêu cầu đăng nhập", Toast.LENGTH_SHORT).show();

            HomeActivity.this.startActivity(stopI);
        }
    }

    @Override
    public void onBackPressed() {

        getSupportFragmentManager().clearBackStack(null);
        super.onBackPressed();
    }

    private void LoadFragmentSelected(Fragment selectedFragment) {
        getSupportFragmentManager().beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragment_container, selectedFragment).commit();
    }
}
