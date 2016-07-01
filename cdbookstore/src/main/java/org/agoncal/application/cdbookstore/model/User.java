package org.agoncal.application.cdbookstore.model;

import org.agoncal.application.cdbookstore.util.PasswordUtils;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */

@Entity
@Table(name = "t_user")
@NamedQueries({
        @NamedQuery(name = User.FIND_BY_EMAIL, query = "SELECT u FROM User u WHERE u.email = :email"),
        @NamedQuery(name = User.FIND_BY_UUID, query = "SELECT u FROM User u WHERE u.uuid = :uuid"),
        @NamedQuery(name = User.FIND_BY_LOGIN, query = "SELECT u FROM User u WHERE u.login = :login"),
        @NamedQuery(name = User.FIND_BY_LOGIN_PASSWORD, query = "SELECT u FROM User u WHERE u.login = :login AND u.password = :password"),
        @NamedQuery(name = User.FIND_ALL, query = "SELECT u FROM User u")
})
public class User implements Serializable {

    // ======================================
    // =             Constants              =
    // ======================================

    public static final String FIND_BY_EMAIL = "User.findByEmail";
    public static final String FIND_BY_LOGIN = "User.findByLogin";
    public static final String FIND_BY_UUID = "User.findByUUID";
    public static final String FIND_BY_LOGIN_PASSWORD = "User.findByLoginAndPassword";
    public static final String FIND_ALL = "User.findAll";

    // ======================================
    // =             Attributes             =
    // ======================================

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Version
    @Column(name = "version")
    private int version;

    @Column(length = 10, nullable = false)
    @NotNull
    @Size(min = 1, max = 10)
    private String login;

    @Column(length = 50, name = "first_name", nullable = false)
    @NotNull
    @Size(min = 2, max = 50)
    private String firstName;

    @Column(length = 50, name = "last_name", nullable = false)
    @NotNull
    @Size(min = 2, max = 50)
    private String lastName;

    @Column
    private String telephone;

    @Column
    @NotNull
    private String email;

    @Column(length = 256, nullable = false)
    @NotNull
    @Size(min = 1, max = 256)
    private String password;

    @Column(length = 256)
    @Size(min = 1, max = 256)
    private String uuid;

    @Enumerated
    @Column(name = "user_role")
    private UserRole role;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    @Past
    private Date dateOfBirth;

    @PrePersist
    @PreUpdate
    private void digestPassword() {
        password = PasswordUtils.digestPassword(password);
    }

    // ======================================
    // =        Getters and Setters         =
    // ======================================

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(final int version) {
        this.version = version;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // ======================================
    // =   Methods hash, equals, toString   =
    // ======================================

    @Override
    public String toString() {
        String result = getClass().getSimpleName() + " ";
        if (id != null)
            result += "id: " + id;
        result += ", version: " + version;
        if (firstName != null && !firstName.trim().isEmpty())
            result += ", firstName: " + firstName;
        if (lastName != null && !lastName.trim().isEmpty())
            result += ", lastName: " + lastName;
        if (telephone != null && !telephone.trim().isEmpty())
            result += ", telephone: " + telephone;
        if (email != null && !email.trim().isEmpty())
            result += ", email: " + email;
        if (login != null && !login.trim().isEmpty())
            result += ", login: " + login;
        if (password != null && !password.trim().isEmpty())
            result += ", password: " + password;
        if (uuid != null && !uuid.trim().isEmpty())
            result += ", uuid: " + uuid;
        if (role != null)
            result += ", role: " + role;
        if (dateOfBirth != null)
            result += ", dateOfBirth: " + dateOfBirth;
        return result;
    }
}