package sky.group.homeworkgroup.model_dinamicbase;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class ModelRequest {
    @Id
    @GeneratedValue
    private Long id;
    private String query;
    private String argumentFirst;
    private String argumentSecond;
    private String operation;
    private int number;
    private Boolean negate;
    @OneToMany(mappedBy = "dinamic_id")
    private List<DinamicBase> dinamicBases;

   }
