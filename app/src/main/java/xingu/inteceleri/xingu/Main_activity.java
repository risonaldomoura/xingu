package xingu.inteceleri.xingu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Spinner;

public class Main_activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private Spinner spn_disciplina;
    private Spinner spn_ano;

    private String ano;

    private ArrayAdapter<String> adp_disciplina;
    private ArrayAdapter<String> adp_ano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        spn_disciplina = (Spinner)findViewById(R.id.spn_disciplina);
        spn_ano = (Spinner)findViewById(R.id.spn_ano);

        adp_disciplina = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item);
        adp_disciplina.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adp_ano = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item);
        adp_ano.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spn_disciplina.setAdapter(adp_disciplina);
        spn_ano.setAdapter(adp_ano);

        adp_disciplina.add("Arte");
        adp_disciplina.add("Ens. Religioso");
        adp_disciplina.add("Ciências");
        adp_disciplina.add("Ed. Física");
        adp_disciplina.add("Geografia");
        adp_disciplina.add("História");
        adp_disciplina.add("Português");
        adp_disciplina.add("Matemática");

        adp_ano.add("6º ano");
        adp_ano.add("7º ano");
        adp_ano.add("8º ano");
        adp_ano.add("9º ano");


        //FrameLayout das spinners
        final FrameLayout fl_spinner = (FrameLayout) findViewById(R.id.fl_spinner);

        //FrameLayout Arte
        final FrameLayout fl_arte = (FrameLayout) findViewById(R.id.fl_arte);
        Button btn_ok_arte;
        btn_ok_arte = (Button) findViewById(R.id.btn_ok_arte);
        btn_ok_arte.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                                   fl_arte.setVisibility(View.GONE);
                                                   fl_spinner.setVisibility(View.VISIBLE);
                                           }
                                       }
        );


        //FrameLayout ciencias
        final FrameLayout fl_ciencias = (FrameLayout) findViewById(R.id.fl_ciencias);
        Button btn_ok_ciencias;
        btn_ok_ciencias = (Button) findViewById(R.id.btn_ok_ciencias);
        btn_ok_ciencias.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               fl_ciencias.setVisibility(View.GONE);
                                               fl_spinner.setVisibility(View.VISIBLE);
                                           }
                                       }
        );



        //FrameLayout ed_fisica
        final FrameLayout fl_ed_fisica = (FrameLayout) findViewById(R.id.fl_ed_fisica);
        Button btn_ok_ed_fisica;
        btn_ok_ed_fisica = (Button) findViewById(R.id.btn_ok_ed_fisica);
        btn_ok_ed_fisica.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   fl_ed_fisica.setVisibility(View.GONE);
                                                   fl_spinner.setVisibility(View.VISIBLE);
                                               }
                                           }
        );

        //FrameLayout ens_religioso
        final FrameLayout fl_ens_religioso = (FrameLayout) findViewById(R.id.fl_ens_religioso);
        Button btn_ok_ens_religioso;
        btn_ok_ens_religioso = (Button) findViewById(R.id.btn_ok_ens_religioso);
        btn_ok_ens_religioso.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    fl_ens_religioso.setVisibility(View.GONE);
                                                    fl_spinner.setVisibility(View.VISIBLE);
                                                }
                                            }
        );

        //FrameLayout geografia
        final FrameLayout fl_geografia = (FrameLayout) findViewById(R.id.fl_geografia);
        Button btn_ok_geografia;
        btn_ok_geografia = (Button) findViewById(R.id.btn_ok_geografia);
        btn_ok_geografia.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        fl_geografia.setVisibility(View.GONE);
                                                        fl_spinner.setVisibility(View.VISIBLE);
                                                    }
                                                }
        );

        //FrameLayout historia
        final FrameLayout fl_historia = (FrameLayout) findViewById(R.id.fl_historia);
        Button btn_ok_historia;
        btn_ok_historia = (Button) findViewById(R.id.btn_ok_historia);
        btn_ok_historia.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    fl_historia.setVisibility(View.GONE);
                                                    fl_spinner.setVisibility(View.VISIBLE);
                                                }
                                            }
        );

        //FrameLayout matematica
        final FrameLayout fl_matematica = (FrameLayout) findViewById(R.id.fl_matematica);
        Button btn_ok_matematica;
        btn_ok_matematica = (Button) findViewById(R.id.btn_ok_matematica);
        btn_ok_matematica.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   fl_matematica.setVisibility(View.GONE);
                                                   fl_spinner.setVisibility(View.VISIBLE);
                                               }
                                           }
        );

        //FrameLayout portugues
        final FrameLayout fl_portugues = (FrameLayout) findViewById(R.id.fl_portugues);
        Button btn_ok_portugues;
        btn_ok_portugues = (Button) findViewById(R.id.btn_ok_portugues);
        btn_ok_portugues.setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View v) {
                                                     fl_portugues.setVisibility(View.GONE);
                                                     fl_spinner.setVisibility(View.VISIBLE);
                                                 }
                                             }
        );

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
               this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        spn_ano.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id1) {

                //pega nome pela posicao
                ano = parent.getItemAtPosition(posicao).toString();
                //imprime um Toast na tela com o nome e posição do item selecionado
                //Toast.makeText(Activity_teste.this, "Disciplina: " + nome, Toast.LENGTH_LONG).show();
                //Toast.makeText(Activity_teste.this, "Id:" + posicao, Toast.LENGTH_SHORT).show();


                //if (posicao == 2){

                //  fl_conteudo.setVisibility(View.VISIBLE);
                //  }

                //  else {

                //  fl_conteudo.setVisibility(View.GONE);

                //  }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.configuracoes) {
            Intent it = new Intent(this, Config_activity.class);
            startActivity(it);
            // chamar a activity de configurações
        } else if (id == R.id.compartilhar) {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("set/plain");
            shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Compartilhe o M-Xingu com seus amigos!");
            shareIntent.putExtra(Intent.EXTRA_TEXT,"https://play.google.com/store/apps/details?id=air.MatematicandoEducation&hl=pt_BR");
            startActivity(Intent.createChooser(shareIntent, "Compartilhar"));
            //Abrir opçoes de compartilhar
        } else if (id == R.id.arte) {
            FrameLayout fl = (FrameLayout) findViewById(R.id.fl_arte);
            FrameLayout fls = (FrameLayout) findViewById(R.id.fl_spinner);
            fl.setVisibility(View.VISIBLE);
            fls.setVisibility(View.GONE);
            //Abrir a mensagem de objetivos de arte
        } else if (id == R.id.ciencias) {
            FrameLayout fl = (FrameLayout) findViewById(R.id.fl_ciencias);
            FrameLayout fls = (FrameLayout) findViewById(R.id.fl_spinner);
            fl.setVisibility(View.VISIBLE);
            fls.setVisibility(View.GONE);

        } else if (id == R.id.ed_fisica) {
            FrameLayout fl = (FrameLayout) findViewById(R.id.fl_ed_fisica);
            FrameLayout fls = (FrameLayout) findViewById(R.id.fl_spinner);
            fl.setVisibility(View.VISIBLE);
            fls.setVisibility(View.GONE);

        } else if (id == R.id.ens_religioso) {
            FrameLayout fl = (FrameLayout) findViewById(R.id.fl_ens_religioso);
            FrameLayout fls = (FrameLayout) findViewById(R.id.fl_spinner);
            fl.setVisibility(View.VISIBLE);
            fls.setVisibility(View.GONE);

        } else if (id == R.id.geografia) {
            FrameLayout fl = (FrameLayout) findViewById(R.id.fl_geografia);
            FrameLayout fls = (FrameLayout) findViewById(R.id.fl_spinner);
            fl.setVisibility(View.VISIBLE);
            fls.setVisibility(View.GONE);

        } else if (id == R.id.historia) {
            FrameLayout fl = (FrameLayout) findViewById(R.id.fl_historia);
            FrameLayout fls = (FrameLayout) findViewById(R.id.fl_spinner);
            fl.setVisibility(View.VISIBLE);
            fls.setVisibility(View.GONE);

        } else if (id == R.id.matematica) {
            FrameLayout fl = (FrameLayout) findViewById(R.id.fl_matematica);
            FrameLayout fls = (FrameLayout) findViewById(R.id.fl_spinner);
            fl.setVisibility(View.VISIBLE);
            fls.setVisibility(View.GONE);

        } else if (id == R.id.portugues) {
            FrameLayout fl = (FrameLayout) findViewById(R.id.fl_portugues);
            FrameLayout fls = (FrameLayout) findViewById(R.id.fl_spinner);
            fl.setVisibility(View.VISIBLE);
            fls.setVisibility(View.GONE);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;


    }
}
