package com.example.cipasoldschool.actividad1.desarrolloapps.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cipasoldschool.actividad1.desarrolloapps.R;
import com.example.cipasoldschool.actividad1.desarrolloapps.controller.PayrollController;
import com.example.cipasoldschool.actividad1.desarrolloapps.model.Payroll;

public class MainActivity extends AppCompatActivity {

    private EditText baseSalary;
    private EditText extraHours;
    private CheckBox bonus;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baseSalary = (EditText) findViewById(R.id.baseSalary);
        extraHours = (EditText) findViewById(R.id.extraHours);
        bonus = (CheckBox) findViewById(R.id.bonus);

        result = (TextView) findViewById(R.id.result);

    }

    /**
     * @param view (View)
     * Descripción: Recibe los valores de los componentes.
     * Calcula el pago mensual del empleado y asigna los valores a los componentes correspondientes.
     */
    //This method calculates the month payment of an employee
    public void calculateMonthPayment(View view){
        Payroll payroll = new Payroll();
        payroll.setBaseSalary(Double.parseDouble(baseSalary.getText().toString()));
        payroll.setExtraHours(Integer.parseInt(extraHours.getText().toString()));
        boolean bonusFromCheckBox = bonus.isChecked();
        if (bonusFromCheckBox){
            payroll.setBonus(1);
        }
        String totalSalary = PayrollController.calculateTotalSalary(payroll);

        result.setText(totalSalary);

    }
}