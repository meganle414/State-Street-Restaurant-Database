run: compile

compile:
        javac BackEnd.java
        javac Connector.java
        javac DataWrangler.java
        javac HashTable.java
        javac List.java
        javac Restaurant.java
        javac RestaurantList.java
        javac Table.java

clean:
        $(RM) *.class

