package guru.qa.heroes;

import java.util.ArrayList;

public class JsonHeroes {

        public String squadName, secretBase, homeTown;
        public int formed;

        public ArrayList<Members> members;
        public static class Members {
            public int age;
            public String name;
        }
      }


