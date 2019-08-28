import org.junit.*;
public class JUnitTest {
    //Run once, e.g. Database connection, connection pool
    @Test
    public void
    checkMax() {
        int array[] = new int[]{1,7,3,4,5,6,2,8,9};
        Integer expected = 9;
        Integer actual = Finder.findMax(array);
        Assert.assertEquals(expected, actual);
    }
    // Run once, e.g close connection, cleanup
    @Test
    public void
    checkMin() {
        int array[] = new int[]{1,7,3,4,5,6,2,8,9};
        Integer expected = 1;
        Integer actual = Finder.findMin(array);
        Assert.assertEquals(expected, actual);
    }
    // Should rename to @BeforeTestMethod
    // e.g. Creating an similar object and share for all @Test
    @Test
    public void checkEmptyMax() {
        int array[] = new int[] {};
        Integer expected = null;
        Integer actual = Finder.findMax(array);
        Assert.assertEquals(expected, actual);
    }
    // Should rename to @AfterTestMethod
    @Test
    public void checkEmptyMin() {
        int array[] = new int[] {};
        Integer expected = null;
        Integer actual = Finder.findMin(array);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void checkNullMax() {
        int array[] = null;
        Integer expected = null;
        Integer actual = Finder.findMax(array);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void checkNullMin() {
        int array[] = null;
        Integer expected = null;
        Integer actual = Finder.findMin(array);
        Assert.assertEquals(expected, actual);
    }
}