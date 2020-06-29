package JSON;

public class JsonSP
{
    private String username;
    private String password;
    private String type;
    private String email,firstName,lastName,phone;
    private String infoPath;
    private String certificatePath;
    private String domain;
    private String approved = "pending";

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getInfoPath()
    {
        return infoPath;
    }

    public void setInfoPath(String infoPath)
    {
        this.infoPath = infoPath;
    }

    public String getDomain()
    {
        return domain;
    }

    public void setDomain(String domain)
    {
        this.domain = domain;
    }

    public String getApproved()
    {
        return approved;
    }

    public void setApproved(String approved)
    {
        this.approved = approved;
    }

    public String getCertificatePath()
    {
        return certificatePath;
    }

    public void setCertificatePath(String certificatePath)
    {
        this.certificatePath = certificatePath;
    }
}
