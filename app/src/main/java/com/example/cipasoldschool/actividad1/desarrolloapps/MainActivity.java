package com.example.cipasoldschool.actividad1.desarrolloapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cipasoldschool.actividad1.desarrolloapps.controller.SalaryController;
import com.example.cipasoldschool.actividad1.desarrolloapps.model.Salary;

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

    //This method calculates the month payment of an employee
    public void calculateMonthPayment(View view){
        Salary salary = new Salary();
        salary.setBaseSalary(Double.parseDouble(baseSalary.getText().toString()));
        salary.setExtraHours(Integer.parseInt(extraHours.getText().toString()));
        boolean bonusFromCheckBox = bonus.isChecked();
        if (bonusFromCheckBox){
            salary.setBonus(1);
        }
        String totalSalary = SalaryController.calculateTotalSalary(salary);

        result.setText(totalSalary);

    }
}