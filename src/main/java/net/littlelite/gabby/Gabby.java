/*
 * Gabby Phrase Generator - Java Edition
 * Copyright (c) Alessio Saltarin 2023.
 * This software is licensed under ISC License (see LICENSE)
 *
 */

package net.littlelite.gabby;

class Gabby implements IGabby
{
    private final String[] words;

    public Gabby(String[] words)
    {
        this.words = words;
    }

    public String generate()
    {
        return this.generate(5);
    }

    public String generate(int numberOfWords)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfWords; i++)
        {
            sb.append(this.words[(int) (Math.random() * this.words.length)]);
            sb.append(" ");
        }
        return sb.toString();
    }
}
