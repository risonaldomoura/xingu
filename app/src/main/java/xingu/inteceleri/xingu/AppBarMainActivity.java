package xingu.inteceleri.xingu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AppBarMainActivity extends AppCompatActivity {
    private FirebaseAuth fbAuth;
    private TextView textUsuarioEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_header_main_activity);

        fbAuth = FirebaseAuth.getInstance();
        textUsuarioEmail = (TextView) findViewById(R.id.textViewEmailUsuario);



        if(fbAuth.getCurrentUser() == null){
            startActivity(new Intent(this,Login_activity.class));
        }else{
            FirebaseUser usuario = fbAuth.getCurrentUser();
            textUsuarioEmail.setText(usuario.getEmail());

            startActivity(new Intent(getApplicationContext(),Main_activity.class));

        }

    }
}
