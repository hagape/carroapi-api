package br.com.marli.carroapi.repository

import br.com.marli.carroapi.entity.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: MongoRepository<User, String> {
    fun findByEmail(email: String): User?
}