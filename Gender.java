/**
 * @author Wei_Zheng
 */
public class Gender {
    private final int VALUE;

    public Gender(int gender) {
        this.VALUE = gender;
    }

    public int getVALUE() {
        return VALUE;
    }

    public boolean equals(Gender otherGender) {
        return this.VALUE == otherGender.getVALUE();
    }

    @Override
    public String toString() {
        return this.VALUE == 0 ? null : (this.VALUE == 1 ? "男" : "女");
    }

    public boolean isMan() {
        return this.VALUE == 1;
    }
}
