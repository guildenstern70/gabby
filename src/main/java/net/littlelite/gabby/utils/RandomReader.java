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
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;

public class RandomReader
{
    private List<String> nouns;
    private List<String> adjectives;
    private List<String> verbs;
    private List<String> templates;

    public RandomReader(
            Path nounsPath,
            Path adjectivesPath,
            Path verbsPath,
            Path templatesPath
    )
    {
        try
        {
            this.initialize(nounsPath, adjectivesPath, verbsPath, templatesPath);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    private void initialize(Path nounsPath,
                            Path adjectivesPath,
                            Path verbsPath,
                            Path templatesPath) throws IOException
    {
        this.nouns = FileUtils.readLines(nounsPath.toFile(), StandardCharsets.UTF_8);
        this.adjectives = FileUtils.readLines(adjectivesPath.toFile(), StandardCharsets.UTF_8);
        this.verbs = FileUtils.readLines(verbsPath.toFile(), StandardCharsets.UTF_8);
        this.templates = FileUtils.readLines(templatesPath.toFile(), StandardCharsets.UTF_8);
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

    public String getRandomTemplate()
    {
        return this.templates.get((int) (Math.random() * this.templates.size()));
    }
}
