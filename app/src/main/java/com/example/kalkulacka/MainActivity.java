package com.example.kalkulacka;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText input1, input2;
    private Spinner operationSpinner;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        operationSpinner = findViewById(R.id.operationSpinner);
        result = findViewById(R.id.result);
        Button calculateButton = findViewById(R.id.calculateButton);

        // Načtení operací ze strings.xml
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.operations, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        operationSpinner.setAdapter(adapter);

        calculateButton.setOnClickListener(v -> calculate());
    }
   private void calculate() {
            String op = operationSpinner.getSelectedItem().toString();

                try {
                            double num1 = Double.parseDouble(input1.getText().toString());
                                    double num2 = 0;
                                            if (!op.equals("!")) {
                                                            num2 = Double.parseDouble(input2.getText().toString());
                                                                    }
                                                    double output = 0;

                                                    if (op.equals("+")) {
                                                                    output = num1 + num2;
                                                                            } else if (op.equals("-")) {
                                                                    output = num1 - num2;
                                                                            } else if (op.equals("*")) {
                                                                    output = num1 * num2;
                                                                            } else if (op.equals("/")) {
                                                                    if (num2 == 0) {
                                                                                        result.setText("Chyba: dělení nulou");
                                                                                                        return;
                                                                                                                    }
                                                                                output = num1 / num2;
                                                                            } else if (op.equals("%")) {
                                                                    if (num2 == 0) {
                                                                                        result.setText("Chyba: modulo nulou");
                                                                                                        return;
                                                                                                                    }
                                                                                output = num1 % num2;
                                                                            } else if (op.equals("^")) {
                                                                    output = Math.pow(num1, num2);
                                                                            } else if (op.equals("√")) {
                                                                    if (num1 < 0) {
                                                                                        result.setText("Chyba: záporné číslo pod odmocninou");
                                                                                                        return;
                                                                                                                    }
                                                                                output = Math.pow(num1, 1.0 / num2);
                                                                            } else if (op.equals("!")) {
                                                                    if (num1 < 0 || num1 != (int) num1) {
                                                                                        result.setText("Chyba: faktoriál jen pro nezáporná celá čísla");
                                                                                                        return;
                                                                                                                    }
                                                                                output = factorial((int) num1);
                                                                            }

                                                            result.setText("Výsledek: " + output);
                                                        } catch (Exception e) {
                            result.setText("Chybný vstup");
                                }
                }

                // Samostatná metoda pro faktoriál
    private int factorial(int n) {
            int fact = 1;
                for (int i = 1; i <= n; i++) {
                            fact *= i;
                                }
                    return fact;
                }

                                                                    }





