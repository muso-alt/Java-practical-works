package Interfaces.Extended;

import java.util.Objects;

public class ExtendedClass {

    private String name;
    private int age;
    private String passport;

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof ExtendedClass)) {
            return false;
        }
        ExtendedClass user = (ExtendedClass) o;
        return age == user.age &&
                Objects.equals(name, user.name) &&
                Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, passport);
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
