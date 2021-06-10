package objects;

public class Account {
    private String accountName;
    private String type;
    private String website;
    private String phone;
    private String industry;
    private String employees;

    public Account(String accountName, String type, String website, String phone, String industry, String employees) {
        this.accountName = accountName;
        this.type = type;
        this.website = website;
        this.phone = phone;
        this.industry = industry;
        this.employees = employees;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getEmployees() {
        return employees;
    }

    public void setEmployees(String employees) {
        this.employees = employees;
    }
}
