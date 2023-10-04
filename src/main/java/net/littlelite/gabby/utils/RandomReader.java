/*
 * Gabby Phrase Generator - Java Edition
 * Copyright (c) Alessio Saltarin 2023.
 * This software is licensed under ISC License (see LICENSE)
 *
 */

package net.littlelite.gabby.utils;

import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.List;

public class RandomReader
{
    private List<String> nouns;
    private List<String> adjectives;
    private List<String> verbs;

    public RandomReader(
            Path nounsPath,
            Path adjectivesPath,
            Path verbsPath
    )
    {
        try
        {
            this.initialize(nounsPath, adjectivesPath, verbsPath);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    private void initialize(Path nounsPath,
                            Path adjectivesPath,
                            Path verbsPath) throws IOException
    {
        Charset charset = Charset.forName("UTF-8");
        this.nouns = FileUtils.readLines(nounsPath.toFile(), charset);
        this.adjectives = FileUtils.readLines(adjectivesPath.toFile(), charset);
        this.verbs = FileUtils.readLines(verbsPath.toFile(), charset);
    }

    public String getRandomNoun()
    {
        return this.nouns.get((int) (Math.random() * this.nouns.size()));
    }

    public String getRandomAdjective()
    {
        return this.adjectives.get((int) (Math.random() * this.adjectives.size()));
    }

    public String getRandomVerb()
    {
        return this.verbs.get((int) (Math.random() * this.verbs.size()));
    }
}
