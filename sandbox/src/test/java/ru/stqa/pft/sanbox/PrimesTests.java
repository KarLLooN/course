package ru.stqa.pft.sanbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.sandbox.Primes;

import static ru.stqa.pft.sandbox.Primes.inPrimeWhile;

public class PrimesTests {
    @Test
    public void testPrime(){
        Assert.assertTrue(Primes.inPrime(Integer.MAX_VALUE));
    }

    @Test
    public void testNonPrime(){
        Assert.assertFalse(Primes.inPrime(Integer.MAX_VALUE - 2));
    }

    @Test(enabled = false)
    public void testPrimeLong(){
        long n = Integer.MAX_VALUE;
        Assert.assertTrue(Primes.inPrime(n));
    }

    @Test
    public void testNonPrimeLong(){
        long n = Integer.MAX_VALUE-2;
        Assert.assertFalse(Primes.inPrime(n));
    }

    @Test
    public void testPrimeFast(){
        Assert.assertTrue(Primes.inPrimeFast(Integer.MAX_VALUE));
    }
}