package xingu.inteceleri.xingu;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;

public class Config_bimestre_activity extends AppCompatActivity{

    public static int ID1_I;
    public static int ID2_I;
    public static int ID3_I;
    public static int ID4_I;

    public static int ID1_II;
    public static int ID2_II;
    public static int ID3_II;
    public static int ID4_II;

    public static int ID1_III;
    public static int ID2_III;
    public static int ID3_III;
    public static int ID4_III;

    public static int ID1_IV;
    public static int ID2_IV;
    public static int ID3_IV;
    public static int ID4_IV;

    private Spinner spn_dia_inicio_I;
    private Spinner spn_dia_termino_I;
    private Spinner spn_mes_inicio_I;
    private Spinner spn_mes_termino_I;

    private Spinner spn_dia_inicio_II;
    private Spinner spn_dia_termino_II;
    private Spinner spn_mes_inicio_II;
    private Spinner spn_mes_termino_II;

    private Spinner spn_dia_inicio_III;
    private Spinner spn_dia_termino_III;
    private Spinner spn_mes_inicio_III;
    private Spinner spn_mes_termino_III;

    private Spinner spn_dia_inicio_IV;
    private Spinner spn_dia_termino_IV;
    private Spinner spn_mes_inicio_IV;
    private Spinner spn_mes_termino_IV;

    private List<String> adp_dia = new ArrayList<String>();
    private List<String> adp_mes = new ArrayList<String>();
    //private String[] id1_I;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config_bimestre);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Configuração de bimestre"); //titulo a mostrar na barra

        adp_dia.add("Dia");
        adp_dia.add("01");
        adp_dia.add("02");
        adp_dia.add("03");
        adp_dia.add("04");
        adp_dia.add("05");
        adp_dia.add("06");
        adp_dia.add("07");
        adp_dia.add("08");
        adp_dia.add("09");
        adp_dia.add("10");
        adp_dia.add("11");
        adp_dia.add("12");
        adp_dia.add("13");
        adp_dia.add("14");
        adp_dia.add("15");
        adp_dia.add("16");
        adp_dia.add("17");
        adp_dia.add("18");
        adp_dia.add("19");
        adp_dia.add("20");
        adp_dia.add("21");
        adp_dia.add("22");
        adp_dia.add("23");
        adp_dia.add("24");
        adp_dia.add("25");
        adp_dia.add("26");
        adp_dia.add("27");
        adp_dia.add("28");
        adp_dia.add("29");
        adp_dia.add("30");
        adp_dia.add("31");

        adp_mes.add("Mês");
        adp_mes.add("Janeiro");
        adp_mes.add("Fevereiro");
        adp_mes.add("Março");
        adp_mes.add("Abril");
        adp_mes.add("Maio");
        adp_mes.add("Junho");
        adp_mes.add("Julho");
        adp_mes.add("Agosto");
        adp_mes.add("Setembro");
        adp_mes.add("Outubro");
        adp_mes.add("Novembro");
        adp_mes.add("Dezembro");


        //======================================SPINNERS DO I BIMESTRE==============================
        //spn_dia_inicio_I
        spn_dia_inicio_I = (Spinner) findViewById(R.id.spn_dia_inicio_I);

        ArrayAdapter<String> adp1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, adp_dia);
        ArrayAdapter<String> spnAdapter1 = adp1;
        spnAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_dia_inicio_I.setAdapter(spnAdapter1);

        //spn_dia_termino_I
        spn_dia_termino_I = (Spinner) findViewById(R.id.spn_dia_termino_I);

        ArrayAdapter<String> adp2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, adp_dia);
        ArrayAdapter<String> spnAdapter2 = adp2;
        spnAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_dia_termino_I.setAdapter(spnAdapter2);

        //spn_mes_inicio_I
        spn_mes_inicio_I = (Spinner) findViewById(R.id.spn_mes_inicio_I);

        ArrayAdapter<String> adp3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, adp_mes);
        ArrayAdapter<String> spnAdapter3 = adp3;
        spnAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_mes_inicio_I.setAdapter(spnAdapter3);

        //spn_mes_termino_I
        spn_mes_termino_I = (Spinner) findViewById(R.id.spn_mes_termino_I);

        ArrayAdapter<String> adp4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, adp_mes);
        ArrayAdapter<String> spnAdapter4 = adp4;
        spnAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_mes_termino_I.setAdapter(spnAdapter4);

        //Leitura spn_dia_inicio_I
        spn_dia_inicio_I.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id1) {

                //pega nome pela posicao
                //dia = parent.getItemAtPosition(posicao).toString();

                ID1_I = posicao;

                mostrarid1_I();

            }


            public int getId(){
                return ID1_I;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        //Leitura spn_dia_termino_I
        spn_dia_termino_I.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id1) {

                ID2_I = posicao;

                mostrarid2_I();

            }

            public int getId(){
                return ID2_I;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        //Leitura spn_mes_inicio_I
        spn_mes_inicio_I.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id1) {

                ID3_I = posicao;

                mostrarid3_I();

            }

            public int getId(){
                return ID3_I;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        //Leitura spn_mes_termino_I
        spn_mes_termino_I.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id1) {

                ID4_I = posicao;

                mostrarid4_I();

            }

            public int getId(){
                return ID4_I;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        //==========================================================================================

        //======================================SPINNERS DO II BIMESTRE=============================
        //spn_dia_inicio_II
        spn_dia_inicio_II = (Spinner) findViewById(R.id.spn_dia_inicio_II);

        ArrayAdapter<String> adp5 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, adp_dia);
        ArrayAdapter<String> spnAdapter5 = adp5;
        spnAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_dia_inicio_II.setAdapter(spnAdapter5);

        //spn_dia_termino_II
        spn_dia_termino_II = (Spinner) findViewById(R.id.spn_dia_termino_II);

        ArrayAdapter<String> adp6 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, adp_dia);
        ArrayAdapter<String> spnAdapter6 = adp6;
        spnAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_dia_termino_II.setAdapter(spnAdapter6);

        //spn_mes_inicio_II
        spn_mes_inicio_II = (Spinner) findViewById(R.id.spn_mes_inicio_II);

        ArrayAdapter<String> adp7 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, adp_mes);
        ArrayAdapter<String> spnAdapter7 = adp7;
        spnAdapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_mes_inicio_II.setAdapter(spnAdapter7);

        //spn_mes_termino_II
        spn_mes_termino_II = (Spinner) findViewById(R.id.spn_mes_termino_II);

        ArrayAdapter<String> adp8 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, adp_mes);
        ArrayAdapter<String> spnAdapter8 = adp8;
        spnAdapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_mes_termino_II.setAdapter(spnAdapter8);

        //Leitura spn_dia_inicio_II
        spn_dia_inicio_II.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id1) {

                //pega nome pela posicao
                //dia = parent.getItemAtPosition(posicao).toString();

                ID1_II = posicao;

                //mostrarid1_II();

            }


            public int getId(){
                return ID1_II;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        //Leitura spn_dia_termino_II
        spn_dia_termino_II.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id1) {

                ID2_II = posicao;

               // mostrarid2_II();

            }

            public int getId(){
                return ID2_II;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        //Leitura spn_mes_inicio_II
        spn_mes_inicio_II.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id1) {

                ID3_II = posicao;

              //  mostrarid3_II();

            }

            public int getId(){
                return ID3_II;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        //Leitura spn_mes_termino_II
        spn_mes_termino_II.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id1) {

                ID4_II = posicao;

               // mostrarid4_II();

            }

            public int getId(){
                return ID4_II;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
        //==========================================================================================

        //======================================SPINNERS DO III BIMESTRE============================
        //spn_dia_inicio_III
        spn_dia_inicio_III = (Spinner) findViewById(R.id.spn_dia_inicio_III);

        ArrayAdapter<String> adp9 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, adp_dia);
        ArrayAdapter<String> spnAdapter9 = adp9;
        spnAdapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_dia_inicio_III.setAdapter(spnAdapter9);

        //spn_dia_termino_III
        spn_dia_termino_III = (Spinner) findViewById(R.id.spn_dia_termino_III);

        ArrayAdapter<String> adp10 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, adp_dia);
        ArrayAdapter<String> spnAdapter10 = adp10;
        spnAdapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_dia_termino_III.setAdapter(spnAdapter10);

        //spn_mes_inicio_III
        spn_mes_inicio_III = (Spinner) findViewById(R.id.spn_mes_inicio_III);

        ArrayAdapter<String> adp11 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, adp_mes);
        ArrayAdapter<String> spnAdapter11 = adp11;
        spnAdapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_mes_inicio_III.setAdapter(spnAdapter11);

        //spn_mes_termino_III
        spn_mes_termino_III = (Spinner) findViewById(R.id.spn_mes_termino_III);

        ArrayAdapter<String> adp12 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, adp_mes);
        ArrayAdapter<String> spnAdapter12 = adp12;
        spnAdapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_mes_termino_III.setAdapter(spnAdapter12);

        //Leitura spn_dia_inicio_III
        spn_dia_inicio_III.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id1) {

                //pega nome pela posicao
                //dia = parent.getItemAtPosition(posicao).toString();

                ID1_III = posicao;

                //mostrarid1_III();

            }


            public int getId(){
                return ID1_III;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        //Leitura spn_dia_termino_III
        spn_dia_termino_III.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id1) {

                ID2_III = posicao;

                //mostrarid2_III();

            }

            public int getId(){
                return ID2_III;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        //Leitura spn_mes_inicio_III
        spn_mes_inicio_III.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id1) {

                ID3_III = posicao;

                //mostrarid3_III();

            }

            public int getId(){
                return ID3_III;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        //Leitura spn_mes_termino_III
        spn_mes_termino_III.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id1) {

                ID4_III = posicao;

                //mostrarid4_III();

            }

            public int getId(){
                return ID4_III;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
        //==========================================================================================

        //======================================SPINNERS DO IV BIMESTRE==============================
        //spn_dia_inicio_IV
        spn_dia_inicio_IV = (Spinner) findViewById(R.id.spn_dia_inicio_IV);

        ArrayAdapter<String> adp13 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, adp_dia);
        ArrayAdapter<String> spnAdapter13 = adp13;
        spnAdapter13.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_dia_inicio_IV.setAdapter(spnAdapter13);

        //spn_dia_termino_IV
        spn_dia_termino_IV = (Spinner) findViewById(R.id.spn_dia_termino_IV);

        ArrayAdapter<String> adp14 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, adp_dia);
        ArrayAdapter<String> spnAdapter14 = adp14;
        spnAdapter14.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_dia_termino_IV.setAdapter(spnAdapter14);

        //spn_mes_inicio_IV
        spn_mes_inicio_IV = (Spinner) findViewById(R.id.spn_mes_inicio_IV);

        ArrayAdapter<String> adp15 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, adp_mes);
        ArrayAdapter<String> spnAdapter15 = adp15;
        spnAdapter15.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_mes_inicio_IV.setAdapter(spnAdapter15);

        //spn_mes_termino_IV
        spn_mes_termino_IV = (Spinner) findViewById(R.id.spn_mes_termino_IV);

        ArrayAdapter<String> adp16 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, adp_mes);
        ArrayAdapter<String> spnAdapter16 = adp16;
        spnAdapter16.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_mes_termino_IV.setAdapter(spnAdapter16);

        //Leitura spn_dia_inicio_IV
        spn_dia_inicio_IV.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id1) {

                //pega nome pela posicao
                //dia = parent.getItemAtPosition(posicao).toString();

                ID1_IV = posicao;

               // mostrarid1_IV();

            }


            public int getId(){
                return ID1_IV;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        //Leitura spn_dia_termino_IV
        spn_dia_termino_IV.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id1) {

                ID2_IV = posicao;

               // mostrarid2_IV();

            }

            public int getId(){
                return ID2_IV;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        //Leitura spn_mes_inicio_IV
        spn_mes_inicio_IV.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id1) {

                ID3_IV = posicao;

                //mostrarid3_IV();

            }

            public int getId(){
                return ID3_IV;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        //Leitura spn_mes_termino_I
        spn_mes_termino_IV.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id1) {

                ID4_IV = posicao;

                //mostrarid4_IV();

            }

            public int getId(){
                return ID4_IV;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        //==========================================================================================


    }//Fim OnCreate



    public void mostrarid1_I (){

        Toast.makeText(Config_bimestre_activity.this,"Dia:"+ID1_I,Toast.LENGTH_SHORT).show();
    }

    public void mostrarid2_I (){

        Toast.makeText(Config_bimestre_activity.this,"Mês:"+ID2_I,Toast.LENGTH_SHORT).show();
    }

    public void mostrarid3_I (){

        Toast.makeText(Config_bimestre_activity.this,"Dia:"+ID3_I,Toast.LENGTH_SHORT).show();
    }

    public void mostrarid4_I (){

        Toast.makeText(Config_bimestre_activity.this,"Mês:"+ID4_I,Toast.LENGTH_SHORT).show();
    }

    public void mostrarid1_II (){

        Toast.makeText(Config_bimestre_activity.this,"Dia:"+ID1_II,Toast.LENGTH_SHORT).show();
    }

    public void mostrarid2_II (){

        Toast.makeText(Config_bimestre_activity.this,"Mês:"+ID2_II,Toast.LENGTH_SHORT).show();
    }

    public void mostrarid3_II (){

        Toast.makeText(Config_bimestre_activity.this,"Dia:"+ID3_II,Toast.LENGTH_SHORT).show();
    }

    public void mostrarid4_II (){

        Toast.makeText(Config_bimestre_activity.this,"Mês:"+ID4_II,Toast.LENGTH_SHORT).show();
    }

    public void mostrarid1_III (){

        Toast.makeText(Config_bimestre_activity.this,"Dia:"+ID1_III,Toast.LENGTH_SHORT).show();
    }

    public void mostrarid2_III (){

        Toast.makeText(Config_bimestre_activity.this,"Mês:"+ID2_III,Toast.LENGTH_SHORT).show();
    }

    public void mostrarid3_III (){

        Toast.makeText(Config_bimestre_activity.this,"Dia:"+ID3_III,Toast.LENGTH_SHORT).show();
    }

    public void mostrarid4_III (){

        Toast.makeText(Config_bimestre_activity.this,"Mês:"+ID4_III,Toast.LENGTH_SHORT).show();
    }

    public void mostrarid1_IV (){

        Toast.makeText(Config_bimestre_activity.this,"Dia:"+ID1_IV,Toast.LENGTH_SHORT).show();
    }

    public void mostrarid2_IV (){

        Toast.makeText(Config_bimestre_activity.this,"Mês:"+ID2_IV,Toast.LENGTH_SHORT).show();
    }

    public void mostrarid3_IV (){

        Toast.makeText(Config_bimestre_activity.this,"Dia:"+ID3_IV,Toast.LENGTH_SHORT).show();
    }

    public void mostrarid4_IV (){

        Toast.makeText(Config_bimestre_activity.this,"Mês:"+ID4_IV,Toast.LENGTH_SHORT).show();
    }




    /*
    spn_dia_inicio_I.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

       @Override
        public void onItemSelected(AdapterView<?> parent, View v, int posicao, long nome) {

            //disciplina = parent.getSelectedItem().toString();

            ID = posicao;

            //mostrarid();

            //imprime um Toast na tela com o nome e posição do item selecionado
            //Toast.makeText(Main_activity.this, "Disciplina: " + nome, Toast.LENGTH_LONG).show();
            Toast.makeText(Config_bimestre_activity.this, "Dia:" + posicao, Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        return;
        }
    });*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                startActivity(new Intent(this, Config_activity.class));  //O efeito ao ser pressionado do botão (no caso abre a activity)
                finishAffinity();  //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
            default:break;
        }
        return true;
    }

}
