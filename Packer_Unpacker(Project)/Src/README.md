# 📦 File Packer-Unpacker

A command-line Java utility that merges multiple `.txt` files from a directory into a single encrypted packed file, and extracts them back on demand.

Built as part of MCA coursework to explore low-level file I/O, byte-level encryption, binary file format design, and file authentication in Java.

---

## 🔍 What It Does

### Packing
- Accepts a source directory and output file name from the user
- Checks if output file already exists — rejects if it does (overwrite protection)
- Writes a **4-byte magic number** at the start of the packed file
- Scans the directory for all `.txt` files
- For each file writes a **100-byte fixed-width header** containing file name and size
- Applies **XOR encryption** (`0x11`) to all file content before writing
- Marks the packed file as **read-only** after packing is complete

### Authentication
- A separate `isValidPackedFile()` method reads the first 4 bytes
- Compares them against the magic number `{0x50, 0x4B, 0x55, 0x11}`
- Called from `Main` before unpacking — invalid files are rejected immediately

### Unpacking
- Validates the packed file using magic number before doing anything
- Skips the first 4 magic bytes after opening
- Reads each 100-byte header to get file name and size
- Allocates a buffer of exactly that size, reads and decrypts content
- Recreates each original file in the current working directory

---

## 📁 Project Structure

```
FilePacker-Unpacker/
├── src/
│   └── Main.java       # FilePackerUnpacker class + Main class
├── MyFiles/            # Sample directory with .txt files for testing
└── README.md
```

> `Main.java` contains the `FilePackerUnpacker` class with all packing, unpacking, and authentication logic, and the `Main` class as the entry point.

---

## 🏗️ Packed File Format

```
[ 4 bytes   — Magic Number           ]
[ 100 bytes — Header : file 1        ]
[ N bytes   — Encrypted content : 1  ]
[ 100 bytes — Header : file 2        ]
[ N bytes   — Encrypted content : 2  ]
...
```

**Header format** (exactly 100 bytes, space-padded):
```
<filename> <filesize_in_bytes>
```

Example:
```
notes.txt 2048                                                (padded to 100 bytes)
```

---

## 🔐 Security Features

| Feature | Detail |
|---|---|
| XOR Encryption | Each byte XORed with key `0x11` before writing |
| Magic Number | `{0x50, 0x4B, 0x55, 0x11}` written at start of every packed file |
| Authentication | `isValidPackedFile()` validates magic number before unpacking |
| Overwrite Protection | Rejects packing if output file name already exists |
| Read-Only | Packed file set to read-only after packing using `setReadOnly()` |

---

## ⚙️ How to Run

### Prerequisites
- Java JDK 8 or above
- Terminal / Command Prompt

### How to Run

```bash
javac Main.java
java Main
```

You will be prompted:
```
Enter Name Of Directory:
> MyFiles

Enter Name Of Packed File:
> output.pak

Enter Name Of Packed File To Unpack:
> output.pak
```

---

## ⚠️ Current Limitations

- Only `.txt` files are packed — other file types in the directory are skipped
- Duplicate file names not handled — second file overwrites first during unpacking
- No MD5 checksum validation
- No log file generation
- XOR key is hardcoded — not configurable at runtime
- Unpacked files are recreated in current working directory only

---

## 🚀 Planned Improvements

- [ ] Support all file types, not just `.txt`
- [ ] Handle duplicate file names by appending counter (`notes(1).txt`)
- [ ] Add MD5 checksum per file for integrity verification
- [ ] Generate a log file recording each pack/unpack operation
- [ ] Make XOR key configurable at runtime
- [ ] Add a Swing-based GUI with file browser dialogs for ease of use

---

## 🛠️ Tech Stack

| Component | Detail |
|---|---|
| Language | Java JDK 8+ |
| I/O | `FileInputStream`, `FileOutputStream` |
| User Input | `Scanner` |
| Encryption | XOR Cipher (`0x11`) |
| Authentication | Magic Number (`0x50 0x4B 0x55 0x11`) |
| Interface | CLI |
| Platform | Windows / Linux |

---

## 📄 License

MIT License — see [LICENSE](LICENSE) for details.