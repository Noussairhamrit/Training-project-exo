package org.exoplatform.entity;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.exoplatform.commons.api.persistence.ExoEntity;

@Entity
@ExoEntity
@Table(name = "ARTICLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    @Id
    @Column(name = "ID_ARTICLE")
    private Long idArticle;

    @Column(name = "CODE_ARTICLE")
    private String codeArticle;

    @Column(name = "DESIGNATION_ARTICLE")
    private String designation;

    @Column(name = "PRIX_HT_ARTICLE")
    private Long prixUnitaireHT;

    @Column(name = "PRIX_TVA_ARTICLE")
    private Long prixTVA;

    @Column(name = "PRIX_TTC_ARTICLE")
    private Long prixUnitaireTTC;
}