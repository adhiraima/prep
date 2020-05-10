package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class AutoComplete {
    private Node trie;

    public AutoComplete() {
        this.trie = new Node('#');
    }

    public static void main(String[] args) throws Exception {
        AutoComplete ac = new AutoComplete();
        ac.constructDict();
        System.out.println("Completed the dictionary");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Prefix >> ");
        String input = scanner.nextLine();
        ac.runSearch(input);
    }

    public void runSearch(String input) {
        System.out.println(findWords(input));
    }

    private void constructDict() throws Exception {
        Scanner scanner = new Scanner(new File("/Users/adhiraima/Downloads/words.txt"));
        while(scanner.hasNextLine()) {
            String word = scanner.nextLine().trim();
            char[] chars = word.toCharArray();
            Node base = this.trie;
            for (int i = 0; i < chars.length; i++)
                base = addToTrie(new Node(chars[i]), base);
            base.complete = true;
        }
    }

    private Node addToTrie(Node n, Node base) {
        if (!base.children.contains(n))
            base.children.add(n);
        return base.getChild(n);
    }

    private List<String> findWords(String prefix) {
        List<String> result = new ArrayList<>();
        if (prefix.length() == 0) return result;
        Node base = this.trie;
        String str = "";
        char[] chars = prefix.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Node sNode = new Node(chars[i]);
            if (base.children.contains(sNode)) {
                base = base.getChild(sNode);
                str += base.value;
            }
        }

        //base is now at the node where the prefix is

        return constructWords(base.children, str, result);
    }

    private List<String> constructWords(List<Node> children, String prefix, List<String> result) {
        for (Node n : children) {
            if (n.hasChildren()) {
                StringBuffer sb = new StringBuffer(prefix).append(n.value);
                if (n.isComplete())
                    result.add(sb.toString());
                constructWords(n.children, prefix + n.value, result);
            } else {
                StringBuffer sb = new StringBuffer(prefix).append(n.value);
                result.add(sb.toString());
            }
        }
        System.out.println(result.size());
        return result;
    }


    class Node {
        char value;
        List<Node> children;
        boolean complete;

        public Node(char val) {
            this.value = val;
            this.children = new ArrayList<>();
            this.complete = false;
        }

        public boolean hasChildren() {
            return this.children.size() > 0;
        }

        public boolean isComplete() {
            return complete;
        }

        public Node getChild(Node node) {
            for (Node n : this.children) {
                if (node.equals(n)) return n;
            }
            return null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return value == node.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }
}
