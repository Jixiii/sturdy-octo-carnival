package test.rjzlbzExperiment;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.CsvSource;
import rjzlbzExperiment.Calculator;

/**
 * Calculator Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>11�� 12, 2022</pre>
 */
public class CalculatorTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: add(int x, int y)
     */
    @Test
    @ParameterizedTest
    @CsvSource({"2,3,5", "-2,20,18"})
    public void testAdd(ArgumentsAccessor args) throws Exception {
//TODO: Test goes here...
        Calculator calculator = new Calculator();
        Assert.assertEquals(args.getInteger(2).intValue(), calculator.add(args.getInteger(0), args.getInteger(1)));
    }

    /**
     * Method: sub(int x, int y)
     */
    @Test
    @ParameterizedTest
    @CsvSource({"2,3,-1", "-2,20,-22"})
    public void testSub(ArgumentsAccessor args) throws Exception {
//TODO: Test goes here...
        Calculator calculator = new Calculator();
        Assert.assertEquals(args.getInteger(2).intValue(), calculator.sub(args.getInteger(0), args.getInteger(1)));
    }

    /**
     * Method: mul(int x, int y)
     */
    @Test
    @ParameterizedTest
    @CsvSource({"2,3,6", "-2,20,-40"})
    public void testMul(ArgumentsAccessor args) throws Exception {
//TODO: Test goes here...
        Calculator calculator = new Calculator();
        Assert.assertEquals(args.getInteger(2).intValue(), calculator.mul(args.getInteger(0), args.getInteger(1)));
    }

    /**
     * Method: div(int x, int y)
     */
    @Test
    @ParameterizedTest
    @CsvSource({"2,3,0", "-2,20,0"})
    public void testDiv(ArgumentsAccessor args) throws Exception {
//TODO: Test goes here...
        Calculator calculator = new Calculator();
        Assert.assertEquals(args.getInteger(2).intValue(), calculator.div(args.getInteger(0), args.getInteger(1)));
    }


} 
