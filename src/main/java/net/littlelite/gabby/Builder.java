/*
 * Gabby Phrase Generator - Java Edition
 * Copyright (c) Alessio Saltarin 2023.
 * This software is licensed under ISC License (see LICENSE)
 *
 */

package net.littlelite.gabby;

import net.littlelite.gabby.utils.RandomReader;
import simplenlg.features.Feature;
import simplenlg.features.InterrogativeType;
import simplenlg.features.Tense;
import simplenlg.framework.NLGFactory;
import simplenlg.lexicon.Lexicon;
import simplenlg.phrasespec.NPPhraseSpec;
import simplenlg.phrasespec.SPhraseSpec;
import simplenlg.phrasespec.VPPhraseSpec;
import simplenlg.realiser.english.Realiser;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class Builder
{
    private final RandomReader randomReader;
    private final Random random;

    public Builder()
    {
        this.random = new Random();
        Path nouns = Paths.get("src/main/resources/nouns.txt");
        Path adjectives = Paths.get("src/main/resources/adjectives.txt");
        Path verbs = Paths.get("src/main/resources/verbs.txt");
        Path templates = Paths.get("src/main/resources/templates.txt");
        this.randomReader = new RandomReader(nouns, adjectives, verbs, templates);
    }

    public String getPhrase()
    {
        Lexicon lexicon = Lexicon.getDefaultLexicon();
        NLGFactory nlgFactory = new NLGFactory(lexicon);
        Realiser realiser = new Realiser(lexicon);

        NPPhraseSpec subject = nlgFactory.createNounPhrase(this.randomReader.getRandomNoun());
        VPPhraseSpec verb = nlgFactory.createVerbPhrase(this.randomReader.getRandomVerb());

        NPPhraseSpec object = nlgFactory.createNounPhrase(this.randomReader.getRandomNoun());
        object.setDeterminer("the");
        if (this.random.nextInt(10) % 2 == 0)
        {
            object.setDeterminer("a");
        }

        // Adjective Modifiers
        if (this.random.nextInt(10) % 2 == 0)
        {
            subject.addModifier(this.randomReader.getRandomAdjective());
        }
        if (this.random.nextInt(10) % 3 == 0)
        {
            object.addModifier(this.randomReader.getRandomAdjective());
        }

        SPhraseSpec p = nlgFactory.createClause();
        p.setSubject(subject);
        p.setVerb(verb);
        p.setObject(object);

        // Adjust tense
        if (this.random.nextInt(10) == 7)
        {
            p.setFeature(Feature.TENSE, Tense.FUTURE);
        }
        else if (this.random.nextInt(10) % 3 == 0)
        {
            p.setFeature(Feature.TENSE, Tense.PAST);
        }

        // Adjust form
        if (this.random.nextInt(10) == 5)
        {
            p.setFeature(Feature.INTERROGATIVE_TYPE, InterrogativeType.YES_NO);
        }
        else if (this.random.nextInt(10) == 3)
        {
            p.setFeature(Feature.NEGATED, true);
        }

        return realiser.realiseSentence(p);
    }
}
