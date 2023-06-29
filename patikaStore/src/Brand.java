
    import java.util.*;

    public class Brand implements Comparable<Brand> {
        private int id;
        private String name;

        private static int  count;

        public static Set<Brand> brands = new TreeSet<>();

        public Brand(){

        }
        public Brand(String name) {
            this.name = name;
            count++;
            this.id = count;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void printBrands(){
            for(Brand b:brands){
                System.out.println(b.getName());
            }
        }


        @Override
        public int compareTo(Brand o1) {
            return this.getName().compareTo(o1.getName());
        }


    }


