# Amazon

# Build jar file
mvn clean install -DskipTest=true

# Run jar file
java -Dbrowser=CHROME -jar target/Amazon-1.0-SNAPSHOT-fat-tests.jar
 