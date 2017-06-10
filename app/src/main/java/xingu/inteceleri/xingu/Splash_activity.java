package xingu.inteceleri.xingu;

import android.content.SharedPreferences;
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

    public int execucao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        pBar = (ProgressBar) findViewById(R.id.progressBar);
        pBar.setVisibility(View.VISIBLE);
        pBar = (ProgressBar) findViewById(R.id.progressBar);

       Thread timerThread = new Thread() {
           public void run(){
               try{
                   sleep (1000);
               } catch (InterruptedException e){
                   e.printStackTrace();
               } finally{

                   //Verifica se o app já foi executado anteriormente
                   SharedPreferences sharedPref_execucao = getSharedPreferences("pref_bimestre",MODE_PRIVATE);
                   execucao = sharedPref_execucao.getInt("execucao",0);

                   if (execucao == 1){

                       Intent intent = new Intent(Splash_activity.this, Main_activity.class);
                       startActivity(intent);
                   }

                   else if (execucao == 2){

                       Intent intent = new Intent(Splash_activity.this, Login_activity.class);
                       startActivity(intent);

                   }

                   else if (execucao == 0){

                       Intent intent = new Intent(Splash_activity.this, Apresentacao_activity.class);
                       startActivity(intent);

                   }

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
