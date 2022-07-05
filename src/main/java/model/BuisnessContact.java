package model;

public class BuisnessContact extends Contact{
    private String companyName;
    @Override
    public String getName() {
        return companyName;
    }

    public BuisnessContact(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "BuisnessContact{" +
                "companyName='" + companyName + '\'' +
                '}';
    }
}
