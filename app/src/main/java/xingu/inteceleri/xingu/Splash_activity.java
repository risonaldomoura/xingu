package xingu.inteceleri.xingu;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.ProgressBar;


public class Splash_activity extends AppCompatActivity {
    ProgressBar pBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        pBar = (ProgressBar) findViewById(R.id.progressBar);

       Thread timerThread = new Thread() {
           public void run(){
               try{
                   sleep (4000);
               } catch (InterruptedException e){
                   e.printStackTrace();
               } finally{
                   Intent intent = new Intent(Splash_activity.this, Apresentacao_activity.class);
                   startActivity(intent);
               }
           }
       };
       timerThread.start();

    }

    @Override
    protected void onPause(){
        super .onPause();
        finish();
    }
}
