// FileOrganizer.java
// Author: [Your Name]
// Course: Programming in Java — BYOP Project
// Purpose: Automatically organizes files in a folder by their type

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileOrganizer {

    public static void main(String[] args) {

        // --- Get the target folder path from user ---
        // If no argument given, use current directory
        String targetPath;
        if (args.length > 0) {
            targetPath = args[0];
        } else {
            targetPath = System.getProperty("user.dir");
        }

        // --- Create a File object for the target directory ---
        File targetDir = new File(targetPath);

        // --- Check if the directory exists ---
        if (!targetDir.exists() || !targetDir.isDirectory()) {
            System.out.println("Error: Directory not found — " + targetPath);
            return;
        }

        System.out.println("========================================");
        System.out.println("   File Organizer — Starting Up");
        System.out.println("========================================");
        System.out.println("Organizing files in: " + targetPath);
        System.out.println("");

        // --- Create subfolders for each file type ---
        createFolder(targetPath + "/Images");
        createFolder(targetPath + "/Videos");
        createFolder(targetPath + "/Documents");
        createFolder(targetPath + "/Music");
        createFolder(targetPath + "/Code");
        createFolder(targetPath + "/Archives");
        createFolder(targetPath + "/Others");

        // --- Initialize counters ---
        int images = 0, videos = 0, docs = 0;
        int music = 0, code = 0, archives = 0, others = 0;

        // --- Get list of all files in the directory ---
        File[] files = targetDir.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("No files found in this directory.");
            return;
        }

        // --- Loop through each file ---
        for (File file : files) {

            // Skip directories
            if (file.isDirectory()) {
                continue;
            }

            // Get the file extension
            String fileName = file.getName();
            String ext = getExtension(fileName).toLowerCase();

            // Determine destination folder based on extension
            String destFolder;

            switch (ext) {
                // Image files
                case "jpg": case "jpeg": case "png":
                case "gif": case "bmp": case "svg":
                case "webp": case "ico":
                    destFolder = "Images";
                    images++;
                    break;

                // Video files
                case "mp4": case "mkv": case "avi":
                case "mov": case "wmv": case "flv":
                    destFolder = "Videos";
                    videos++;
                    break;

                // Document files
                case "pdf": case "doc": case "docx":
                case "txt": case "ppt": case "pptx":
                case "xls": case "xlsx": case "csv":
                    destFolder = "Documents";
                    docs++;
                    break;

                // Music files
                case "mp3": case "wav": case "flac":
                case "aac": case "ogg": case "m4a":
                    destFolder = "Music";
                    music++;
                    break;

                // Code files
                case "java": case "py": case "js":
                case "html": case "css": case "cpp":
                case "c": case "php": case "ts":
                    destFolder = "Code";
                    code++;
                    break;

                // Archive files
                case "zip": case "tar": case "gz":
                case "rar": case "7z": case "bz2":
                    destFolder = "Archives";
                    archives++;
                    break;

                // Everything else
                default:
                    destFolder = "Others";
                    others++;
                    break;
            }

            // --- Move the file to the destination folder ---
            try {
                Path source = Paths.get(file.getAbsolutePath());
                Path destination = Paths.get(targetPath + "/" + destFolder + "/" + fileName);
                Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
                System.out.println(destFolder + " : " + fileName);
            } catch (Exception e) {
                System.out.println("Could not move " + fileName + " — " + e.getMessage());
            }
        }

        // --- Print summary ---
        int total = images + videos + docs + music + code + archives + others;
        System.out.println("");
        System.out.println("========================================");
        System.out.println("   Organization Complete — Summary");
        System.out.println("========================================");
        System.out.println("Images    : " + images + " files");
        System.out.println("Videos    : " + videos + " files");
        System.out.println("Documents : " + docs + " files");
        System.out.println("Music     : " + music + " files");
        System.out.println("Code      : " + code + " files");
        System.out.println("Archives  : " + archives + " files");
        System.out.println("Others    : " + others + " files");
        System.out.println("========================================");
        System.out.println("Total files organized: " + total);
        System.out.println("========================================");
    }

    // --- Helper method to create a folder if it doesn't exist ---
    static void createFolder(String path) {
        File folder = new File(path);
        if (!folder.exists()) {
            folder.mkdir();
        }
    }

    // --- Helper method to get file extension ---
    static String getExtension(String fileName) {
        int lastDot = fileName.lastIndexOf(".");
        if (lastDot == -1 || lastDot == fileName.length() - 1) {
            return "";
        }
        return fileName.substring(lastDot + 1);
    }
}