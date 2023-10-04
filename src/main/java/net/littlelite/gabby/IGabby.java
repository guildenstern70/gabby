/*
 * Gabby Phrase Generator - Java Edition
 * Copyright (c) Alessio Saltarin 2023.
 * This software is licensed under ISC License (see LICENSE)
 *
 */

package net.littlelite.gabby;

public interface IGabby
{
    /**
     * Generates a gabby phrase
     * @return a gabby phrase
     */
    String generate();

    /**
     * Generates a gabby phrase with a given number of words
     * @param numberOfWords number of words
     * @return a gabby phrase
     */
    String generate(int numberOfWords);

}
