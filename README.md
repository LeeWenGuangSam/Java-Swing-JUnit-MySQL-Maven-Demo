# JavaSwingMySQLDemo
Created with Java Swing, Hibernate, MySQL and Maven.

The main file in the program, [MainApp.java](https://github.com/LeeWenGuangSam/JavaSwingMySQLDemo/blob/DatabaseBranch/src/pc/predi/MainApp.java), is the main of the program and meant to start the Swing program.

Currently only works with the Weapon Selection only and able to use the confirm button and send the information to the MySQL database.

The [pom.xml](https://github.com/LeeWenGuangSam/JavaSwingMySQLDemo/blob/DatabaseBranch/pom.xml) defines the of dependencies of the program.

This file in the package pc.predi.Div2InventoryCardLayoutDatabase.Tests shows how to validate a insert statement with JUnit and [Regex](https://en.wikipedia.org/wiki/Regular_expression).  
This example validates a set of insert statements into a database.

[JUnit Test Demo](https://github.com/LeeWenGuangSam/JavaSwingMySQLDemo/blob/DatabaseBranch/src/pc/predi/Div2InventoryCardLayoutDatabase/Tests/CreateScriptsTest.java)

The [persistence.xml](https://github.com/LeeWenGuangSam/JavaSwingMySQLDemo/blob/DatabaseBranch/src/main/resources/META-INF/persistence.xml) and this  [package](https://github.com/LeeWenGuangSam/JavaSwingMySQLDemo/blob/DatabaseBranch/src/pc/predi/Div2InventoryCardLayoutDatabase/Tables/CreateTables.java) details the creation of the MySQL database and tables.
