package com.academy.kocats.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.*;

@Entity
@Getter
@Setter
@DynamicInsert
@DynamicUpdate
@Table(name = "user")
public class User {


    public User() {
        ShoppingCart shoppingCart = new ShoppingCart();
        this.setShoppingCart(shoppingCart);
        shoppingCart.setUser(this);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName ;

    private String email;

    private String username;

    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "birth_date")
    private Date birthDate;

   // @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

    //@JsonManagedReference
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Purchase> purchases = new ArrayList<>();


    @OneToOne(mappedBy = "user",
            optional = false,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private ShoppingCart shoppingCart;


    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();


    public void removeRoleById(Integer roleId)
    {
        if (roleId != null)
        {
            for (Role role : roles)
            {
                if (role.getRoleId().equals(roleId))
                {
                    roles.remove(role);
                    break;
                }
            }
        }
    }

}
