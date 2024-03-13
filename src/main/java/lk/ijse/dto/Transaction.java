package lk.ijse.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class Transaction {
    private String id;
    private String username;
    private String email;
    private String password;
    private String repeatpassword;
}
