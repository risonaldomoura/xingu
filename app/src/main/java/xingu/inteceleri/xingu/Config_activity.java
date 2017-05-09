package xingu.inteceleri.xingu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.content.*;
import android.widget.*;

public class Config_activity extends AppCompatActivity implements View.OnClickListener{

    Button btn_voltar, btn_config_bimestre, btn_mudar_conta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config_activity);

        btn_voltar = (Button)findViewById(R.id.btn_voltar);
        btn_voltar.setOnClickListener(this);

        btn_config_bimestre = (Button)findViewById(R.id.btn_config_bimestre);
        btn_config_bimestre.setOnClickListener(this);

        btn_mudar_conta = (Button)findViewById(R.id.btn_mudar_conta);
        btn_mudar_conta.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){

        {

            switch (v.getId()) {

                case R.id.btn_voltar:
                    Intent it = new Intent(this, Main_activity.class);
                    startActivity(it);
                    break;

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
    protected void onPause(){
        super .onPause();
        finish();
    }

}
