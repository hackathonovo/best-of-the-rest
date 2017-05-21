mvn flyway:clean   -Dflyway.configFile=etc/flyway/properties/in2-dev.properties
mvn flyway:clean   -Dflyway.configFile=etc/flyway/properties/in2-test.properties
mvn flyway:migrate -Dflyway.configFile=etc/flyway/properties/in2-dev.properties
mvn flyway:migrate -Dflyway.configFile=etc/flyway/properties/in2-test.properties