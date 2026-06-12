# 📚 Student Study Tracker

A console-based Java application to help students log, track, summarize, and export their daily study sessions.

---

## 🔍 Overview

Student Study Tracker lets you maintain a structured record of your study activities directly from the terminal. You can log sessions by subject, view summaries grouped by date or subject, and export everything to a CSV file for offline reference.

Built entirely with **Core Java** — no external libraries or frameworks required.

---

## ✨ Features

| Feature | Description |
|---|---|
| **Insert Study Log** | Record subject, duration (hours), and description; date is auto-captured |
| **View All Logs** | Display all study sessions stored in the current session |
| **Summary by Date** | Total study hours grouped per day |
| **Summary by Subject** | Total study hours grouped per subject |
| **Export to CSV** | Export all logs to `StudentStudyTracker.csv` for offline use |
| **Menu-driven UI** | Simple numbered console menu with switch-case navigation |

---

## 🛠️ Tech Stack

- **Language:** Java (JDK 8+)
- **APIs & Packages:**
  - `java.util.*` — `ArrayList`, `TreeMap`, `Scanner`
  - `java.time.LocalDate` — auto-captures current date
  - `java.io.*` — CSV file export via `FileWriter`

---

## 🗂️ Project Structure

```
StudyTracker/
├── Src/
│   └── StudentStudyTracker.java   
├── README.md
└── LICENSE
```

### Classes in `StudentStudyTracker.java`

**`StudyLog`**
- Fields: `LocalDate Date`, `String Subject`, `double Duration`, `String Description`
- Constructor, getters, `toString()`

**`StudyTracker`**
- Holds `ArrayList<StudyLog>` as in-memory storage
- Methods: `insertLog()`, `displayLog()`, `exportToCSV()`, `SummaryByDate()`, `SummaryBySubject()`

**`StudentStudyTracker`** *(Main Class)*
- Contains `main()` — handles menu loop and user input via `do-while` + `switch-case`, delegates to `StudyTracker`

---

## ▶️ How to Run

**Prerequisites:** JDK 8 or above installed

```bash
# Clone the repository
cd student-study-tracker/Src

# Compile
javac StudentStudyTracker.java

# Run
java StudentStudyTracker
```

---

## 💻 Sample Console Flow

```
-----------------------------------------------------
--------Welcome To Study Tracker-----------
-----------------------------------------------------
Please select Appropriate Option:
1.Insert New StudyLog
2.View All  StudyLog
3.Export Study Log To CSV file
4.Summary Of StudyLog by Date
5.Summary Of StudyLog by Subject
6.EXIT

Enter choice: 1

-----------------------------------------------------
-----------Enter Valid Detais Of Your Study----------
-----------------------------------------------------
Please Enter Name Of Subject: Java Programming
Enter Time Period Of Your Study(Hrs): 2.5
Enter Description Of Study: Practiced ArrayList and TreeMap

Data Gets Stored Sucessfully.........
```

---

## 📄 Sample CSV Output (`StudentStudyTracker.csv`)

```
Date,Subject,Duration,Description
2025-09-13,Java Programming,2.5,Practiced ArrayList and TreeMap
2025-09-13,Database,1.5,Revised SQL Joins
```

---

## 📌 Key Concepts Demonstrated

- Object-Oriented Design — three classes in a single file (`StudyLog`, `StudyTracker`, main)
- Java Collections — `ArrayList` for in-memory storage, `TreeMap` for sorted grouping by date and subject
- File I/O — CSV export using `FileWriter` with try-with-resources
- `LocalDate` API for automatic date capture
- Console menu using `do-while` loop and `switch-case`

---

## 🚀 Possible Improvements

- [ ] Persist logs across sessions using file-based or database storage
- [ ] Add edit and delete log functionality
- [ ] Weekly/monthly summary view
- [ ] GUI using JavaFX or Swing

---

## 📝 License

This project is open source and available under the [MIT License](LICENSE).