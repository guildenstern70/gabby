/*
 * Gabby Phrase Generator - Java Edition
 * Copyright (c) Alessio Saltarin 2023.
 * This software is licensed under ISC License (see LICENSE)
 *
 */

package net.littlelite.gabby;

import net.littlelite.gabby.utils.PhrasePart;
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
        Path templates = Paths.get("src/main/resources/templates.txt");
        this.randomReader = new RandomReader(nouns, adjectives, verbs, templates);
    }

    public String generate()
    {
        // 1. Get a random template
        var phrase = this.randomReader.getRandomTemplate();

        // 2. Substitute all adjectives, nouns and verbs in the template
        // with random adjectives, nouns and verbs
        phrase = this.tokenSubstitute(phrase, PhrasePart.ADJECTIVE);
        phrase = this.tokenSubstitute(phrase, PhrasePart.NOUN);
        phrase = this.tokenSubstitute(phrase, PhrasePart.VERB);

        return phrase;
    }

    /**
     * This function substitues all occurrences of a given word type in a template
     * with a random word of the given type.
     * @param template The template to substitute
     * @param wordType The word type to substitute (can be Verb, Noun or Adjective)
     *                 as defined in PhrasePart enum.
     *                 See src/main/java/net/littlelite/gabby/utils/PhrasePart.java
     *                 for more details.
     * @return The template with all occurrences of the given word type
     *
     */
    private String tokenSubstitute(String template, PhrasePart wordType)
    {
        int templateParts = this.countTokenOccurrences(template, wordType.getToken());
        for (int i = 0; i < templateParts; i++)
        {
            var word = switch (wordType) {
                case NOUN -> this.randomReader.getRandomNoun();
                case ADJECTIVE -> this.randomReader.getRandomAdjective();
                case VERB -> this.randomReader.getRandomVerb();
                default -> throw new RuntimeException("Unknown word type");
            };
            template = template.replaceFirst(wordType.getToken(), word);
        }

        return template;
    }

    /**
     * Get the number of token occurrences in a template
     * @param template The template to analyze
     * @param token The token to count
     * @return The number of occurrences of the token in the template
     */
    private int countTokenOccurrences(String template, String token)
    {
        var count = 0;
        var index = template.indexOf(token);
        while (index != -1)
        {
            count++;
            index = template.indexOf(token, index + 1);
        }
        return count;
    }

}
