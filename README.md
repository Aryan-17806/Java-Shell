# $ Build Your Own Shell in Java

A Unix-inspired command-line shell built **from scratch in Java**.

This project is designed to explore how shells work internally — from reading and parsing commands to executing processes, handling pipelines, managing file descriptors, implementing tab completion, and interacting with the operating system.

The project follows a progressive **Build Your Own Shell** roadmap, with each phase introducing a deeper systems-programming concept.

> 🚧 **Current Status: Phase 1 — Basic Shell Functionality**

---

## 🎯 Project Objective

The goal of this project is to build a functional shell without relying on an existing shell implementation.

Instead of simply executing commands through `cmd`, PowerShell, Bash, or another shell, this project implements the shell logic directly in Java.

The project focuses on understanding:

* Command-line interfaces
* Command parsing
* Environment variables
* `PATH` resolution
* Process creation
* Standard input/output/error
* File descriptors
* Pipes
* Redirection
* Signals
* Autocompletion
* Command history
* Shell architecture
* Operating-system interaction

---

# 🚀 Features

The shell is being developed incrementally.

## Phase 1 — Basic Shell

* [x] Initialize shell
* [x] Display interactive prompt
* [x] Read user input
* [x] Parse command name
* [x] Implement `exit`
* [x] Implement `echo`
* [x] Implement `type`
* [x] Detect shell built-ins
* [x] Search executables using `PATH`
* [x] Detect Windows `.exe` executables
* [x] Display `command not found` errors

### Example

```text
$ echo Hello World
Hello World

$ type echo
echo is a shell builtin

$ type java
java is C:\Program Files\Java\...\java.exe

$ type unknown
unknown: not found
```

---

# Phase 2 — Command Execution

The next stage is to make the shell capable of actually launching external programs.

* [ ] Locate external commands
* [ ] Execute external programs
* [ ] Pass command-line arguments
* [ ] Handle program exit status
* [ ] Display execution errors
* [ ] Improve process handling

### Target Example

```text
$ java Main
Hello from Java

$ python test.py
Hello World
```

---

# Phase 3 — Built-in Commands

Expand the shell with commonly used built-in commands.

* [ ] `pwd`
* [ ] `cd`
* [ ] Environment-variable handling
* [ ] Additional shell built-ins
* [ ] Correct handling of built-ins vs external programs

### Target Example

```text
$ pwd
C:\Users\Aryan\Desktop

$ cd projects

$ pwd
C:\Users\Aryan\Desktop\projects
```

---

# Phase 4 — Command Arguments & Parsing

Improve the command parser so the shell can correctly understand complex commands.

* [ ] Multiple arguments
* [ ] Whitespace handling
* [ ] Empty arguments
* [ ] Quoted strings
* [ ] Single quotes
* [ ] Double quotes
* [ ] Escape characters
* [ ] Special characters
* [ ] Improved tokenizer/parser

### Target Example

```text
$ echo "Hello World"
Hello World

$ echo 'Hello World'
Hello World
```

---

# Phase 5 — Input & Output Redirection

Implement shell-style redirection using standard streams and files.

* [ ] Standard output redirection
* [ ] Standard input redirection
* [ ] Append output
* [ ] Standard error redirection
* [ ] Redirect stdout and stderr
* [ ] File creation and writing
* [ ] File descriptor handling

### Target Example

```text
$ echo Hello > output.txt

$ cat output.txt
Hello

$ echo Another >> output.txt
```

---

# Phase 6 — Pipes

Implement pipelines so the output of one process can become the input of another process.

* [ ] Parse `|`
* [ ] Create multiple processes
* [ ] Connect process stdout to process stdin
* [ ] Support multiple pipelines
* [ ] Handle pipeline errors

### Target Example

```text
$ cat file.txt | grep Java
Java
Java Shell
```

Multiple commands:

```text
$ cat file.txt | grep Java | wc
```

---

# Phase 7 — Process & Signal Handling

Explore how shells interact with running processes.

* [ ] Process management
* [ ] Process exit status
* [ ] Signal handling
* [ ] Interrupt handling
* [ ] Graceful process termination
* [ ] Foreground process handling

### Example

```text
$ long-running-program

^C
```

The shell should remain usable after the child process is interrupted.

---

# Phase 8 — Tab Completion

Add interactive command completion.

* [ ] Detect TAB key
* [ ] Complete built-in commands
* [ ] Complete executable commands
* [ ] Complete file names
* [ ] Complete directory names
* [ ] Handle multiple matching commands
* [ ] Display completion suggestions

### Target Example

```text
$ ec<TAB>
echo
```

---

# Phase 9 — Command History

Implement command history functionality.

* [ ] Store previously executed commands
* [ ] Navigate through history
* [ ] Up-arrow history
* [ ] Down-arrow history
* [ ] History persistence
* [ ] History management

### Target Example

```text
$ echo Hello
Hello

$ java Main
...

$ ↑
java Main

$ ↑
echo Hello
```

---

# Phase 10 — Advanced Shell Features

The final stage focuses on making the shell more complete and robust.

* [ ] Advanced command parsing
* [ ] Improved quoting and escaping
* [ ] Advanced redirection
* [ ] Multiple pipelines
* [ ] Better process management
* [ ] Improved error handling
* [ ] Interactive terminal behavior
* [ ] Cross-platform compatibility
* [ ] Performance improvements
* [ ] Cleaner shell architecture

---

# 🧩 Architecture

The shell is designed around a simple command-processing pipeline:

```text
User Input
    │
    ▼
Command Parser
    │
    ▼
Command Identification
    │
    ├── Built-in Command
    │
    └── External Command
             │
             ▼
       PATH Resolution
             │
             ▼
       Process Execution
             │
             ▼
      Input / Output Handling
             │
             ▼
        Shell Prompt
```

As additional phases are implemented, the architecture will expand to support:

```text
Input
  │
  ▼
Lexer / Parser
  │
  ├── Built-ins
  │
  ├── External Commands
  │
  ├── Redirection
  │
  └── Pipelines
          │
          ▼
      Processes
          │
          ▼
   stdin / stdout / stderr
```

---

# 🛠️ Technology Stack

| Technology                    | Purpose                    |
| ----------------------------- | -------------------------- |
| **Java**                      | Core implementation        |
| **Java Scanner / Input APIs** | Reading user input         |
| **java.io.File**              | File-system operations     |
| **ProcessBuilder**            | External process execution |
| **Java I/O Streams**          | Input/output redirection   |
| **Environment Variables**     | PATH and shell environment |
| **Git**                       | Version control            |
| **GitHub**                    | Source-code hosting        |

---

# 📁 Project Structure

The project will evolve as more functionality is added.

```text
java-shell/
│
├── src/
│   └── Main.java
│
├── README.md
├── .gitignore
└── ...
```

A more modular structure may eventually look like:

```text
java-shell/
│
├── src/
│   ├── Main.java
│   ├── Shell.java
│   ├── Parser.java
│   ├── CommandExecutor.java
│   ├── Builtins.java
│   ├── ProcessManager.java
│   ├── PathResolver.java
│   └── Terminal.java
│
├── README.md
├── .gitignore
└── LICENSE
```

---

# ▶️ Getting Started

## Requirements

* Java JDK 8 or higher
* Git

Check Java:

```bash
java --version
```

Check the compiler:

```bash
javac --version
```

---

## Clone the Repository

```bash
git clone <YOUR_REPOSITORY_URL>
cd <YOUR_REPOSITORY_NAME>
```

---

## Compile

```bash
javac Main.java
```

---

## Run

```bash
java Main
```

The shell will display:

```text
$
```

You can now enter commands.

---

# 🧪 Testing

The shell is tested incrementally after each phase.

### Basic commands

```text
$ echo Hello
Hello

$ echo Hello World
Hello World
```

### Built-in detection

```text
$ type echo
echo is a shell builtin

$ type exit
exit is a shell builtin

$ type type
type is a shell builtin
```

### PATH lookup

```text
$ type java
java is C:\...\java.exe
```

### Unknown command

```text
$ type abcxyz
abcxyz: not found
```

As new phases are completed, additional test cases will be added.

---

# 📊 Development Progress

| Phase | Feature                    | Status                          |
| ----- | -------------------------- | ------------------------------- |
| 1     | Basic Shell                | ✅ In Progress / Mostly Complete |
| 2     | External Command Execution | ⬜ Not Started                   |
| 3     | Built-in Commands          | ⬜ Not Started                   |
| 4     | Arguments & Parsing        | ⬜ Not Started                   |
| 5     | I/O Redirection            | ⬜ Not Started                   |
| 6     | Pipes                      | ⬜ Not Started                   |
| 7     | Process & Signal Handling  | ⬜ Not Started                   |
| 8     | Tab Completion             | ⬜ Not Started                   |
| 9     | Command History            | ⬜ Not Started                   |
| 10    | Advanced Features          | ⬜ Not Started                   |

> The progress table will be updated as development continues.

---

# 📚 What This Project Demonstrates

After completing the complete roadmap, this project will demonstrate practical knowledge of:

* Java programming
* Object-oriented design
* Data parsing
* Lexical analysis
* File-system APIs
* Environment variables
* Operating-system processes
* Process management
* Inter-process communication
* Standard streams
* File descriptors
* Input/output redirection
* Unix-style pipelines
* Terminal interaction
* Signal handling
* CLI application design
* Error handling
* Cross-platform development

---

# 🎓 Learning Goals

The project is intended to provide hands-on experience with concepts that are normally hidden behind high-level APIs.

Instead of simply writing:

```java
Runtime.getRuntime().exec(...);
```

the project explores what happens around command execution:

```text
User
 │
 ▼
Shell
 │
 ├── Parse command
 │
 ├── Find executable
 │
 ├── Create process
 │
 ├── Connect stdin/stdout/stderr
 │
 ├── Handle pipes/redirection
 │
 └── Wait for process
       │
       ▼
    Operating System
```

---

# 📈 Future Improvements

After completing the main roadmap, possible improvements include:

* Better modular architecture
* Unit and integration tests
* Cross-platform support for Windows/Linux/macOS
* Improved terminal rendering
* Configuration files
* Custom shell prompts
* Environment management
* More built-in commands
* Performance optimization
* Comprehensive documentation

---

# 👨‍💻 Author

**Aryan Singh**

A systems-programming project built to understand how command-line shells work internally using Java.

---

# 📜 License

This project is created for educational and learning purposes.

---

## ⭐ Project Status

**🚧 Work in Progress**

The shell is being developed phase-by-phase.

The current implementation focuses on **Phase 1**, while future phases will progressively introduce process execution, parsing, redirection, pipelines, process management, tab completion, history, and other advanced shell capabilities.

⭐ If you find this project interesting, consider giving the repository a star.
