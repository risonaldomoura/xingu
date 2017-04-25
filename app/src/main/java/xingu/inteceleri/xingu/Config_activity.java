package xingu.inteceleri.xingu;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.*;
import android.content.*;
import android.widget.*;

public class Config_activity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config_activity);

        btn_voltar = (Button)findViewById(R.id.btn_voltar);
        btn_voltar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){

        Intent it = new Intent(this, Main_activity.class);
        startActivity(it);
    }

    @Override
    protected void onPause(){
        super .onPause();
        finish();
    }

}
