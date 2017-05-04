package xingu.inteceleri.xingu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



public class Activity_teste extends AppCompatActivity {

    public int disciplina = 0;
    public int serie = 0;

    private Spinner spinner;
    private Spinner spinner2;

    private List<String> nomes = new ArrayList<String>();
    private String nome;
    private String[] id1;

    private List<String> anos = new ArrayList<String>();
    private String ano;
    private String[] id2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);

        anos.add("6º");
        anos.add("7º");
        anos.add("8º");
        anos.add("9º");

        nomes.add("Arte");
        nomes.add("Ciências");
        nomes.add("Ed. Física");
        nomes.add("Ens. Religioso");
        nomes.add("Geografia");
        nomes.add("História");
        nomes.add("Matemática");
        nomes.add("Português");

        //final FrameLayout fl_conteudo = (FrameLayout) findViewById(R.id.fl_conteudo);
        final FrameLayout fl_cont_arte_sexto = (FrameLayout) findViewById(R.id.fl_cont_arte_sexto);
        final FrameLayout fl_cont_arte_setimo = (FrameLayout) findViewById(R.id.fl_cont_arte_setimo);
        final FrameLayout fl_cont_arte_oitavo = (FrameLayout) findViewById(R.id.fl_cont_arte_oitavo);
        final FrameLayout fl_cont_arte_nono = (FrameLayout) findViewById(R.id.fl_cont_arte_nono);

        final FrameLayout fl_cont_ciencias_sexto = (FrameLayout) findViewById(R.id.fl_cont_ciencias_sexto);
        final FrameLayout fl_cont_ciencias_setimo = (FrameLayout) findViewById(R.id.fl_cont_ciencias_setimo);
        final FrameLayout fl_cont_ciencias_oitavo = (FrameLayout) findViewById(R.id.fl_cont_ciencias_oitavo);
        final FrameLayout fl_cont_ciencias_nono = (FrameLayout) findViewById(R.id.fl_cont_ciencias_nono);

        final FrameLayout fl_cont_ed_fisica_sexto = (FrameLayout) findViewById(R.id.fl_cont_ed_fisica_sexto);
        final FrameLayout fl_cont_ed_fisica_setimo = (FrameLayout) findViewById(R.id.fl_cont_ed_fisica_setimo);
        final FrameLayout fl_cont_ed_fisica_oitavo = (FrameLayout) findViewById(R.id.fl_cont_ed_fisica_oitavo);
        final FrameLayout fl_cont_ed_fisica_nono = (FrameLayout) findViewById(R.id.fl_cont_ed_fisica_nono);

        final FrameLayout fl_cont_ens_religioso_sexto = (FrameLayout) findViewById(R.id.fl_cont_ens_religioso_sexto);
        final FrameLayout fl_cont_ens_religioso_setimo = (FrameLayout) findViewById(R.id.fl_cont_ens_religioso_setimo);
        final FrameLayout fl_cont_ens_religioso_oitavo = (FrameLayout) findViewById(R.id.fl_cont_ens_religioso_oitavo);
        final FrameLayout fl_cont_ens_religioso_nono = (FrameLayout) findViewById(R.id.fl_cont_ens_religioso_nono);

        final FrameLayout fl_cont_geografia_sexto = (FrameLayout) findViewById(R.id.fl_cont_geografia_sexto);
        final FrameLayout fl_cont_geografia_setimo = (FrameLayout) findViewById(R.id.fl_cont_geografia_setimo);
        final FrameLayout fl_cont_geografia_oitavo = (FrameLayout) findViewById(R.id.fl_cont_geografia_oitavo);
        final FrameLayout fl_cont_geografia_nono = (FrameLayout) findViewById(R.id.fl_cont_geografia_nono);

        final FrameLayout fl_cont_historia_sexto = (FrameLayout) findViewById(R.id.fl_cont_historia_sexto);
        final FrameLayout fl_cont_historia_setimo = (FrameLayout) findViewById(R.id.fl_cont_historia_setimo);
        final FrameLayout fl_cont_historia_oitavo = (FrameLayout) findViewById(R.id.fl_cont_historia_oitavo);
        final FrameLayout fl_cont_historia_nono = (FrameLayout) findViewById(R.id.fl_cont_historia_nono);

        final FrameLayout fl_cont_matematica_sexto = (FrameLayout) findViewById(R.id.fl_cont_matematica_sexto);
        final FrameLayout fl_cont_matematica_setimo = (FrameLayout) findViewById(R.id.fl_cont_matematica_setimo);
        final FrameLayout fl_cont_matematica_oitavo = (FrameLayout) findViewById(R.id.fl_cont_matematica_oitavo);
        final FrameLayout fl_cont_matematica_nono = (FrameLayout) findViewById(R.id.fl_cont_matematica_nono);

        final FrameLayout fl_cont_portugues_sexto = (FrameLayout) findViewById(R.id.fl_cont_portugues_sexto);
        final FrameLayout fl_cont_portugues_setimo = (FrameLayout) findViewById(R.id.fl_cont_portugues_setimo);
        final FrameLayout fl_cont_portugues_oitavo = (FrameLayout) findViewById(R.id.fl_cont_portugues_oitavo);
        final FrameLayout fl_cont_portugues_nono = (FrameLayout) findViewById(R.id.fl_cont_portugues_nono);




        //identifica o spinner no layout
        spinner = (Spinner) findViewById(R.id.spinner);

        spinner2 = (Spinner) findViewById(R.id.spinner2);

        //cria o ArrayAdapter
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, nomes);
        ArrayAdapter<String> spinnerArrayAdapter = arrayAdapter;

        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, anos);
        ArrayAdapter<String> spinnerArrayAdapter2 = arrayAdapter2;

        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spinner.setAdapter(spinnerArrayAdapter);

        spinnerArrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spinner2.setAdapter(spinnerArrayAdapter2);


        //Método do spinner para capturar o item selecionado

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id1) {

                //pega nome pela posicao
                nome = parent.getItemAtPosition(posicao).toString();
                //imprime um Toast na tela com o nome e posição do item selecionado
                //Toast.makeText(Activity_teste.this, "Disciplina: " + nome, Toast.LENGTH_LONG).show();
                //Toast.makeText(Activity_teste.this, "Id:" + posicao, Toast.LENGTH_SHORT).show();

               // Toast.makeText(Activity_teste.this,"Id:"+serie,Toast.LENGTH_SHORT).show();

               // Toast.makeText(Activity_teste.this, "Id:" + posicao, Toast.LENGTH_SHORT).show();

                //disciplina = posicao;


                //Arte

                if (posicao == 0){


                    spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


                        @Override
                        public void onItemSelected(AdapterView<?> parent, View v, int posicao1, long id2) {

                            //pega nome pela posicao
                            ano = parent.getItemAtPosition(posicao1).toString();
                            //imprime um Toast na tela com o nome e posição do item selecionado
                            //Toast.makeText(Activity_teste.this, "Série: " + ano, Toast.LENGTH_LONG).show();
                            //Toast.makeText(Activity_teste.this, "Id:" + posicao, Toast.LENGTH_SHORT).show();


                             if (posicao1 == 0){

                                 fl_cont_arte_sexto.setVisibility(View.GONE);
                                 fl_cont_arte_setimo.setVisibility(View.GONE);
                                 fl_cont_arte_oitavo.setVisibility(View.GONE);
                                 fl_cont_arte_nono.setVisibility(View.GONE);

                                 fl_cont_ciencias_sexto.setVisibility(View.GONE);
                                 fl_cont_ciencias_setimo.setVisibility(View.GONE);
                                 fl_cont_ciencias_oitavo.setVisibility(View.GONE);
                                 fl_cont_ciencias_nono.setVisibility(View.GONE);

                                 fl_cont_ed_fisica_sexto.setVisibility(View.GONE);
                                 fl_cont_ed_fisica_setimo.setVisibility(View.GONE);
                                 fl_cont_ed_fisica_oitavo.setVisibility(View.GONE);
                                 fl_cont_ed_fisica_nono.setVisibility(View.GONE);

                                 fl_cont_ens_religioso_sexto.setVisibility(View.GONE);
                                 fl_cont_ens_religioso_setimo.setVisibility(View.GONE);
                                 fl_cont_ens_religioso_oitavo.setVisibility(View.GONE);
                                 fl_cont_ens_religioso_nono.setVisibility(View.GONE);

                                 fl_cont_geografia_sexto.setVisibility(View.GONE);
                                 fl_cont_geografia_setimo.setVisibility(View.GONE);
                                 fl_cont_geografia_oitavo.setVisibility(View.GONE);
                                 fl_cont_geografia_nono.setVisibility(View.GONE);

                                 fl_cont_historia_sexto.setVisibility(View.GONE);
                                 fl_cont_historia_setimo.setVisibility(View.GONE);
                                 fl_cont_historia_oitavo.setVisibility(View.GONE);
                                 fl_cont_historia_nono.setVisibility(View.GONE);

                                 fl_cont_matematica_sexto.setVisibility(View.GONE);
                                 fl_cont_matematica_setimo.setVisibility(View.GONE);
                                 fl_cont_matematica_oitavo.setVisibility(View.GONE);
                                 fl_cont_matematica_nono.setVisibility(View.GONE);

                                 fl_cont_portugues_sexto.setVisibility(View.GONE);
                                 fl_cont_portugues_setimo.setVisibility(View.GONE);
                                 fl_cont_portugues_oitavo.setVisibility(View.GONE);
                                 fl_cont_portugues_nono.setVisibility(View.GONE);


                                 fl_cont_arte_sexto.setVisibility(View.VISIBLE);

                            }


                            if (posicao1 == 1){

                                fl_cont_arte_sexto.setVisibility(View.GONE);
                                fl_cont_arte_setimo.setVisibility(View.GONE);
                                fl_cont_arte_oitavo.setVisibility(View.GONE);
                                fl_cont_arte_nono.setVisibility(View.GONE);

                                fl_cont_ciencias_sexto.setVisibility(View.GONE);
                                fl_cont_ciencias_setimo.setVisibility(View.GONE);
                                fl_cont_ciencias_oitavo.setVisibility(View.GONE);
                                fl_cont_ciencias_nono.setVisibility(View.GONE);

                                fl_cont_ed_fisica_sexto.setVisibility(View.GONE);
                                fl_cont_ed_fisica_setimo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_oitavo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_nono.setVisibility(View.GONE);

                                fl_cont_ens_religioso_sexto.setVisibility(View.GONE);
                                fl_cont_ens_religioso_setimo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_oitavo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_nono.setVisibility(View.GONE);

                                fl_cont_geografia_sexto.setVisibility(View.GONE);
                                fl_cont_geografia_setimo.setVisibility(View.GONE);
                                fl_cont_geografia_oitavo.setVisibility(View.GONE);
                                fl_cont_geografia_nono.setVisibility(View.GONE);

                                fl_cont_historia_sexto.setVisibility(View.GONE);
                                fl_cont_historia_setimo.setVisibility(View.GONE);
                                fl_cont_historia_oitavo.setVisibility(View.GONE);
                                fl_cont_historia_nono.setVisibility(View.GONE);

                                fl_cont_matematica_sexto.setVisibility(View.GONE);
                                fl_cont_matematica_setimo.setVisibility(View.GONE);
                                fl_cont_matematica_oitavo.setVisibility(View.GONE);
                                fl_cont_matematica_nono.setVisibility(View.GONE);

                                fl_cont_portugues_sexto.setVisibility(View.GONE);
                                fl_cont_portugues_setimo.setVisibility(View.GONE);
                                fl_cont_portugues_oitavo.setVisibility(View.GONE);
                                fl_cont_portugues_nono.setVisibility(View.GONE);


                                fl_cont_arte_setimo.setVisibility(View.VISIBLE);

                            }
                            if (posicao1 == 2){

                                fl_cont_arte_sexto.setVisibility(View.GONE);
                                fl_cont_arte_setimo.setVisibility(View.GONE);
                                fl_cont_arte_oitavo.setVisibility(View.GONE);
                                fl_cont_arte_nono.setVisibility(View.GONE);

                                fl_cont_ciencias_sexto.setVisibility(View.GONE);
                                fl_cont_ciencias_setimo.setVisibility(View.GONE);
                                fl_cont_ciencias_oitavo.setVisibility(View.GONE);
                                fl_cont_ciencias_nono.setVisibility(View.GONE);

                                fl_cont_ed_fisica_sexto.setVisibility(View.GONE);
                                fl_cont_ed_fisica_setimo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_oitavo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_nono.setVisibility(View.GONE);

                                fl_cont_ens_religioso_sexto.setVisibility(View.GONE);
                                fl_cont_ens_religioso_setimo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_oitavo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_nono.setVisibility(View.GONE);

                                fl_cont_geografia_sexto.setVisibility(View.GONE);
                                fl_cont_geografia_setimo.setVisibility(View.GONE);
                                fl_cont_geografia_oitavo.setVisibility(View.GONE);
                                fl_cont_geografia_nono.setVisibility(View.GONE);

                                fl_cont_historia_sexto.setVisibility(View.GONE);
                                fl_cont_historia_setimo.setVisibility(View.GONE);
                                fl_cont_historia_oitavo.setVisibility(View.GONE);
                                fl_cont_historia_nono.setVisibility(View.GONE);

                                fl_cont_matematica_sexto.setVisibility(View.GONE);
                                fl_cont_matematica_setimo.setVisibility(View.GONE);
                                fl_cont_matematica_oitavo.setVisibility(View.GONE);
                                fl_cont_matematica_nono.setVisibility(View.GONE);

                                fl_cont_portugues_sexto.setVisibility(View.GONE);
                                fl_cont_portugues_setimo.setVisibility(View.GONE);
                                fl_cont_portugues_oitavo.setVisibility(View.GONE);
                                fl_cont_portugues_nono.setVisibility(View.GONE);


                                fl_cont_arte_oitavo.setVisibility(View.VISIBLE);

                            }
                            if (posicao1 == 3){

                                fl_cont_arte_sexto.setVisibility(View.GONE);
                                fl_cont_arte_setimo.setVisibility(View.GONE);
                                fl_cont_arte_oitavo.setVisibility(View.GONE);
                                fl_cont_arte_nono.setVisibility(View.GONE);

                                fl_cont_ciencias_sexto.setVisibility(View.GONE);
                                fl_cont_ciencias_setimo.setVisibility(View.GONE);
                                fl_cont_ciencias_oitavo.setVisibility(View.GONE);
                                fl_cont_ciencias_nono.setVisibility(View.GONE);

                                fl_cont_ed_fisica_sexto.setVisibility(View.GONE);
                                fl_cont_ed_fisica_setimo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_oitavo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_nono.setVisibility(View.GONE);

                                fl_cont_ens_religioso_sexto.setVisibility(View.GONE);
                                fl_cont_ens_religioso_setimo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_oitavo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_nono.setVisibility(View.GONE);

                                fl_cont_geografia_sexto.setVisibility(View.GONE);
                                fl_cont_geografia_setimo.setVisibility(View.GONE);
                                fl_cont_geografia_oitavo.setVisibility(View.GONE);
                                fl_cont_geografia_nono.setVisibility(View.GONE);

                                fl_cont_historia_sexto.setVisibility(View.GONE);
                                fl_cont_historia_setimo.setVisibility(View.GONE);
                                fl_cont_historia_oitavo.setVisibility(View.GONE);
                                fl_cont_historia_nono.setVisibility(View.GONE);

                                fl_cont_matematica_sexto.setVisibility(View.GONE);
                                fl_cont_matematica_setimo.setVisibility(View.GONE);
                                fl_cont_matematica_oitavo.setVisibility(View.GONE);
                                fl_cont_matematica_nono.setVisibility(View.GONE);

                                fl_cont_portugues_sexto.setVisibility(View.GONE);
                                fl_cont_portugues_setimo.setVisibility(View.GONE);
                                fl_cont_portugues_oitavo.setVisibility(View.GONE);
                                fl_cont_portugues_nono.setVisibility(View.GONE);


                                fl_cont_arte_nono.setVisibility(View.VISIBLE);
                            }

                             else {

                                //fl_cont_arte_sexto.setVisibility(View.VISIBLE);

                              }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }


                    });



                }


                //Ciencias
                if (posicao == 1){

                    spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


                        @Override
                        public void onItemSelected(AdapterView<?> parent, View v, int posicao1, long id2) {

                            //pega nome pela posicao
                            ano = parent.getItemAtPosition(posicao1).toString();
                            //imprime um Toast na tela com o nome e posição do item selecionado
                            //Toast.makeText(Activity_teste.this, "Série: " + ano, Toast.LENGTH_LONG).show();
                            //Toast.makeText(Activity_teste.this, "Id:" + posicao, Toast.LENGTH_SHORT).show();


                            if (posicao1 == 0){

                                fl_cont_arte_sexto.setVisibility(View.GONE);
                                fl_cont_arte_setimo.setVisibility(View.GONE);
                                fl_cont_arte_oitavo.setVisibility(View.GONE);
                                fl_cont_arte_nono.setVisibility(View.GONE);

                                fl_cont_ciencias_sexto.setVisibility(View.GONE);
                                fl_cont_ciencias_setimo.setVisibility(View.GONE);
                                fl_cont_ciencias_oitavo.setVisibility(View.GONE);
                                fl_cont_ciencias_nono.setVisibility(View.GONE);

                                fl_cont_ed_fisica_sexto.setVisibility(View.GONE);
                                fl_cont_ed_fisica_setimo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_oitavo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_nono.setVisibility(View.GONE);

                                fl_cont_ens_religioso_sexto.setVisibility(View.GONE);
                                fl_cont_ens_religioso_setimo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_oitavo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_nono.setVisibility(View.GONE);

                                fl_cont_geografia_sexto.setVisibility(View.GONE);
                                fl_cont_geografia_setimo.setVisibility(View.GONE);
                                fl_cont_geografia_oitavo.setVisibility(View.GONE);
                                fl_cont_geografia_nono.setVisibility(View.GONE);

                                fl_cont_historia_sexto.setVisibility(View.GONE);
                                fl_cont_historia_setimo.setVisibility(View.GONE);
                                fl_cont_historia_oitavo.setVisibility(View.GONE);
                                fl_cont_historia_nono.setVisibility(View.GONE);

                                fl_cont_matematica_sexto.setVisibility(View.GONE);
                                fl_cont_matematica_setimo.setVisibility(View.GONE);
                                fl_cont_matematica_oitavo.setVisibility(View.GONE);
                                fl_cont_matematica_nono.setVisibility(View.GONE);

                                fl_cont_portugues_sexto.setVisibility(View.GONE);
                                fl_cont_portugues_setimo.setVisibility(View.GONE);
                                fl_cont_portugues_oitavo.setVisibility(View.GONE);
                                fl_cont_portugues_nono.setVisibility(View.GONE);


                                fl_cont_ciencias_sexto.setVisibility(View.VISIBLE);

                            }


                            if (posicao1 == 1){

                                fl_cont_arte_sexto.setVisibility(View.GONE);
                                fl_cont_arte_setimo.setVisibility(View.GONE);
                                fl_cont_arte_oitavo.setVisibility(View.GONE);
                                fl_cont_arte_nono.setVisibility(View.GONE);

                                fl_cont_ciencias_sexto.setVisibility(View.GONE);
                                fl_cont_ciencias_setimo.setVisibility(View.GONE);
                                fl_cont_ciencias_oitavo.setVisibility(View.GONE);
                                fl_cont_ciencias_nono.setVisibility(View.GONE);

                                fl_cont_ed_fisica_sexto.setVisibility(View.GONE);
                                fl_cont_ed_fisica_setimo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_oitavo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_nono.setVisibility(View.GONE);

                                fl_cont_ens_religioso_sexto.setVisibility(View.GONE);
                                fl_cont_ens_religioso_setimo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_oitavo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_nono.setVisibility(View.GONE);

                                fl_cont_geografia_sexto.setVisibility(View.GONE);
                                fl_cont_geografia_setimo.setVisibility(View.GONE);
                                fl_cont_geografia_oitavo.setVisibility(View.GONE);
                                fl_cont_geografia_nono.setVisibility(View.GONE);

                                fl_cont_historia_sexto.setVisibility(View.GONE);
                                fl_cont_historia_setimo.setVisibility(View.GONE);
                                fl_cont_historia_oitavo.setVisibility(View.GONE);
                                fl_cont_historia_nono.setVisibility(View.GONE);

                                fl_cont_matematica_sexto.setVisibility(View.GONE);
                                fl_cont_matematica_setimo.setVisibility(View.GONE);
                                fl_cont_matematica_oitavo.setVisibility(View.GONE);
                                fl_cont_matematica_nono.setVisibility(View.GONE);

                                fl_cont_portugues_sexto.setVisibility(View.GONE);
                                fl_cont_portugues_setimo.setVisibility(View.GONE);
                                fl_cont_portugues_oitavo.setVisibility(View.GONE);
                                fl_cont_portugues_nono.setVisibility(View.GONE);


                                fl_cont_ciencias_setimo.setVisibility(View.VISIBLE);

                            }
                            if (posicao1 == 2){

                                fl_cont_arte_sexto.setVisibility(View.GONE);
                                fl_cont_arte_setimo.setVisibility(View.GONE);
                                fl_cont_arte_oitavo.setVisibility(View.GONE);
                                fl_cont_arte_nono.setVisibility(View.GONE);

                                fl_cont_ciencias_sexto.setVisibility(View.GONE);
                                fl_cont_ciencias_setimo.setVisibility(View.GONE);
                                fl_cont_ciencias_oitavo.setVisibility(View.GONE);
                                fl_cont_ciencias_nono.setVisibility(View.GONE);

                                fl_cont_ed_fisica_sexto.setVisibility(View.GONE);
                                fl_cont_ed_fisica_setimo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_oitavo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_nono.setVisibility(View.GONE);

                                fl_cont_ens_religioso_sexto.setVisibility(View.GONE);
                                fl_cont_ens_religioso_setimo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_oitavo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_nono.setVisibility(View.GONE);

                                fl_cont_geografia_sexto.setVisibility(View.GONE);
                                fl_cont_geografia_setimo.setVisibility(View.GONE);
                                fl_cont_geografia_oitavo.setVisibility(View.GONE);
                                fl_cont_geografia_nono.setVisibility(View.GONE);

                                fl_cont_historia_sexto.setVisibility(View.GONE);
                                fl_cont_historia_setimo.setVisibility(View.GONE);
                                fl_cont_historia_oitavo.setVisibility(View.GONE);
                                fl_cont_historia_nono.setVisibility(View.GONE);

                                fl_cont_matematica_sexto.setVisibility(View.GONE);
                                fl_cont_matematica_setimo.setVisibility(View.GONE);
                                fl_cont_matematica_oitavo.setVisibility(View.GONE);
                                fl_cont_matematica_nono.setVisibility(View.GONE);

                                fl_cont_portugues_sexto.setVisibility(View.GONE);
                                fl_cont_portugues_setimo.setVisibility(View.GONE);
                                fl_cont_portugues_oitavo.setVisibility(View.GONE);
                                fl_cont_portugues_nono.setVisibility(View.GONE);


                                fl_cont_ciencias_oitavo.setVisibility(View.VISIBLE);

                            }
                            if (posicao1 == 3){

                                fl_cont_arte_sexto.setVisibility(View.GONE);
                                fl_cont_arte_setimo.setVisibility(View.GONE);
                                fl_cont_arte_oitavo.setVisibility(View.GONE);
                                fl_cont_arte_nono.setVisibility(View.GONE);

                                fl_cont_ciencias_sexto.setVisibility(View.GONE);
                                fl_cont_ciencias_setimo.setVisibility(View.GONE);
                                fl_cont_ciencias_oitavo.setVisibility(View.GONE);
                                fl_cont_ciencias_nono.setVisibility(View.GONE);

                                fl_cont_ed_fisica_sexto.setVisibility(View.GONE);
                                fl_cont_ed_fisica_setimo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_oitavo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_nono.setVisibility(View.GONE);

                                fl_cont_ens_religioso_sexto.setVisibility(View.GONE);
                                fl_cont_ens_religioso_setimo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_oitavo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_nono.setVisibility(View.GONE);

                                fl_cont_geografia_sexto.setVisibility(View.GONE);
                                fl_cont_geografia_setimo.setVisibility(View.GONE);
                                fl_cont_geografia_oitavo.setVisibility(View.GONE);
                                fl_cont_geografia_nono.setVisibility(View.GONE);

                                fl_cont_historia_sexto.setVisibility(View.GONE);
                                fl_cont_historia_setimo.setVisibility(View.GONE);
                                fl_cont_historia_oitavo.setVisibility(View.GONE);
                                fl_cont_historia_nono.setVisibility(View.GONE);

                                fl_cont_matematica_sexto.setVisibility(View.GONE);
                                fl_cont_matematica_setimo.setVisibility(View.GONE);
                                fl_cont_matematica_oitavo.setVisibility(View.GONE);
                                fl_cont_matematica_nono.setVisibility(View.GONE);

                                fl_cont_portugues_sexto.setVisibility(View.GONE);
                                fl_cont_portugues_setimo.setVisibility(View.GONE);
                                fl_cont_portugues_oitavo.setVisibility(View.GONE);
                                fl_cont_portugues_nono.setVisibility(View.GONE);


                                fl_cont_ciencias_nono.setVisibility(View.VISIBLE);
                            }

                            else {

                                //fl_cont_arte_sexto.setVisibility(View.VISIBLE);

                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }


                    });

                }

                //ed_fisica
                if (posicao == 2){

                    spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


                        @Override
                        public void onItemSelected(AdapterView<?> parent, View v, int posicao1, long id2) {

                            //pega nome pela posicao
                            ano = parent.getItemAtPosition(posicao1).toString();
                            //imprime um Toast na tela com o nome e posição do item selecionado
                            //Toast.makeText(Activity_teste.this, "Série: " + ano, Toast.LENGTH_LONG).show();
                            //Toast.makeText(Activity_teste.this, "Id:" + posicao, Toast.LENGTH_SHORT).show();


                            if (posicao1 == 0){

                                fl_cont_arte_sexto.setVisibility(View.GONE);
                                fl_cont_arte_setimo.setVisibility(View.GONE);
                                fl_cont_arte_oitavo.setVisibility(View.GONE);
                                fl_cont_arte_nono.setVisibility(View.GONE);

                                fl_cont_ciencias_sexto.setVisibility(View.GONE);
                                fl_cont_ciencias_setimo.setVisibility(View.GONE);
                                fl_cont_ciencias_oitavo.setVisibility(View.GONE);
                                fl_cont_ciencias_nono.setVisibility(View.GONE);

                                fl_cont_ed_fisica_sexto.setVisibility(View.GONE);
                                fl_cont_ed_fisica_setimo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_oitavo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_nono.setVisibility(View.GONE);

                                fl_cont_ens_religioso_sexto.setVisibility(View.GONE);
                                fl_cont_ens_religioso_setimo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_oitavo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_nono.setVisibility(View.GONE);

                                fl_cont_geografia_sexto.setVisibility(View.GONE);
                                fl_cont_geografia_setimo.setVisibility(View.GONE);
                                fl_cont_geografia_oitavo.setVisibility(View.GONE);
                                fl_cont_geografia_nono.setVisibility(View.GONE);

                                fl_cont_historia_sexto.setVisibility(View.GONE);
                                fl_cont_historia_setimo.setVisibility(View.GONE);
                                fl_cont_historia_oitavo.setVisibility(View.GONE);
                                fl_cont_historia_nono.setVisibility(View.GONE);

                                fl_cont_matematica_sexto.setVisibility(View.GONE);
                                fl_cont_matematica_setimo.setVisibility(View.GONE);
                                fl_cont_matematica_oitavo.setVisibility(View.GONE);
                                fl_cont_matematica_nono.setVisibility(View.GONE);

                                fl_cont_portugues_sexto.setVisibility(View.GONE);
                                fl_cont_portugues_setimo.setVisibility(View.GONE);
                                fl_cont_portugues_oitavo.setVisibility(View.GONE);
                                fl_cont_portugues_nono.setVisibility(View.GONE);


                                fl_cont_ed_fisica_sexto.setVisibility(View.VISIBLE);

                            }


                            if (posicao1 == 1){

                                fl_cont_arte_sexto.setVisibility(View.GONE);
                                fl_cont_arte_setimo.setVisibility(View.GONE);
                                fl_cont_arte_oitavo.setVisibility(View.GONE);
                                fl_cont_arte_nono.setVisibility(View.GONE);

                                fl_cont_ciencias_sexto.setVisibility(View.GONE);
                                fl_cont_ciencias_setimo.setVisibility(View.GONE);
                                fl_cont_ciencias_oitavo.setVisibility(View.GONE);
                                fl_cont_ciencias_nono.setVisibility(View.GONE);

                                fl_cont_ed_fisica_sexto.setVisibility(View.GONE);
                                fl_cont_ed_fisica_setimo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_oitavo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_nono.setVisibility(View.GONE);

                                fl_cont_ens_religioso_sexto.setVisibility(View.GONE);
                                fl_cont_ens_religioso_setimo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_oitavo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_nono.setVisibility(View.GONE);

                                fl_cont_geografia_sexto.setVisibility(View.GONE);
                                fl_cont_geografia_setimo.setVisibility(View.GONE);
                                fl_cont_geografia_oitavo.setVisibility(View.GONE);
                                fl_cont_geografia_nono.setVisibility(View.GONE);

                                fl_cont_historia_sexto.setVisibility(View.GONE);
                                fl_cont_historia_setimo.setVisibility(View.GONE);
                                fl_cont_historia_oitavo.setVisibility(View.GONE);
                                fl_cont_historia_nono.setVisibility(View.GONE);

                                fl_cont_matematica_sexto.setVisibility(View.GONE);
                                fl_cont_matematica_setimo.setVisibility(View.GONE);
                                fl_cont_matematica_oitavo.setVisibility(View.GONE);
                                fl_cont_matematica_nono.setVisibility(View.GONE);

                                fl_cont_portugues_sexto.setVisibility(View.GONE);
                                fl_cont_portugues_setimo.setVisibility(View.GONE);
                                fl_cont_portugues_oitavo.setVisibility(View.GONE);
                                fl_cont_portugues_nono.setVisibility(View.GONE);


                                fl_cont_ed_fisica_setimo.setVisibility(View.VISIBLE);

                            }
                            if (posicao1 == 2){

                                fl_cont_arte_sexto.setVisibility(View.GONE);
                                fl_cont_arte_setimo.setVisibility(View.GONE);
                                fl_cont_arte_oitavo.setVisibility(View.GONE);
                                fl_cont_arte_nono.setVisibility(View.GONE);

                                fl_cont_ciencias_sexto.setVisibility(View.GONE);
                                fl_cont_ciencias_setimo.setVisibility(View.GONE);
                                fl_cont_ciencias_oitavo.setVisibility(View.GONE);
                                fl_cont_ciencias_nono.setVisibility(View.GONE);

                                fl_cont_ed_fisica_sexto.setVisibility(View.GONE);
                                fl_cont_ed_fisica_setimo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_oitavo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_nono.setVisibility(View.GONE);

                                fl_cont_ens_religioso_sexto.setVisibility(View.GONE);
                                fl_cont_ens_religioso_setimo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_oitavo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_nono.setVisibility(View.GONE);

                                fl_cont_geografia_sexto.setVisibility(View.GONE);
                                fl_cont_geografia_setimo.setVisibility(View.GONE);
                                fl_cont_geografia_oitavo.setVisibility(View.GONE);
                                fl_cont_geografia_nono.setVisibility(View.GONE);

                                fl_cont_historia_sexto.setVisibility(View.GONE);
                                fl_cont_historia_setimo.setVisibility(View.GONE);
                                fl_cont_historia_oitavo.setVisibility(View.GONE);
                                fl_cont_historia_nono.setVisibility(View.GONE);

                                fl_cont_matematica_sexto.setVisibility(View.GONE);
                                fl_cont_matematica_setimo.setVisibility(View.GONE);
                                fl_cont_matematica_oitavo.setVisibility(View.GONE);
                                fl_cont_matematica_nono.setVisibility(View.GONE);

                                fl_cont_portugues_sexto.setVisibility(View.GONE);
                                fl_cont_portugues_setimo.setVisibility(View.GONE);
                                fl_cont_portugues_oitavo.setVisibility(View.GONE);
                                fl_cont_portugues_nono.setVisibility(View.GONE);


                                fl_cont_ed_fisica_oitavo.setVisibility(View.VISIBLE);

                            }
                            if (posicao1 == 3){

                                fl_cont_arte_sexto.setVisibility(View.GONE);
                                fl_cont_arte_setimo.setVisibility(View.GONE);
                                fl_cont_arte_oitavo.setVisibility(View.GONE);
                                fl_cont_arte_nono.setVisibility(View.GONE);

                                fl_cont_ciencias_sexto.setVisibility(View.GONE);
                                fl_cont_ciencias_setimo.setVisibility(View.GONE);
                                fl_cont_ciencias_oitavo.setVisibility(View.GONE);
                                fl_cont_ciencias_nono.setVisibility(View.GONE);

                                fl_cont_ed_fisica_sexto.setVisibility(View.GONE);
                                fl_cont_ed_fisica_setimo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_oitavo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_nono.setVisibility(View.GONE);

                                fl_cont_ens_religioso_sexto.setVisibility(View.GONE);
                                fl_cont_ens_religioso_setimo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_oitavo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_nono.setVisibility(View.GONE);

                                fl_cont_geografia_sexto.setVisibility(View.GONE);
                                fl_cont_geografia_setimo.setVisibility(View.GONE);
                                fl_cont_geografia_oitavo.setVisibility(View.GONE);
                                fl_cont_geografia_nono.setVisibility(View.GONE);

                                fl_cont_historia_sexto.setVisibility(View.GONE);
                                fl_cont_historia_setimo.setVisibility(View.GONE);
                                fl_cont_historia_oitavo.setVisibility(View.GONE);
                                fl_cont_historia_nono.setVisibility(View.GONE);

                                fl_cont_matematica_sexto.setVisibility(View.GONE);
                                fl_cont_matematica_setimo.setVisibility(View.GONE);
                                fl_cont_matematica_oitavo.setVisibility(View.GONE);
                                fl_cont_matematica_nono.setVisibility(View.GONE);

                                fl_cont_portugues_sexto.setVisibility(View.GONE);
                                fl_cont_portugues_setimo.setVisibility(View.GONE);
                                fl_cont_portugues_oitavo.setVisibility(View.GONE);
                                fl_cont_portugues_nono.setVisibility(View.GONE);


                                fl_cont_ed_fisica_nono.setVisibility(View.VISIBLE);
                            }

                            else {

                                //fl_cont_arte_sexto.setVisibility(View.VISIBLE);

                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }


                    });



                }

                //ens_religioso
                if (posicao == 3){

                    spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


                        @Override
                        public void onItemSelected(AdapterView<?> parent, View v, int posicao1, long id2) {

                            //pega nome pela posicao
                            ano = parent.getItemAtPosition(posicao1).toString();
                            //imprime um Toast na tela com o nome e posição do item selecionado
                            //Toast.makeText(Activity_teste.this, "Série: " + ano, Toast.LENGTH_LONG).show();
                            //Toast.makeText(Activity_teste.this, "Id:" + posicao, Toast.LENGTH_SHORT).show();


                            if (posicao1 == 0){

                                fl_cont_arte_sexto.setVisibility(View.GONE);
                                fl_cont_arte_setimo.setVisibility(View.GONE);
                                fl_cont_arte_oitavo.setVisibility(View.GONE);
                                fl_cont_arte_nono.setVisibility(View.GONE);

                                fl_cont_ciencias_sexto.setVisibility(View.GONE);
                                fl_cont_ciencias_setimo.setVisibility(View.GONE);
                                fl_cont_ciencias_oitavo.setVisibility(View.GONE);
                                fl_cont_ciencias_nono.setVisibility(View.GONE);

                                fl_cont_ed_fisica_sexto.setVisibility(View.GONE);
                                fl_cont_ed_fisica_setimo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_oitavo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_nono.setVisibility(View.GONE);

                                fl_cont_ens_religioso_sexto.setVisibility(View.GONE);
                                fl_cont_ens_religioso_setimo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_oitavo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_nono.setVisibility(View.GONE);

                                fl_cont_geografia_sexto.setVisibility(View.GONE);
                                fl_cont_geografia_setimo.setVisibility(View.GONE);
                                fl_cont_geografia_oitavo.setVisibility(View.GONE);
                                fl_cont_geografia_nono.setVisibility(View.GONE);

                                fl_cont_historia_sexto.setVisibility(View.GONE);
                                fl_cont_historia_setimo.setVisibility(View.GONE);
                                fl_cont_historia_oitavo.setVisibility(View.GONE);
                                fl_cont_historia_nono.setVisibility(View.GONE);

                                fl_cont_matematica_sexto.setVisibility(View.GONE);
                                fl_cont_matematica_setimo.setVisibility(View.GONE);
                                fl_cont_matematica_oitavo.setVisibility(View.GONE);
                                fl_cont_matematica_nono.setVisibility(View.GONE);

                                fl_cont_portugues_sexto.setVisibility(View.GONE);
                                fl_cont_portugues_setimo.setVisibility(View.GONE);
                                fl_cont_portugues_oitavo.setVisibility(View.GONE);
                                fl_cont_portugues_nono.setVisibility(View.GONE);


                                fl_cont_ens_religioso_sexto.setVisibility(View.VISIBLE);

                            }


                            if (posicao1 == 1){

                                fl_cont_arte_sexto.setVisibility(View.GONE);
                                fl_cont_arte_setimo.setVisibility(View.GONE);
                                fl_cont_arte_oitavo.setVisibility(View.GONE);
                                fl_cont_arte_nono.setVisibility(View.GONE);

                                fl_cont_ciencias_sexto.setVisibility(View.GONE);
                                fl_cont_ciencias_setimo.setVisibility(View.GONE);
                                fl_cont_ciencias_oitavo.setVisibility(View.GONE);
                                fl_cont_ciencias_nono.setVisibility(View.GONE);

                                fl_cont_ed_fisica_sexto.setVisibility(View.GONE);
                                fl_cont_ed_fisica_setimo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_oitavo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_nono.setVisibility(View.GONE);

                                fl_cont_ens_religioso_sexto.setVisibility(View.GONE);
                                fl_cont_ens_religioso_setimo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_oitavo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_nono.setVisibility(View.GONE);

                                fl_cont_geografia_sexto.setVisibility(View.GONE);
                                fl_cont_geografia_setimo.setVisibility(View.GONE);
                                fl_cont_geografia_oitavo.setVisibility(View.GONE);
                                fl_cont_geografia_nono.setVisibility(View.GONE);

                                fl_cont_historia_sexto.setVisibility(View.GONE);
                                fl_cont_historia_setimo.setVisibility(View.GONE);
                                fl_cont_historia_oitavo.setVisibility(View.GONE);
                                fl_cont_historia_nono.setVisibility(View.GONE);

                                fl_cont_matematica_sexto.setVisibility(View.GONE);
                                fl_cont_matematica_setimo.setVisibility(View.GONE);
                                fl_cont_matematica_oitavo.setVisibility(View.GONE);
                                fl_cont_matematica_nono.setVisibility(View.GONE);

                                fl_cont_portugues_sexto.setVisibility(View.GONE);
                                fl_cont_portugues_setimo.setVisibility(View.GONE);
                                fl_cont_portugues_oitavo.setVisibility(View.GONE);
                                fl_cont_portugues_nono.setVisibility(View.GONE);


                                fl_cont_ens_religioso_setimo.setVisibility(View.VISIBLE);

                            }
                            if (posicao1 == 2){

                                fl_cont_arte_sexto.setVisibility(View.GONE);
                                fl_cont_arte_setimo.setVisibility(View.GONE);
                                fl_cont_arte_oitavo.setVisibility(View.GONE);
                                fl_cont_arte_nono.setVisibility(View.GONE);

                                fl_cont_ciencias_sexto.setVisibility(View.GONE);
                                fl_cont_ciencias_setimo.setVisibility(View.GONE);
                                fl_cont_ciencias_oitavo.setVisibility(View.GONE);
                                fl_cont_ciencias_nono.setVisibility(View.GONE);

                                fl_cont_ed_fisica_sexto.setVisibility(View.GONE);
                                fl_cont_ed_fisica_setimo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_oitavo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_nono.setVisibility(View.GONE);

                                fl_cont_ens_religioso_sexto.setVisibility(View.GONE);
                                fl_cont_ens_religioso_setimo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_oitavo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_nono.setVisibility(View.GONE);

                                fl_cont_geografia_sexto.setVisibility(View.GONE);
                                fl_cont_geografia_setimo.setVisibility(View.GONE);
                                fl_cont_geografia_oitavo.setVisibility(View.GONE);
                                fl_cont_geografia_nono.setVisibility(View.GONE);

                                fl_cont_historia_sexto.setVisibility(View.GONE);
                                fl_cont_historia_setimo.setVisibility(View.GONE);
                                fl_cont_historia_oitavo.setVisibility(View.GONE);
                                fl_cont_historia_nono.setVisibility(View.GONE);

                                fl_cont_matematica_sexto.setVisibility(View.GONE);
                                fl_cont_matematica_setimo.setVisibility(View.GONE);
                                fl_cont_matematica_oitavo.setVisibility(View.GONE);
                                fl_cont_matematica_nono.setVisibility(View.GONE);

                                fl_cont_portugues_sexto.setVisibility(View.GONE);
                                fl_cont_portugues_setimo.setVisibility(View.GONE);
                                fl_cont_portugues_oitavo.setVisibility(View.GONE);
                                fl_cont_portugues_nono.setVisibility(View.GONE);


                                fl_cont_ens_religioso_oitavo.setVisibility(View.VISIBLE);

                            }
                            if (posicao1 == 3){

                                fl_cont_arte_sexto.setVisibility(View.GONE);
                                fl_cont_arte_setimo.setVisibility(View.GONE);
                                fl_cont_arte_oitavo.setVisibility(View.GONE);
                                fl_cont_arte_nono.setVisibility(View.GONE);

                                fl_cont_ciencias_sexto.setVisibility(View.GONE);
                                fl_cont_ciencias_setimo.setVisibility(View.GONE);
                                fl_cont_ciencias_oitavo.setVisibility(View.GONE);
                                fl_cont_ciencias_nono.setVisibility(View.GONE);

                                fl_cont_ed_fisica_sexto.setVisibility(View.GONE);
                                fl_cont_ed_fisica_setimo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_oitavo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_nono.setVisibility(View.GONE);

                                fl_cont_ens_religioso_sexto.setVisibility(View.GONE);
                                fl_cont_ens_religioso_setimo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_oitavo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_nono.setVisibility(View.GONE);

                                fl_cont_geografia_sexto.setVisibility(View.GONE);
                                fl_cont_geografia_setimo.setVisibility(View.GONE);
                                fl_cont_geografia_oitavo.setVisibility(View.GONE);
                                fl_cont_geografia_nono.setVisibility(View.GONE);

                                fl_cont_historia_sexto.setVisibility(View.GONE);
                                fl_cont_historia_setimo.setVisibility(View.GONE);
                                fl_cont_historia_oitavo.setVisibility(View.GONE);
                                fl_cont_historia_nono.setVisibility(View.GONE);

                                fl_cont_matematica_sexto.setVisibility(View.GONE);
                                fl_cont_matematica_setimo.setVisibility(View.GONE);
                                fl_cont_matematica_oitavo.setVisibility(View.GONE);
                                fl_cont_matematica_nono.setVisibility(View.GONE);

                                fl_cont_portugues_sexto.setVisibility(View.GONE);
                                fl_cont_portugues_setimo.setVisibility(View.GONE);
                                fl_cont_portugues_oitavo.setVisibility(View.GONE);
                                fl_cont_portugues_nono.setVisibility(View.GONE);


                                fl_cont_ens_religioso_nono.setVisibility(View.VISIBLE);
                            }

                            else {

                                //fl_cont_arte_sexto.setVisibility(View.VISIBLE);

                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }


                    });


                }

                //geografia
                if (posicao == 4){

                    spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


                        @Override
                        public void onItemSelected(AdapterView<?> parent, View v, int posicao1, long id2) {

                            //pega nome pela posicao
                            ano = parent.getItemAtPosition(posicao1).toString();
                            //imprime um Toast na tela com o nome e posição do item selecionado
                            //Toast.makeText(Activity_teste.this, "Série: " + ano, Toast.LENGTH_LONG).show();
                            //Toast.makeText(Activity_teste.this, "Id:" + posicao, Toast.LENGTH_SHORT).show();


                            if (posicao1 == 0){

                                fl_cont_arte_sexto.setVisibility(View.GONE);
                                fl_cont_arte_setimo.setVisibility(View.GONE);
                                fl_cont_arte_oitavo.setVisibility(View.GONE);
                                fl_cont_arte_nono.setVisibility(View.GONE);

                                fl_cont_ciencias_sexto.setVisibility(View.GONE);
                                fl_cont_ciencias_setimo.setVisibility(View.GONE);
                                fl_cont_ciencias_oitavo.setVisibility(View.GONE);
                                fl_cont_ciencias_nono.setVisibility(View.GONE);

                                fl_cont_ed_fisica_sexto.setVisibility(View.GONE);
                                fl_cont_ed_fisica_setimo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_oitavo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_nono.setVisibility(View.GONE);

                                fl_cont_ens_religioso_sexto.setVisibility(View.GONE);
                                fl_cont_ens_religioso_setimo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_oitavo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_nono.setVisibility(View.GONE);

                                fl_cont_geografia_sexto.setVisibility(View.GONE);
                                fl_cont_geografia_setimo.setVisibility(View.GONE);
                                fl_cont_geografia_oitavo.setVisibility(View.GONE);
                                fl_cont_geografia_nono.setVisibility(View.GONE);

                                fl_cont_historia_sexto.setVisibility(View.GONE);
                                fl_cont_historia_setimo.setVisibility(View.GONE);
                                fl_cont_historia_oitavo.setVisibility(View.GONE);
                                fl_cont_historia_nono.setVisibility(View.GONE);

                                fl_cont_matematica_sexto.setVisibility(View.GONE);
                                fl_cont_matematica_setimo.setVisibility(View.GONE);
                                fl_cont_matematica_oitavo.setVisibility(View.GONE);
                                fl_cont_matematica_nono.setVisibility(View.GONE);

                                fl_cont_portugues_sexto.setVisibility(View.GONE);
                                fl_cont_portugues_setimo.setVisibility(View.GONE);
                                fl_cont_portugues_oitavo.setVisibility(View.GONE);
                                fl_cont_portugues_nono.setVisibility(View.GONE);


                                fl_cont_geografia_sexto.setVisibility(View.VISIBLE);

                            }


                            if (posicao1 == 1){

                                fl_cont_arte_sexto.setVisibility(View.GONE);
                                fl_cont_arte_setimo.setVisibility(View.GONE);
                                fl_cont_arte_oitavo.setVisibility(View.GONE);
                                fl_cont_arte_nono.setVisibility(View.GONE);

                                fl_cont_ciencias_sexto.setVisibility(View.GONE);
                                fl_cont_ciencias_setimo.setVisibility(View.GONE);
                                fl_cont_ciencias_oitavo.setVisibility(View.GONE);
                                fl_cont_ciencias_nono.setVisibility(View.GONE);

                                fl_cont_ed_fisica_sexto.setVisibility(View.GONE);
                                fl_cont_ed_fisica_setimo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_oitavo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_nono.setVisibility(View.GONE);

                                fl_cont_ens_religioso_sexto.setVisibility(View.GONE);
                                fl_cont_ens_religioso_setimo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_oitavo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_nono.setVisibility(View.GONE);

                                fl_cont_geografia_sexto.setVisibility(View.GONE);
                                fl_cont_geografia_setimo.setVisibility(View.GONE);
                                fl_cont_geografia_oitavo.setVisibility(View.GONE);
                                fl_cont_geografia_nono.setVisibility(View.GONE);

                                fl_cont_historia_sexto.setVisibility(View.GONE);
                                fl_cont_historia_setimo.setVisibility(View.GONE);
                                fl_cont_historia_oitavo.setVisibility(View.GONE);
                                fl_cont_historia_nono.setVisibility(View.GONE);

                                fl_cont_matematica_sexto.setVisibility(View.GONE);
                                fl_cont_matematica_setimo.setVisibility(View.GONE);
                                fl_cont_matematica_oitavo.setVisibility(View.GONE);
                                fl_cont_matematica_nono.setVisibility(View.GONE);

                                fl_cont_portugues_sexto.setVisibility(View.GONE);
                                fl_cont_portugues_setimo.setVisibility(View.GONE);
                                fl_cont_portugues_oitavo.setVisibility(View.GONE);
                                fl_cont_portugues_nono.setVisibility(View.GONE);


                                fl_cont_geografia_setimo.setVisibility(View.VISIBLE);

                            }
                            if (posicao1 == 2){

                                fl_cont_arte_sexto.setVisibility(View.GONE);
                                fl_cont_arte_setimo.setVisibility(View.GONE);
                                fl_cont_arte_oitavo.setVisibility(View.GONE);
                                fl_cont_arte_nono.setVisibility(View.GONE);

                                fl_cont_ciencias_sexto.setVisibility(View.GONE);
                                fl_cont_ciencias_setimo.setVisibility(View.GONE);
                                fl_cont_ciencias_oitavo.setVisibility(View.GONE);
                                fl_cont_ciencias_nono.setVisibility(View.GONE);

                                fl_cont_ed_fisica_sexto.setVisibility(View.GONE);
                                fl_cont_ed_fisica_setimo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_oitavo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_nono.setVisibility(View.GONE);

                                fl_cont_ens_religioso_sexto.setVisibility(View.GONE);
                                fl_cont_ens_religioso_setimo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_oitavo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_nono.setVisibility(View.GONE);

                                fl_cont_geografia_sexto.setVisibility(View.GONE);
                                fl_cont_geografia_setimo.setVisibility(View.GONE);
                                fl_cont_geografia_oitavo.setVisibility(View.GONE);
                                fl_cont_geografia_nono.setVisibility(View.GONE);

                                fl_cont_historia_sexto.setVisibility(View.GONE);
                                fl_cont_historia_setimo.setVisibility(View.GONE);
                                fl_cont_historia_oitavo.setVisibility(View.GONE);
                                fl_cont_historia_nono.setVisibility(View.GONE);

                                fl_cont_matematica_sexto.setVisibility(View.GONE);
                                fl_cont_matematica_setimo.setVisibility(View.GONE);
                                fl_cont_matematica_oitavo.setVisibility(View.GONE);
                                fl_cont_matematica_nono.setVisibility(View.GONE);

                                fl_cont_portugues_sexto.setVisibility(View.GONE);
                                fl_cont_portugues_setimo.setVisibility(View.GONE);
                                fl_cont_portugues_oitavo.setVisibility(View.GONE);
                                fl_cont_portugues_nono.setVisibility(View.GONE);


                                fl_cont_geografia_oitavo.setVisibility(View.VISIBLE);

                            }
                            if (posicao1 == 3){

                                fl_cont_arte_sexto.setVisibility(View.GONE);
                                fl_cont_arte_setimo.setVisibility(View.GONE);
                                fl_cont_arte_oitavo.setVisibility(View.GONE);
                                fl_cont_arte_nono.setVisibility(View.GONE);

                                fl_cont_ciencias_sexto.setVisibility(View.GONE);
                                fl_cont_ciencias_setimo.setVisibility(View.GONE);
                                fl_cont_ciencias_oitavo.setVisibility(View.GONE);
                                fl_cont_ciencias_nono.setVisibility(View.GONE);

                                fl_cont_ed_fisica_sexto.setVisibility(View.GONE);
                                fl_cont_ed_fisica_setimo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_oitavo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_nono.setVisibility(View.GONE);

                                fl_cont_ens_religioso_sexto.setVisibility(View.GONE);
                                fl_cont_ens_religioso_setimo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_oitavo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_nono.setVisibility(View.GONE);

                                fl_cont_geografia_sexto.setVisibility(View.GONE);
                                fl_cont_geografia_setimo.setVisibility(View.GONE);
                                fl_cont_geografia_oitavo.setVisibility(View.GONE);
                                fl_cont_geografia_nono.setVisibility(View.GONE);

                                fl_cont_historia_sexto.setVisibility(View.GONE);
                                fl_cont_historia_setimo.setVisibility(View.GONE);
                                fl_cont_historia_oitavo.setVisibility(View.GONE);
                                fl_cont_historia_nono.setVisibility(View.GONE);

                                fl_cont_matematica_sexto.setVisibility(View.GONE);
                                fl_cont_matematica_setimo.setVisibility(View.GONE);
                                fl_cont_matematica_oitavo.setVisibility(View.GONE);
                                fl_cont_matematica_nono.setVisibility(View.GONE);

                                fl_cont_portugues_sexto.setVisibility(View.GONE);
                                fl_cont_portugues_setimo.setVisibility(View.GONE);
                                fl_cont_portugues_oitavo.setVisibility(View.GONE);
                                fl_cont_portugues_nono.setVisibility(View.GONE);


                                fl_cont_geografia_nono.setVisibility(View.VISIBLE);
                            }

                            else {

                                //fl_cont_arte_sexto.setVisibility(View.VISIBLE);

                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }


                    });

                }

                //historia
                if (posicao == 5){

                    spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


                        @Override
                        public void onItemSelected(AdapterView<?> parent, View v, int posicao1, long id2) {

                            //pega nome pela posicao
                            ano = parent.getItemAtPosition(posicao1).toString();
                            //imprime um Toast na tela com o nome e posição do item selecionado
                            //Toast.makeText(Activity_teste.this, "Série: " + ano, Toast.LENGTH_LONG).show();
                            //Toast.makeText(Activity_teste.this, "Id:" + posicao, Toast.LENGTH_SHORT).show();


                            if (posicao1 == 0){

                                fl_cont_arte_sexto.setVisibility(View.GONE);
                                fl_cont_arte_setimo.setVisibility(View.GONE);
                                fl_cont_arte_oitavo.setVisibility(View.GONE);
                                fl_cont_arte_nono.setVisibility(View.GONE);

                                fl_cont_ciencias_sexto.setVisibility(View.GONE);
                                fl_cont_ciencias_setimo.setVisibility(View.GONE);
                                fl_cont_ciencias_oitavo.setVisibility(View.GONE);
                                fl_cont_ciencias_nono.setVisibility(View.GONE);

                                fl_cont_ed_fisica_sexto.setVisibility(View.GONE);
                                fl_cont_ed_fisica_setimo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_oitavo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_nono.setVisibility(View.GONE);

                                fl_cont_ens_religioso_sexto.setVisibility(View.GONE);
                                fl_cont_ens_religioso_setimo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_oitavo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_nono.setVisibility(View.GONE);

                                fl_cont_geografia_sexto.setVisibility(View.GONE);
                                fl_cont_geografia_setimo.setVisibility(View.GONE);
                                fl_cont_geografia_oitavo.setVisibility(View.GONE);
                                fl_cont_geografia_nono.setVisibility(View.GONE);

                                fl_cont_historia_sexto.setVisibility(View.GONE);
                                fl_cont_historia_setimo.setVisibility(View.GONE);
                                fl_cont_historia_oitavo.setVisibility(View.GONE);
                                fl_cont_historia_nono.setVisibility(View.GONE);

                                fl_cont_matematica_sexto.setVisibility(View.GONE);
                                fl_cont_matematica_setimo.setVisibility(View.GONE);
                                fl_cont_matematica_oitavo.setVisibility(View.GONE);
                                fl_cont_matematica_nono.setVisibility(View.GONE);

                                fl_cont_portugues_sexto.setVisibility(View.GONE);
                                fl_cont_portugues_setimo.setVisibility(View.GONE);
                                fl_cont_portugues_oitavo.setVisibility(View.GONE);
                                fl_cont_portugues_nono.setVisibility(View.GONE);


                                fl_cont_historia_sexto.setVisibility(View.VISIBLE);

                            }


                            if (posicao1 == 1){

                                fl_cont_arte_sexto.setVisibility(View.GONE);
                                fl_cont_arte_setimo.setVisibility(View.GONE);
                                fl_cont_arte_oitavo.setVisibility(View.GONE);
                                fl_cont_arte_nono.setVisibility(View.GONE);

                                fl_cont_ciencias_sexto.setVisibility(View.GONE);
                                fl_cont_ciencias_setimo.setVisibility(View.GONE);
                                fl_cont_ciencias_oitavo.setVisibility(View.GONE);
                                fl_cont_ciencias_nono.setVisibility(View.GONE);

                                fl_cont_ed_fisica_sexto.setVisibility(View.GONE);
                                fl_cont_ed_fisica_setimo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_oitavo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_nono.setVisibility(View.GONE);

                                fl_cont_ens_religioso_sexto.setVisibility(View.GONE);
                                fl_cont_ens_religioso_setimo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_oitavo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_nono.setVisibility(View.GONE);

                                fl_cont_geografia_sexto.setVisibility(View.GONE);
                                fl_cont_geografia_setimo.setVisibility(View.GONE);
                                fl_cont_geografia_oitavo.setVisibility(View.GONE);
                                fl_cont_geografia_nono.setVisibility(View.GONE);

                                fl_cont_historia_sexto.setVisibility(View.GONE);
                                fl_cont_historia_setimo.setVisibility(View.GONE);
                                fl_cont_historia_oitavo.setVisibility(View.GONE);
                                fl_cont_historia_nono.setVisibility(View.GONE);

                                fl_cont_matematica_sexto.setVisibility(View.GONE);
                                fl_cont_matematica_setimo.setVisibility(View.GONE);
                                fl_cont_matematica_oitavo.setVisibility(View.GONE);
                                fl_cont_matematica_nono.setVisibility(View.GONE);

                                fl_cont_portugues_sexto.setVisibility(View.GONE);
                                fl_cont_portugues_setimo.setVisibility(View.GONE);
                                fl_cont_portugues_oitavo.setVisibility(View.GONE);
                                fl_cont_portugues_nono.setVisibility(View.GONE);


                                fl_cont_historia_setimo.setVisibility(View.VISIBLE);

                            }
                            if (posicao1 == 2){

                                fl_cont_arte_sexto.setVisibility(View.GONE);
                                fl_cont_arte_setimo.setVisibility(View.GONE);
                                fl_cont_arte_oitavo.setVisibility(View.GONE);
                                fl_cont_arte_nono.setVisibility(View.GONE);

                                fl_cont_ciencias_sexto.setVisibility(View.GONE);
                                fl_cont_ciencias_setimo.setVisibility(View.GONE);
                                fl_cont_ciencias_oitavo.setVisibility(View.GONE);
                                fl_cont_ciencias_nono.setVisibility(View.GONE);

                                fl_cont_ed_fisica_sexto.setVisibility(View.GONE);
                                fl_cont_ed_fisica_setimo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_oitavo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_nono.setVisibility(View.GONE);

                                fl_cont_ens_religioso_sexto.setVisibility(View.GONE);
                                fl_cont_ens_religioso_setimo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_oitavo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_nono.setVisibility(View.GONE);

                                fl_cont_geografia_sexto.setVisibility(View.GONE);
                                fl_cont_geografia_setimo.setVisibility(View.GONE);
                                fl_cont_geografia_oitavo.setVisibility(View.GONE);
                                fl_cont_geografia_nono.setVisibility(View.GONE);

                                fl_cont_historia_sexto.setVisibility(View.GONE);
                                fl_cont_historia_setimo.setVisibility(View.GONE);
                                fl_cont_historia_oitavo.setVisibility(View.GONE);
                                fl_cont_historia_nono.setVisibility(View.GONE);

                                fl_cont_matematica_sexto.setVisibility(View.GONE);
                                fl_cont_matematica_setimo.setVisibility(View.GONE);
                                fl_cont_matematica_oitavo.setVisibility(View.GONE);
                                fl_cont_matematica_nono.setVisibility(View.GONE);

                                fl_cont_portugues_sexto.setVisibility(View.GONE);
                                fl_cont_portugues_setimo.setVisibility(View.GONE);
                                fl_cont_portugues_oitavo.setVisibility(View.GONE);
                                fl_cont_portugues_nono.setVisibility(View.GONE);


                                fl_cont_historia_oitavo.setVisibility(View.VISIBLE);

                            }
                            if (posicao1 == 3){

                                fl_cont_arte_sexto.setVisibility(View.GONE);
                                fl_cont_arte_setimo.setVisibility(View.GONE);
                                fl_cont_arte_oitavo.setVisibility(View.GONE);
                                fl_cont_arte_nono.setVisibility(View.GONE);

                                fl_cont_ciencias_sexto.setVisibility(View.GONE);
                                fl_cont_ciencias_setimo.setVisibility(View.GONE);
                                fl_cont_ciencias_oitavo.setVisibility(View.GONE);
                                fl_cont_ciencias_nono.setVisibility(View.GONE);

                                fl_cont_ed_fisica_sexto.setVisibility(View.GONE);
                                fl_cont_ed_fisica_setimo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_oitavo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_nono.setVisibility(View.GONE);

                                fl_cont_ens_religioso_sexto.setVisibility(View.GONE);
                                fl_cont_ens_religioso_setimo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_oitavo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_nono.setVisibility(View.GONE);

                                fl_cont_geografia_sexto.setVisibility(View.GONE);
                                fl_cont_geografia_setimo.setVisibility(View.GONE);
                                fl_cont_geografia_oitavo.setVisibility(View.GONE);
                                fl_cont_geografia_nono.setVisibility(View.GONE);

                                fl_cont_historia_sexto.setVisibility(View.GONE);
                                fl_cont_historia_setimo.setVisibility(View.GONE);
                                fl_cont_historia_oitavo.setVisibility(View.GONE);
                                fl_cont_historia_nono.setVisibility(View.GONE);

                                fl_cont_matematica_sexto.setVisibility(View.GONE);
                                fl_cont_matematica_setimo.setVisibility(View.GONE);
                                fl_cont_matematica_oitavo.setVisibility(View.GONE);
                                fl_cont_matematica_nono.setVisibility(View.GONE);

                                fl_cont_portugues_sexto.setVisibility(View.GONE);
                                fl_cont_portugues_setimo.setVisibility(View.GONE);
                                fl_cont_portugues_oitavo.setVisibility(View.GONE);
                                fl_cont_portugues_nono.setVisibility(View.GONE);


                                fl_cont_historia_nono.setVisibility(View.VISIBLE);
                            }

                            else {

                                //fl_cont_arte_sexto.setVisibility(View.VISIBLE);

                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }


                    });

                }

                //matematica
                if (posicao == 6){

                    spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


                        @Override
                        public void onItemSelected(AdapterView<?> parent, View v, int posicao1, long id2) {

                            //pega nome pela posicao
                            ano = parent.getItemAtPosition(posicao1).toString();
                            //imprime um Toast na tela com o nome e posição do item selecionado
                            //Toast.makeText(Activity_teste.this, "Série: " + ano, Toast.LENGTH_LONG).show();
                            //Toast.makeText(Activity_teste.this, "Id:" + posicao, Toast.LENGTH_SHORT).show();


                            if (posicao1 == 0){

                                fl_cont_arte_sexto.setVisibility(View.GONE);
                                fl_cont_arte_setimo.setVisibility(View.GONE);
                                fl_cont_arte_oitavo.setVisibility(View.GONE);
                                fl_cont_arte_nono.setVisibility(View.GONE);

                                fl_cont_ciencias_sexto.setVisibility(View.GONE);
                                fl_cont_ciencias_setimo.setVisibility(View.GONE);
                                fl_cont_ciencias_oitavo.setVisibility(View.GONE);
                                fl_cont_ciencias_nono.setVisibility(View.GONE);

                                fl_cont_ed_fisica_sexto.setVisibility(View.GONE);
                                fl_cont_ed_fisica_setimo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_oitavo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_nono.setVisibility(View.GONE);

                                fl_cont_ens_religioso_sexto.setVisibility(View.GONE);
                                fl_cont_ens_religioso_setimo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_oitavo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_nono.setVisibility(View.GONE);

                                fl_cont_geografia_sexto.setVisibility(View.GONE);
                                fl_cont_geografia_setimo.setVisibility(View.GONE);
                                fl_cont_geografia_oitavo.setVisibility(View.GONE);
                                fl_cont_geografia_nono.setVisibility(View.GONE);

                                fl_cont_historia_sexto.setVisibility(View.GONE);
                                fl_cont_historia_setimo.setVisibility(View.GONE);
                                fl_cont_historia_oitavo.setVisibility(View.GONE);
                                fl_cont_historia_nono.setVisibility(View.GONE);

                                fl_cont_matematica_sexto.setVisibility(View.GONE);
                                fl_cont_matematica_setimo.setVisibility(View.GONE);
                                fl_cont_matematica_oitavo.setVisibility(View.GONE);
                                fl_cont_matematica_nono.setVisibility(View.GONE);

                                fl_cont_portugues_sexto.setVisibility(View.GONE);
                                fl_cont_portugues_setimo.setVisibility(View.GONE);
                                fl_cont_portugues_oitavo.setVisibility(View.GONE);
                                fl_cont_portugues_nono.setVisibility(View.GONE);


                                fl_cont_matematica_sexto.setVisibility(View.VISIBLE);

                            }


                            if (posicao1 == 1){

                                fl_cont_arte_sexto.setVisibility(View.GONE);
                                fl_cont_arte_setimo.setVisibility(View.GONE);
                                fl_cont_arte_oitavo.setVisibility(View.GONE);
                                fl_cont_arte_nono.setVisibility(View.GONE);

                                fl_cont_ciencias_sexto.setVisibility(View.GONE);
                                fl_cont_ciencias_setimo.setVisibility(View.GONE);
                                fl_cont_ciencias_oitavo.setVisibility(View.GONE);
                                fl_cont_ciencias_nono.setVisibility(View.GONE);

                                fl_cont_ed_fisica_sexto.setVisibility(View.GONE);
                                fl_cont_ed_fisica_setimo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_oitavo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_nono.setVisibility(View.GONE);

                                fl_cont_ens_religioso_sexto.setVisibility(View.GONE);
                                fl_cont_ens_religioso_setimo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_oitavo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_nono.setVisibility(View.GONE);

                                fl_cont_geografia_sexto.setVisibility(View.GONE);
                                fl_cont_geografia_setimo.setVisibility(View.GONE);
                                fl_cont_geografia_oitavo.setVisibility(View.GONE);
                                fl_cont_geografia_nono.setVisibility(View.GONE);

                                fl_cont_historia_sexto.setVisibility(View.GONE);
                                fl_cont_historia_setimo.setVisibility(View.GONE);
                                fl_cont_historia_oitavo.setVisibility(View.GONE);
                                fl_cont_historia_nono.setVisibility(View.GONE);

                                fl_cont_matematica_sexto.setVisibility(View.GONE);
                                fl_cont_matematica_setimo.setVisibility(View.GONE);
                                fl_cont_matematica_oitavo.setVisibility(View.GONE);
                                fl_cont_matematica_nono.setVisibility(View.GONE);

                                fl_cont_portugues_sexto.setVisibility(View.GONE);
                                fl_cont_portugues_setimo.setVisibility(View.GONE);
                                fl_cont_portugues_oitavo.setVisibility(View.GONE);
                                fl_cont_portugues_nono.setVisibility(View.GONE);


                                fl_cont_matematica_setimo.setVisibility(View.VISIBLE);

                            }
                            if (posicao1 == 2){

                                fl_cont_arte_sexto.setVisibility(View.GONE);
                                fl_cont_arte_setimo.setVisibility(View.GONE);
                                fl_cont_arte_oitavo.setVisibility(View.GONE);
                                fl_cont_arte_nono.setVisibility(View.GONE);

                                fl_cont_ciencias_sexto.setVisibility(View.GONE);
                                fl_cont_ciencias_setimo.setVisibility(View.GONE);
                                fl_cont_ciencias_oitavo.setVisibility(View.GONE);
                                fl_cont_ciencias_nono.setVisibility(View.GONE);

                                fl_cont_ed_fisica_sexto.setVisibility(View.GONE);
                                fl_cont_ed_fisica_setimo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_oitavo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_nono.setVisibility(View.GONE);

                                fl_cont_ens_religioso_sexto.setVisibility(View.GONE);
                                fl_cont_ens_religioso_setimo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_oitavo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_nono.setVisibility(View.GONE);

                                fl_cont_geografia_sexto.setVisibility(View.GONE);
                                fl_cont_geografia_setimo.setVisibility(View.GONE);
                                fl_cont_geografia_oitavo.setVisibility(View.GONE);
                                fl_cont_geografia_nono.setVisibility(View.GONE);

                                fl_cont_historia_sexto.setVisibility(View.GONE);
                                fl_cont_historia_setimo.setVisibility(View.GONE);
                                fl_cont_historia_oitavo.setVisibility(View.GONE);
                                fl_cont_historia_nono.setVisibility(View.GONE);

                                fl_cont_matematica_sexto.setVisibility(View.GONE);
                                fl_cont_matematica_setimo.setVisibility(View.GONE);
                                fl_cont_matematica_oitavo.setVisibility(View.GONE);
                                fl_cont_matematica_nono.setVisibility(View.GONE);

                                fl_cont_portugues_sexto.setVisibility(View.GONE);
                                fl_cont_portugues_setimo.setVisibility(View.GONE);
                                fl_cont_portugues_oitavo.setVisibility(View.GONE);
                                fl_cont_portugues_nono.setVisibility(View.GONE);


                                fl_cont_matematica_oitavo.setVisibility(View.VISIBLE);

                            }
                            if (posicao1 == 3){

                                fl_cont_arte_sexto.setVisibility(View.GONE);
                                fl_cont_arte_setimo.setVisibility(View.GONE);
                                fl_cont_arte_oitavo.setVisibility(View.GONE);
                                fl_cont_arte_nono.setVisibility(View.GONE);

                                fl_cont_ciencias_sexto.setVisibility(View.GONE);
                                fl_cont_ciencias_setimo.setVisibility(View.GONE);
                                fl_cont_ciencias_oitavo.setVisibility(View.GONE);
                                fl_cont_ciencias_nono.setVisibility(View.GONE);

                                fl_cont_ed_fisica_sexto.setVisibility(View.GONE);
                                fl_cont_ed_fisica_setimo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_oitavo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_nono.setVisibility(View.GONE);

                                fl_cont_ens_religioso_sexto.setVisibility(View.GONE);
                                fl_cont_ens_religioso_setimo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_oitavo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_nono.setVisibility(View.GONE);

                                fl_cont_geografia_sexto.setVisibility(View.GONE);
                                fl_cont_geografia_setimo.setVisibility(View.GONE);
                                fl_cont_geografia_oitavo.setVisibility(View.GONE);
                                fl_cont_geografia_nono.setVisibility(View.GONE);

                                fl_cont_historia_sexto.setVisibility(View.GONE);
                                fl_cont_historia_setimo.setVisibility(View.GONE);
                                fl_cont_historia_oitavo.setVisibility(View.GONE);
                                fl_cont_historia_nono.setVisibility(View.GONE);

                                fl_cont_matematica_sexto.setVisibility(View.GONE);
                                fl_cont_matematica_setimo.setVisibility(View.GONE);
                                fl_cont_matematica_oitavo.setVisibility(View.GONE);
                                fl_cont_matematica_nono.setVisibility(View.GONE);

                                fl_cont_portugues_sexto.setVisibility(View.GONE);
                                fl_cont_portugues_setimo.setVisibility(View.GONE);
                                fl_cont_portugues_oitavo.setVisibility(View.GONE);
                                fl_cont_portugues_nono.setVisibility(View.GONE);


                                fl_cont_matematica_nono.setVisibility(View.VISIBLE);
                            }

                            else {

                                //fl_cont_arte_sexto.setVisibility(View.VISIBLE);

                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }


                    });

                }

                //portugues
                if (posicao == 7){

                    spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


                        @Override
                        public void onItemSelected(AdapterView<?> parent, View v, int posicao1, long id2) {

                            //pega nome pela posicao
                            ano = parent.getItemAtPosition(posicao1).toString();
                            //imprime um Toast na tela com o nome e posição do item selecionado
                            //Toast.makeText(Activity_teste.this, "Série: " + ano, Toast.LENGTH_LONG).show();
                            //Toast.makeText(Activity_teste.this, "Id:" + posicao, Toast.LENGTH_SHORT).show();


                            if (posicao1 == 0){

                                fl_cont_arte_sexto.setVisibility(View.GONE);
                                fl_cont_arte_setimo.setVisibility(View.GONE);
                                fl_cont_arte_oitavo.setVisibility(View.GONE);
                                fl_cont_arte_nono.setVisibility(View.GONE);

                                fl_cont_ciencias_sexto.setVisibility(View.GONE);
                                fl_cont_ciencias_setimo.setVisibility(View.GONE);
                                fl_cont_ciencias_oitavo.setVisibility(View.GONE);
                                fl_cont_ciencias_nono.setVisibility(View.GONE);

                                fl_cont_ed_fisica_sexto.setVisibility(View.GONE);
                                fl_cont_ed_fisica_setimo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_oitavo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_nono.setVisibility(View.GONE);

                                fl_cont_ens_religioso_sexto.setVisibility(View.GONE);
                                fl_cont_ens_religioso_setimo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_oitavo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_nono.setVisibility(View.GONE);

                                fl_cont_geografia_sexto.setVisibility(View.GONE);
                                fl_cont_geografia_setimo.setVisibility(View.GONE);
                                fl_cont_geografia_oitavo.setVisibility(View.GONE);
                                fl_cont_geografia_nono.setVisibility(View.GONE);

                                fl_cont_historia_sexto.setVisibility(View.GONE);
                                fl_cont_historia_setimo.setVisibility(View.GONE);
                                fl_cont_historia_oitavo.setVisibility(View.GONE);
                                fl_cont_historia_nono.setVisibility(View.GONE);

                                fl_cont_matematica_sexto.setVisibility(View.GONE);
                                fl_cont_matematica_setimo.setVisibility(View.GONE);
                                fl_cont_matematica_oitavo.setVisibility(View.GONE);
                                fl_cont_matematica_nono.setVisibility(View.GONE);

                                fl_cont_portugues_sexto.setVisibility(View.GONE);
                                fl_cont_portugues_setimo.setVisibility(View.GONE);
                                fl_cont_portugues_oitavo.setVisibility(View.GONE);
                                fl_cont_portugues_nono.setVisibility(View.GONE);


                                fl_cont_portugues_sexto.setVisibility(View.VISIBLE);

                            }


                            if (posicao1 == 1){

                                fl_cont_arte_sexto.setVisibility(View.GONE);
                                fl_cont_arte_setimo.setVisibility(View.GONE);
                                fl_cont_arte_oitavo.setVisibility(View.GONE);
                                fl_cont_arte_nono.setVisibility(View.GONE);

                                fl_cont_ciencias_sexto.setVisibility(View.GONE);
                                fl_cont_ciencias_setimo.setVisibility(View.GONE);
                                fl_cont_ciencias_oitavo.setVisibility(View.GONE);
                                fl_cont_ciencias_nono.setVisibility(View.GONE);

                                fl_cont_ed_fisica_sexto.setVisibility(View.GONE);
                                fl_cont_ed_fisica_setimo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_oitavo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_nono.setVisibility(View.GONE);

                                fl_cont_ens_religioso_sexto.setVisibility(View.GONE);
                                fl_cont_ens_religioso_setimo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_oitavo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_nono.setVisibility(View.GONE);

                                fl_cont_geografia_sexto.setVisibility(View.GONE);
                                fl_cont_geografia_setimo.setVisibility(View.GONE);
                                fl_cont_geografia_oitavo.setVisibility(View.GONE);
                                fl_cont_geografia_nono.setVisibility(View.GONE);

                                fl_cont_historia_sexto.setVisibility(View.GONE);
                                fl_cont_historia_setimo.setVisibility(View.GONE);
                                fl_cont_historia_oitavo.setVisibility(View.GONE);
                                fl_cont_historia_nono.setVisibility(View.GONE);

                                fl_cont_matematica_sexto.setVisibility(View.GONE);
                                fl_cont_matematica_setimo.setVisibility(View.GONE);
                                fl_cont_matematica_oitavo.setVisibility(View.GONE);
                                fl_cont_matematica_nono.setVisibility(View.GONE);

                                fl_cont_portugues_sexto.setVisibility(View.GONE);
                                fl_cont_portugues_setimo.setVisibility(View.GONE);
                                fl_cont_portugues_oitavo.setVisibility(View.GONE);
                                fl_cont_portugues_nono.setVisibility(View.GONE);


                                fl_cont_portugues_setimo.setVisibility(View.VISIBLE);

                            }
                            if (posicao1 == 2){

                                fl_cont_arte_sexto.setVisibility(View.GONE);
                                fl_cont_arte_setimo.setVisibility(View.GONE);
                                fl_cont_arte_oitavo.setVisibility(View.GONE);
                                fl_cont_arte_nono.setVisibility(View.GONE);

                                fl_cont_ciencias_sexto.setVisibility(View.GONE);
                                fl_cont_ciencias_setimo.setVisibility(View.GONE);
                                fl_cont_ciencias_oitavo.setVisibility(View.GONE);
                                fl_cont_ciencias_nono.setVisibility(View.GONE);

                                fl_cont_ed_fisica_sexto.setVisibility(View.GONE);
                                fl_cont_ed_fisica_setimo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_oitavo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_nono.setVisibility(View.GONE);

                                fl_cont_ens_religioso_sexto.setVisibility(View.GONE);
                                fl_cont_ens_religioso_setimo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_oitavo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_nono.setVisibility(View.GONE);

                                fl_cont_geografia_sexto.setVisibility(View.GONE);
                                fl_cont_geografia_setimo.setVisibility(View.GONE);
                                fl_cont_geografia_oitavo.setVisibility(View.GONE);
                                fl_cont_geografia_nono.setVisibility(View.GONE);

                                fl_cont_historia_sexto.setVisibility(View.GONE);
                                fl_cont_historia_setimo.setVisibility(View.GONE);
                                fl_cont_historia_oitavo.setVisibility(View.GONE);
                                fl_cont_historia_nono.setVisibility(View.GONE);

                                fl_cont_matematica_sexto.setVisibility(View.GONE);
                                fl_cont_matematica_setimo.setVisibility(View.GONE);
                                fl_cont_matematica_oitavo.setVisibility(View.GONE);
                                fl_cont_matematica_nono.setVisibility(View.GONE);

                                fl_cont_portugues_sexto.setVisibility(View.GONE);
                                fl_cont_portugues_setimo.setVisibility(View.GONE);
                                fl_cont_portugues_oitavo.setVisibility(View.GONE);
                                fl_cont_portugues_nono.setVisibility(View.GONE);


                                fl_cont_portugues_oitavo.setVisibility(View.VISIBLE);

                            }
                            if (posicao1 == 3){

                                fl_cont_arte_sexto.setVisibility(View.GONE);
                                fl_cont_arte_setimo.setVisibility(View.GONE);
                                fl_cont_arte_oitavo.setVisibility(View.GONE);
                                fl_cont_arte_nono.setVisibility(View.GONE);

                                fl_cont_ciencias_sexto.setVisibility(View.GONE);
                                fl_cont_ciencias_setimo.setVisibility(View.GONE);
                                fl_cont_ciencias_oitavo.setVisibility(View.GONE);
                                fl_cont_ciencias_nono.setVisibility(View.GONE);

                                fl_cont_ed_fisica_sexto.setVisibility(View.GONE);
                                fl_cont_ed_fisica_setimo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_oitavo.setVisibility(View.GONE);
                                fl_cont_ed_fisica_nono.setVisibility(View.GONE);

                                fl_cont_ens_religioso_sexto.setVisibility(View.GONE);
                                fl_cont_ens_religioso_setimo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_oitavo.setVisibility(View.GONE);
                                fl_cont_ens_religioso_nono.setVisibility(View.GONE);

                                fl_cont_geografia_sexto.setVisibility(View.GONE);
                                fl_cont_geografia_setimo.setVisibility(View.GONE);
                                fl_cont_geografia_oitavo.setVisibility(View.GONE);
                                fl_cont_geografia_nono.setVisibility(View.GONE);

                                fl_cont_historia_sexto.setVisibility(View.GONE);
                                fl_cont_historia_setimo.setVisibility(View.GONE);
                                fl_cont_historia_oitavo.setVisibility(View.GONE);
                                fl_cont_historia_nono.setVisibility(View.GONE);

                                fl_cont_matematica_sexto.setVisibility(View.GONE);
                                fl_cont_matematica_setimo.setVisibility(View.GONE);
                                fl_cont_matematica_oitavo.setVisibility(View.GONE);
                                fl_cont_matematica_nono.setVisibility(View.GONE);

                                fl_cont_portugues_sexto.setVisibility(View.GONE);
                                fl_cont_portugues_setimo.setVisibility(View.GONE);
                                fl_cont_portugues_oitavo.setVisibility(View.GONE);
                                fl_cont_portugues_nono.setVisibility(View.GONE);


                                fl_cont_portugues_nono.setVisibility(View.VISIBLE);
                            }

                            else {

                                //fl_cont_arte_sexto.setVisibility(View.VISIBLE);

                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }


                    });

                }

                  else {

                  //fl_cont_arte_sexto.setVisibility(View.VISIBLE);

                  }
            }



            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        /*
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


                @Override
                public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id2) {

                    //pega nome pela posicao
                    ano = parent.getItemAtPosition(posicao).toString();
                    //imprime um Toast na tela com o nome e posição do item selecionado
                    //Toast.makeText(Activity_teste.this, "Série: " + ano, Toast.LENGTH_LONG).show();
                    //Toast.makeText(Activity_teste.this, "Id:" + posicao, Toast.LENGTH_SHORT).show();

                    serie = posicao;


                    // if (posicao == 1){

                //    fl_conteudo.setVisibility(View.VISIBLE);
                //}

                // else {

                //     fl_conteudo.setVisibility(View.GONE);

                //  }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });

        //Toast.makeText(Activity_teste.this,"Id:"+serie,Toast.LENGTH_SHORT).show();


        if (serie == 1) {

            fl_conteudo.setVisibility(View.VISIBLE);
        } else {

            fl_conteudo.setVisibility(View.GONE);
        } */


    }


}
