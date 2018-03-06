package org.jandjzone.android.uitestingexample;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void string_isBlankNull() throws Exception {
        assertEquals(true,StringUtils.isBlank(null)||StringUtils.isBlank(""));
    }
    @Test
    public void string_isBlankBlank() throws Exception {
        assertEquals(true,StringUtils.isBlank(" "));
    }

    @Test
    public void string_isEmptyNull() throws Exception {
        assertEquals(true,StringUtils.isEmpty(null)||StringUtils.isEmpty(""));
    }
    @Test
    public void string_isEmptyBlank() throws Exception {
        assertEquals(true,StringUtils.isEmpty(" "));
    }
}