package evgenyt.springdemo;

/**
 * Entity to translate data to table person
 */

import javax.persistence.*;

@Entity
@Table(name = "person")
public class PersonEntity
{
    @Column(name = "person_name")
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id", unique = true, nullable = false)
    private Integer id;

    public void setName(String name) {
        this.name = name;
    }
}
