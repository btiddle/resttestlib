package com.btiddle;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.btiddle.TestFramework.getQueryString;
import static com.btiddle.TestFramework.httpGet;


public class TestSuiteBadUrl {

    boolean debug = TestFramework.DEBUG;

    // iTunes Search API
    String baseURL = "https://itunes.apple.com/search";

    /**
     * <pre>
     * <i>Test Case: </i>
     * base url       = valid,
     * query_string   = empty
     * </pre>
     */
    @Test
    public void testcase_query_string_is_empty() throws Exception {
        // Construct query string
        String query = "";

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 200);

        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 0);
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * base url       = valid,
     * query_string   = null
     * </pre>
     */
    @Test
    public void testcase_query_string_is_null() throws Exception {
        // Construct query string
        String query = null;

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 404);
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * base url       = valid,
     * query_string   = "?"
     *
     * Specification Question:
     *
     * Should query string of "?" really return status code of 200?
     *
     * </pre>
     */
    @Test
    public void testcase_query_string_is_qmark() throws Exception {
        // Construct query string
        String query = "?";

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 200);

        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 0);
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * base url       = valid,
     * query_string   = "term="
     * </pre>
     */
    @Test
    public void testcase_query_string_is_term_eq() throws Exception {
        // Construct query string
        String query = "term=";

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 404);
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * base url       = valid,
     * query_string   = "country="
     * </pre>
     */
    @Test
    public void testcase_query_string_is_country_eq() throws Exception {
        // Construct query string
        String query = "country=";

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 404);
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * base url       = valid,
     * query_string   = "media="
     * </pre>
     */
    @Test
    public void testcase_query_string_is_media_eq() throws Exception {
        // Construct query string
        String query = "media=";

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 404);
    }


    /**
     * <pre>
     * <i>Test Case: </i>
     * base url       = valid,
     * query_string   = "limit="
     * </pre>
     */
    @Test
    public void testcase_query_string_is_limit_eq() throws Exception {
        // Construct query string
        String query = "limit=";

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 404);
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * TERM   = "The",
     * media  = "ebook",
     * limit  = 1
     * Specification Question: term upper case return 0 records.
     *
     * Should "TERM=Bob" returns 0 records when "term=Bob" does return records?
     * Or should it return 404 like the other incorrect query string?
     * </pre>
     */
    @Test
    public void testcase_media_term_capital_letters() throws  Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"TERM", "Bob"}, {"media", "ebook"}, {"limit", "1"}} );

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 200);

        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 1);

        Object kind = responseObj.body.getJSONArray("results").getJSONObject(0).opt("kind");
        Assert.assertEquals(kind, "ebook");
    }

}
