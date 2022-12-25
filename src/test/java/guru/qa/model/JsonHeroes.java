package guru.qa.model;

import java.util.ArrayList;

public class JsonHeroes {
    public static class Heroes {

        public String squadName, secretBase, homeTown;
        public int formed;

        public ArrayList<Members> members;
        public static class Members {
            public int age;
            public String name;
        }
      }
    }

