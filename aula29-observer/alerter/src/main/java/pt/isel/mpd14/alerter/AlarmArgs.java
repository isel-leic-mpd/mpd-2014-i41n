/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.alerter;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
class AlarmArgs {
    final int nrEvent;
    final long eventTime;

    public AlarmArgs(int nrEvent, long eventTime) {
        this.nrEvent = nrEvent;
        this.eventTime = eventTime;
    }

    
   
}
