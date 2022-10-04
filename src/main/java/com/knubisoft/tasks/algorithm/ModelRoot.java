package com.knubisoft.tasks.algorithm;

import com.knubisoft.tasks.algorithm.reflection.AnnotationReflection;
import lombok.*;

import java.util.List;

/**
 * TODO fix model
 *
 * @see json and xml file
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ModelRoot {

    public List<Item> items;
    @NoArgsConstructor
    @Data
    public static class Batter {
        public String id;
        @AnnotationReflection
        public String type;

        public Batter(String id){
            this.id = id;
        }
        public Batter(String id, String type){
            this.id = id;
            this.type = type;
        }
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
