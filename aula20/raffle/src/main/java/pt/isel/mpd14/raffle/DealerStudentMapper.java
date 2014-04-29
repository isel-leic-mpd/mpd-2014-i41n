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
package pt.isel.mpd14.raffle;

import java.util.Arrays;
import org.apache.commons.lang3.StringEscapeUtils;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public class DealerStudentMapper {

    String[] tokens;
    String previous;
    
    public boolean hasStudentInfo(String line) {
        previous = line;
        
        if (line.indexOf("<td>") < 0) {
            return false;
        }
        line = line
                .replace("<td>", "|")
                .replace("</td>", "|")
                .replace("<tr>", "|")
                .replace("</tr>", "|")
                .replace("<table>", "|")
                .replace("</table>", "|");

        tokens = line.split("\\|");

        tokens = (String[]) Arrays.stream(tokens)
                .filter(s -> {
                    s = s.replaceAll("\\s+", "");
                    return s != null && !s.isEmpty();
                 })
                .toArray(cap -> new String[cap]);

        if(!tokens[0].matches("\\d+"))
            return false;
        
        return true;

    }
    
    public Student mapToStudent(String line){
        if(previous != line)
            throw new IllegalArgumentException("This mapper should be used in a stream with the hasStudentInfo as the previous filter funcion");
        
        int grade = tokens.length >= 4 ? Integer.parseInt(tokens[3]) : 10;
        
        tokens[2] = StringEscapeUtils.unescapeHtml4(tokens[2]);
                
        return new Student(
                Integer.parseInt(tokens[0]), 
                tokens[2], 
                grade);
    }
}
