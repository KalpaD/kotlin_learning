package kotlin_learning._14_properties

interface User {
    val name: String
}

class GitHubUser(val accountId: Int) : User {
    override val name = getGitHubUserName(accountId)

    private fun getGitHubUserName(accountId: Int): String {
        return "userName"
    }
}

class GmailUser(private val email: String) : User {
    override val name: String
        get() = email.substringBefore("@")
}

fun interfacePropertyDemo() {
    val gitHubUser = GitHubUser(1234);
    val gmailUser = GmailUser("userName@gmail.com")

    println(gitHubUser.name)
    println(gmailUser.name)
}


interface Session {
    val user: User
}

fun analyzeUserSession(session: Session) {
    if (session.user is GitHubUser) {
        // Smart cast to 'GitHubUser' is impossible, because 'session.user' is a property that has open or custom getter
        // because the custom getter can return a new value on each access
        //println(session.user.accountId)
    }
}

fun analyzeUserSessionImproved(session: Session) {
    val user = session.user
    if (user is GitHubUser) {
        println(user.accountId)
    }
}


fun main() {
    interfacePropertyDemo()
}