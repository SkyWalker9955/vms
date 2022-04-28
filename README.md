### Vending Machine Software
##Argano Coding Challenge

#Short description
This is a Maven project based on Maven archetype 1889.

#How to run a project: 
1. Clone the project to your local machine.
2. Open intelliJ IDEA and select open project.
3. Select a pom.xml file if the vms folder.
4. Build and Run the project
# *Make sure dependencies installed, check pom.xml* 

#Here are all dependencies from xml file:
#JUNIT JUPITER
#JACKSON libraey for handling JSON

  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.13.2</version>
    </dependency>
    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter</artifactId>
      <version>RELEASE</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
  
  
### Description on the approach.
While is not the prettiest looking console output, the app is almost functional.
*The result you will see in the project code would reflect what I was able to come out in two days given*

I was able to manage some parts of logic with a Singleton Pattern (JsonMapper class)
And I have one unit test case just to demonstrate my familiarity with unit testing. In general I would preffer Test Drive Development (and will use the approach when will get more experience with patterns and java in general).

Besides that I tried to keep in mind user experience and a flow the user would experience while using this software. 
This project absolutely needs refinment.

##What I would do next if I had more time: 
1. finish logging functionality, making sure that each step user takes gets recorded and appended to a file that will be stored/send to a control server when program is done.
2. Make sure that the program always runs.

###Will be glad to hear your feedback on this. I learned a lot doing this project.
  
  
