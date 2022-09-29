package com.knubisoft.tasks.algorithm;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * TODO fix model
 *
 * @see json and xml file
 */
@Getter
@Setter
public class ModelRoot {

    public List<Item> items;

    public static class Batter {
        public String id;
        public String type;
    }
    @Getter
    @Setter
    public static class Item {
        public int id;
        public String type;
        public String name;
        public double ppu;
        public Batters batters;
        public List<Topping> topping;
    }
    @Getter
    @Setter
    public static class Batters {
        public List<Batter> batter;
    }
    @Getter
    @Setter
    public static class Topping {
        public String id;
        public String type;
    }

}
