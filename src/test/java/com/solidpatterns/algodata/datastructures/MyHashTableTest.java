package com.solidpatterns.algodata.datastructures;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MyHashTableTest {

    private final String catName = "caillou";

    private class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    @Test
    public void should_add_when_called_add() {
        MyHashTable<String, Cat> myHashTable = getMyHashTableWithSingleEntry();
    }

    @Test
    public void should_add_when_called_add_with_null_value() {
        MyHashTable<String, Cat> myHashTable = new MyHashTable<>();
        myHashTable.add(catName, null);
    }

    @Test
    public void should_get_when_called_get_for_an_existing_key() {
        MyHashTable<String, Cat> myHashTable = getMyHashTableWithSingleEntry();
        assertNotNull(myHashTable.get(catName));
    }

    @Test
    public void should_get_each_key_separately_when_called_get_with_distinct_keys() {
        MyHashTable<String, Cat> myHashTable = getMyHashTableWithSingleEntry();
        String catName2 = "lila";
        myHashTable.add(catName2, new Cat(catName2));
        String catName3 = "papyon";
        myHashTable.add(catName3, new Cat(catName3));

        assertAll("Should return 3 distinct entries",
                () -> assertEquals(catName, myHashTable.get(catName).getName()),
                () -> assertEquals(catName2, myHashTable.get(catName2).getName()),
                () -> assertEquals(catName3, myHashTable.get(catName3).getName()));
    }

    @Test
    public void should_replace_existing_entry_when_set_with_same_key() {
        MyHashTable<String, Cat> myHashTable = getMyHashTableWithSingleEntry();
        String catNameNew = "caillouNew";
        myHashTable.add(catName, new Cat(catNameNew));
        assertEquals(catNameNew, myHashTable.get(catName).getName());
    }

    @Test
    public void should_throw_illegal_argument_exception_when_called_add_with_null_key() {
        MyHashTable<String, Cat> myHashTable = new MyHashTable<>();
        String catName = "caillou";
        assertThrows(IllegalArgumentException.class, () -> myHashTable.add(null, new Cat(catName)));
    }

    @Test
    public void should_remove_when_called_remove_with_existing_key() {
        MyHashTable<String, Cat> myHashTable = getMyHashTableWithSingleEntry();
        assertAll("Should return true for remove and null for get",
                () -> assertTrue(myHashTable.remove(catName)),
                () -> assertNull(myHashTable.get(catName)));
    }

    @Test
    public void should_return_false_when_removed_non_existing_key() {
        MyHashTable<String, Cat> myHashTable = getMyHashTableWithSingleEntry();
        assertFalse(myHashTable.remove("non_existing_key"));
    }

    private MyHashTable<String, Cat> getMyHashTableWithSingleEntry() {
        MyHashTable<String, Cat> myHashTable = new MyHashTable<>();
        myHashTable.add(catName, new Cat(catName));
        return myHashTable;
    }
}