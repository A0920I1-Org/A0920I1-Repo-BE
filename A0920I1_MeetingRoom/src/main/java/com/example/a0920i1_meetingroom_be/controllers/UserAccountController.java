package com.example.a0920i1_meetingroom_be.controllers;

import com.example.a0920i1_meetingroom_be.models.dto.accountDto.AccountCreateDTO;
import com.example.a0920i1_meetingroom_be.models.dto.accountDto.AccountListDTO;
import com.example.a0920i1_meetingroom_be.models.dto.accountDto.AccountUpdateDTO;
import com.example.a0920i1_meetingroom_be.models.entity.Account;
import com.example.a0920i1_meetingroom_be.models.entity.Role;
import com.example.a0920i1_meetingroom_be.services.AccountService;
import com.example.a0920i1_meetingroom_be.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserAccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/account/list")
    public ResponseEntity<Page<AccountListDTO>> getAllAccountList(@PageableDefault(value=5) Pageable pageable){
        Page<AccountListDTO> accountList = this.accountService.getPageAllAccount(pageable);
        if (accountList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(accountList, HttpStatus.OK);
    }

    @PostMapping(value="/account/create-account",consumes = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public ResponseEntity<?> createStaff(@RequestBody AccountCreateDTO accountCreateDTO){

        accountService.createAccountDto( accountCreateDTO.getDivision(),
            accountCreateDTO.getEmail(),
                accountCreateDTO.getFullName(),
                accountCreateDTO.getUsername(),
                accountCreateDTO.getPhone(),
                accountCreateDTO.getImageUrl(),
                1L,
                passwordEncoder.encode(accountCreateDTO.getPassword())
        );
        Account account = accountService.findByUsername(accountCreateDTO.getUsername());
        accountService.createAccountRole(account.getId(),accountCreateDTO.getRoleId());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/api/public/account/{id}")
    public ResponseEntity<?> deleteByEmployeeId(@PathVariable Long id) {
        if(id == null){
            return ResponseEntity.badRequest().body("Không có tài khoản này !");
        }
        accountService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/api/public/account/{id}")
    public ResponseEntity<?> getByEmployeeId(@PathVariable Long id) {
        if(id == null){
            return ResponseEntity.badRequest().body("Không có tài khoản này !");
        }
        return new ResponseEntity<>(accountService.findAccountUpdateById(id),HttpStatus.OK);
    }

    @GetMapping("/api/public/role")
    public ResponseEntity<List<Role>> findRole() {
        return ResponseEntity.ok(accountService.findAll());
    }

    @PutMapping("/api/public/account")
    public ResponseEntity<?> update(@RequestBody AccountUpdateDTO accountUpdateDTO) {
        accountService.update(accountUpdateDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
