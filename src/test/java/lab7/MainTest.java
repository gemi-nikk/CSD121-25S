package lab7;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testGetQuickRecipesReturnsEmptyListIfNoData() {
        var recipes = Main.getQuickRecipes(List::of);
        assertEquals(0, recipes.size());
    }

    @Test
    void testGetQuickRecipesReturnsEmptyListIfNoQuickRecipes() {
        var recipes = Main.getQuickRecipes(() -> List.of(
                new Recipe(0, "", "", "", 4, 10, 10, 16),
                new Recipe(1, "", "", "", 4, 10, 10, 20),
                new Recipe(2, "", "", "", 4, 10, 10, 200)
        ));
        assertEquals(0, recipes.size());
    }

    @Test
    void testGetQuickRecipesReturnsAllRecipesIfAllQuick() {
        var recipes = Main.getQuickRecipes(() -> List.of(
                new Recipe(0, "", "", "", 4, 10, 10, 15),
                new Recipe(1, "", "", "", 4, 5, 5, 10)
        ));
        assertEquals(2, recipes.size());
    }

    // ---------- searchRecipes tests ----------

    @Test
    void testSearchRecipesFindsCorrectMatches() {
        DataService mockService = () -> List.of(
                new Recipe(0, "Chicken Soup", "Warm and tasty", "", 4, 10, 10, 30),
                new Recipe(1, "Beef Stew", "Hearty and filling", "", 4, 15, 15, 45)
        );

        var results = Main.searchRecipes("chicken", mockService);
        assertEquals(1, results.size());
        assertEquals("Chicken Soup", results.get(0).name());
    }

    @Test
    void testSearchRecipesSearchesDescription() {
        DataService mockService = () -> List.of(
                new Recipe(0, "Soup", "Contains chicken pieces", "", 4, 10, 10, 20),
                new Recipe(1, "Salad", "Fresh greens", "", 4, 5, 5, 10)
        );

        var results = Main.searchRecipes("chicken", mockService);
        assertEquals(1, results.size());
        assertEquals("Soup", results.get(0).name());
    }

    @Test
    void testSearchRecipesCaseInsensitive() {
        DataService mockService = () -> List.of(
                new Recipe(0, "CHICKEN Curry", "Spicy delight", "", 4, 20, 20, 40)
        );

        var results = Main.searchRecipes("chicken", mockService);
        assertEquals(1, results.size());
    }

    @Test
    void testSearchRecipesReturnsEmptyWhenNoMatch() {
        DataService mockService = () -> List.of(
                new Recipe(0, "Pasta", "Italian classic", "", 4, 15, 15, 25)
        );

        var results = Main.searchRecipes("chicken", mockService);
        assertTrue(results.isEmpty());
    }

    @Test
    void testSearchRecipesHandlesException() {
        DataService mockService = () -> { throw new RuntimeException("DB error"); };

        var results = Main.searchRecipes("anything", mockService);
        assertTrue(results.isEmpty());
    }
}
