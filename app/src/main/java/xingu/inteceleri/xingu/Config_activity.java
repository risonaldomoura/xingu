package xingu.inteceleri.xingu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.content.*;
import android.widget.*;

public class Config_activity extends AppCompatActivity implements View.OnClickListener{

    Button btn_config_bimestre, btn_mudar_conta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config_activity);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Configurações"); //titulo a mostrar na barra

        btn_config_bimestre = (Button)findViewById(R.id.btn_config_bimestre);
        btn_config_bimestre.setOnClickListener(this);

        btn_mudar_conta = (Button)findViewById(R.id.btn_mudar_conta);
        btn_mudar_conta.setOnClickListener(this);
    }

    public void onBackPressed() {

        Intent it = new Intent(this, Main_activity.class);
        startActivity(it);

        return;
    }
    @Override
    public void onClick(View v){

        {

            switch (v.getId()) {

                case R.id.btn_config_bimestre:

                    Intent it2 = new Intent(this, Config_bimestre_activity.class);
                    startActivity(it2);
                    break;

                case R.id.btn_mudar_conta:

                    Intent it3 = new Intent(this, Login_activity.class);
                    startActivity(it3);

                    break;

            }

        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                startActivity(new Intent(this, Main_activity.class));  //O efeito ao ser pressionado do botão (no caso abre a activity)
                finishAffinity();  //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
            default:break;
        }
        return true;
    }

    @Override
    protected void onPause(){
        super .onPause();
        finish();
    }


}
