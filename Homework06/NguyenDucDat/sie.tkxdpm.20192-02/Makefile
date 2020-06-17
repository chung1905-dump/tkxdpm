LIB_DIR = `pwd`/lib/*

all: compile initialize run

run:
	java -cp ./bin/:$(LIB_DIR) main.Application

compile:
	javac -d ./bin -cp ./bin/:$(LIB_DIR) -sourcepath ./src/ ./src/main/Application.java ./src/setup/Initializer.java

initialize:
	java -cp ./bin/:$(LIB_DIR) setup.Initializer

clean:
	rm -rf ./bin/*
