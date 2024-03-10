package lk.ijse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity
public class User {
    @Id
    private String id;
    private String username;
    private String mobile;
    private String password;
    private String repeatpassword;

}
