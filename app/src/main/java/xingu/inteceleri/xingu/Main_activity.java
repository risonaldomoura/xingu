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
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

//import static android.widget.Toast.*;


public class Main_activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;


    private Spinner spn_disciplina;
    public static String disciplina;
    public static int ID;
    private ArrayAdapter<String> adp_disciplina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


        spn_disciplina = (Spinner) findViewById(R.id.spn_disciplina);

        adp_disciplina = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adp_disciplina.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spn_disciplina.setAdapter(adp_disciplina);

        adp_disciplina.add("Arte");
        adp_disciplina.add("Ens. Religioso");
        adp_disciplina.add("Ciências");
        adp_disciplina.add("Ed. Física");
        adp_disciplina.add("Geografia");
        adp_disciplina.add("História");
        adp_disciplina.add("Língua Portuguesa");
        adp_disciplina.add("Matemática");

        //FrameLayout da spinner
        final FrameLayout fl_spinner = (FrameLayout) findViewById(R.id.fl_spinner);

        //final FrameLayout fl_conteudo = (FrameLayout) findViewById(R.id.fl_conteudo);



        final FrameLayout tab1_sexto = (FrameLayout) findViewById(R.id.tab1_sexto);
        final LinearLayout tab2_setimo = (LinearLayout) findViewById(R.id.tab2_setimo);
        final LinearLayout tab3_oitavo = (LinearLayout) findViewById(R.id.tab3_oitavo);
        final LinearLayout tab4_nono = (LinearLayout) findViewById(R.id.tab4_nono);


        /*
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
         */

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

       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Método do spinner para capturar o item selecionado

        spn_disciplina.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id1) {

                //pega nome pela posicao
                disciplina = parent.getSelectedItem().toString();
                
                ID = posicao;

                mostrarid();

                //imprime um Toast na tela com o nome e posição do item selecionado
                //Toast.makeText(Main_activity.this, "Disciplina: " + nome, Toast.LENGTH_LONG).show();
                //Toast.makeText(Main_activity.this, "Disciplina:" + posicao, Toast.LENGTH_SHORT).show();

                // Toast.makeText(Activity_teste.this,"Id:"+serie,Toast.LENGTH_SHORT).show();

                // Toast.makeText(Activity_teste.this, "Id:" + posicao, Toast.LENGTH_SHORT).show();

                /*
                if (posicao == 0){

                    fl_cont_ciencias_sexto.setVisibility(View.VISIBLE);
                    fl_cont_ciencias_setimo.setVisibility(View.GONE);
                    fl_cont_ciencias_oitavo.setVisibility(View.GONE);
                    fl_cont_ciencias_nono.setVisibility(View.GONE);






                if (posicao == 1){

                    fl_cont_arte_sexto.setVisibility(View.VISIBLE);

                }

                /*
                if (posicao == 2){



                }

                if (posicao == 3){




                } */


            }

            public int getId(){
                return ID;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
             return;
            }
        });

    }

    public void mostrarid (){

        Toast.makeText(Main_activity.this,"Id:"+ID,Toast.LENGTH_SHORT).show();
    }



    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }
           @Override
            public Fragment getItem ( int position){

            switch (position) {

                case 0:

                    if (ID == 0){

                        Tab1_sexto tab1 = new Tab1_sexto();
                        return tab1;
                    }

                    else if (ID == 1){

                        Tab1_teste tab5 = new Tab1_teste();
                        return tab5;
                    }


                case 1:

                    Tab2_setimo tab2 = new Tab2_setimo();
                    return tab2;

                case 2:

                    Tab3_oitavo tab3 = new Tab3_oitavo();
                    return tab3;

                case 3:

                    Tab4_nono tab4 = new Tab4_nono();
                    return tab4;
            }
            return null;

        }

        @Override
        public int getCount() {
            // Show 4 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "6º ANO";
                case 1:
                    return "7º ANO";
                case 2:
                    return "8º ANO";
                case 3:
                    return "9º ANO";
            }
            return null;
        }
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
        } if (id == R.id.arte) {
           FrameLayout fl = (FrameLayout) findViewById(R.id.fl_arte);
           FrameLayout fls = (FrameLayout) findViewById(R.id.fl_spinner);


            fl.setVisibility(View.VISIBLE);
            fls.setVisibility(View.GONE);
            //Abrir a mensagem de objetivos de arte

        } if (id == R.id.ciencias) {
            FrameLayout fl = (FrameLayout) findViewById(R.id.fl_ciencias);
            FrameLayout fls = (FrameLayout) findViewById(R.id.fl_spinner);
            fl.setVisibility(View.VISIBLE);
            fls.setVisibility(View.GONE);

        } if (id == R.id.ed_fisica) {
            FrameLayout fl = (FrameLayout) findViewById(R.id.fl_ed_fisica);
            FrameLayout fls = (FrameLayout) findViewById(R.id.fl_spinner);
            fl.setVisibility(View.VISIBLE);
            fls.setVisibility(View.GONE);

        } if (id == R.id.ens_religioso) {
            FrameLayout fl = (FrameLayout) findViewById(R.id.fl_ens_religioso);
            FrameLayout fls = (FrameLayout) findViewById(R.id.fl_spinner);
            fl.setVisibility(View.VISIBLE);
            fls.setVisibility(View.GONE);

        } if (id == R.id.geografia) {
            FrameLayout fl = (FrameLayout) findViewById(R.id.fl_geografia);
            FrameLayout fls = (FrameLayout) findViewById(R.id.fl_spinner);
            fl.setVisibility(View.VISIBLE);
            fls.setVisibility(View.GONE);

        } if (id == R.id.historia) {
            FrameLayout fl = (FrameLayout) findViewById(R.id.fl_historia);
            FrameLayout fls = (FrameLayout) findViewById(R.id.fl_spinner);
            fl.setVisibility(View.VISIBLE);
            fls.setVisibility(View.GONE);

        } if (id == R.id.matematica) {
            FrameLayout fl = (FrameLayout) findViewById(R.id.fl_matematica);
            FrameLayout fls = (FrameLayout) findViewById(R.id.fl_spinner);
            fl.setVisibility(View.VISIBLE);
            fls.setVisibility(View.GONE);

        } if (id == R.id.portugues) {
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
