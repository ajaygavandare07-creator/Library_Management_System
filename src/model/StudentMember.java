package model;

public class StudentMember extends Member {

    private static final long serialVersionUID = 1L;

    public StudentMember(int memberId, String name) {
        super(memberId, name);
    }

    @Override
    public String getMemberType() {
        return "Student";
    }
}
