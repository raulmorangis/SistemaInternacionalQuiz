package com.example.android.sistemainternacionalquiz;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static com.example.android.sistemainternacionalquiz.R.id.kilometroRB;
import static com.example.android.sistemainternacionalquiz.R.id.masaField;
import static com.example.android.sistemainternacionalquiz.R.id.metroField;
import static com.example.android.sistemainternacionalquiz.R.id.segundoField;

public class MainActivity extends AppCompatActivity {

    int resultado = 0;
    boolean birmania = false;
    boolean reinoUnido = false;
    boolean liberia = false;
    boolean estadosUnidos = false;
    boolean canada = false;
    private RadioButton kilometro;
    private RadioButton imagenSi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }


    /**
     * Este método obtiene las respuestas correctas de la primera pregunta
     *
     * @param view
     */
    public int primeraPregunta(int view) {
        //Comprobar que está marcando la casilla Birmania - 1 pregunta
        CheckBox birmaniaCheckBox = (CheckBox) findViewById(R.id.birmania);
        boolean birmania = birmaniaCheckBox.isChecked();

        //Comprobar que está marcando la casilla Reino Unido - 1 pregunta
        CheckBox reinoUnidoCheckBox = (CheckBox) findViewById(R.id.reinoUnido);
        boolean reinoUnido = reinoUnidoCheckBox.isChecked();

        //Comprobar que está marcando la casilla Liberia - 1 pregunta
        CheckBox liberiaCheckBox = (CheckBox) findViewById(R.id.liberia);
        boolean liberia = liberiaCheckBox.isChecked();

        //Comprobar que está marcando la casilla Estados Unidos - 1 pregunta
        CheckBox estadosUnidosCheckBox = (CheckBox) findViewById(R.id.estadosUnidos);
        boolean estadosUnidos = estadosUnidosCheckBox.isChecked();

        //Comprobar que está marcando la casilla Canada - 1 pregunta
        CheckBox canadaCheckBox = (CheckBox) findViewById(R.id.canada);
        boolean canada = liberiaCheckBox.isChecked();

        int result = 0;

        result = numeroRespuestasPrimera(birmania, liberia, estadosUnidos);

        return result;
    }


    /**
     * Este método calcula las respuestas correctas de la primera pregunta
     *
     * @param addBirmania      suma una respuesta correcta
     * @param addLiberia       suma una respuesta correcta
     * @param addEstadosUnidos suma una respuesta correcta
     * @return respuestasCorrectas el número total de respuestas de la primera pregunta
     */
    private int numeroRespuestasPrimera(boolean addBirmania, boolean addLiberia, boolean addEstadosUnidos) {
        //Respuestas correctas
        int respuestasCorrectasPrimera = 0;

        if (addBirmania) {
            respuestasCorrectasPrimera += 1;
        }
        if (addLiberia) {
            respuestasCorrectasPrimera += 1;
        }
        if (addEstadosUnidos) {
            respuestasCorrectasPrimera += 1;
        }

        return respuestasCorrectasPrimera;
    }


    //Comprobar resultado segunda pregunta
    public int segundaPregunta(int view) {

        int result = 0;

        EditText metroField = (EditText) findViewById(R.id.metroField);
        //   String metro = String.valueOf(metroField.getText().toString());
        if (metroField.getText().toString().equals("metro")) {
            result += 1;
        }
        return result;
    }


    //Comprobar resultado tercera pregunta A
    public int terceraPreguntaA(int view) {

        int result = 0;

        EditText masaField = (EditText) findViewById(R.id.masaField);
        //   String metro = String.valueOf(metroField.getText().toString());
        if (masaField.getText().toString().equals("Masa")) {
            result += 1;
        }

        return result;
    }

    //Comprobar resultado tercera pregunta B
    public int terceraPreguntaB(int view) {

        int result = 0;

        EditText segundoField = (EditText) findViewById(R.id.segundoField);
        //   String metro = String.valueOf(metroField.getText().toString());
        if (segundoField.getText().toString().equals("segundo")) {
            result += 1;
        }

        return result;
    }

    //Comprobar resultado tercera pregunta C
    public int terceraPreguntaC(int view) {

        int result = 0;

        EditText candelaField = (EditText) findViewById(R.id.candelaField);
        //   String metro = String.valueOf(metroField.getText().toString());
        if (candelaField.getText().toString().equals("candela")) {
            result += 1;
        }

        return result;
    }

    //Comprobar resultado cuarta pregunta
    public int cuartaPregunta(int view) {

        int result = 0;

        EditText basicasField = (EditText) findViewById(R.id.basicasField);
        //   String metro = String.valueOf(metroField.getText().toString());
        if (basicasField.getText().toString().equals("básicas")) {
            result += 1;
        }

        return result;
    }

    //Comprobar resultado quinta pregunta
    public int quintaPregunta(int view) {
        int result = 0;

        kilometro = (RadioButton) findViewById(R.id.kilometroRB);

        if (kilometro.isChecked()) {
            result += 1;
        }

        return result;
    }

    //Comprobar resultado sexta pregunta
    public int sextaPregunta(int view) {
        int result = 0;

        imagenSi = (RadioButton) findViewById(R.id.imagenSiRB);

        if (imagenSi.isChecked()) {
            result += 1;
        }

        return result;
    }


    /**
     * Este método es llamado cuando se pulsa el botón Resultado
     */
    public void submit(View view) {

        resultado = primeraPregunta(resultado) + segundaPregunta(resultado) + terceraPreguntaA(resultado) + terceraPreguntaB(resultado) + terceraPreguntaC(resultado) + cuartaPregunta(resultado) + quintaPregunta(resultado) + sextaPregunta(resultado);


        Toast.makeText(this, "Tú resultado es " + Integer.toString(resultado) + "/10", Toast.LENGTH_SHORT).show();

        if (resultado == 10) {
            Toast.makeText(this, "Enhorabuena, eres un genio", Toast.LENGTH_SHORT).show();
        } else if (resultado >= 5) {
            Toast.makeText(this, "No está mal pero repasa un poco", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Estudia más el Sistema internacional de Unidades", Toast.LENGTH_SHORT).show();
        }

    }

}
