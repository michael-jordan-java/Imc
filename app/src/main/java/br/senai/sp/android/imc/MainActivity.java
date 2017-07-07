package br.senai.sp.android.imc;

import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private double altura;
    private double peso;
    private double resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txtResultado = (TextView) findViewById(R.id.txtResultado);
        final ImageView txtImagem = (ImageView) findViewById(R.id.txtImagem);
        final EditText txtAltura = (EditText) findViewById(R.id.txtAltura);
        final EditText txtPeso = (EditText) findViewById(R.id.txtPeso);
        final Button btnCalcular = (Button) findViewById(R.id.btnCalcular);
        Button btnLimpar = (Button) findViewById(R.id.btnLimpar);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtAltura.length() > 0 && txtPeso.length() > 0) {
                    altura = Math.pow(Double.parseDouble(txtAltura.getText().toString()), 2);
                    peso = Double.parseDouble(txtPeso.getText().toString());

                    if (altura > 0 && peso > 0) {
                        resultado = peso / altura;

                        if (resultado <= 18.5) {
                            txtResultado.setText(getString(R.string.abaixo_peso) + String.format(" %.2f", resultado));
                            txtImagem.setImageResource(R.drawable.abaixo_peso);
                            txtAltura.setEnabled(false);
                            txtPeso.setEnabled(false);
                            txtImagem.setVisibility(View.VISIBLE);
                        } else {
                            if (resultado >= 18.6 && resultado <= 24.9) {
                                txtResultado.setText(getString(R.string.saudavel) + String.format(" %.2f", resultado));
                                txtImagem.setImageResource(R.drawable.saudavel);
                                txtAltura.setEnabled(false);
                                txtPeso.setEnabled(false);
                                txtImagem.setVisibility(View.VISIBLE);
                            } else {
                                if (resultado >= 25 && resultado <= 29.9) {
                                    txtResultado.setText(getString(R.string.peso_execesso) + String.format(" %.2f", resultado));
                                    txtImagem.setImageResource(R.drawable.peso_execesso);
                                    txtAltura.setEnabled(false);
                                    txtPeso.setEnabled(false);
                                    txtImagem.setVisibility(View.VISIBLE);
                                } else {
                                    if (resultado >= 30 && resultado <= 34.9) {
                                        txtResultado.setText(getString(R.string.ob_1) + String.format(" %.2f", resultado));
                                        txtImagem.setImageResource(R.drawable.obesidade_grau1);
                                        txtAltura.setEnabled(false);
                                        txtPeso.setEnabled(false);
                                        txtImagem.setVisibility(View.VISIBLE);
                                    } else {
                                        if (resultado >= 35 && resultado <= 39.9) {
                                            txtResultado.setText(getString(R.string.ob_2) + String.format(" %.2f", resultado));
                                            txtImagem.setImageResource(R.drawable.obesidade_grau2);
                                            txtAltura.setEnabled(false);
                                            txtPeso.setEnabled(false);
                                            txtImagem.setVisibility(View.VISIBLE);
                                        } else {
                                            if (resultado >= 40) {
                                                txtResultado.setText(getString(R.string.ob_3) + String.format(" %.2f", resultado));
                                                txtImagem.setImageResource(R.drawable.obesidade_grau3);
                                                txtAltura.setEnabled(false);
                                                txtPeso.setEnabled(false);
                                                txtImagem.setVisibility(View.VISIBLE);
                                            }
                                        }
                                    }
                                }
                            }

                        }

                    } else {
                        Toast.makeText(MainActivity.this, "peso/altura inválidos", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                altura = 0;
                peso = 0;
                resultado = 0;
                txtAltura.setText("");
                txtPeso.setText("");
                txtResultado.setText("");
                txtAltura.setEnabled(true);
                txtPeso.setEnabled(true);
                txtImagem.setVisibility(View.INVISIBLE);
                txtAltura.requestFocus();
            }
        });
    }
}
