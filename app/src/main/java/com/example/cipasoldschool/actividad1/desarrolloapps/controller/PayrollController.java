package com.example.cipasoldschool.actividad1.desarrolloapps.controller;

import android.annotation.SuppressLint;

import com.example.cipasoldschool.actividad1.desarrolloapps.model.Payroll;
import com.example.cipasoldschool.actividad1.desarrolloapps.util.Constants;

/**
 * @Author CIPAS_OLD_SCHOOL
 * Nombre de clase en español: PayrollController -> Controlador de nómina
 * Descripción: En esta clase se realiza la lógica de cálculo de nómina
 */
public class PayrollController {

    /**
     * @param payroll (Payroll -> Nómina)
     * @return String
     * Descripción: Calcula el total del salario con deducciones aplicadas y lo convierte a String.
     */
    @SuppressLint("DefaultLocale")
    public static String calculateTotalSalary(Payroll payroll){
        double totalSalaryBeforeDeductions = calculateTotalSalaryBeforeDeductions(payroll);
        double deductions = calculateDeductions(totalSalaryBeforeDeductions);
        return  String.format("%.2f",totalSalaryBeforeDeductions - deductions);
    }

    /**
     * @param payroll (Payroll -> Nómina)
     * @return double
     * Descripción: calcula el valor de una hora normal trabajada.
     */
    private static double getValuePerHour(Payroll payroll){
        return payroll.getBaseSalary()/ Constants.WORKING_HOURS_PER_WEEK;
    }

    /**
     * @param valuePerHour (double)
     * @return double
     * Descripcion: calcula el valor de una hora extra trabajada
     */
    private static double getValuePerExtraHour(double valuePerHour){
        return valuePerHour + valuePerHour * Constants.PERCENTAGE_VALUE_EXTRA_HOUR;
    }

    /**
     * @param payroll (Payroll -> Nómina)
     * @return double
     * Descripción: calcula el valor de una bonificación.
     */
    private static double getValuePerBonus(Payroll payroll){
        return payroll.getBaseSalary() * Constants.PERCENTAGE_VALUE_BONUS;
    }

    /**
     * @param payroll (Payroll  -> Nómina)
     * @return double
     * Descripción: calcula el total del salario antes de las deducciones
     */
    private static double calculateTotalSalaryBeforeDeductions(Payroll payroll){
        double extraHoursValue = payroll.getExtraHours() * getValuePerExtraHour(getValuePerHour(payroll));
        double bonus = payroll.getBonus() * getValuePerBonus(payroll);
        return payroll.getBaseSalary() + extraHoursValue + bonus;
    }

    /**
     * @param totalSalaryBeforeDeductions (double)
     * @return double
     * Descripción: calcula el valor de la deducción por pensión del salario total
     * antes de las deducciones
     */
    private static double getHealthDeduction(double totalSalaryBeforeDeductions){
        return totalSalaryBeforeDeductions * Constants.PERCENTAGE_VALUE_HEALTH_DEDUCTION;
    }

    /**
     * @param totalSalaryBeforeDeductions (double)
     * @return double
     * Descripción: calcula el valor de la deducción de pensión del salario total
     * antes de las deducciones
     */
    private static double getRetirementDeduction(double totalSalaryBeforeDeductions){
        return totalSalaryBeforeDeductions * Constants.PERCENTAGE_VALUE_RETIREMENT_DEDUCTION;
    }

    /**
     * @param totalSalaryBeforeDeductions (double)
     * @return double
     * Descripción: calcula el valor de la deducción de caja de compensación del salario total
     * antes de las deducciones
     */
    private static double getCompensationDeduction(double totalSalaryBeforeDeductions){
        return totalSalaryBeforeDeductions * Constants.PERCENTAGE_VALUE_COMPENSATION_FUND_DEDUCTION;
    }

    /**
     * @param totalSalaryBeforeDeductions (double)
     * @return double
     * Descripción: Calcula las deducciones que se realizarán al total del salario antes de las
     * deducciones
     */
    private static double calculateDeductions(double totalSalaryBeforeDeductions){
        return getHealthDeduction(totalSalaryBeforeDeductions) +
                getRetirementDeduction(totalSalaryBeforeDeductions) +
                getCompensationDeduction(totalSalaryBeforeDeductions);
    }
}
