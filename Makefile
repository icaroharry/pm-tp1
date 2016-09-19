all:
	javac */*.java
	javac *.java

clean:
	rm -rf */*.class
	rm -rf *.class

run:
	java src/tp1/tp1.java
