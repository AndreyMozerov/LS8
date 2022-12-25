package guru.qa.model;

import java.util.ArrayList;

public class JsonHeroes {
    public static class Heroes {

        public String squadName;
        public String homeTown;
        public int formed;
        public String secretBase;
        public ArrayList<Members> members;

        public static class Members {
            public int age;
            public String name;
        }
     }
    }

