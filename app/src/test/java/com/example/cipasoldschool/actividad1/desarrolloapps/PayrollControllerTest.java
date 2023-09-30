package com.example.cipasoldschool.actividad1.desarrolloapps;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.cipasoldschool.actividad1.desarrolloapps.controller.PayrollController;
import com.example.cipasoldschool.actividad1.desarrolloapps.model.Payroll;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class PayrollControllerTest {
    @Test
    public void itShoulCalculateTheTotalSalaryWithNoExtraHourNorBonus() {
        Payroll payroll = new Payroll();
        payroll.setBaseSalary(1000000);
        payroll.setExtraHours(0);
        String totalSalary = PayrollController.calculateTotalSalary(payroll);

        assertEquals("915000,00",totalSalary);
    }
    @Test
    public void itShoulCalculateTheTotalSalaryWithExtraHourAndBonus() {
        Payroll payroll = new Payroll();
        payroll.setBaseSalary(2355255);
        payroll.setExtraHours(2);
        payroll.setBonus(1);
        String totalSalary = PayrollController.calculateTotalSalary(payroll);

        assertEquals("2290871,90",totalSalary);
    }
}