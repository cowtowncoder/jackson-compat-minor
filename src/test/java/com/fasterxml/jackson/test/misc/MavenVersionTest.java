package com.fasterxml.jackson.test.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.maven.artifact.versioning.ComparableVersion;

import com.fasterxml.jackson.test.BaseTest;

public class MavenVersionTest extends BaseTest
{
    public void testOrdering()
    {
        ComparableVersion v1 = new ComparableVersion("2.11.0.alpha");
        ComparableVersion v2 = new ComparableVersion("2.11.0.m3");
        ComparableVersion v3 = new ComparableVersion("2.11.0.rc1");
        ComparableVersion v4 = new ComparableVersion("2.11.0.rc5");
        ComparableVersion v5 = new ComparableVersion("2.11.0");
        ComparableVersion v6 = new ComparableVersion("2.11.0.sp1");
        ComparableVersion v7 = new ComparableVersion("2.11.0.unknown");
        ComparableVersion v8 = new ComparableVersion("2.11.1");
        ComparableVersion v9 = new ComparableVersion("2.11.1.1");

        final List<ComparableVersion> exp = Arrays.asList(v1, v2, v3, v4, v5, v6, v7, v8, v9);
        final List<ComparableVersion> unsorted = Arrays.asList(v9, v8, v7, v6, v5, v4, v3, v2, v1);
        final List<ComparableVersion> sorted = new ArrayList<ComparableVersion>(unsorted);
        Collections.sort(sorted);

        assertEquals(exp, sorted);
    }
}
