package org.gestiondestitresimportationbcp.dto;
import java.util.Date;
import java.util.List;

public record TitreImportationDetailsDTO (
        //message
        Long numeroMessage,
        String emetteur,
        int destinataire ,
        Date dateMessage ,
        String typeMessage,
        String fonction,
        //Operateur
        long idFicalUnique,
        String nom,
        int centre,
        String typeIdentification,
        long numIdentification,
        long identifiantDouane,
        String ribBancaire,
        ///Banque
        Long codeBanque,
        long guichet,
        long localite,
        //title
        Long numEnregistrement,

        int Categorie,
        int typeDedmande,
        String importateur,
        String expediteur,
        int regimeDouanier,
        int bureauDouanier,
        double  montantTotale,
        double montantFOB,
        double motantFret,
        String montantAssuranceAcessoires,
        String devise,
        int  ConditionsLivraison,
        String incotermString,
        //Marchandise
        long nomenclature,
        String paysOrigine,
        String designation,
        double quantite ,
        int uniteComplementaire,
        double poidsUnit,
        ////paysprovenance
        String paysProvenance ,
         List<String> pdfFilePaths













){

}
