# Resume Builder

This project generates a resume from user input using Starter Web from Spring. 

The project:

- Stores user inputs into variables then to separate classes under a Resume class.
- Parses those variables into lists using Java.
- Using the parsed/processed data, generates an HTML page using Bootstrap and Thymeleaf from Spring.

## Instructions

1. Run `mvn spring-boot:run`.
2. Go to [http://localhost:8080/](http://localhost:8080/).
3. Fill in "Basic Information." LinkedIn, GitHub, and Website aren't required.
4. Add necessary "parts" of the resume (education, experience, certification, project, skill).
5. Press the `Generate resume` button.
6. Modifications can be done on the result page with the ability to add hyperlinks to texts using
the `Add Link` button on the bottom right.
7. Press control/command + P to export the HTML page into a PDF file.