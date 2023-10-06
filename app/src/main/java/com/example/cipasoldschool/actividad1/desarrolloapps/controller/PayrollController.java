package com.example.cipasoldschool.actividad1.desarrolloapps.controller;

import android.annotation.SuppressLint;

import com.example.cipasoldschool.actividad1.desarrolloapps.model.Payroll;
import com.example.cipasoldschool.actividad1.desarrolloapps.util.Constants;

public class PayrollController {

    @SuppressLint("DefaultLocale")
    public static String calculateTotalSalary(Payroll payroll){
        double totalSalaryBeforeDeductions = calculateTotalSalaryBeforeDeductions(payroll);
        double deductions = calculateDeductions(totalSalaryBeforeDeductions);
        return  String.format("%.2f",totalSalaryBeforeDeductions - deductions);
    }
    private static double getValuePerHour(Payroll payroll){
        return payroll.getBaseSalary()/ Constants.WORKING_HOURS_PER_WEEK;
    }

    private static double getValuePerExtraHour(double valuePerHour){
        return valuePerHour + valuePerHour * Constants.PERCENTAGE_VALUE_EXTRA_HOUR;
    }
    private static double getValuePerBonus(Payroll payroll){
        return payroll.getBaseSalary() * Constants.PERCENTAGE_VALUE_BONUS;
    }
    private static double calculateTotalSalaryBeforeDeductions(Payroll payroll){
        double extraHoursValue = payroll.getExtraHours() * getValuePerExtraHour(getValuePerHour(payroll));
        double bonus = payroll.getBonus() * getValuePerBonus(payroll);
        return payroll.getBaseSalary() + extraHoursValue + bonus;
    }
    private static double getHealthDeduction(double totalSalaryBeforeDeductions){
        return totalSalaryBeforeDeductions * Constants.PERCENTAGE_VALUE_HEALTH_DEDUCTION;
    }
    private static double getRetirementDeduction(double totalSalaryBeforeDeductions){
        return totalSalaryBeforeDeductions * Constants.PERCENTAGE_VALUE_RETIREMENT_DEDUCTION;
    }
    private static double getCompensationDeduction(double totalSalaryBeforeDeductions){
        return totalSalaryBeforeDeductions * Constants.PERCENTAGE_VALUE_COMPENSATION_FUND_DEDUCTION;
    }
    private static double calculateDeductions(double totalSalaryBeforeDeductions){
        return getHealthDeduction(totalSalaryBeforeDeductions) +
                getRetirementDeduction(totalSalaryBeforeDeductions) +
                getCompensationDeduction(totalSalaryBeforeDeductions);
    }
}
