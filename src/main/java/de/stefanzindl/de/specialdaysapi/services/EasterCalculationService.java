package de.stefanzindl.de.specialdaysapi.services;

import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class EasterCalculationService {

    public LocalDate calculateEasterDate(int year) {
        int goldenNumber = calculateGoldenNumber(year);
        int century = year / 100;
        int h = calculateH(year, goldenNumber, century);
        int i = calculateI(century);
        int j = calculateJ(year);
        int l = calculateL(h, i, j);

        int month = calculateEasterMonth(h, l);
        int day = calculateEasterDay(h, l);

        return LocalDate.of(year, month, day);
    }

    private int calculateGoldenNumber(int year) {
        return year % 19 + 1;
    }

    private int calculateH(int year, int goldenNumber, int century) {
        int a = year % 19;
        int b = century / 4;
        int c = century % 4;
        int d = (century + 8) / 25;
        int e = (century - d + 1) / 3;
        int f = (19 * a + century - b - e + 15) % 30;
        return f;
    }

    private int calculateI(int century) {
        return century / 4 - (century + 8) / 25 + 5;
    }

    private int calculateJ(int year) {
        return year % 4;
    }

    private int calculateL(int h, int i, int j) {
        return (32 + 2 * i + 2 * j - h) % 7;
    }

    private int calculateEasterMonth(int h, int l) {
        int m = (h + l - 7 * ((h + l - 7) / 7) + 114) / 31;
        return m;
    }

    private int calculateEasterDay(int h, int l) {
        int p = (h + l - 7 * ((h + l - 7) / 7) + 114) % 31;
        return p + 1;
    }
}
