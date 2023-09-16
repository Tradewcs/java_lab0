package lab0;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lab0.Variant11;

class Variant11Test {
    @Test
    void inputOutputTaskTest() {
        double a = 1;
        double b = -3;

        double[] expected = new double[] {4, -2, 3, (double) 1 / 3};
        double[] actual = Variant11.inputOutputTask(a, b);
        assertEquals(expected, actual);
    }
    @Test
    void integerNumbersTaskTest() {
        int[] actual = Variant11.integerNumbersTask(372);
        int[] expected = new int[] {12, 42};
        assertEquals(expected, actual);
    }

    @Test
    void booleanTaskTest() {
        boolean actual = Variant11.booleanTask(5, 7);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    void ifTaskTest() {
        int[] actual = Variant11.ifTask(4, 9);
        int[] expected = new int[] {9, 9};
        assertEquals(expected, actual);
    }

    @Test
    void switchTaskTest() {
        char actual = Variant11.switchTask('N', 1, 2);
        char expected = 'E';
        assertEquals(expected, actual);
    }

    @Test
    void forTaskTest() {
        int actual = Variant11.forTask(2);
        int expected = 29;
        assertEquals(expected, actual);
    }

    @Test
    void whileTaskTest() {
        int actual = Variant11.whileTask(5);
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    void whileTaskTest1() {
        Variant11.whileTask(0);
    }

    @Test
    void seriesTaskTest() {
        boolean actual = Variant11.seriesTask(5, new int[] {6, 9, 12, 4, 57});
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    void functionTaskTest() {
        int[] actual = Variant11.functionTask(3, 1, 2, 4);
        int[] expected = new int[] {1, 4};
        assertEquals(expected, actual);
    }


    @Test
    void minMaxTaskTest() {
        int actual = Variant11.minMaxTask(new int[] {5, 3, 9, 2, 4});
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    void arrayTaskTest() {
        int[] actual = Variant11.arrayTask(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, 3);
        int[] expected = new int[] {3, 6, 9};
        assertEquals(expected, actual);
    }

    @Test
    void twoDimensionArrayTaskTest() {
        int[][] mx = {{1, 2, 3},
                      {4, 5, 6},
                      {7, 8, 9}};
        int[] actual = Variant11.twoDimensionArrayTask(mx);
        int[] expected = new int[] {1, 4, 7, 8, 5, 2, 3, 6, 9};
        assertEquals(expected, actual);
    }

    @Test
    void stringTaskTest() {
        String actual = Variant11.stringTask("wasd");
        String expected = "w a s d";
        assertEquals(expected, actual);
    }
}