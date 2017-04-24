package xingu.inteceleri.xingu;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Main_activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Spinner spn_disciplina;
    private Spinner spn_ano;

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

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.configuracoes) {
            // chamar a activity de configurações
        } else if (id == R.id.compartilhar) {
            //Abrir opçoes de compartilhar
        } else if (id == R.id.arte) {
            //Abrir a mensagem de opções de arte
        } else if (id == R.id.ciencias) {

        } else if (id == R.id.ed_fisica) {

        } else if (id == R.id.ens_religioso) {

        } else if (id == R.id.geografia) {

        } else if (id == R.id.historia) {

        } else if (id == R.id.matematica) {

        } else if (id == R.id.portugues) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
