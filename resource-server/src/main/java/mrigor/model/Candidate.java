package mrigor.model;

/**
 * Created by Игорь on 18.07.2017.
 */
public class Candidate {
    private int id;
    private String email;
    private String fullName;

    public Candidate(String email, String fullName) {
        this.email = email;
        this.fullName = fullName;
    }

    public Candidate() {
    }

    public Candidate(int id, String email, String fullName) {

        this.id = id;
        this.email = email;
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Candidate{");
        sb.append("id=").append(id);
        sb.append(", email='").append(email).append('\'');
        sb.append(", fullName='").append(fullName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
