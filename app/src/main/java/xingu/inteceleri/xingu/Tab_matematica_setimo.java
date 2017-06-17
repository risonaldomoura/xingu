package xingu.inteceleri.xingu;

/**
 * Created by Risonald0 on 04/05/2017.
 */

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Tab_matematica_setimo extends Fragment {

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

    public int estadocb1, estadocb2, estadocb3, estadocb4, estadocb5, estadocb6, estadocb7, estadocb8
            ,estadocb9, estadocb10, estadocb11, estadocb12, estadocb13, estadocb14, estadocb15
            , estadocb16, estadocb17, estadocb18, estadocb19, estadocb20, estadocb21, estadocb22
            , estadocb23, estadocb24, estadocb25, estadocb26, estadocb27, estadocb28, estadocb29
            , estadocb30, estadocb31, estadocb32, estadocb33, estadocb34, estadocb35, estadocb36
            , estadocb37, estadocb38, estadocb39, estadocb40, estadocb41, estadocb42, estadocb43
            , estadocb44, estadocb45, estadocb46, estadocb47, estadocb48, estadocb49, estadocb50
            , estadocb51, estadocb52, estadocb53, estadocb54, estadocb55, estadocb56, estadocb57;

    CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9, cb10, cb11, cb12, cb13, cb14, cb15, cb16
            , cb17, cb18, cb19, cb20, cb21, cb22, cb23, cb24, cb25, cb26, cb27, cb28, cb29, cb30, cb31
            , cb32, cb33, cb34, cb35, cb36, cb37, cb38, cb39, cb40, cb41, cb42, cb43, cb44, cb45, cb46
            , cb47, cb48, cb49, cb50, cb51, cb52, cb53, cb54, cb55, cb56, cb57;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cont_matematica_setimo, container, false);

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

        //======================TRATAMENTO DO CHECKBOX 1============================================

        cb1 = (CheckBox) view.findViewById(R.id.cb1);

        SharedPreferences sharedPref_estadocb1 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb1 = sharedPref_estadocb1.getInt("estadocb1", 0);

        if (estadocb1 == 0)
            cb1.setChecked(false);
        else
            cb1.setChecked(true);

        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb1.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);

                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);

                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb1.setChecked(true);

                            //estadocb1 = 1;
                            SharedPreferences sharedPref_estadocb1 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb1.edit();
                            prefEditor.putInt("estadocb1",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);

                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb1.setChecked(false);

                            SharedPreferences sharedPref_estadocb1 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb1.edit();
                            prefEditor.putInt("estadocb1", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });


        //===================================FIM CHECKBOX 1=========================================

        //======================TRATAMENTO DO CHECKBOX 2============================================

        cb2 = (CheckBox) view.findViewById(R.id.cb2);

        SharedPreferences sharedPref_estadocb2 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb2 = sharedPref_estadocb2.getInt("estadocb2", 0);

        if (estadocb2 == 0)
            cb2.setChecked(false);
        else
            cb2.setChecked(true);

        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb2.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb2.setChecked(true);

                            //estadocb2 = 1;
                            SharedPreferences sharedPref_estadocb2 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb2.edit();
                            prefEditor.putInt("estadocb2",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb2.setChecked(false);

                            SharedPreferences sharedPref_estadocb2 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb2.edit();
                            prefEditor.putInt("estadocb2", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 2=========================================


        //======================TRATAMENTO DO CHECKBOX 3============================================

        cb3 = (CheckBox) view.findViewById(R.id.cb3);

        SharedPreferences sharedPref_estadocb3 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb3 = sharedPref_estadocb3.getInt("estadocb3", 0);

        if (estadocb3 == 0)
            cb3.setChecked(false);
        else
            cb3.setChecked(true);

        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb3.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb3.setChecked(true);

                            //estadocb3 = 1;
                            SharedPreferences sharedPref_estadocb3 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb3.edit();
                            prefEditor.putInt("estadocb3",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb3.setChecked(false);

                            SharedPreferences sharedPref_estadocb3 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb3.edit();
                            prefEditor.putInt("estadocb3", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 3=========================================

        //======================TRATAMENTO DO CHECKBOX 4============================================

        cb4 = (CheckBox) view.findViewById(R.id.cb4);

        SharedPreferences sharedPref_estadocb4 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb4 = sharedPref_estadocb4.getInt("estadocb4", 0);

        if (estadocb4 == 0)
            cb4.setChecked(false);
        else
            cb4.setChecked(true);

        cb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb4.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb4.setChecked(true);

                            //estadocb4 = 1;
                            SharedPreferences sharedPref_estadocb4 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb4.edit();
                            prefEditor.putInt("estadocb4",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb4.setChecked(false);

                            SharedPreferences sharedPref_estadocb4 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb4.edit();
                            prefEditor.putInt("estadocb4", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 4=========================================


        //======================TRATAMENTO DO CHECKBOX 5============================================

        cb5 = (CheckBox) view.findViewById(R.id.cb5);

        SharedPreferences sharedPref_estadocb5 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb5 = sharedPref_estadocb5.getInt("estadocb5", 0);

        if (estadocb5 == 0)
            cb5.setChecked(false);
        else
            cb5.setChecked(true);

        cb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb5.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb5.setChecked(true);

                            //estadocb5 = 1;
                            SharedPreferences sharedPref_estadocb5 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb5.edit();
                            prefEditor.putInt("estadocb5",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb5.setChecked(false);

                            SharedPreferences sharedPref_estadocb5 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb5.edit();
                            prefEditor.putInt("estadocb5", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 5=========================================

        //======================TRATAMENTO DO CHECKBOX 6============================================

        cb6 = (CheckBox) view.findViewById(R.id.cb6);

        SharedPreferences sharedPref_estadocb6 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb6 = sharedPref_estadocb6.getInt("estadocb6", 0);

        if (estadocb6 == 0)
            cb6.setChecked(false);
        else
            cb6.setChecked(true);

        cb6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb6.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb6.setChecked(true);

                            //estadocb6 = 1;
                            SharedPreferences sharedPref_estadocb6 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb6.edit();
                            prefEditor.putInt("estadocb6",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb6.setChecked(false);

                            SharedPreferences sharedPref_estadocb6 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb6.edit();
                            prefEditor.putInt("estadocb6", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 6=========================================


        //======================TRATAMENTO DO CHECKBOX 7============================================

        cb7 = (CheckBox) view.findViewById(R.id.cb7);

        SharedPreferences sharedPref_estadocb7 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb7 = sharedPref_estadocb7.getInt("estadocb7", 0);

        if (estadocb7 == 0)
            cb7.setChecked(false);
        else
            cb7.setChecked(true);

        cb7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb7.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb7.setChecked(true);

                            //estadocb7 = 1;
                            SharedPreferences sharedPref_estadocb7 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb7.edit();
                            prefEditor.putInt("estadocb7",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb7.setChecked(false);

                            SharedPreferences sharedPref_estadocb7 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb7.edit();
                            prefEditor.putInt("estadocb7", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 7=========================================


        //======================TRATAMENTO DO CHECKBOX 8============================================

        cb8 = (CheckBox) view.findViewById(R.id.cb8);

        SharedPreferences sharedPref_estadocb8 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb8 = sharedPref_estadocb8.getInt("estadocb8", 0);

        if (estadocb8 == 0)
            cb8.setChecked(false);
        else
            cb8.setChecked(true);

        cb8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb8.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb8.setChecked(true);

                            //estadocb8 = 1;
                            SharedPreferences sharedPref_estadocb8 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb8.edit();
                            prefEditor.putInt("estadocb8",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb8.setChecked(false);

                            SharedPreferences sharedPref_estadocb8 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb8.edit();
                            prefEditor.putInt("estadocb8", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 8=========================================

        //======================TRATAMENTO DO CHECKBOX 9============================================

        cb9 = (CheckBox) view.findViewById(R.id.cb9);

        SharedPreferences sharedPref_estadocb9 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb9 = sharedPref_estadocb9.getInt("estadocb9", 0);

        if (estadocb9 == 0)
            cb9.setChecked(false);
        else
            cb9.setChecked(true);

        cb9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb9.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb9.setChecked(true);

                            //estadocb9 = 1;
                            SharedPreferences sharedPref_estadocb9 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb9.edit();
                            prefEditor.putInt("estadocb9",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb9.setChecked(false);

                            SharedPreferences sharedPref_estadocb9 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb9.edit();
                            prefEditor.putInt("estadocb9", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 9=========================================

        //======================TRATAMENTO DO CHECKBOX 10===========================================

        cb10 = (CheckBox) view.findViewById(R.id.cb10);

        SharedPreferences sharedPref_estadocb10 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb10 = sharedPref_estadocb10.getInt("estadocb10", 0);

        if (estadocb10 == 0)
            cb10.setChecked(false);
        else
            cb10.setChecked(true);

        cb10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb10.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb10.setChecked(true);

                            //estadocb10 = 1;
                            SharedPreferences sharedPref_estadocb10 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb10.edit();
                            prefEditor.putInt("estadocb10",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb10.setChecked(false);

                            SharedPreferences sharedPref_estadocb10 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb10.edit();
                            prefEditor.putInt("estadocb10", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 10========================================

        //======================TRATAMENTO DO CHECKBOX 11============================================

        cb11 = (CheckBox) view.findViewById(R.id.cb11);

        SharedPreferences sharedPref_estadocb11 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb11 = sharedPref_estadocb11.getInt("estadocb11", 0);

        if (estadocb11 == 0)
            cb11.setChecked(false);
        else
            cb11.setChecked(true);

        cb11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb11.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);

                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);

                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb11.setChecked(true);

                            //estadocb11 = 1;
                            SharedPreferences sharedPref_estadocb11 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb11.edit();
                            prefEditor.putInt("estadocb11",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);

                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb11.setChecked(false);

                            SharedPreferences sharedPref_estadocb11 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb11.edit();
                            prefEditor.putInt("estadocb11", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });


        //===================================FIM CHECKBOX 11========================================

        //======================TRATAMENTO DO CHECKBOX 12===========================================

        cb12 = (CheckBox) view.findViewById(R.id.cb12);

        SharedPreferences sharedPref_estadocb12 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb12 = sharedPref_estadocb12.getInt("estadocb12", 0);

        if (estadocb12 == 0)
            cb12.setChecked(false);
        else
            cb12.setChecked(true);

        cb12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb12.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);

                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);

                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb12.setChecked(true);

                            //estadocb12 = 1;
                            SharedPreferences sharedPref_estadocb12 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb12.edit();
                            prefEditor.putInt("estadocb12",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);

                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb12.setChecked(false);

                            SharedPreferences sharedPref_estadocb12 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb12.edit();
                            prefEditor.putInt("estadocb12", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });


        //===================================FIM CHECKBOX 12========================================

        //======================TRATAMENTO DO CHECKBOX 13============================================

        cb13 = (CheckBox) view.findViewById(R.id.cb13);

        SharedPreferences sharedPref_estadocb13 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb13 = sharedPref_estadocb13.getInt("estadocb13", 0);

        if (estadocb13 == 0)
            cb13.setChecked(false);
        else
            cb13.setChecked(true);

        cb13.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb13.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);

                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);

                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb13.setChecked(true);

                            //estadocb13 = 1;
                            SharedPreferences sharedPref_estadocb13 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb13.edit();
                            prefEditor.putInt("estadocb13",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);

                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb13.setChecked(false);

                            SharedPreferences sharedPref_estadocb13 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb13.edit();
                            prefEditor.putInt("estadocb13", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });


        //===================================FIM CHECKBOX 13========================================

        //======================TRATAMENTO DO CHECKBOX 14===========================================

        cb14 = (CheckBox) view.findViewById(R.id.cb14);

        SharedPreferences sharedPref_estadocb14 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb14 = sharedPref_estadocb14.getInt("estadocb14", 0);

        if (estadocb14 == 0)
            cb14.setChecked(false);
        else
            cb14.setChecked(true);

        cb14.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb14.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);

                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);

                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb14.setChecked(true);

                            //estadocb14 = 1;
                            SharedPreferences sharedPref_estadocb14 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb14.edit();
                            prefEditor.putInt("estadocb14",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);

                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb14.setChecked(false);

                            SharedPreferences sharedPref_estadocb14 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb14.edit();
                            prefEditor.putInt("estadocb14", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });


        //===================================FIM CHECKBOX 14========================================

        //======================TRATAMENTO DO CHECKBOX 15============================================

        cb15 = (CheckBox) view.findViewById(R.id.cb15);

        SharedPreferences sharedPref_estadocb15 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb15 = sharedPref_estadocb15.getInt("estadocb15", 0);

        if (estadocb15 == 0)
            cb15.setChecked(false);
        else
            cb15.setChecked(true);

        cb15.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb15.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);

                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);

                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb15.setChecked(true);

                            //estadocb15 = 1;
                            SharedPreferences sharedPref_estadocb15 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb15.edit();
                            prefEditor.putInt("estadocb15",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);

                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb15.setChecked(false);

                            SharedPreferences sharedPref_estadocb15 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb15.edit();
                            prefEditor.putInt("estadocb15", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });


        //===================================FIM CHECKBOX 15========================================

        //======================TRATAMENTO DO CHECKBOX 16============================================

        cb16 = (CheckBox) view.findViewById(R.id.cb16);

        SharedPreferences sharedPref_estadocb16 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb16 = sharedPref_estadocb16.getInt("estadocb16", 0);

        if (estadocb16 == 0)
            cb16.setChecked(false);
        else
            cb16.setChecked(true);

        cb16.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb16.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);

                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);

                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb16.setChecked(true);

                            //estadocb16 = 1;
                            SharedPreferences sharedPref_estadocb16 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb16.edit();
                            prefEditor.putInt("estadocb16",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);

                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb16.setChecked(false);

                            SharedPreferences sharedPref_estadocb16 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb16.edit();
                            prefEditor.putInt("estadocb16", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });


        //===================================FIM CHECKBOX 16========================================

        //======================TRATAMENTO DO CHECKBOX 17===========================================

        cb17 = (CheckBox) view.findViewById(R.id.cb17);

        SharedPreferences sharedPref_estadocb17 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb17 = sharedPref_estadocb17.getInt("estadocb17", 0);

        if (estadocb17 == 0)
            cb17.setChecked(false);
        else
            cb17.setChecked(true);

        cb17.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb17.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);

                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);

                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb17.setChecked(true);

                            //estadocb17 = 1;
                            SharedPreferences sharedPref_estadocb17 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb17.edit();
                            prefEditor.putInt("estadocb17",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);

                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb17.setChecked(false);

                            SharedPreferences sharedPref_estadocb17 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb17.edit();
                            prefEditor.putInt("estadocb17", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });


        //===================================FIM CHECKBOX 17========================================

        //======================TRATAMENTO DO CHECKBOX 18============================================

        cb18 = (CheckBox) view.findViewById(R.id.cb18);

        SharedPreferences sharedPref_estadocb18 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb18 = sharedPref_estadocb18.getInt("estadocb18", 0);

        if (estadocb18 == 0)
            cb18.setChecked(false);
        else
            cb18.setChecked(true);

        cb18.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb18.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);

                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);

                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb18.setChecked(true);

                            //estadocb18 = 1;
                            SharedPreferences sharedPref_estadocb18 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb18.edit();
                            prefEditor.putInt("estadocb18",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);

                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb18.setChecked(false);

                            SharedPreferences sharedPref_estadocb18 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb18.edit();
                            prefEditor.putInt("estadocb18", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });


        //===================================FIM CHECKBOX 18========================================

        //======================TRATAMENTO DO CHECKBOX 19============================================

        cb19 = (CheckBox) view.findViewById(R.id.cb19);

        SharedPreferences sharedPref_estadocb19 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb19 = sharedPref_estadocb19.getInt("estadocb19", 0);

        if (estadocb19 == 0)
            cb19.setChecked(false);
        else
            cb19.setChecked(true);

        cb19.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb19.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);

                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);

                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb19.setChecked(true);

                            //estadocb19 = 1;
                            SharedPreferences sharedPref_estadocb19 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb19.edit();
                            prefEditor.putInt("estadocb19",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);

                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb19.setChecked(false);

                            SharedPreferences sharedPref_estadocb19 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb19.edit();
                            prefEditor.putInt("estadocb19", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });


        //===================================FIM CHECKBOX 19========================================

        //======================TRATAMENTO DO CHECKBOX 20============================================

        cb20 = (CheckBox) view.findViewById(R.id.cb20);

        SharedPreferences sharedPref_estadocb20 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb20 = sharedPref_estadocb20.getInt("estadocb20", 0);

        if (estadocb20 == 0)
            cb20.setChecked(false);
        else
            cb20.setChecked(true);

        cb20.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb20.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb20.setChecked(true);

                            //estadocb20 = 1;
                            SharedPreferences sharedPref_estadocb20 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb20.edit();
                            prefEditor.putInt("estadocb20",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb20.setChecked(false);

                            SharedPreferences sharedPref_estadocb20 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb20.edit();
                            prefEditor.putInt("estadocb20", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 20========================================

        //======================TRATAMENTO DO CHECKBOX 21============================================

        cb21 = (CheckBox) view.findViewById(R.id.cb21);

        SharedPreferences sharedPref_estadocb21 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb21 = sharedPref_estadocb21.getInt("estadocb21", 0);

        if (estadocb21 == 0)
            cb21.setChecked(false);
        else
            cb21.setChecked(true);

        cb21.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb21.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb21.setChecked(true);

                            //estadocb21 = 1;
                            SharedPreferences sharedPref_estadocb21 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb21.edit();
                            prefEditor.putInt("estadocb21",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb21.setChecked(false);

                            SharedPreferences sharedPref_estadocb21 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb21.edit();
                            prefEditor.putInt("estadocb21", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 21========================================

        //======================TRATAMENTO DO CHECKBOX 22============================================

        cb22 = (CheckBox) view.findViewById(R.id.cb22);

        SharedPreferences sharedPref_estadocb22 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb22 = sharedPref_estadocb22.getInt("estadocb22", 0);

        if (estadocb22 == 0)
            cb22.setChecked(false);
        else
            cb22.setChecked(true);

        cb22.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb22.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb22.setChecked(true);

                            //estadocb22 = 1;
                            SharedPreferences sharedPref_estadocb22 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb22.edit();
                            prefEditor.putInt("estadocb22",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb22.setChecked(false);

                            SharedPreferences sharedPref_estadocb22 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb22.edit();
                            prefEditor.putInt("estadocb22", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 22========================================

        //======================TRATAMENTO DO CHECKBOX 23===========================================

        cb23 = (CheckBox) view.findViewById(R.id.cb23);

        SharedPreferences sharedPref_estadocb23 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb23 = sharedPref_estadocb23.getInt("estadocb23", 0);

        if (estadocb23 == 0)
            cb23.setChecked(false);
        else
            cb23.setChecked(true);

        cb23.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb23.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb23.setChecked(true);

                            //estadocb23 = 1;
                            SharedPreferences sharedPref_estadocb23 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb23.edit();
                            prefEditor.putInt("estadocb23",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb23.setChecked(false);

                            SharedPreferences sharedPref_estadocb23 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb23.edit();
                            prefEditor.putInt("estadocb23", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 23========================================

        //======================TRATAMENTO DO CHECKBOX 24============================================

        cb24 = (CheckBox) view.findViewById(R.id.cb24);

        SharedPreferences sharedPref_estadocb24 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb24 = sharedPref_estadocb24.getInt("estadocb24", 0);

        if (estadocb24 == 0)
            cb24.setChecked(false);
        else
            cb24.setChecked(true);

        cb24.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb24.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb24.setChecked(true);

                            //estadocb24 = 1;
                            SharedPreferences sharedPref_estadocb24 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb24.edit();
                            prefEditor.putInt("estadocb24",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb24.setChecked(false);

                            SharedPreferences sharedPref_estadocb24 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb24.edit();
                            prefEditor.putInt("estadocb24", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 24========================================

        //======================TRATAMENTO DO CHECKBOX 25============================================

        cb25 = (CheckBox) view.findViewById(R.id.cb25);

        SharedPreferences sharedPref_estadocb25 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb25 = sharedPref_estadocb25.getInt("estadocb25", 0);

        if (estadocb25 == 0)
            cb25.setChecked(false);
        else
            cb25.setChecked(true);

        cb25.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb25.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb25.setChecked(true);

                            //estadocb2 = 1;
                            SharedPreferences sharedPref_estadocb25 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb25.edit();
                            prefEditor.putInt("estadocb25",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb25.setChecked(false);

                            SharedPreferences sharedPref_estadocb25 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb25.edit();
                            prefEditor.putInt("estadocb25", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 25========================================

        //======================TRATAMENTO DO CHECKBOX 26============================================

        cb26 = (CheckBox) view.findViewById(R.id.cb26);

        SharedPreferences sharedPref_estadocb26 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb26 = sharedPref_estadocb26.getInt("estadocb26", 0);

        if (estadocb26 == 0)
            cb26.setChecked(false);
        else
            cb26.setChecked(true);

        cb26.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb26.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb26.setChecked(true);

                            //estadocb26 = 1;
                            SharedPreferences sharedPref_estadocb26 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb26.edit();
                            prefEditor.putInt("estadocb26",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb26.setChecked(false);

                            SharedPreferences sharedPref_estadocb26 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb26.edit();
                            prefEditor.putInt("estadocb26", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 26========================================

        //======================TRATAMENTO DO CHECKBOX 27============================================

        cb27 = (CheckBox) view.findViewById(R.id.cb27);

        SharedPreferences sharedPref_estadocb27 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb27 = sharedPref_estadocb27.getInt("estadocb27", 0);

        if (estadocb27 == 0)
            cb27.setChecked(false);
        else
            cb27.setChecked(true);

        cb27.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb27.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb27.setChecked(true);

                            //estadocb27 = 1;
                            SharedPreferences sharedPref_estadocb27 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb27.edit();
                            prefEditor.putInt("estadocb27",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb27.setChecked(false);

                            SharedPreferences sharedPref_estadocb27 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb27.edit();
                            prefEditor.putInt("estadocb27", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 27========================================

        //======================TRATAMENTO DO CHECKBOX 28============================================

        cb28 = (CheckBox) view.findViewById(R.id.cb28);

        SharedPreferences sharedPref_estadocb28 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb28 = sharedPref_estadocb28.getInt("estadocb28", 0);

        if (estadocb28 == 0)
            cb28.setChecked(false);
        else
            cb28.setChecked(true);

        cb28.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb28.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb28.setChecked(true);

                            //estadocb28 = 1;
                            SharedPreferences sharedPref_estadocb28 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb28.edit();
                            prefEditor.putInt("estadocb28",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb28.setChecked(false);

                            SharedPreferences sharedPref_estadocb28 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb28.edit();
                            prefEditor.putInt("estadocb28", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 28========================================

        //======================TRATAMENTO DO CHECKBOX 29============================================

        cb29 = (CheckBox) view.findViewById(R.id.cb29);

        SharedPreferences sharedPref_estadocb29 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb29 = sharedPref_estadocb29.getInt("estadocb29", 0);

        if (estadocb29 == 0)
            cb29.setChecked(false);
        else
            cb29.setChecked(true);

        cb29.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb29.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb29.setChecked(true);

                            //estadocb29 = 1;
                            SharedPreferences sharedPref_estadocb29 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb29.edit();
                            prefEditor.putInt("estadocb29",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb29.setChecked(false);

                            SharedPreferences sharedPref_estadocb29 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb29.edit();
                            prefEditor.putInt("estadocb29", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 29========================================

        //======================TRATAMENTO DO CHECKBOX 30============================================

        cb30 = (CheckBox) view.findViewById(R.id.cb30);

        SharedPreferences sharedPref_estadocb30 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb30 = sharedPref_estadocb30.getInt("estadocb30", 0);

        if (estadocb30 == 0)
            cb30.setChecked(false);
        else
            cb30.setChecked(true);

        cb30.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb30.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb30.setChecked(true);

                            //estadocb30 = 1;
                            SharedPreferences sharedPref_estadocb30 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb30.edit();
                            prefEditor.putInt("estadocb30",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb30.setChecked(false);

                            SharedPreferences sharedPref_estadocb30 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb30.edit();
                            prefEditor.putInt("estadocb30", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 30========================================

        //======================TRATAMENTO DO CHECKBOX 31============================================

        cb31 = (CheckBox) view.findViewById(R.id.cb31);

        SharedPreferences sharedPref_estadocb31 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb31 = sharedPref_estadocb31.getInt("estadocb31", 0);

        if (estadocb31 == 0)
            cb31.setChecked(false);
        else
            cb31.setChecked(true);

        cb31.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb31.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb31.setChecked(true);

                            //estadocb31 = 1;
                            SharedPreferences sharedPref_estadocb31 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb31.edit();
                            prefEditor.putInt("estadocb31",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb31.setChecked(false);

                            SharedPreferences sharedPref_estadocb31 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb31.edit();
                            prefEditor.putInt("estadocb31", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 31========================================

        //======================TRATAMENTO DO CHECKBOX 32============================================

        cb32 = (CheckBox) view.findViewById(R.id.cb32);

        SharedPreferences sharedPref_estadocb32 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb32 = sharedPref_estadocb32.getInt("estadocb32", 0);

        if (estadocb32 == 0)
            cb32.setChecked(false);
        else
            cb32.setChecked(true);

        cb32.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb32.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb32.setChecked(true);

                            //estadocb32 = 1;
                            SharedPreferences sharedPref_estadocb32 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb32.edit();
                            prefEditor.putInt("estadocb32",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb32.setChecked(false);

                            SharedPreferences sharedPref_estadocb32 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb32.edit();
                            prefEditor.putInt("estadocb32", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 32========================================

        //======================TRATAMENTO DO CHECKBOX 33============================================

        cb33 = (CheckBox) view.findViewById(R.id.cb33);

        SharedPreferences sharedPref_estadocb33 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb33 = sharedPref_estadocb33.getInt("estadocb33", 0);

        if (estadocb33 == 0)
            cb33.setChecked(false);
        else
            cb33.setChecked(true);

        cb33.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb33.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb33.setChecked(true);

                            //estadocb33 = 1;
                            SharedPreferences sharedPref_estadocb33 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb33.edit();
                            prefEditor.putInt("estadocb33",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb33.setChecked(false);

                            SharedPreferences sharedPref_estadocb33 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb33.edit();
                            prefEditor.putInt("estadocb33", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 33========================================

        //======================TRATAMENTO DO CHECKBOX 34============================================

        cb34 = (CheckBox) view.findViewById(R.id.cb34);

        SharedPreferences sharedPref_estadocb34 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb34 = sharedPref_estadocb34.getInt("estadocb34", 0);

        if (estadocb34 == 0)
            cb34.setChecked(false);
        else
            cb34.setChecked(true);

        cb34.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb34.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb34.setChecked(true);

                            //estadocb34 = 1;
                            SharedPreferences sharedPref_estadocb34 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb34.edit();
                            prefEditor.putInt("estadocb34",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb34.setChecked(false);

                            SharedPreferences sharedPref_estadocb34 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb34.edit();
                            prefEditor.putInt("estadocb34", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 34========================================

        //======================TRATAMENTO DO CHECKBOX 35============================================

        cb35 = (CheckBox) view.findViewById(R.id.cb35);

        SharedPreferences sharedPref_estadocb35 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb35 = sharedPref_estadocb35.getInt("estadocb35", 0);

        if (estadocb35 == 0)
            cb35.setChecked(false);
        else
            cb3.setChecked(true);

        cb35.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb35.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb35.setChecked(true);

                            //estadocb35 = 1;
                            SharedPreferences sharedPref_estadocb35 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb35.edit();
                            prefEditor.putInt("estadocb35",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb35.setChecked(false);

                            SharedPreferences sharedPref_estadocb35 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb35.edit();
                            prefEditor.putInt("estadocb35", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 35========================================

        //======================TRATAMENTO DO CHECKBOX 36============================================

        cb36 = (CheckBox) view.findViewById(R.id.cb36);

        SharedPreferences sharedPref_estadocb36 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb36 = sharedPref_estadocb36.getInt("estadocb36", 0);

        if (estadocb36 == 0)
            cb36.setChecked(false);
        else
            cb36.setChecked(true);

        cb36.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb36.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb36.setChecked(true);

                            //estadocb36 = 1;
                            SharedPreferences sharedPref_estadocb36 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb36.edit();
                            prefEditor.putInt("estadocb36",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb36.setChecked(false);

                            SharedPreferences sharedPref_estadocb36 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb36.edit();
                            prefEditor.putInt("estadocb36", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 36========================================

        //======================TRATAMENTO DO CHECKBOX 37============================================

        cb37 = (CheckBox) view.findViewById(R.id.cb37);

        SharedPreferences sharedPref_estadocb37 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb37 = sharedPref_estadocb37.getInt("estadocb37", 0);

        if (estadocb37 == 0)
            cb37.setChecked(false);
        else
            cb37.setChecked(true);

        cb37.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb37.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb37.setChecked(true);

                            //estadocb37 = 1;
                            SharedPreferences sharedPref_estadocb37 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb37.edit();
                            prefEditor.putInt("estadocb37",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb37.setChecked(false);

                            SharedPreferences sharedPref_estadocb37 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb37.edit();
                            prefEditor.putInt("estadocb37", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 37========================================

        //======================TRATAMENTO DO CHECKBOX 38============================================

        cb38 = (CheckBox) view.findViewById(R.id.cb38);

        SharedPreferences sharedPref_estadocb38 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb38 = sharedPref_estadocb38.getInt("estadocb38", 0);

        if (estadocb38 == 0)
            cb38.setChecked(false);
        else
            cb38.setChecked(true);

        cb38.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb38.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb38.setChecked(true);

                            //estadocb38 = 1;
                            SharedPreferences sharedPref_estadocb38 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb38.edit();
                            prefEditor.putInt("estadocb38",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb38.setChecked(false);

                            SharedPreferences sharedPref_estadocb38 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb38.edit();
                            prefEditor.putInt("estadocb38", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 38========================================

        //======================TRATAMENTO DO CHECKBOX 39============================================

        cb39 = (CheckBox) view.findViewById(R.id.cb39);

        SharedPreferences sharedPref_estadocb39 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb39 = sharedPref_estadocb39.getInt("estadocb39", 0);

        if (estadocb39 == 0)
            cb39.setChecked(false);
        else
            cb39.setChecked(true);

        cb39.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb39.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb39.setChecked(true);

                            //estadocb39 = 1;
                            SharedPreferences sharedPref_estadocb39 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb39.edit();
                            prefEditor.putInt("estadocb39",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb39.setChecked(false);

                            SharedPreferences sharedPref_estadocb39 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb39.edit();
                            prefEditor.putInt("estadocb39", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 39========================================

        //======================TRATAMENTO DO CHECKBOX 40===========================================

        cb40 = (CheckBox) view.findViewById(R.id.cb40);

        SharedPreferences sharedPref_estadocb40 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb40 = sharedPref_estadocb40.getInt("estadocb40", 0);

        if (estadocb40 == 0)
            cb40.setChecked(false);
        else
            cb40.setChecked(true);

        cb40.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb40.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb40.setChecked(true);

                            //estadocb40 = 1;
                            SharedPreferences sharedPref_estadocb40 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb40.edit();
                            prefEditor.putInt("estadocb40",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb40.setChecked(false);

                            SharedPreferences sharedPref_estadocb40 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb40.edit();
                            prefEditor.putInt("estadocb40", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 40========================================

        //======================TRATAMENTO DO CHECKBOX 41===========================================

        cb41 = (CheckBox) view.findViewById(R.id.cb41);

        SharedPreferences sharedPref_estadocb41 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb41 = sharedPref_estadocb41.getInt("estadocb41", 0);

        if (estadocb41 == 0)
            cb41.setChecked(false);
        else
            cb41.setChecked(true);

        cb41.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb41.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb41.setChecked(true);

                            //estadocb41 = 1;
                            SharedPreferences sharedPref_estadocb41 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb41.edit();
                            prefEditor.putInt("estadocb41",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb41.setChecked(false);

                            SharedPreferences sharedPref_estadocb41 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb41.edit();
                            prefEditor.putInt("estadocb41", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 41========================================

        //======================TRATAMENTO DO CHECKBOX 42===========================================

        cb42 = (CheckBox) view.findViewById(R.id.cb42);

        SharedPreferences sharedPref_estadocb42 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb42 = sharedPref_estadocb42.getInt("estadocb42", 0);

        if (estadocb42 == 0)
            cb42.setChecked(false);
        else
            cb42.setChecked(true);

        cb42.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb42.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb42.setChecked(true);

                            //estadocb42 = 1;
                            SharedPreferences sharedPref_estadocb42 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb42.edit();
                            prefEditor.putInt("estadocb42",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb42.setChecked(false);

                            SharedPreferences sharedPref_estadocb42 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb42.edit();
                            prefEditor.putInt("estadocb42", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 42========================================

        //======================TRATAMENTO DO CHECKBOX 43===========================================

        cb43 = (CheckBox) view.findViewById(R.id.cb43);

        SharedPreferences sharedPref_estadocb43 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb43 = sharedPref_estadocb43.getInt("estadocb43", 0);

        if (estadocb43 == 0)
            cb43.setChecked(false);
        else
            cb43.setChecked(true);

        cb43.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb43.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb43.setChecked(true);

                            //estadocb43 = 1;
                            SharedPreferences sharedPref_estadocb43 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb43.edit();
                            prefEditor.putInt("estadocb43",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb43.setChecked(false);

                            SharedPreferences sharedPref_estadocb43 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb43.edit();
                            prefEditor.putInt("estadocb43", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 43========================================

        //======================TRATAMENTO DO CHECKBOX 44===========================================

        cb44 = (CheckBox) view.findViewById(R.id.cb44);

        SharedPreferences sharedPref_estadocb44 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb44 = sharedPref_estadocb44.getInt("estadocb44", 0);

        if (estadocb44 == 0)
            cb44.setChecked(false);
        else
            cb44.setChecked(true);

        cb44.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb44.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb44.setChecked(true);

                            //estadocb44 = 1;
                            SharedPreferences sharedPref_estadocb44 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb44.edit();
                            prefEditor.putInt("estadocb44",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb44.setChecked(false);

                            SharedPreferences sharedPref_estadocb44 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb44.edit();
                            prefEditor.putInt("estadocb44", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 44========================================

        //======================TRATAMENTO DO CHECKBOX 45===========================================

        cb45 = (CheckBox) view.findViewById(R.id.cb45);

        SharedPreferences sharedPref_estadocb45 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb45 = sharedPref_estadocb45.getInt("estadocb45", 0);

        if (estadocb45 == 0)
            cb45.setChecked(false);
        else
            cb45.setChecked(true);

        cb45.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb45.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb45.setChecked(true);

                            //estadocb45 = 1;
                            SharedPreferences sharedPref_estadocb45 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb45.edit();
                            prefEditor.putInt("estadocb45",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb45.setChecked(false);

                            SharedPreferences sharedPref_estadocb45 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb45.edit();
                            prefEditor.putInt("estadocb45", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 45========================================

        //======================TRATAMENTO DO CHECKBOX 46===========================================

        cb46 = (CheckBox) view.findViewById(R.id.cb46);

        SharedPreferences sharedPref_estadocb46 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb46 = sharedPref_estadocb46.getInt("estadocb46", 0);

        if (estadocb46 == 0)
            cb46.setChecked(false);
        else
            cb46.setChecked(true);

        cb46.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb46.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb46.setChecked(true);

                            //estadocb46 = 1;
                            SharedPreferences sharedPref_estadocb46 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb46.edit();
                            prefEditor.putInt("estadocb46",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb46.setChecked(false);

                            SharedPreferences sharedPref_estadocb46 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb46.edit();
                            prefEditor.putInt("estadocb46", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 46========================================

        //======================TRATAMENTO DO CHECKBOX 47===========================================

        cb47 = (CheckBox) view.findViewById(R.id.cb47);

        SharedPreferences sharedPref_estadocb47 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb47 = sharedPref_estadocb47.getInt("estadocb47", 0);

        if (estadocb47 == 0)
            cb47.setChecked(false);
        else
            cb47.setChecked(true);

        cb47.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb47.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb47.setChecked(true);

                            //estadocb47 = 1;
                            SharedPreferences sharedPref_estadocb47 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb47.edit();
                            prefEditor.putInt("estadocb47",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb47.setChecked(false);

                            SharedPreferences sharedPref_estadocb47 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb47.edit();
                            prefEditor.putInt("estadocb47", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 47========================================

        //======================TRATAMENTO DO CHECKBOX 48===========================================

        cb48 = (CheckBox) view.findViewById(R.id.cb48);

        SharedPreferences sharedPref_estadocb48 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb48 = sharedPref_estadocb48.getInt("estadocb48", 0);

        if (estadocb48 == 0)
            cb48.setChecked(false);
        else
            cb48.setChecked(true);

        cb48.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb48.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb48.setChecked(true);

                            //estadocb48 = 1;
                            SharedPreferences sharedPref_estadocb48 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb48.edit();
                            prefEditor.putInt("estadocb48",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb48.setChecked(false);

                            SharedPreferences sharedPref_estadocb48 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb48.edit();
                            prefEditor.putInt("estadocb48", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 48========================================

        //======================TRATAMENTO DO CHECKBOX 49===========================================

        cb49 = (CheckBox) view.findViewById(R.id.cb49);

        SharedPreferences sharedPref_estadocb49 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb49 = sharedPref_estadocb49.getInt("estadocb49", 0);

        if (estadocb49 == 0)
            cb49.setChecked(false);
        else
            cb49.setChecked(true);

        cb49.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb49.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb49.setChecked(true);

                            //estadocb49 = 1;
                            SharedPreferences sharedPref_estadocb49 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb49.edit();
                            prefEditor.putInt("estadocb49",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb49.setChecked(false);

                            SharedPreferences sharedPref_estadocb49 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb49.edit();
                            prefEditor.putInt("estadocb49", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 49========================================

        //======================TRATAMENTO DO CHECKBOX 50============================================

        cb50 = (CheckBox) view.findViewById(R.id.cb50);

        SharedPreferences sharedPref_estadocb50 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb50 = sharedPref_estadocb50.getInt("estadocb50", 0);

        if (estadocb50 == 0)
            cb50.setChecked(false);
        else
            cb50.setChecked(true);

        cb50.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb50.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb50.setChecked(true);

                            //estadocb50 = 1;
                            SharedPreferences sharedPref_estadocb50 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb50.edit();
                            prefEditor.putInt("estadocb50",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb50.setChecked(false);

                            SharedPreferences sharedPref_estadocb50 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb50.edit();
                            prefEditor.putInt("estadocb50", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 50=========================================

        //======================TRATAMENTO DO CHECKBOX 51============================================

        cb51 = (CheckBox) view.findViewById(R.id.cb51);

        SharedPreferences sharedPref_estadocb51 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb51 = sharedPref_estadocb51.getInt("estadocb51", 0);

        if (estadocb51 == 0)
            cb51.setChecked(false);
        else
            cb51.setChecked(true);

        cb51.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb51.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb51.setChecked(true);

                            //estadocb51 = 1;
                            SharedPreferences sharedPref_estadocb51 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb51.edit();
                            prefEditor.putInt("estadocb51",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb51.setChecked(false);

                            SharedPreferences sharedPref_estadocb51 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb51.edit();
                            prefEditor.putInt("estadocb51", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 51=========================================

        //======================TRATAMENTO DO CHECKBOX 52============================================

        cb52 = (CheckBox) view.findViewById(R.id.cb52);

        SharedPreferences sharedPref_estadocb52 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb52 = sharedPref_estadocb52.getInt("estadocb52", 0);

        if (estadocb52 == 0)
            cb52.setChecked(false);
        else
            cb52.setChecked(true);

        cb52.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb52.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb52.setChecked(true);

                            //estadocb52 = 1;
                            SharedPreferences sharedPref_estadocb52 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb52.edit();
                            prefEditor.putInt("estadocb52",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb52.setChecked(false);

                            SharedPreferences sharedPref_estadocb52 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb52.edit();
                            prefEditor.putInt("estadocb52", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 52========================================

        //======================TRATAMENTO DO CHECKBOX 53============================================

        cb53 = (CheckBox) view.findViewById(R.id.cb53);

        SharedPreferences sharedPref_estadocb53 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb53 = sharedPref_estadocb53.getInt("estadocb53", 0);

        if (estadocb53 == 0)
            cb53.setChecked(false);
        else
            cb53.setChecked(true);

        cb53.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb53.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb53.setChecked(true);

                            //estadocb53 = 1;
                            SharedPreferences sharedPref_estadocb53 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb53.edit();
                            prefEditor.putInt("estadocb53",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb53.setChecked(false);

                            SharedPreferences sharedPref_estadocb53 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb53.edit();
                            prefEditor.putInt("estadocb53", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 53========================================

        //======================TRATAMENTO DO CHECKBOX 54============================================

        cb54 = (CheckBox) view.findViewById(R.id.cb54);

        SharedPreferences sharedPref_estadocb54 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb54 = sharedPref_estadocb54.getInt("estadocb54", 0);

        if (estadocb54 == 0)
            cb54.setChecked(false);
        else
            cb54.setChecked(true);

        cb54.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb54.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb54.setChecked(true);

                            //estadocb54 = 1;
                            SharedPreferences sharedPref_estadocb54 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb54.edit();
                            prefEditor.putInt("estadocb54",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb54.setChecked(false);

                            SharedPreferences sharedPref_estadocb54 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb54.edit();
                            prefEditor.putInt("estadocb54", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 54========================================

        //======================TRATAMENTO DO CHECKBOX 55============================================

        cb55 = (CheckBox) view.findViewById(R.id.cb55);

        SharedPreferences sharedPref_estadocb55 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb55 = sharedPref_estadocb55.getInt("estadocb55", 0);

        if (estadocb55 == 0)
            cb55.setChecked(false);
        else
            cb55.setChecked(true);

        cb55.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb55.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb55.setChecked(true);

                            //estadocb55 = 1;
                            SharedPreferences sharedPref_estadocb55 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb55.edit();
                            prefEditor.putInt("estadocb55",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb55.setChecked(false);

                            SharedPreferences sharedPref_estadocb55 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb55.edit();
                            prefEditor.putInt("estadocb55", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 55========================================

        //======================TRATAMENTO DO CHECKBOX 56============================================

        cb56 = (CheckBox) view.findViewById(R.id.cb56);

        SharedPreferences sharedPref_estadocb56 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb56 = sharedPref_estadocb56.getInt("estadocb56", 0);

        if (estadocb56 == 0)
            cb56.setChecked(false);
        else
            cb56.setChecked(true);

        cb56.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb56.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb56.setChecked(true);

                            //estadocb56 = 1;
                            SharedPreferences sharedPref_estadocb56 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb56.edit();
                            prefEditor.putInt("estadocb56",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb56.setChecked(false);

                            SharedPreferences sharedPref_estadocb56 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb56.edit();
                            prefEditor.putInt("estadocb56", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 56========================================

        //======================TRATAMENTO DO CHECKBOX 57============================================

        cb57 = (CheckBox) view.findViewById(R.id.cb57);

        SharedPreferences sharedPref_estadocb57 = this.getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", Context.MODE_PRIVATE);
        estadocb57 = sharedPref_estadocb57.getInt("estadocb57", 0);

        if (estadocb57 == 0)
            cb57.setChecked(false);
        else
            cb57.setChecked(true);

        cb57.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (cb57.isChecked()){
                    String mensagem_marcar = getString(R.string.confirmacao_marcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_marcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb57.setChecked(true);

                            //estadocb57 = 1;
                            SharedPreferences sharedPref_estadocb57 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo",0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb57.edit();
                            prefEditor.putInt("estadocb57",1);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    String mensagem_desmarcar = getString(R.string.confirmacao_desmarcar);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(mensagem_desmarcar);
                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(getActivity(), Main_activity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            cb57.setChecked(false);

                            SharedPreferences sharedPref_estadocb57 = getActivity().getSharedPreferences("pref_checkbox_matematica_setimo", 0);
                            SharedPreferences.Editor prefEditor = sharedPref_estadocb57.edit();
                            prefEditor.putInt("estadocb57", 0);
                            prefEditor.commit();

                            Toast.makeText(getActivity().getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.show();
                }
            }
        });
        //===================================FIM CHECKBOX 57========================================



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