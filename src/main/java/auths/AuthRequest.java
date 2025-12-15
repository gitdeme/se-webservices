package auths;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
class AuthRequest {
    private String username;
    private String password;
}

@Data
@AllArgsConstructor
class AuthResponse {
    private String token;
}
