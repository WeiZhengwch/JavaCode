import java.util.UUID;

/**
 * @author Wei_Zheng
 */
public class People {
    private final String NAME;
    private final Gender GENDER;
    private final UUID UUID;
    private int age;

    public People(String name, Gender gender) {
        this.NAME = name;
        this.GENDER = gender;
        this.UUID = createUUID();
    }

    public People(String name, Gender gender, int age) {
        this.NAME = name;
        this.GENDER = gender;
        this.age = age;
        this.UUID = createUUID();
    }

    private UUID createUUID() {
        return java.util.UUID.randomUUID();
    }

    public java.util.UUID getUUID() {
        return this.UUID;
    }

    public String getNAME() {
        return this.NAME;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGENDER() {
        return GENDER;
    }

    public boolean equalsFromName(People otherPeople) {
        return this.NAME.equals(otherPeople.getNAME());
    }

    public boolean equalsFromAge(People otherPeople) {
        return this.age == otherPeople.getAge();
    }

    public boolean equalsFromUUID(People otherPeople) {
        return this.UUID.equals(otherPeople.UUID);
    }
}
