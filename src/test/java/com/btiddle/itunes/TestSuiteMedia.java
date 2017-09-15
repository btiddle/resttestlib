package com.btiddle;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.btiddle.TestFramework.getQueryString;
import static com.btiddle.TestFramework.httpGet;


public class TestSuiteMedia {
    boolean debug = TestFramework.DEBUG;

    // iTunes Search API
    String baseURL = "https://itunes.apple.com/search";

    /**
     * <pre>
     * <i>Test Case: </i>
     * term   = "Ann",
     * media = "movie",
     * limit  = 1
     * </pre>
     */
    @Test
    public void testcase_media_movie() throws  Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"term", "Ann"}, {"media", "movie"}, {"limit", "1"}} );

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 200);

        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 1);

        Object kind = responseObj.body.getJSONArray("results").getJSONObject(0).opt("kind");
        Assert.assertEquals(kind, "feature-movie");
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * term   = "John",
     * media = "podcast",
     * limit  = 1
     * </pre>
     */
    @Test
    public void testcase_media_podcast() throws  Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"term", "Bob"}, {"media", "podcast"}, {"limit", "1"}} );

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 200);

        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 1);

        Object kind = responseObj.body.getJSONArray("results").getJSONObject(0).opt("kind");
        Assert.assertEquals(kind, "podcast");
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * term   = "Miles Davis",
     * media = "music",
     * limit  = 1
     * </pre>
     */
    @Test
    public void testcase_media_music() throws  Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"term", "Miles Davis"}, {"media", "music"}, {"limit", "1"}} );

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 200);

        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 1);

        Object kind = responseObj.body.getJSONArray("results").getJSONObject(0).opt("kind");
        Assert.assertEquals(kind, "song");
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * term   = "Joe",
     * media = "musicVideo",
     * limit  = 1
     * </pre>
     */
    @Test
    public void testcase_media_musicVideo() throws  Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"term", "Joe"}, {"media", "musicVideo"}, {"limit", "1"}} );

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 200);

        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 1);

        Object kind = responseObj.body.getJSONArray("results").getJSONObject(0).opt("kind");
        Assert.assertEquals(kind, "music-video");
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * term   = "Sam",
     * media = "audiobook",
     * limit  = 1
     * </pre>
     */
    @Test
    public void testcase_media_audiobook() throws  Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"term", "Sam"}, {"media", "audiobook"}, {"limit", "1"}} );

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 200);

        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 1);

        Object wrapperType = responseObj.body.getJSONArray("results").getJSONObject(0).opt("wrapperType");
        Assert.assertEquals(wrapperType, "audiobook");
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * term   = "The",
     * media = "shortFilm",
     * limit  = 1
     * Specification Question: "media=shortFilm" returns no records.
     *
     * When using "media=shortFilm" with different term values, no records are
     * ever returned.
     *
     * </pre>
     *
     */
    @Test
    public void testcase_media_shortFilm() throws  Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"term", "Bob"}, {"media", "shortFilm"}, {"limit", "1"}} );

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 200);

        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 1);

        Object kind = responseObj.body.getJSONArray("results").getJSONObject(0).opt("kind");
        Assert.assertEquals(kind, "shortFilm");
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * term   = "The",
     * media = "tvShow",
     * limit  = 1
     * </pre>
     *
     */
    @Test
    public void testcase_media_tvShow() throws  Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"term", "Bob"}, {"media", "tvShow"}, {"limit", "1"}} );

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 200);

        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 1);

        Object kind = responseObj.body.getJSONArray("results").getJSONObject(0).opt("kind");
        Assert.assertEquals(kind, "tv-episode");
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * term   = "The",
     * media = "software",
     * limit  = 1
     * </pre>
     *
     */
    @Test
    public void testcase_media_software() throws  Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"term", "Bob"}, {"media", "software"}, {"limit", "1"}} );

        // Perform request
        ResponseObj responseObj = httpGet(baseURL + query);

        // Assert results
        Assert.assertEquals(responseObj.statusCode, 200);

        int resultCount = Integer.parseInt(responseObj.body.get("resultCount").toString());
        Assert.assertEquals(resultCount, 1);

        Object kind = responseObj.body.getJSONArray("results").getJSONObject(0).opt("kind");
        Assert.assertEquals(kind, "software");
    }

    /**
     * <pre>
     * <i>Test Case: </i>
     * term   = "The",
     * media = "ebook",
     * limit  = 1
     * </pre>
     *
     */
    @Test
    public void testcase_media_ebook() throws  Exception {
        // Construct query string
        String query = getQueryString( new String[][] {{"term", "Bob"}, {"media", "ebook"}, {"limit", "1"}} );

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
