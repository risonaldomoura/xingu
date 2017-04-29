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

                if (posicao == 1){



                    spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


                        @Override
                        public void onItemSelected(AdapterView<?> parent, View v, int posicao1, long id2) {

                            //pega nome pela posicao
                            ano = parent.getItemAtPosition(posicao1).toString();
                            //imprime um Toast na tela com o nome e posição do item selecionado
                            //Toast.makeText(Activity_teste.this, "Série: " + ano, Toast.LENGTH_LONG).show();
                            //Toast.makeText(Activity_teste.this, "Id:" + posicao, Toast.LENGTH_SHORT).show();

                            //serie = posicao1;

                             if (posicao1 == 0){

                                fl_cont_arte_sexto.setVisibility(View.VISIBLE);

                                // Toast.makeText(Activity_teste.this, "Id:" + posicao1, Toast.LENGTH_SHORT).show();

                                 fl_cont_arte_setimo.setVisibility(View.GONE);
                                 fl_cont_arte_oitavo.setVisibility(View.GONE);
                                 fl_cont_arte_nono.setVisibility(View.GONE);
                            }


                            if (posicao1 == 1){

                                fl_cont_arte_setimo.setVisibility(View.VISIBLE);

                                fl_cont_arte_sexto.setVisibility(View.GONE);
                                fl_cont_arte_oitavo.setVisibility(View.GONE);
                                fl_cont_arte_nono.setVisibility(View.GONE);
                            }
                            if (posicao1 == 2){

                                fl_cont_arte_oitavo.setVisibility(View.VISIBLE);

                                fl_cont_arte_sexto.setVisibility(View.GONE);
                                fl_cont_arte_setimo.setVisibility(View.GONE);
                                fl_cont_arte_nono.setVisibility(View.GONE);
                            }
                            if (posicao1 == 3){

                                fl_cont_arte_nono.setVisibility(View.VISIBLE);

                                fl_cont_arte_sexto.setVisibility(View.GONE);
                                fl_cont_arte_setimo.setVisibility(View.GONE);
                                fl_cont_arte_oitavo.setVisibility(View.GONE);
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

                //  fl_conteudo.setVisibility(View.VISIBLE);
                //  }

                  else {

                  fl_cont_arte_sexto.setVisibility(View.VISIBLE);

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
