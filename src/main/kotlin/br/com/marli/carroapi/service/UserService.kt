package br.com.marli.carroapi.service

import br.com.marli.carroapi.entity.User
import br.com.marli.carroapi.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    fun findAllUsers(): List<User>?{
        return userRepository.findAll()
    }

    fun login(email: String, senha: String) : User? {
        return userRepository.findByEmail(email)
    }

    fun salvar(user: User){
        userRepository.insert(user)
    }
}