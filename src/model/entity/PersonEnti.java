package model.entity;


public class PersonEnti {
    private String name,address,email;
    private int id, phone;


    public PersonEnti()
    {
        name = "";
        address = "";
        email = "";

        id = 0;
        phone = 0;
    }

    public PersonEnti(int id, String name, String address, int phone, String email)
    {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }


    public PersonEnti(String name, String address, int phone, String email)
    {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }


    public void setId(int i)
    {
        id = i;
    }

    public PersonEnti setName(String n)
    {
        this.name=n;
        return this;
    }
    public PersonEnti setAddress(String a)
    {
        this.address=a;
        return this;
    }
    public PersonEnti setPhone(int ph)
    {
        this.phone=ph;
        return this;
    }
    public PersonEnti setEmail(String e)
    {
        this.email=e;
        return this;
    }


    public int getId( )
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getAddress()
    {
        return address;
    }

    public int getPhone()
    {
        return phone;
    }

    public String getEmail()
    {
        return email;
    }





}
