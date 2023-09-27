package com.example.cipasoldschool.actividad1.desarrolloapps.controller;

import android.annotation.SuppressLint;

import com.example.cipasoldschool.actividad1.desarrolloapps.model.Salary;
import com.example.cipasoldschool.actividad1.desarrolloapps.util.Constants;

public class SalaryController {

    @SuppressLint("DefaultLocale")
    public static String calculateTotalSalary(Salary salary){
        double totalSalaryBeforeDeductions = calculateTotalSalaryBeforeDeductions(salary);
        double deductions = calculateDeductions(totalSalaryBeforeDeductions);
        return  String.format("%.2f",totalSalaryBeforeDeductions - deductions);
    }
    private static double getValuePerHour(Salary salary){
        return salary.getBaseSalary()/ Constants.WORKING_HOURS_PER_WEEK;
    }

    private static double getValuePerExtraHour(double valuePerHour){
        return valuePerHour + valuePerHour * Constants.PERCENTAGE_VALUE_EXTRA_HOUR;
    }
    private static double getValuePerBonus(Salary salary){
        return salary.getBaseSalary() * Constants.PERCENTAGE_VALUE_BONUS;
    }
    private static double calculateTotalSalaryBeforeDeductions(Salary salary){
        double extraHoursValue = salary.getExtraHours() * getValuePerExtraHour(getValuePerHour(salary));
        double bonus = salary.getBonus() * getValuePerBonus(salary);
        return salary.getBaseSalary() + extraHoursValue + bonus;
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
