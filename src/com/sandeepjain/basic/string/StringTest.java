package com.sandeepjain.basic.string;

import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertFalse;


public class StringTest {
    StringPractice stringTest = new StringPractice();
    @Test
    public void checkAnagramTest() {
        assertTrue(stringTest.checkStringAnagEff1("geeks", "ekesg"));
        assertFalse(stringTest.checkStringAnagEff1("aabcd","abbc"));
    }
    @Test
    public void checkAnagramTest2() {
        assertTrue(stringTest.checkStringAnagEff1("geeks", "ekesg"));
        assertFalse(stringTest.checkStringAnagEff1("aabcd","abbc"));
    }
//
    @Test
    void groupedAssertions() {
        assertAll("address name",
                () -> assertTrue(stringTest.checkStringAnagNaive("geeks", "ekesg")),
                () -> assertFalse(stringTest.checkStringAnagNaive("aabcd","abbc"))
        );
        assertAll("checking anagram efficient",
                () -> assertTrue(stringTest.checkStringAnagEff1("geeks", "ekesg")),
                () -> assertFalse(stringTest.checkStringAnagEff1("aabcd","abbc"))
        );
    }

    //Testing for
    @Test
    public void findFirstRepeating(){
        assertEquals(0,stringTest.findFirstRepeatingCharNaive("geeksforgeeks"));
        assertEquals(0,stringTest.findFirstRepeatingCharNaive("aabcd"));
        assertEquals(-1,stringTest.findFirstRepeatingCharNaive("abcd"));

    }
    @Test
    void groupedAssertionsFirstRepeatingChar() {
        assertAll("checking for repeating character naive O(N^2) time complexity",
                () -> assertEquals(0,stringTest.findFirstRepeatingCharNaive("geeksforgeeks")),
                () -> assertEquals(0,stringTest.findFirstRepeatingCharNaive("aabcd")),
                () -> assertEquals(-1,stringTest.findFirstRepeatingCharNaive("abcd")),
                () -> assertEquals(0,stringTest.findFirstRepeatingCharNaive("abcda")),
                () -> assertEquals(1,stringTest.findFirstRepeatingCharNaive("abcdb")),
                () -> assertEquals(3,stringTest.findFirstRepeatingCharNaive("abcdd"))
        );
        assertAll("checking for repeating character efficient O(N) time complexity",
                () -> assertEquals(0,stringTest.findFirstRepeatingCharEff("geeksforgeeks")),
                () -> assertEquals(0,stringTest.findFirstRepeatingCharEff("aabcd")),
                () -> assertEquals(-1,stringTest.findFirstRepeatingCharEff("abcd")),
                () -> assertEquals(0,stringTest.findFirstRepeatingCharEff("abcda")),
                () -> assertEquals(1,stringTest.findFirstRepeatingCharEff("abcdb")),
                () -> assertEquals(3,stringTest.findFirstRepeatingCharEff("abcdd"))
        );
        assertAll("checking for repeating character efficient O(N) time complexity but exactly one traversal is allowed",
                () -> assertEquals(0,stringTest.findFirstRepeatingCharEff2("geeksforgeeks")),
                () -> assertEquals(0,stringTest.findFirstRepeatingCharEff2("aabcd")),
                () -> assertEquals(-1,stringTest.findFirstRepeatingCharEff2("abcd")),
                () -> assertEquals(0,stringTest.findFirstRepeatingCharEff2("abcda")),
                () -> assertEquals(1,stringTest.findFirstRepeatingCharEff2("abcdb")),
                () -> assertEquals(3,stringTest.findFirstRepeatingCharEff2("abcdd"))

        );
        assertAll("checking for repeating character efficient O(constant) time complexity",
                () -> assertEquals(0,stringTest.findFirstRepeatingCharEff3("geeksforgeeks")),
                () -> assertEquals(0,stringTest.findFirstRepeatingCharEff3("aabcd")),
                () -> assertEquals(-1,stringTest.findFirstRepeatingCharEff3("abcd")),
                () -> assertEquals(0,stringTest.findFirstRepeatingCharEff3("abcda")),
                () -> assertEquals(1,stringTest.findFirstRepeatingCharEff3("abcdb")),
                () -> assertEquals(3,stringTest.findFirstRepeatingCharEff3("abcdd"))

        );
    }

    @Test
    void groupedAssertionsFirstNonRepeatingChar() {
        assertAll("checking for first non repeating character naive O(N^2) time complexity",
                () -> assertEquals(5,stringTest.findFirstNonRepeatingEff("geeksforgeeks")),
                () -> assertEquals(6,stringTest.findFirstNonRepeatingEff("aabbccd")),
                () -> assertEquals(0,stringTest.findFirstNonRepeatingEff("abcd")),
                () -> assertEquals(2,stringTest.findFirstNonRepeatingEff("aabccda")),
                () -> assertEquals(4,stringTest.findFirstNonRepeatingEff("eezztvvg")),
                () -> assertEquals(2,stringTest.findFirstNonRepeatingEff("mmoabcd"))
        );

    }
}

