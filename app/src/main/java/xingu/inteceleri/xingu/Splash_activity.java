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
<<<<<<< HEAD

=======
>>>>>>> 2a7cc001a69fa8c4d8147e6f6801c827a80a0047
    ProgressBar pBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

<<<<<<< HEAD

        pBar = (ProgressBar) findViewById(R.id.progressBar);
        pBar.setVisibility(View.VISIBLE);
=======
        pBar = (ProgressBar) findViewById(R.id.progressBar);
>>>>>>> 2a7cc001a69fa8c4d8147e6f6801c827a80a0047

       Thread timerThread = new Thread() {
           public void run(){
               try{
                   sleep (500);
               } catch (InterruptedException e){
                   e.printStackTrace();
               } finally{
                   Intent intent = new Intent(Splash_activity.this, Main_activity.class);
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
