package kotlin_learning.oop

interface Repository {
    fun getById(id: Int): Customer
    fun getAll(): List<Customer>
}

interface Logger {
    fun info()
}

// implements an interface by delegating the generating trivial methods to the compiler
class Controller(val repository: Repository, val logger: Logger): Repository by repository, Logger by logger

fun use(controller: Controller) {
    controller.getById(123) // controller has access to the repository methods
}