package trie;

import java.util.List;

public class SearchSuggestion {

    static class Base {
        public static void show() {
            System.out.println("Base::show() called");
        }
    }

    public static void main(String[] args) {
        Base b = new Base();
        b.show();
    }
}
