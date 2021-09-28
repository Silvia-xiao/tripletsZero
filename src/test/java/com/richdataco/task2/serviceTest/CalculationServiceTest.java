package com.richdataco.task2.serviceTest;

import com.richdataco.task2.service.CalculationService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.Arrays;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@SpringBootTest
public class CalculationServiceTest {
    CalculationService calculationService = new CalculationService();

    @Test
    public void testPerformCalculation() throws Exception {
        int arr[] = {0, -1, 2, -3, 1, 1};
        String inputString = Arrays.toString(arr);
        int triplet_1[] = {-3, 1, 2};
        int triplet_2[] = {-1, 0, 1};
        ArrayList<int[]> expectResult = new ArrayList<int[]>();
        expectResult.add(triplet_1);
        expectResult.add(triplet_2);
        ArrayList<int[]> actualResult = calculationService.performCalculation(inputString);
        for (int i = 0; i < actualResult.size() - 1; i++) {
            assertThat(actualResult.get(i), is(expectResult.get(i)));
        }
    }

    @Test
    public void testTripletsZero() {
        int arr[] = {0, -1, 2, -3, 1, 1};
        int triplet_1[] = {-3, 1, 2};
        int triplet_2[] = {-1, 0, 1};
        ArrayList<int[]> expectResult = new ArrayList<int[]>();
        expectResult.add(triplet_1);
        expectResult.add(triplet_2);
        ArrayList<int[]> actualResult = calculationService.tripletsZero(arr);
        for (int i = 0; i < actualResult.size() - 1; i++) {
            assertThat(actualResult.get(i), is(expectResult.get(i)));
        }
    }

    @Test
    public void testTripletsZero_testNoDuplicateRecord() {
        int arr[] = {0, -1, 2, -3, 1, 1, -1, 1};
        int triplet_1[] = {-3, 1, 2};
        int triplet_2[] = {-1, -1, 2};
        int triplet_3[] = {-1, 0, 1};
        ArrayList<int[]> expectResult = new ArrayList<int[]>();
        expectResult.add(triplet_1);
        expectResult.add(triplet_2);
        expectResult.add(triplet_3);
        ArrayList<int[]> actualResult = calculationService.tripletsZero(arr);
        for (int i = 0; i < actualResult.size() - 1; i++) {
            assertThat(actualResult.get(i), is(expectResult.get(i)));
        }
    }
}
