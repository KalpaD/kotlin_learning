package kotlin_learning._10_oop

// data modifier generates the following methods
// equals()
// hashCode()
// copy()
// toString()

data class Contact(val name: String, val address: String)

fun copyData() {
    val contact = Contact("John", "001 Some Street")
    println(contact)

    val copyContactWithModification = contact.copy(address = "002 another street")
    println("copy with modification: $copyContactWithModification")
    println("while the original remains same $contact")
}


fun avoidPropertiesFromGeneratedContent() {
    data class User(val email: String) {
        var nickName: String = email.substring(2)
    }

    val user1 = User("user1@mail.com")
    user1.nickName = "someName1"

    val user2 = User("user1@mail.com")
    user2.nickName = "someName2"

    println(user1.toString())
    println(user1 == user2) // this prints true as nickName is avided from the generated methods
}

fun main() {
    copyData()
    avoidPropertiesFromGeneratedContent()
}

