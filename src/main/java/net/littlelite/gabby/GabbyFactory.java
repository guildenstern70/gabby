/*
 * Gabby Phrase Generator - Java Edition
 * Copyright (c) Alessio Saltarin 2023.
 * This software is licensed under ISC License (see LICENSE)
 *
 */

package net.littlelite.gabby;

public final class GabbyFactory
{
    private GabbyFactory() {}

    /**
     * Creates a new Gabby phrase generator
     * @param words array of words
     * @return a new Gabby phrase generator
     */
    public static IGabby create(String[] words)
    {
        return new Gabby(words);
    }


}
