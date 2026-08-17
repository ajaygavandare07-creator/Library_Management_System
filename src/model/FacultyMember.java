package model;

public class FacultyMember extends Member {

    private static final long serialVersionUID = 1L;

    public FacultyMember(int memberId, String name) {
        super(memberId, name);
    }

    @Override
    public String getMemberType() {
        return "Faculty";
    }
}
