package setup;

import setup.database.Schema;

public class Initializer {
    public static void main(String[] args) {
        Schema dbSetup = new Schema();
        dbSetup.run();
    }
}
