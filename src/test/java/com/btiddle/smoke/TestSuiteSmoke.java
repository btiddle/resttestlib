package com.btiddle.smoke;

import com.btiddle.ResponseObj;
import com.btiddle.TestFramework;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuiteSmoke extends TestFramework {
    boolean debug = TestFramework.DEBUG;
    String baseURL = TestFramework.BASE_URL;

    /**
     * <pre>
     * <i>Test Case: </i>
     * baseURL = https://itunes.apple.com/search
     * term    = "Taylor Swift",
     * country = "US",
     * media   = "music",
     * limit   = "200",
     * </pre>
     */
    @Test
    public void testcase_itunes_search_api() throws  Exception {

        // iTunes Search API
        baseURL = "https://itunes.apple.com/search";

        // Construct query string
        String query = getQueryString( new String[][] {
            {"term",    "Taylor Swift"},
            {"country", "US"},
            {"media",   "music"},
            {"limit",   "5"}
        });

        // Perform request
        ResponseObj responseObj = new ResponseObj(httpGet(baseURL + query));
        //ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 200);
        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 5);
        Object artistName1 = responseObj.body.getJSONArray("results").getJSONObject(0).opt("artistName");
        Assert.assertEquals(artistName1, "Taylor Swift");

        // Print records
        int count = responseObj.body.getJSONArray("results").length();
        System.out.println("number, artist name, track name");
        for (int i = 0; i < count; i++) {
            Object artistName2 = responseObj.body.getJSONArray("results").getJSONObject(i).opt("artistName");
            Object trackName = responseObj.body.getJSONArray("results").getJSONObject(i).opt("trackName");
            System.out.println((i + 1) + ", " + artistName2 + ", " + trackName);
        }
    }
}
