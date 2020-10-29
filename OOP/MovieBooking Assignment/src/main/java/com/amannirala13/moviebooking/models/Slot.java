/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amannirala13.moviebooking.models;

import java.sql.Date;

/**
 *
 * @author amann
 */
public final class Slot {
    
    public final static String ID = "slot_id";
    public final static String MOVIE_ID = "movie_id";
    public final static String START_TIME = "start_time";
    public final static String END_TIME = "end_time";
    
    
    public int id;
    public int movieID;
    public Date startTime;
    public Date endTime;
    
    /**
     *
     * @param id
     * @param movieID
     * @param startTime
     * @param endTime
     */
    public Slot(int id, int movieID, Date startTime, Date endTime){
        this.id = id;
        this.movieID = movieID;
        this.startTime = startTime;
        this.endTime = endTime;
        
    }
    
    
    
}
