package br.com.rocketdevelopment.urlredirect.infrastructure.persistence;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "shortner")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShortnerEntity {

    @Id
    private String shorten;

    private String url;


}
