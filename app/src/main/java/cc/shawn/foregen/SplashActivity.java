package cc.shawn.foregen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by shawn on 17/3/6.
 */

public class SplashActivity extends AppCompatActivity {
    SharedPreferences setting;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_NoActionBar);
        setContentView(R.layout.activity_splash);


        setting = getSharedPreferences("SETTING", MODE_PRIVATE);
        boolean not_first = setting.getBoolean("NOT_FIRST", false);
        if (not_first){
            startActivity(new Intent(this,MainActivity.class));
            finish();
        }
    }

    public void in(View view){
        setting.edit().putBoolean("NOT_FIRST",true).apply();
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
