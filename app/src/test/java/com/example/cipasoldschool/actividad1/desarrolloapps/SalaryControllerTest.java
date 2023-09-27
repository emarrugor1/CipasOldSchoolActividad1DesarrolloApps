package com.example.cipasoldschool.actividad1.desarrolloapps;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.cipasoldschool.actividad1.desarrolloapps.controller.SalaryController;
import com.example.cipasoldschool.actividad1.desarrolloapps.model.Salary;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class SalaryControllerTest {
    @Test
    public void itShoulCalculateTheTotalSalaryWithNoExtraHourNorBonus() {
        Salary salary = new Salary();
        salary.setBaseSalary(1000000);
        salary.setExtraHours(0);
        String totalSalary = SalaryController.calculateTotalSalary(salary);

        assertEquals("915000,00",totalSalary);
    }
    @Test
    public void itShoulCalculateTheTotalSalaryWithExtraHourAndBonus() {
        Salary salary = new Salary();
        salary.setBaseSalary(2355255);
        salary.setExtraHours(2);
        salary.setBonus(1);
        String totalSalary = SalaryController.calculateTotalSalary(salary);

        assertEquals("2290871,90",totalSalary);
    }
}