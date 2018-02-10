package dataBase;

import java.util.UUID;

public class uniqueID {

    public UUID creatID() {
        UUID uniqueKey = UUID.randomUUID();
        return uniqueKey;
    }
    public uniqueID() {}
}