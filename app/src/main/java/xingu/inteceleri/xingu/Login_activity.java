package xingu.inteceleri.xingu;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.*;
import android.content.*;
import android.widget.*;

public class Login_activity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_entrar;
    private EditText edtEmail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        btn_entrar = (Button)findViewById(R.id.btn_entrar);
        btn_entrar.setOnClickListener(this);

        edtEmail = (EditText) findViewById(R.id.edtEmail);
    }

    @Override
    public void onClick(View v){

        Intent it = new Intent(this, Activity_teste.class);
        startActivity(it);
    }

    @Override
    protected void onPause(){
        super .onPause();
        finish();
    }
}
