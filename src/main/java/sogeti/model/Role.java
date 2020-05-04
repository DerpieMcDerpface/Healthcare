package sogeti.model;

import javax.persistence.*;

    @Entity
    @Table(name = "ROLE")
    public class Role {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(name = "name")
        private String name;

        public Role() {
        }

        public Role(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


