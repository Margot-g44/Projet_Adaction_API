package skillup.projet_adaction_api.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "volunteers")
public class Volunteer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false )
    private String firstname;

    @Column(nullable = false )
    private String lastname;

    @Column(nullable = false )
    private String email;

    @Column(nullable = false )
    private String password;

    @Column(nullable = false )
    private String Location;

    @Column(nullable = false )
    private Date created_at;

    @Column(nullable = true )
    private Date updated_at;

    @Column(nullable = false )
    private int total_points;

    @Column(nullable = false )
    private int donation_points;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public int getTotal_points() {
        return total_points;
    }

    public void setTotal_points(int total_points) {
        this.total_points = total_points;
    }

    public int getDonation_points() {
        return donation_points;
    }

    public void setDonation_points(int donation_points) {
        this.donation_points = donation_points;
    }
}
