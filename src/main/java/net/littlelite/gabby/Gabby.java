/*
 * Gabby Phrase Generator - Java Edition
 * Copyright (c) Alessio Saltarin 2023.
 * This software is licensed under ISC License (see LICENSE)
 *
 */

package net.littlelite.gabby;

import net.littlelite.gabby.utils.RandomReader;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

class Gabby implements IGabby
{
    private final RandomReader randomReader;

    public Gabby()
    {
        Path nouns = Paths.get("src/main/resources/nouns.txt");
        Path adjectives = Paths.get("src/main/resources/adjectives.txt");
        Path verbs = Paths.get("src/main/resources/verbs.txt");
        this.randomReader = new RandomReader(nouns, adjectives, verbs);
    }

    public String generate()
    {
        return this.generate(5);
    }

    public String generate(int numberOfWords)
    {
        ArrayList<String> phrase = new ArrayList<>();
        for (int i = 0; i < numberOfWords; i++)
        {
            phrase.add(this.randomReader.getRandomAdjective());
            phrase.add(this.randomReader.getRandomNoun());
            phrase.add(this.randomReader.getRandomVerb());
        }
        return String.join(" ", phrase);
    }
}
