package com.cleanarchkotlin.presentation.controllers

import com.cleanarchkotlin.data.contracts.CreateUser
import com.cleanarchkotlin.data.contracts.ListUser
import com.cleanarchkotlin.data.dto.UserDTO
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/users")
class UserController @Inject constructor(
    private val persistPart: CreateUser,
    private val listPart: ListUser
) {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    fun save(userDTO: UserDTO) = persistPart.create(userDTO.email, userDTO.password, userDTO.name)

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun list() = listPart.list()
}