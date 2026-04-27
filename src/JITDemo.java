public class JITDemo {

    public static void main(String[] args) {

        // First run
        long start1 = System.currentTimeMillis();
        runLoop();
        long end1 = System.currentTimeMillis();

        // Second run (should be faster due to JIT)
        long start2 = System.currentTimeMillis();
        runLoop();
        long end2 = System.currentTimeMillis();

        System.out.println("First Run Time: " + (end1 - start1) + " ms");
        System.out.println("Second Run Time: " + (end2 - start2) + " ms");
    }

    public static void runLoop() {
        for (int i = 0; i < 100000000; i++) {
            int x = i * i;
        }
    }
}





Experiment 4

Practical Exercise: Build and Run a Java Application with Maven, Migrate the Same Application to Gradle

Part 1: Create and Build a Java Application with Maven

Step 1: Create a Maven Project in IntelliJ IDEA

1. Open IntelliJ IDEA

Launch IntelliJ IDEA and click on File → New→ Project.

2. Select Maven

In the New Project window, choose Maven from the options on the left.

Check Create from archetype and select maven-archetype-quickstart.

Click Next.

3. Enter Project Details

GroupId: com.example

ArtifactId: MVNGRDLDEMO

Click Next and then Finish.

4. Wait for IntelliJ to Load Dependencies

IntelliJ will automatically download the Maven dependencies, so just relax for a moment.

Step 2: Update pom.xml to Add Build Plugin To compile and package your project into a jar file, you need to add the Maven Compiler and

Jar plugins.

a) 1. Open the pom.xml file.

2. Add the following inside the <project> tag:

<build>

<plugins>

<!-- Compiler Plugin -->

<plugin>

<groupId>org.apache.maven.plugins</groupId>

<artifactId>maven-compiler-plugin</artifactId>

<version>3.8.1</version>

<configuration>

<source>1.8</source>

<target>1.8</target>

</configuration>

</plugin>

<!-- Jar Plugin -->

<plugin>

<groupId>org.apache.maven.plugins</groupId>

<artifactId>maven-jar-plugin</artifactId>

<version>3.2.0</version>

<configuration>
<archive>

<manifest>

<addClasspath>true</addClasspath>

<mainClass>org.example.Main</mainClass>

</manifest>

</archive>

</configuration>

</plugin>

</plugins>

</build>

b) 1. Open the Main.java file. 2. Add the following code package org.example;

public class Main

static void main() {

System.out.println("Hello students"); System.out.println("Welcome to Devops Lab"); System.out.println("Lab Program no.4");


Step 3: Build and Run the Maven Project

1. Open IntelliJ IDEA Terminal

Press Alt + F12 to open the terminal.

2. Compile and Package the Project

Run the following commands to build the project:

mvn clean compile

mvn package

3. Locate the JAR File

After running the above, your jar file will be located at: D: \Idea Projects\MVNGRDLDEMO\target MVNGRDLDEMO-1.0-SNAPSHOT.jar

4. Run the JAR File

To run the generated JAR file, use: java -jar target\MVNGRDLDEMO-1.0-SNAPSHOT.jar

Part 2: Migrate Maven Project to Gradle

Step 1: Initialize Gradle in Your Project 1. Open Terminal in IntelliJ IDEA Make sure you're in the project directory: cd "D:\Idea Projects MVNGRDLDEMO
2. Run Gradle Init Command
Execute the following command to migrate your Maven project to Gradle:
gradle init --type pom
This command will convert your Maven pom.xml into a Gradle build.gradle file.
Step 2: Review and Update build.gradle
Open build.gradle in IntelliJ IDEA.
Ensure the following configurations are correct:
plugins {
id 'java'
}
group = 'com.example'
version = '1.0-SNAPSHOT'
repositories {
mavenCentral()
}
dependencies {
testImplementation 'junit:junit:4.13.2'
}
jar {
manifest {
attributes('Main-Class': 'org.example.Main')
}
}
Step 3: Build and Run the Gradle Project
1. Clean and Build the Project
To clean and build your Gradle project, run:
gradle clean build
2. Run the Generated JAR File
Now, run the generated JAR file using:
java -jar build/libs/MVNGRDLDEMO-1.0-SNAPSHOT.jar





  
6

Experiment 6
Continuous Integration with Jenkins
What is a CI Pipeline?
A Continuous Integration (CI) Pipeline automates the process of building, testing, and integrating code changes every time code is committed to the repository. This pipeline:
Automatically checks out the latest code.
Compiles the application.
Runs tests to catch errors early.
Notifies the team of build/test results.
Why Use Jenkins for CI?
Automation: Jenkins automates the build and test cycle, reducing manual intervention.
Immediate Feedback: Developers get rapid notifications of any integration issues.
Extensibility: With hundreds of plugins available, Jenkins can integrate with version control systems, build tools (Maven, Gradle), testing frameworks, and more.
Pipeline as Code: Using Jenkins Pipelines (defined in a Jenkinsfile), you can manage the CI process as part of your source code repository.
Prerequisites
Before proceeding, ensure the following:
✅ Jenkins is installed and running on your system.
✅ Git is installed and configured in Jenkins. (Verify with git --version.)
✅ Maven is installed and configured in Jenkins. (Check with mvn -version.)
✅ Selenium Maven Project is ready with test cases ( src/test/java ).
✅ Project is stored in two places:
Locally on your system (e.g., D:\Idea Projects\MVNGRDLDEMO).
Pushed to GitHub with a valid repository link.
✅ Jenkins has access to the GitHub repository (via credentials).
Before doing experiment 6, we need to open the command prompt and type:
java -jar jenkins.war
1. Running a Selenium Java Test from a Local Maven Project
Step 1: Create a New Jenkins Job
Go to Jenkins Dashboard → Click New Item.
Enter a project name → Select Freestyle Project.
Click OK.
Step 2: Configure the Build Step
Scroll to Build → Click Add build step → Execute Windows Batch Command.
Enter the following commands (ensure correct navigation to project directory):
    cd D:\Idea Projects\MVNGRDLDEMO
mvn test
    Click Save → Click Build Now to execute the test.
2. Running Selenium Tests from a GitHub Repository via Jenkins
Step 1: Set Up a New Jenkins Job for GitHub Project
Go to Jenkins Dashboard → Click New Item.
Enter a project name → Select Freestyle Project.
Click OK.
Step 2: Configure Git Repository in Jenkins
Under Source Code Management, select Git.
Enter your GitHub repository URL (e.g., https://github.com/your-repo-name.git).
Select the Git credentials configured earlier.
Step 3: Add Build Step for Maven
Scroll to Build → Click Add build step → Execute Windows Batch Command.
Enter the Maven test command:
     mvn test
         Click Save.
Step 4: Trigger the Build
Click Build Now to fetch the code from GitHub and execute the Selenium tests.
Check the Console Output to verify test execution.



    7



    Experiment 7:

Configuration Management with Ansible: Basics of Ansible: Inventory, Playbooks, and Modules, Automating Server Configurations with Playbooks, Hands-On: Writing and Running a Basic Playbook

1. Introduction to Ansible

What Is Ansible?

Ansible is an open-source IT automation and configuration management tool. It allows you to manage multiple servers and perform tasks such as:

Configuration Management: Automate the configuration of servers.

Application Deployment: Deploy applications consistently.

Orchestration: Coordinate complex IT workflows and processes.

Key Concepts in Ansible

Inventory: An inventory is a file (usually in INI or YAML format) that lists the hosts (or groups

of hosts) you want to manage. It tells Ansible which machines to target.

Playbook: A playbook is a YAML file that defines a set of tasks to be executed on your target hosts. It is the heart of Ansible automation. In a playbook, you specify: Hosts: The target machines

(or groups) on which the tasks should run.

Tasks: A list of actions (using modules) that should be executed.

Modules: Reusable, standalone scripts that perform specific actions (e.g., installing packages, copying files, configuring services). Ansible comes with a large collection of built-in modules (such as apt, yum, copy, service, etc.). These modules perform specific tasks on target hosts. You can also write custom modules if needed.

Why Use Ansible?

Agentless: Ansible uses SSH to communicate with target hosts, so no agent needs to be installed on them.

Simplicity: Playbooks use simple YAML syntax, making them easy to write and understand. Idempotence: Ansible tasks are idempotent, meaning running the same playbook multiple times

yields the same result, ensuring consistency.

Scalability: Ansible can manage a small number of servers to large infrastructures with hundreds or thousands of nodes.

Installing Ansible on Ubuntu (Using Windows Subsystem for Ubuntu (WSL))

What's WSL?

WSL allows you to run a full Linux terminal inside Windows without a VM. It's lightweight and works perfectly for Ansible labs.

Step 1: Install WSL (Windows Subsystem for Ubuntu) Open PowerShell as Administrator, and run this:

wsl -install
This will:

Install Ubuntu as the default Linux distro.

Automatically enable WSL and reboot your system.

wsl

Step 2: Open Ubuntu (WSL)

After installation and reboot:

Search for "Ubuntu" in the Start menu and open it and type the below codes:

sudo apt update

sudo apt install ansible -y

Now it will asks for password enter the password.

That will install Ansible sible successfully. Now to verify installed ansible or not, type below code: ansible --version

Step 3: Create a Working Directory mkdir ~/ansible-lab

cd ~/ansible-lab

Step 4: Create an Inventory File

Create a file named hosts:

nano hosts

type the below code:

[local]

localhost ansible connection local

Press CTRL + O→ Enter to save

Press CTRL + X to exit

Then save:

Step 5: Test Ansible is Working Run a simple ping module: ansible -i hosts local -m ping You will see below code: localhost | SUCCESS => { "ansible facts": {

"discovered_interpreter_python": "/usr/bin/python3"

"changed": false,

"ping": "pong"

}

Step 6: Create a Sample Playbook Create a file named install_nginx.yml: nano install nginx.yml Paste this basic playbook:
name: Install and start NGINX on localhost

hosts: local

become: yes

tasks:

- name: Install NGINX

apt:

name: nginx

state: present

update_cache: yes

name: Ensure NGINX is running

service:

name: nginx

state: started

enabled: ves

Step 7: Run the Playbook

ansible-playbook -i hosts install_nginx.yml --ask-become-pass

Step 8: Verify the Result curl http://localhost



5



    Experiment 5 Introduction to Jenkins: What is Jenkins? Installing Jenkins on Local or Cloud Environment, Configuring Jenkins for First Use

1. What is Jenkins?

Jenkins is an open-source automation server used for:

Continuous Integration (CI) - Automatically testing and integrating code changes

✔ Continuous Deployment (CD) - Automating application deployment

✔ Building Pipelines - Managing end-to-end software development workflows

Plugin-Based Extensibility - Supporting tools like Maven, Gradle, Ansible, Docker, and Azure DevOps

Why Use Jenkins?

✓ Automates builds and tests

✓ Reduces manual intervention

✓ Improves software quality

✓ Works with multiple tools and platforms

2. Installing Jenkins

Jenkins can be installed using multiple methods:

Windows Installer (.msi) - Recommended for Windows

2 Linux Package Manager - Best for Linux Users

Jenkins WAR File - Universal method using Java (will be installing by this method)

2.1 Prerequisites

Java 21 or 25 is required for Jenkins(from march 31/03/2026 Java 17 will be stoped).

Check Java version:

java -version

2.2 Installing Jenkins on Windows

This method allows you to run Jenkins without installing it as a service.

✔ Step 1: Download the Jenkins WAR File

Download from: Download and deploy

Choose Generic Java Package (.war).

Step 2: Run Jenkins Using Java

Navigate to the folder where the war file is downloaded and run:

java -jar jenkins.war

✔ Step 3: Open Jenkins in Browser

Go to:

http://localhost:8080

Step 4: Unlock Jenkins & Setup Follow the steps as the Windows installation:

✓ Find the initial password

✓ Install plugins

✓ Create an admin user

Jenkins is now running without installation! To stop Jenkins, press CTRL + C in the terminal.

3. Configuring Jenkins for First Use Understanding the Jenkins Dashboard

After logging in, you will see:

New Item→ Create Jobs/Pipelines

Manage Jenkins→ Configure System, Users, and Plugins

Build History→ View previous builds

Credentials→ Store secure authentication details
    


    
