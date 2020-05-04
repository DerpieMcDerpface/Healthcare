package sogeti.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
    @Table(name = "ROLE")
    public class Role {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idRole;

        @Column(name = "name")
        private String name;

        @ManyToMany
        @JoinTable (name = "User_Role_Association",
                    joinColumns = @JoinColumn(name = "idRole"),
                    inverseJoinColumns = @JoinColumn(name = "idUser"))
        private List<User> users = new ArrayList<>();


        public Role() {
        }

        public Role(String name) {
            this.name = name;
        }

        public int getIdRole() {
            return idRole;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<User> getUsers() {
             return users;
         }
    }


