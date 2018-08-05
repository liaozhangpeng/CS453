# Tester for project 3. 

# Compile class
javac Generator.java 
# Run generator to generate a class called token matcher. Takes the first argument to the bash script, which should be a file a name, and redirects the file into the program.
java Generator TokenMatcher < $1 > TokenMatcher.java

# Compile the driver
javac Main.java
# Match a token 
java Main $2 $3 
