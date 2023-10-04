/*
 * Gabby Phrase Generator - Java Edition
 * Copyright (c) Alessio Saltarin 2023.
 * This software is licensed under ISC License (see LICENSE)
 *
 */

package net.littlelite.gabby;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


class AppTest
{

    private final String[] words = new String[] {"the", "great", "api", "is", "the", "best"};

    private final Gabby gabby = new Gabby(words);

    @Test
    void generate()
    {
        String phrase = this.gabby.generate();
        assertThat("the").isIn(phrase.split(" "));
    }
}



