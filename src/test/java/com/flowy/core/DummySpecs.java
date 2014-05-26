package com.flowy.core;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DummySpecs {

    private Dummy dummy;

    @Test
    public void itShouldSayHello() {
        //Given
        dummy = new Dummy();
        //When
        String reply = dummy.sayHello();
        //Then
        assertThat(reply, is("Hello World!"));
    }
}
