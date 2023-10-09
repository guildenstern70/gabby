/*
 * Gabby Phrase Generator - Java Edition
 * Copyright (c) Alessio Saltarin 2023.
 * This software is licensed under ISC License (see LICENSE)
 *
 */

package net.littlelite.gabby;

class Gabby implements IGabby
{
    private final Builder builder;

    public Gabby()
    {
        this.builder = new Builder();
    }

    public String generate()
    {
        return this.builder.getPhrase();
    }

}
