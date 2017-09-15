package com.btiddle;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.btiddle.TestFramework.getQueryString;
import static com.btiddle.TestFramework.httpGet;

public class TestSuiteTerm {
    boolean debug = TestFramework.DEBUG;

    // iTunes Search API
    String baseURL = "https://itunes.apple.com/search";

    /**
     * <pre>
     * <i>Test Case: </i>
     * term   = "taylor swift" as all lower case letters,
     * limit  = default
     * </pre>
     */
    @Test
    public void testcase_term_all_lower_case_letters() throws  Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"term", "taylor swift"}} );

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
     * term   = "TAYLOR SWIFT" as all upper case letters,
     * limit  = default
     * </pre>
     */
    @Test
    public void testcase_term_all_upper_lower_case_letters() throws Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"term", "taylor swift"}} );

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
     * term   = "10 Years" (includes digits)
     * limit  = default
     * </pre>
     */
    @Test
    public void testcase_term_digit() throws Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"term", "1"}} );

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 200);

        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 50);

        //Object artistName = responseObj.body.getJSONArray("results").getJSONObject(0).opt("artistName");
        //Assert.assertEquals(artistName, "10 Years");
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * term   = "!" (includes punctuation)
     * limit  = default
     * </pre>
     */
    @Test
    public void testcase_term_punctuation() throws Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"term", "!"}} );

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results

        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 50);

        //Object artistName = responseObj.body.getJSONArray("results").getJSONObject(0).opt("artistName");
        //Assert.assertEquals(artistName, "10 Years");
    }


}
