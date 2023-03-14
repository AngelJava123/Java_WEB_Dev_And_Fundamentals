package automobile.cars.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "terms")
public class Term {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "TEXT")
    private String welcome;

    @Column(columnDefinition = "TEXT")
    private String useOfService;

    @Column(columnDefinition = "TEXT")
    private String intellectualProperty;

    @Column(columnDefinition = "TEXT")
    private String thirdParty;

    @Column(columnDefinition = "TEXT")
    private String warranties;

    @Column(columnDefinition = "TEXT")
    private String liability;

    @Column(columnDefinition = "TEXT")
    private String indemnification;

    @Column(columnDefinition = "TEXT")
    private String modification;

    @Column(columnDefinition = "TEXT")
    private String law;

    @Column(columnDefinition = "TEXT")
    private String resolution;

    @Column(columnDefinition = "TEXT")
    private String agreement;

    public Term() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWelcome() {
        return welcome;
    }

    public void setWelcome(String welcome) {
        this.welcome = welcome;
    }

    public String getUseOfService() {
        return useOfService;
    }

    public void setUseOfService(String useOfService) {
        this.useOfService = useOfService;
    }

    public String getIntellectualProperty() {
        return intellectualProperty;
    }

    public void setIntellectualProperty(String intellectualProperty) {
        this.intellectualProperty = intellectualProperty;
    }

    public String getThirdParty() {
        return thirdParty;
    }

    public void setThirdParty(String thirdParty) {
        this.thirdParty = thirdParty;
    }

    public String getWarranties() {
        return warranties;
    }

    public void setWarranties(String warranties) {
        this.warranties = warranties;
    }

    public String getLiability() {
        return liability;
    }

    public void setLiability(String liability) {
        this.liability = liability;
    }

    public String getIndemnification() {
        return indemnification;
    }

    public void setIndemnification(String indemnification) {
        this.indemnification = indemnification;
    }

    public String getModification() {
        return modification;
    }

    public void setModification(String modification) {
        this.modification = modification;
    }

    public String getLaw() {
        return law;
    }

    public void setLaw(String law) {
        this.law = law;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }
}
