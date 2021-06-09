package com.pacheco.energymaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Calculadora extends AppCompatActivity {
    TextView estado,txtkw;
    Spinner comboelectrodomestico, combotiempo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        estado = findViewById(R.id.resultadocalculado);
        txtkw = findViewById(R.id.txtresultadocalculado);

        comboelectrodomestico = findViewById(R.id.spinerelectrodomestico);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.combo_electrodomestico, android.R.layout.simple_expandable_list_item_1);
        comboelectrodomestico.setAdapter(adapter);
        comboelectrodomestico.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        combotiempo = findViewById(R.id.spinertiempo);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.opctiempo, android.R.layout.simple_list_item_1);
        combotiempo.setAdapter(adapter1);
        combotiempo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void Calcularprom(View view) {
        int tiempo = combotiempo.getSelectedItemPosition();
        int electro = comboelectrodomestico.getSelectedItemPosition();

        if (tiempo == 1) {
            if (electro == 1) {
                estado.setText("LA NEVERA CONSUME CADA HORA:0,35 KW/H");
                txtkw.setText("VA A CONSUMIR 21KW APROXIMADAMENTE EN EL MES");
            }else {
                if (electro == 2) {
                    estado.setText("EL AIRE ACONDICIONADO CONSUME:1.8KW/H ");
                    txtkw.setText("CON ESE PROMEDIO EN EL MES CONSUMIRA 108KW APROXIMADAMENTE");
                } else {
                    if (electro == 3) {
                        estado.setText("EL MICROHONDA CONSUME: 1,2KW/H");
                        txtkw.setText("EL USO DEL MICROHONDA PUEDE GENERAR UN CONSUMO DE 72KH EN EL MES");
                    } else {
                        if (electro == 4) {
                            estado.setText("UN ABANICO CONSUME 0,5KH/H");
                            txtkw.setText("EL CONSUMO MENSUAL SERA DE 30KW APROX.");
                        }
                    }
                }
            }
            }else {
            if (tiempo == 2) {
                if (electro == 1) {
                    estado.setText("LA NEVERA CONSUME CADA HORA:0,35 KW/H");
                    txtkw.setText("VA A CONSUMIR 52,5KW APROXIMADAMENTE EN EL MES");
                }else {
                    if (electro == 2) {
                        estado.setText("EL AIRE ACONDICIONADO CONSUME:1.8KW/H ");
                        txtkw.setText("CON ESE PROMEDIO EN EL MES CONSUMIRA 270KW APROXIMADAMENTE");
                    } else {
                        if (electro == 3) {
                            estado.setText("EL MICROHONDA CONSUME: 1,2KW/H");
                            txtkw.setText("EL USO DEL MICROHONDA PUEDE GENERAR UN CONSUMO DE 180KH EN EL MES");
                        } else {
                            if (electro == 4) {
                                estado.setText("UN ABANICO CONSUME 0,5KW/H");
                                txtkw.setText("EL CONSUMO MENSUAL SERA DE 75KW APROX.");
                            }
                        }
                    }
                }

            } else {
                if (tiempo == 3) {
                    if (electro == 1) {
                        estado.setText("LA NEVERA CONSUME CADA HORA:0,35 KW/H");
                        txtkw.setText("VA A CONSUMIR 84KW APROXIMADAMENTE EN EL MES");
                    }else {
                        if (electro == 2) {
                            estado.setText("EL AIRE ACONDICIONADO CONSUME:1.8KW/H ");
                            txtkw.setText("CON ESE PROMEDIO EN EL MES CONSUMIRA 432KW APROXIMADAMENTE");
                        } else {
                            if (electro == 3) {
                                estado.setText("EL MICROHONDA CONSUME: 1,2KW/H");
                                txtkw.setText("EL USO DEL MICROHONDA PUEDE GENERAR UN CONSUMO DE 288KH EN EL MES");
                            } else {
                                if (electro == 4) {
                                    estado.setText("UN ABANICO CONSUME 0,5KW/H");
                                    txtkw.setText("EL CONSUMO MENSUAL SERA DE 30KW APROX.");
                                }
                            }
                        }
                    }                } else {
                    if (tiempo == 4) {
                        if (electro == 1) {
                            estado.setText("LA NEVERA CONSUME CADA HORA:0,35 KW/H");
                            txtkw.setText("VA A CONSUMIR 105KW APROXIMADAMENTE EN EL MES");
                        }else {
                            if (electro == 2) {
                                estado.setText("EL AIRE ACONDICIONADO CONSUME:1.8KW/H ");
                                txtkw.setText("CON ESE PROMEDIO EN EL MES CONSUMIRA 540KW APROXIMADAMENTE");
                            } else {
                                if (electro == 3) {
                                    estado.setText("EL MICROHONDA CONSUME: 1,2KW/H");
                                    txtkw.setText("EL USO DEL MICROHONDA PUEDE GENERAR UN CONSUMO DE 360KH EN EL MES");
                                } else {
                                    if (electro == 4) {
                                        estado.setText("UN ABANICO CONSUME 0,5KW/H");
                                        txtkw.setText("EL CONSUMO MENSUAL SERA DE 30KW APROX.");
                                    }
                                }
                            }
                        }                    }
                }
            }
        }
    }
}
