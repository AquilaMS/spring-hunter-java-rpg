package com.aquilamazzei.springhunter.resources;

import com.aquilamazzei.springhunter.dto.User.Auth.LoginResponseDTO;
import com.aquilamazzei.springhunter.dto.User.CreateAccountDTO;
import com.aquilamazzei.springhunter.dto.User.LoginDTO;
import com.aquilamazzei.springhunter.entities.Player;
import com.aquilamazzei.springhunter.repositories.PlayerRepository;
import com.aquilamazzei.springhunter.utils.security.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerResource {

    //TODO: Criar o throw

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    @PostMapping("/signup")
    public ResponseEntity<Player> createNewPlayer(@RequestBody CreateAccountDTO account) {
        if (playerRepository.findByUsernameOrEmail(account.username(), account.email()).isEmpty()) {
            String encryptedPassword = new BCryptPasswordEncoder().encode(account.password());
            Player newPlayer = new Player(account.username(), encryptedPassword, account.email());
            this.playerRepository.save(newPlayer);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();

    }

    @PostMapping("/signin")
    public ResponseEntity loginPlayer(@RequestBody LoginDTO account) {
        Authentication usernamePassword = new UsernamePasswordAuthenticationToken(account.username(), account.password());
        Authentication auth = this.authenticationManager.authenticate(usernamePassword);

        String token = jwtService.generateToken((Player) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}
