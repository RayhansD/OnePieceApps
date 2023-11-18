package com.example.onepiecelogin2

import com.example.onepiecelogin2.data.local.LocalRepository
import com.example.onepiecelogin2.data.local.entity.UserEntity
import com.example.onepiecelogin2.data.remote.RemoteRepository

class Repository(private val localRepository: LocalRepository, private val remoteRepository: RemoteRepository) {
    suspend fun insertUser(userEntity: UserEntity){
        localRepository.insertUser(userEntity)
    }

    suspend fun getUser(email: String, password: String): UserEntity {
        return localRepository.getUser(email, password)
    }
}