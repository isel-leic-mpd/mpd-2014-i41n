/*
 * Copyright (C) 2014 Miguel Gamboa at CCISEL
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package pt.isel.mpd14.app;

import static java.lang.Integer.parseInt;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public class Student {
    public final int nr;
    public final String name;
    public final int grade;
    public final List<Date> deliverables = new LinkedList<>();
    
    public Student(int nr, String name, int grade) {
        this.nr = nr;
        this.name = name;
        this.grade = grade;
    }
    
    public Student(String line){
        String [] tokens = line.split("\\|");
        if(tokens.length < 3) throw new IllegalArgumentException("Invalid line parameter");
        this.nr = parseInt(tokens[1]);
        this.name = tokens[3];
        this.grade = tokens.length == 5? parseInt(tokens[4]): 10;
    }    

    @Override
    public String toString() {
        return "Student{" + "nr=" + nr + ", name=" + name + ", grade=" + grade + '}';
    }

    void print() {
        System.out.println(this);
    }
       
}
