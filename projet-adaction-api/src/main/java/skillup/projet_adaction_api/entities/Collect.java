package skillup.projet_adaction_api.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "collects")
public class Collect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false )
    private LocalDate date;

    @ManyToOne
    @JsonBackReference("city-collect")
    @JoinColumn( name = "city_id", nullable = false )
    private City city;

    @Column( nullable = true )
    private Integer glass_nb;

    @Column( nullable = true )
    private Integer butt_nb;

    @Column( nullable = true )
    private Integer plastic_nb;

    @Column( nullable = true )
    private Integer electronics_nb;

    @Column( nullable = true )
    private Integer others_nb;

    @ManyToOne
    @JsonBackReference("volunteer-collect")
    @JoinColumn( name = "volunteer_id", nullable = false )
    private Volunteer volunteer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getGlass_nb() {
        return glass_nb;
    }

    public void setGlass_nb(int glass_nb) {
        this.glass_nb = glass_nb;
    }

    public int getButt_nb() {
        return butt_nb;
    }

    public void setButt_nb(int butt_nb) {
        this.butt_nb = butt_nb;
    }

    public int getPlastic_nb() {
        return plastic_nb;
    }

    public void setPlastic_nb(int plastic_nb) {
        this.plastic_nb = plastic_nb;
    }

    public int getElectronics_nb() {
        return electronics_nb;
    }

    public void setElectronics_nb(int electronics_nb) {
        this.electronics_nb = electronics_nb;
    }

    public int getOthers_nb() {
        return others_nb;
    }

    public void setOthers_nb(int others_nb) {
        this.others_nb = others_nb;
    }

    public Volunteer getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(Volunteer volunteer) {
        this.volunteer = volunteer;
    }
}