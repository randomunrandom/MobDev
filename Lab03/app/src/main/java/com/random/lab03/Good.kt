package com.random.lab03

class Good() {
    var name: String? = null
    var desc: String? = null
    var price: String? = null

    constructor(name: String, desc: String, price: String) : this() {
        this.name = name
        this.desc = desc
        this.price = price
    }
}