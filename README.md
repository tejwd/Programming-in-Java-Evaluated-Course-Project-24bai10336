# Programming-in-Java-Evaluated-Course-Project-24bai10336
# File Organizer — Java
**Student Name:** Tejasav Bhasin
**Roll Number:** 24BAI10336
**Course:** Programming in Java
**Project Type:** BYOP — Bring Your Own Project

---

## What This Project Does
File Organizer is a Java program that automatically sorts files
in a folder into organized subfolders based on their file type.

Instead of manually sorting hundreds of files, you just run
this program and it does everything automatically.

### It organizes files into:
- Images — jpg, jpeg, png, gif, bmp, svg
- Videos — mp4, mkv, avi, mov, wmv
- Documents — pdf, doc, docx, txt, ppt, xls, csv
- Music — mp3, wav, flac, aac, ogg
- Code — java, py, js, html, css, cpp
- Archives — zip, tar, gz, rar, 7z
- Others — anything else

---

## The Problem It Solves
Most people have messy Downloads or Desktop folders with
hundreds of mixed files. Sorting them manually takes time
and effort. This program solves that in seconds.

---

## How to Set It Up

### Requirements
- Java JDK 21 or above
- Any terminal or command prompt

### Installation
1. Clone this repository:
   git clone https://github.com/YOURUSERNAME/file-organizer.git

2. Go into the folder:
   cd file-organizer

3. Compile the Java file:
   javac FileOrganizer.java

---

## How to Use It

### Option 1 — Organize current folder:
java FileOrganizer

### Option 2 — Organize a specific folder:
java FileOrganizer "C:\Users\YourName\Downloads"

---

## Example Output
```
========================================
   File Organizer — Starting Up
========================================
Organizing files in: C:\Users\bhasi\file-organizer

Images    : test.jpg
Documents : test.pdf
Music     : test.mp3
Videos    : test.mp4
Archives  : test.zip
Documents : test.txt

========================================
   Organization Complete — Summary
========================================
Images    : 1 files
Videos    : 1 files
Documents : 2 files
Music     : 1 files
Archives  : 1 files
Others    : 0 files
========================================
Total files organized: 6
========================================
```

---

## Project Structure
```
file-organizer/
├── FileOrganizer.java    — main program
├── README.md             — this file
```

---

## Concepts Used
- File handling with java.io.File
- Moving files with java.nio.file.Files
- Switch statements for file type detection
- Loops to process multiple files
- Helper methods for clean code structure
