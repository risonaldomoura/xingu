package xingu.inteceleri.xingu;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.*;
import android.content.*;
import android.widget.*;

public class Apresentacao_activity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_avancar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apresentacao_activity);

        btn_avancar = (Button)findViewById(R.id.btn_avancar);
        btn_avancar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){

        Intent it = new Intent(this, Registro_activity.class);
        startActivity(it);
    }

    @Override
    protected void onPause(){
        super .onPause();
        finish();
    }

}
