package com.dorjear.training.fundamental.file;

import java.io.File;

public class RenameJsonToFeature {
    public static void main(String[] args) {
        File directory = new File("src/main/resources/files");
        renameFiles(directory);
    }

    private static void renameFiles(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    renameFiles(file);
                } else if (file.getName().endsWith(".json")) {
                    String newName = file.getName().replace(".json", ".feature");
                    File newFile = new File(file.getParent(), newName);
                    if (!file.renameTo(newFile)) {
                        System.err.println("Failed to rename " + file.getName());
                    }
                }
            }
        }
    }
}