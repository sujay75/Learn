package com.learn.java;


public class SplitParagraphIntoStrings {

    public static void main(String[] args) {
        String input = "There are other common uses for hash structures other than putting/getting though. Another typical use involves storing string keys and specific values associated with those keys, where the key has some kind of semantic value (like a name, for example). When you do this kind of thing, you usually want to grab a collection of keys that you can then process to find a specific value. This    kind of operation looks like this:";

        String arr[] = input.replace(",", " ").replace("\t", "").replace("\r", "").replace(".", "").replace(":", "").split("\\s");

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].trim());
        }
    }
}
