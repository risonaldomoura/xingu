package xingu.inteceleri.xingu;

import android.graphics.drawable.AnimationDrawable;
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


public class Splash_activity extends AppCompatActivity {

    ImageView imageView;
    AnimationDrawable anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        imageView = (ImageView) findViewById(R.id.imageView11);
        if(imageView == null ) throw new  AssertionError();
        imageView.setBackgroundResource(R.drawable.animacao_loading);

        anim = (AnimationDrawable) imageView.getBackground();
        anim.start();


       Thread timerThread = new Thread() {
           public void run(){
               try{
                   sleep (5000);
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
