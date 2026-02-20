import java.util.*;

class FoodRatings {
        Map<String, String> foodToCuisine = new HashMap<>();
        Map<String, Integer> foodToRating = new HashMap<>();
        Map<String, TreeSet<String>> cuisineToFoods = new HashMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
                for (int i = 0; i < foods.length; i++) {
                        String f = foods[i];
                        String c = cuisines[i];
                        int r = ratings[i];

                        foodToCuisine.put(f, c);
                        foodToRating.put(f, r);

                        cuisineToFoods.putIfAbsent(c, new TreeSet<>((a, b) -> {
                                int ra = foodToRating.get(a);
                                int rb = foodToRating.get(b);
                                if (ra != rb)
                                        return rb - ra;
                                return a.compareTo(b);
                        }));
                        cuisineToFoods.get(c).add(f);
                }
        }

        public void changeRating(String f, int newRating) {
                String c = foodToCuisine.get(f);
                TreeSet<String> set = cuisineToFoods.get(c);
                set.remove(f);
                foodToRating.put(f, newRating);
                set.add(f);
        }

        public String highestRated(String c) {
                return cuisineToFoods.get(c).first();
        }
}
