# 🔐 Custom Encryption-Decryption Tool (Java)

A desktop-based Java application for encrypting and decrypting text files using **AES-128** and a custom **Vigenère Cipher**. Built with Java Swing, it features an intuitive GUI and requires **no database or external libraries**.

---

## 🚀 Features

- 🔒 AES-128 Encryption/Decryption (Java Crypto API)
- 🧠 Custom Vigenère Cipher Implementation
- 📂 Load and Save Text Files
- 🖥️ Simple Swing GUI — No command line needed
- ✅ AES Key Validation (16 characters)
- 💬 Popup notifications on success/error

---

## 🧪 Demo

![App Screenshot](screenshot.png) <!-- Replace with your actual image -->

---

## 🛠️ Installation & Usage

### Requirements
- Java 8 or higher

### Run Locally

```bash
# Compile


CustomEncryptionTool/
├── src/
│   ├── AESCipher.java
│   ├── VigenereCipher.java
│   ├── FileHandler.java
│   └── EncryptionToolGUI.java
├── .gitignore
├── README.md


javac -d out src/*.java

# Run
java -cp out EncryptionToolGUI



🔑 Usage Notes
AES requires a key of exactly 16 characters.

Vigenère cipher works only on alphabetic characters.

Use Load File to import a .txt file, and Save Output to store results.



