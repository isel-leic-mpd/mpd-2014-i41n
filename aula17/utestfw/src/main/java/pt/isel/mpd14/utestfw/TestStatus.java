/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.utestfw;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public abstract class TestStatus{
    
    final String testName;

    public TestStatus(String testName) {
        this.testName = testName;
    }
        
}
