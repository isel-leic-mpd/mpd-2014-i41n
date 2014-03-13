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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import pt.isel.mpd14.utils.Iters;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public class Dealer {

    
    final Path STDS_FILE = 
            FileSystems.getDefault().getPath("i41d.txt");
    final List<Student> stds;

    public Dealer() throws IOException {
        
        BufferedReader reader = 
                new BufferedReader(
                        new InputStreamReader(
                                getClass().getResourceAsStream("/i41d.txt")));
        
        try (Stream<String> lines = reader.lines()) {
            this.stds = lines.map(line -> new Student(line)).collect(Collectors.toList());
        }

    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Iters.stream(stds).forEach(s -> res.append(s).append("\n"));
        return res.toString();
    }
    
    
    public void print(){
        System.out.println(this.toString());
    }

}
