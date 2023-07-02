package com.example.fitwayapp

import java.util.jar.Attributes.Name

class Exercise {
   var name: String = ""
    var description: String = ""

    constructor(name: String,
                description: String
    ) {
        this.name = name
        this.description = description
    }
    constructor()
}