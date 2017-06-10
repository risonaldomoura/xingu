package xingu.inteceleri.xingu;

/**
 * Created by Risonald0 on 04/05/2017.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;

public class Tab_portugues_sexto extends Fragment {

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

    public int Dia_sistema;
    public int Mes_sistema;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cont_portugues_sexto, container, false);

        //=============== CARREGAMENTO DAS DATAS DOS BIMESTRES =====================================

        //=================PRIMEIRO BIMESTRE========================================================

        //DIA INÍCIO
        SharedPreferences sharedPref_dia_inicio_I = this.getActivity().getSharedPreferences("pref_bimestre", Context.MODE_PRIVATE);
        ID_salvo_dia_inicio_I = sharedPref_dia_inicio_I.getInt("dia_inicio_I", 15);

        //DIA TÉRMINO
        SharedPreferences sharedPref_dia_termino_I = this.getActivity().getSharedPreferences("pref_bimestre", Context.MODE_PRIVATE);
        ID_salvo_dia_termino_I = sharedPref_dia_termino_I.getInt("dia_termino_I", 15);

        //MÊS INÍCIO
        SharedPreferences sharedPref_mes_inicio_I = this.getActivity().getSharedPreferences("pref_bimestre", Context.MODE_PRIVATE);
        ID_salvo_mes_inicio_I = sharedPref_mes_inicio_I.getInt("mes_inicio_I", 1);

        //MÊS TÉRMINO
        SharedPreferences sharedPref_mes_termino_I = this.getActivity().getSharedPreferences("pref_bimestre", Context.MODE_PRIVATE);
        ID_salvo_mes_termino_I = sharedPref_mes_termino_I.getInt("mes_termino_I", 3);

        //==========================================================================================

        //=================SEGUNDO BIMESTRE=========================================================

        //DIA INICIO
        SharedPreferences sharedPref_dia_inicio_II = this.getActivity().getSharedPreferences("pref_bimestre", Context.MODE_PRIVATE);
        ID_salvo_dia_inicio_II = sharedPref_dia_inicio_II.getInt("dia_inicio_II", 16);

        //DIA TÉRMINO
        SharedPreferences sharedPref_dia_termino_II = this.getActivity().getSharedPreferences("pref_bimestre", Context.MODE_PRIVATE);
        ID_salvo_dia_termino_II = sharedPref_dia_termino_II.getInt("dia_termino_II", 16);

        //MES INÍCIO
        SharedPreferences sharedPref_mes_inicio_II = this.getActivity().getSharedPreferences("pref_bimestre", Context.MODE_PRIVATE);
        ID_salvo_mes_inicio_II = sharedPref_mes_inicio_II.getInt("mes_inicio_II", 3);

        //MÊS TÉRMINO
        SharedPreferences sharedPref_mes_termino_II = this.getActivity().getSharedPreferences("pref_bimestre", Context.MODE_PRIVATE);
        ID_salvo_mes_termino_II = sharedPref_mes_termino_II.getInt("mes_termino_II", 5);

        //==========================================================================================

        //=================TERCEIRO BIMESTRE========================================================

        //DIA INÍCIO
        SharedPreferences sharedPref_dia_inicio_III = this.getActivity().getSharedPreferences("pref_bimestre", Context.MODE_PRIVATE);
        ID_salvo_dia_inicio_III = sharedPref_dia_inicio_III.getInt("dia_inicio_III", 5);

        //DIA TÉRMINO
        SharedPreferences sharedPref_dia_termino_III = this.getActivity().getSharedPreferences("pref_bimestre", Context.MODE_PRIVATE);
        ID_salvo_dia_termino_III = sharedPref_dia_termino_III.getInt("dia_termino_III", 5);

        //MES INÍCIO
        SharedPreferences sharedPref_mes_inicio_III = this.getActivity().getSharedPreferences("pref_bimestre", Context.MODE_PRIVATE);
        ID_salvo_mes_inicio_III = sharedPref_mes_inicio_III.getInt("mes_inicio_III", 7);

        //MÊS TÉRMINO
        SharedPreferences sharedPref_mes_termino_III = this.getActivity().getSharedPreferences("pref_bimestre", Context.MODE_PRIVATE);
        ID_salvo_mes_termino_III = sharedPref_mes_termino_III.getInt("mes_termino_III", 9);

        //==========================================================================================

        //=================QUARTO BIMESTRE==========================================================

        //DIA INÍCIO
        SharedPreferences sharedPref_dia_inicio_IV = this.getActivity().getSharedPreferences("pref_bimestre", Context.MODE_PRIVATE);
        ID_salvo_dia_inicio_IV = sharedPref_dia_inicio_IV.getInt("dia_inicio_IV", 6);

        //DIA TÉRMINO
        SharedPreferences sharedPref_dia_termino_IV = this.getActivity().getSharedPreferences("pref_bimestre", Context.MODE_PRIVATE);
        ID_salvo_dia_termino_IV = sharedPref_dia_termino_IV.getInt("dia_termino_IV", 6);

        //MES INÍCIO
        SharedPreferences sharedPref_mes_inicio_IV = this.getActivity().getSharedPreferences("pref_bimestre", Context.MODE_PRIVATE);
        ID_salvo_mes_inicio_IV = sharedPref_mes_inicio_IV.getInt("mes_inicio_IV", 9);

        //MÊS TÉRMINO
        SharedPreferences sharedPref_mes_termino_IV = this.getActivity().getSharedPreferences("pref_bimestre", Context.MODE_PRIVATE);
        ID_salvo_mes_termino_IV = sharedPref_mes_termino_IV.getInt("mes_termino_IV", 11);

        //==========================================================================================


        //===================MÉTODO QUE SETA AS DATAS NOS BLOCOS DE BIMESTRES===========================
        // Iniciar os campos buscando no layout do Fragment

        //=========================I BIMESTRE=======================================================

        //DIA INICIO
        TextView dia_inicio_I = (TextView) view.findViewById(R.id.dia_inicio_I);
        dia_inicio_I.setText("" + ID_salvo_dia_inicio_I);

        //DIA TÉRMINO
        TextView dia_termino_I = (TextView) view.findViewById(R.id.dia_termino_I);
        dia_termino_I.setText("" + ID_salvo_dia_termino_I);

        //MES INICIO
        TextView mes_inicio_I = (TextView) view.findViewById(R.id.mes_inicio_I);

        if (ID_salvo_mes_inicio_I == 1)
            mes_inicio_I.setText(mes_1);
        else if (ID_salvo_mes_inicio_I == 2)
            mes_inicio_I.setText(mes_2);
        else if (ID_salvo_mes_inicio_I == 3)
            mes_inicio_I.setText(mes_3);
        else if (ID_salvo_mes_inicio_I == 4)
            mes_inicio_I.setText(mes_4);
        else if (ID_salvo_mes_inicio_I == 5)
            mes_inicio_I.setText(mes_5);
        else if (ID_salvo_mes_inicio_I == 6)
            mes_inicio_I.setText(mes_6);
        else if (ID_salvo_mes_inicio_I == 7)
            mes_inicio_I.setText(mes_7);
        else if (ID_salvo_mes_inicio_I == 8)
            mes_inicio_I.setText(mes_8);
        else if (ID_salvo_mes_inicio_I == 9)
            mes_inicio_I.setText(mes_9);
        else if (ID_salvo_mes_inicio_I == 10)
            mes_inicio_I.setText(mes_10);
        else if (ID_salvo_mes_inicio_I == 11)
            mes_inicio_I.setText(mes_11);
        else if (ID_salvo_mes_inicio_I == 12)
            mes_inicio_I.setText(mes_12);

        //MES TERMINO
        TextView mes_termino_I = (TextView) view.findViewById(R.id.mes_termino_I);

        if (ID_salvo_mes_termino_I == 1)
            mes_termino_I.setText(mes_1);
        else if (ID_salvo_mes_termino_I == 2)
            mes_termino_I.setText(mes_2);
        else if (ID_salvo_mes_termino_I == 3)
            mes_termino_I.setText(mes_3);
        else if (ID_salvo_mes_termino_I == 4)
            mes_termino_I.setText(mes_4);
        else if (ID_salvo_mes_termino_I == 5)
            mes_termino_I.setText(mes_5);
        else if (ID_salvo_mes_termino_I == 6)
            mes_termino_I.setText(mes_6);
        else if (ID_salvo_mes_termino_I == 7)
            mes_termino_I.setText(mes_7);
        else if (ID_salvo_mes_termino_I == 8)
            mes_termino_I.setText(mes_8);
        else if (ID_salvo_mes_termino_I == 9)
            mes_termino_I.setText(mes_9);
        else if (ID_salvo_mes_termino_I == 10)
            mes_termino_I.setText(mes_10);
        else if (ID_salvo_mes_termino_I == 11)
            mes_termino_I.setText(mes_11);
        else if (ID_salvo_mes_termino_I == 12)
            mes_termino_I.setText(mes_12);

        //==========================================================================================

        //=========================II BIMESTRE======================================================

        //DIA INICIO
        TextView dia_inicio_II = (TextView) view.findViewById(R.id.dia_inicio_II);
        dia_inicio_II.setText("" + ID_salvo_dia_inicio_II);

        //DIA TÉRMINO
        TextView dia_termino_II = (TextView) view.findViewById(R.id.dia_termino_II);
        dia_termino_II.setText("" + ID_salvo_dia_termino_II);

        //MES INICIO
        TextView mes_inicio_II = (TextView) view.findViewById(R.id.mes_inicio_II);

        if (ID_salvo_mes_inicio_II == 1)
            mes_inicio_II.setText(mes_1);
        else if (ID_salvo_mes_inicio_II == 2)
            mes_inicio_II.setText(mes_2);
        else if (ID_salvo_mes_inicio_II == 3)
            mes_inicio_II.setText(mes_3);
        else if (ID_salvo_mes_inicio_II == 4)
            mes_inicio_II.setText(mes_4);
        else if (ID_salvo_mes_inicio_II == 5)
            mes_inicio_II.setText(mes_5);
        else if (ID_salvo_mes_inicio_II == 6)
            mes_inicio_II.setText(mes_6);
        else if (ID_salvo_mes_inicio_II == 7)
            mes_inicio_II.setText(mes_7);
        else if (ID_salvo_mes_inicio_II == 8)
            mes_inicio_II.setText(mes_8);
        else if (ID_salvo_mes_inicio_II == 9)
            mes_inicio_II.setText(mes_9);
        else if (ID_salvo_mes_inicio_II == 10)
            mes_inicio_II.setText(mes_10);
        else if (ID_salvo_mes_inicio_II == 11)
            mes_inicio_II.setText(mes_11);
        else if (ID_salvo_mes_inicio_II == 12)
            mes_inicio_II.setText(mes_12);

        //MES TERMINO
        TextView mes_termino_II = (TextView) view.findViewById(R.id.mes_termino_II);

        if (ID_salvo_mes_termino_II == 1)
            mes_termino_II.setText(mes_1);
        else if (ID_salvo_mes_termino_II == 2)
            mes_termino_II.setText(mes_2);
        else if (ID_salvo_mes_termino_II == 3)
            mes_termino_II.setText(mes_3);
        else if (ID_salvo_mes_termino_II == 4)
            mes_termino_II.setText(mes_4);
        else if (ID_salvo_mes_termino_II == 5)
            mes_termino_II.setText(mes_5);
        else if (ID_salvo_mes_termino_II == 6)
            mes_termino_II.setText(mes_6);
        else if (ID_salvo_mes_termino_II == 7)
            mes_termino_II.setText(mes_7);
        else if (ID_salvo_mes_termino_II == 8)
            mes_termino_II.setText(mes_8);
        else if (ID_salvo_mes_termino_II == 9)
            mes_termino_II.setText(mes_9);
        else if (ID_salvo_mes_termino_II == 10)
            mes_termino_II.setText(mes_10);
        else if (ID_salvo_mes_termino_II == 11)
            mes_termino_II.setText(mes_11);
        else if (ID_salvo_mes_termino_II == 12)
            mes_termino_II.setText(mes_12);

        //==========================================================================================

        //=========================III BIMESTRE=====================================================

        //DIA INICIO
        TextView dia_inicio_III = (TextView) view.findViewById(R.id.dia_inicio_III);
        dia_inicio_III.setText("" + ID_salvo_dia_inicio_III);

        //DIA TÉRMINO
        TextView dia_termino_III = (TextView) view.findViewById(R.id.dia_termino_III);
        dia_termino_III.setText("" + ID_salvo_dia_termino_III);

        //MES INICIO
        TextView mes_inicio_III = (TextView) view.findViewById(R.id.mes_inicio_III);

        if (ID_salvo_mes_inicio_III == 1)
            mes_inicio_III.setText(mes_1);
        else if (ID_salvo_mes_inicio_III == 2)
            mes_inicio_III.setText(mes_2);
        else if (ID_salvo_mes_inicio_III == 3)
            mes_inicio_III.setText(mes_3);
        else if (ID_salvo_mes_inicio_III == 4)
            mes_inicio_III.setText(mes_4);
        else if (ID_salvo_mes_inicio_III == 5)
            mes_inicio_III.setText(mes_5);
        else if (ID_salvo_mes_inicio_III == 6)
            mes_inicio_III.setText(mes_6);
        else if (ID_salvo_mes_inicio_III == 7)
            mes_inicio_III.setText(mes_7);
        else if (ID_salvo_mes_inicio_III == 8)
            mes_inicio_III.setText(mes_8);
        else if (ID_salvo_mes_inicio_III == 9)
            mes_inicio_III.setText(mes_9);
        else if (ID_salvo_mes_inicio_III == 10)
            mes_inicio_III.setText(mes_10);
        else if (ID_salvo_mes_inicio_III == 11)
            mes_inicio_III.setText(mes_11);
        else if (ID_salvo_mes_inicio_III == 12)
            mes_inicio_III.setText(mes_12);

        //MES TERMINO
        TextView mes_termino_III = (TextView) view.findViewById(R.id.mes_termino_III);

        if (ID_salvo_mes_termino_III == 1)
            mes_termino_III.setText(mes_1);
        else if (ID_salvo_mes_termino_III == 2)
            mes_termino_III.setText(mes_2);
        else if (ID_salvo_mes_termino_III == 3)
            mes_termino_III.setText(mes_3);
        else if (ID_salvo_mes_termino_III == 4)
            mes_termino_III.setText(mes_4);
        else if (ID_salvo_mes_termino_III == 5)
            mes_termino_III.setText(mes_5);
        else if (ID_salvo_mes_termino_III == 6)
            mes_termino_III.setText(mes_6);
        else if (ID_salvo_mes_termino_III == 7)
            mes_termino_III.setText(mes_7);
        else if (ID_salvo_mes_termino_III == 8)
            mes_termino_III.setText(mes_8);
        else if (ID_salvo_mes_termino_III == 9)
            mes_termino_III.setText(mes_9);
        else if (ID_salvo_mes_termino_III == 10)
            mes_termino_III.setText(mes_10);
        else if (ID_salvo_mes_termino_III == 11)
            mes_termino_III.setText(mes_11);
        else if (ID_salvo_mes_termino_III == 12)
            mes_termino_III.setText(mes_12);

        //==========================================================================================

        //=========================IV BIMESTRE======================================================

        //DIA INICIO
        TextView dia_inicio_IV = (TextView) view.findViewById(R.id.dia_inicio_IV);
        dia_inicio_IV.setText("" + ID_salvo_dia_inicio_IV);

        //DIA TÉRMINO
        TextView dia_termino_IV = (TextView) view.findViewById(R.id.dia_termino_IV);
        dia_termino_IV.setText("" + ID_salvo_dia_termino_IV);

        //MES INICIO
        TextView mes_inicio_IV = (TextView) view.findViewById(R.id.mes_inicio_IV);

        if (ID_salvo_mes_inicio_IV == 1)
            mes_inicio_IV.setText(mes_1);
        else if (ID_salvo_mes_inicio_IV == 2)
            mes_inicio_IV.setText(mes_2);
        else if (ID_salvo_mes_inicio_IV == 3)
            mes_inicio_IV.setText(mes_3);
        else if (ID_salvo_mes_inicio_IV == 4)
            mes_inicio_IV.setText(mes_4);
        else if (ID_salvo_mes_inicio_IV == 5)
            mes_inicio_IV.setText(mes_5);
        else if (ID_salvo_mes_inicio_IV == 6)
            mes_inicio_IV.setText(mes_6);
        else if (ID_salvo_mes_inicio_IV == 7)
            mes_inicio_IV.setText(mes_7);
        else if (ID_salvo_mes_inicio_IV == 8)
            mes_inicio_IV.setText(mes_8);
        else if (ID_salvo_mes_inicio_IV == 9)
            mes_inicio_IV.setText(mes_9);
        else if (ID_salvo_mes_inicio_IV == 10)
            mes_inicio_IV.setText(mes_10);
        else if (ID_salvo_mes_inicio_IV == 11)
            mes_inicio_IV.setText(mes_11);
        else if (ID_salvo_mes_inicio_IV == 12)
            mes_inicio_IV.setText(mes_12);

        //MES TERMINO
        TextView mes_termino_IV = (TextView) view.findViewById(R.id.mes_termino_IV);

        if (ID_salvo_mes_termino_IV == 1)
            mes_termino_IV.setText(mes_1);
        else if (ID_salvo_mes_termino_IV == 2)
            mes_termino_IV.setText(mes_2);
        else if (ID_salvo_mes_termino_IV == 3)
            mes_termino_IV.setText(mes_3);
        else if (ID_salvo_mes_termino_IV == 4)
            mes_termino_IV.setText(mes_4);
        else if (ID_salvo_mes_termino_IV == 5)
            mes_termino_IV.setText(mes_5);
        else if (ID_salvo_mes_termino_IV == 6)
            mes_termino_IV.setText(mes_6);
        else if (ID_salvo_mes_termino_IV == 7)
            mes_termino_IV.setText(mes_7);
        else if (ID_salvo_mes_termino_IV == 8)
            mes_termino_IV.setText(mes_8);
        else if (ID_salvo_mes_termino_IV == 9)
            mes_termino_IV.setText(mes_9);
        else if (ID_salvo_mes_termino_IV == 10)
            mes_termino_IV.setText(mes_10);
        else if (ID_salvo_mes_termino_IV == 11)
            mes_termino_IV.setText(mes_11);
        else if (ID_salvo_mes_termino_IV == 12)
            mes_termino_IV.setText(mes_12);

        //==========================================================================================
        //FIM DO MÉTODO DE DATAS DOS BIMESTRES


        DataSistema();

        return view;

    }//end OnCreate

    //=============================FUNÇÃO DE LEITURA DA DATA DO SISTEMA============================
    public void DataSistema(){

        //Leitor de data do sistema
        Calendar now = Calendar.getInstance();
        Dia_sistema = now.get(Calendar.DAY_OF_MONTH);
        Mes_sistema = now.get(Calendar.MONTH); // Note: zero based!
        Mes_sistema++;

        //Toast.makeText(getActivity().getApplicationContext()," "+ Dia_sistema + " / "+ Mes_sistema, Toast.LENGTH_LONG);

    }
    //==============================================================================================


    //===========================MÉTODO QUE RECEBE AS SOMBRAS DOS BIMESTRES===========================
    @Override
    public void onViewCreated (View view, Bundle savedInstanceState) {
        ((Main_activity) getActivity()).SombraBimestre(view);
    }
    //==============================================================================================
}