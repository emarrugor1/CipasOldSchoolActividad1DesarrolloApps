package com.example.cipasoldschool.actividad1.desarrolloapps.model;

public class Payroll {
    private double baseSalary;
    private double extraHours;
    private int bonus = 0;

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getExtraHours() {
        return extraHours;
    }

    public void setExtraHours(double extraHours) {
        this.extraHours = extraHours;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
