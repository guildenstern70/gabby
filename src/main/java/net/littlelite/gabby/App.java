/*
 * Gabby Phrase Generator - Java Edition
 * Copyright (c) Alessio Saltarin 2023.
 * This software is licensed under ISC License (see LICENSE)
 *
 */

package net.littlelite.gabby;

/**
 * Gabby example of usage
 */
public class App 
{
    public static void main( String[] args )
    {
        IGabby gabby = GabbyFactory.create();
        System.out.println("**************************************************");
        for (int i = 0; i < 10; i++)
        {
            System.out.println(" > " + gabby.generate() );
        }
        System.out.println("**************************************************");
    }
}
