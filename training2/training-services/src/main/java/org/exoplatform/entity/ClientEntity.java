package org.exoplatform.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.exoplatform.commons.api.persistence.ExoEntity;
@Entity
@ExoEntity
@Table( name="CLIENT" )
@Data
@AllArgsConstructor
@NoArgsConstructor

@NamedQueries({
        @NamedQuery(name = "ClientEntity.getClientByAddresse",query = "select client FROM ClientEntity client WHERE client.addresse= :addresse"),
        @NamedQuery(name = "ClientEntity.getNumber",query = "SELECT count (*) FROM ClientEntity client WHERE client.name= :name")
})

public class ClientEntity {
    @Id
    @GeneratedValue
    @Column( name="ID_CLIENT")
    public Long id;
    @Column(name = "FIRST_NAME_CLIENT")
    public String prenom;
    @Column(name = "NAME_CLIENT")
    public String name;
    @Column(name = "ADDRESS_CLIENT")
    public String addresse;
    @Column(name = "EMAIL_CLIENT")
    public String email;

}
