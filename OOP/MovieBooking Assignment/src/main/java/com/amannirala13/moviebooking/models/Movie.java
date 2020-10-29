/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amannirala13.moviebooking.models;

/**
 *
 * @author amann
 */
public final class Movie {
    
    public final static String ID = "movie_id";
    public final static String TITLE = "title";
    public final static String DESCRIPTION = "description";
    public final static String CAST = "cast";
    public final static String DIRECTOR = "director";
    public final static String PRODUCER = "producer";
    public final static String YEAR = "year";
    
    public int id;
    public String title;
    public String description;
    public String cast;
    public String director;
    public String producer;
    public int year;
    
    /**
     *
     * @param id
     * @param title
     * @param description
     * @param cast
     * @param director
     * @param producer
     * @param year
     */
    public Movie(int id,
            String title,
            String description,
            String cast,
            String director,
            String producer,
            int year){
                this.id = id;
                this.title = title;
                this.description = description;
                this.cast = cast;
                this.director = director;
                this.producer = producer;
            }
    
    
}
