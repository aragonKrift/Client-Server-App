package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import classes.*;

public class IAlgoStringMatchingTest {

    @Test
    public void testRabinKarpStringMatching() {
        IAlgoStringMatching algorithm = new RabinKarpStringMatching();
        Assertions.assertEquals(0, algorithm.search("AABAACAADAABAABA", "AABA"));
        Assertions.assertEquals(-1, algorithm.search("AABACAADAABAABA", "AAC"));
        Assertions.assertEquals(-1, algorithm.search("", "AAC"));
    }

    @Test
    public void testKMPStringMatching() {
        IAlgoStringMatching algorithm = new KMPStringMatching();
        Assertions.assertEquals(9, algorithm.search("BABAACAADAABAABA", "AABA"));
        Assertions.assertEquals(-1, algorithm.search("AABACAADAABAABA", "AAC"));
        Assertions.assertEquals(-1, algorithm.search("", "AAC"));
    }
}