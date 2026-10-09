package domain;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class LibraryName implements Serializable {

    private String name;

    public LibraryName(String name){
        this.name = name;
    }

    protected LibraryName() {}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        LibraryName other = (LibraryName) obj;
        return this.name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
