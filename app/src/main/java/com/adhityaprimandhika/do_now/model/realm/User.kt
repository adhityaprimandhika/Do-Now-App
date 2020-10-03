package com.adhityaprimandhika.do_now.model.realm

import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass
open class User : RealmObject() {
    private var id : Int = 0
    private var username : String = ""
    private var email : String = ""
    private var password : String = ""

    fun setId(id : Int) {
        this.id = id
    }

    fun getId() : Int {
        return id
    }

    fun setUsername(username : String) {
        this.username = username
    }

    fun getUsername() : String {
        return username
    }

    fun setEmail(email : String) {
        this.email = email
    }

    fun getEmail() : String {
        return email
    }

    fun setPassword(password : String) {
        this.password = password
    }

    fun getPassword() : String {
        return password
    }
}