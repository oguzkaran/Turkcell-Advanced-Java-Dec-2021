package com.turkcell.app.entity;

import java.util.Optional;

public class Person {
    private String m_firstName;
    private Optional<String> m_middleName;
    private String m_familyName;
    //...

    public Person(String firstName, String familyName)
    {
        m_firstName = firstName;
        m_middleName = Optional.empty();
        m_familyName = familyName;
    }

    public Person(String firstName, String middleName, String familyName)
    {
        m_firstName = firstName;
        m_middleName = Optional.of(middleName);
        m_familyName = familyName;
    }

    public String getFirstName()
    {
        return m_firstName;
    }

    public void setFirstName(String firstName)
    {
        m_firstName = firstName;
    }

    public Optional<String> getMiddleName()
    {
        return m_middleName;
    }

    public void setMiddleName(String middleName)
    {
        m_middleName = Optional.of(middleName);
    }

    public String getFamilyName()
    {
        return m_familyName;
    }

    public void setFamilyName(String familyName)
    {
        m_familyName = familyName;
    }

    @Override
    public String toString()
    {
        return String.format("%s %s%s", m_firstName, m_middleName.isPresent() ? m_middleName.get() + " " : "", m_familyName);
    }

    //...
}
