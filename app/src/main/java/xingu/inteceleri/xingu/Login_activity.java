package xingu.inteceleri.xingu;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.*;
import android.content.*;
import android.widget.*;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_activity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_entrar;
    private Button btn_registrar;
    private EditText edtEmail;
    private EditText edtSenha;

    private ProgressDialog pDiag;
    private FirebaseAuth fbAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        fbAuth = FirebaseAuth.getInstance();
        pDiag = new ProgressDialog(this);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtSenha = (EditText) findViewById(R.id.edtSenha);



        btn_entrar = (Button)findViewById(R.id.btn_entrar);
        btn_registrar = (Button) findViewById(R.id.btn_registrar);


        btn_registrar.setOnClickListener(this);
        btn_entrar.setOnClickListener(this);

    }

    private void EntrarUsuario(){

        String email  = edtEmail.getText().toString().toString();
        String senha = edtSenha.getText().toString().toString();

        if(TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Por favor, insira seu e-mail!", Toast.LENGTH_SHORT).show();
            return;
        }else {
            if (TextUtils.isEmpty(senha)) {
                Toast.makeText(this, "Por favor, insira sua senha!", Toast.LENGTH_SHORT).show();
                return;
            } else {
                pDiag.setMessage("Entrando com suas credenciais. Por favor, aguarde!");
                pDiag.show();

                fbAuth.signInWithEmailAndPassword(email,senha)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                pDiag.dismiss();
                                if(task.isSuccessful()){
                                    Intent Main_act = new Intent(getApplicationContext(), Main_activity.class);
                                    startActivity(Main_act);
                                }
                            }
                        });


            }
        }

    }


    @Override
    public void onClick(View v){
            if(v == btn_registrar){
                Intent Registro_act = new Intent(this, Registro_activity.class);
                startActivity(Registro_act);
            }else if(v == btn_entrar){
                        EntrarUsuario();


            }


    }

    @Override
    protected void onPause(){
        super .onPause();
        finish();
    }
}
