package xingu.inteceleri.xingu;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.net.URI;

public class AppBarMainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_header_main_activity);




        /*
        //fbAuth = FirebaseAuth.getInstance();
        textUsuarioEmail = (TextView) findViewById(R.id.textViewEmailUsuario);
        nome = account.getDisplayName();
        textUsuarioEmail.setText(nome);

        fotoPessoa = (ImageView) findViewById(R.id.imageViewPhoto);
        foto = account.getPhotoUrl();
        fotoPessoa.setImageURI(foto);

        */

        /*
        if(fbAuth.getCurrentUser() == null){
            startActivity(new Intent(this,Login_activity.class));
        }else{
            FirebaseUser usuario = fbAuth.getCurrentUser();
            textUsuarioEmail.setText(usuario.getEmail());

            startActivity(new Intent(getApplicationContext(),Main_activity.class));

        }
        */
    }
}
