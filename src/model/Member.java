package model;

import java.io.Serializable;

public abstract class Member implements Serializable {

    private static final long serialVersionUID = 1L;

    protected int memberId;
    protected String name;

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public abstract String getMemberType();

    @Override
    public String toString() {
        return "Member ID: " + memberId +
                " | Name: " + name +
                " | Type: " + getMemberType();
    }
}
