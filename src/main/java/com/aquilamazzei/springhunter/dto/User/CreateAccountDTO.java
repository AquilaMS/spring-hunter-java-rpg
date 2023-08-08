package com.aquilamazzei.springhunter.dto.User;

import com.aquilamazzei.springhunter.entities.Player;

public record CreateAccountDTO(String username, String password, String email) {
}
