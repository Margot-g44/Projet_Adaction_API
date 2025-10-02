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

}
