package xingu.inteceleri.xingu;

import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.Toast;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import java.util.Calendar;

//import static android.widget.Toast.*;


public class Main_activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    // private CheckBox checkbox1;

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    public String mes_1 = "JAN";
    public String mes_2 = "FEV";
    public String mes_3 = "MAR";
    public String mes_4 = "ABR";
    public String mes_5 = "MAI";
    public String mes_6 = "JUN";
    public String mes_7 = "JUL";
    public String mes_8 = "AGO";
    public String mes_9 = "SET";
    public String mes_10 = "OUT";
    public String mes_11 = "NOV";
    public String mes_12 = "DEZ";

    private Spinner spn_disciplina;
    public static int IDAtual;
    public static int ID;
    public static int IDAnterior;

    public int Dia_sistema;
    public int Mes_sistema;

    public int ID_salvo_dia_inicio_I;
    public int ID_salvo_dia_termino_I;
    public int ID_salvo_mes_inicio_I;
    public int ID_salvo_mes_termino_I;

    public int ID_salvo_dia_inicio_II;
    public int ID_salvo_dia_termino_II;
    public int ID_salvo_mes_inicio_II;
    public int ID_salvo_mes_termino_II;

    public int ID_salvo_dia_inicio_III;
    public int ID_salvo_dia_termino_III;
    public int ID_salvo_mes_inicio_III;
    public int ID_salvo_mes_termino_III;

    public int ID_salvo_dia_inicio_IV;
    public int ID_salvo_dia_termino_IV;
    public int ID_salvo_mes_inicio_IV;
    public int ID_salvo_mes_termino_IV;

    private ArrayAdapter<String> adp_disciplina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);



        //final CheckBox checkbox1 = (CheckBox) findViewById(R.id.checkbox1);

       //if (checkbox1.isChecked()){
         //  checkbox1.setChecked(false);
         //}

        /*
        final CheckBox checkbox1 = (CheckBox) findViewById(R.id.checkbox1);
        if (checkbox1.isChecked()){
            String mensagem = "Você realmente deseja desmarcar esse conteúdo";
            AlertDialog.Builder dlg = new AlertDialog.Builder(Main_activity.this);
            dlg.setTitle("Confirmação");
            dlg.setMessage(mensagem);
            dlg.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    checkbox1.setChecked(false);

                }
            });

            dlg.setNeutralButton("NÃO", null);
        }*/

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


        spn_disciplina = (Spinner) findViewById(R.id.spn_disciplina);

        adp_disciplina = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adp_disciplina.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spn_disciplina.setAdapter(adp_disciplina);

        adp_disciplina.add("Arte");
        adp_disciplina.add("Ciências");
        adp_disciplina.add("Educação Física");
        adp_disciplina.add("Ens. Religioso");
        adp_disciplina.add("Geografia");
        adp_disciplina.add("História");
        adp_disciplina.add("Língua Portuguesa");
        adp_disciplina.add("Matemática");


        //FrameLayout da spinner
        final FrameLayout fl_spinner = (FrameLayout) findViewById(R.id.fl_spinner);

        //final FrameLayout fl_1 = (FrameLayout) findViewById(R.id.fl_1);
        //final FrameLayout fl_2 = (FrameLayout) findViewById(R.id.fl_2);

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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        /*
        //Método para limpar o arquivo SharedPreferences
        SharedPreferences settings = getSharedPreferences("disciplina", 0);
        SharedPreferences.Editor e = settings.edit();
        e.clear();
        e.commit();
        */

        //=============== CARREGAMENTO DAS DATAS DOS BIMESTRES =====================================

        //=================PRIMEIRO BIMESTRE========================================================

        //DIA INÍCIO
        SharedPreferences sharedPref_dia_inicio_I = getSharedPreferences("pref_bimestre",MODE_PRIVATE);
        ID_salvo_dia_inicio_I = sharedPref_dia_inicio_I.getInt("dia_inicio_I",1);


        //DIA TÉRMINO
        SharedPreferences sharedPref_dia_termino_I = getSharedPreferences("pref_bimestre",MODE_PRIVATE);
        ID_salvo_dia_termino_I = sharedPref_dia_termino_I.getInt("dia_termino_I",1);

        //MÊS INÍCIO
        SharedPreferences sharedPref_mes_inicio_I = getSharedPreferences("pref_bimestre",MODE_PRIVATE);
        ID_salvo_mes_inicio_I = sharedPref_mes_inicio_I.getInt("mes_inicio_I",1);

        //MÊS TÉRMINO
        SharedPreferences sharedPref_mes_termino_I = getSharedPreferences("pref_bimestre",MODE_PRIVATE);
        ID_salvo_mes_termino_I = sharedPref_mes_termino_I.getInt("mes_termino_I",1);

        //==========================================================================================

        //=================SEGUNDO BIMESTRE=========================================================

        //DIA INICIO
        SharedPreferences sharedPref_dia_inicio_II = getSharedPreferences("pref_bimestre",MODE_PRIVATE);
        ID_salvo_dia_inicio_II = sharedPref_dia_inicio_II.getInt("dia_inicio_II",1);

        //DIA TÉRMINO
        SharedPreferences sharedPref_dia_termino_II = getSharedPreferences("pref_bimestre",MODE_PRIVATE);
        ID_salvo_dia_termino_II = sharedPref_dia_termino_II.getInt("dia_termino_II",1);

        //MES INÍCIO
        SharedPreferences sharedPref_mes_inicio_II = getSharedPreferences("pref_bimestre",MODE_PRIVATE);
        ID_salvo_mes_inicio_II = sharedPref_mes_inicio_II.getInt("mes_inicio_II",1);

        //MÊS TÉRMINO
        SharedPreferences sharedPref_mes_termino_II = getSharedPreferences("pref_bimestre",MODE_PRIVATE);
        ID_salvo_mes_termino_II = sharedPref_mes_termino_II.getInt("mes_termino_II",1);

        //==========================================================================================

        //=================TERCEIRO BIMESTRE========================================================

        //DIA INÍCIO
        SharedPreferences sharedPref_dia_inicio_III = getSharedPreferences("pref_bimestre",MODE_PRIVATE);
        ID_salvo_dia_inicio_III = sharedPref_dia_inicio_III.getInt("dia_inicio_III",1);

        //DIA TÉRMINO
        SharedPreferences sharedPref_dia_termino_III = getSharedPreferences("pref_bimestre",MODE_PRIVATE);
        ID_salvo_dia_termino_III = sharedPref_dia_termino_III.getInt("dia_termino_III",1);

        //MES INÍCIO
        SharedPreferences sharedPref_mes_inicio_III = getSharedPreferences("pref_bimestre",MODE_PRIVATE);
        ID_salvo_mes_inicio_III = sharedPref_mes_inicio_III.getInt("mes_inicio_III",1);

        //MÊS TÉRMINO
        SharedPreferences sharedPref_mes_termino_III = getSharedPreferences("pref_bimestre",MODE_PRIVATE);
        ID_salvo_mes_termino_III = sharedPref_mes_termino_III.getInt("mes_termino_III",1);

        //==========================================================================================

        //=================QUARTO BIMESTRE==========================================================

        //DIA INÍCIO
        SharedPreferences sharedPref_dia_inicio_IV = getSharedPreferences("pref_bimestre",MODE_PRIVATE);
        ID_salvo_dia_inicio_IV = sharedPref_dia_inicio_IV.getInt("dia_inicio_IV",1);

        //DIA TÉRMINO
        SharedPreferences sharedPref_dia_termino_IV = getSharedPreferences("pref_bimestre",MODE_PRIVATE);
        ID_salvo_dia_termino_IV = sharedPref_dia_termino_IV.getInt("dia_termino_IV",1);

        //MES INÍCIO
        SharedPreferences sharedPref_mes_inicio_IV = getSharedPreferences("pref_bimestre",MODE_PRIVATE);
        ID_salvo_mes_inicio_IV = sharedPref_mes_inicio_IV.getInt("mes_inicio_IV",1);

        //MÊS TÉRMINO
        SharedPreferences sharedPref_mes_termino_IV = getSharedPreferences("pref_bimestre",MODE_PRIVATE);
        ID_salvo_mes_termino_IV = sharedPref_mes_termino_IV.getInt("mes_termino_IV",1);

        //==========================================================================================

        //==========================SPINNER DISCIPLINA==============================================
        //load do ID da spinner do arquivo sharedPreferences
        SharedPreferences sharedPref = getSharedPreferences("disciplina",MODE_PRIVATE);
        int ID_salvo_disciplina = sharedPref.getInt("selecaodisciplina",0);

        // set the value of the spinner
        spn_disciplina.setSelection(ID_salvo_disciplina); //Seta a posição da spinner

        ID = ID_salvo_disciplina; //Seta o valor salvo para a ID da spinner

        //Método do spinner para capturar o item selecionado
        spn_disciplina.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id1) {

                //Save do ID da spinner no sharedPreferences
                int IDescolhadisciplina = spn_disciplina.getSelectedItemPosition();
                SharedPreferences sharedPref = getSharedPreferences("disciplina",0);
                SharedPreferences.Editor prefEditor = sharedPref.edit();
                prefEditor.putInt("selecaodisciplina",IDescolhadisciplina);
                prefEditor.commit();


                ID = posicao;

                IDAtual = ID;

                if (IDAtual != IDAnterior) {

                    startActivity(this);
                    IDAnterior = IDAtual;
                    //onPause();

                } else {

                }

                //mostrarid();
            }

            public int getId(){
                return ID;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
        //==========================================================================================

        DataSistema();
        //LinhaDoTempo_I();
        //LinhaDoTempo_II();
        //LinhaDoTempo_III();
        //LinhaDoTempo_IV();

    }//end OnCreate


    //=============================FUNÇÃO DE LEITURA DA DATA DO SISTEMA============================
    public void DataSistema(){

        //Leitor de data do sistema
        Calendar now = Calendar.getInstance();
        Dia_sistema = now.get(Calendar.DAY_OF_MONTH);
        Mes_sistema = now.get(Calendar.MONTH); // Note: zero based!
        Mes_sistema++;

       // Toast.makeText(Main_activity.this, "Dia: "+ Dia_sistema + " Mês: "+ Mes_sistema,Toast.LENGTH_SHORT).show();
    }
    //==============================================================================================

    //=============================COLOCAR SOMBRA NO BLOCO DE BIMESTRE==============================

          public void SombraBimestre(View view) {

            FrameLayout fl_1 = (FrameLayout) view.findViewById(R.id.fl_1);
            FrameLayout fl_2 = (FrameLayout) view.findViewById(R.id.fl_2);
            FrameLayout fl_3 = (FrameLayout) view.findViewById(R.id.fl_3);
            FrameLayout fl_4 = (FrameLayout) view.findViewById(R.id.fl_4);

            //====================================I BIMESTRE========================================

            if (Mes_sistema == ID_salvo_mes_termino_I) {

                if (Dia_sistema > ID_salvo_dia_termino_I) {

                   // Toast.makeText(Main_activity.this, "Sombra Bim_I ", Toast.LENGTH_SHORT).show();

                    fl_1.setVisibility(View.VISIBLE);

                } else
                    fl_1.setVisibility(View.GONE);
            } else if (Mes_sistema > ID_salvo_mes_termino_I) {

                fl_1.setVisibility(View.VISIBLE);

            } else if (Mes_sistema < ID_salvo_mes_termino_I) {

                fl_1.setVisibility(View.GONE);
            }
            //======================================================================================

            //===================================II BIMESTRE========================================
            if (Mes_sistema == ID_salvo_mes_termino_II) {

                if (Dia_sistema > ID_salvo_dia_termino_II) {

                    //Toast.makeText(Main_activity.this, "Sombra Bim_I ", Toast.LENGTH_SHORT).show();

                    fl_2.setVisibility(View.VISIBLE);

                } else
                    fl_2.setVisibility(View.GONE);
            } else if (Mes_sistema > ID_salvo_mes_termino_II) {

                fl_2.setVisibility(View.VISIBLE);

            } else if (Mes_sistema < ID_salvo_mes_termino_II) {

                fl_2.setVisibility(View.GONE);
            }
            //======================================================================================

            //==================================III BIMESTRE========================================
            if (Mes_sistema == ID_salvo_mes_termino_III) {

                if (Dia_sistema > ID_salvo_dia_termino_III) {

                    //Toast.makeText(Main_activity.this, "Sombra Bim_I ", Toast.LENGTH_SHORT).show();

                    fl_3.setVisibility(View.VISIBLE);

                } else
                    fl_3.setVisibility(View.GONE);
            } else if (Mes_sistema > ID_salvo_mes_termino_III) {

                fl_3.setVisibility(View.VISIBLE);

            } else if (Mes_sistema < ID_salvo_mes_termino_III) {

                fl_3.setVisibility(View.GONE);
            }
            //======================================================================================

            //===================================IV BIMESTRE========================================
            if (Mes_sistema == ID_salvo_mes_termino_IV) {

                if (Dia_sistema > ID_salvo_dia_termino_IV) {

                    //Toast.makeText(Main_activity.this, "Sombra Bim_I ", Toast.LENGTH_SHORT).show();

                    fl_4.setVisibility(View.VISIBLE);

                } else
                    fl_4.setVisibility(View.GONE);
            } else if (Mes_sistema > ID_salvo_mes_termino_IV) {

                fl_4.setVisibility(View.VISIBLE);

            } else if (Mes_sistema < ID_salvo_mes_termino_IV) {

                fl_4.setVisibility(View.GONE);
            }
            //======================================================================================
        }
    //==============================================================================================

    /*
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox1:
                if (checked)
                    Toast.makeText(Main_activity.this,"Marcado:",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Main_activity.this,"Desmarcado:",Toast.LENGTH_SHORT).show();
                break;
           // case R.id.checkbox_cheese:
               // if (checked)
               // // Cheese me
            //else
            //    // I'm lactose intolerant
             //   break;
            //
        }
    } */



    /*
    private void loadSavedPreferences() {

        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this/ Put some meat on the sandwich
            else);
        boolean checkBoxValue = sharedPreferences.getBoolean("CheckBox_Value", false);
        String name = sharedPreferences.getString("storedName", "YourName");
        if (checkBoxValue) {
            checkbox1.setChecked(true);

        } else {

            checkbox1.setChecked(false);
        }
    }

    private void savePreferences(String key, boolean value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public void onClick(View v) {
        //
        savePreferences("CheckBox_Value", checkbox1.isChecked());
        //if (checkbox1.isChecked())
        //savePreferences("storedName", editText.getText().toString());
        finish();
    }
    */



    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }

    private void startActivity(AdapterView.OnItemSelectedListener onItemSelectedListener) {

        Intent it = new Intent(this, Main_activity.class);
        startActivity(it);

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

            if (ID == 0) { //Arte

                switch (position) {

                    case 0:

                        return new Tab_arte_sexto();

                    case 1:

                        return new Tab_arte_setimo();


                    case 2:

                        return new Tab_arte_oitavo();

                    case 3:

                        return new Tab_arte_nono();
                }
            }

            else if (ID == 1) {//Ciencias

                switch (position) {

                    case 0:

                        return new Tab_ciencias_sexto();

                    case 1:

                        return new Tab_ciencias_setimo();

                    case 2:

                        return new Tab_ciencias_oitavo();

                    case 3:

                        return new Tab_ciencias_nono();
                }
            }

            else if (ID == 2) {//ed. fisica

                switch (position) {

                    case 0:

                        return new Tab_ed_fisica_sexto();

                    case 1:

                        return new Tab_ed_fisica_setimo();


                    case 2:

                        return new Tab_ed_fisica_oitavo();

                    case 3:

                        return new Tab_ed_fisica_nono();
                }
            }

            else if (ID == 3) {//ens_religioso

                switch (position) {

                    case 0:

                        return new Tab_ens_religioso_sexto();

                    case 1:

                        return new Tab_ens_religioso_setimo();


                    case 2:

                        return new Tab_ens_religioso_oitavo();

                    case 3:

                        return new Tab_ens_religioso_nono();
                }
            }
            else if (ID == 4) {//geografia

                switch (position) {

                    case 0:

                        return new Tab_geografia_sexto();

                    case 1:

                        return new Tab_geografia_setimo();


                    case 2:

                        return new Tab_geografia_oitavo();

                    case 3:

                        return new Tab_geografia_nono();
                }
            }
            else if (ID == 5) {//historia

                switch (position) {

                    case 0:

                        return new Tab_historia_sexto();

                    case 1:

                        return new Tab_historia_setimo();


                    case 2:

                        return new Tab_historia_oitavo();

                    case 3:

                        return new Tab_historia_nono();
                }
            }
            else if (ID == 6) {//Portugues

                switch (position) {

                    case 0:

                        return new Tab_portugues_sexto();

                    case 1:

                        return new Tab_portugues_setimo();


                    case 2:

                        return new Tab_portugues_oitavo();

                    case 3:

                        return new Tab_portugues_nono();
                }
            }
            else if (ID == 7) {//Matematica

                switch (position) {

                    case 0:

                        return new Tab_matematica_sexto();

                    case 1:

                        return new Tab_matematica_setimo();


                    case 2:

                        return new Tab_matematica_oitavo();

                    case 3:

                        return new Tab_matematica_nono();
                }
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
