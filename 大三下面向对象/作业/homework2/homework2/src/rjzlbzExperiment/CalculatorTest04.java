package rjzlbzExperiment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author IDK You Yet
 */
public class CalculatorTest04 {
    @Before
    public void setUp() throws Exception {
        System.out.println("setUp");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown");
    }

    @Test
    public void add01() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(30,calculator.add(10, 20));
        System.out.println("calculator.add(10, 20)");
    }

    @Test
    public void add02() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(0,calculator.add(0, 0));
        System.out.println("calculator.add(0, 0)");
    }

    @Test
    public void add03() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(-10,calculator.add(10, -20));
        System.out.println("calculator.add(10, -20)");
    }

    @Test
    public void sub01() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(-10,calculator.sub(10, 20));
        System.out.println("calculator.sub(10, 20)");
    }

    @Test
    public void sub02() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(10,calculator.sub(20, 10));
        System.out.println("calculator.sub(20, 10)");
    }

    @Test
    public void sub03() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(-20,calculator.sub(0, 20));
        System.out.println("calculator.sub(0, 20)");
    }

    @Test
    public void mul01() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(0,calculator.mul(0, 20));
        System.out.println("calculator.mul(0, 20)");
    }

    @Test
    public void div01() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(0,calculator.div(10, 20));
        System.out.println("calculator.mul(10, 20)");
    }

    @Test
    public void div02() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(6,calculator.div(120, 20));
        System.out.println("calculator.mul(10, 20)");
    }
}