/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amannirala13.moviebooking.models;

import java.util.ArrayList;

/**
 *
 * @author amann
 */
public final class Booking {
    
    public final static String ID = "booking_id";
    public final static String USER_ID = "user_id";
    public final static String SLOT_ID = "slot_id";
    public final static String SEATS = "seats";
    
    public int id;
    public int userID;
    public int slotID;
    public String[] seats;
    
    /**
     *
     * @param id
     * @param userID
     * @param slotID
     * @param seats
     */
    public Booking(int id, int userID, int slotID, String seats){
        this.id = id;
        this.userID = userID;
        this.slotID = slotID;
        this.seats = seats.split("[,]", 0);
    }
}
