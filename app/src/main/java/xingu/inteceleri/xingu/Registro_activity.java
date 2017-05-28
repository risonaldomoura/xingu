package xingu.inteceleri.xingu;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registro_activity extends AppCompatActivity implements View.OnClickListener {

    private Button botaoRegistrar;
    private EditText campoEditarEmail;
    private EditText campoEditarSenha;
    private EditText campoEditarSenhaConfirm;
    private ProgressDialog progressDiag;

    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_activity);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDiag = new ProgressDialog(this);

        botaoRegistrar = (Button) findViewById(R.id.btn_registrarRegistro);
        campoEditarEmail = (EditText) findViewById(R.id.edtEmailRegistro);
        campoEditarSenha = (EditText) findViewById(R.id.edtSenhaRegistro);
        campoEditarSenhaConfirm = (EditText) findViewById(R.id.edtSenhaRegistroConfirmacao);

        botaoRegistrar.setOnClickListener(this);

    }

    private  void registrarUsuario(){

        String email = campoEditarEmail.getText().toString().trim();
        String senha =  campoEditarSenha.getText().toString().trim();
        String senhaConfirm = campoEditarSenhaConfirm.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Por favor, entre com um E-mail!", Toast.LENGTH_SHORT).show();
            return;
        }else if(TextUtils.isEmpty(senha)){
            Toast.makeText(this, "Por favor, entre com uma senha!", Toast.LENGTH_SHORT).show();
            return;
        }else{


                if( senha.compareTo(senhaConfirm) == 0){
                    //Toast.makeText(this, "Senhas iguais", Toast.LENGTH_SHORT).show();
                    //return;
                    progressDiag.setMessage("Registrando usuário ...");
                    progressDiag.show();
                    Thread timerThread = new Thread() {
                        public void run(){
                            try{
                                sleep (4000);
                            } catch (InterruptedException e){
                                e.printStackTrace();
                            } finally{

                            }
                        }
                    };
                    timerThread.start();


                    firebaseAuth.createUserWithEmailAndPassword(email,senha)
                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){

                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        progressDiag.setMessage("Usuário Registrado!");
                                        progressDiag.show();
                                        Thread timerThread = new Thread() {
                                            public void run(){
                                                try{
                                                    sleep (2000);
                                                } catch (InterruptedException e){
                                                    e.printStackTrace();
                                                } finally{
                                                    Intent intent = new Intent(Registro_activity.this,Login_activity.class );
                                                    startActivity(intent);
                                                }
                                            }
                                        };
                                        timerThread.start();
                                    }else {
                                        progressDiag.setMessage("Falha ao registrar, tente novamente!");
                                        progressDiag.show();
                                        Thread timerThread = new Thread() {
                                            public void run(){
                                                try{
                                                    sleep (2000);
                                                } catch (InterruptedException e){
                                                    e.printStackTrace();
                                                } finally{
                                                    return;
                                                }
                                            }
                                        };
                                        timerThread.start();
                                    }
                                }
                            });

                }else {
                    Toast.makeText(this, "Senhas não conferem!", Toast.LENGTH_SHORT).show();
                    return;
                }





        }

    }

    @Override
    public void onClick(View v) {
            if(v == botaoRegistrar){
                    registrarUsuario();
            }
    }
}
