package xingu.inteceleri.xingu;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AlertDialog;
import android.text.Layout;
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
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;



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

    //Autentição com o Google
    private GoogleApiClient googleApiClient;
    private ImageView photoID;
    private TextView nomeID;
    private RoundedBitmapDrawable roundedBitmapDrawable;
    private Intent data;

    //Firebase
    private FirebaseAuth fbAuth;
    private FirebaseAuth.AuthStateListener fbAuthListener;

    private Spinner spn_disciplina;
    public static int IDAtual;
    public static int ID;
    public static int IDAnterior;

    public int execucao = 1;
    public int configurar;

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


        //load do ID do estado de configurar bimestre
        SharedPreferences sharedPref_configurar = getSharedPreferences("pref_bimestre",MODE_PRIVATE);
        configurar = sharedPref_configurar.getInt("configurar",-1);

        configurar();

        //Salva booleana para saber se o app já executou anteriormente
        SharedPreferences sharedPref_execucao = getSharedPreferences("pref_bimestre",0);
        SharedPreferences.Editor prefEditor = sharedPref_execucao.edit();
        prefEditor.putInt("execucao",execucao);
        prefEditor.commit();

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

        adp_disciplina = new ArrayAdapter<String>(this, R.layout.layout_spinner);
        adp_disciplina.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spn_disciplina.setAdapter(adp_disciplina);

        adp_disciplina.add("Arte");
        adp_disciplina.add("Ciências");
        adp_disciplina.add("Educação física");
        adp_disciplina.add("Ensino religioso");
        adp_disciplina.add("Geografia");
        adp_disciplina.add("História");
        adp_disciplina.add("Língua portuguesa");
        adp_disciplina.add("Matemática");


        //FrameLayout da spinner
        final FrameLayout fl_spinner = (FrameLayout) findViewById(R.id.fl_spinner);


        //Botao OK dos objetivos
       Button btn_ok = (Button) findViewById(R.id.btn_ok);
        final FrameLayout fl_obj = (FrameLayout) findViewById(R.id.fl_obj);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.GONE);
                fl_spinner.setVisibility(View.VISIBLE);
            }
        });


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
        //------------------------------------------------------------------------------------------
        //Pegando um layout de xml acessado por outro xml

        //FirebaseUser fbUsuario = fbAuth.getCurrentUser();
        //View nav_header = (View) navigationView.getHeaderView(R.layout.nav_header_main_activity);

        //===================================================================================
        /*
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user!= null){


            String nome = user.getDisplayName();
            Uri photoUrl = user.getPhotoUrl();

            View header  = navigationView.getHeaderView(0);

            ImageView photoID = (ImageView) header.findViewById(R.id.imageViewPhoto);
            TextView nomeID = (TextView) header.findViewById(R.id.textViewEmailUsuario);

            photoID.setImageURI(photoUrl);
            nomeID.setText(nome);

            //String nome  = user.getDisplayName();
            //Uri photoUrl = user.getPhotoUrl();


        }*/
        //==========================================================================

        View header  = navigationView.getHeaderView(0);
         photoID = (ImageView) header.findViewById(R.id.imageViewPhoto);
         nomeID = (TextView) header.findViewById(R.id.textViewEmailUsuario);

        

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        googleApiClient= new GoogleApiClient.Builder(this)

                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();


        fbAuth = FirebaseAuth.getInstance();
        fbAuthListener = new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth){
                FirebaseUser user = fbAuth.getCurrentUser();
                if(user != null){
                    setUserData(user);
                }
            }
        };



        // TextView email = (TextView) findViewById(R.id.textViewEmailUsuario);
        //email.setText(fbUsuario.getEmail());

        /*
        //Método para limpar o arquivo SharedPreferences
        SharedPreferences settings = getSharedPreferences("disciplina", 0);
        SharedPreferences.Editor e = settings.edit();
        e.clear();
        e.commit();
        */

        //navigationView.findViewById(R.id.textViewEmailUsuario);
        //emailUsuario.setText(fbUsuario.getEmail());

        //------------------------------------------------------------------------------------------
        //Método do spinner para capturar o item selecionado

        //=============== CARREGAMENTO DAS DATAS DOS BIMESTRES =====================================

        //=================PRIMEIRO BIMESTRE========================================================

        //DIA INÍCIO
        SharedPreferences sharedPref_dia_inicio_I = getSharedPreferences("pref_bimestre",MODE_PRIVATE);
        ID_salvo_dia_inicio_I = sharedPref_dia_inicio_I.getInt("dia_inicio_I", 15);


        //DIA TÉRMINO
        SharedPreferences sharedPref_dia_termino_I = getSharedPreferences("pref_bimestre",MODE_PRIVATE);
        ID_salvo_dia_termino_I = sharedPref_dia_termino_I.getInt("dia_termino_I",15);

        //MÊS INÍCIO
        SharedPreferences sharedPref_mes_inicio_I = getSharedPreferences("pref_bimestre",MODE_PRIVATE);
        ID_salvo_mes_inicio_I = sharedPref_mes_inicio_I.getInt("mes_inicio_I",1);

        //MÊS TÉRMINO
        SharedPreferences sharedPref_mes_termino_I = getSharedPreferences("pref_bimestre",MODE_PRIVATE);
        ID_salvo_mes_termino_I = sharedPref_mes_termino_I.getInt("mes_termino_I",3);

        //==========================================================================================

        //=================SEGUNDO BIMESTRE=========================================================

        //DIA INICIO
        SharedPreferences sharedPref_dia_inicio_II = getSharedPreferences("pref_bimestre",MODE_PRIVATE);
        ID_salvo_dia_inicio_II = sharedPref_dia_inicio_II.getInt("dia_inicio_II",16);

        //DIA TÉRMINO
        SharedPreferences sharedPref_dia_termino_II = getSharedPreferences("pref_bimestre",MODE_PRIVATE);
        ID_salvo_dia_termino_II = sharedPref_dia_termino_II.getInt("dia_termino_II",16);

        //MES INÍCIO
        SharedPreferences sharedPref_mes_inicio_II = getSharedPreferences("pref_bimestre",MODE_PRIVATE);
        ID_salvo_mes_inicio_II = sharedPref_mes_inicio_II.getInt("mes_inicio_II",3);

        //MÊS TÉRMINO
        SharedPreferences sharedPref_mes_termino_II = getSharedPreferences("pref_bimestre",MODE_PRIVATE);
        ID_salvo_mes_termino_II = sharedPref_mes_termino_II.getInt("mes_termino_II",5);

        //==========================================================================================

        //=================TERCEIRO BIMESTRE========================================================

        //DIA INÍCIO
        SharedPreferences sharedPref_dia_inicio_III = getSharedPreferences("pref_bimestre",MODE_PRIVATE);
        ID_salvo_dia_inicio_III = sharedPref_dia_inicio_III.getInt("dia_inicio_III",5);

        //DIA TÉRMINO
        SharedPreferences sharedPref_dia_termino_III = getSharedPreferences("pref_bimestre",MODE_PRIVATE);
        ID_salvo_dia_termino_III = sharedPref_dia_termino_III.getInt("dia_termino_III",5);

        //MES INÍCIO
        SharedPreferences sharedPref_mes_inicio_III = getSharedPreferences("pref_bimestre",MODE_PRIVATE);
        ID_salvo_mes_inicio_III = sharedPref_mes_inicio_III.getInt("mes_inicio_III",7);

        //MÊS TÉRMINO
        SharedPreferences sharedPref_mes_termino_III = getSharedPreferences("pref_bimestre",MODE_PRIVATE);
        ID_salvo_mes_termino_III = sharedPref_mes_termino_III.getInt("mes_termino_III",9);

        //==========================================================================================

        //=================QUARTO BIMESTRE==========================================================

        //DIA INÍCIO
        SharedPreferences sharedPref_dia_inicio_IV = getSharedPreferences("pref_bimestre",MODE_PRIVATE);
        ID_salvo_dia_inicio_IV = sharedPref_dia_inicio_IV.getInt("dia_inicio_IV",6);

        //DIA TÉRMINO
        SharedPreferences sharedPref_dia_termino_IV = getSharedPreferences("pref_bimestre",MODE_PRIVATE);
        ID_salvo_dia_termino_IV = sharedPref_dia_termino_IV.getInt("dia_termino_IV",6);

        //MES INÍCIO
        SharedPreferences sharedPref_mes_inicio_IV = getSharedPreferences("pref_bimestre",MODE_PRIVATE);
        ID_salvo_mes_inicio_IV = sharedPref_mes_inicio_IV.getInt("mes_inicio_IV",9);

        //MÊS TÉRMINO
        SharedPreferences sharedPref_mes_termino_IV = getSharedPreferences("pref_bimestre",MODE_PRIVATE);
        ID_salvo_mes_termino_IV = sharedPref_mes_termino_IV.getInt("mes_termino_IV",11);

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

    }//end OnCreate

    public void configurar(){

        if(configurar != 1){

                //Escreve configurar == 1;
                SharedPreferences sharedPref_configurar = getSharedPreferences("pref_bimestre", 0);
                SharedPreferences.Editor prefEditor2 = sharedPref_configurar.edit();
                prefEditor2.putInt("configurar", 1);
                prefEditor2.commit();

                //Toast.makeText(Main_activity.this, "estado: "+ configurar,Toast.LENGTH_SHORT).show();

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Bem Vindo(a)!");
                builder.setMessage("Deseja modificar as datas padrão dos bimestres?")
                        .setCancelable(false)
                        .setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                        .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(Main_activity.this, Config_bimestre_activity.class);
                                startActivity(intent);
                            }
                        });
                builder.show();
        }

    }


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

    //==========================LAYOUT CONTEÚDO DOS BIMESTRES=======================================

    //=========================================ARTE SEXTO===========================================
    public void fl_obj_arte_sexto(View view) {
       final FrameLayout fl_obj = (FrameLayout) findViewById(R.id.fl_obj);
        Button btn1 = (Button) view.findViewById(R.id.btn1);
        Button btn2 = (Button) view.findViewById(R.id.btn2);
        Button btn3 = (Button) view.findViewById(R.id.btn3);
        Button btn4 = (Button) view.findViewById(R.id.btn4);
        final FrameLayout fl_spinner = (FrameLayout) findViewById(R.id.fl_spinner);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_arte_sexto_I);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_arte_sexto_II);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_arte_sexto_III);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_arte_sexto_IV);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });
    }
    //==============================================================================================

    //=========================================ARTE SETIMO==========================================
    public void fl_obj_arte_setimo(View view) {
        final FrameLayout fl_obj = (FrameLayout) findViewById(R.id.fl_obj);
        Button btn1 = (Button) view.findViewById(R.id.btn1);
        Button btn2 = (Button) view.findViewById(R.id.btn2);
        Button btn3 = (Button) view.findViewById(R.id.btn3);
        Button btn4 = (Button) view.findViewById(R.id.btn4);
        final FrameLayout fl_spinner = (FrameLayout) findViewById(R.id.fl_spinner);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_arte_setimo_I);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_arte_setimo_II);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_arte_setimo_III);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_arte_setimo_IV);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });
    }
    //==============================================================================================

    //=========================================ARTE OITAVO==========================================
    public void fl_obj_arte_oitavo(View view) {
        final FrameLayout fl_obj = (FrameLayout) findViewById(R.id.fl_obj);
        Button btn1 = (Button) view.findViewById(R.id.btn1);
        Button btn2 = (Button) view.findViewById(R.id.btn2);
        Button btn3 = (Button) view.findViewById(R.id.btn3);
        Button btn4 = (Button) view.findViewById(R.id.btn4);
        final FrameLayout fl_spinner = (FrameLayout) findViewById(R.id.fl_spinner);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_arte_oitavo_I);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_arte_oitavo_II);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_arte_oitavo_III);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_arte_oitavo_IV);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });
    }
    //==============================================================================================

    //=========================================ARTE NONO============================================
    public void fl_obj_arte_nono(View view) {
        final FrameLayout fl_obj = (FrameLayout) findViewById(R.id.fl_obj);
        Button btn1 = (Button) view.findViewById(R.id.btn1);
        Button btn2 = (Button) view.findViewById(R.id.btn2);
        Button btn3 = (Button) view.findViewById(R.id.btn3);
        Button btn4 = (Button) view.findViewById(R.id.btn4);
        final FrameLayout fl_spinner = (FrameLayout) findViewById(R.id.fl_spinner);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_arte_nono_I);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_arte_nono_II);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_arte_nono_III);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_arte_nono_IV);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });
    }
    //==============================================================================================


    //=========================================CIENCIAS SEXTO============================================
    public void fl_obj_ciencias_sexto(View view) {
        final FrameLayout fl_obj = (FrameLayout) findViewById(R.id.fl_obj);
        Button btn1 = (Button) view.findViewById(R.id.btn1);
        Button btn2 = (Button) view.findViewById(R.id.btn2);
        Button btn3 = (Button) view.findViewById(R.id.btn3);
        Button btn4 = (Button) view.findViewById(R.id.btn4);
        final FrameLayout fl_spinner = (FrameLayout) findViewById(R.id.fl_spinner);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ciencias_sexto_I);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ciencias_sexto_II);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ciencias_sexto_III);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ciencias_sexto_IV);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });
    }
    //==============================================================================================


    //=========================================CIENCIAS SETIMO============================================
    public void fl_obj_ciencias_setimo(View view) {
        final FrameLayout fl_obj = (FrameLayout) findViewById(R.id.fl_obj);
        Button btn1 = (Button) view.findViewById(R.id.btn1);
        Button btn2 = (Button) view.findViewById(R.id.btn2);
        Button btn3 = (Button) view.findViewById(R.id.btn3);
        Button btn4 = (Button) view.findViewById(R.id.btn4);
        final FrameLayout fl_spinner = (FrameLayout) findViewById(R.id.fl_spinner);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ciencias_setimo_I);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ciencias_setimo_II);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ciencias_setimo_III);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ciencias_setimo_IV);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });
    }
    //==============================================================================================


    //=========================================CIENCIAS OITAVO============================================
    public void fl_obj_ciencias_oitavo(View view) {
        final FrameLayout fl_obj = (FrameLayout) findViewById(R.id.fl_obj);
        Button btn1 = (Button) view.findViewById(R.id.btn1);
        Button btn2 = (Button) view.findViewById(R.id.btn2);
        Button btn3 = (Button) view.findViewById(R.id.btn3);
        Button btn4 = (Button) view.findViewById(R.id.btn4);
        final FrameLayout fl_spinner = (FrameLayout) findViewById(R.id.fl_spinner);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ciencias_oitavo_I);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ciencias_oitavo_II);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ciencias_oitavo_III);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ciencias_oitavo_IV);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });
    }
    //==============================================================================================


    //=========================================CIENCIAS NONO============================================
    public void fl_obj_ciencias_nono(View view) {
        final FrameLayout fl_obj = (FrameLayout) findViewById(R.id.fl_obj);
        Button btn1 = (Button) view.findViewById(R.id.btn1);
        Button btn2 = (Button) view.findViewById(R.id.btn2);
        Button btn3 = (Button) view.findViewById(R.id.btn3);
        Button btn4 = (Button) view.findViewById(R.id.btn4);
        final FrameLayout fl_spinner = (FrameLayout) findViewById(R.id.fl_spinner);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ciencias_nono_I);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ciencias_nono_II);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ciencias_nono_III);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ciencias_nono_IV);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });
    }
    //==============================================================================================

    //=========================================ED_FISICA SEXTO============================================
    public void fl_obj_ed_fisica_sexto(View view) {
        final FrameLayout fl_obj = (FrameLayout) findViewById(R.id.fl_obj);
        Button btn1 = (Button) view.findViewById(R.id.btn1);
        Button btn2 = (Button) view.findViewById(R.id.btn2);
        Button btn3 = (Button) view.findViewById(R.id.btn3);
        Button btn4 = (Button) view.findViewById(R.id.btn4);
        final FrameLayout fl_spinner = (FrameLayout) findViewById(R.id.fl_spinner);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ed_fisica_sexto_I);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ed_fisica_sexto_II);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ed_fisica_sexto_III);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ed_fisica_sexto_IV);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });
    }
    //==============================================================================================

    //=========================================ED_FISICA SETIMO============================================
    public void fl_obj_ed_fisica_setimo(View view) {
        final FrameLayout fl_obj = (FrameLayout) findViewById(R.id.fl_obj);
        Button btn1 = (Button) view.findViewById(R.id.btn1);
        Button btn2 = (Button) view.findViewById(R.id.btn2);
        Button btn3 = (Button) view.findViewById(R.id.btn3);
        Button btn4 = (Button) view.findViewById(R.id.btn4);
        final FrameLayout fl_spinner = (FrameLayout) findViewById(R.id.fl_spinner);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ed_fisica_setimo_I);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ed_fisica_setimo_II);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ed_fisica_setimo_III);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ed_fisica_setimo_IV);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });
    }
    //==============================================================================================

    //=========================================ED_FISICA OITAVO============================================
    public void fl_obj_ed_fisica_oitavo(View view) {
        final FrameLayout fl_obj = (FrameLayout) findViewById(R.id.fl_obj);
        Button btn1 = (Button) view.findViewById(R.id.btn1);
        Button btn2 = (Button) view.findViewById(R.id.btn2);
        Button btn3 = (Button) view.findViewById(R.id.btn3);
        Button btn4 = (Button) view.findViewById(R.id.btn4);
        final FrameLayout fl_spinner = (FrameLayout) findViewById(R.id.fl_spinner);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ed_fisica_oitavo_I);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ed_fisica_oitavo_II);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ed_fisica_oitavo_III);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ed_fisica_oitavo_IV);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });
    }
    //==============================================================================================

    //=========================================ED_FISICA NONO============================================
    public void fl_obj_ed_fisica_nono(View view) {
        final FrameLayout fl_obj = (FrameLayout) findViewById(R.id.fl_obj);
        Button btn1 = (Button) view.findViewById(R.id.btn1);
        Button btn2 = (Button) view.findViewById(R.id.btn2);
        Button btn3 = (Button) view.findViewById(R.id.btn3);
        Button btn4 = (Button) view.findViewById(R.id.btn4);
        final FrameLayout fl_spinner = (FrameLayout) findViewById(R.id.fl_spinner);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ed_fisica_nono_I);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ed_fisica_nono_II);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ed_fisica_nono_III);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ed_fisica_nono_IV);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });
    }
    //==============================================================================================

    //=========================================ENS_RELIGIOSO SEXTO============================================
    public void fl_obj_ens_religioso_sexto(View view) {
        final FrameLayout fl_obj = (FrameLayout) findViewById(R.id.fl_obj);
        Button btn1 = (Button) view.findViewById(R.id.btn1);
        Button btn2 = (Button) view.findViewById(R.id.btn2);
        Button btn3 = (Button) view.findViewById(R.id.btn3);
        Button btn4 = (Button) view.findViewById(R.id.btn4);
        final FrameLayout fl_spinner = (FrameLayout) findViewById(R.id.fl_spinner);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ens_religioso_sexto_I);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ens_religioso_sexto_II);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ens_religioso_sexto_III);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ens_religioso_sexto_IV);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });
    }
    //==============================================================================================

    //=========================================ENS_RELIGIOSO SETIMO============================================
    public void fl_obj_ens_religioso_setimo(View view) {
        final FrameLayout fl_obj = (FrameLayout) findViewById(R.id.fl_obj);
        Button btn1 = (Button) view.findViewById(R.id.btn1);
        Button btn2 = (Button) view.findViewById(R.id.btn2);
        Button btn3 = (Button) view.findViewById(R.id.btn3);
        Button btn4 = (Button) view.findViewById(R.id.btn4);
        final FrameLayout fl_spinner = (FrameLayout) findViewById(R.id.fl_spinner);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ens_religioso_setimo_I);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ens_religioso_setimo_II);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ens_religioso_setimo_III);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ens_religioso_setimo_IV);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });
    }
    //==============================================================================================

    //=========================================ENS_RELIGIOSO OITAVO============================================
    public void fl_obj_ens_religioso_oitavo(View view) {
        final FrameLayout fl_obj = (FrameLayout) findViewById(R.id.fl_obj);
        Button btn1 = (Button) view.findViewById(R.id.btn1);
        Button btn2 = (Button) view.findViewById(R.id.btn2);
        Button btn3 = (Button) view.findViewById(R.id.btn3);
        Button btn4 = (Button) view.findViewById(R.id.btn4);
        final FrameLayout fl_spinner = (FrameLayout) findViewById(R.id.fl_spinner);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ens_religioso_oitavo_I);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ens_religioso_oitavo_II);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ens_religioso_oitavo_III);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ens_religioso_oitavo_IV);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });
    }
    //==============================================================================================

    //=========================================ENS_RELIGIOSO NONO============================================
    public void fl_obj_ens_religioso_nono(View view) {
        final FrameLayout fl_obj = (FrameLayout) findViewById(R.id.fl_obj);
        Button btn1 = (Button) view.findViewById(R.id.btn1);
        Button btn2 = (Button) view.findViewById(R.id.btn2);
        Button btn3 = (Button) view.findViewById(R.id.btn3);
        Button btn4 = (Button) view.findViewById(R.id.btn4);
        final FrameLayout fl_spinner = (FrameLayout) findViewById(R.id.fl_spinner);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ens_religioso_nono_I);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ens_religioso_nono_II);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ens_religioso_nono_III);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_ens_religioso_nono_IV);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });
    }
    //==============================================================================================

    //=========================================GEOGRAFIA SEXTO============================================
    public void fl_obj_geografia_sexto(View view) {
        final FrameLayout fl_obj = (FrameLayout) findViewById(R.id.fl_obj);
        Button btn1 = (Button) view.findViewById(R.id.btn1);
        Button btn2 = (Button) view.findViewById(R.id.btn2);
        Button btn3 = (Button) view.findViewById(R.id.btn3);
        Button btn4 = (Button) view.findViewById(R.id.btn4);
        final FrameLayout fl_spinner = (FrameLayout) findViewById(R.id.fl_spinner);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_geografia_sexto_I);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_geografia_sexto_II);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_geografia_sexto_III);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_geografia_sexto_IV);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });
    }
    //==============================================================================================

    //=========================================GEOGRAFIA SETIMO============================================
    public void fl_obj_geografia_setimo(View view) {
        final FrameLayout fl_obj = (FrameLayout) findViewById(R.id.fl_obj);
        Button btn1 = (Button) view.findViewById(R.id.btn1);
        Button btn2 = (Button) view.findViewById(R.id.btn2);
        Button btn3 = (Button) view.findViewById(R.id.btn3);
        Button btn4 = (Button) view.findViewById(R.id.btn4);
        final FrameLayout fl_spinner = (FrameLayout) findViewById(R.id.fl_spinner);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_geografia_setimo_I);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_geografia_setimo_II);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_geografia_setimo_III);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_geografia_setimo_IV);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });
    }
    //==============================================================================================

    //=========================================GEOGRAFIA OITAVO============================================
    public void fl_obj_geografia_oitavo(View view) {
        final FrameLayout fl_obj = (FrameLayout) findViewById(R.id.fl_obj);
        Button btn1 = (Button) view.findViewById(R.id.btn1);
        Button btn2 = (Button) view.findViewById(R.id.btn2);
        Button btn3 = (Button) view.findViewById(R.id.btn3);
        Button btn4 = (Button) view.findViewById(R.id.btn4);
        final FrameLayout fl_spinner = (FrameLayout) findViewById(R.id.fl_spinner);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_geografia_oitavo_I);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_geografia_oitavo_II);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_geografia_oitavo_III);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_geografia_oitavo_IV);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });
    }
    //==============================================================================================

    //=========================================GEOGRAFIA NONO============================================
    public void fl_obj_geografia_nono(View view) {
        final FrameLayout fl_obj = (FrameLayout) findViewById(R.id.fl_obj);
        Button btn1 = (Button) view.findViewById(R.id.btn1);
        Button btn2 = (Button) view.findViewById(R.id.btn2);
        Button btn3 = (Button) view.findViewById(R.id.btn3);
        Button btn4 = (Button) view.findViewById(R.id.btn4);
        final FrameLayout fl_spinner = (FrameLayout) findViewById(R.id.fl_spinner);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_geografia_nono_I);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_geografia_nono_II);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_geografia_nono_III);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_geografia_nono_IV);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });
    }
    //==============================================================================================

    //=========================================HISTORIA SEXTO============================================
    public void fl_obj_historia_sexto(View view) {
        final FrameLayout fl_obj = (FrameLayout) findViewById(R.id.fl_obj);
        Button btn1 = (Button) view.findViewById(R.id.btn1);
        Button btn2 = (Button) view.findViewById(R.id.btn2);
        Button btn3 = (Button) view.findViewById(R.id.btn3);
        Button btn4 = (Button) view.findViewById(R.id.btn4);
        final FrameLayout fl_spinner = (FrameLayout) findViewById(R.id.fl_spinner);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_historia_sexto_I);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_historia_sexto_II);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_historia_sexto_III);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_historia_sexto_IV);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });
    }
    //==============================================================================================

    //=========================================HISTORIA SETIMO============================================
    public void fl_obj_historia_setimo(View view) {
        final FrameLayout fl_obj = (FrameLayout) findViewById(R.id.fl_obj);
        Button btn1 = (Button) view.findViewById(R.id.btn1);
        Button btn2 = (Button) view.findViewById(R.id.btn2);
        Button btn3 = (Button) view.findViewById(R.id.btn3);
        Button btn4 = (Button) view.findViewById(R.id.btn4);
        final FrameLayout fl_spinner = (FrameLayout) findViewById(R.id.fl_spinner);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_historia_setimo_I);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_historia_setimo_II);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_historia_setimo_III);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_historia_setimo_IV);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });
    }
    //==============================================================================================

    //=========================================HISTORIA OITAVO============================================
    public void fl_obj_historia_oitavo(View view) {
        final FrameLayout fl_obj = (FrameLayout) findViewById(R.id.fl_obj);
        Button btn1 = (Button) view.findViewById(R.id.btn1);
        Button btn2 = (Button) view.findViewById(R.id.btn2);
        Button btn3 = (Button) view.findViewById(R.id.btn3);
        Button btn4 = (Button) view.findViewById(R.id.btn4);
        final FrameLayout fl_spinner = (FrameLayout) findViewById(R.id.fl_spinner);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_historia_oitavo_I);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_historia_oitavo_II);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_historia_oitavo_III);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_historia_oitavo_IV);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });
    }
    //==============================================================================================

    //=========================================HISTORIA NONO============================================
    public void fl_obj_historia_nono(View view) {
        final FrameLayout fl_obj = (FrameLayout) findViewById(R.id.fl_obj);
        Button btn1 = (Button) view.findViewById(R.id.btn1);
        Button btn2 = (Button) view.findViewById(R.id.btn2);
        Button btn3 = (Button) view.findViewById(R.id.btn3);
        Button btn4 = (Button) view.findViewById(R.id.btn4);
        final FrameLayout fl_spinner = (FrameLayout) findViewById(R.id.fl_spinner);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_historia_nono_I);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_historia_nono_II);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_historia_nono_III);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_historia_nono_IV);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });
    }
    //==============================================================================================

    //=========================================MATEMATICA SEXTO============================================
    public void fl_obj_matematica_sexto(View view) {
        final FrameLayout fl_obj = (FrameLayout) findViewById(R.id.fl_obj);
        Button btn1 = (Button) view.findViewById(R.id.btn1);
        Button btn2 = (Button) view.findViewById(R.id.btn2);
        Button btn3 = (Button) view.findViewById(R.id.btn3);
        Button btn4 = (Button) view.findViewById(R.id.btn4);
        final FrameLayout fl_spinner = (FrameLayout) findViewById(R.id.fl_spinner);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_matematica_sexto_I);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_matematica_sexto_II);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_matematica_sexto_III);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_matematica_sexto_IV);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });
    }
    //==============================================================================================

    //=========================================MATEMATICA SETIMO============================================
    public void fl_obj_matematica_setimo(View view) {
        final FrameLayout fl_obj = (FrameLayout) findViewById(R.id.fl_obj);
        Button btn1 = (Button) view.findViewById(R.id.btn1);
        Button btn2 = (Button) view.findViewById(R.id.btn2);
        Button btn3 = (Button) view.findViewById(R.id.btn3);
        Button btn4 = (Button) view.findViewById(R.id.btn4);
        final FrameLayout fl_spinner = (FrameLayout) findViewById(R.id.fl_spinner);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_matematica_setimo_I);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_matematica_setimo_II);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_matematica_setimo_III);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_matematica_setimo_IV);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });
    }
    //==============================================================================================

    //=========================================MATEMATICA OITAVO============================================
    public void fl_obj_matematica_oitavo(View view) {
        final FrameLayout fl_obj = (FrameLayout) findViewById(R.id.fl_obj);
        Button btn1 = (Button) view.findViewById(R.id.btn1);
        Button btn2 = (Button) view.findViewById(R.id.btn2);
        Button btn3 = (Button) view.findViewById(R.id.btn3);
        Button btn4 = (Button) view.findViewById(R.id.btn4);
        final FrameLayout fl_spinner = (FrameLayout) findViewById(R.id.fl_spinner);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_matematica_oitavo_I);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_matematica_oitavo_II);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_matematica_oitavo_III);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_matematica_oitavo_IV);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });
    }
    //==============================================================================================

    //=========================================MATEMATICA NONO============================================
    public void fl_obj_matematica_nono(View view) {
        final FrameLayout fl_obj = (FrameLayout) findViewById(R.id.fl_obj);
        Button btn1 = (Button) view.findViewById(R.id.btn1);
        Button btn2 = (Button) view.findViewById(R.id.btn2);
        Button btn3 = (Button) view.findViewById(R.id.btn3);
        Button btn4 = (Button) view.findViewById(R.id.btn4);
        final FrameLayout fl_spinner = (FrameLayout) findViewById(R.id.fl_spinner);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_matematica_nono_I);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_matematica_nono_II);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_matematica_nono_III);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_matematica_nono_IV);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });
    }
    //==============================================================================================

    //=========================================PORTUGUES SEXTO============================================
    public void fl_obj_portugues_sexto(View view) {
        final FrameLayout fl_obj = (FrameLayout) findViewById(R.id.fl_obj);
        Button btn1 = (Button) view.findViewById(R.id.btn1);
        Button btn2 = (Button) view.findViewById(R.id.btn2);
        Button btn3 = (Button) view.findViewById(R.id.btn3);
        Button btn4 = (Button) view.findViewById(R.id.btn4);
        final FrameLayout fl_spinner = (FrameLayout) findViewById(R.id.fl_spinner);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_portugues_sexto_I);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_portugues_sexto_II);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_portugues_sexto_III);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_portugues_sexto_IV);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });
    }
    //==============================================================================================

    //=========================================PORTUGUES SETIMO============================================
    public void fl_obj_portugues_setimo(View view) {
        final FrameLayout fl_obj = (FrameLayout) findViewById(R.id.fl_obj);
        Button btn1 = (Button) view.findViewById(R.id.btn1);
        Button btn2 = (Button) view.findViewById(R.id.btn2);
        Button btn3 = (Button) view.findViewById(R.id.btn3);
        Button btn4 = (Button) view.findViewById(R.id.btn4);
        final FrameLayout fl_spinner = (FrameLayout) findViewById(R.id.fl_spinner);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_portugues_setimo_I);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_portugues_setimo_II);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_portugues_setimo_III);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_portugues_setimo_IV);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });
    }
    //==============================================================================================

    //=========================================PORTUGUES OITAVO============================================
    public void fl_obj_portugues_oitavo(View view) {
        final FrameLayout fl_obj = (FrameLayout) findViewById(R.id.fl_obj);
        Button btn1 = (Button) view.findViewById(R.id.btn1);
        Button btn2 = (Button) view.findViewById(R.id.btn2);
        Button btn3 = (Button) view.findViewById(R.id.btn3);
        Button btn4 = (Button) view.findViewById(R.id.btn4);
        final FrameLayout fl_spinner = (FrameLayout) findViewById(R.id.fl_spinner);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_portugues_oitavo_I);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_portugues_oitavo_II);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_portugues_oitavo_III);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
             // Toast.makeText(Main_activity.this, "Dia: "+ Dia_sistema + " Mês: "+ Mes_sistema,Toast.LENGTH_SHORT).show();
                 fl_obj.setVisibility(View.VISIBLE);
                 fl_spinner.setVisibility(View.GONE);

                 String obj = getString(R.string.obj_portugues_oitavo_IV);
                 TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                 txt_obj.setText(obj);
             }
        });
    }
    //==============================================================================================


    private void setUserData(FirebaseUser user){


        nomeID.setText(user.getDisplayName());
        //Glide.with(this)
        //       .load(user.getPhotoUrl())
        //        .into(photoID);

        Glide.with(this).load(user.getPhotoUrl()).asBitmap().centerCrop().into(new BitmapImageViewTarget(photoID) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                photoID.setImageDrawable(circularBitmapDrawable);
            }
        });

    }
    protected void onStart(){
        super.onStart();
        fbAuth.addAuthStateListener(fbAuthListener);
    }

    protected  void onStop(){
        super.onStop();

        if(fbAuthListener != null){
            fbAuth.removeAuthStateListener(fbAuthListener);
        }
    }

    private void  handleSingInResult(GoogleSignInResult result){
        if(result.isSuccess()){
            GoogleSignInAccount account = result.getSignInAccount();

            nomeID.setText(account.getDisplayName());
            Glide.with(this).load(account.getPhotoUrl()).into(photoID);

        }else
            goRegistroLogin();
        {

        }

    }

    private void goRegistroLogin(){
        Intent intent = new Intent(this,Registro_activity.class);
        startActivity(intent);
    }


    //=========================================PORTUGUES NONO============================================
    public void fl_obj_portugues_nono(View view) {
        final FrameLayout fl_obj = (FrameLayout) findViewById(R.id.fl_obj);
        Button btn1 = (Button) view.findViewById(R.id.btn1);
        Button btn2 = (Button) view.findViewById(R.id.btn2);
        Button btn3 = (Button) view.findViewById(R.id.btn3);
        Button btn4 = (Button) view.findViewById(R.id.btn4);
        final FrameLayout fl_spinner = (FrameLayout) findViewById(R.id.fl_spinner);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_portugues_nono_I);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_portugues_nono_II);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_portugues_nono_III);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fl_obj.setVisibility(View.VISIBLE);
                fl_spinner.setVisibility(View.GONE);

                String obj = getString(R.string.obj_portugues_nono_IV);
                TextView txt_obj = (TextView) findViewById(R.id.txt_obj);
                txt_obj.setText(obj);
            }
        });
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
    @Override
    protected void onPause(){
        super.onPause();
        finish();
    } */

    private void startActivity(AdapterView.OnItemSelectedListener onItemSelectedListener) {

        Intent it = new Intent(this, Main_activity.class);
        startActivity(it);

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
            shareIntent.setType("text/plain");
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
            //Abrir a mensagem de Apresentação de arte

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
