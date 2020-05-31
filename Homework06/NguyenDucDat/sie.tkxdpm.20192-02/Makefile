LIB_DIR = `pwd`/lib
MYSQL_CONN_JAR = $(LIB_DIR)/mysql-connector-java-8.0.20.jar

all: compile initialize run

run:
	java -cp ./bin/:$(MYSQL_CONN_JAR) main.Application

compile:
	javac -d ./bin -sourcepath ./src/ ./src/main/Application.java ./src/setup/Initializer.java

initialize:
	java -cp ./bin/:$(MYSQL_CONN_JAR) setup.Initializer

clean:
	rm -rf ./bin/*
