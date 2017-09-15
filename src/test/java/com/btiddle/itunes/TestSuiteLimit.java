package com.btiddle;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.btiddle.TestFramework.getQueryString;
import static com.btiddle.TestFramework.httpGet;


public class TestSuiteLimit {
    boolean debug = TestFramework.DEBUG;

    // iTunes Search API
    String baseURL = "https://itunes.apple.com/search";

    /**
     * <pre>
     * <i>Test Case: </i>
     * term   = "Taylor Swift",
     * limit  = default
     * </pre>
     */
    @Test
    public void testcase_limit_default() throws Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"term", "Taylor Swift"}} );

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 200);

        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 50);

        Object artistName = responseObj.body.getJSONArray("results").getJSONObject(0).opt("artistName");
        Assert.assertEquals(artistName, "Taylor Swift");
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * term   = "Despacito",
     * limit  = 1
     * </pre>
     */
    @Test
    public void testcase_limit_is_1() throws Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"term", "Despacito"}, {"limit", "1"}} );

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 200);

        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 1);

        Object artistName = responseObj.body.getJSONArray("results").getJSONObject(0).opt("artistName");
        Assert.assertEquals(artistName, "Luis Fonsi & Daddy Yankee");
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * term   = "Cardi B",
     * limit  = 2
     * </pre>
     */
    @Test
    public void testcase_limit_is_2() throws Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"term", "Cardi B"}, {"limit", "2"}} );

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 200);

        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 2);

        Object artistName = responseObj.body.getJSONArray("results").getJSONObject(0).opt("artistName");
        Assert.assertEquals(artistName, "Cardi B");
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * term   = "Charlie Puth",
     * limit  = 3
     * </pre>
     */
    @Test
    public void testcase_limit_is_3() throws Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"term", "Charlie Puth"}, {"limit", "3"}} );

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 200);

        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 3);

        Object artistName = responseObj.body.getJSONArray("results").getJSONObject(0).opt("artistName");
        Assert.assertEquals(artistName, "Charlie Puth");
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * term   = "Imagine Dragons",
     * limit  = 4
     * </pre>
     */
    @Test
    public void testcase_limit_is_4() throws Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"term", "Imagine Dragons"}, {"limit", "4"}} );

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 200);

        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 4);

        Object artistName = responseObj.body.getJSONArray("results").getJSONObject(0).opt("artistName");
        Assert.assertEquals(artistName, "Imagine Dragons" );
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * term   = "French Montana",
     * limit  = 5
     * </pre>
     */
    @Test
    public void testcase_limit_is_5() throws Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"term", "French Montana"}, {"limit", "5"}} );

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 200);

        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 5);

        Object artistName = responseObj.body.getJSONArray("results").getJSONObject(0).opt("artistName");
        Assert.assertEquals(artistName, "French Montana");
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * term   = "Shawn Mendes",
     * limit  = 6
     * </pre>
     */
    @Test
    public void testcase_limit_is_6() throws Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"term", "Shawn Mendes"}, {"limit", "6"}} );

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 200);

        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 6);

        Object artistName = responseObj.body.getJSONArray("results").getJSONObject(0).opt("artistName");
        Assert.assertEquals(artistName, "Shawn Mendes");
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * term   = "Logic",
     * limit  = 7
     * </pre>
     */
    @Test
    public void testcase_limit_is_7() throws Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"term", "Logic"}, {"limit", "7"}} );

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 200);

        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 7);

        Object artistName = responseObj.body.getJSONArray("results").getJSONObject(0).opt("artistName");
        Assert.assertEquals(artistName, "Logic");
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * term   = "Michael Jackson",
     * limit  = 8
     * </pre>
     */
    @Test
    public void testcase_limit_is_8() throws Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"term", "Michael Jackson"}, {"limit", "8"}} );

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 200);

        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 8);

        Object artistName = responseObj.body.getJSONArray("results").getJSONObject(0).opt("artistName");
        Assert.assertEquals(artistName, "Michael Jackson");
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * term   = "Michael Jackson",
     * limit  = 9
     * </pre>
     */
    @Test
    public void testcase_limit_is_9() throws Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"term", "Michael Jackson"}, {"limit", "9"}} );

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 200);

        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 9);

        Object artistName = responseObj.body.getJSONArray("results").getJSONObject(0).opt("artistName");
        Assert.assertEquals(artistName, "Michael Jackson");
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * term   = "Enya",
     * limit  = 10
     * </pre>
     */
    @Test
    public void testcase_limit_is_10() throws Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"term", "Enyan"}, {"limit", "10"}} );

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 200);

        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 10);

        Object artistName = responseObj.body.getJSONArray("results").getJSONObject(0).opt("artistName");
        Assert.assertEquals(artistName, "Enya");
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * term   = "Usher",
     * limit  = 20
     * </pre>
     */
    @Test
    public void testcase_limit_is_20() throws Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"term", "Usher"}, {"limit", "20"}} );

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 200);

        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 20);

        Object artistName = responseObj.body.getJSONArray("results").getJSONObject(0).opt("artistName");
        Assert.assertEquals(artistName, "Usher");
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * term   = "The Rolling Stones",
     * limit  = 50
     * </pre>
     */
    @Test
    public void testcase_limit_is_50() throws Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"term", "The Rolling Stones"}, {"limit", "50"}} );

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 200);

        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 50);

        Object artistName = responseObj.body.getJSONArray("results").getJSONObject(0).opt("artistName");
        Assert.assertEquals(artistName, "The Rolling Stones");
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * term   = "Queen",
     * limit  = 100
     * </pre>
     */
    @Test
    public void testcase_limit_is_100() throws Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"term", "Queen"}, {"limit", "100"}} );

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 200);

        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 100);

        Object artistName = responseObj.body.getJSONArray("results").getJSONObject(0).opt("artistName");
        Assert.assertEquals(artistName, "Queen");
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * term   = "Whitney Houston",
     * limit  = 150
     * </pre>
     */
    @Test
    public void testcase_limit_is_150() throws Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"term", "Whitney Houston"}, {"limit", "150"}} );

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 200);

        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 150);

        Object artistName = responseObj.body.getJSONArray("results").getJSONObject(0).opt("artistName");
        Assert.assertEquals(artistName, "Whitney Houston");
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * term   = "AC/DC",
     * limit  = 200
     * </pre>
     */
    @Test
    public void testcase_limit_is_200() throws Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"term", "AC/DC"}, {"limit", "200"}} );

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 200);

        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 200);

        Object artistName = responseObj.body.getJSONArray("results").getJSONObject(0).opt("artistName");
        Assert.assertEquals(artistName, "AC/DC");
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * term   = "Céline Dion",
     * limit  = 201 when max is 200
     * </pre>
     */
    @Test
    public void testcase_limit_is_201() throws Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"term", "Céline Dion"}, {"limit", "201"}} );

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 200);

        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 200);

        Object artistName = responseObj.body.getJSONArray("results").getJSONObject(0).opt("artistName");
        Assert.assertEquals(artistName, "Céline Dion");
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * term   = "Rihanna",
     * limit  = 1,000 when max is 200
     * </pre>
     */
    @Test
    public void testcase_limit_is_1_000() throws Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"term", "Rihanna"}, {"limit", "1000"}} );

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 200);

        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 200);

        Object artistName = responseObj.body.getJSONArray("results").getJSONObject(0).opt("artistName");
        Assert.assertEquals(artistName, "Rihanna");
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * term   = "Rihanna",
     * limit  = 10,000 when max is 200
     * </pre>
     */
    @Test
    public void testcase_limit_is_10_000() throws Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"term", "Rihanna"}, {"limit", "10000"}} );

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 200);

        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 200);

        Object artistName = responseObj.body.getJSONArray("results").getJSONObject(0).opt("artistName");
        Assert.assertEquals(artistName, "Rihanna");
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * term   = "The Beatles",
     * limit  = 100,000 when max is 200
     * </pre>
     */
    @Test
    public void testcase_limit_is_100_000() throws Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"term", "The Beatles"}, {"limit", "100000"}} );

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 200);

        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 200);

        Object artistName = responseObj.body.getJSONArray("results").getJSONObject(0).opt("artistName");
        Assert.assertEquals(artistName, "The Beatles");
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * term   = "Elvis Presley",
     * limit  = 1,000,000 when max is 200
     * </pre>
     */
    @Test
    public void testcase_limit_is_1_000_000() throws Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"term", "Elvis Presley"}, {"limit", "1000000"}} );

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 200);

        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 200);

        Object artistName = responseObj.body.getJSONArray("results").getJSONObject(0).opt("artistName");
        Assert.assertEquals(artistName, "Elvis Presley");
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * term   = "Madonna",
     * limit  = 0
     *
     *  Specification Question: Inconsistent behavior when limit is leas than 1.
     *
     *  Specification does not say what value should be, but seems like it ought
     *  to be either 0 (for no records return) or 50 (default records returned).
     *
     *  Test case is assuming default value of 50.
     *
     *  If behavior is changed to 0, will need to update test case code to
     *  handle when 0 records are returned.
     *
     *  limit    records_returned
     *  -----    ----------------
     *      0                  18
     *     -1                  17
     *     -2                  16
     *     -3                  15
     *     -4                  14
     *     -5                  12
     *     -6                  11
     *     -7                  10
     *     -8                   9
     *     -9                   8
     *    -10                   6
     *    -11                   5
     *    -12                   4
     *    -13                   3
     *    -14                   2
     *    -15                   0
     *    -16                   0
     *    -17                   0
     *    -18                   0
     *    -19                   0
     *    -20                   0
     *    -30                   0
     *   -100                   0
     * </pre>
     */
    @Test
    public void testcase_limit_is_0() throws Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"term", "Madonna"}, {"limit", "0"}} );

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 200);

        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 50);

        Object artistName = responseObj.body.getJSONArray("results").getJSONObject(0).opt("artistName");
        Assert.assertEquals(artistName, "Madonnay");
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * term   = "Elton Johny",
     * limit  = "A"
     * </pre>
     */
    @Test
    public void testcase_limit_is_A() throws Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"term", "Elton John"}, {"limit", "A"}} );

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 200);

        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 50);

        Object artistName = responseObj.body.getJSONArray("results").getJSONObject(0).opt("artistName");
        Assert.assertEquals(artistName, "Elton John");
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * term   = "Led Zeppelin",
     * limit  = "A Z"
     * </pre>
     */
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testcase_limit_is_A_Z() throws Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"term", "Led Zeppelin"}, {"limit", "A Z"}} );

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 200);

        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 50);

        Object artistName = responseObj.body.getJSONArray("results").getJSONObject(0).opt("artistName");
        Assert.assertEquals(artistName, "Led Zeppelin");
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * term   = "Pink Floyd",
     * limit  = "A Z~!@#$%^*()_-+={[}]|:;,.?,"
     * </pre>
     */
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testcase_limit_is_A_Z_special_characters() throws Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"term", "Pink Floyd"}, {"limit", "A Z~!@#$%^&*()_-+={[}]|:;<,>.?<,>"}} );

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 200);

        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 50);

        Object artistName = responseObj.body.getJSONArray("results").getJSONObject(0).opt("artistName");
        Assert.assertEquals(artistName, "Pink Floyd");
    }

}
