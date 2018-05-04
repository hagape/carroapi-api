package br.com.marli.carroapi.controller

import br.com.marli.carroapi.entity.User
import br.com.marli.carroapi.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    lateinit var userService : UserService

    @GetMapping
    fun getAllUsers() :List<User>?{
        return userService.findAllUsers()
    }

    @GetMapping("/email/{email}/senha/{senha}")
    fun login(@PathVariable(value = "email") email: String,
                @PathVariable(value = "senha") senha: String) : Boolean{
        val user: User? = userService.login(email, senha)

        if (user != null){
            if (user.senha.equals(senha)){
                return true
            }
            return false
        }

        return false
    }

    @PostMapping
    fun salvar(@RequestBody user: User){
        userService.salvar(user)
    }

}