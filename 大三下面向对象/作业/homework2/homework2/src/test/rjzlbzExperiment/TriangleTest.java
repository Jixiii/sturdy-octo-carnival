package test.rjzlbzExperiment;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;
import rjzlbzExperiment.Triangle;
//import org.junit.platform.runner.JUnitPlatform;
//import org.junit.platform.suite.api.SelectPackages;

/**
 * Triangle Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>11�� 12, 2022</pre>
 */
public class TriangleTest {

    @Before
    @Test
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: panDuanXingZhuang()
     */
    @Test
    @ParameterizedTest
    @CsvSource({"2,3,5,不能构成三角形", "-2,20,18,边长非法","3,3,3,等边三角形","3,3,5,等腰三角形","3,4,5,一般三角形"})
    public void testPanDuanXingZhuang(ArgumentsAccessor args) throws Exception {
//TODO: Test goes here...
        Triangle triangle = new Triangle();
        Assert.assertEquals(args.getString(3),triangle.panDuanXingZhuang(args.getInteger(0), args.getInteger(1), args.getInteger(2)));
    }


} 
