📌 Project Objectives
The main goals of this project are to:

Write clean, maintainable Java code using the Red-Green-Refactor TDD cycle.
Apply unit testing best practices using JUnit 5 (Jupiter).

Learn how to validate structured numerical data using logical rules and checksum verification.

Build and manage the project using Gradle.

🧪 Validation Criteria
A South African ID number consists of 13 digits in the format:
YYMMDDSSSSCAZ


Section	Description
YYMMDD	Date of Birth (e.g. 920220 = 20 Feb 1992)
SSSS	Gender code (0000–4999 = Female, 5000–9999 = Male)
C	Citizenship (0 = SA Citizen, 1 = Permanent Resident)
A	Usually 8 or 9 (ignored in validation)
Z	Checksum digit, calculated using the Luhn algorithm
🛠️ How to Run the Project
Clone the Repository

bash
Copy
Edit
git clone https://github.com/Nosipho9/id_Validation.git
cd id_validate
Run the Unit Tests

Ensure Gradle is installed on your machine, then run:

bash
Copy
Edit
./gradlew test
All unit tests should pass if the implementation is correct.

✅ Features
✔️ Checks if the ID is numeric and exactly 13 digits
✔️ Validates the date of birth using strict formatting and rules
✔️ Determines gender based on the gender sequence
✔️ Validates the citizenship code
✔️ Calculates and verifies the checksum digit using the Luhn algorithm
✔️ Fully tested with JUnit 5
✔️ Built and managed using Gradle
